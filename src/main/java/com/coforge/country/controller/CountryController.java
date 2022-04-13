package com.coforge.country.controller;

import com.coforge.country.entity.Country;
import com.coforge.country.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {
    @Autowired
    CountryService countryService;
@GetMapping("/getall")
    public ResponseEntity<?> getCountries(){
        ResponseEntity<?> resp=null;
try {
    List<Country> list=countryService.getAllCountries();
    resp=new ResponseEntity<>(list, HttpStatus.FOUND);

}catch (Exception e){
    resp=new ResponseEntity<String>("country data not exist", HttpStatus.INTERNAL_SERVER_ERROR);
}
return resp;

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getCountryById(@PathVariable("id") int id){
    ResponseEntity <?>resp=null;
    try{
        Country countryById=countryService.getCountryById(id);

        resp=new ResponseEntity<>(countryById,HttpStatus.FOUND);

    }catch (Exception e){

        resp=new ResponseEntity<String>("country data not exist of id ="+id, HttpStatus.INTERNAL_SERVER_ERROR);

    }
    return resp;
    }

    @PostMapping("/register")
    public ResponseEntity<?> saveCountry(@RequestBody Country country){
        ResponseEntity <?>resp=null;
        try{
            Country count=countryService.registerCountry(country);

            resp=new ResponseEntity<>(count,HttpStatus.CREATED);

        }catch (Exception e){

            resp=new ResponseEntity<String>("country data is not saved", HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return resp;

    }
}
