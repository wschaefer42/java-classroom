package org.example.hellospring.service;

import jakarta.transaction.Transactional;
import org.example.hellospring.domain.Address;
import org.example.hellospring.domain.Town;
import org.example.hellospring.repository.AddressRepository;
import org.example.hellospring.repository.TownRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    private final AddressRepository addressRepository;
    private final TownRepository townRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository, TownRepository townRepository) {
        this.addressRepository = addressRepository;
        this.townRepository = townRepository;
    }

    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    public Address findById(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Transactional
    public Address addAddress(String street, String houseNo, String city, String countryCode) {
        Town town = townRepository.findByNameAndCountryCodeIgnoreCase(city, countryCode);
        if (town == null) {
            town = townRepository.save(new Town(city, countryCode));
        }

        Address address = new Address(street, houseNo, town);
        return addressRepository.save(address);
    }
}
