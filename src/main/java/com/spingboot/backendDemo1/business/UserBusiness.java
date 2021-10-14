package com.spingboot.backendDemo1.business;

import com.spingboot.backendDemo1.Service.UserService;
import com.spingboot.backendDemo1.entity.User;
import com.spingboot.backendDemo1.exception.BaseException;
import com.spingboot.backendDemo1.exception.FileException;
import com.spingboot.backendDemo1.model.MRegisterRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

@Service
public class UserBusiness { // สร้างเพื่อเรียกใช้งานได้หลายๆ ครั้ง

    private final UserService userService;

    public UserBusiness(UserService userService) {
        this.userService = userService;
    }

    public User register(MRegisterRequest request) throws BaseException {
        User user = userService.create(request.getEmail(), request.getPassword(), request.getName());

        return user;
    }

    public String uploadProfilePicture(MultipartFile file) throws FileException {
        //validate file
        if (file == null) {
            //throw error
            throw FileException.fileNull();
        }
        //validate size
        if (file.getSize() > 1048576 * 2) {
            // throw error
            throw FileException.fileMaxSize();
        }

        String contentType = file.getContentType();
        if (contentType == null) {
            //throw error
            throw FileException.unsupported();
        }

        List<String> supportedTypes = Arrays.asList("image/jpeg", "image/png");
        if (!supportedTypes.contains(contentType)) {
            //throw error (unsupport)
            throw FileException.fileNull();
        }
        throw FileException.unsupported();
    }

}
