package com.gaw.dvdrentalcli.repository;

import com.gaw.dvdrentalcli.model.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
    Country findByCountry(String country);
}
