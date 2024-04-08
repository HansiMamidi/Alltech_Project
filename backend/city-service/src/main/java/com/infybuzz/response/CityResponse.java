package com.infybuzz.response;

import javax.persistence.Column;

import com.infybuzz.entity.City;

public class CityResponse {

	private Long cityId;
	private String cityName;
	public Long getCityId() {
		return cityId;
	}
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public CityResponse(City city) {
		super();
		this.cityId = city.getCityId();
		this.cityName = city.getCityName();
	}
	
}
