package com.bookso.customer.mapper;

import com.bookso.customer.dto.CustomerDto;
import com.bookso.customer.dto.NewCustomerDto;
import com.bookso.customer.dto.ProfileDto;
import com.bookso.customer.entity.Customer;
import com.bookso.customer.entity.Profile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/*
* author: santhosh kumar
* description: Mapper class for Customer and Profile
 */
@Service
@Slf4j
public class CustomerMapper {

    /*
    * author: Santhosh Kumar
    * param: CustomerDto
    * return: Customer
    */
    public Customer toCustomer(CustomerDto customerDto){
        Customer customer = new Customer();
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setContact(customerDto.getContact());
        customer.setSubscriptionType(customerDto.getSubscriptionType());

        return customer;
    }

    /*
    * author: santhosh kumar
    * params: Customer
    * returns: CustomerDto
    */
    public static CustomerDto toCustomerDto(Customer customer){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setContact(customer.getContact());
        customerDto.setSubscriptionType(customer.getSubscriptionType());

        return customerDto;
    }

    /*
    * author: santhosh kumar
    * params: ProfileDto
    * returns: Profile
    */
    public Profile toProfile(ProfileDto profileDto){
        Profile profile = new Profile();
        profile.setCustomerId(profileDto.getCustomerId());
        profile.setSubscriptionType(profile.getSubscriptionType());
        profile.setSubscriptionDuration(profile.getSubscriptionDuration());
        profile.setSubscribedOn(profileDto.getSubscribedOn());
        profile.setValidTill(profileDto.getValidTill());

        return profile;
    }

    /*
     * author: santhosh kumar
     * params: Profile
     * returns: ProfileDto
     */
    public ProfileDto toProfileDto(Profile profile){
        ProfileDto profileDto = new ProfileDto();
        profileDto.setCustomerId(profile.getCustomerId());
        profileDto.setSubscriptionType(profile.getSubscriptionType());
        profileDto.setSubscriptionDuration(profile.getSubscriptionDuration());
        profileDto.setSubscribedOn(profile.getSubscribedOn());
        profileDto.setValidTill(profile.getValidTill());

        return profileDto;
    }

    /*
    * author: santhosh kumar
    * params: NewCustomerDto
    * returns: CustomerDto
    * description: Mapper method to Change NewCustomerDto to Customer
     */
    public Customer newCustomerMapper(NewCustomerDto newCustomerDto){
        Customer customer = new Customer();
        customer.setName(newCustomerDto.getName());
        customer.setEmail(newCustomerDto.getEmail());
        customer.setContact(newCustomerDto.getContact());

        return customer;
    }


}
