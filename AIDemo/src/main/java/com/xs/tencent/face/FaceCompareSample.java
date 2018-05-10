package com.xs.tencent.face;

import java.util.HashMap;

import com.xs.tencent.TencentAPI;
import com.xs.tencent.sign.TencentAISign;
import com.xs.tencent.sign.TencentAISignSort;
import com.xs.util.baidu.Base64Util;
import com.xs.util.baidu.FileUtil;
import com.xs.util.baidu.HttpUtil;

public class FaceCompareSample {
		public static void main(String[] args) throws Exception {
		//时间戳
		String time_stamp = System.currentTimeMillis()/1000+"";
		//图片的二进制数组数据
		byte [] imageData = FileUtil.readFileByBytes("G:/test2.jpg");
		//图片的base64编码数据
		String img64 = Base64Util.encode(imageData);
		//随机字符串
		String nonce_str = TencentAISign.getRandomString(10);
		//参数拼接
		HashMap<String, String> bodys = new HashMap<String, String>();
		bodys.put("app_id",TencentAPI.APP_ID_AI.toString());
		bodys.put("time_stamp",time_stamp);
		bodys.put("nonce_str", nonce_str);
		bodys.put("image_a", img64);
		bodys.put("image_b",img64);
		//计算SIGN
		String sign = TencentAISignSort.getSignature(bodys);
		bodys.put("sign", sign);
		String param = TencentAISignSort.getParams(bodys);
		String result = HttpUtil.post("https://api.ai.qq.com/fcgi-bin/face/face_facecompare", param);
		System.out.println(result);
	}
}
