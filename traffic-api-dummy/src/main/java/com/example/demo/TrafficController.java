package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Traffic;

@RestController
public class TrafficController {

	@RequestMapping("/{myCity}")
	public Traffic getTraffic(@PathVariable("myCity")String myCity)
	{
		return new Traffic(myCity, "Sever Accident", 2);
		
	}
}
