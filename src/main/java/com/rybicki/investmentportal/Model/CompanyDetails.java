package com.rybicki.investmentportal.Model;

import com.rybicki.investmentportal.Service.UserCompaniesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CompanyDetails extends CompanyBasicInfo {

    private Map<String, Object> companyDetails = new HashMap();
    private static final Logger LOGGER = LoggerFactory.getLogger(UserCompaniesService.class);

    public CompanyDetails(String symbol) {
        super(symbol, true);
        try {
            Stock stock = YahooFinance.get(symbol);
            companyDetails.put("Symbol", super.getSymbol());
            companyDetails.put("Name", super.getName());
            companyDetails.put("Price", super.getPrice());
            if (super.getAnnualYieldDividend() != null)
                companyDetails.put("Annual Yield Dividend", super.getAnnualYieldDividend());
            else
                companyDetails.put("Annual Yield Dividend", "-");
            companyDetails.put("Change", super.getChange());
            companyDetails.put("Change In %", super.getChangeInPercent());

            if (stock.getStats().getBookValuePerShare() != null)
                companyDetails.put("Book Value Per Share", stock.getStats().getBookValuePerShare().toString());

            if (stock.getStats().getEBITDA() != null)
                companyDetails.put("EBITDA", stock.getStats().getEBITDA().toString());

            if (stock.getStats().getEps() != null)
                companyDetails.put("EPS", stock.getStats().getEps().toString());

            if (stock.getStats().getEpsEstimateCurrentYear() != null)
                companyDetails.put("EPS Estimate Current Year", stock.getStats().getEpsEstimateCurrentYear().toString());

            if (stock.getStats().getEpsEstimateNextQuarter() != null)
                companyDetails.put("EPS Estimate Next Quarter", stock.getStats().getEpsEstimateNextQuarter().toString());

            if (stock.getStats().getEpsEstimateNextYear() != null)
                companyDetails.put("EPS Estimate Next Year", stock.getStats().getEpsEstimateNextYear().toString());

            if (stock.getStats().getMarketCap() != null)
                companyDetails.put("Market Cap", stock.getStats().getMarketCap().toString());

            if (stock.getStats().getOneYearTargetPrice() != null)
                companyDetails.put("One Year Target Price", stock.getStats().getOneYearTargetPrice().toString());

            if (stock.getStats().getPe() != null)
                companyDetails.put("PE", stock.getStats().getPe().toString());

            if (stock.getStats().getPeg() != null)
                companyDetails.put("PEG", stock.getStats().getPeg().toString());

            if (stock.getStats().getPriceBook() != null)
                companyDetails.put("Price Book", stock.getStats().getPriceBook().toString());

            if (stock.getStats().getPriceSales() != null)
                companyDetails.put("Price Sales", stock.getStats().getPriceSales().toString());

            if (stock.getStats().getRevenue() != null)
                companyDetails.put("Revenue", stock.getStats().getRevenue().toString());

            if (stock.getStats().getROE() != null)
                companyDetails.put("ROE", stock.getStats().getROE().toString());

            if (stock.getStats().getShortRatio() != null)
                companyDetails.put("Short Ratio", stock.getStats().getShortRatio().toString());

            if (stock.getStats().getSharesFloat() != null)
                companyDetails.put("Shares Float", stock.getStats().getSharesFloat().toString());

            if (stock.getStats().getSharesOutstanding() != null)
                companyDetails.put("Shares Outstanding", stock.getStats().getSharesOutstanding().toString());

            if (stock.getStats().getSharesOwned() != null)
                companyDetails.put("Shares Owned", stock.getStats().getSharesOwned().toString());

            if (stock.getStockExchange() != null)
                companyDetails.put("Stock Exchange", stock.getStockExchange());

            if (stock.getQuote().getLastTradeDateStr() != null)
                companyDetails.put("Last Trade Date Str", stock.getQuote().getLastTradeDateStr());

            if (stock.getQuote().getAsk() != null)
                companyDetails.put("Ask", stock.getQuote().getAsk().toString());

            if (stock.getQuote().getAskSize() != null)
                companyDetails.put("Ask Size", stock.getQuote().getAskSize());

            if (stock.getQuote().getAvgVolume() != null)
                companyDetails.put("Avg Volume", stock.getQuote().getAvgVolume());

            if (stock.getQuote().getBid() != null)
                companyDetails.put("Bid", stock.getQuote().getBid().toString());

            if (stock.getQuote().getBidSize() != null)
                companyDetails.put("Bid Size", stock.getQuote().getBidSize());

            if (stock.getQuote().getChangeFromAvg50() != null)
                companyDetails.put("Change From Avg 50", stock.getQuote().getChangeFromAvg50().toString());

            if (stock.getQuote().getChangeFromAvg50InPercent() != null)
                companyDetails.put("Change From Avg 50 In Percent", stock.getQuote().getChangeFromAvg50InPercent().toString());

            if (stock.getQuote().getChangeFromYearLow() != null)
                companyDetails.put("Change From Year Low", stock.getQuote().getChangeFromYearLow());

            if (stock.getQuote().getChangeFromYearLowInPercent() != null)
                companyDetails.put("Change From Year Low In Percent", stock.getQuote().getChangeFromYearLowInPercent());

            if (stock.getQuote().getLastTradeSize() != null)
                companyDetails.put("Last Trade Size", stock.getQuote().getLastTradeSize().toString());

            if (stock.getQuote().getPreviousClose() != null)
                companyDetails.put("Previous Close", stock.getQuote().getPreviousClose().toString());

            if (stock.getQuote().getVolume() != null)
                companyDetails.put("Volume", stock.getQuote().getVolume().toString());

            if (stock.getQuote().getLastTradeTimeStr() != null)
                companyDetails.put("Last Trade Time", stock.getQuote().getLastTradeTimeStr());

            if (stock.getQuote().getChange() != null)
                companyDetails.put("Change", stock.getQuote().getChange().toString());

            if (stock.getQuote().getOpen() != null)
                companyDetails.put("Open", stock.getQuote().getOpen().toString());

            if (stock.getQuote().getSymbol() != null)
                companyDetails.put("Symbol", stock.getQuote().getSymbol().toString());

            if (stock.getQuote().getChangeFromYearHighInPercent() != null)
                companyDetails.put("Change From Year High In Percent", stock.getQuote().getChangeFromYearHighInPercent().toString());

            if (stock.getQuote().getChangeFromYearHigh() != null)
                companyDetails.put("Change From Year High", stock.getQuote().getChangeFromYearHigh().toString());

            if (stock.getQuote().getPrice() != null)
                companyDetails.put("Price", stock.getQuote().getPrice().toString());

            if (stock.getQuote().getChangeInPercent() != null)
                companyDetails.put("Change In Percent", stock.getQuote().getChangeInPercent().toString());

            if (stock.getQuote().getDayHigh() != null)
                companyDetails.put("Day High", stock.getQuote().getDayHigh().toString());

            if (stock.getQuote().getDayLow() != null)
                companyDetails.put("Day Low", stock.getQuote().getDayLow().toString());

            if (stock.getQuote().getPriceAvg50() != null)
                companyDetails.put("Price Avg 50", stock.getQuote().getPriceAvg50().toString());

            if (stock.getQuote().getChangeFromAvg50InPercent() != null)
                companyDetails.put("Change From Avg 50 In Percent", stock.getQuote().getChangeFromAvg50InPercent().toString());

            if (stock.getQuote().getChangeFromAvg50() != null)
                companyDetails.put("Change From Avg 50", stock.getQuote().getChangeFromAvg50().toString());

            if (stock.getQuote().getPriceAvg200() != null)
                companyDetails.put("Price Avg 200", stock.getQuote().getPriceAvg200().toString());

            if (stock.getQuote().getChangeFromAvg200InPercent() != null)
                companyDetails.put("Change From Avg 200 In Percent", stock.getQuote().getChangeFromAvg200InPercent().toString());

            if (stock.getQuote().getChangeFromAvg200() != null)
                companyDetails.put("Change From Avg 200", stock.getQuote().getChangeFromAvg200().toString());

            if (stock.getQuote().getYearHigh() != null)
                companyDetails.put("Year High", stock.getQuote().getYearHigh().toString());

        } catch (IOException e) {
            LOGGER.error(e.toString());
        }
    }

    public Map<String, Object> getCompanyDetails() {
        return companyDetails;
    }
}

