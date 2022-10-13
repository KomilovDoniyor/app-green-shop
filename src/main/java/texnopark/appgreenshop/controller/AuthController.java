/**
 * Author: komiloff_doniyor2505@gmail.com
 * Date:10/6/2022
 * Time:5:00 PM
 * Project Name:app-green-shop
 */
package texnopark.appgreenshop.controller;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import texnopark.appgreenshop.dto.LoginDto;
import texnopark.appgreenshop.dto.RegisterDto;
import texnopark.appgreenshop.service.impl.MyUserService;

@RestController
@RequestMapping(value = "/api/auth/")
public class AuthController {
    private final MyUserService userService;

    public AuthController(MyUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public HttpEntity<?> register(@RequestBody RegisterDto dto){
        return userService.register(dto);
    }

    @PostMapping("/login")
    public HttpEntity<?> login(@RequestBody LoginDto dto){
        return userService.login(dto);
    }
}
