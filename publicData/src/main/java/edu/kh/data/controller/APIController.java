package edu.kh.data.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class APIController {
	
	private static final String serviceKey = "AD%2BrdpRI4IBexV%2Fa%2BNaDAleMJmFgnH9to5I3KmFgqYm4oHKN8YzdfEJRupijwxCYwU7S8sXoaCanRrsmfLInmw%3D%3D";
	
	@ResponseBody
	@RequestMapping(value="busInfo", produces="application/json; charset=utf-8")
	public String busInfo() throws Exception{
		
			
		String url = "http://apis.data.go.kr/1613000/BusRouteInfoInqireService/getRouteAcctoThrghSttnList";
		url += "?serviceKey=" + serviceKey;
		url += "&cityCode=25";
		url += "&routeId=DJB30300004";
		url += "&_type=json";
	 	
	 	
		URL requestUrl = new URL(url);

		HttpURLConnection urlConnection = (HttpURLConnection)requestUrl.openConnection();

		urlConnection.setRequestMethod("GET");

		BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

		String responseData = "";
		String line; 
		
		while((line = br.readLine()) != null) {
				responseData += line;
				}
		
		br.close();

		urlConnection.disconnect(); 

		System.out.println("responseData::" + responseData);
				
		return responseData;

		
	}
	
	
}
