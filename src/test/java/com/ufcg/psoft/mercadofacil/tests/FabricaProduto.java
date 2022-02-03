package com.ufcg.psoft.mercadofacil.tests;

import com.ufcg.psoft.mercadofacil.DTO.ProdutoDTO;
import com.ufcg.psoft.mercadofacil.model.Produto;

import java.math.BigDecimal;

public class FabricaProduto {

    public static Produto createProduct(){
        Produto p = new Produto("Arroz",
                "codigo",
                "chines",
                new BigDecimal(2.80),
                "alimentos");

        return p;
    }

    public static ProdutoDTO createProductDTO(){
        Produto prod = createProduct();
        ProdutoDTO dto = new ProdutoDTO();
        dto.setCategoria(prod.getCategoria());
        dto.setCodigoBarra(prod.getCodigoBarra());
        dto.setNome(prod.getNome());
        dto.setFabricante(prod.getFabricante());
        dto.setPreco(prod.getPreco());
        return dto;
    }
}
