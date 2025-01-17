package com.example.demosogetisecurity.repository;

import com.example.demosogetisecurity.model.Cards;
import com.example.demosogetisecurity.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardsRepository extends CrudRepository<Cards, Long> {
    List<Cards> findByCustomerId(int customerId);

}
