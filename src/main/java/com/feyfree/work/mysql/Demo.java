package com.feyfree.work.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {
    private static ConnectionDetail checkMysql(ResourceDBInfoDTO data) {
        ConnectionDetail detail = ConnectionDetail.builder().connected("YES").desc("").ip(data.getDbIp()).build();
        long start = System.currentTimeMillis();
        try (Connection connection = connectMySql(data)) {
            Statement statement = connection.createStatement();
            String sql = "SELECT 1";
            statement.execute(sql);
            long interval = System.currentTimeMillis() - start;
            if (interval > 30 * 1000) {
                detail.setTimeout(interval);
                detail.setDesc("连接时间耗时太久:" + interval + "ms");
            }
        } catch (Exception e) {
            detail.setConnected("NO");
            detail.setDesc("连接异常, 请检查是否是服务器IP问题");
        }
        return detail;
    }

    private void checkHive() {

    }

    private static Connection connectMySql(ResourceDBInfoDTO data) throws SQLException, ClassNotFoundException {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://" + data.getDbIp() + ":" + data.getDbPort() + "/" + data.getDatabaseName();
        String name = data.getDbUser();
        String pwd = data.getUserPsd();
        Class.forName(driver);
        return DriverManager.getConnection(url, name, pwd);
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

    }
}
