package com.coinquista.xchange_coinquista.dto.marketdata;

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
        "baseAsset",
        "baseAssetPrecision",
        "quoteAsset",
        "quoteAssetPrecision",
        "symbol"
})
public class Symbol {

    @JsonProperty("baseAsset")
    private String baseAsset;
    @JsonProperty("baseAssetPrecision")
    private String baseAssetPrecision;
    @JsonProperty("quoteAsset")
    private String quoteAsset;
    @JsonProperty("quoteAssetPrecision")
    private String quoteAssetPrecision;
    @JsonProperty("symbol")
    private String symbol;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Symbol() {
    }

    /**
     *
     * @param quoteAsset
     * @param symbol
     * @param baseAsset
     * @param baseAssetPrecision
     * @param quoteAssetPrecision
     */
    public Symbol(String baseAsset, String baseAssetPrecision, String quoteAsset, String quoteAssetPrecision, String symbol) {
        super();
        this.baseAsset = baseAsset;
        this.baseAssetPrecision = baseAssetPrecision;
        this.quoteAsset = quoteAsset;
        this.quoteAssetPrecision = quoteAssetPrecision;
        this.symbol = symbol;
    }

    @JsonProperty("baseAsset")
    public String getBaseAsset() {
        return baseAsset;
    }

    @JsonProperty("baseAsset")
    public void setBaseAsset(String baseAsset) {
        this.baseAsset = baseAsset;
    }

    @JsonProperty("baseAssetPrecision")
    public String getBaseAssetPrecision() {
        return baseAssetPrecision;
    }

    @JsonProperty("baseAssetPrecision")
    public void setBaseAssetPrecision(String baseAssetPrecision) {
        this.baseAssetPrecision = baseAssetPrecision;
    }

    @JsonProperty("quoteAsset")
    public String getQuoteAsset() {
        return quoteAsset;
    }

    @JsonProperty("quoteAsset")
    public void setQuoteAsset(String quoteAsset) {
        this.quoteAsset = quoteAsset;
    }

    @JsonProperty("quoteAssetPrecision")
    public String getQuoteAssetPrecision() {
        return quoteAssetPrecision;
    }

    @JsonProperty("quoteAssetPrecision")
    public void setQuoteAssetPrecision(String quoteAssetPrecision) {
        this.quoteAssetPrecision = quoteAssetPrecision;
    }

    @JsonProperty("symbol")
    public String getSymbol() {
        return symbol;
    }

    @JsonProperty("symbol")
    public void setSymbol(String symbol) {
        this.symbol = symbol;
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
