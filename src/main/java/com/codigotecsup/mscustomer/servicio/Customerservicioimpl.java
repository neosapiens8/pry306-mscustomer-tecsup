package com.codigotecsup.mscustomer.servicio;

import com.codigotecsup.mscustomer.entidad.Customer;
import com.codigotecsup.mscustomer.repositorio.Customerrepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service // solución al ERROR de test al utilizar @Autowired en Customercontrolador
public class Customerservicioimpl implements Customerservicio{
    // inyectamos el repositorio para poder usar sus características
    // para redefinir los métodos de la interface "Customerservicio"
    @Autowired
    Customerrepositorio custrep;

    /* //Alternativa
    private final Customerrepositorio custrep;
    @Autowired
    public Customerservicioimpl(Customerrepositorio custrep1) {
        this.custrep = custrep1;
    }
    */

    // lógica del CRUD repositorio desde el servicio
    @Override
    public Mono<Customer> sscrear(Customer cust1) {
        return custrep.save(cust1);
    }

    @Override
    public Mono<Customer> ssactualizar(Customer cust2) {
        return custrep.findById(cust2.getId())
                .flatMap(monocust -> {
                    return custrep.save(cust2);
                    // reemplaza los datos del monocust encontrado con los datos del customer2
                });
    }

    @Override
    public Mono<Customer> ssbuscarxid(String id) {
        return custrep.findById(id);
    }

    @Override
    public Flux<Customer> ssbuscartodo() {
        return custrep.findAll();
    }

    @Override
    public Mono<Boolean> sseliminar(String id) {
        return custrep.findById(id)
                .flatMap(monocust -> custrep.delete(monocust)
                        .then(Mono.just(Boolean.TRUE)))
                .defaultIfEmpty(Boolean.FALSE);
    }
}