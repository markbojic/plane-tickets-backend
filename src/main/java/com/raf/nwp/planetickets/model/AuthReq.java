package com.raf.nwp.planetickets.model;

import lombok.Data;

@Data
public class AuthReq {
    private String username;
    private String password;
}