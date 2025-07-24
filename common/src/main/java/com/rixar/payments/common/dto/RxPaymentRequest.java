package com.rixar.payments.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RxPaymentRequest {

    String channel;

    String rxOrderReference;

    String amount;

    String phoneNumber;

    String narration;

    String userId;

}
