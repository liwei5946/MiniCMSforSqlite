package cn.edu.hbcit.minicms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.*;

import cn.edu.hbcit.minicms.util.OperateProperties;

/**
 * 数据库连接类
 * 简要说明:
 * @author 李玮
 * @version 1.00  2014-1-26下午05:53:28	新建
 */

public class ConnectDb {
	protected final static Logger log = Logger.getLogger(ConnectDb.class.getName());
	private static OperateProperties op = new OperateProperties();//Properties文件操作
	private static String path = op.readValue("/db.properties", "path");
	private static String driveClassName = "org.sqlite.JDBC";
	private static String url = "jdbc:sqlite:" + path + "\\minicms.db"; 
	
	
	public static Connection Connect(){
		Connection conn = null;
		//load driver
		log.debug(driveClassName);
		log.debug(url);
		try {
			Class.forName(driveClassName);
		} catch (ClassNotFoundException  e) {
			log.debug("Load driver failed!");
			e.printStackTrace();
		}
		
		//connect db
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			log.debug("Connect failed!");
			e.printStackTrace();
		}		
		return conn;
	}
}
