package com.dukan.customer.customer_service.dto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"firstName",
"lastName",
"email",
"phoneNumber",
"address"
})
public class UserDTO 
{
	@JsonProperty("firstName")
	@NotNull(message = "name can not be null")
	@NotBlank(message = "name can not be blank")
	private String firstName;
	
	@JsonProperty("lastName")
	private String lastName;
	
	@JsonProperty("email")
	@Email
	private String email;
	
	@JsonProperty("phoneNumber")
	@NotNull(message = "number can not be null")
	@Pattern(regexp = "^\\d{10}$", message = "please provide valid number")
	private String phoneNumber;
	
	@JsonProperty("address")
	@Valid
	private List<AddressDto> addressDto;
	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("firstName")
	public String getFirstName() {
	return firstName;
	}

	@JsonProperty("firstName")
	public void setFirstName(String firstName) {
	this.firstName = firstName;
	}

	@JsonProperty("lastName")
	public String getLastName() {
	return lastName;
	}

	@JsonProperty("lastName")
	public void setLastName(String lastName) {
	this.lastName = lastName;
	}

	@JsonProperty("email")
	public String getEmail() {
	return email;
	}

	@JsonProperty("email")
	public void setEmail(String email) {
	this.email = email;
	}

	@JsonProperty("phoneNumber")
	public String getPhoneNumber() {
	return phoneNumber;
	}

	@JsonProperty("phoneNumber")
	public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
	}

	@JsonProperty("address")
	public List<AddressDto> getAddress() {
	return addressDto;
	}

	@JsonProperty("address")
	public void setAddress(List<AddressDto> addressDto) {
	this.addressDto = addressDto;
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
		return "UserDTO [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", addressDto=" + addressDto.toString() + ", additionalProperties=" + additionalProperties + "]";
	}
	
	
}
