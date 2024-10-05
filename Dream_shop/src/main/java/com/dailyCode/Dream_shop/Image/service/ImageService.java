package com.dailyCode.Dream_shop.Image.service;

import com.dailyCode.Dream_shop.Image.Dto.ImageResponseDto;
import com.dailyCode.Dream_shop.Image.mapper.ImageMapper;
import com.dailyCode.Dream_shop.Image.model.Image;
import com.dailyCode.Dream_shop.Image.repository.ImageRepo;
import com.dailyCode.Dream_shop.Product.model.Product;
import com.dailyCode.Dream_shop.Product.repository.ProductRepo;
import com.dailyCode.Dream_shop.exceptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ImageService {
    private final ImageMapper imageMapper;
    private final ImageRepo imageRepo;
    private final ProductRepo productRepo;

    public List<ImageResponseDto> getAllImages() {
        return imageRepo.findAll().stream().map(imageMapper::toImageResponseDto).toList();
    }

    public List<ImageResponseDto> getImageByProductId(Long id) {
        return imageRepo.findByProductId(id).stream().map(imageMapper::toImageResponseDto).toList();
    }
    public Image getImageById(Long id){
        return imageRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Image not found"));
    }

    public ImageResponseDto addImage(Long productId, MultipartFile file) {
        Product product = productRepo.findById(productId).orElseThrow(() -> new EntityNotFoundException("Product not found"));

        try {
            Image image = new Image();
            image.setFileName(file.getOriginalFilename());
            image.setFileType(file.getContentType());
            image.setImage(new SerialBlob(file.getBytes()));
            image.setProduct(product);

            String buildDownloadUrl = "api/vi/images/image/download";
            String downloadUrl= buildDownloadUrl + "/" + image.getId();
            image.setDownloadUrl(downloadUrl);

            imageRepo.save(image);
            return imageMapper.toImageResponseDto(image);
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

    }
    public void deleteImageById(Long id){
        Image image= imageRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Image not found"));
        imageRepo.deleteById(id);
    }

    public void updateImage(MultipartFile file,Long imageId){
        Image image= imageRepo.findById(imageId).orElseThrow(() -> new EntityNotFoundException("Image not found"));
        try {
            image.setFileName(file.getOriginalFilename());
            image.setFileType(file.getContentType());
            image.setImage(new SerialBlob(file.getBytes()));
            imageRepo.save(image);
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}