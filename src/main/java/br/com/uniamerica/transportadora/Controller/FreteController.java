package br.com.uniamerica.transportadora.Controller;

import br.com.uniamerica.transportadora.Entity.Frete;
import br.com.uniamerica.transportadora.Service.FreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/frete")
public class FreteController {

    @Autowired
    private FreteService freteService;

    @PostMapping
    public ResponseEntity<?> save(
            @RequestBody Frete frete
    ){
        try{
            this.freteService.save(frete);
            return ResponseEntity.ok().body("Frete cadastrado!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Frete>> listAll(

    ){
        return ResponseEntity.ok().body(this.freteService.listAll());
    }

    @GetMapping("/{idFrete}")
    public ResponseEntity<Frete> findById(
            @PathVariable("idFrete") Long idFrete
    ){
        return ResponseEntity.ok().body(this.freteService.findById(idFrete).get());
    }

    @PutMapping("/{idFrete}")
    public ResponseEntity<?> update(
            @PathVariable Long idFrete,
            @RequestBody Frete frete
    ){
        try{
            this.freteService.update(idFrete, frete);
            return ResponseEntity.ok().body("Frete atualizado com sucesso!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{idFrete}")
    public ResponseEntity<?> delete(
            @PathVariable Long idFrete
    ){
        try{
            this.freteService.delete(idFrete);
            return ResponseEntity.ok().body("Frete deletado com sucesso!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
