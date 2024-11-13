package com.bookso.customer.controller;

import com.bookso.customer.constants.CustomerConstants;
import com.bookso.customer.dto.CustomerDto;
import com.bookso.customer.dto.NewCustomerDto;
import com.bookso.customer.dto.ProfileDto;
import com.bookso.customer.dto.ResponseDto;
import com.bookso.customer.service.ICustomerService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookso/v1")
public class CustomerController {

    private static final String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{2,})$";
    private static final String mobileRegex = "^[0-9]{10}$";
    @Autowired
    ICustomerService customerService;

    @PostMapping("/customers")
    public ResponseEntity<ResponseDto> createCustomer(@Valid @RequestBody NewCustomerDto newCustomer){
     customerService.createCustomer(newCustomer);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(CustomerConstants.STATUS_201,CustomerConstants.CUSTOMER_CREATED_SUCCESSFULLY));
    }

    @GetMapping("email/{email}/customers")
    public ResponseEntity<CustomerDto> getCustomerByEmail(@Valid @PathVariable("email")
                                                              @Pattern(regexp = emailRegex, message = "Invalid Mail id")
                                                              String email){
        CustomerDto customer = customerService.getCustomerByEmail(email);
        return ResponseEntity.status(HttpStatus.OK).body(customer);
    }

    @GetMapping("contact/{contact}/customers")
    public ResponseEntity<CustomerDto> getCustomerByContact(@Valid @PathVariable("contact")
                                                                @Pattern(regexp = mobileRegex, message = "Invalid Mobile number")
                                                            String contact){
        CustomerDto customerDto = customerService.getCustomerByMobile(contact);
        return ResponseEntity.status(HttpStatus.OK).body(customerDto);

    }

    @PutMapping("customers/{email}")
    public ResponseEntity<ResponseDto> updateCustomer(@PathVariable ("email") String email,
                                                      @Valid @RequestBody CustomerDto customerDto){
        customerService.updateCustomer(email, customerDto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDto(CustomerConstants.STATUS_200, CustomerConstants.CUSTOMER_UPDATED_SUCCESSFULLY));
    }

    @DeleteMapping("/customers/{email}")
    public ResponseEntity<ResponseDto> deleteCustomer(@PathVariable ("email") String email){
        customerService.deleteCustomer(email);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDto(CustomerConstants.STATUS_201, CustomerConstants.CUSTOMER_DELETED_SUCCESSFULLY));
    }

    @GetMapping("/customers/{email}/profile")
    public ResponseEntity<ProfileDto> getProfile(@PathVariable("email") String email){
        ProfileDto profileDto = customerService.getMyProfile(email);
        return ResponseEntity.status(HttpStatus.OK).body(profileDto);
    }

    @PutMapping("/customers/{customerId}/{subscriptionType}/{subscriptionDurationType}/profile")
    public ResponseEntity<ResponseDto> updateSubscription(@PathVariable("customerId") Long customerId,
                                                          @PathVariable("subscriptionType") int subscriptionType,
                                                          @PathVariable("subscriptionDurationType") int subscriptionDurationType){
        customerService.updateSubscription(customerId,subscriptionType,subscriptionDurationType);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(CustomerConstants.STATUS_200, CustomerConstants.PROFILE_UPDATED_SUCCESSFULLY));
    }

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDto>> getAllCustomers(){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.getAll());
    }

}
