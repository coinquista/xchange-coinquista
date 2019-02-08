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
        "amount",
        "baseAsset",
        "id",
        "orderId",
        "quoteAsset",
        "rate",
        "timestamp",
        "type"
})
public class UserDealResponse {

    @JsonProperty("amount")
    private String amount;
    @JsonProperty("baseAsset")
    private String baseAsset;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("orderId")
    private String orderId;
    @JsonProperty("quoteAsset")
    private String quoteAsset;
    @JsonProperty("rate")
    private String rate;
    @JsonProperty("timestamp")
    private String timestamp;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public UserDealResponse() {
    }

    /**
     *
     * @param timestamp
     * @param quoteAsset
     * @param id
     * @param amount
     * @param rate
     * @param baseAsset
     * @param type
     * @param orderId
     */
    public UserDealResponse(String amount, String baseAsset, Integer id, String orderId, String quoteAsset, String rate, String timestamp, String type) {
        super();
        this.amount = amount;
        this.baseAsset = baseAsset;
        this.id = id;
        this.orderId = orderId;
        this.quoteAsset = quoteAsset;
        this.rate = rate;
        this.timestamp = timestamp;
        this.type = type;
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

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("orderId")
    public String getOrderId() {
        return orderId;
    }

    @JsonProperty("orderId")
    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    @JsonProperty("timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
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