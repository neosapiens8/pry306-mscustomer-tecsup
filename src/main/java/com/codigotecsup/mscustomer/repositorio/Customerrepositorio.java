package com.codigotecsup.mscustomer.repositorio;

import com.codigotecsup.mscustomer.entidad.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface Customerrepositorio extends ReactiveMongoRepository<Customer,String> {
    
}