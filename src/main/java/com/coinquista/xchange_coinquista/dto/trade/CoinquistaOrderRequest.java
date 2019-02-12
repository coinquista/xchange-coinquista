package com.coinquista.xchange_coinquista.dto.trade;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "symbol",
        "side",
        "type",
        "baseAmount",
        "quoteAmount",
        "price"
})
public class CoinquistaOrderRequest {

    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("side")
    private String side;
    @JsonProperty("type")
    private String type;
    @JsonProperty("baseAmount")
    private String baseAmount;
    @JsonProperty("quoteAmount")
    private String quoteAmount;
    @JsonProperty("price")
    private String price;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public CoinquistaOrderRequest() {
    }

    /**
     *
     * @param baseAmount
     * @param price
     * @param symbol
     * @param side
     * @param type
     * @param quoteAmount
     */
    public CoinquistaOrderRequest(String symbol, String side, String type, String baseAmount, String quoteAmount, String price) {
        super();
        this.symbol = symbol;
        this.side = side;
        this.type = type;
        this.baseAmount = baseAmount;
        this.quoteAmount = quoteAmount;
        this.price = price;
    }

    @JsonProperty("symbol")
    public String getSymbol() {
        return symbol;
    }

    @JsonProperty("symbol")
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @JsonProperty("side")
    public String getSide() {
        return side;
    }

    @JsonProperty("side")
    public void setSide(String side) {
        this.side = side;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("baseAmount")
    public String getBaseAmount() {
        return baseAmount;
    }

    @JsonProperty("baseAmount")
    public void setBaseAmount(String baseAmount) {
        this.baseAmount = baseAmount;
    }

    @JsonProperty("quoteAmount")
    public String getQuoteAmount() {
        return quoteAmount;
    }

    @JsonProperty("quoteAmount")
    public void setQuoteAmount(String quoteAmount) {
        this.quoteAmount = quoteAmount;
    }

    @JsonProperty("price")
    public String getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(String price) {
        this.price = price;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}