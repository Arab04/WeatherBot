package com.SringFramework.TelegramLongPollingBot;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;


public class UrlConnector {
	
	public static String request(String message,Model model) throws IOException, InterruptedException {
		
		HttpClient client = HttpClient.newHttpClient();
	    HttpRequest request = HttpRequest.newBuilder()
	            .uri(URI.create("https://api.openweathermap.org/data/2.5/weather?q="+message+"&units=metric&appid=180c3997b80115f07c9b91ab68446cad"))
	            .build();
	    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
	        
	    
	      String result = "";
	      Scanner scan = new Scanner(response.body());
	      
	      while(scan.hasNext()) {
				result += scan.nextLine();
			}
			
			JSONObject object = new JSONObject(result);
			model.setName(object.getString("name"));
			
			JSONObject main = object.getJSONObject("main");
			model.setTemp(main.getDouble("temp"));
			model.setHumidity(main.getDouble("humidity"));
			
			JSONArray array = object.getJSONArray("weather");
			
			for(int i = 0; i<array.length();i++) {
				JSONObject obj = array.getJSONObject(i);
				model.setIcon((String)obj.get("icon"));
				model.setMain((String)obj.get("main"));
			}
			
			String abc = "City "+model.getName()+"\n"+"Temprature "+model.getTemp()+" C"+"\n"+"Humidity "+model.getHumidity()+" %";
			
			return abc;
	}
}
