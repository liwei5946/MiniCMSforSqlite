package cn.edu.hbcit.minicms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.*;

import cn.edu.hbcit.minicms.util.OperateProperties;
//import org.logicalcobwebs.proxool.ProxoolException;       
//import org.logicalcobwebs.proxool.ProxoolFacade;       
//import org.logicalcobwebs.proxool.admin.SnapshotIF;
import com.alibaba.druid.pool.DruidDataSource;

/**
 * 数据库连接类
 * 简要说明:
 * @author 李玮
 * @version 1.00  2014-1-26下午05:53:28	新建
 * @version 2.00 liwei 使用druid-1.0.2.jar
 */

public class ConnectDb {
	protected final static Logger log = Logger.getLogger(ConnectDb.class.getName());
	private static OperateProperties op = new OperateProperties();//Properties文件操作
	private static String path = op.readValue("/db.properties", "path");
	private static String driveClassName = "org.sqlite.JDBC";
	private static String url = "jdbc:sqlite:" + path + "\\minicms.db"; 
//	private static String driveClassName = "org.logicalcobwebs.proxool.ProxoolDriver";//proxool驱动类
//	private static int activeCount = 0; //活动连接数
	private static DruidDataSource dds ;
	
	public static Connection Connect(){
		Connection conn = null;
		
		//load driver
//		log.debug(driveClassName);
//		log.debug(url);
		try {
//			Class.forName(driveClassName);
			dds = new DruidDataSource();
			dds.setDriverClassName(driveClassName);
			dds.setUrl(url);
			dds.setInitialSize(5);
			dds.setMinIdle(1);
			dds.setMaxActive(20);
			dds.setFilters("stat");
			dds.setPoolPreparedStatements(false);
			dds.setValidationQuery("SELECT 'x'");
//			dds.setFilters("wall");//防SQL注入功能不支持sqlite
			
			conn = dds.getConnection();
		}catch (SQLException e) {
			log.debug("Connect failed! 请检查db.properties文件是否配置正确！");
			e.printStackTrace();
		}	
		
		//connect db
//		try {
//			conn = DriverManager.getConnection("proxool.minicms");//此处的minicms是在proxool.xml中配置的连接池别名
//			showSnapshotInfo(); //查看连接池信息
//		} catch (SQLException e) {
//			log.debug("Connect failed!");
//			e.printStackTrace();
//		}		
		return conn;
	}
	
	/**
	 * 获取连接池中的连接信息
	 */
//	private static void showSnapshotInfo(){
//        try{       
//            SnapshotIF snapshot = ProxoolFacade.getSnapshot("minicms", true);       
//            int curActiveCount=snapshot.getActiveConnectionCount();//获得活动连接数       
//            int availableCount=snapshot.getAvailableConnectionCount();//获得可得到的连接数       
//            int maxCount=snapshot.getMaximumConnectionCount() ;//获得总连接数      
//            if(curActiveCount!=activeCount)//当活动连接数变化时输出的信息       
//            {
//            	log.debug("活动连接数:"+curActiveCount+"(active)；\n可得到的连接数:"+availableCount+"(available)；\n总连接数:"+maxCount+"(max)");                 
//             activeCount=curActiveCount;       
//            }
//        }catch(ProxoolException e){       
//            e.printStackTrace(); 
//        }       
//    }
}
