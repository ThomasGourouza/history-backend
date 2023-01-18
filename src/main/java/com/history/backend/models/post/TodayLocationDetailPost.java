package com.history.backend.models.post;

import com.history.backend.models.types.Image;
import com.history.backend.models.types.enums.LocationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodayLocationDetailPost {
    private LocationType type;

	private String continent;

    private String geographicalRegion;

    private String country;

    private String countryRegion;

    private String city;

    private Image flag;
}
