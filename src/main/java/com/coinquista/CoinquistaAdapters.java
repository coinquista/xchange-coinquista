package com.coinquista;

import com.coinquista.dto.marketdata.DealResponse;
import com.coinquista.dto.marketdata.OrderbookOrderResponse;
import com.coinquista.dto.trade.CoinquistaActiveOrder;
import com.coinquista.dto.trade.CoinquistaOrderRequest;
import com.coinquista.dto.trade.UserDealResponse;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.marketdata.Trade;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.dto.trade.MarketOrder;
import org.knowm.xchange.dto.trade.UserTrade;
import org.knowm.xchange.exceptions.ExchangeException;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

public class CoinquistaAdapters {
    private CoinquistaAdapters() {}

    public static Date parseDatetime(String datetimeString) {
        return Date.from(Instant.parse(datetimeString));

    }

    public static String getMarketName(CurrencyPair pair) {
        return pair.base.toString() + pair.counter.toString();
    }

    public static LimitOrder adaptActiveOrder(CoinquistaActiveOrder order) {
        Order.OrderType type;
        switch (order.getSide()) {
            case 1:
                type = Order.OrderType.ASK;
                break;
            case 2:
                type = Order.OrderType.BID;
                break;
            default:
                throw new ExchangeException("Wrong API response: side must be 1 or 2");
        }

        CurrencyPair pair = new CurrencyPair(order.getBaseAsset(), order.getQuoteAsset());
        Date timestamp = parseDatetime(order.getCreatedAt());
        return new LimitOrder(
                type, new BigDecimal(order.getAmount()), new BigDecimal(order.getCompletedAmount()), pair,
                order.getId().toString(), timestamp, new BigDecimal(order.getPrice())
        );
    }

    public static CoinquistaOrderRequest adaptMarketOrder(MarketOrder marketOrder) {
        String symbol = getMarketName(marketOrder.getCurrencyPair());
        if (marketOrder.getType() == Order.OrderType.BID) {
            return new CoinquistaOrderRequest(
                    symbol, "BUY", "MARKET", null, marketOrder.getOriginalAmount().toString(),
                    marketOrder.getAveragePrice().toString()
            );
        }
        else if (marketOrder.getType() == Order.OrderType.ASK) {
            return new CoinquistaOrderRequest(symbol, "SELL", "MARKET",
                    marketOrder.getOriginalAmount().toString(),null, null
            );
        }
        else {
            throw new ExchangeException("Unsupported order type");
        }
    }

    public static CoinquistaOrderRequest adaptLimitOrder(LimitOrder limitOrder) {
        String symbol = limitOrder.getCurrencyPair().base.toString() + limitOrder.getCurrencyPair().counter.toString();
        String side;
        switch (limitOrder.getType()) {
            case BID: side = "BUY"; break;
            case ASK: side = "SELL"; break;
            default: throw new ExchangeException("Unsupported order type");
        }
        return new CoinquistaOrderRequest(symbol, side, "LIMIT", limitOrder.getOriginalAmount().toString(),
                null, limitOrder.getLimitPrice().toString()
        );
    }

    public static LimitOrder adaptOrderbookOrder(OrderbookOrderResponse order, Order.OrderType type, CurrencyPair pair) {
        Date timestamp = parseDatetime(order.getTimestamp());
        return new LimitOrder(
                type, new BigDecimal(order.getAmount()), new BigDecimal(order.getCompletedAmount()), pair,
                order.getOrderId().toString(), timestamp, new BigDecimal(order.getPrice())
        );
    }

    public static Trade adaptDeal(DealResponse deal, CurrencyPair pair) {
        Order.OrderType type = adaptType(deal.getType());
        Date timestamp = parseDatetime(deal.getTimestamp());
        return new Trade(type, new BigDecimal(deal.getAmount()), pair, new BigDecimal(deal.getRate()), timestamp, null);
    }

    public static UserTrade adaptUserDeal(UserDealResponse userDeal) {
        Order.OrderType type = adaptType(userDeal.getType());
        CurrencyPair pair = new CurrencyPair(userDeal.getBaseAsset(), userDeal.getQuoteAsset());
        Date timestamp = parseDatetime(userDeal.getTimestamp());
        return new UserTrade(
                type, new BigDecimal(userDeal.getAmount()), pair, new BigDecimal(userDeal.getRate()),
                timestamp, userDeal.getId().toString(), userDeal.getOrderId(), null, null
        );
    }

    private static Order.OrderType adaptType(String coinquistaType) {
        switch (coinquistaType) {
            case "BUY":
                return Order.OrderType.BID;
            case "SELL":
                return Order.OrderType.ASK;
            default:
                throw new ExchangeException("Wrong API response: order type must be BUY or SELL");
        }
    }
}
