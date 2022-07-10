package com.bank.demo.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Controller;

@Controller
public class DbService implements HealthIndicator{
	
	private static final String DataBase_Service = "Database_service";

	public boolean isHealthGood()
	{
		return true;
	}

	@Override
	public Health health() {
		
		if(isHealthGood())
		{
			return Health.up().withDetail(DataBase_Service, "DataBase Servive is running").build();	
		}
		else
		{

		return Health.down().withDetail(DataBase_Service, "DataBase Servive is running down").build();
	      }
	}

}
