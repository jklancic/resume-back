package xyz.blackmonster.resume.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xyz.blackmonster.resume.controller.ApiVersioning;
import xyz.blackmonster.resume.controller.error.AuthenticationException;
import xyz.blackmonster.resume.controller.v1.contract.AuthController;
import xyz.blackmonster.resume.json.v1.auth.Token;
import xyz.blackmonster.resume.json.v1.auth.User;
import xyz.blackmonster.resume.jwt.contract.JwtUtil;
import xyz.blackmonster.resume.layer.contract.ClassConverter;
import xyz.blackmonster.resume.service.contract.UserService;
import xyz.blackmonster.resume.service.model.UserBean;

@RestController
@RequestMapping(ApiVersioning.API_V1 + "/authenticate")
public class AuthControllerImpl implements AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final ClassConverter classConverter;
    private final JwtUtil jwtUtil;

    @Autowired
    public AuthControllerImpl(AuthenticationManager authenticationManager, UserService userService, PasswordEncoder passwordEncoder, ClassConverter classConverter, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.classConverter = classConverter;
        this.jwtUtil = jwtUtil;
    }

    @Override
    @RequestMapping(value = "/jwt", method = RequestMethod.POST)
    public Token authenticate(@RequestBody User user) throws AuthenticationException {
        authenticate(user.getUsername(), user.getPassword());

        UserBean validatedUser = userService.validateCredentials(user.getUsername(), user.getPassword());

        return new Token(jwtUtil.generateToken(validatedUser.getUsername()));
    }

    @Override
    @RequestMapping(value = "/setup", method = RequestMethod.POST)
    public User setup(@RequestBody User user) {
        if (userService.hasOneUser()) {
            throw new IllegalStateException("User is already defined.");
        }

        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        UserBean newUser = userService.saveUser(classConverter.transform(user));

        return classConverter.transform(newUser);
    }

    private void authenticate(String username, String password) throws AuthenticationException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new AuthenticationException("User is disabled");
        } catch (BadCredentialsException e) {
            throw new AuthenticationException("Invalid credentials");
        }
    }
}