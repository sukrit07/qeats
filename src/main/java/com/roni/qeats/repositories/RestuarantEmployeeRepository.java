package com.roni.qeats.repositories;

import com.roni.qeats.models.RestaurantEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RestuarantEmployeeRepository extends JpaRepository<RestaurantEmployee, Long> {

  RestaurantEmployee findByUsername(String username);

}
