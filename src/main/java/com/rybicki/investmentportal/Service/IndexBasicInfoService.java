package com.rybicki.investmentportal.Service;

import com.rybicki.investmentportal.Model.CompanyBasicInfo;
import com.rybicki.investmentportal.Model.Stocks;
import org.springframework.stereotype.Service;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class IndexBasicInfoService {

    ArrayList<CompanyBasicInfo> nasdaq100DowJones30SAndP500Indexes = new ArrayList<>();
    String[] nasdaq100DowJones30SAndP500Symbols = new String[]{"^DJI", "^NDX", "^GSPC"};
    Stocks stocks = new Stocks();

    public ArrayList<CompanyBasicInfo> getNasdaq100DowJones30SAndP500Indexes() {
        if(nasdaq100DowJones30SAndP500Indexes.isEmpty()) {
            nasdaq100DowJones30SAndP500Indexes.add(getIndexBasicInfo("^DJI"));
            nasdaq100DowJones30SAndP500Indexes.add(getIndexBasicInfo("^NDX"));
            nasdaq100DowJones30SAndP500Indexes.add(getIndexBasicInfo("^GSPC"));
        }
        return stocks.actualizeCompaniesData(nasdaq100DowJones30SAndP500Indexes, nasdaq100DowJones30SAndP500Symbols);
    }

    public CompanyBasicInfo getIndexBasicInfo(String symbol) {
        CompanyBasicInfo indexBasicInfo = new CompanyBasicInfo(symbol, false);
        try {
            Stock stock = YahooFinance.get(symbol);
            indexBasicInfo.setName(stock.getName());
            indexBasicInfo.setPrice(stock.getQuote().getPrice());
            indexBasicInfo.setChange(stock.getQuote().getChange());
            indexBasicInfo.setChangeInPercent(stock.getQuote().getChangeInPercent());
        } catch (IOException e) {

        }
        return  indexBasicInfo;
    }

}
