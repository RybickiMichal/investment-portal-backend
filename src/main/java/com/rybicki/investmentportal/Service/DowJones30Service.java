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
public class DowJones30Service implements StockService {

    private Stocks stocks = new Stocks();
    private ArrayList<CompanyBasicInfo> dowJones30 = stocks.getDowJones30();
    private String[] dowJones30symbols = stocks.getDowJones30Symbols();
    private static final Logger LOGGER = LoggerFactory.getLogger(DowJones30Service.class);

    @Override
    public ArrayList<CompanyBasicInfo> findAll() {
        dowJones30 = stocks.actualizeCompaniesData(dowJones30, dowJones30symbols);
        return dowJones30;
    }

    @Override
    public CompanyBasicInfo findBySymbol(String symbol) {
        for (CompanyBasicInfo companyBasicInfo : dowJones30) {
            if (companyBasicInfo.getSymbol().equals(symbol)) {
                stocks.actualizeCompanyData(companyBasicInfo);
                return companyBasicInfo;
            }
        }
        return null;
    }

    @Override
    public int getIndexPrice() {
        try {
            Stock stock = YahooFinance.get("^DJI");
            return stock.getQuote().getPrice().intValue();
        } catch (IOException e) {
            LOGGER.error(""+e);
        }
        return 0;
    }

    @Override
    public int getIndexPriceOnClosed() {
        try {
            Stock stock = YahooFinance.get("^DJI");
            return stock.getQuote().getPreviousClose().intValue();
        } catch (IOException e) {
            LOGGER.error(""+e);
        }
        return 0;
    }
}
