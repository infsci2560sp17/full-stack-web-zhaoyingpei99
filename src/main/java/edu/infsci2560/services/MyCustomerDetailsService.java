package edu.infsci2560.services;


import edu.infsci2560.models.Customer;
import edu.infsci2560.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;





@Service
public class MyCustomerDetailsService implements UserDetailsService {

    @Autowired
    private CustomerRepository CustomerRepository;
    
    public MyCustomerDetailsService() {
        super();
    }

    // API
    
    @Override
    public UserDetails loadUserByUsername(final String username) {
        final Customer Customer = CustomerRepository.findByUsername(username);
        if (Customer == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyCustomerPrincipal(Customer);
    }
}