package br.com.uniamerica.transportadora.Controller;

import br.com.uniamerica.transportadora.Entity.Usuario;
import br.com.uniamerica.transportadora.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<?> save(
            @RequestBody Usuario usuario
    ){
        try{
            this.usuarioService.save(usuario);
            return ResponseEntity.ok().body("Usuário cadastrado!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listAll(

    ){
        return ResponseEntity.ok().body(this.usuarioService.listAll());
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<?> findById(
            @PathVariable("idUsuario") Long idUsuario
    ){
        return ResponseEntity.ok().body(this.usuarioService.findById(idUsuario));
    }

    @PutMapping("/{idUsuario}")
    public ResponseEntity<?> update(
            @PathVariable Long idUsuario,
            @RequestBody Usuario usuario
    ){
        try{
            this.usuarioService.update(idUsuario, usuario);
            return ResponseEntity.ok().body("Usuário atualizado com sucesso!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<?> delete(
            @PathVariable Long idUsuario,
            @RequestBody Usuario usuario
    ){
        try{
            this.usuarioService.delete(idUsuario, usuario);
            return ResponseEntity.ok().body("Usuário deletado com sucesso!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
