package com.baidu.aip.nlp;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @Title: AipNlpTest
 * @Description:
 * @Author: zhaotf
 * @Since:2018年6月20日 下午2:50:23
 */
public class AipNlpTest {
	private static String appId="11420017";
	private static String apiKey="Dvbe9XBCXDdtV5gMUlSLDx6b"; 
	private static String secretKey="xIfwyhoMRDnoUEr08Wc7uuIN7ELBTSNF ";

	public static void main(String[] args) {
//		AipNlp
		AipNlpTest test = new AipNlpTest();
		test.sentimentClassify();
	}
	
	 /**
     * TODO,情感倾向分析接口
     * 对包含主观观点信息的文本进行情感极性类别（积极、消极、中性）的判断，并给出相应的置信度。
     *
     * @param text - 文本内容（GBK编码），最大102400字节
     * @param options - 可选参数对象，key: value都为string类型
     * options - options列表:
     * @return JSONObject
     */
    public void sentimentClassify() {
    	String text = "毛泽东";
    	AipNlp nlp = new AipNlp(appId,apiKey,secretKey);
    	System.out.println("昵称审核-文本分析:"+JSON.toJSONString(nlp.sentimentClassify(text, null)));
    	
    }
	
}
