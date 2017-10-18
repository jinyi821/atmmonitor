package com.common.core.web;

import java.io.StringReader;
import java.io.StringWriter;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.blogspot.radialmind.html.HTMLParser;
import com.blogspot.radialmind.xss.XSSFilter;

public class XssHttpServletRequestWrapperNew extends HttpServletRequestWrapper {
	HttpServletRequest orgRequest = null;
	Map params;
	static List<String> unXssParameterNamelist = new ArrayList<String>(); // 不进行xss拦截参数名称集合
	static {
		unXssParameterNamelist.add("taskName");

	}

	public XssHttpServletRequestWrapperNew(HttpServletRequest request, Map newParams) {
		super(request);
		orgRequest = request;
		params = newParams;
	}

	/**
	 * 覆盖getParameter方法，将参数名和参数值都做xss过滤。
	 * 如果需要获得原始的值，则通过super.getParameterValues(name)来获取
	 * getParameterNames,getParameterValues和getParameterMap也可能需要覆盖
	 */
	@Override
	public String getParameter(String name) {
		String value = super.getParameter(xssEncode(name));
		if (!name.equals("param") && value != null) {
			value = xssEncode(value);
			if (!unXssParameterNamelist.contains(name)) {
				value = HTMLEncode(value);
			}
		}
		return value;
	}

	public Enumeration getParameterNames() {
		Vector l = new Vector(params.keySet());
		return l.elements();
	}

	public String[] getParameterValues(String name) {
		Object v = params.get(xssEncode(name));
		if (v == null) {
			return null;
		} else if (v instanceof String[]) {
			String[] value = (String[]) v;
			if (!unXssParameterNamelist.contains(name)) {
				for (int i = 0; i < value.length; i++) {
					value[i] = xssEncode(value[i]);
					value[i] = HTMLEncode(value[i]);
				}
			}
			return (String[]) value;
		} else if (v instanceof String) {
			String value = (String) v;
			value = xssEncode(value);
			value = HTMLEncode(value);
			return new String[] { (String) value };
		} else {
			return new String[] { v.toString() };
		}
	}

	public Map getParameterMap() {
		return params;
	}

	/**
	 * 覆盖getHeader方法，将参数名和参数值都做xss过滤。 如果需要获得原始的值，则通过super.getHeaders(name)来获取
	 * getHeaderNames 也可能需要覆盖
	 */
	/*
	 * @Override public String getHeader(String name) { String value =
	 * super.getHeader(xssEncode(name)); if (value != null) { value =
	 * xssEncode(value); } return value; }
	 * 
	 * @Override public Enumeration getHeaderNames() { return
	 * super.getHeaderNames(); }
	 */
	/**
	 * 将容易引起xss漏洞的半角字符直接替换成全角字符
	 * 
	 * @param s
	 * @return
	 */
	private static String xssEncode(String s) {
		if (s == null || s.isEmpty()) {
			return s;
		}
		StringReader reader = new StringReader(s);
		StringWriter writer = new StringWriter();
		try {
			HTMLParser.process(reader, writer, new XSSFilter(), true);
			String result = writer.toString();
			// System.out.println("xssEncode-------------------------"+s+"="+result);
			return result;
		} catch (NullPointerException e) {
			return s;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * 对一些特殊字符进行转义
	 */
	public static String HTMLEncode(String aText) {
		final StringBuilder result = new StringBuilder();
		final StringCharacterIterator iterator = new StringCharacterIterator(aText);
		char character = iterator.current();
		while (character != CharacterIterator.DONE) {
			if (character == '<') {
				result.append("&lt;");
			} else if (character == '>') {
				result.append("&gt;");
			} else if (character == '&') {
				result.append("&amp;");
			}
			/*
			 * else if (character == '\"') { result.append("&quot;"); }
			 */
			else if (character == '\t') {
				addCharEntity(9, result);
			}
			/*
			 * else if (character == '!') { addCharEntity(33, result); }
			 */
			else if (character == '#') {
				addCharEntity(35, result);
			} else if (character == '$') {
				addCharEntity(36, result);
			} else if (character == '%') {
				addCharEntity(37, result);
			}
			/*
			 * else if (character == '\'') { addCharEntity(39, result); }else if
			 * (character == '(') { addCharEntity(40, result); } else if
			 * (character == ')') { addCharEntity(41, result); } else if
			 * (character == '*') { addCharEntity(42, result); }else if
			 * (character == '+') { addCharEntity(43, result); } else if
			 * (character == ',') { addCharEntity(44, result); } else if
			 * (character == '-') { addCharEntity(45, result); } else if
			 * (character == '.') { addCharEntity(46, result); }else if
			 * (character == '/') { addCharEntity(47, result); } else if
			 * (character == ':') { addCharEntity(58, result); } else if
			 * (character == ';') { addCharEntity(59, result); } else if
			 * (character == '=') { addCharEntity(61, result); } else if
			 * (character == '?') { addCharEntity(63, result); } else if
			 * (character == '@') { addCharEntity(64, result); } else if
			 * (character == '[') { addCharEntity(91, result); }
			 */
			/*
			 * else if (character == '\\') { addCharEntity(92, result); }
			 */
			/*
			 * else if (character == ']') { addCharEntity(93, result); }
			 */
			else if (character == '^') {
				addCharEntity(94, result);
			}
			/*
			 * else if (character == '_') { addCharEntity(95, result); }
			 */
			else if (character == '`') {
				addCharEntity(96, result);
			} else if (character == '{') {
				addCharEntity(123, result);
			} else if (character == '|') {
				addCharEntity(124, result);
			} else if (character == '}') {
				addCharEntity(125, result);
			} else if (character == '~') {
				addCharEntity(126, result);
			} else {
				// the char is not a special one
				// add it to the result as is
				result.append(character);
			}
			character = iterator.next();
		}
		return result.toString();
	}

	private static void addCharEntity(Integer aIdx, StringBuilder aBuilder) {
		String padding = "";
		if (aIdx <= 9) {
			padding = "00";
		} else if (aIdx <= 99) {
			padding = "0";
		} else {
			// no prefix
		}
		String number = padding + aIdx.toString();
		aBuilder.append("&#" + number + ";");
	}

	/**
	 * 获取最原始的request
	 */
	public HttpServletRequest getOrgRequest() {
		return orgRequest;
	}

	/**
	 * 获取最原始的request的静态方法
	 */
	public static HttpServletRequest getOrgRequest(HttpServletRequest req) {
		if (req instanceof XssHttpServletRequestWrapperNew) {
			return ((XssHttpServletRequestWrapperNew) req).getOrgRequest();
		}
		return req;
	}
}