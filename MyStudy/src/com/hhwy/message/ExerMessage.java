package com.hhwy.message;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class ExerMessage {

	public static void main(String[] args) throws Exception {  
  
        HttpClient client = new HttpClient();  
        PostMethod post = new PostMethod("http://sms.webchinese.cn/web_api/");  
        post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=gbk");	// 在头文件中设置转码  
        NameValuePair[] data = { new NameValuePair("Uid", "lufeilong"), 						// 注册的用户名  
        						 new NameValuePair("Key", "96daaf284df9bf0fadbc"), 				// 注册成功后,登录网站使用的密钥  
        						 new NameValuePair("smsMob", "18610945021"), 					// 手机号码  
        						 new NameValuePair("smsText", "验证码：886497，发送，XX公司或XX网名称") };				// 设置短信内容          
        //[java] view plain copy print?
        post.setRequestBody(data);  
  
        client.executeMethod(post);  
        Header[] headers = post.getResponseHeaders();  
        int statusCode = post.getStatusCode();  
        System.out.println("statusCode:" + statusCode);  
        for (Header h : headers) {  
        	System.out.println(h.toString());  
        }  
        String result = new String(post.getResponseBodyAsString().getBytes("gbk"));  
        System.out.println(result);  
        post.releaseConnection();  
	}
}	