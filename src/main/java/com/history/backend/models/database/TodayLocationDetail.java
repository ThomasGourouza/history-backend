package com.history.backend.models.database;

import org.springframework.data.mongodb.core.mapping.Document;

import com.history.backend.models.types.enums.LocationType;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "today_location_detail")
@NoArgsConstructor
@AllArgsConstructor
public class TodayLocationDetail {
	@Id
    private String id;

    @TextIndexed
	private LocationType type;

    @TextIndexed
	private String continent;

    @TextIndexed
    private String geographicalRegion;

    @TextIndexed
    private String country;

    @TextIndexed
    private String countryRegion;

    @TextIndexed
    private String city;

    private String flagImageId;
}
