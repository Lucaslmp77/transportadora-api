package br.com.uniamerica.transportadora.Controller;

import br.com.uniamerica.transportadora.Entity.Produto;
import br.com.uniamerica.transportadora.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<?> save(
            @RequestBody Produto produto
    ){
        try{
            this.produtoService.save(produto);
            return ResponseEntity.ok().body("Produto cadastrado!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listAll(

    ){
        return ResponseEntity.ok().body(this.produtoService.listAll());
    }

    @GetMapping("/{idProduto}")
    public ResponseEntity<Produto> findById(
            @PathVariable("idProduto") Long idProduto
    ){
        return ResponseEntity.ok().body(this.produtoService.findById(idProduto));
    }

    @PutMapping("/{idProduto}")
    public ResponseEntity<?> update(
            @PathVariable Long idProduto,
            @RequestBody Produto produto
    ){
        try{
            this.produtoService.update(idProduto, produto);
            return ResponseEntity.ok().body("Produto atualizado com sucesso!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{idProduto}")
    public ResponseEntity<?> delete(
            @PathVariable Long idProduto,
            @RequestBody Produto produto
    ){
        try{
            this.produtoService.delete(idProduto, produto);
            return ResponseEntity.ok().body("Produto deletado com sucesso!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
