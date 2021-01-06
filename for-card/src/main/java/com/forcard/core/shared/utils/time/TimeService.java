package com.forcard.core.shared.utils.time;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public interface TimeService {

    LocalDate getLocalDate();

    LocalDateTime getLocalDateTime();
}
