package com.roni.qeats.repositories;

import com.roni.qeats.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,  Long> {

}
