package com.coinquista.xchange_coinquista.service;

import org.knowm.xchange.Exchange;
import com.coinquista.xchange_coinquista.CoinquistaAdapters;
import com.coinquista.xchange_coinquista.dto.trade.CoinquistaActiveOrder;
import com.coinquista.xchange_coinquista.dto.trade.CoinquistaListResponse;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.dto.trade.MarketOrder;
import org.knowm.xchange.dto.trade.OpenOrders;
import org.knowm.xchange.dto.trade.UserTrades;
import org.knowm.xchange.exceptions.NotYetImplementedForExchangeException;
import org.knowm.xchange.service.trade.TradeService;
import org.knowm.xchange.service.trade.params.DefaultTradeHistoryParamsTimeSpan;
import org.knowm.xchange.service.trade.params.TradeHistoryParamCurrencyPair;
import org.knowm.xchange.service.trade.params.TradeHistoryParams;

import java.util.ArrayList;
import java.util.List;

public class CoinquistaTradeService extends CoinquistaTradeServiceRaw implements TradeService {
    public CoinquistaTradeService(Exchange exchange) {
        super(exchange);
    }

    public OpenOrders getOpenOrders() {
        CoinquistaListResponse<CoinquistaActiveOrder> coinquistaActiveOrders = super.getActiveOrders();
        List<LimitOrder> limitOrders = new ArrayList<>();
        for (CoinquistaActiveOrder order : coinquistaActiveOrders.getResults()) {
            limitOrders.add(CoinquistaAdapters.adaptActiveOrder(order));
        }
        return new OpenOrders(limitOrders);
    }

    public String placeMarketOrder(MarketOrder marketOrder) {
        return super.putOrder(CoinquistaAdapters.adaptMarketOrder(marketOrder));
    }

    public String placeLimitOrder(LimitOrder limitOrder) {
        return super.putOrder(CoinquistaAdapters.adaptLimitOrder(limitOrder));
    }

    public boolean cancelOrder(String orderId) {
        return super.cancelOrder(orderId);
    }

    public UserTrades getTradeHistory(TradeHistoryParams params) {
        if (params instanceof DefaultTradeHistoryParamsTimeSpan) {
            DefaultTradeHistoryParamsTimeSpan timeSpan = (DefaultTradeHistoryParamsTimeSpan) params;
            return super.getTradeHistory(timeSpan.getStartTime(), timeSpan.getEndTime());
        }
        else if (params instanceof TradeHistoryParamCurrencyPair) {
            TradeHistoryParamCurrencyPair currencyPair = (TradeHistoryParamCurrencyPair) params;
            return super.getTradeHistory(currencyPair.getCurrencyPair());
        }
        else {
            throw new NotYetImplementedForExchangeException("Unsupported TradeHistoryParams type");
        }
    }
}
