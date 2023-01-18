package com.history.backend.models.database;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.history.backend.models.types.Date;
import com.history.backend.models.types.Location;
import com.history.backend.models.types.enums.Field;
import com.history.backend.models.types.Work;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Personality {
    @Id
    private String id;

    @TextIndexed
    private String name;

	private Date date;
    
	private Location livingLocation;

	private List<String> imageIds;

	private List<Field> fields;
    
	private List<Field> movement;

	@TextIndexed
    private String description;

    private String wikipediaLink;

	private List<Work> works;
}
