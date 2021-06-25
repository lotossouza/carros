package com.example.carros.Api;


import com.example.carros.Domain.Carro;
import com.example.carros.Domain.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/carros")

public class CarrosController {
    @Autowired
    private CarroService service;

    @GetMapping()
    public ResponseEntity<Iterable<Carro>> get() {
        return ResponseEntity.ok(service.getCarros());
        //return new ResponseEntity<>(service.getCarros(), HttpStatus.OK);


    }

    @GetMapping("/{id}")
    public void get(@PathVariable("id") Long id) {
        Optional<Carro> carro = service.getCarrosById(id);
    }

    //return carro.isPresent() ?
    //ResponseEntity.ok(carro.get());
    //ResponseEntity.notFound().build();

//    if(carro.IsPresent()) {
//    return ResponseEntity.ok(carro.get());
//    } else {
//    return ResponseEntity.notFound().build();
//

    @GetMapping("/tipo/{tipo}")
    public Iterable<Carro> getCarrosByTipo(@PathVariable("tipo") String tipo) {
    return service.getCarrosByTipo(tipo);
    }
    @PostMapping
    public String post(@RequestBody Carro carro){
       Carro c= service.save(carro);

       return "Carro salvo com sucesso:" + c.getId();

    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id")Long id){
        service.delete(id);
        return "Carro deletado com sucesso";
    }

}
