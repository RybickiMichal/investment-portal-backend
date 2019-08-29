package com.rybicki.investmentportal.Service;

import com.rybicki.investmentportal.Model.CompanyBasicInfo;
import com.rybicki.investmentportal.Model.Stocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class Nasdaq100Service implements StockService {

    private Stocks stocks = new Stocks();
    private ArrayList<CompanyBasicInfo> nasdaq100 = stocks.getNasdaq100();
    private String[] nasdaq100Symbols = stocks.getNasdaq100Symbols();
    private static final Logger LOGGER = LoggerFactory.getLogger(Nasdaq100Service.class);

    @Override
    public ArrayList<CompanyBasicInfo> findAll() {
        nasdaq100 = stocks.actualizeCompaniesData(nasdaq100, nasdaq100Symbols);
        return nasdaq100;
    }

    @Override
    public CompanyBasicInfo findBySymbol(String symbol) {
        for (CompanyBasicInfo companyBasicInfo : nasdaq100) {
            if (companyBasicInfo.getSymbol().equals(symbol)) {
                stocks.actualizeCompanyData(companyBasicInfo);
                return companyBasicInfo;
            }
        }
        return null;
    }

}
