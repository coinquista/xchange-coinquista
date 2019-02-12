package com.coinquista.xchange_coinquista.service;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.dto.marketdata.Trades;
import org.knowm.xchange.dto.meta.ExchangeMetaData;
import org.knowm.xchange.service.marketdata.MarketDataService;

public class CoinquistaMarketDataService extends CoinquistaMarketDataServiceRaw implements MarketDataService {
    public CoinquistaMarketDataService(Exchange exchange) {
        super(exchange);
    }

    public OrderBook getOrderBook(CurrencyPair currencyPair, Object... args) {
        return super.getOrderbook(currencyPair);
    }

    public Trades getTrades(CurrencyPair currencyPair, Object... args) {
        if (args.length == 0) {
            return super.getTrades(currencyPair, 1);
        }
        else {
            int page = Integer.parseInt((String) args[0]);
            return super.getTrades(currencyPair, page);
        }
    }

    public ExchangeMetaData getExchangeMetaData() {
        return new ExchangeMetaData(
                super.getCurrencyPairsMetadata(), super.getCurrenciesMetadata(), null,
                null, null
        );
    }
}
