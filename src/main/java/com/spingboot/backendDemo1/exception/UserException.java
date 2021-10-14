package com.spingboot.backendDemo1.exception;

public class UserException extends BaseException{

    public UserException(String code) {
        super("user." + code);
    }

    public static UserException requestNull() {
        return new UserException("register.request.null");
    }
        //user.register.email.null
    public static UserException emailNull(){
        return new UserException("register.email.null");
    }

    // Create
    public static UserException createEmailNull(){
        return new UserException("create.email.null");
    }

    public static UserException createPasswordNull(){
        return new UserException("create.password.null");
    }

    public static UserException createNameNull(){
        return new UserException("create.name.null");
    }
}
