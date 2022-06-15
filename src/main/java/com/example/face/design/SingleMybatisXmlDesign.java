package com.example.face.design;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;

/**
 * 读取mybatis配置单例模式
 *
 * @author 搬砖的码农
 * @date 2022/05/18
 * @email
 **/
public class SingleMybatisXmlDesign {
    /**
     * new当前对象
     */
    private static final SingleMybatisXmlDesign smxd = new SingleMybatisXmlDesign();

    /**
     * 私有构造方法
     * 禁止调用构造方法
     */
    private SingleMybatisXmlDesign() {
    }


    /**
     * 公开对外访问方法
     */
    public static SingleMybatisXmlDesign getDesign() {
        return smxd;
    }

    /**
     * 返回连接配置
     * */
    public SqlSession getConnt() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);

        SqlSession ss=  ssf.openSession();
        return ss;
    }
}
