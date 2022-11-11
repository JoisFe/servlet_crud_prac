package config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author : 조재철
 * @since 1.0
 */

public class Connector {

    private Connector() {
    }

    public static Connection conn = null; //접속을 위한 객체

    public static void connection() {
        try (BufferedReader reader =
            new BufferedReader(new FileReader("/Users/jo/Desktop/untitled2/src/main/resources/dbInfo.txt"));) {

            String connectionInfo = reader.readLine();

            String[] idPwd = connectionInfo.split(":");

            String id = idPwd[0];
            String pwd = idPwd[1];

            conn = DriverManager.getConnection("jdbc:mysql://localhost/db01", id, pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
