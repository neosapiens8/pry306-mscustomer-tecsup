package com.codigotecsup.mscustomer.servicio;

import com.codigotecsup.mscustomer.entidad.Customer;
import com.codigotecsup.mscustomer.repositorio.Customerrepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service // solucional ERROR de test al utilizar @Autowired en Customercontrolador
public class Customerservicioimpl implements Customerservicio{
    // inyectamos el repositorio para poder usar sus características
    @Autowired
    Customerrepositorio customerrep1;

    // lógica del CRUD repositorio desde el servicio
    @Override
    public Mono<Customer> sscrear(Customer customer1) {
        return customerrep1.save(customer1);
    }

    @Override
    public Mono<Customer> ssactualizar(Customer customer2) {
        return customerrep1.findById(customer2.getId())
                .flatMap(monocust -> {
                    return customerrep1.save(customer2);
                    // reemplaza los datos del monocust encontrado con los datos del customer2
                });
    }

    @Override
    public Mono<Customer> ssbuscarxid(String id) {
        return customerrep1.findById(id);
    }

    @Override
    public Flux<Customer> ssbuscartodo() {
        return customerrep1.findAll();
    }

    @Override
    public Mono<Boolean> sseliminar(String id) {
        return customerrep1.findById(id)
                .flatMap(monocust -> customerrep1.delete(monocust)
                        .then(Mono.just(Boolean.TRUE)))
                .defaultIfEmpty(Boolean.FALSE);
    }
}
