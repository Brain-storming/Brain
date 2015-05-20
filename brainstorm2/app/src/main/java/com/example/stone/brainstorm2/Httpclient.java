package com.example.stone.brainstorm2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Httpclient {

	private String result = "";

	private String url = "http://localhost/";

	public String doPost(String action, String params) {
		
		HttpURLConnection conn = null;
		try {
			url = url + action;
			URL requestURL = new URL(url);
			System.out.println(requestURL);
			System.out.println(params);
			conn = (HttpURLConnection) requestURL.openConnection();
			conn.setRequestMethod("POST");
			conn.setConnectTimeout(6000);
			conn.setDoOutput(true);
			byte[] bytes = params.getBytes();
			conn.getOutputStream().write(bytes, 0, bytes.length);
			conn.getOutputStream().flush();
			conn.getOutputStream().close();

			InputStream iStream = conn.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					iStream, "UTF-8"));
			String tempLine = rd.readLine();
			// StringBuffer tempStr = new StringBuffer();
			this.result = tempLine.toString();
			System.out.println(this.result);
			rd.close();
			iStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != conn) {
				conn.disconnect();
			}
		}
		return this.result;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	public static void main(String []args){
		Httpclient c=new Httpclient();
		c.doPost("haha.php", "userName=1&&pass=1");
	}
}
