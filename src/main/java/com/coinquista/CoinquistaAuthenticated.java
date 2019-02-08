package com.coinquista;

import com.coinquista.dto.account.BalancesResponse;
import com.coinquista.dto.account.UserResponse;
import com.coinquista.dto.account.WithdrawRequest;
import com.coinquista.dto.marketdata.AssetResponse;
import com.coinquista.dto.marketdata.OrderbookOrderResponse;
import com.coinquista.dto.trade.*;
import com.coinquista.dto.trade.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Path("api/v1/")
@Consumes(value = MediaType.APPLICATION_JSON)
public interface CoinquistaAuthenticated extends Coinquista {
    @GET
    @Path("assets/")
    CoinquistaListResponse<AssetResponse> getAssets(
            @HeaderParam("Authorization") String apiKey
    );

    @GET
    @Path("assets/{currency}/deposit_address/")
    HashMap<String, String> returnDepositAddress(
            @HeaderParam("Authorization") String apiKey,
            @PathParam("currency") String currency
    );

    @POST
    @Path("withdraw/")
    void withdraw(
            @HeaderParam("Authorization") String apiKey,
            WithdrawRequest withdrawRequest
    );

    @POST
    @Path("order/")
    CoinquistaOrderResponse putOrder(
            @HeaderParam("Authorization") String apiKey,
            CoinquistaOrderRequest orderRequest
    );

    @DELETE
    @Path("order/{order}/")
    void cancelOrder(
            @HeaderParam("Authorization") String apiKey,
            @PathParam("order") String order
    );

    @GET
    @Path("activeOrders/")
    CoinquistaListResponse<CoinquistaActiveOrder> activeOrders(
            @HeaderParam("Authorization") String apiKey
    );

    @GET
    @Path("finishedOrders/")
    CoinquistaListResponse<CoinquistaFinishedOrderResponse> finishedOrders(
            @HeaderParam("Authorization") String apiKey
    );

    @GET
    @Path("markets/{market}/buyOrders/")
    CoinquistaListResponse<OrderbookOrderResponse> buyOrders(
            @HeaderParam("Authorization") String apiKey,
            @PathParam("market") String market
    );

    @GET
    @Path("markets/{market}/sellOrders/")
    CoinquistaListResponse<OrderbookOrderResponse> sellOrders(
            @HeaderParam("Authorization") String apiKey,
            @PathParam("market") String market
    );

    @GET
    @Path("balances/")
    List<BalancesResponse> getBalances(
            @HeaderParam("Authorization") String apiKey
    );

    @GET
    @Path("users/me/")
    UserResponse getUser(
            @HeaderParam("Authorization") String apiKey
    );

    @GET
    @Path("userLatestDeals/")
    CoinquistaListResponse<UserDealResponse> getUserLatestDeals(
            @HeaderParam("Authorization") String apiKey,
            @QueryParam("startTime") Date startTime,
            @QueryParam("endTime") Date endTime,
            @QueryParam("page") int page
    );
}
