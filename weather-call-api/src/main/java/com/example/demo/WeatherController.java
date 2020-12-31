
package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.restapi.model.Root;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class WeatherController {
	
	@Value("${api.Key}")
	private String apiKey; 
	
	@Autowired
	private RestTemplate restTemplate;
	  
	
	
	  @RequestMapping("/byCity/{city}")
	  public Object getWeatherByCity(@PathVariable("city") String city) {
	  
	  
		/*
		 * String response = restTemplate.
		 * getForObject("https://api.openweathermap.org/data/2.5/weather?q=" + city +
		 * "&APPID=b1a110e3b436d4025130881bcef95c27", String.class);
		 */
	  
	  Root response = restTemplate.
			  getForObject("https://api.openweathermap.org/data/2.5/weather?q=" + city +
	  "&APPID="+apiKey, Root.class);
	  
	  
	  return response;
	  }
	 
	
	/*
	 * @RequestMapping("/byCity/{country}/{city}") public Object
	 * getWeather(@PathVariable String city, @PathVariable String country){
	 * RestTemplate temp = new RestTemplate(); Object response =
	 * temp.getForObject("https://api.openweathermap.org/data/2.5/forecast?q=" +
	 * city + "," + country + "&APPID=b1a110e3b436d4025130881bcef95c27",
	 * Object.class); return response; }
	 */
	 
	

	@RequestMapping(method = RequestMethod.GET, value = "/forecastByCity/{country}/{city}")
	public @ResponseBody Object getForecastByCity(@PathVariable String city, @PathVariable String code) {

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();

		ResponseEntity<Object> response = restTemplate
				.getForEntity("https://api.openweathermap.org/data/2.5/forecast?q=" + city + "," + code
						+ "&APPID=b1a110e3b436d4025130881bcef95c27", Object.class);

		return response;
	}

}
