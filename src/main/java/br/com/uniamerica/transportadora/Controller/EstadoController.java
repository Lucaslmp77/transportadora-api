package br.com.uniamerica.transportadora.Controller;

import br.com.uniamerica.transportadora.Entity.Estado;
import br.com.uniamerica.transportadora.Service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/estado")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @PostMapping
    public ResponseEntity<?> save(
            @RequestBody Estado estado
    ){
        try{
            this.estadoService.save(estado);
            return ResponseEntity.ok().body("Estado cadastrado!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Estado>> listAll(

    ){
        return ResponseEntity.ok().body(this.estadoService.listAll());
    }

    @GetMapping("/ativos")
    public ResponseEntity<List<Estado>> findByEstadosAtivos(

    ){
        return ResponseEntity.ok().body(this.estadoService.findByEstadosAtivos());
    }

    @GetMapping("/{idEstado}")
    public ResponseEntity<Estado> findById(
            @PathVariable("idEstado") Long idEstado
    ){
        return ResponseEntity.ok().body(this.estadoService.findById(idEstado));
    }

    @PutMapping("/{idEstado}")
    public ResponseEntity<?> update(
            @PathVariable Long idEstado,
            @RequestBody Estado estado
    ){
        try{
            this.estadoService.update(idEstado, estado);
            return ResponseEntity.ok().body("Estado atualizado com sucesso!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/disable/{idEstado}")
    public ResponseEntity<?> disable(
            @PathVariable Long idEstado
    ){
        try{
            this.estadoService.disable(idEstado);
            return ResponseEntity.ok().body("Estado desativado com sucesso!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
