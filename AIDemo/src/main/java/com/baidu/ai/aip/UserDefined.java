package com.baidu.ai.aip;

import java.net.URLEncoder;

import com.xs.util.baidu.Base64Util;
import com.xs.util.baidu.FileUtil;
import com.xs.util.baidu.HttpUtil;

/**
 * 图像审核接口
 */
public class UserDefined {

	// 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间，
	// 客户端可自行缓存，过期后重新获取。
	static String accessToken = "24.a81c9e8a323c346000b88823ec7cb76e.2592000.1532066348.282335-11419576";
	/**
	 * 重要提示代码中所需工具类 FileUtil,Base64Util,HttpUtil,GsonUtils请从
	 * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
	 * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
	 * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
	 * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3 下载
	 */
	public static String userDefined() {
		// 请求url
		String url = "https://aip.baidubce.com/rest/2.0/solution/v1/img_censor/user_defined";

		try {
			// 本地文件路径
//			String filePath = "D:\\data\\images\\timg (5).jpg";
			String filePath = "D:\\data\\images\\u=1721316670,1149575775&fm=173&app=25&f=JPEG.jpg";
			byte[] imgData = FileUtil.readFileByBytes(filePath);
			String imgStr = Base64Util.encode(imgData);
			String imgParam = URLEncoder.encode(imgStr, "UTF-8");

			String param = "image=" + imgParam;


			String result = HttpUtil.post(url, accessToken, param);
			System.out.println("图像审核:" + result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		UserDefined.userDefined();
	}

}
