package com.example.play_ground.java.refactor_example;

public interface PartnerService {
    String retrieve();
    String approve();
    String cancel();
    String netCancel();
    Identifier getIdentifier();
}
