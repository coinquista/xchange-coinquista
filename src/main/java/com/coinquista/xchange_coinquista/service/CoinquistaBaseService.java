package com.coinquista.xchange_coinquista.service;

import org.knowm.xchange.Exchange;
import com.coinquista.xchange_coinquista.Coinquista;
import com.coinquista.xchange_coinquista.CoinquistaAuthenticated;
import org.knowm.xchange.service.BaseExchangeService;
import org.knowm.xchange.service.BaseService;
import si.mazi.rescu.RestProxyFactory;

public class CoinquistaBaseService extends BaseExchangeService implements BaseService {
    protected final Coinquista coinquista;
    protected final CoinquistaAuthenticated coinquistaAuthenticated;
    protected final String apiKey;
    protected CoinquistaBaseService(Exchange exchange) {
        super(exchange);
        this.coinquista = RestProxyFactory.createProxy(
                Coinquista.class, exchange.getExchangeSpecification().getSslUri()
        );
        this.coinquistaAuthenticated = RestProxyFactory.createProxy(
                CoinquistaAuthenticated.class, exchange.getExchangeSpecification().getSslUri()
        );
        this.apiKey = "Token " + exchange.getExchangeSpecification().getApiKey();
    }
}
