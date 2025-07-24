package com.rixar.common.interfaces;

import com.rixar.common.dto.RxPaymentRequest;

public interface PaymentAdapter {

    void initiatePayment(RxPaymentRequest paymentRequest);

    String getName();

}
