package com.common.core.util;

import java.io.UnsupportedEncodingException;

/**
 * 字符串操作处理组件
 */
public class StringUtils {

	/**
	 * 对获取的字符串检查是否为空。
	 * @param p_String 一个String。
	 * @return String 如果为空则返回"",如果不为空则返回p_String本身。
	 */
	public static String checkNullString(String p_String){
		if (p_String == null)
			return "";
		else
			return p_String;
	}

	/**
	 * 返回 Object 参数的字符串表示形式。
	 * @param p_obj 一个Object。
	 * @return String 如果该对象为null,则返回"";否则返回p_obj.toString()的值。
	 */
	public static String checkNullString(Object p_obj){
		if (p_obj == null)
			return "";
		else
			return p_obj.toString();
	}

	/**
	 * 两个字符串内容是否一样。
	 * @param src 源字符串。
	 * @param dest 目标字符串。
	 * @return 如果相同则返回true,否则返回false。
	 */
	public static boolean compareEqualsString(String src, String dest){
		src = checkNullString(src).toLowerCase();
		dest = checkNullString(dest).toLowerCase();
		if (src.equals(dest))
			return true;
		else
			return false;
	}
	
	/**
	 * 按照指定的编码类型对对字符串编码
	 * @param str 需编码的字符串
	 * @param _codeType  编码类型 例如:UTF-8
	 * @return 返回编码后的字符串
	 */
	public static String encoder(String str,String _codeType) {
		if (str == null || str.length() < 1) {
			str = "";
		} else {
			try {
				str = new String(str.getBytes("iso-8859-1"), _codeType);
			} catch (UnsupportedEncodingException e) {
				return str;
			}
		}
		return str;
	}
	
	/**
	 * 转换指定编码的字符串
	 * @param str 源字符串
	 * @return 返回指定编码字符串
	 */
	public static String getEncoderStr(String str, String code) {
		if (str == null || str.length() < 1) {
			str = "";
		} else {
			try {
				str = (new String(str.getBytes(code)));
			} catch (Exception e) {
				e.printStackTrace();
				return str;
			}
		}
		return str;
	}
	
    /**
     * 将字符串截取为一定长度的字符串，对于大于该字符串长度的部分截掉，后边添加'...'
     * @param string           待截取的字符串
     * @param maxLength      假设该title全部为中文字符的最大长度
     * @return
     */
    public static String trunk(String string, int maxLength) 
    {
        try {
			char[] ca = string.toCharArray();
			int iMaxlength = maxLength * 2;
			int iTotalLength = 0;
			int i = 0;
			int j = 0;
			for (; i < ca.length; i++) {
				if (ca[i] > 128)
					iTotalLength += 2;
				else
					iTotalLength += 1;

				if ((j == 0) && (iTotalLength >= iMaxlength - 4))
					j = i;

				if (iTotalLength > iMaxlength)
					break;
			}

			if (iTotalLength <= iMaxlength) //未超出最大长度。

				return string;

			StringBuffer buf = new StringBuffer(string);
			buf.setLength(j + 1);
			buf.append("...");

			return buf.toString();
			
		} catch (Exception e) {
			return "";
		}
    }	
	
	/**
	 * 将字符串改成json字符串
	 * @param s
	 * @return
	 */
	public static String string2Json(String s) { 
	    StringBuilder sb = new StringBuilder(s.length()+20); 
	    sb.append('\"'); 
	    for (int i=0; i<s.length(); i++) { 
	        char c = s.charAt(i); 
	        switch (c) { 
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
	    sb.append('\"'); 
	    return sb.toString(); 
	 }
}
