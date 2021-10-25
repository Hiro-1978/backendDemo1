package com.spingboot.backendDemo1;

import com.spingboot.backendDemo1.business.EmailBusiness;
import com.spingboot.backendDemo1.exception.BaseException;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestEmailBusiness {

    @Autowired
    private EmailBusiness emailBusiness;

    @Order(1)
    @Test
    void testSendActivateEmail() throws BaseException {
        emailBusiness.sendActivateUserEmail(
                TestData.email,
                TestData.name,
                TestData.token
        );
    }

    interface TestData {

        String email = "hiro_miuki@hotmail.com";

        String name = "Paisan Pompadech";

        String token = "m#@:LSDIFDISIDFO99020kkddd";

    }

}

