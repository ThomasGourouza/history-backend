package com.history.backend.models.types;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.history.backend.models.types.enums.Field;
import com.history.backend.models.types.enums.Language;
import com.history.backend.models.types.enums.WorkType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Work {
    private String name;

    private WorkType type;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;

	private List<String> imageIds;

	private List<Field> fields;
    
	private List<Field> movement;

    private String description;

	private String wikipediaLink;

    private Language language;

}
