package com.history.backend.models.post;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImagePost {
    private String name;

    private String description;

    private MultipartFile image;
}
