package com.spingboot.backendDemo1.api;

import com.spingboot.backendDemo1.business.UserBusiness;
import com.spingboot.backendDemo1.exception.BaseException;
import com.spingboot.backendDemo1.model.MLoginRequest;
import com.spingboot.backendDemo1.model.MRegisterRequest;
import com.spingboot.backendDemo1.model.MRegisterResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user")
public class UserApi {

    private final UserBusiness business; // กด Alt+Enter

    public UserApi(UserBusiness business) {
        this.business = business;
    }

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody MLoginRequest request) throws BaseException {
        String response = business.login(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<MRegisterResponse> register(@RequestBody MRegisterRequest request) throws BaseException {
        MRegisterResponse response = business.register(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<String> uploadProfilePicture(@RequestPart MultipartFile file) throws BaseException {
        String response = business.uploadProfilePicture(file);
        return ResponseEntity.ok(response);
    }


}
