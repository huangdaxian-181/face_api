package com.example.face.service.impl;

import com.example.face.design.SingleMybatisXmlDesign;
import com.example.face.domain.FaceUser;
import com.example.face.mapper.UserMapper;
import com.example.face.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.io.IOException;

/**
 * @author 搬砖的码农
 * @date 2022/05/17
 * @email
 **/
@Service("UserService")
public class UserServiceImpl implements UserService {
    Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    UserMapper userMapper;

    @Override
    public void query() throws IOException {

        SqlSession ss = SingleMybatisXmlDesign.getDesign().getConnt();

        UserMapper um = ss.getMapper(UserMapper.class);
        FaceUser list = um.selectQuery("张三");

        ss.commit();
        ss.close();
    }
}
