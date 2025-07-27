package com.rixar.common.dto.notifications;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RxEmailNotification {

    List<String> emails;

    String preferredGateway;

    String subject;

    String from;

    String replyTo;

    String contentType;

    String mimeVersion;

    String content;

}
