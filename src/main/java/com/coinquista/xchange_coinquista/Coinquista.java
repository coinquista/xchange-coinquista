package com.coinquista.xchange_coinquista;

import com.coinquista.xchange_coinquista.dto.marketdata.AssetResponse;
import com.coinquista.xchange_coinquista.dto.marketdata.DealResponse;
import com.coinquista.xchange_coinquista.dto.marketdata.ExchangeInfoResponse;
import com.coinquista.xchange_coinquista.dto.trade.CoinquistaListResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/api/v1/")
@Consumes(value = MediaType.APPLICATION_JSON)
public interface Coinquista {
    @GET
    @Path("assets/")
    CoinquistaListResponse<AssetResponse> getAssets();

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
