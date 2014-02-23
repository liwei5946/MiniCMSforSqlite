/**
* Copyright(C) 2014
*
* 模块名称：     
* 子模块名称：   
*
* 备注：
*
* 修改历史：
* 2014-1-26	1.0		liwei5946@gmail.com		新建
*/
package cn.edu.hbcit.minicms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import cn.edu.hbcit.minicms.dao.Login;
import cn.edu.hbcit.minicms.util.PasswordEncodeBean;

/**
 * 移动端登录控制类
 * 简要说明:
 * @author liwei5946@gmail.com
 * @version 1.00  2014-1-26下午07:21:13	新建
 */

public class MobileLoginServlet extends HttpServlet {
	protected final static Logger log = Logger.getLogger(MobileLoginServlet.class.getName());

	/**
	 * Constructor of the object.
	 */
	public MobileLoginServlet() {
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
		Boolean flag = false;
		Login login = new Login();
		PasswordEncodeBean encode = new PasswordEncodeBean();
		String userName = request.getParameter("un");
		String password = request.getParameter("pw");
		flag = login.login(userName, encode.MD5Encode(password));
		log.debug("登录结果是：" + flag);
		out.print(flag);
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
