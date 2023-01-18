package com.history.backend.models.database;

import org.springframework.data.mongodb.core.mapping.Document;

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
	private String continent;

    @TextIndexed
    private String country;

    private String flagImageId;
}
