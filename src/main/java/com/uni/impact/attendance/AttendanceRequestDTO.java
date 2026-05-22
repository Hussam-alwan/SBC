package com.uni.impact.attendance;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
public class AttendanceRequestDTO {

    @NotNull
    private LocalDate attendanceDate;

    @NotNull
    private AttendanceStatus status;

    @NotNull
    private Double hoursThatDay;

    private String notes;

    private LocalDateTime recordedAt;

    @NotNull
    private Long student;

    private Long campaign;

    @NotNull
    private Long recordedBy;

}
