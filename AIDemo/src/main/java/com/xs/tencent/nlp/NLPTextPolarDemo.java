package com.xs.tencent.nlp;

import java.net.URLEncoder;
import java.util.HashMap;

import com.xs.tencent.TencentAPI;
import com.xs.tencent.sign.TencentAISign;
import com.xs.tencent.sign.TencentAISignSort;
import com.xs.util.baidu.HttpUtil;

public class NLPTextPolarDemo {
	public static void main(String[] args) throws Exception {
		//时间戳
		String time_stamp = System.currentTimeMillis()/1000+"";
		String text = new String("今天天气不错呀");
		//随机字符串
		String nonce_str = TencentAISign.getRandomString(10);
		//计算SIGN
		HashMap<String, String> bodys = new HashMap<String, String>();
		bodys.put("app_id","1106471787");
		bodys.put("time_stamp",time_stamp);
		bodys.put("nonce_str", nonce_str);
		bodys.put("text", text);
		String sign = TencentAISignSort.getSignature(bodys);
		System.out.println("sign==="+sign);
		bodys.put("sign", sign);
		String params = TencentAISignSort.getParams(bodys);
		System.out.println(params);
		System.out.println("发送的参数");
		//如果乱码。请把HttpUtil的post方法中判断接口包含nlp更改编码格式的代码注释掉
		String result = HttpUtil.post(TencentAPI.NLP_TEXTPOLAR, params);
		System.out.println(result);
	}
}