package com.history.backend.models.database;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "field")
@NoArgsConstructor
@AllArgsConstructor
public class Field {
    @Id
    private String id;

	private String name;
}
