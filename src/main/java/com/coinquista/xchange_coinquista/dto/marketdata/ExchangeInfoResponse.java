package com.coinquista.xchange_coinquista.dto.marketdata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "symbols"
})
public class ExchangeInfoResponse {

    @JsonProperty("symbols")
    private List<Symbol> symbols = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public ExchangeInfoResponse() {
    }

    /**
     *
     * @param symbols
     */
    public ExchangeInfoResponse(List<Symbol> symbols) {
        super();
        this.symbols = symbols;
    }

    @JsonProperty("symbols")
    public List<Symbol> getSymbols() {
        return symbols;
    }

    @JsonProperty("symbols")
    public void setSymbols(List<Symbol> symbols) {
        this.symbols = symbols;
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
