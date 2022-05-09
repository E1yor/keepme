package uz.wiut.keepme.service.jwt;

public interface TokenHelper {
    String generate(String sessionId);
    String retrieveToken(String authorizationHeader) throws Exception;
    String retrieveSessionId(String token) throws Exception;
    String generateRefreshToken(String id);
    String retrieveRefreshSessionId(String refreshToken) throws Exception;
}