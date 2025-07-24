package com.rixar.common.dto.notifications;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RxSmsNotification {

    List<String> phoneNumbers;

    String message;

    String senderId;

}
