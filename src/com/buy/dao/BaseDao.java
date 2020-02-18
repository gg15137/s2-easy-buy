package com.buy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @Author:LiuZe
 * @Description: 工具类 （添加删除，修改查询的）
 * @Date:Created in 2019/10/14 15:01
 * @Modified By:
 */
public class BaseDao {
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/easybuy";
    private String userName = "root";
    private String pwd = "root";
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    /**8
     *连接操作
     * @return
     */
    public Connection getConnection() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, userName, pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 查询
     * @param sql  需要你执行的SQL语句
     * @param param ？的参数（可有可无）
     * @return  返回结果集（rs）
     */
    public ResultSet getExecuteQuery(String sql, Object... param) {
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            if (param != null && param.length > 0) {
                for (int i = 0; i < param.length; i++) {
                    //给SQL语句中的？占位符设置值
                    pstmt.setObject((i + 1), param[i]);
                }
            }
            //返回执行对象
            rs = pstmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    /**
     * 删除    修改  添加
     * @param sql   需要你执行的SQL语句
     * @param param  ？的参数（可有可无）
     * @return  返回受影响的行数
     */
    public int getExecuteUpdate(String sql,Object...param){
        try {
            conn=getConnection();
            pstmt=conn.prepareStatement(sql);
            if (param!=null&&param.length>0){
                for (int i = 0; i <param.length ; i++) {
                    pstmt.setObject((i+1),param[i]);
                }
            }
            return pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭
            closeAll();
        }
        return -1;
    }

    /**
     * 关闭所有
     */
    public void closeAll(){
        try {
            if (rs!=null){
                rs.close();
            }
            if (pstmt!=null){
                pstmt.close();
            }
            if (conn!=null){
                conn.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}