package project.isabackend.controller;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import project.isabackend.dto.UserInfoDTO;
import project.isabackend.dto.UserLoginDTO;
import project.isabackend.dto.UserRegistrationDTO;
import project.isabackend.model.RegisteredUser;
import project.isabackend.security.UserDetailsImpl;
import project.isabackend.service.UserService;
import project.isabackend.util.TokenUtil;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    TokenUtil tokenUtil;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserRegistrationDTO userDTO) {
        RegisteredUser existingUser = userService.findByEmail(userDTO.getEmail());

        if (existingUser != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already exists!");
        }

        userService.addRegisteredUser(userDTO);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> logIn(@Valid @RequestBody UserLoginDTO dto) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        ResponseCookie cookie = tokenUtil.getCookie(userDetails);
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString()).build();
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logOut() {
        ResponseCookie cookie = tokenUtil.getCleanCookie();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString()).build();
    }

    @GetMapping("/user-info")
    public ResponseEntity<?> getUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        UserInfoDTO userInfo = new UserInfoDTO();
        BeanUtils.copyProperties(userDetails, userInfo);

        if (userDetails.getRole() != null) {
            userInfo.setRole(userDetails.getRole().getName());
        }

        return ResponseEntity.ok(userInfo);
    }
}
