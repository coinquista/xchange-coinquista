package com.coinquista.dto.trade;

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
        "left",
        "orderId",
        "price",
        "side",
        "symbol",
        "type"
})
public class CoinquistaOrderResponse {

    @JsonProperty("left")
    private String left;
    @JsonProperty("orderId")
    private Integer orderId;
    @JsonProperty("price")
    private String price;
    @JsonProperty("side")
    private Integer side;
    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("type")
    private Integer type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public CoinquistaOrderResponse() {
    }

    /**
     *
     * @param price
     * @param symbol
     * @param side
     * @param left
     * @param type
     * @param orderId
     */
    public CoinquistaOrderResponse(String left, Integer orderId, String price, Integer side, String symbol, Integer type) {
        super();
        this.left = left;
        this.orderId = orderId;
        this.price = price;
        this.side = side;
        this.symbol = symbol;
        this.type = type;
    }

    @JsonProperty("left")
    public String getLeft() {
        return left;
    }

    @JsonProperty("left")
    public void setLeft(String left) {
        this.left = left;
    }

    @JsonProperty("orderId")
    public Integer getOrderId() {
        return orderId;
    }

    @JsonProperty("orderId")
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @JsonProperty("price")
    public String getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(String price) {
        this.price = price;
    }

    @JsonProperty("side")
    public Integer getSide() {
        return side;
    }

    @JsonProperty("side")
    public void setSide(Integer side) {
        this.side = side;
    }

    @JsonProperty("symbol")
    public String getSymbol() {
        return symbol;
    }

    @JsonProperty("symbol")
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @JsonProperty("type")
    public Integer getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(Integer type) {
        this.type = type;
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