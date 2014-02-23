/**
* Copyright(C) 2014
*
* 模块名称：     
* 子模块名称：   
*
* 备注：
*
* 修改历史：
* 2014-1-28	1.0		李玮		新建
*/
package cn.edu.hbcit.minicms.dao;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONStringer;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.log4j.Logger;

import cn.edu.hbcit.minicms.model.Article;
import cn.edu.hbcit.minicms.util.UtilTools;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 新闻处理类
 * 简要说明:
 * @author 李玮
 * @version 1.00  2014-1-28下午04:38:51	新建
 */

public class NewsDAO {
	protected final Logger log = Logger.getLogger(NewsDAO.class.getName());
	/**
	 * 查找前10条新闻标题和时间
	 * @return
	 */
	public JSONArray selectTop10NewsTitleJSON(){
		JSONArray finalJson = new JSONArray();
		ArrayList<Article> list = null;
		try {
			Connection conn = ConnectDb.Connect();
			Article article = new Article();
			QueryRunner qr = new QueryRunner();
			String sql = "SELECT id,title,publishtime,author,content,type,shorttime,viewcount FROM article  ORDER BY id DESC limit 0,10";
			
			list = (ArrayList<Article>)qr.query(conn, sql, new BeanListHandler(Article.class));
			
			for(Article a : list){
				JSONObject json = new JSONObject();
				json.element("id", a.getId());
				json.element("title", a.getTitle());
				json.element("time", a.getShorttime());
				finalJson.add(json);
			}
			DbUtils.closeQuietly(conn);//关闭连接
			log.debug(finalJson.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return finalJson;
	}

	public JSONArray selectNewsById(int id){
		JSONArray finalJson = new JSONArray();
		ArrayList<Article> list = null;
		UtilTools ut = new UtilTools();
		try {
			Connection conn = ConnectDb.Connect();
			Article article = new Article();
			QueryRunner qr = new QueryRunner();
			String sql = " SELECT id,title,publishtime,author,content,type,shorttime,viewcount FROM article WHERE id = ? ";
			
			list = (ArrayList<Article>)qr.query(conn, sql, new BeanListHandler(Article.class), id);
			
			for(Article a : list){
				JSONObject json = new JSONObject();
				json.element("id", a.getId());
				json.element("title", a.getTitle());
				json.element("time", a.getShorttime());
				json.element("author", a.getAuthor());
				json.element("content", ut.string2Json(a.getContent()));//ut.string2Json(String)
				json.element("viewcount", a.getViewcount());
				finalJson.add(json);
			}
			DbUtils.closeQuietly(conn);//关闭连接
			log.debug(finalJson.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return finalJson;
	}
}
