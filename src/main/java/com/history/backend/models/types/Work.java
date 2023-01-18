package com.history.backend.models.types;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.history.backend.models.types.enums.Field;
import com.history.backend.models.types.enums.Language;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Work {
    private String name;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;

	private List<String> imageIds;

	private List<Field> fields;
    
	private List<String> periodEventIds;

    private String description;

	private List<String> links;

    private Language language;

}
