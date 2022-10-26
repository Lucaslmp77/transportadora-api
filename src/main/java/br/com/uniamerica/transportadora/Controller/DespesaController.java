package br.com.uniamerica.transportadora.Controller;

import br.com.uniamerica.transportadora.Entity.Despesa;
import br.com.uniamerica.transportadora.Service.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/despesa")
public class DespesaController {

    @Autowired
    private DespesaService despesaService;

    @PostMapping
    public ResponseEntity<?> save(
            @RequestBody Despesa despesa
    ){
        try{
            this.despesaService.save(despesa);
            return ResponseEntity.ok().body("Despesa cadastrada!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Despesa>> listAll(

    ){
        return ResponseEntity.ok().body(this.despesaService.listAll());
    }

    @GetMapping("/{idDespesa}")
    public ResponseEntity<?> findById(
            @PathVariable("idDespesa") Long idDespesa
    ){
        return ResponseEntity.ok().body(this.despesaService.findById(idDespesa));
    }

    @PutMapping("/{idDespesa}")
    public ResponseEntity<?> update(
            @PathVariable Long idDespesa,
            @RequestBody Despesa despesa
    ){
        try{
            this.despesaService.update(idDespesa, despesa);
            return ResponseEntity.ok().body("Despesa atualizada com sucesso!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{idDespesa}")
    public ResponseEntity<?> delete(
            @PathVariable Long idDespesa,
            @RequestBody Despesa despesa
    ){
        try{
            this.despesaService.delete(idDespesa, despesa);
            return ResponseEntity.ok().body("Despesa deletada com sucesso!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
