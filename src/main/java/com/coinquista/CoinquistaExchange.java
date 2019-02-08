package com.coinquista;

import com.coinquista.service.CoinquistaAccountService;
import com.coinquista.service.CoinquistaMarketDataService;
import com.coinquista.service.CoinquistaTradeService;
import org.knowm.xchange.BaseExchange;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.utils.nonce.AtomicLongIncrementalTime2013NonceFactory;
import si.mazi.rescu.SynchronizedValueFactory;


public class CoinquistaExchange extends BaseExchange implements Exchange {
    private SynchronizedValueFactory<Long> nonceFactory = new AtomicLongIncrementalTime2013NonceFactory();

    @Override
    protected void initServices() {
        this.marketDataService = new CoinquistaMarketDataService(this);
        this.accountService = new CoinquistaAccountService(this);
        this.tradeService = new CoinquistaTradeService(this);
    }

    @Override
    public SynchronizedValueFactory<Long> getNonceFactory() {
        return nonceFactory;
    }

    @Override
    public ExchangeSpecification getDefaultExchangeSpecification() {
        ExchangeSpecification exchangeSpecification = new ExchangeSpecification(this.getClass().getCanonicalName());
        exchangeSpecification.setSslUri("https://b.stg.coinquista.com");
        exchangeSpecification.setHost("https://b.stg.coinquista.com");
        exchangeSpecification.setPort(443);
        exchangeSpecification.setExchangeName("Coinquista");
        exchangeSpecification.setExchangeDescription("Coinquista is a crypto currency exchange based in Poland.");

        return exchangeSpecification;
    }

    @Override
    public void remoteInit() {
        exchangeMetaData = ((CoinquistaMarketDataService) marketDataService).getExchangeMetaData();
    }
}
