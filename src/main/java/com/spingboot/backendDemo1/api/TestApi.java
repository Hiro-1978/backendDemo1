package com.spingboot.backendDemo1.api;

import com.spingboot.backendDemo1.business.TestBusiness;
import com.spingboot.backendDemo1.exception.BaseException;
import com.spingboot.backendDemo1.model.MRegisterRequest;
import com.spingboot.backendDemo1.model.TestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/test")
public class TestApi {
    /*
    //Method: 1 => Field Injection
    @Autowired
    private TestBusiness business;
    */
    //Method: 2 => Constructor Injection *Code ยาวกว่า แต่ทำงานได้เร็วกว่า
    private final TestBusiness business; // กด Alt+Enter

    public TestApi(TestBusiness business) {
        this.business = business;
    }

    @GetMapping
    public TestResponse test(){
        TestResponse response = new TestResponse();
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
    public ResponseEntity<String> register(@RequestBody MRegisterRequest request) throws BaseException {
        String response = null;
        response = business.register(request);
        return ResponseEntity.ok(response);
    }

}
