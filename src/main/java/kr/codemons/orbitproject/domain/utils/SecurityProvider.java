package kr.codemons.orbitproject.domain.utils;


import java.util.UUID;

public class SecurityProvider {

    public static String generateSecretKey () {
        return UUID.randomUUID().toString();
    }
}
