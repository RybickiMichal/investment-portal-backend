package com.rybicki.investmentportal.Model;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Stocks {
    private ArrayList<CompanyBasicInfo> dowJones30;
    private static String[] dowJones30Symbols = new String[]{"AXP", "AAPL", "BA", "CAT", "CVX", "CSCO", "DIS", "DOW", "GS", "HD", "IBM", "INTC", "JNJ", "JPM", "KO", "MCD", "MMM", "MRK", "MSFT", "NKE", "PFE", "PG", "TRV", "UTX", "UNH", "VZ", "V", "WMT", "WBA", "XOM"};
    private ArrayList<CompanyBasicInfo> standardAndPoors500;
    private static String[] standardAndPoors500Symbols = new String[]{"ABT", "ABBV", "ACN", "ADBE", "AAP", "AES", "AFL", "AMG", "A", "APD", "AKAM", "AA", "AGN", "ALXN", "ALLE", "ADS", "ALL", "ALTR", "MO", "AMZN", "AEE", "AAL", "AEP", "AXP", "AIG", "AMT", "AMP", "ABC", "AME", "AMGN", "APH", "APC", "ADI", "AON", "APA", "AIV", "AMAT", "ADM", "AIZ", "T", "ADSK", "ADP", "AN", "AZO", "AVGO", "AVB", "AVY", "BLL", "BAC", "BK", "BAX", "BBT", "BDX", "BBBY", "BRK-B", "BBY", "BLX", "HRB", "BA", "BWA", "BXP", "BMY", "BFB", "CHRW", "COG", "CPB", "COF", "CAH", "HSIC", "KMX", "CCL", "CAT", "CBS", "CELG", "CNP", "CTL", "CERN", "CF", "SCHW", "CHK", "CVX", "CMG", "CB", "CI", "XEC", "CTAS", "CSCO", "C", "CTXS", "CLX", "CME", "CMS", "KO", "CTSH", "CL", "CMCSA", "CMA", "CAG", "COP", "CNX", "ED", "STZ", "GLW", "COST", "CCI", "CSX", "CMI", "CVS", "DHI", "DHR", "DRI", "DVA", "DE", "DLPH", "DAL", "XRAY", "DVN", "DO", "DTV", "DFS", "DISCA", "DISCK", "DG", "DLTR", "D", "DOV", "DOW", "DTE", "DD", "DUK", "ETFC", "EMN", "ETN", "EBAY", "ECL", "EIX", "EW", "EA", "EMR", "ENDP", "ESV", "ETR", "EOG", "EQT", "EFX", "EQIX", "EQR", "ESS", "EL", "ES", "EXC", "EXPE", "EXPD", "XOM", "FFIV", "FB", "FAST", "FDX", "FIS", "FITB", "FSLR", "FE", "FLIR", "FLS", "FLR", "FMC", "FTI", "F", "FOSL", "BEN", "FCX", "FTR", "GME", "GPS", "GRMN", "GD", "GE", "GIS", "GM", "GPC", "GILD", "GS", "GT", "GOOGL", "GOOG", "GWW", "HAL", "HBI", "HOG", "HRS", "HIG", "HAS", "HCA", "HCP", "HP", "HES", "HPQ", "HD", "HON", "HRL", "HST", "HUM", "HBAN", "ITW", "IR", "INTC", "ICE", "IBM", "IP", "IPG", "IFF", "INTU", "ISRG", "IVZ", "IRM", "JEC", "JBHT", "JNJ", "JCI", "JPM", "JNPR", "KSU", "K", "KEY", "KMB", "KIM", "KMI", "KLAC", "KSS", "KR", "LB", "LLL", "LH", "LRCX", "LM", "LEG", "LEN", "LLY", "LNC", "LMT", "L", "LOW", "LYB", "MTB", "MAC", "M", "MNK", "MRO", "MPC", "MAR", "MMC", "MLM", "MAS", "MA", "MAT", "MKC", "MCD", "MCK", "MDT", "MRK", "MET", "MCHP", "MU", "MSFT", "MHK", "TAP", "MDLZ", "MNST", "MCO", "MS", "MOS", "MSI", "MUR", "MYL", "NDAQ", "NOV", "NAVI", "NTAP", "NFLX", "NWL", "NEM", "NWSA", "NEE", "NLSN", "NKE", "NI", "NE", "NBL", "JWN", "NSC", "NTRS", "NOC", "NRG", "NUE", "NVDA", "ORLY", "OXY", "OMC", "OKE", "ORCL", "OI", "PCAR", "PLL", "PH", "PDCO", "PAYX", "PNR", "PBCT", "PEP", "PKI", "PRGO", "PFE", "PCG", "PM", "PSX", "PNW", "PXD", "PBI", "PNC", "RL", "PPG", "PPL", "PFG", "PG", "PGR", "PLD", "PRU", "PEG", "PSA", "PHM", "PVH", "QRVO", "PWR", "QCOM", "DGX", "RRC", "RTN", "O", "REGN", "RF", "RSG", "RHI", "ROK", "ROP", "ROST", "R", "CRM", "SLB", "STX", "SEE", "SRE", "SHW", "SPG", "SWKS", "SLG", "SJM", "SNA", "SO", "LUV", "SWN", "SE", "SWK", "SBUX", "STT", "SRCL", "SYK", "STI", "SYMC", "SYY", "TROW", "TGT", "TEL", "TGNA", "THC", "TDC", "TXN", "TXT", "HSY", "TRV", "TMO", "TIF", "TMK", "TSS", "TSCO", "RIG", "TRIP", "FOXA", "TSN", "UA", "UNP", "UNH", "UPS", "URI", "UTX", "UHS", "UNM", "URBN", "VFC", "VLO", "VAR", "VTR", "VRSN", "VZ", "VRTX", "VIAB", "V", "VNO", "VMC", "WMT", "WBA", "DIS", "WM", "WAT", "ANTM", "WFC", "WDC", "WU", "WY", "WHR", "WMB", "WEC", "WYNN", "XEL", "XRX", "XLNX", "XYL", "YUM", "ZBH", "ZION", "ZTS"};
    private ArrayList<CompanyBasicInfo> nasdaq100;
    private static String[] nasdaq100Symbols = new String[]{"AAL", "AAPL", "ADBE", "ADI", "ADP", "ADSK", "ALGN", "ALXN", "AMAT", "AMD", "AMGN", "AMZN", "ASML", "ATVI", "AVGO", "BIDU", "BIIB", "BKNG", "BMRN", "CDNS", "CELG", "CERN", "CHKP", "CHTR", "CMCSA", "COST", "CSCO", "CSX", "CTAS", "CTRP", "CTSH", "CTXS", "DLTR", "EA", "EBAY", "EXPE", "FAST", "FB", "FISV", "FOX", "FOXA", "GILD", "GILD", "GOOG", "GOOGL", "HAS", "HSIC", "IDXX", "ILMN", "INCY", "INTC", "INTU", "ISRG", "JBHT", "JD", "KHC", "KLAC", "LBTYA", "LBTYK", "LRCX", "LULU", "MAR", "MCHP", "MDLZ", "MELI", "MNST", "MSFT", "MU", "MXIM", "MYL", "NFLX", "NTAP", "NTES", "NVDA", "NXPI", "ORLY", "PAYX", "PCAR", "PEP", "PYPL", "QCOM", "REGN", "ROST", "SBUX", "SIRI", "SNPS", "SWKS", "SYMC", "TMUS", "TSLA", "TTWO", "TXN", "UAL", "ULTA", "VRSK", "VRSN", "VRTX", "WBA", "WDAY", "WDC", "WLTW", "WYNN", "XEL", "XLNX"};

    public Stocks() {


    }

    public ArrayList getDowJones30() {
        if (dowJones30 == null) {
            dowJones30 = new ArrayList<CompanyBasicInfo>();
            dowJones30 = this.loadCompanies(dowJones30, dowJones30Symbols);
        }
        return dowJones30;
    }

    public String[] getDowJones30Symbols() {
        return dowJones30Symbols;
    }

    public ArrayList<CompanyBasicInfo> getStandardAndPoors500() {
        if (standardAndPoors500 == null) {
            standardAndPoors500 = new ArrayList<CompanyBasicInfo>();
            standardAndPoors500 = this.loadCompanies(standardAndPoors500, standardAndPoors500Symbols);
        }
        return standardAndPoors500;
    }

    public ArrayList<CompanyBasicInfo> getNasdaq100() {
        if (nasdaq100 == null) {
            nasdaq100 = new ArrayList<CompanyBasicInfo>();
            nasdaq100 = this.loadCompanies(nasdaq100, nasdaq100Symbols);
        }
        return nasdaq100;
    }

    public static String[] getNasdaq100Symbols() {
        return nasdaq100Symbols;
    }

    private ArrayList<CompanyBasicInfo> loadCompanies(ArrayList<CompanyBasicInfo> index, String[] symbols) {
        for (int x = 0; x < symbols.length; x++) {
            index.add(new CompanyBasicInfo(symbols[x], false));
        }
        return actualizeCompaniesData(index, symbols);
    }

    public static String[] getStandardAndPoors500Symbols() {
        return standardAndPoors500Symbols;
    }

    public CompanyBasicInfo actualizeCompanyData(CompanyBasicInfo companyBasicInfo) {
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

    public ArrayList<CompanyBasicInfo> actualizeCompaniesData(ArrayList<CompanyBasicInfo> companies, String[] symbols) {
        try {
            Map<String, Stock> stock = YahooFinance.get(symbols);
            companies.forEach((company) -> {
                for (int x = 0; x < symbols.length; x++) {
                    if (symbols[x].equals(company.getSymbol())) {
                        company.setAnnualYieldDividend(stock.get(symbols[x]).getDividend().getAnnualYield());
                        company.setPrice(stock.get(symbols[x]).getQuote().getPrice());
                        company.setChange(stock.get(symbols[x]).getQuote().getChange());
                        company.setChangeInPercent(stock.get(symbols[x]).getQuote().getChangeInPercent());
                        if (company.getName() == null || company.getName().isEmpty()) {
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
