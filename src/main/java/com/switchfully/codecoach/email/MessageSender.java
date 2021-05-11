package com.switchfully.codecoach.email;

import com.switchfully.codecoach.domain.Event;

public interface MessageSender {
    void handle(Event event);
}
