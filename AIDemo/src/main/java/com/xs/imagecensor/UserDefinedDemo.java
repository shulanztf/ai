package com.xs.imagecensor;

import java.net.URLEncoder;

import com.alibaba.fastjson.JSON;
import com.xs.pojo.imagecensor.UserDefinedBean;
import com.xs.util.baidu.Base64Util;
import com.xs.util.baidu.FileUtil;
import com.xs.util.baidu.HttpUtil;

/**
 * 图像审核接口示例代码
 * 
 * @author 小帅丶
 *
 */
public class UserDefinedDemo {
	private static String ACCESS_TOKEN = "24.a81c9e8a323c346000b88823ec7cb76e.2592000.1532066348.282335-11419576";

	public static void main(String[] args) throws Exception {
//		String imagePath = "D:\\data\\images\\mon (15).jpg";
//		String imagePath = "D:\\data\\images\\timg.jpg";//586
		String imagePath = "D:\\data\\images\\timg (1).jpg";
		// 返回字符串
		String result = getUserDefinedResult(imagePath, ACCESS_TOKEN);
		System.out.println(result);
		// 返回java对象
		UserDefinedBean userDefinedBean = getUserDefinedBean(imagePath, ACCESS_TOKEN);
		System.out.println("图像审核结果:"+JSON.toJSONString(userDefinedBean));
//		System.out.println(userDefinedBean.getData().get(0).getMsg());
//		System.out.println(userDefinedBean.getData().get(0).getStars().get(0).getName());
	}

	/**
	 * 图像审核识别Demo
	 * 
	 * @param imagePath
	 * @param accessToken
	 * @return 字符串
	 * @throws Exception
	 */
	public static String getUserDefinedResult(String imagePath, String accessToken) throws Exception {
		byte[] imgData = FileUtil.readFileByBytes(imagePath);
		String imgStr = Base64Util.encode(imgData);
		String param = "image=" + URLEncoder.encode(imgStr, "UTF-8");
		// String jsonParam = "{\"top_num\":5,\"image\":\"图片的base64\"}";
		// 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间，
		// 客户端可自行缓存，过期后重新获取。
		String result = HttpUtil.post(ImageCensorConsts.ANTI_USER_DEFINED_URL, accessToken, param);
		System.out.println(result);
		return result;
	}

	/**
	 * 图像审核识别Demo
	 * 
	 * @param imagePath
	 * @param accessToken
	 * @return UserDefinedBean
	 * @throws Exception
	 */
	public static UserDefinedBean getUserDefinedBean(String imagePath, String accessToken) throws Exception {
		byte[] imgData = FileUtil.readFileByBytes(imagePath);
		String imgStr = Base64Util.encode(imgData);
		String param = "image=" + URLEncoder.encode(imgStr, "UTF-8");
		// String jsonParam = "{\"top_num\":5,\"image\":\"图片的base64\"}";
		// 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间，
		// 客户端可自行缓存，过期后重新获取。
		String result = HttpUtil.post(ImageCensorConsts.ANTI_USER_DEFINED_URL, accessToken, param);
		UserDefinedBean userDefinedBean = JSON.parseObject(result, UserDefinedBean.class);
		return userDefinedBean;
	}
}
