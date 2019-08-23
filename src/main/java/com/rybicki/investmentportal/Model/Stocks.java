package com.rybicki.investmentportal.Model;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Stocks {
    private ArrayList<CompanyBasicInfo> dowJones30;
    private static String[] dowJones30Symbols = new String[] {"AXP","AAPL","BA","CAT","CVX","CSCO","DIS","DOW","GS","HD","IBM","INTC","JNJ","JPM","KO","MCD","MMM","MRK","MSFT","NKE","PFE","PG","TRV","UTX","UNH","VZ","V","WMT","WBA","XOM"};

    public Stocks(){
        dowJones30 = new ArrayList<CompanyBasicInfo>();
        for (int x=0; x<dowJones30Symbols.length;x++){
            dowJones30.add(new CompanyBasicInfo(dowJones30Symbols[x], false));
        }
        dowJones30 = actualizeCompaniesData(dowJones30,dowJones30Symbols);
    }

    public ArrayList getDowJones30(){
        return dowJones30;
    }

    public static String[] getDowJones30Symbols() {
        return dowJones30Symbols;
    }

    public CompanyBasicInfo actualizeCompanyData(CompanyBasicInfo companyBasicInfo){
        try {
            Stock stock = YahooFinance.get(companyBasicInfo.getSymbol());
            companyBasicInfo.setAnnualYieldDividend(stock.getDividend().getAnnualYield());
            companyBasicInfo.setPrice(stock.getQuote().getPrice());
            companyBasicInfo.setChange(stock.getQuote().getChange());
            companyBasicInfo.setChangeInPercent(stock.getQuote().getChangeInPercent());
            return companyBasicInfo;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<CompanyBasicInfo> actualizeCompaniesData(ArrayList<CompanyBasicInfo> companies, String[] symbols){
        try {
            Map<String, Stock> stock = YahooFinance.get(symbols);
            companies.forEach((company) ->{
                for (int x=0; x<symbols.length;x++){
                    if(symbols[x].equals(company.getSymbol())){
                        company.setAnnualYieldDividend(stock.get(symbols[x]).getDividend().getAnnualYield());
                        company.setPrice(stock.get(symbols[x]).getQuote().getPrice());
                        company.setChange(stock.get(symbols[x]).getQuote().getChange());
                        company.setChangeInPercent(stock.get(symbols[x]).getQuote().getChangeInPercent());
                        if(company.getName() == null || company.getName().isEmpty()){
                            company.setName(stock.get(symbols[x]).getName());
                        }
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return companies;
    }
}
