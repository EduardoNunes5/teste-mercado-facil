package com.ufcg.psoft.mercadofacil.service;


import com.ufcg.psoft.mercadofacil.model.Produto;
import com.ufcg.psoft.mercadofacil.repository.ProdutoRepository;
import com.ufcg.psoft.mercadofacil.tests.FabricaProduto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
public class ProdutoServiceTests {

    @InjectMocks
    private ProdutoServiceImpl produtoService;

    @Mock
    private ProdutoRepository repository;

    private long idExistente;
    private long idInexistente;

    @BeforeEach
    void setUp() throws Exception {
        idExistente = 1L;
        idInexistente = 6L;

        //simulando comportamento do findby id do repository
        Mockito.when(repository.findById(idExistente))
                .thenReturn(Optional.of(FabricaProduto.createProduct()));

        Mockito.when(repository.findById(idInexistente)).thenReturn(Optional.empty());

        // outros exemplos
        //Mockito.when(mock.metodo()).thenThrow(ClasseException.class);

        // quando o método retorna void
        //Mockito.doNothing().when(mock).metodoMock(parametros);
        //Mockito.doThrow().when(mock).metodoMock(parametros);

    }

    @Test
    void getByIdDeveRetornarProdutoQuandoIdExiste(){
        Optional<Produto> prod = produtoService.getProdutoById(idExistente);

        //verificando se o produto está presente
        Assertions.assertTrue(prod.isPresent());
        //verifica se o repository.findById foi chamado umavez
        Mockito.verify(repository, Mockito.times(1)).findById(idExistente);
    }


    @Test
    void getByIdDeveRetornarVazioQuandoIdNaoExiste(){
        Optional<Produto> prod = produtoService.getProdutoById(idInexistente);

        //verificando se o produto está presente
        Assertions.assertFalse(prod.isPresent());
        //verifica se o repository.findById foi chamado umavez
        Mockito.verify(repository, Mockito.times(1)).findById(idInexistente);
    }
}
