/**
* Copyright(C) 2014
*
* 模块名称：     
* 子模块名称：   
*
* 备注：
*
* 修改历史：
* 2014-1-29	1.0		李玮		新建
*/
package cn.edu.hbcit.minicms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import cn.edu.hbcit.minicms.dao.NewsDAO;
import cn.edu.hbcit.minicms.util.UtilTools;

/**
 * 根据ID查询新闻内容类
 * 简要说明:
 * @author 李玮
 * @version 1.00  2014-1-29上午12:19:54	新建
 */

public class SelectNewsById extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SelectNewsById() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("utf-8");
		JSONArray json = new JSONArray();
		NewsDAO nd = new NewsDAO();
		UtilTools ut = new UtilTools();
		
		String newsId = request.getParameter("nid");
		if(ut.isNumeric(newsId)){
			json = nd.selectNewsById(Integer.parseInt(newsId));
			out.print(json);
		}
		
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
