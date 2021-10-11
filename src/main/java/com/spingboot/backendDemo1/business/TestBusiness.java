package com.spingboot.backendDemo1.business;

import com.spingboot.backendDemo1.exception.BaseException;
import com.spingboot.backendDemo1.exception.UserException;
import com.spingboot.backendDemo1.model.MRegisterRequest;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TestBusiness { // สร้างเพื่อเรียกใช้งานได้หลายๆ ครั้ง

    public String register(MRegisterRequest request) throws BaseException {
        if (request == null) {
            throw UserException.requestNull();
        }

        //validate email
        if (Objects.isNull(request.getEmail())) {
            throw UserException.emailNull();
        }

        //Validate...
        return "";
    }

}
