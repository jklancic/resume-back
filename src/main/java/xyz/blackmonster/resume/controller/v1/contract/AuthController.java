package xyz.blackmonster.resume.controller.v1.contract;

import xyz.blackmonster.resume.controller.error.AuthenticationException;
import xyz.blackmonster.resume.json.v1.auth.Token;
import xyz.blackmonster.resume.json.v1.auth.User;

public interface AuthController {

	Token authenticate(User user) throws AuthenticationException;
	User setup(User user);
}