package com.study.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 데이터베이스 연결 유틸리티 클래스입니다.
 */
public class ConnectionUtil {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/ebrainsoft_study";
    private static final String USER = "ebsoft";
    private static final String PASS = "ebsoft";

    /**
     * 데이터베이스 연결을 수행하여 Connection 객체를 반환합니다.
     *
     * @return Connection 객체
     * @throws Exception 예외 발생 시
     */
    public static Connection getConnection() throws Exception {
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
}
