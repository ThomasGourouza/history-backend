package com.history.backend.models.database;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.history.backend.models.types.Date;
import com.history.backend.models.types.Location;
import com.history.backend.models.types.enums.Field;
import com.history.backend.models.types.enums.PeriodEventType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "period_event")
@NoArgsConstructor
@AllArgsConstructor
public class PeriodEvent {
    @Id
    private String id;

    @TextIndexed
    private PeriodEventType type;

    @TextIndexed
    private String name;

    @TextIndexed
    private String description;

    private String wikipediaLink;

    private List<Field> fields;

    private Date date;

	private Location location;

	private List<String> imageIds;

	private List<String> personalityIds;
}
