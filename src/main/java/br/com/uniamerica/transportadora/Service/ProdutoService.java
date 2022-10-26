package br.com.uniamerica.transportadora.Service;

import br.com.uniamerica.transportadora.Entity.Produto;
import br.com.uniamerica.transportadora.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

    public Optional<Produto> findById(Long id) {
        return this.produtoRepository.findById(id);
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
    public void delete(Long id, Produto produto) {
        if(id == produto.getId()) {
            this.produtoRepository.delete(produto);
        } else {
            throw new RuntimeException();
        }
    }

}
