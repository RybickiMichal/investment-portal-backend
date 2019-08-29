package com.rybicki.investmentportal.Service;

import com.rybicki.investmentportal.Model.CompanyBasicInfo;
import org.springframework.stereotype.Service;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;

@Service
public class IndexBasicInfoService {

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
