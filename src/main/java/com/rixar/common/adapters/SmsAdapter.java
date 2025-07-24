package com.rixar.common.adapters;

import java.util.List;


public interface SmsAdapter {

    void sendOne(String phone,String message);

    void sendMultiple(List<String> phoneNumbers, String message);

}
