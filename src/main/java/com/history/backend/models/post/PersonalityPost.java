package com.history.backend.models.post;

import java.util.List;

import com.history.backend.models.types.Date;
import com.history.backend.models.types.Image;
import com.history.backend.models.types.Location;
import com.history.backend.models.types.Work;
import com.history.backend.models.types.enums.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonalityPost {
    private String name;

	private Date date;
    
	private Location livingLocation;

	private List<Image> images;

	private List<Field> fields;
    
	private List<Field> movement;

    private String description;

    private String wikipediaLink;

	private List<Work> works;
}
