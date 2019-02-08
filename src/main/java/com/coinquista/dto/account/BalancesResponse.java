package com.coinquista.dto.account;

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
        "asset",
        "balance"
})
public class BalancesResponse {

    @JsonProperty("asset")
    private String asset;
    @JsonProperty("balance")
    private String balance;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public BalancesResponse() {
    }

    /**
     *
     * @param balance
     * @param asset
     */
    public BalancesResponse(String asset, String balance) {
        super();
        this.asset = asset;
        this.balance = balance;
    }

    @JsonProperty("asset")
    public String getAsset() {
        return asset;
    }

    @JsonProperty("asset")
    public void setAsset(String asset) {
        this.asset = asset;
    }

    @JsonProperty("balance")
    public String getBalance() {
        return balance;
    }

    @JsonProperty("balance")
    public void setBalance(String balance) {
        this.balance = balance;
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