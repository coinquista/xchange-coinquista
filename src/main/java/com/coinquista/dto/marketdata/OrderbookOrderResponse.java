package com.coinquista.dto.marketdata;
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
        "completedAmount",
        "orderId",
        "price",
        "timestamp"
})
public class OrderbookOrderResponse {

    @JsonProperty("amount")
    private String amount;
    @JsonProperty("completedAmount")
    private String completedAmount;
    @JsonProperty("orderId")
    private Integer orderId;
    @JsonProperty("price")
    private String price;
    @JsonProperty("timestamp")
    private String timestamp;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public OrderbookOrderResponse() {
    }

    /**
     *
     * @param timestamp
     * @param completedAmount
     * @param amount
     * @param price
     * @param orderId
     */
    public OrderbookOrderResponse(String amount, String completedAmount, Integer orderId, String price, String timestamp) {
        super();
        this.amount = amount;
        this.completedAmount = completedAmount;
        this.orderId = orderId;
        this.price = price;
        this.timestamp = timestamp;
    }

    @JsonProperty("amount")
    public String getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(String amount) {
        this.amount = amount;
    }

    @JsonProperty("completedAmount")
    public String getCompletedAmount() {
        return completedAmount;
    }

    @JsonProperty("completedAmount")
    public void setCompletedAmount(String completedAmount) {
        this.completedAmount = completedAmount;
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

    @JsonProperty("timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
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
