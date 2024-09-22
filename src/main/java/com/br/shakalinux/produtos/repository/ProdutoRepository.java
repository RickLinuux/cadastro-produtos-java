package com.br.shakalinux.produtos.repository;

import com.br.shakalinux.produtos.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {

}
