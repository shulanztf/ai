package com;

import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.ocr.AipOcr;

/**
 * @Title: SimpleTextTest
 * @Description: 百度人工智能-文本审核
 * @Author: zhaotf
 * @Since:2018年6月20日 下午4:20:50
 * @see {@linkplain https://ai.baidu.com/docs#/TextCensoring-API/top}
 * @see {@linkplain http://ai.baidu.com/docs#/TextCensoring-API/top}
 * @see {@linkplain https://blog.csdn.net/larger5/article/details/79652778}
 */
public class SimpleTextTest {

	// 设置APPID/AK/SK：百度云自己的帐号信息
	public static final String APP_ID = "11419576";
	public static final String API_KEY = "uVQRxIWNCGjRp0pzYlVZOI15";
	public static final String SECRET_KEY = "MKWlGV4XKQ2mOPjqv93YbIQQUQXO3ezD";

	public static void main(String[] args) {

		AipContentCensor censor = new AipContentCensor(APP_ID, API_KEY, SECRET_KEY); 
		AipContentCensor.antiSpam
		
		// 初始化一个AipOcr
		AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

		HashMap<String, String> options = new HashMap<String, String>();

		options.put("detect_direction", "true");
		/**
		 * 是否开启身份证风险类型(身份证复印件、临时身份证、身份证翻拍、修改过的身份证)功能， 默认不开启，即：false。
		 * 可选值:true-开启；false-不开启
		 */
		options.put("detect_risk", "false");
		/**
		 * front：身份证含照片的一面 back：身份证带国徽的一面 必须正确声明，否则"error_msg":
		 * "recognize id card error"
		 */
		String idCardSide = "front";
		// 本地图片
		String path = "C:\\LLLLLLLLLLLLLLLLLLL\\a5a578D.jpg";
		// idcard 表示读取图片的类型是身份证
		JSONObject res = client.idcard(path, idCardSide, options);
		System.out.println(res.toString(2));
	}
}
