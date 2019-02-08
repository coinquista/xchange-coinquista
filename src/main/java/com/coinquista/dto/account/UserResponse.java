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
        "countryCode",
        "currency",
        "currencyPrecision",
        "email",
        "id",
        "language",
        "phoneNumber",
        "referredBy",
        "timezone",
        "username",
        "usernameModified"
})
public class UserResponse {

    @JsonProperty("countryCode")
    private String countryCode;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("currencyPrecision")
    private Integer currencyPrecision;
    @JsonProperty("email")
    private String email;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("language")
    private String language;
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    @JsonProperty("referredBy")
    private Object referredBy;
    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("username")
    private String username;
    @JsonProperty("usernameModified")
    private Boolean usernameModified;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public UserResponse() {
    }

    /**
     *
     * @param id
     * @param username
     * @param timezone
     * @param phoneNumber
     * @param email
     * @param currencyPrecision
     * @param countryCode
     * @param usernameModified
     * @param referredBy
     * @param language
     * @param currency
     */
    public UserResponse(String countryCode, String currency, Integer currencyPrecision, String email, Integer id, String language, String phoneNumber, Object referredBy, String timezone, String username, Boolean usernameModified) {
        super();
        this.countryCode = countryCode;
        this.currency = currency;
        this.currencyPrecision = currencyPrecision;
        this.email = email;
        this.id = id;
        this.language = language;
        this.phoneNumber = phoneNumber;
        this.referredBy = referredBy;
        this.timezone = timezone;
        this.username = username;
        this.usernameModified = usernameModified;
    }

    @JsonProperty("countryCode")
    public String getCountryCode() {
        return countryCode;
    }

    @JsonProperty("countryCode")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("currencyPrecision")
    public Integer getCurrencyPrecision() {
        return currencyPrecision;
    }

    @JsonProperty("currencyPrecision")
    public void setCurrencyPrecision(Integer currencyPrecision) {
        this.currencyPrecision = currencyPrecision;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }

    @JsonProperty("phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @JsonProperty("phoneNumber")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @JsonProperty("referredBy")
    public Object getReferredBy() {
        return referredBy;
    }

    @JsonProperty("referredBy")
    public void setReferredBy(Object referredBy) {
        this.referredBy = referredBy;
    }

    @JsonProperty("timezone")
    public String getTimezone() {
        return timezone;
    }

    @JsonProperty("timezone")
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty("usernameModified")
    public Boolean getUsernameModified() {
        return usernameModified;
    }

    @JsonProperty("usernameModified")
    public void setUsernameModified(Boolean usernameModified) {
        this.usernameModified = usernameModified;
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