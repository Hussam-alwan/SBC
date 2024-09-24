package com.dailyCode.Dream_shop.Image.service;

import com.dailyCode.Dream_shop.Image.mapper.ImageMapper;
import com.dailyCode.Dream_shop.Image.repository.ImageRepo;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    private final ImageMapper imageMapper;
    private final ImageRepo imageRepo;

    public ImageService(ImageMapper imageMapper, ImageRepo imageRepo) {
        this.imageMapper = imageMapper;
        this.imageRepo = imageRepo;
    }
}
