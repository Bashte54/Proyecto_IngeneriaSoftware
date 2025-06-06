package mx.unam.aragon.ico.is.cochesapi.controllers;

import jakarta.validation.Valid;
import mx.unam.aragon.ico.is.cochesapi.entitys.Coche;
import mx.unam.aragon.ico.is.cochesapi.repositories.CocheRepository;
import mx.unam.aragon.ico.is.cochesapi.services.interfaz.CocheService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping("/api/proyecto/coche")
public class CocheController {

    @Autowired
    private CocheService cocheService;

    @GetMapping("/")
    public ResponseEntity<Iterable<Coche>> getCoches(){

        return ResponseEntity.ok().body(cocheService.listarTodos());
    }

    @PostMapping("/")
    public ResponseEntity<Coche> createCoche(@Valid @RequestBody Coche coche) throws URISyntaxException {
        return ResponseEntity.created(new URI("http://localhost:8080/")).body(cocheService.crear(coche));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coche> getCoche(@PathVariable Integer id){
        return ResponseEntity.ok(cocheService.buscarporId(id).orElse(null));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coche> updateCoche(@PathVariable Integer id, @RequestBody Coche coche){
        return ResponseEntity.ok(cocheService.actualizar(id, coche));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Coche> patchCoche(@PathVariable Integer id, @RequestBody Coche coche){
        Optional<Coche> tmp = cocheService.buscarporId(id);
        if (tmp.isPresent()) {
            LoggerFactory.getLogger(CocheController.class).info("Coche actualizado" + coche);
            Coche actual =  tmp.get();
            if (coche.getMarca() != null) actual.setMarca(coche.getMarca());
            if (coche.getModelo() != null) actual.setModelo(coche.getModelo());
            if (coche.getColor() != null) actual.setColor(coche.getColor());
            if (coche.getPrecio() != null) actual.setPrecio(coche.getPrecio());
            if (coche.getFoto() != null) actual.setFoto(coche.getFoto());
            return ResponseEntity.ok(cocheService.actualizar(id, actual));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteCoche(@PathVariable Integer id){
        cocheService.eliminar(id);
    }

}

