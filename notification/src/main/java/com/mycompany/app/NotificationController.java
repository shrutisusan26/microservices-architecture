package com.mycompany.app;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/notification")
@Slf4j
public class NotificationController {
    private  final NotificationService notificationService;

    @PostMapping
    public void sendNotification(@RequestBody  NotificationRequest notificationRequest){
        notificationService.send(notificationRequest);

    }

}
