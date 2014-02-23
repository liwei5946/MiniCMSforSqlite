package cn.edu.hbcit.minicms.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilTools {
	/**
	 * 判断字符串是否为整型
	 * @param str
	 * @return
	 */
	public boolean isNumeric(String str)
	{
	Pattern pattern = Pattern.compile("[0-9]*");
	Matcher isNum = pattern.matcher(str);
	if( !isNum.matches() ){
		return false;
	}
		return true;
	} 
	/*
	 * 在access数据库中，将Memo备注型字段里的数据完整取出
	 * @param InputStream
	 * @return StringBuilder
	 */
	public StringBuilder accessdbMemoToString(InputStream in)
	{
		BufferedReader reader=new BufferedReader(new InputStreamReader(in));
		StringBuilder sb=new StringBuilder();
		String line=null;
		try {
		while((line=reader.readLine())!=null){
			sb.append(line);
			}
		} catch (IOException e) {
		e.printStackTrace();
		  }
		return sb;
	}
	
	/**
     * JSON字符串特殊字符处理，比如：“\A1;1300”
     * @param s
     * @return String
     */
    public String string2Json(String s) {      
        StringBuffer sb = new StringBuffer();      
        for (int i=0; i<s.length(); i++) {
        	char c = s.charAt(i);  
        	 switch (c){
        	 case '\"':      
                 sb.append("\\\"");      
                 break;      
             case '\\':      
                 sb.append("\\\\");      
                 break;      
             case '/':      
                 sb.append("\\/");      
                 break;      
             case '\b':      
                 sb.append("\\b");      
                 break;      
             case '\f':      
                 sb.append("\\f");      
                 break;      
             case '\n':      
                 sb.append("\\n");      
                 break;      
             case '\r':      
                 sb.append("\\r");      
                 break;      
             case '\t':      
                 sb.append("\\t");      
                 break;      
             default:      
                 sb.append(c);   
        	 }
         }    
        return sb.toString();   
        }

}
