package com.spingboot.backendDemo1.api;

import com.spingboot.backendDemo1.business.UserBusiness;
import com.spingboot.backendDemo1.entity.User;
import com.spingboot.backendDemo1.exception.BaseException;
import com.spingboot.backendDemo1.model.MRegisterRequest;
import com.spingboot.backendDemo1.model.TestResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user")
public class UserApi {
    /*
    //Method: 1 => Field Injection
    @Autowired
    private TestBusiness business;
    */
    //Method: 2 => Constructor Injection *Code ยาวกว่า แต่ทำงานได้เร็วกว่า
    private final UserBusiness business; // กด Alt+Enter

    public UserApi(UserBusiness business) {
        this.business = business;
    }

    @GetMapping
    public TestResponse test() {
        TestResponse response = new TestResponse();
        response.setName("www");
        response.setName("Hiro");
        response.setFood("KFC");
        return response;
    }

   /* @GetMapping
    @RequestMapping("/test2")
    public TestResponse test2(){
        TestResponse response = new TestResponse();
        response.setName("Hiro 2");
        response.setFood("KFC 2");
        return response;
    } */

    @PostMapping
    @RequestMapping("/register")
    public ResponseEntity<User> register(@RequestBody MRegisterRequest request) throws BaseException {
        User response = business.register(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<String> uploadProfilePicture(@RequestPart MultipartFile file) throws BaseException {
        String response = business.uploadProfilePicture(file);
        return ResponseEntity.ok(response);
    }


}
