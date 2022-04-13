package com.coforge.country.service;

import com.coforge.country.entity.Country;

import java.util.List;

public interface CountryService {
    public List<Country> getAllCountries();
    public Country getCountryById(int id);
  /*  public Boolean isCountryExist();*/
    public Country registerCountry(Country country);
    public Country updateCountry(Country country);
}
