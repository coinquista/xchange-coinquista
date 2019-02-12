package com.coinquista.xchange_coinquista.service;

import org.knowm.xchange.Exchange;
import com.coinquista.xchange_coinquista.dto.account.BalancesResponse;
import com.coinquista.xchange_coinquista.dto.account.UserResponse;
import com.coinquista.xchange_coinquista.dto.account.WithdrawRequest;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.dto.account.AccountInfo;
import org.knowm.xchange.dto.account.Balance;
import org.knowm.xchange.dto.account.Wallet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CoinquistaAccountServiceRaw extends CoinquistaBaseService {
    CoinquistaAccountServiceRaw(Exchange exchange) {
        super(exchange);
    }

    public AccountInfo getAccountInfo() {
        UserResponse userResponse = coinquistaAuthenticated.getUser(apiKey);
        List<BalancesResponse> balancesResponse = coinquistaAuthenticated.getBalances(apiKey);
        List<Balance> balances = new ArrayList<>();
        for (BalancesResponse balanceResponse : balancesResponse) {
            balances.add(new Balance(new Currency(balanceResponse.getAsset()), new BigDecimal(balanceResponse.getBalance())));
        }
        Wallet wallet = new Wallet(null, null, balances);
        return new AccountInfo(userResponse.getUsername(), wallet);
    }

    public String getDepositAddress(String currency) throws IOException {
        HashMap<String, String> response = coinquistaAuthenticated.returnDepositAddress(apiKey, currency);
        return response.get("address");
    }

    public void withdraw(String asset, String address, BigDecimal amount) {
        coinquistaAuthenticated.withdraw(apiKey, new WithdrawRequest(asset, amount.toString(), address));
    }
}
