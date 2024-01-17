package com.roni.qeats.security;


import com.roni.qeats.models.RestaurantEmployee;
import com.roni.qeats.models.UserLoginDetails;
import com.roni.qeats.models.Users;
import com.roni.qeats.repositories.RestuarantEmployeeRepository;
import com.roni.qeats.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {
// whenever spring security needs to know the user details,It will call this method
	
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RestuarantEmployeeRepository restuarantEmployeeRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// loading user from database by username
		Users user = userRepo.findByUsername(username);
		RestaurantEmployee restaurantEmployee = restuarantEmployeeRepository.findByUsername(username);
		if (user == null && null == restaurantEmployee) {
			throw new UsernameNotFoundException(username);
		}
		return user != null? new UserLoginDetails(user) : new UserLoginDetails(restaurantEmployee);
	}
	
}
