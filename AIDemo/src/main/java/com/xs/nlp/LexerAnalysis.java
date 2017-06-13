package com.xs.nlp;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import com.xs.common.APIContants;
import com.xs.util.baidu.HttpUtil;
import com.xs.util.baidu.HttpUtils;
import com.xs.util.baidu.UnicodeUtil;
/**
 * 自然语言处理-词法分析
 * @author 小帅帅丶
 *
 */
public class LexerAnalysis {
	/**
	 * 接口地址
	 */
	public String LEXERANALYSIS_URL = "https://aip.baidubce.com/rpc/2.0/nlp/v1/lexer";
	public static void main(String[] args) throws Exception {
		LexerAnalysis analysis = new  LexerAnalysis();
		System.out.println(analysis.getLexerAnalysis("北京你好有限公司", APIContants.NLP_TOKEN));
	}
	/**
	 * 词法分析接口
	 * @param text
	 * @param accessToken
	 * @return data
	 * @throws Exception
	 */
	public String getLexerAnalysis(String text,String accessToken) throws Exception {
		String url_param = "?access_token="+accessToken;
		String url = LEXERANALYSIS_URL+url_param;
		
// 1.		
//		HttpUtils httpUtils = new HttpUtils();
//		Map<String, String> headers = new HashMap<String, String>(); 
//		Map<String, String> bodys= new HashMap<String, String>();
//		bodys.put("text", text);
//		headers.put("Content-Encoding", "GBK");
//		headers.put("Content-Type","application/json");
//		HttpResponse response = httpUtils.doPostBD(url,headers,bodys);
//		String data = EntityUtils.toString(response.getEntity());
		
//2.	
		HttpUtil httpUtil = new HttpUtil();
		String param = UnicodeUtil.getGbk(text);
		System.out.println(param);
		String data = httpUtil.post(url, param);
		return data;
	}
}
