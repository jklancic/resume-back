package xyz.blackmonster.resume.controller.error;

public class AuthenticationException extends Exception {

    public AuthenticationException(String error) {
        super(error);
    }
}