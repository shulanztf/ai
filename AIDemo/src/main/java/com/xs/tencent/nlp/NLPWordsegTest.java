package com.xs.tencent.nlp;

import java.util.HashMap;

import com.xs.tencent.TencentAPI;
import com.xs.tencent.sign.TencentAISign;
import com.xs.tencent.sign.TencentAISignSort;
import com.xs.util.baidu.HttpUtil;

/**
 * 腾讯AI 基本文本分析-分词接口示例代码
 * @author 小帅丶
 * @date 2017年11月28日
 */
public class NLPWordsegTest {
	public static void main(String[] args) throws Exception {
		//时间戳
		String time_stamp = System.currentTimeMillis()/1000+"";
		String text = new String("腾讯人工智能");
		//随机字符串
		String nonce_str = TencentAISign.getRandomString(10);
		//计算SIGN
		HashMap<String, String> bodys = new HashMap<String, String>();
		bodys.put("app_id",TencentAPI.APP_ID_AI.toString());
		bodys.put("time_stamp",time_stamp);
		bodys.put("nonce_str", nonce_str);
		bodys.put("text", text);
		String sign = TencentAISignSort.getSignatureforNLP(bodys);	
		bodys.put("sign", sign);
	   //text 进行urlencode 使用GBK编码 
		String params = TencentAISignSort.getParamsforNLP(bodys);
		System.out.println(params);
		String result = HttpUtil.postNLP(TencentAPI.NLP_WORDSEG, params);
	    System.out.println(result);
	}
}
