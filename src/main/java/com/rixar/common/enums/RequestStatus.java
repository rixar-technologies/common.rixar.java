package com.rixar.common.enums;


public enum RequestStatus {

    SUCCESS("Success"),
    PENDING("Pending"),
    FAILED("Failed"),
    UNKNOWN("Unknown");

    public final String label;

    RequestStatus(String label) {
        this.label = label;
    }

}
