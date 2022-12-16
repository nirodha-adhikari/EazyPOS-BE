package com.bootcamp.pos.EzyPOS.repo;

import com.bootcamp.pos.EzyPOS.entity.Customer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;


@EnableJpaRepositories
public interface CustomerRepo extends JpaRepository<Customer, String> {

    @Query(value = "SELECT * FROM customer WHERE name LIKE%?% OR address LIKE%?%",nativeQuery = true)
    public List<Customer> searchCustomer(String searchText, Pageable pageable);

    @Query(value = "SELECT COUNT(id) customer WHERE name LIKE%?% OR address LIKE%?%",nativeQuery = true)
    public int searchCustomer(String searchText);

}
