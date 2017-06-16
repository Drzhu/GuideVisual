package com.guide.utils;

import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ConnectionFactory {
    private static SqlSessionFactory factory;

    static {
        try {
            Reader reader = Resources.getResourceAsReader("E:/marsWorkspace/ZJXLDataCenter/src/main/resources/config/configuration.xml");
            factory = new SqlSessionFactoryBuilder().build(reader, "df");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSession() {
        return factory.openSession();
    }

    public static <T> T getMapper(Class mapper) {
        SqlSession session = getSession();
        return (T) session.getMapper(mapper);
    }
    public static void main(String[] args) {
    	ConnectionFactory.getSession();
	}
}