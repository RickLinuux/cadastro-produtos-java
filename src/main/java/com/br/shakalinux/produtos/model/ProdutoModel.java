package com.br.shakalinux.produtos.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "produtos")
public class ProdutoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Nome do Produto deve ser preenchido")
    @Size(min = 3, max = 40, message = "Nome do Produto deve ter entre 3 a 40 caracteres")
    private String nome;

    @NotBlank(message = "Nome do Produto deve ser preenchido")
    @Column(length = 255)
    private String descricao;

    @Column(nullable = false)
    @NotNull(message = "O valor do produto é obrigatório")
    @Positive(message = "Valor do Produto deve ser um número positivo")
    private double valor;


    @Column(name = "imagem", columnDefinition = "longblob")
    private byte[] imagem;

    private String imagemBase64;
}
