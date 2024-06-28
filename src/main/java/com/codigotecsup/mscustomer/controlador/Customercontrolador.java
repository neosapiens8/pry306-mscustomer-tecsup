package com.codigotecsup.mscustomer.controlador;

import com.codigotecsup.mscustomer.entidad.Customer;
import com.codigotecsup.mscustomer.servicio.Customerservicio;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//@RefreshScope
@RestController
@RequestMapping("/rutacustomer")
public class Customercontrolador {
    // como tenemos una unica implementación del servicio
    // inyectamos directamente el servicio, de otro modo inyectaríamos la implementación "Customerservicioimpl"
    @Autowired
    Customerservicio custserv;

    /* //Alternativa
    private final Customerservicio custserv;
    @Autowired
    public Customercontrolador(Customerservicio custserv1) {
        this.custserv = custserv1;
    }
    */

    @GetMapping("/")
    public String home() {
        return "Hello World!"; // Puedes devolver cualquier respuesta que desees aquí
    }

    @GetMapping("")
    public String home2() {
        return "Hello World!"; // Puedes devolver cualquier respuesta que desees aquí
    }

    @PostMapping("/crear")
    public Mono<ResponseEntity<Customer>> cccrear (@RequestBody Customer cust1){
        // devuelve un Mono como ResponseEntity y dile el estado de la petición
        return custserv.sscrear(cust1)
                .map(monocust -> new ResponseEntity<>(monocust, HttpStatus.CREATED));
    }
    @PostMapping("/crear2")
    public Mono<ResponseEntity<Customer>> cccrear2(@RequestBody Customer cust1) {
        return custserv.sscrear(cust1)
                .map(monocust -> ResponseEntity.status(HttpStatus.CREATED).body(monocust));
    }

    @PutMapping("/actualizar")
    public Mono<ResponseEntity<Customer>> ccactualizar (@RequestBody Customer cust2){
        return custserv.ssactualizar(cust2)
                .map(monocust -> new ResponseEntity<>(monocust, HttpStatus.CREATED));
    }
    
    @GetMapping("/busca/{id}")
    public Mono<Customer> ccbuscarxid (@PathVariable Customer cust3){
        return custserv.ssbuscarxid(cust3.getId());
    }

    @GetMapping("/listar")
    public Flux<Customer> ccbuscartodo (){
        return custserv.ssbuscartodo();
    }
    
    @DeleteMapping("eliminar/{id}")
    public Mono<ResponseEntity<String>> cceliminar (@PathVariable String id){
        return custserv.sseliminar(id)
                .map(monocust -> new ResponseEntity<>("customer eliminado",HttpStatus.ACCEPTED))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}