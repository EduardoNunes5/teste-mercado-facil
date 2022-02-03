# Testes automatizados
## Testes unitários

A classe que contém os testes deve ser anotada com @ExtendWith(SpringExtension.class),
dessa forma é permitida a integração do spring com o Junit. É utilizada para realizar  
testes unitários de @Services ou @Component. 
É comum que precisemos simular comportamentos com os nossos componentes em testes unitários,
visto que não estamos testanto a **integração** entre eles, apenas testando pequenas partes (métodos).  
Para termos controle sobre eles, usamos o termo mock, e temos as anotações: @Mock e @InjectMocks.  
Note que não será utilizada a anotação @Autowired.  
Suponha que eu esteja testando uma classe de service chamada PessoaService, e ela contém um PessoRepository,
eu precisarei simular comportamentos do repository, para que a lógica do service funcione, então a classe de teste ficaria mais ou menos:  

```java
@ExtendWith(SpringExtension.class)
public PessoaServiceTests{
    
    // dessa forma, todas as suas dependências serão injetadas através de mocks
    @InjectMocks
    private PessoaService pessoaService;
    // aqui estou mockando o repository usado no pessoa service, e ele será injetado
    @Mock
    private PessoaRepository pessoaRepository;
}
```

Poderemos então, simular comportamentos utilizando o mockito, com seus métodos when e then.  

Referências:

## Testes de integração  

Para os testes de integração, precisamos do contexto da aplicação, e poderemos utilizar a anotação
@Autowired para pegar os nossos componentes(beans), pois precisaremos do comportamento real deles, 
fazendo com que os testes sejam mais lentos. A classe de teste deve ser anotada com @SpringBootTest 
e também @Transactional, para que seja feito o rollback no banco de dados a cada alteração que tiver lá
e um teste não influencie no outro.
```java
@SpringBootTest
@Transactional
public PessoaServiceTests{

    @Autowired
    private PessoaService pessoaService;

}
```

- [Baeldung](https://www.baeldung.com/mockito-behavior)
- [Concrete page](https://www.concretepage.com/spring-5/extendwith-springextension-spring-test)
- [Video DevDojo](https://www.youtube.com/watch?v=bWbzpsePKdk&list=PL62G310vn6nFBIxp6ZwGnm8xMcGE3VA5H&index=36)
