/**
* Copyright(C) 2014
*
* 模块名称：     
* 子模块名称：   
*
* 备注：
*
* 修改历史：
* 2014-1-26	1.0		李玮		新建
*/
package cn.edu.hbcit.minicms.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.log4j.Logger;

import cn.edu.hbcit.minicms.model.Passport;

/**
 * 登入登出类
 * 简要说明:
 * @author 李玮
 * @version 1.00  2014-1-26下午06:12:37	新建
 */

public class Login {
	protected final static Logger log = Logger.getLogger(Login.class.getName());
/**
 * 方法命名规约
 * 方法种类							开头词汇		例
 * 取得变量的值						get			getProperty
 * 设定变量的值						set			setProperty
 * 追加/新增对象的属性或对象			add			addMember
 * 删除对象的属性或对象				remove		removeMember
 * 检索对象的属性或对象				select		selectMember
 * 更新对象的属性或对象				update		updateMember
 * 判断状态或类型，并且返回布尔类型	is			isModified
 * 判断执行的可能性					can			canModify
 */
	public boolean login(String userName, String password){
		boolean flag = false;
		ArrayList<Passport> list = null;
		int count = 0;
		try {
			Connection conn = ConnectDb.Connect();
			Passport passport = null;
			QueryRunner qr = new QueryRunner();
			
			String sql = "SELECT * FROM passport WHERE username=? AND password=?";
			list = (ArrayList<Passport>)qr.query(conn, sql, new BeanListHandler(Passport.class),userName,password);
			
			for (Passport p : list){
				count++;
			}
			
			if(count > 0){
				flag = true;
			}
			//关闭连接
			DbUtils.closeQuietly(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}
}
