package com.rybicki.investmentportal.Model;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

public class CompanyHistory {

    private List<HistoricalQuote> historicalQuotes = new ArrayList<>();
    private Map<Calendar, BigDecimal> companyHistoricalClosedStocks = new HashMap<>();
    private Map<Calendar, BigDecimal[]> companyHistoricalStocks = new HashMap<>();
    private static final int numberOfDailyQuotes = 4;

    public CompanyHistory() {}

    public Map<Calendar, BigDecimal> getHistoricalQuotesOnClosed(String symbol, int yearsAgo, int monthsAgo, int daysAgo, Interval interval){
        historicalQuotes = null;
        companyHistoricalClosedStocks = new HashMap<>();
        try {
            Calendar calendar = setCalendar(yearsAgo, monthsAgo, daysAgo);
            Stock stock = YahooFinance.get(symbol, calendar, interval);

            this.historicalQuotes = stock.getHistory();
            for (int x = 0; x < historicalQuotes.size(); x++) {
                companyHistoricalClosedStocks.put(historicalQuotes.get(x).getDate(), historicalQuotes.get(x).getClose());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return companyHistoricalClosedStocks;
    }

    public Map<Calendar, BigDecimal[]> getHistoricalQuotes(String symbol, int yearsAgo, int monthsAgo, int daysAgo, Interval interval){
        historicalQuotes = null;
        companyHistoricalStocks = new HashMap<>();
        try {
            Calendar calendar = setCalendar(yearsAgo, monthsAgo, daysAgo);
            Stock stock = YahooFinance.get(symbol, calendar, interval);

            this.historicalQuotes = stock.getHistory();
            for (int x = 0; x < historicalQuotes.size(); x++) {
                BigDecimal[] quotes = new BigDecimal[numberOfDailyQuotes];
                for (int y = 0; y < numberOfDailyQuotes; y++) {
                    if(y == 0){
                        quotes[y] = historicalQuotes.get(x).getOpen();
                    }else if(y == 1){
                        quotes[y] = historicalQuotes.get(x).getHigh();
                    }else if(y == 2){
                        quotes[y] = historicalQuotes.get(x).getLow();
                    }else if(y == 3){
                        quotes[y] = historicalQuotes.get(x).getClose();
                    }
                }
                companyHistoricalStocks.put(historicalQuotes.get(x).getDate(), quotes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return companyHistoricalStocks;
    }

    private Calendar setCalendar(int yearsAgo, int monthsAgo, int daysAgo){
        Calendar calendar = Calendar.getInstance();
        if(yearsAgo > 0) {
            calendar.add(Calendar.YEAR, -yearsAgo);
        }
        if(monthsAgo > 0) {
            calendar.add(Calendar.MONTH, -monthsAgo);
        }
        if(daysAgo > 0) {
            calendar.add(Calendar.DAY_OF_YEAR, -daysAgo);
        }
        return calendar;
    }
}
