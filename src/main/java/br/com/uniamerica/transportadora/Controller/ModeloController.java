package br.com.uniamerica.transportadora.Controller;

import br.com.uniamerica.transportadora.Entity.Modelo;
import br.com.uniamerica.transportadora.Service.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/modelo")
public class ModeloController {

    @Autowired
    private ModeloService modeloService;

    @PostMapping
    public ResponseEntity<?> save(
            @RequestBody Modelo modelo
    ){
        try{
            this.modeloService.save(modelo);
            return ResponseEntity.ok().body("Modelo cadastrado!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Modelo>> listAll(

    ){
        return ResponseEntity.ok().body(this.modeloService.listAll());
    }

    @GetMapping("/{idModelo}")
    public ResponseEntity<?> findById(
            @PathVariable("idModelo") Long idModelo
    ){
        return ResponseEntity.ok().body(this.modeloService.findById(idModelo));
    }

    @PutMapping("/{idModelo}")
    public ResponseEntity<?> update(
            @PathVariable Long idModelo,
            @RequestBody Modelo modelo
    ){
        try{
            this.modeloService.update(idModelo, modelo);
            return ResponseEntity.ok().body("Modelo atualizado com sucesso!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{idModelo}")
    public ResponseEntity<?> delete(
            @PathVariable Long idModelo,
            @RequestBody Modelo modelo
    ){
        try{
            this.modeloService.delete(idModelo, modelo);
            return ResponseEntity.ok().body("Modelo deletado com sucesso!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
