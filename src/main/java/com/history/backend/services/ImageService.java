package com.history.backend.services;

import java.io.IOException;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.history.backend.models.database.Image;
import com.history.backend.repositories.ImageRepository;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    public String saveImage(String name, String description, MultipartFile file) throws IOException { 
        Image image = new Image(name, description); 
        image.setBinary(
          new Binary(BsonBinarySubType.BINARY, file.getBytes())); 
        image = imageRepository.insert(image);
        return image.getId(); 
    }

    public Image getImage(String id) { 
        return imageRepository.findById(id).orElse(null);
    }
}