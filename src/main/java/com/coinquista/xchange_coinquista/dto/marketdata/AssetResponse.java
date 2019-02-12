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
        "fiat",
        "icon",
        "name",
        "precision",
        "primary",
        "showPrecision",
        "tickerSymbol",
        "withdrawalFeeConstant",
        "withdrawalFeeRate"
})
public class AssetResponse {

    @JsonProperty("fiat")
    private Boolean fiat;
    @JsonProperty("icon")
    private Object icon;
    @JsonProperty("name")
    private String name;
    @JsonProperty("precision")
    private Integer precision;
    @JsonProperty("primary")
    private Boolean primary;
    @JsonProperty("showPrecision")
    private Integer showPrecision;
    @JsonProperty("tickerSymbol")
    private String tickerSymbol;
    @JsonProperty("withdrawalFeeConstant")
    private String withdrawalFeeConstant;
    @JsonProperty("withdrawalFeeRate")
    private String withdrawalFeeRate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public AssetResponse() {
    }

    /**
     *
     * @param showPrecision
     * @param icon
     * @param withdrawalFeeConstant
     * @param tickerSymbol
     * @param precision
     * @param primary
     * @param name
     * @param fiat
     * @param withdrawalFeeRate
     */
    public AssetResponse(Boolean fiat, Object icon, String name, Integer precision, Boolean primary, Integer showPrecision, String tickerSymbol, String withdrawalFeeConstant, String withdrawalFeeRate) {
        super();
        this.fiat = fiat;
        this.icon = icon;
        this.name = name;
        this.precision = precision;
        this.primary = primary;
        this.showPrecision = showPrecision;
        this.tickerSymbol = tickerSymbol;
        this.withdrawalFeeConstant = withdrawalFeeConstant;
        this.withdrawalFeeRate = withdrawalFeeRate;
    }

    @JsonProperty("fiat")
    public Boolean getFiat() {
        return fiat;
    }

    @JsonProperty("fiat")
    public void setFiat(Boolean fiat) {
        this.fiat = fiat;
    }

    @JsonProperty("icon")
    public Object getIcon() {
        return icon;
    }

    @JsonProperty("icon")
    public void setIcon(Object icon) {
        this.icon = icon;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("precision")
    public Integer getPrecision() {
        return precision;
    }

    @JsonProperty("precision")
    public void setPrecision(Integer precision) {
        this.precision = precision;
    }

    @JsonProperty("primary")
    public Boolean getPrimary() {
        return primary;
    }

    @JsonProperty("primary")
    public void setPrimary(Boolean primary) {
        this.primary = primary;
    }

    @JsonProperty("showPrecision")
    public Integer getShowPrecision() {
        return showPrecision;
    }

    @JsonProperty("showPrecision")
    public void setShowPrecision(Integer showPrecision) {
        this.showPrecision = showPrecision;
    }

    @JsonProperty("tickerSymbol")
    public String getTickerSymbol() {
        return tickerSymbol;
    }

    @JsonProperty("tickerSymbol")
    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }

    @JsonProperty("withdrawalFeeConstant")
    public String getWithdrawalFeeConstant() {
        return withdrawalFeeConstant;
    }

    @JsonProperty("withdrawalFeeConstant")
    public void setWithdrawalFeeConstant(String withdrawalFeeConstant) {
        this.withdrawalFeeConstant = withdrawalFeeConstant;
    }

    @JsonProperty("withdrawalFeeRate")
    public String getWithdrawalFeeRate() {
        return withdrawalFeeRate;
    }

    @JsonProperty("withdrawalFeeRate")
    public void setWithdrawalFeeRate(String withdrawalFeeRate) {
        this.withdrawalFeeRate = withdrawalFeeRate;
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