package helpers.user;

public class UserResponse {
    private boolean success;
    private User user;
    private String accessToken;
    private String refreshToken;

    public UserResponse() {

    }

    public String getAccessToken() {
        return accessToken;
    }
}
