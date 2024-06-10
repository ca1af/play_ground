package com.example.play_ground.java.refactor_example;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class PartnerServiceFactory {

    private final Map<Identifier, PartnerService> partnerServiceBeans = new HashMap<>();

    public PartnerServiceFactory(List<PartnerService> partnerServiceList) { // List 형태의 파트너서비스 beans 주입
        partnerServiceList.forEach(each -> partnerServiceBeans.put(each.getIdentifier(), each));
    }

    public PartnerService getPartnerService(Identifier identifier) {
        return partnerServiceBeans.get(identifier);
    }
}
