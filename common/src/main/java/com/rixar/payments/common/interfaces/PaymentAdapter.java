package com.rixar.payments.common.interfaces;

import com.rixar.payments.common.dto.RxPaymentRequest;

public interface PaymentAdapter {

    void initiatePayment(RxPaymentRequest paymentRequest);

    String getName();

}
