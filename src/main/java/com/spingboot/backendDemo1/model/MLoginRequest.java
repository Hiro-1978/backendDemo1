package com.spingboot.backendDemo1.model;

import lombok.Data;

@Data
public class MLoginRequest {
    private String email;
    private String password;
}
