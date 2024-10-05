package com.dailyCode.Dream_shop.Image.controller;

import com.dailyCode.Dream_shop.Image.Dto.ImageResponseDto;
import com.dailyCode.Dream_shop.Image.model.Image;
import com.dailyCode.Dream_shop.Image.service.ImageService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.SQLException;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/images")
public class ImageController {

    private final ImageService imageService;
    @PostMapping("/upload")
    public ImageResponseDto upload(@RequestParam MultipartFile file,@RequestParam Long ProductId){
        return this.imageService.addImage(ProductId, file);
    }

    @GetMapping("/image/download/{imageId}")
    public ResponseEntity<ByteArrayResource> download(@PathVariable Long imageId)throws SQLException{
        Image image= this.imageService.getImageById(imageId);
        ByteArrayResource resource = new ByteArrayResource(image.getImage().getBytes(1, (int) image.getImage().length()));
        return  ResponseEntity.ok().contentType(MediaType.parseMediaType(image.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" +image.getFileName() + "\"")
                .body(resource);
    }
    @Transactional
   @PutMapping("/image/update/{imageId}")
    public void update(@RequestParam MultipartFile file, @PathVariable Long imageId) {
        this.imageService.updateImage(file, imageId);
    }

    @DeleteMapping("/image/delete/{imageId}")
    public void delete(@PathVariable Long imageId)  {
        this.imageService.deleteImageById(imageId);
    }

}
