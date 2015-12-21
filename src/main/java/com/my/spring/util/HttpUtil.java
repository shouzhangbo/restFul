package com.my.spring.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class HttpUtil {

	public static void main(String[] args) {
		String str = doGet("http://www.baidu.com");
		System.out.println(str.indexOf("<a>"));
		System.out.println();
	}
	
	public static String doGet(String url) {
		// 创建HttpClient实例     
        HttpClient httpclient = new DefaultHttpClient();  
        // 创建Get方法实例     
        HttpGet httpgets = new HttpGet(url);
        HttpResponse response = null;
        HttpEntity entity = null;
        String str = "";
        try{
	        response = httpclient.execute(httpgets);    
	        entity = (HttpEntity) response.getEntity();
	        if (entity != null) {    
	            InputStream instreams = ((org.apache.http.HttpEntity) entity).getContent();    
	            str = convertStreamToString(instreams);  
	            System.out.println("Do something");   
	            System.out.println(str);  
	            httpgets.abort();    
	        }
        }catch(ClientProtocolException e){
        	e.printStackTrace();
        }catch(IOException e){
        	e.printStackTrace();
        }
        
		return str;
	}
	public static String convertStreamToString(InputStream is) {      
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));      
        StringBuilder sb = new StringBuilder();      
       
        String line = null;      
        try {      
            while ((line = reader.readLine()) != null) {  
                sb.append(line + "\n");      
            }      
        } catch (IOException e) {      
            e.printStackTrace();      
        } finally {      
            try {      
                is.close();      
            } catch (IOException e) {      
               e.printStackTrace();      
            }      
        }      
        return sb.toString();      
    }
}
