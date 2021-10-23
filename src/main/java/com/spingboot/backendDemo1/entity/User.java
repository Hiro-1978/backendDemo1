package com.spingboot.backendDemo1.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "m_user")
public class User extends BaseEntity {

    @Column(nullable = false, unique = true, length = 60)
    private String email;

    @Column(nullable = false, length = 120)
    private String password;

    @Column(nullable = false, length = 120)
    private String name;

    private String civilId;

    //การ Join Table Database
    @OneToOne(mappedBy = "user", orphanRemoval = true) // ลบแม่ แล้วลูกหายไปด้วย
    private Social social;

    //การ Join แบบ One to Many
    @OneToMany(mappedBy = "user", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Address> adresses;
}
