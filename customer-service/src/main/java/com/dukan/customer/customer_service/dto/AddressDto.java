package com.dukan.customer.customer_service.dto;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"fullAddress",
"city",
"country",
"pinCode"
})
public class AddressDto 
{
	@JsonProperty("fullAddress")
	@NotNull(message = "Address can not be null")
	@NotBlank(message = "Address can not be blank")
	private String fullAddress;
	
	@JsonProperty("city")
	@NotNull(message = "city can not be null")
	@NotBlank(message = "city can not be blank")
	private String city;
	
	@JsonProperty("country")
	@NotNull(message = "country can not be null")
	@NotBlank(message = "country can not be blank")
	private String country;
	
	@JsonProperty("pinCode")
	@NotNull(message = "pinCode can not be null")
	@Pattern(regexp = "^\\d{5}$", message = "please provide valid pin code")
	private String pinCode;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("fullAddress")
	public String getFullAddress() {
	return fullAddress;
	}

	@JsonProperty("fullAddress")
	public void setFullAddress(String fullAddress) {
	this.fullAddress = fullAddress;
	}

	@JsonProperty("city")
	public String getCity() {
	return city;
	}

	@JsonProperty("city")
	public void setCity(String city) {
	this.city = city;
	}

	@JsonProperty("country")
	public String getCountry() {
	return country;
	}

	@JsonProperty("country")
	public void setCountry(String country) {
	this.country = country;
	}

	@JsonProperty("pinCode")
	public String getPinCode() {
	return pinCode;
	}

	@JsonProperty("pinCode")
	public void setPinCode(String pinCode) {
	this.pinCode = pinCode;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
	return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
	}

	@Override
	public String toString() {
		return "AddressDto [fullAddress=" + fullAddress + ", city=" + city + ", country=" + country + ", pinCode="
				+ pinCode + ", additionalProperties=" + additionalProperties + "]";
	}
	
	
}
