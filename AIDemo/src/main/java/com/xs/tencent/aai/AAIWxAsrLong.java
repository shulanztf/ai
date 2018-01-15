package com.xs.tencent.aai;

import java.util.HashMap;

import com.xs.tencent.HttpsUtil4Tencent;
import com.xs.tencent.TencentAPI;
import com.xs.tencent.sign.Base64Util;
import com.xs.tencent.sign.TencentAISign;
import com.xs.tencent.sign.TencentAISignSort;
import com.xs.util.baidu.FileUtil;
/**
 * 腾讯ai-长语音识别示例代码
 * @author 小帅丶
 */
public class AAIWxAsrLong {
	public static void main(String[] args) throws Exception {
		//时间戳
		String time_stamp = System.currentTimeMillis()/1000+"";
		//语音的base64数据
		String voicebase64 =Base64Util.encode(FileUtil.readFileByBytes("C:/Users/Administrator/text2audio/VOICE1513237078.pcm"));
		//随机字符串
		String nonce_str = TencentAISign.getRandomString(10);
		HashMap<String, String> bodys = new HashMap<String, String>();
		bodys.put("app_id","1106471787");
		bodys.put("time_stamp",time_stamp);
		bodys.put("nonce_str", nonce_str);
		//格式自行参考文档说明
		bodys.put("format", "1");
		//回调地址 最好是外网访问的哦
		bodys.put("callback_url","http://zxshuai.imwork.net/PaymentManager/txnotify");
		bodys.put("speech", voicebase64);
		//计算SIGN
		String sign = TencentAISignSort.getSignature(bodys);
		bodys.put("sign", sign);
		//拼接参数
		String param = TencentAISignSort.getParams(bodys);
		param = param.substring(0, param.length()-1);
		System.out.println(param);
		//接口返回数据
		String result = HttpsUtil4Tencent.getforVoice(TencentAPI.AAI_WXASRLONG, param);
		System.out.println(result);
	}
}
