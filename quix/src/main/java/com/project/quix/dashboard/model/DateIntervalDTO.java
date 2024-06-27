package com.project.quix.dashboard.model;

import java.time.LocalDateTime;

public class DateIntervalDTO {
    LocalDateTime date1;
    LocalDateTime date2;

    public DateIntervalDTO() {
    }

    public DateIntervalDTO(LocalDateTime date1, LocalDateTime date2) {
        this.date1 = date1;
        this.date2 = date2;
    }

    public LocalDateTime getDate1() {
        return date1;
    }

    public void setDate1(LocalDateTime date1) {
        this.date1 = date1;
    }

    public LocalDateTime getDate2() {
        return date2;
    }

    public void setDate2(LocalDateTime date2) {
        this.date2 = date2;
    }
}
