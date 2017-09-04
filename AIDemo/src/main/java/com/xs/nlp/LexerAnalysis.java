package com.xs.nlp;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import com.xiaoleilu.hutool.lang.Base64;
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
		System.out.println(analysis.getLexerAnalysis("百度是一家互联网公司", APIContants.NLP_TOKEN));
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
		HttpUtil httpUtil = new HttpUtil();
		String param = "{\"text\":\""+text+"\"}";
		String paramGBK = URLEncoder.encode(param, "GBK");
		String data = httpUtil.postNLP(url, param);
		return data;
	}
}
