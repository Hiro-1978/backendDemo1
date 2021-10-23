package com.spingboot.backendDemo1.business;

import com.spingboot.backendDemo1.exception.UserException;
import com.spingboot.backendDemo1.mapper.UserMapper;
import com.spingboot.backendDemo1.model.MLoginRequest;
import com.spingboot.backendDemo1.model.MRegisterResponse;
import com.spingboot.backendDemo1.service.TokenService;
import com.spingboot.backendDemo1.service.UserService;
import com.spingboot.backendDemo1.entity.User;
import com.spingboot.backendDemo1.exception.BaseException;
import com.spingboot.backendDemo1.exception.FileException;
import com.spingboot.backendDemo1.model.MRegisterRequest;


import com.spingboot.backendDemo1.util.SecurityUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserBusiness { // สร้างเพื่อเรียกใช้งานได้หลายๆ ครั้ง

    private final UserService userService;

    private final TokenService tokenService;

    private final UserMapper userMapper;

    public UserBusiness(UserService userService, TokenService tokenService, UserMapper userMapper) {
        this.userService = userService;
        this.tokenService = tokenService;
        this.userMapper = userMapper;
    }

    public String login(MLoginRequest request) throws BaseException{
        // validate request

        // verify database
        Optional<User> opt = userService.findByEmail(request.getEmail());
        if(opt.isEmpty()){ //ใช้ .isEmpty() ไม่ได้เพราะไม่ใช่ java11
            // Throw login fail, email not found
            throw UserException.loginFailEmailNotFound();
        }
        User user = opt.get();
        // verify password
        if(!userService.matchPassword(request.getPassword(), user.getPassword())){
            // throw login fail, email incorrect
            throw UserException.loginFailPasswordIncorrect();
        }

        // Todo: generate JWT
            return tokenService.tokenize(user);
    }

    public String refreshToken() throws BaseException {
        Optional<String> opt = SecurityUtil.getCurrentUserId();
        if (opt.isEmpty()) {
            throw UserException.unauthorized();
        }

        String userId = opt.get();

        Optional<User> optUser = userService.findById(userId);
        if (optUser.isEmpty()) {
            throw UserException.notFound();
        }

        User user = optUser.get();
        return tokenService.tokenize(user);
    }
    public MRegisterResponse register(MRegisterRequest request) throws BaseException {
        User user = userService.create(request.getEmail(), request.getPassword(), request.getName());
        // Todo MApper
        return userMapper.toRegisterResponse(user);
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
