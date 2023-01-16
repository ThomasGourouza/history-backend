package com.history.backend.models.types;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Date {
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate begin;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate end;
}
