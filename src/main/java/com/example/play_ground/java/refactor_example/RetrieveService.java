package com.example.play_ground.java.refactor_example;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RetrieveService {

    private final PartnerServiceFactory partnerServiceFactory;

    public String retrieve(RequestDto requestDto){
        PartnerService partnerService = partnerServiceFactory.getPartnerService(requestDto.identifier());
        return partnerService.retrieve();
    }
}
