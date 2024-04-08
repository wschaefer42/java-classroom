package org.example.hellospring.resource;

import org.example.hellospring.domain.Address;
import org.example.hellospring.service.AddressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressResource {
    private final AddressService addressService;

    public record AddressDto(String street, String houseNo, String city, String countryCode) {
        static AddressDto from(Address address) {
            return new AddressDto(
                    address.getStreet(),
                    address.getHouseNumber(),
                    address.getTown().getName(),
                    address.getTown().getCountryCode()
            );
        }
    }

    public AddressResource(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public List<AddressDto> getAll() {
        return addressService.findAll().stream().map(AddressDto::from).toList();
    }

    @GetMapping("/{id}")
    public AddressDto getById(@PathVariable Long id) {
        return AddressDto.from(addressService.findById(id));
    }

    @PostMapping
    public Address add(@RequestBody AddressDto address) {
        return addressService.addAddress(
                address.street,
                address.houseNo,
                address.city,
                address.countryCode
        );
    }
}
