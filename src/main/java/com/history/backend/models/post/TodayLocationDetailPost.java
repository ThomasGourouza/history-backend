package com.history.backend.models.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodayLocationDetailPost {
	private String continent;

    private String country;

    private String flagImageId;
}
