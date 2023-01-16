package com.masai.exception;

import lombok.*;

import java.time.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyErrorDetails {

    private LocalDateTime localDateTime;
    private String message;
    private String details;

}
