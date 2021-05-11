package com.switchfully.codecoach.email;

import com.switchfully.codecoach.domain.Event;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"test", "development"})
@Component
public class MockMessageSender implements MessageSender {

    @Override
    public void handle(Event event) {
        //Send your messages here...
    }
}
