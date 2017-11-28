package com.xs.tencent;

public class TencentAPI {
	//自己的APPID
	public static final Integer APP_ID_AI = 132465;
	//自己的APPKEY
	public static final String APP_KEY_AI = "123456";
	/**
	 * 人脸检测接口地址
	 */
	public static final String FACE_DETECT = "https://api.ai.qq.com/fcgi-bin/face/face_detectface";
	/**
	 * 人脸美妆接口地址
	 */
	public static final String FACE_COSMETIC = "https://api.ai.qq.com/fcgi-bin/face/face_detectface";
	/**
	 * 人脸变装
	 */
	public static final String FACE_DECORATION = "https://api.ai.qq.com/fcgi-bin/ptu/ptu_facedecoration";
	//身份证识别接口地址
	public static final String OCR_IDCARD = "https://api.ai.qq.com/fcgi-bin/ocr/ocr_idcardocr";
	public static final String OCR_GENERAL = "https://api.ai.qq.com/fcgi-bin/ocr/ocr_generalocr";
	//基本文本分析-分词接口地址
	public static final String NLP_WORDSEG = "https://api.ai.qq.com/fcgi-bin/nlp/nlp_wordseg";
}
