package com.gaw.dvdrentalcli.service;

import com.gaw.dvdrentalcli.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;


}
