package com.example.play_ground.java.refactor_example;

import org.springframework.stereotype.Service;

@Service
public class PartnerTwo implements PartnerService {

    public String retrieve(){
        return "retrive";
    }

    public String approve(){
        return "approve";
    }

    public String cancel(){
        return "cancel";
    }

    public String netCancel(){
        return "netCancel";
    }

    @Override
    public Identifier getIdentifier() {
        return Identifier.PARTNER_TWO;
    }
}
