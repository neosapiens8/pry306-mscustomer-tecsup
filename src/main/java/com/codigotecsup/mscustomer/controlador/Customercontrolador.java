package com.codigotecsup.mscustomer.controlador;

import com.codigotecsup.mscustomer.entidad.Customer;
import com.codigotecsup.mscustomer.servicio.Customerservicio;
import com.codigotecsup.mscustomer.servicio.Customerservicioimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//@RefreshScope
@RestController
@RequestMapping("/customer")
public class Customercontrolador {
    @Autowired
    Customerservicio customerserv1;

    @PostMapping("/crear")
    public Mono<ResponseEntity<Customer>> cccrear (@RequestBody Customer cust){
        // devuelve un Mono como ResponseEntity y dile el estado de la petición
        return customerserv1.sscrear(cust)
                .map(monocust -> new ResponseEntity<>(monocust, HttpStatus.CREATED));
    }
    @PutMapping("/actualizar")
    public Mono<ResponseEntity<Customer>> ccactualizar (@RequestBody Customer cust){
        return customerserv1.ssactualizar(cust)
                .map(monocust -> new ResponseEntity<>(monocust, HttpStatus.CREATED));
    }
    @GetMapping("/busca/{id}")
    public Mono<Customer> ccbuscarxid (@PathVariable Customer cust){
        return customerserv1.ssbuscarxid(cust.getId());
    }
    @GetMapping("/listar")
    public Flux<Customer> ccbuscartodo (){
        return customerserv1.ssbuscartodo();
    }
    @DeleteMapping("eliminar/{id}")
    public Mono<ResponseEntity<String>> cceliminar (@PathVariable String id){
        return customerserv1.sseliminar(id)
                .map(monocust -> new ResponseEntity<>("customer eliminado",HttpStatus.ACCEPTED))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}