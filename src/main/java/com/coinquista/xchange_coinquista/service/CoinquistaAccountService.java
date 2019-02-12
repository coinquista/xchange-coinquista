package com.coinquista.xchange_coinquista.service;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.dto.account.AccountInfo;
import org.knowm.xchange.service.account.AccountService;
import org.knowm.xchange.service.trade.params.DefaultWithdrawFundsParams;
import org.knowm.xchange.service.trade.params.WithdrawFundsParams;

import java.io.IOException;
import java.math.BigDecimal;

public class CoinquistaAccountService extends CoinquistaAccountServiceRaw implements AccountService {
    public CoinquistaAccountService(Exchange exchange) {
        super(exchange);
    }

    @Override
    public AccountInfo getAccountInfo() {
        return super.getAccountInfo();
    }

    @Override
    public String withdrawFunds(Currency currency, BigDecimal amount, String address) throws IOException {
        super.withdraw(currency.getCurrencyCode(), address, amount);
        return "Success";
    }

    @Override
    public String withdrawFunds(WithdrawFundsParams params) throws IOException {
        if (params instanceof DefaultWithdrawFundsParams) {
            DefaultWithdrawFundsParams defaultParams = (DefaultWithdrawFundsParams) params;
            return withdrawFunds(
                    defaultParams.getCurrency(), defaultParams.getAmount(), defaultParams.getAddress());
        }
        throw new IllegalStateException("Don't know how to withdraw: " + params);
    }

    @Override
    public String requestDepositAddress(Currency currency, String... args) throws IOException {
        return super.getDepositAddress(currency.getCurrencyCode());
    }
}
