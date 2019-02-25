package com.coinquista.xchange_coinquista.service;

import com.coinquista.xchange_coinquista.dto.marketdata.*;
import org.knowm.xchange.Exchange;
import com.coinquista.xchange_coinquista.CoinquistaAdapters;
import com.coinquista.xchange_coinquista.dto.trade.CoinquistaListResponse;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.dto.marketdata.Trade;
import org.knowm.xchange.dto.marketdata.Trades;
import org.knowm.xchange.dto.meta.CurrencyMetaData;
import org.knowm.xchange.dto.meta.CurrencyPairMetaData;
import org.knowm.xchange.dto.trade.LimitOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoinquistaMarketDataServiceRaw extends CoinquistaBaseService {
    CoinquistaMarketDataServiceRaw(Exchange exchange) {
        super(exchange);
    }

    OrderBook getOrderbook(CurrencyPair pair) {
        String market = CoinquistaAdapters.getMarketName(pair);
        CoinquistaListResponse<OrderbookOrderResponse> buyOrders = coinquistaAuthenticated.buyOrders(apiKey, market);
        CoinquistaListResponse<OrderbookOrderResponse> sellOrders = coinquistaAuthenticated.sellOrders(apiKey, market);
        List<LimitOrder> buyLimitOrders = new ArrayList<>();
        List<LimitOrder> sellLimitOrders = new ArrayList<>();
        for (OrderbookOrderResponse order : buyOrders.getResults()) {
            buyLimitOrders.add(CoinquistaAdapters.adaptOrderbookOrder(order, Order.OrderType.BID, pair));
        }
        for (OrderbookOrderResponse order : sellOrders.getResults()) {
            sellLimitOrders.add(CoinquistaAdapters.adaptOrderbookOrder(order, Order.OrderType.ASK, pair));
        }
        return new OrderBook(null, sellLimitOrders, buyLimitOrders);
    }

    Map<Currency, CurrencyMetaData> getCurrenciesMetadata() {
        Map<Currency, CurrencyMetaData> result = new HashMap<>();
        CoinquistaListResponse<AssetResponse> currencies = coinquista.getAssets();
        for (AssetResponse currency : currencies.getResults()) {
            // TODO: coinquista has withdrawal constant fee and fee rate, xchange api accepts only constant fee
            CurrencyMetaData metaData = new CurrencyMetaData(currency.getShowPrecision(), null);
            result.put(new Currency(currency.getTickerSymbol()), metaData);
        }
        return result;
    }

    Map<CurrencyPair, CurrencyPairMetaData> getCurrencyPairsMetadata() {
        Map<CurrencyPair, CurrencyPairMetaData> result = new HashMap<>();
        ExchangeInfoResponse exchangeInfoResponse = coinquista.getExchangeInfo();
        for (Symbol symbol : exchangeInfoResponse.getSymbols()) {
            CurrencyPair pair = new CurrencyPair(symbol.getBaseAsset(), symbol.getQuoteAsset());
            result.put(pair, new CurrencyPairMetaData(null, null, null, null, null));
        }
        return result;
    }

    Trades getTrades(CurrencyPair currencyPair, int page) {
        List<Trade> trades = new ArrayList<>();
        String marketName = CoinquistaAdapters.getMarketName(currencyPair);
        CoinquistaListResponse<DealResponse> dealResponse = coinquistaAuthenticated.getLatestDeals(apiKey, marketName, page);
        for (DealResponse deal : dealResponse.getResults()) {
            trades.add(CoinquistaAdapters.adaptDeal(deal, currencyPair));
        }
        String nextPageCursor;
        Object next = dealResponse.getNext();
        nextPageCursor = (next != null) ? Integer.toString(page + 1) : null;
        return new Trades(trades, 0L, Trades.TradeSortType.SortByTimestamp, nextPageCursor);
    }
}
