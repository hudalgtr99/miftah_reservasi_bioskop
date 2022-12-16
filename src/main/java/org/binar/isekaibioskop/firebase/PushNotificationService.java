package org.binar.isekaibioskop.firebase;


import org.binar.isekaibioskop.request.PushNotificationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PushNotificationService {

    private Logger log = LoggerFactory.getLogger(PushNotificationService.class);

    private FirebaseCloudMessagingService fcmService;

    public PushNotificationService(FirebaseCloudMessagingService fcmService) {
        this.fcmService = fcmService;
    }


    public void sendPushNotificationToToken(PushNotificationRequest request) {
        try {
            fcmService.sendMessageToToken(request);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

}