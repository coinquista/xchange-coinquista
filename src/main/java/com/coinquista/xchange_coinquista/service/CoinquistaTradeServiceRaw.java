package com.coinquista.xchange_coinquista.service;

import com.coinquista.xchange_coinquista.dto.trade.*;
import org.knowm.xchange.Exchange;
import com.coinquista.xchange_coinquista.CoinquistaAdapters;
import org.knowm.xchange.dto.marketdata.Trades;
import org.knowm.xchange.dto.trade.UserTrade;
import org.knowm.xchange.dto.trade.UserTrades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


class CoinquistaTradeServiceRaw extends CoinquistaBaseService {
    CoinquistaTradeServiceRaw(Exchange exchange) {
        super(exchange);
    }

    CoinquistaListResponse<CoinquistaActiveOrder> getActiveOrders() {
        return coinquistaAuthenticated.activeOrders(apiKey);
    }

    String putOrder(CoinquistaOrderRequest orderRequest) {
        CoinquistaOrderResponse response = coinquistaAuthenticated.putOrder(apiKey, orderRequest);
        return response.getOrderId().toString();
    }

    boolean cancelOrder(String orderId) {
        coinquistaAuthenticated.cancelOrder(apiKey, orderId);
        return true;
    }

    CoinquistaListResponse<CoinquistaFinishedOrderResponse> getFinishedOrders() {
        return coinquistaAuthenticated.finishedOrders(apiKey);
    }

    UserTrades getTradeHistory(Date from, Date to) {
        List<UserTrade> userTrades = new ArrayList<>();
        boolean hasNextPage = true;
        for (int page = 1; hasNextPage; page++) {
            CoinquistaListResponse<UserDealResponse> userDealResponses = coinquistaAuthenticated.getUserLatestDeals(
                    apiKey, from, to, page
            );
            hasNextPage = userDealResponses.getNext() != null;
            for (UserDealResponse userDeal : userDealResponses.getResults()) {
                userTrades.add(CoinquistaAdapters.adaptUserDeal(userDeal));
            }
        }
        return new UserTrades(userTrades, Trades.TradeSortType.SortByTimestamp);
    }
}
