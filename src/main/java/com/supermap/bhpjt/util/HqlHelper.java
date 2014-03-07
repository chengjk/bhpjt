package com.supermap.bhpjt.util;

import java.util.ArrayList;
import java.util.List;

public class HqlHelper {

	/**
	 * 逗号隔开的字符串转换为 between条件语句
	 * @return
	 */
	public static String strToBetween(String va){
		if(va==null||va.trim()=="")return null;
		va=va.replace("，", ",");
		String[] strs=va.split(",");
		return " '"+strs[0]+"' and '"+strs[1]+"' ";
	}
	/**
	 * 逗号隔开的字符串转换为 in条件语句
	 * @return
	 */
	public static List<String> strToIn(String va){
		if(va==null||va.trim()=="")return null;
		va=va.replace("，", ",");
		String[] strs=va.split(",");
		List<String> lst=new ArrayList<String>();
		int i=strs.length;
		while(i-->0){
			lst.add(strs[i]);
		}
		return lst;
	}
	/**
	 * 字符串转为 like 条件语句
	 * @param keys
	 * @return
	 */
	public static String strToLike(String keys){
		if(keys==null||keys.trim()==""){
			keys="%";
		}else{
			keys="%"+keys+"%";
		}
		return keys;
	}
	/**
	 * 字符串转为  = 条件
	 * @param keys
	 * @return
	 */
	public static String strToEqual(String key){
		if(key==null) key="";
		return key.trim();
	}
	/**
	 * 字符串转为  = 条件
	 * @param keys
	 * @return
	 */
	public static double strToDouble(String key){
		if(key==null||key.trim()==""){
			return 0;
		}
		return Double.parseDouble(key);
	}
}
