package com.rixar.common.adapters;

import com.rixar.common.dto.notifications.RxSmsNotification;

public interface SmsAdapter {

    void send(RxSmsNotification smsNotification);

    String getAdapterName();

}
