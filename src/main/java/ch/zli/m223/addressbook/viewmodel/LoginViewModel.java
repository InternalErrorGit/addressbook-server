package ch.zli.m223.addressbook.viewmodel;

/**
 * @author P. Gatzka
 * @version 29.09.2021
 * Project: addressbookserver
 */
public class LoginViewModel {

    private final String token;
    private final Long userId;

    public LoginViewModel(String token, Long userId) {
        this.token = token;
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }


    public Long getUserId() {
        return userId;
    }

}
