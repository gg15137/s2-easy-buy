package com.buy.util;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**+
 * 数据库操作辅助类
 */
public class DataSourceUtil {
    /**
     * 配置阿里巴巴数据源
     */
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/easybuy";
    private static final String userName = "root";
    private static final String pwd = "root";


    //创建druid数据源对象
    private static DruidDataSource druidDataSource = null;
    static{
        try {
            init();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static DruidDataSource init() throws SQLException {
        //实例化DruidDataSource
        druidDataSource = new DruidDataSource();
        //设置属性的值
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUrl(url);
        druidDataSource.setInitialSize(5);//初始化连接池数量
        druidDataSource.setMaxActive(100);//最大连接数
        druidDataSource.setMinIdle(1);//最大空闲连接数
        druidDataSource.setMaxWait(1000);//连接等待时长，单位：毫秒
        druidDataSource.setFilters("stat");//设置监控
        return druidDataSource;
    }
    //链接数据源的方法，返回链接对象
    public static Connection getConn(){
        Connection conn = null;
        //加载mysql驱动（开启服务）
        try {
            Class.forName(driver);
            //如果爱数据库处于没有链接状态，则创建一个链接
            if (conn==null){
                conn = druidDataSource.getConnection(userName,pwd);
                System.out.println("数据库链接成功");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭链接的方法
     * @param conn
     */
    public static void  closeConnection(Connection conn){

    }
}
