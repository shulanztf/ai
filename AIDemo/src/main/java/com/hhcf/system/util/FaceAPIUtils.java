package com.hhcf.system.util;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.methods.CloseableHttpResponse;

import com.xs.util.baidu.Base64Util;
import com.xs.util.baidu.FileUtil;
import com.xs.util.baidu.HttpUtil;

/**
 * @Title: FaceAPIUtils
 * @Description:
 * @Author: zhaotf
 * @Since:2018年6月21日 上午10:38:29
 * @see {@linkplain https://blog.csdn.net/zmx729618/article/details/78132942}
 * @see {@linkplain https://ai.baidu.com/docs#/TextCensoring-API/top}
 * @see {@linkplain https://ai.baidu.com/docs#/ImageCensoring-API/top}
 */
public class FaceAPIUtils {
	static String TEXT_ACCESS_TOKEN = "24.50e1e9db26d210dfef76b9843a1c8bbe.2592000.1532068869.282335-11420017";
	static String IMGAE_ACCESS_TOKEN = "24.a81c9e8a323c346000b88823ec7cb76e.2592000.1532066348.282335-11419576";

	public static void main(String[] args) {
		// getToKenTest() ;
		// faceDetecttest();
		// textValidate();
		imagesValidate();
	}

	/**
	 * 获取token
	 */
	public static void getToKenTest() {
		// String APPID = "11419576"; // 管理中心获得
		String API_KEY = "uVQRxIWNCGjRp0pzYlVZOI15"; // 百度人脸识别应用apikey
		String SERCET_KEY = "MKWlGV4XKQ2mOPjqv93YbIQQUQXO3ezD"; // 百度人脸识别应用sercetkey
		// 使用其测试百度云API---获取token
		// url: http://console.bce.baidu.com/ai
		String access_token_url = "https://aip.baidubce.com/oauth/2.0/token?grant_type=client_credentials"
				+ "&client_id=" + API_KEY + "&client_secret=" + SERCET_KEY;
		CloseableHttpResponse response = HttpClientUtils.doHttpsGet(access_token_url, null);
		// 百度人脸识别token 有效期一个月
		String accessToken = HttpClientUtils.toString(response);
		System.out.println("百度token:" + accessToken);
	}

	/**
	 * 文本审核
	 * 
	 * @see {@linkplain https://ai.baidu.com/docs#/TextCensoring-API/top}
	 */
	public static void faceDetecttest() {
		String token = "24.1d786b9cdbdd8ac7cf55d56c7f38372b.2592000.1509244497.282335-10201425";
		String Filepath = "E:/test.jpg";
		String image = Base64ImageUtils.GetImageStrFromPath(Filepath);
		String url = "https://aip.baidubce.com/rest/2.0/antispam/v2/spam?access_token=" + token;

		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/x-www-form-urlencoded");

		Map<String, String> bodys = new HashMap<String, String>();
		bodys.put("image", image);
		bodys.put("face_fields", "age,beauty,expression,gender,glasses,race,qualities");

		try {
			CloseableHttpResponse response = HttpClientUtils.doHttpsPost(url, headers, bodys);
			System.out.println("人脸识别:" + HttpClientUtils.toString(response));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 文本审核
	 */
	public static void textValidate() {
		String content = "苟利国家生死以";
		String url = "https://aip.baidubce.com/rest/2.0/antispam/v2/spam?access_token=" + TEXT_ACCESS_TOKEN;

		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/x-www-form-urlencoded");

		Map<String, String> bodys = new HashMap<String, String>();
		bodys.put("content", content);

		try {
			CloseableHttpResponse response = HttpClientUtils.doHttpsPost(url, headers, bodys);
			System.out.println("文本审核:" + HttpClientUtils.toString(response));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 图片审核
	 * 
	 * void
	 */
	public static void imagesValidate() {
		String url = "https://aip.baidubce.com/rest/2.0/solution/v1/img_censor/user_defined";
		try {
			// 本地文件路径
			// String filePath = "D:\\data\\images\\timg (5).jpg";
			String filePath = "D:\\data\\images\\u=1721316670,1149575775&fm=173&app=25&f=JPEG.jpg";
			byte[] imgData = FileUtil.readFileByBytes(filePath);
			String imgStr = Base64Util.encode(imgData);
			String imgParam = URLEncoder.encode(imgStr, "UTF-8");

			String param = "image=" + imgParam;

			String result = HttpUtil.post(url, IMGAE_ACCESS_TOKEN, param);
			System.out.println("图像审核:" + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
