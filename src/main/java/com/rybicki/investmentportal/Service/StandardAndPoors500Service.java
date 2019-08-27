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
public class StandardAndPoors500Service implements StockService {

    private Stocks stocks = new Stocks();
    private ArrayList<CompanyBasicInfo> standardAndPoors500 = stocks.getStandardAndPoors500();
    private String[] standardAndPoors500Symbols = stocks.getStandardAndPoors500Symbols();
    private static final Logger LOGGER = LoggerFactory.getLogger(StandardAndPoors500Service.class);

    @Override
    public ArrayList<CompanyBasicInfo> findAll() {
        standardAndPoors500 = stocks.actualizeCompaniesData(standardAndPoors500, standardAndPoors500Symbols);
        return standardAndPoors500;
    }

    @Override
    public CompanyBasicInfo findBySymbol(String symbol) {
        for (CompanyBasicInfo companyBasicInfo : standardAndPoors500) {
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
            Stock stock = YahooFinance.get("^GSPC");
            return stock.getQuote().getPrice().intValue();
        } catch (IOException e) {
            LOGGER.error(""+e);
        }
        return 0;
    }

    @Override
    public int getIndexPriceOnClosed() {
        try {
            Stock stock = YahooFinance.get("^GSPC");
            return stock.getQuote().getPreviousClose().intValue();
        } catch (IOException e) {
            LOGGER.error(""+e);
        }
        return 0;
    }
}

