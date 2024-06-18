package com.codigotecsup.mscustomer.servicio;

import com.codigotecsup.mscustomer.entidad.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface Customerservicio {
    // declaracion de métodos del servicio
    public Mono<Customer> sscrear (Customer customer1);
    public Mono<Customer> ssactualizar (Customer customer2);
    public Mono<Customer> ssbuscarxid (String id);
    public Flux<Customer> ssbuscartodo ();
    public Mono<Boolean> sseliminar (String id);
}
