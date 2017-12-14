package com.xs.tencent;

public class TencentAPI {
	//自己的APPID
	public static final Integer APP_ID_AI = 123456;
	//自己的APPKEY
	public static final String APP_KEY_AI = "自己的key";
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
	//语音合成-AI LAB
	public static final String AAI_TTS = "https://api.ai.qq.com/fcgi-bin/aai/aai_tts";
	//语音识别-echo版
	public static final String AAI_ASR = "https://api.ai.qq.com/fcgi-bin/aai/aai_asr";
}
