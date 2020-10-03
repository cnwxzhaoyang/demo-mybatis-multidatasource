package com.orient.data.migration.controller;

import com.orient.data.migration.entity._new.NewUser;
import com.orient.data.migration.entity.old.OldUser;
import com.orient.data.migration.service.IPingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:
 *
 * @author MorningSun
 * @version 1.0
 * @see
 * @since JDK1.8
 * date 2020/10/3 15:46
 */
@RestController
public class PingController {


    @Autowired
    IPingService pingService;

    @GetMapping("/ping")
    public String ping(){
        NewUser newUser = pingService.findNewUserById("1");
        OldUser oldUser = pingService.findOldUserById(1);

        return "hello !";
    }

}
