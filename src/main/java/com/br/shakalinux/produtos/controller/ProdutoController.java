package com.br.shakalinux.produtos.controller;

import com.br.shakalinux.produtos.model.ProdutoModel;
import com.br.shakalinux.produtos.repository.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;


@Controller
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/cadastrar")
    public String cadastro(Model model) {
        model.addAttribute("produtos", new ProdutoModel());
        return "cadastro";
    }

    @PostMapping("/cadastrar")
    public String cadastrar(@ModelAttribute("produto") @Valid ProdutoModel produtoModel,
                            BindingResult bindingResult,
                            @RequestParam("file") MultipartFile imagem,
                            Model model) {
        if (bindingResult.hasErrors()) {
            return "cadastro";
        }
        try {
            produtoModel.setImagem(imagem.getBytes());
            produtoRepository.save(produtoModel);
        } catch (IOException e) {
            e.printStackTrace();
            return "cadastro";
        }
        return "redirect:/listarProdutos";
    }


    @GetMapping("/listarProdutos")
    public String listarProdutos(Model model) {
        List<ProdutoModel> produtos = produtoRepository.findAll();
        for (ProdutoModel produto : produtos) {
            if (produto.getImagem() != null) {
                String imagemBase64 = Base64.getEncoder().encodeToString(produto.getImagem());
                produto.setImagemBase64(imagemBase64);
            }
        }
        model.addAttribute("produtos", produtos);
        return "listarProdutos";
    }


    @GetMapping("/editarProduto/{id}")
    public String editarProduto(@PathVariable Long id, Model model) {
        Optional<ProdutoModel> produtoOptional = produtoRepository.findById(id);
        if (produtoOptional.isPresent()) {
            model.addAttribute("produtos", produtoOptional.get());
        } else {
            return "redirect:/listarProdutos";
        }
        return "editarProduto";
    }


    @PostMapping("/editarProduto/{id}")
    public String atualizarProduto(@PathVariable Long id,
                                   @ModelAttribute("produtos") @Valid ProdutoModel produtoModel,
                                   BindingResult bindingResult,
                                   @RequestParam("file") MultipartFile imagem,
                                   Model model) {
        if (bindingResult.hasErrors()) {
            return "editarProduto";
        }
        try {
            ProdutoModel produtoExistente = produtoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));

            if (!imagem.isEmpty()) {
                produtoExistente.setImagem(imagem.getBytes());
            }
            
            produtoExistente.setNome(produtoModel.getNome());
            produtoExistente.setDescricao(produtoModel.getDescricao());
            produtoExistente.setValor(produtoModel.getValor());

            produtoRepository.save(produtoExistente);
        } catch (IOException e) {
            e.printStackTrace();
            return "editarProduto";
        }
        return "redirect:/listarProdutos";
    }



    @GetMapping("excluirProduto/{id}")
    public String excluirProduto(@PathVariable Long id) {
        produtoRepository.deleteById(id);
        return "redirect:/listarProdutos";
    }

    @GetMapping("/produto/{id}")
    public String exibirDetalhesProduto(@PathVariable Long id, Model model) {
        Optional<ProdutoModel> produtoOptional = produtoRepository.findById(id);
        if (produtoOptional.isPresent()) {
            ProdutoModel produto = produtoOptional.get();
            if (produto.getImagem() != null) {
                String imagemBase64 = Base64.getEncoder().encodeToString(produto.getImagem());
                produto.setImagemBase64(imagemBase64);
            }
            model.addAttribute("produto", produto);
            return "detalhesProdutos";
        } else {
            return "redirect:/listarProdutos";
        }
    }





}







    



