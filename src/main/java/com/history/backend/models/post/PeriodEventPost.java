package com.history.backend.models.post;

import java.util.List;

import com.history.backend.models.types.Date;
import com.history.backend.models.types.Image;
import com.history.backend.models.types.Location;
import com.history.backend.models.types.enums.Field;
import com.history.backend.models.types.enums.PeriodEventType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeriodEventPost {
    private PeriodEventType type;

    private String name;

    private String description;

    private String wikipediaLink;

    private List<Field> fields;

    private Date date;

	private Location location;

	private List<Image> images;
}
