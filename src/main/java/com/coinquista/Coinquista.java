package com.coinquista;

import com.coinquista.dto.marketdata.DealResponse;
import com.coinquista.dto.marketdata.ExchangeInfoResponse;
import com.coinquista.dto.trade.CoinquistaListResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/api/v1/")
@Consumes(value = MediaType.APPLICATION_JSON)
public interface Coinquista {
    @GET
    @Path("exchangeInfo/")
    ExchangeInfoResponse getExchangeInfo();

    @GET
    @Path("latestDeals/")
    CoinquistaListResponse<DealResponse> getLatestDeals(
            @HeaderParam("Authorization") String apiKey,
            @QueryParam("symbol") String symbol,
            @QueryParam("page") int page
    );
}
