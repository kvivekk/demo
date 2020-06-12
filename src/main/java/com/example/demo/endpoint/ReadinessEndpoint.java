package com.example.demo.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Endpoint (id = "readiness111")
public class ReadinessEndpoint {

    private String ready = "NOT_READY456";

    @ReadOperation
    public String getReadiness(){
        return ready;
    }

//    @WriteOperation
    @EventListener(ApplicationReadyEvent.class)
    public void setReady(){
        ready = "READY123";
    }
}
