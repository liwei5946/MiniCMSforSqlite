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
package cn.edu.hbcit.minicms.model;

public class Article {
	private int id;
	private String title;
	private String publishtime;
	private String author;
	private String content;
	private int type;
	private String shorttime;
	private int viewcount;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the publishtime
	 */
	public String getPublishtime() {
		return publishtime;
	}
	/**
	 * @param publishtime the publishtime to set
	 */
	public void setPublishtime(String publishtime) {
		this.publishtime = publishtime;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}
	/**
	 * @return the shorttime
	 */
	public String getShorttime() {
		return shorttime;
	}
	/**
	 * @param shorttime the shorttime to set
	 */
	public void setShorttime(String shorttime) {
		this.shorttime = shorttime;
	}
	/**
	 * @return the viewcount
	 */
	public int getViewcount() {
		return viewcount;
	}
	/**
	 * @param viewcount the viewcount to set
	 */
	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}
}
