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
        "amount",
        "baseAsset",
        "completedAmount",
        "completedRatio",
        "createdAt",
        "dealsCount",
        "id",
        "market",
        "orderType",
        "price",
        "quoteAsset",
        "rate",
        "side"
})
public class CoinquistaFinishedOrderResponse {

    @JsonProperty("amount")
    private String amount;
    @JsonProperty("baseAsset")
    private String baseAsset;
    @JsonProperty("completedAmount")
    private String completedAmount;
    @JsonProperty("completedRatio")
    private String completedRatio;
    @JsonProperty("createdAt")
    private String createdAt;
    @JsonProperty("dealsCount")
    private Integer dealsCount;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("market")
    private String market;
    @JsonProperty("orderType")
    private Integer orderType;
    @JsonProperty("price")
    private String price;
    @JsonProperty("quoteAsset")
    private String quoteAsset;
    @JsonProperty("rate")
    private String rate;
    @JsonProperty("side")
    private Integer side;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public CoinquistaFinishedOrderResponse() {
    }

    /**
     *
     * @param quoteAsset
     * @param orderType
     * @param amount
     * @param completedAmount
     * @param id
     * @param market
     * @param price
     * @param rate
     * @param baseAsset
     * @param side
     * @param createdAt
     * @param completedRatio
     * @param dealsCount
     */
    public CoinquistaFinishedOrderResponse(String amount, String baseAsset, String completedAmount, String completedRatio, String createdAt, Integer dealsCount, Integer id, String market, Integer orderType, String price, String quoteAsset, String rate, Integer side) {
        super();
        this.amount = amount;
        this.baseAsset = baseAsset;
        this.completedAmount = completedAmount;
        this.completedRatio = completedRatio;
        this.createdAt = createdAt;
        this.dealsCount = dealsCount;
        this.id = id;
        this.market = market;
        this.orderType = orderType;
        this.price = price;
        this.quoteAsset = quoteAsset;
        this.rate = rate;
        this.side = side;
    }

    @JsonProperty("amount")
    public String getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(String amount) {
        this.amount = amount;
    }

    @JsonProperty("baseAsset")
    public String getBaseAsset() {
        return baseAsset;
    }

    @JsonProperty("baseAsset")
    public void setBaseAsset(String baseAsset) {
        this.baseAsset = baseAsset;
    }

    @JsonProperty("completedAmount")
    public String getCompletedAmount() {
        return completedAmount;
    }

    @JsonProperty("completedAmount")
    public void setCompletedAmount(String completedAmount) {
        this.completedAmount = completedAmount;
    }

    @JsonProperty("completedRatio")
    public String getCompletedRatio() {
        return completedRatio;
    }

    @JsonProperty("completedRatio")
    public void setCompletedRatio(String completedRatio) {
        this.completedRatio = completedRatio;
    }

    @JsonProperty("createdAt")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("createdAt")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("dealsCount")
    public Integer getDealsCount() {
        return dealsCount;
    }

    @JsonProperty("dealsCount")
    public void setDealsCount(Integer dealsCount) {
        this.dealsCount = dealsCount;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("market")
    public String getMarket() {
        return market;
    }

    @JsonProperty("market")
    public void setMarket(String market) {
        this.market = market;
    }

    @JsonProperty("orderType")
    public Integer getOrderType() {
        return orderType;
    }

    @JsonProperty("orderType")
    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    @JsonProperty("price")
    public String getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(String price) {
        this.price = price;
    }

    @JsonProperty("quoteAsset")
    public String getQuoteAsset() {
        return quoteAsset;
    }

    @JsonProperty("quoteAsset")
    public void setQuoteAsset(String quoteAsset) {
        this.quoteAsset = quoteAsset;
    }

    @JsonProperty("rate")
    public String getRate() {
        return rate;
    }

    @JsonProperty("rate")
    public void setRate(String rate) {
        this.rate = rate;
    }

    @JsonProperty("side")
    public Integer getSide() {
        return side;
    }

    @JsonProperty("side")
    public void setSide(Integer side) {
        this.side = side;
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