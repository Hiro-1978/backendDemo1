package com.spingboot.backendDemo1.business;

import com.spingboot.backendDemo1.exception.BaseException;
import com.spingboot.backendDemo1.exception.FileException;
import com.spingboot.backendDemo1.exception.UserException;
import com.spingboot.backendDemo1.model.MRegisterRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
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

    public String uploadProfilePicture(MultipartFile file) throws FileException {
        //validate file
        if (file == null) {
         //throw error
            throw FileException.fileNull();
        }
        //validate size
        if(file.getSize() > 1048576*2){
            // throw error
            throw FileException.fileMaxSize();
        }

        String contentType = file.getContentType();
        if(contentType == null){
            //throw error
            throw FileException.unsupported();
        }

        List<String> supportedTypes = Arrays.asList("image/jpeg","image/png");
        if(!supportedTypes.contains(contentType)){
            //throw error (unsupport)
            throw FileException.fileNull();
        }
        throw FileException.unsupported();
    }

}
