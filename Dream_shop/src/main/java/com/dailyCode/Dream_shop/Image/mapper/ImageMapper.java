package com.dailyCode.Dream_shop.Image.mapper;

import com.dailyCode.Dream_shop.Image.Dto.ImageDto;
import com.dailyCode.Dream_shop.Image.Dto.ImageResponseDto;
import com.dailyCode.Dream_shop.Image.model.Image;
import org.springframework.stereotype.Service;

@Service
public class ImageMapper {
    public ImageResponseDto toImageResponseDto(Image image) {
      return new ImageResponseDto(
        image.getId(),
        image.getFileName(),
        image.getDownloadUrl()
      );
    }

    public Image toImage(ImageDto imageDto) {
        Image image = new Image();
        image.setFileName(imageDto.firstName());
        image.setDownloadUrl(imageDto.downloadUrl());
        return image;
    }

}
