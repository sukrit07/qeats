package com.roni.qeats.models;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserLoginDetails implements UserDetails {

  private Object user;

  public UserLoginDetails(Object users){
    this.user = users;
  }


  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() throws ClassCastException {
    Users userLogin = null;
    RestaurantEmployee restaurantEmployee = null;
    List<SimpleGrantedAuthority> authorities = null;
    try {
      if (user == Users.class) {
        userLogin = (Users) this.user;
        authorities = userLogin.getRoles().stream()
            .map((role) -> new SimpleGrantedAuthority(role.getName())).collect(
                Collectors.toList());
      }
      if (user == RestaurantEmployee.class) {
        restaurantEmployee = (RestaurantEmployee) user;
        authorities =
            restaurantEmployee.getRoles().stream()
                .map((role) -> new SimpleGrantedAuthority(role.getName())).collect(
                    Collectors.toList());
      }
    }catch(ClassCastException e){
      throw e;
    }

    return authorities;
  }

  @Override
  public String getPassword() {
    return null;
  }

  @Override
  public String getUsername() {
    return null;
  }

  @Override
  public boolean isAccountNonExpired() {
    return false;
  }

  @Override
  public boolean isAccountNonLocked() {
    return false;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return false;
  }

  @Override
  public boolean isEnabled() {
    return false;
  }
}
