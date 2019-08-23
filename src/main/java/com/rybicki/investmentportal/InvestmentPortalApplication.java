package com.rybicki.investmentportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;

@SpringBootApplication
public class InvestmentPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvestmentPortalApplication.class, args);
	}

}
