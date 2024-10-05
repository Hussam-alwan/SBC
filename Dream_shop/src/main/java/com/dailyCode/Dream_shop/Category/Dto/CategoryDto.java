package com.dailyCode.Dream_shop.Category.Dto;

import jakarta.validation.constraints.NotEmpty;

public record CategoryDto(
        @NotEmpty String name
) {}