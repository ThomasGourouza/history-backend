package com.history.backend.models.database;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "images")
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    @Id
    private String id;
    
    @TextIndexed
    private String name;
    
    @TextIndexed
    private String description;
        
    private Binary binary;

    public Image(String name, String description) {
        this.name = name;
        this.description = description;
    }
}