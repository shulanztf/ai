package com.xs.unit;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import com.xs.common.APIContants;
import com.xs.pojo.BDAccessToken;
import com.xs.util.baidu.AIUtil;
import com.xs.util.baidu.HttpUtil;
import com.xs.util.baidu.HttpUtils;

public class UnitUtteranceSample {
	
	public static String UNITUTTERANCE_URL = "https://aip.baidubce.com/rpc/2.0/solution/v1/unit_utterance";
	public static void main(String[] args) throws Exception {
		//你自己的场景ID
		Integer scene_id = 123456;
		String query = "好看的科幻片";
		String session_id = "";
		HttpUtil httpUtil = new HttpUtil();
		com.xs.pojo.unit.UnitUtterance unitUtterance = new com.xs.pojo.unit.UnitUtterance();
		unitUtterance.setScene_id(scene_id);
		unitUtterance.setSession_id("");
		unitUtterance.setQuery(URLEncoder.encode(query, "utf-8"));
		JSONObject paramsObject = JSONObject.fromObject(unitUtterance);
		String data = httpUtil.postUnit(UNITUTTERANCE_URL,APIContants.UNIT_TOKEN,paramsObject.toString());
		System.out.println(URLDecoder.decode(data, "UTF-8"));
//		HttpUtils httpUtils = new HttpUtils();
//		String data2 = httpUtils.sendPostUrl(UNITUTTERANCE_URL, params,"UTF-8");
//		System.out.println(data2);
		
	}
}
