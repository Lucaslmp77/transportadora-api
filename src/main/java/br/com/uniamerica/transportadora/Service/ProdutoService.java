package br.com.uniamerica.transportadora.Service;

import br.com.uniamerica.transportadora.Entity.Produto;
import br.com.uniamerica.transportadora.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public Produto save(Produto produto) {
        return this.produtoRepository.save(produto);
    }

    public List<Produto> listAll() {
        return this.produtoRepository.findAll();
    }

    public List<Produto> findByProdutosAtivos() {
        return this.produtoRepository.findByProdutosAtivos();
    }

    public Produto findById(Long id) {
        return this.produtoRepository.findById(id).orElse(new Produto());
    }

    @Transactional
    public void update(Long id, Produto produto) {
        if(id == produto.getId()) {
            this.produtoRepository.save(produto);
        } else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void disable(Long id){
        var produto = this.produtoRepository.findById(id);
        if (id == produto.get().getId()) {
            this.produtoRepository.disable(id);
        }
        else {
            throw new RuntimeException();
        }
    }

}
