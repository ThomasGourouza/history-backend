package com.history.backend.models.database;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Century {
    @Id
    private String id;

    private int number;

	private String roman;

	private int begin;
    
	private int end;
}
