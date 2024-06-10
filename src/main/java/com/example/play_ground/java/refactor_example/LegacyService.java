package com.example.play_ground.java.refactor_example;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class LegacyService {

    private final PartnerOne partnerOne;

    private final PartnerTwo partnerTwo;

    // ...

    // 조회 (예시)
    public String retrieve(Map<String, Object> objectMap){ //
        // ...
        String identifier = (String) objectMap.get("identifier");
        switch (identifier){
            case "giftiCon" : return partnerTwo.retrieve();
            case "giftiShow" : return partnerOne.retrieve();
            default: throw new RuntimeException("custom exception");
        }
        // ...
    }

    // 취소 (예시)
    public String approve(Map<String, Object> objectMap){ //
        // ...
        String identifier = (String) objectMap.get("identifier");
        switch (identifier){
            case "giftiCon" : return partnerTwo.cancel(); // 어떤 고객사는 망 취소가 없으므로 여기서 명시적으로 cancel
            case "giftiShow" : return partnerOne.netCancel();
            default: throw new RuntimeException("custom exception");
        }
        // ...
    }
}
