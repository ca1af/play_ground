package com.example.play_ground.spring;

import java.util.HashMap;
import java.util.Map;

public class RedisAuthDAO {
    static Map<String, Map<String, String>> userRefreshTokens = new HashMap<>();

    public void storeRefreshToken(String username, String deviceId, String refreshToken) {
        Map<String, String> userTokens = userRefreshTokens.get(username);
        // 사용자의 이름을 키로 하는 맵에서, 그 안에 이중 맵으로 {아이디, 리프레쉬 토큰} 을 저장
        if (userTokens == null) {
            userTokens = new HashMap<>();
            userRefreshTokens.put(username, userTokens);
        }
        userTokens.put(deviceId, refreshToken);
    }

    public String getRefreshToken(String username, String deviceId) {
        Map<String, String> userTokens = userRefreshTokens.get(username);
        return userTokens != null ? userTokens.get(deviceId) : null;
    }

    public void removeRefreshToken(String username, String deviceId) {
        Map<String, String> userTokens = userRefreshTokens.get(username);
        if (userTokens != null) {
            userTokens.remove(deviceId);
        }
    }
}
