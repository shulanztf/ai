package com.xs.test;

import com.xs.common.APIContants;
import com.xs.pojo.BDAccessToken;
import com.xs.util.baidu.AIUtil;

public class TestGetAT {
	public static void main(String[] args) throws Exception {
		AIUtil aiUtil = new AIUtil();
		BDAccessToken accessToken =  aiUtil.getAccessToken(APIContants.NLP_API_KEY, APIContants.NLP_SERCET_KEY);
		System.out.println(accessToken.getAccess_token());
	}
}
