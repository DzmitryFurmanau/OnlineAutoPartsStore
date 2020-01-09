package com.onlineAutoPartsStore.app.controller;

import com.onlineAutoPartsStore.app.dto.request.UserRegistrationRequestDto;
import com.onlineAutoPartsStore.app.dto.response.TokenResponseDto;
import com.onlineAutoPartsStore.app.model.Role;
import com.onlineAutoPartsStore.app.model.User;
import com.onlineAutoPartsStore.app.service.RoleService;
import com.onlineAutoPartsStore.app.service.UserService;
import com.onlineAutoPartsStore.app.service.security.TokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The type Authentication controller.
 */
@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    private final UserService userService;

    private final RoleService roleService;

    private final TokenService tokenService;

    private final PasswordEncoder encoder;

    private final AuthenticationManager authenticationManager;

    /**
     * Instantiates a new Authentication controller.
     *
     * @param userService           the user service
     * @param roleService           the role service
     * @param tokenService          the token service
     * @param encoder               the encoder
     * @param authenticationManager the authentication manager
     */
    public AuthenticationController(UserService userService,
                                    RoleService roleService,
                                    TokenService tokenService,
                                    PasswordEncoder encoder,
                                    AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.roleService = roleService;
        this.tokenService = tokenService;
        this.encoder = encoder;
        this.authenticationManager = authenticationManager;
    }

    /**
     * Authenticate user token response dto.
     *
     * @param requestDto the request dto
     * @return the token response dto
     */
    @PostMapping("/signIn")
    public TokenResponseDto authenticateUser(@RequestBody UserRegistrationRequestDto requestDto) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(requestDto.getUsername(), requestDto.getPassword());
        Authentication authentication = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new TokenResponseDto(tokenService.generate(authentication));
    }

    /**
     * Register user user.
     *
     * @param userRegistrationRequestDto the user registration request dto
     * @return the user
     */
    @PostMapping("/signUp")
    public User registerUser(@RequestBody UserRegistrationRequestDto userRegistrationRequestDto) {
        final User user = new User();
        user.setName(userRegistrationRequestDto.getUsername());
        user.setPassword(encoder.encode(userRegistrationRequestDto.getPassword()));
        final Set<Role> roles = userRegistrationRequestDto.getRoles().stream()
                .map(roleService::findByName)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
        user.setRoles(roles);
        return userService.save(user);
    }
}
