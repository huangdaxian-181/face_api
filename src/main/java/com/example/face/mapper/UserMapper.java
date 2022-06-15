package com.example.face.mapper;

import com.example.face.domain.FaceUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
/**
 * @author huangdaxian
 * @date 2022/05/18
 * @email 3081476398@qq.com
 **/
@Mapper
public interface UserMapper {
    FaceUser selectQuery(@Param("name") String name);
}
