package com.example.face.controller;

import com.example.face.domain.FaceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.face.service.UserService;

import java.io.IOException;

/**
 * @author 搬砖的码农
 * @date 2022/05/17
 * @email
 **/
@RestController
public class TestController {

      @Autowired
      UserService userService;

      @RequestMapping("/demo1")
      @ResponseBody
      public void demo1() throws IOException {
            userService.query();
      }
}
