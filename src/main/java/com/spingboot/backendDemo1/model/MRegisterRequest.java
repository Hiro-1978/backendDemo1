package com.spingboot.backendDemo1.model;

import lombok.Data;

@Data
public class MRegisterRequest { // M = Model
    private String email;
    private String password;
    private String name;

}
