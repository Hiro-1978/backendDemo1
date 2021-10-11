package com.spingboot.backendDemo1.exception;

public abstract class BaseException extends Exception{

    public BaseException(String code){
        super(code);
    }

}
