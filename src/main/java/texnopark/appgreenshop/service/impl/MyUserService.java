/**
 * Author: komiloff_doniyor2505@gmail.com
 * Date:10/9/2022
 * Time:10:44 PM
 * Project Name:app-green-shop
 */
package texnopark.appgreenshop.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import texnopark.appgreenshop.dto.LoginDto;
import texnopark.appgreenshop.dto.RegisterDto;
import texnopark.appgreenshop.entity.Role;
import texnopark.appgreenshop.entity.User;
import texnopark.appgreenshop.repository.RoleRepository;
import texnopark.appgreenshop.repository.UserRepository;
import texnopark.appgreenshop.security.JwtProvider;

import java.util.HashSet;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class  MyUserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    private final JavaMailSender mailSender;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository
                .findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return user;
    }

    public HttpEntity<?> register(RegisterDto dto) {
        User user = new User();
        user.setFirstname(dto.getFirstname());
        user.setLastname(dto.getLastname());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        Set<Role> roles = new HashSet<>();
        for (Long roleId : dto.getRolesIdSet()) {
            Optional<Role> byId = roleRepository.findById(roleId);
            byId.ifPresent(roles::add);
        }
        User savedUser = userRepository.save(user);
        //sendVerificationCodeFromEmail(savedUser.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body("Successfully registered " + savedUser.getEmail());
    }

    private void sendVerificationCodeFromEmail(String toEmail) {
        Integer code = generateVerificationCode();
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("komiloff.doniyor2505@gmail.com");
        mailMessage.setTo(toEmail);
        mailMessage.setText(code.toString());
        mailMessage.setSubject("ConfirmationCode");

        mailSender.send(mailMessage);
    }

    private Integer generateVerificationCode() {
        Random random = new Random();
        int code = random.nextInt(999999);
        return code;
    }

    public HttpEntity<?> login(LoginDto dto) {
        Authentication authenticate = authenticationManager
                            .authenticate(new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword()));
        User principal = (User) authenticate.getPrincipal();
        String generateToken = jwtProvider.generateToken(principal.getEmail(), principal.getRoles());
        return ResponseEntity.status(HttpStatus.OK).body("Token: " + generateToken);
    }
}
