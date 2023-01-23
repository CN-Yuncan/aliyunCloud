package com.nyist;

import com.nyist.model.Admin;
import com.nyist.model.User;
import com.nyist.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootFilemanagementApplicationTests {

    @Autowired
    AdminService adminService;

    @Test
    void testAdmin() {
        System.out.println(adminService.FindAllUser());
    }

}
