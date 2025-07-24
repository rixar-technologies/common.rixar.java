package com.rixar.payments.common.orders;


public enum OrderStatus {

    PENDING("Pending"),
    WAITING_DELIVERY("Waiting delivery"),
    DEBT("Debt"),
    CANCELLED("Cancelled"),
    COMPLETED("Completed");

    final String label;

    OrderStatus(String label) {
        this.label = label;
    }

}
