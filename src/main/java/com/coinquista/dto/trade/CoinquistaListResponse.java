package com.coinquista.dto.trade;

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
        "count",
        "next",
        "previous",
        "results"
})
public class CoinquistaListResponse<T> {

    @JsonProperty("count")
    private Integer count;
    @JsonProperty("next")
    private Object next;
    @JsonProperty("previous")
    private Object previous;
    @JsonProperty("results")
    private List<T> results = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public CoinquistaListResponse() {
    }

    /**
     *
     * @param results
     * @param previous
     * @param count
     * @param next
     */
    public CoinquistaListResponse(Integer count, Object next, Object previous, List<T> results) {
        super();
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

    @JsonProperty("count")
    public Integer getCount() {
        return count;
    }

    @JsonProperty("count")
    public void setCount(Integer count) {
        this.count = count;
    }

    @JsonProperty("next")
    public Object getNext() {
        return next;
    }

    @JsonProperty("next")
    public void setNext(Object next) {
        this.next = next;
    }

    @JsonProperty("previous")
    public Object getPrevious() {
        return previous;
    }

    @JsonProperty("previous")
    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    @JsonProperty("results")
    public List<T> getResults() {
        return results;
    }

    @JsonProperty("results")
    public void setResults(List<T> results) {
        this.results = results;
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
