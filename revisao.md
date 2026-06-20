# Lista de Revisão — Manutenção de Software

Esta lista reúne **30 atividades de revisão** baseadas nos conteúdos trabalhados nas atividades anteriores da disciplina: código limpo, legibilidade, comentários, formatação, funções, refatoração, Strategy, Singleton e Adapter.

---

## Parte 1 — Código Limpo, Legibilidade e Comentários

### 1. Conceito de código limpo

O Clean Code envolve técnicas de boas praticas de organização na programação,
para facilitar o entendimento a longo prazo por qualquer programador que ler o código, 
com nomes de funções e variáveis descritivos, que contribuem para o entendimento da lógica,
diminuindo a chance de erros futuros, facilitando a adição de funcionalidades e a colaboração
entre diferentes desenvolvedores.  

---

### 2. Avaliação de nomes de variáveis.

Analise os nomes abaixo:

```java
int x;
int dias;
int diasDesdeUltimoLogin;
double v;
double valorTotalPedido;
```

Responda:

a) Quais nomes são mais legíveis?  
diasDesdeUltimoLogin, valorTotalPedido. 
  
b) Quais nomes são vagos?  
x, dias e v.  
  
c) O que um bom nome deve comunicar ao leitor do código?  
deve comunicar o que a variável/método realiza.  

---

## Parte 2 — Formatação de Código

### 7. Formatação vertical

```java
public class PedidoService {

    public void fecharPedido(String cliente, double subtotal, double frete) {
        double total = calcularTotal(subtotal, frete);
        imprimirResumo(cliente, total);
    }

    private double calcularTotal(double subtotal, double frete) {
        return subtotal + frete;
    }

    private void imprimirResumo(String cliente, double total) {
        System.out.println(cliente + ": " + total);
    }
}
```

Com essa reformulação, os métodos chamadores passam a ser acima dos métodos chamados, melhorando a legibilidade e seguinte os princípios de clean code.

---

### 8. Separação de conceitos

```java
public void cadastrarProduto(String nome, double preco) {

    String nomeFormatado = nome.trim().toUpperCase();
    boolean precoValido = preco > 0;

    if (!precoValido) {
        System.out.println("Preço inválido");
        return;
    }

    System.out.println("Produto: " + nomeFormatado);
    System.out.println("Preço: " + preco);
    System.out.println("Cadastro finalizado");
}
```

---

### 9. Formatação horizontal

```java
public void gerarRelatorio(String cliente, String email, double total, boolean premium, boolean pagamentoEmDia) {

    boolean clienteEspecial = premium && pagamentoEmDia && total > 1000;

    if (clienteEspecial) {
        System.out.println("Relatório especial para " + cliente + " enviado para " + email + " com total de " + total);
    }
}
```

---

### 10. Indentação

```java
public void verificarAcesso(boolean ativo, boolean admin) {
  if (ativo) {
    if (admin) {
      System.out.println("Acesso administrativo");
    } else {
      System.out.println("Acesso comum");
    }
  } else {
    System.out.println("Usuário inativo");
  }
}
```

---

### 11. Afinidade conceitual

```java
public class UsuarioUtils {
    public void enviarEmail(String email) {
        System.out.println("Enviando e-mail para " + email);
    }

    public void enviarNotificacao(String mensagem) {
        System.out.println(mensagem);
    }

    public String formatarCPF(String cpf) {
        return cpf.replace(".", "").replace("-", "");
    }

    public String formatarNome(String nome) {
        return nome.trim().toUpperCase();
    }
}
```

O método utilizado foi o de coesão (afinidade conceitual), onde responsabilidades semelhantes devem estar próximas umas das outras.

---

## Parte 3 — Código Limpo: Funções

### 12. Função com muitas responsabilidades

Analise a função abaixo:

```java
public void finalizarPedido(Cliente cliente, Carrinho carrinho) {
    double total = 0;

    for (Item item : carrinho.getItens()) {
        total += item.getPreco() * item.getQuantidade();
    }

    Pedido pedido = new Pedido(cliente, carrinho.getItens(), total);
    pedidoRepository.salvar(pedido);

    emailService.enviar(cliente.getEmail(), "Pedido confirmado");
}
```
Faça o que se pede:

a) Identifique as responsabilidades da função.  
a função finaliza os pedidos, somando o valor do carrinho, criando o novo pedido, e enviando pelo email. 
  
b) Explique por que isso prejudica a manutenção.  
pois ela tem muitas responsabilidades, além de não descrever tudo o que realmente é realizado.  
  
c) Reescreva dividindo a lógica em funções menores.
```java
public void finalizarPedido(Cliente cliente, Carrinho carrinho) {
    double total = somarValorCarrinho(carrinho);

    Pedido pedido = new Pedido(cliente, carrinho.getItens(), total);
    pedidoRepository.salvar(pedido);

    enviarConfirmacaoEmail(cliente);
}

public double somarValorCarrinho(Carrinho carrinho) {
    double total = 0;

    for (Item item : carrinho.getItens()) {
        total += item.getPreco() * item.getQuantidade();
    }

    return total;
}

public void enviarConfirmacaoEmail(Cliente cliente) {
  emailService.enviar(cliente.getEmail(), "Pedido confirmado");
}
```

---

### 13. Nome pouco descritivo

Analise o método:

```java
public boolean verificar(Usuario usuario) {
    return usuario.getIdade() >= 18 && usuario.isAtivo();
}
```
Faça o que se pede:

a) Explique o problema do nome verificar.  
o nome não explica o que é verificado.  
  
b) Proponha um nome mais descritivo.  
isMaiorIdadeEAtivo.  
  
c) Reescreva o método com o novo nome.  
```java
public boolean isMaiorIdadeEAtivo(Usuario usuario) {
    return usuario.getIdade() >= 18 && usuario.isAtivo();
}
```

---

### 14. Função com muitos argumentos

Analise a função:
```java
public void cadastrarAluno(
    String nome,
    String cpf,
    String email,
    String telefone,
    String curso,
    int periodo
) {
    Aluno aluno = new Aluno();
    aluno.setNome(nome);
    aluno.setCpf(cpf);
    aluno.setEmail(email);
    aluno.setTelefone(telefone);
    aluno.setCurso(curso);
    aluno.setPeriodo(periodo);

    alunoRepository.salvar(aluno);
}
```
Faça o que se pede:

a) Explique por que muitos argumentos dificultam o uso da função.  
pois pode ser difícil interpretar de onde cada argumento vem no código, suas responsabilidades, além de dificultar a manutenção e os testes.  
  
b) Crie uma classe ou objeto para agrupar os dados de cadastro.  
c) Reescreva a função recebendo esse objeto como parâmetro.  
```java
public void cadastrarAluno(Aluno aluno) {
    alunoRepository.salvar(aluno);
}
```

---

### 15. Efeito colateral escondido

Analise a função:

```java
public boolean usuarioExiste(String email) {
    Usuario usuario = usuarioRepository.buscarPorEmail(email);

    if (usuario == null) {
        usuarioRepository.salvar(new Usuario(email));
        return false;
    }

    return true;
}
```
Responda:

a) O que o nome da função sugere que ela faz?  
verifica se o usuario existe ou nao no sistema. 
  
b) O que ela faz além disso?  
salva o usuario no sistema.  
  
c) Por que isso é um efeito colateral?  
pois o nome do metodo não explica exatamente o que é feito, dificultando a leitura e manutenção. 
  
d) Reescreva separando verificação e criação do usuário.  
```java
public boolean usuarioExiste(String email) {
    Usuario usuario = usuarioRepository.buscarPorEmail(email);

    if (usuario == null) {
        return false;
    }

    return true;
}

public void salvarUsuario(String email) {
  if (usuario == null) {
       usuarioRepository.salvar(new Usuario(email));
  }
}
```

---

## Parte 4 — Refatoração Básica

### 18. Extract Method

Refatore o método abaixo usando Extract Method.

```java
public void emitirRecibo(String cliente, int quantidade, double precoUnitario) {
    double subtotal = quantidade * precoUnitario;
    double imposto = subtotal * 0.10;
    double total = subtotal + imposto;

    System.out.println("Cliente: " + cliente);
    System.out.println("Quantidade: " + quantidade);
    System.out.println("Subtotal: " + subtotal);
    System.out.println("Imposto: " + imposto);
    System.out.println("Total: " + total);

    if (total > 500) {
        System.out.println("Compra de alto valor");
    }
}
```
Extraia métodos para:

calcular subtotal;
calcular imposto;
imprimir recibo;
verificar compra de alto valor.

```java
public void emitirRecibo(String cliente, int quantidade, double precoUnitario) {
    double subtotal = calcularSubtotal(quantidade, precoUnitario);
    double imposto = calcularImposto(subtotal);
    double total = subtotal + imposto;

    imprimirRecibo(cliente, quantidade, subtotal, imposto, total);

    verificarCompraAltoValor(total);
}

public double calcularSubtotal(int quantidade, double precoUnitario) {
    return quantidade * precoUnitario;
}

public double calcularImposto(int subtotal) {
    return subtotal * 0.10;
}

public void imprimirRecibo(String cliente, int quantidade,
        double subtotal, double imposto, double total) {

    System.out.println("Cliente: " + cliente);
    System.out.println("Quantidade: " + quantidade);
    System.out.println("Subtotal: " + subtotal);
    System.out.println("Imposto: " + imposto);
    System.out.println("Total: " + total);
}

public void verificarCompraAltoValor(double total) {
    if (total > 500) {
        System.out.println("Compra de alto valor");
    }
}
```

---

### 19. Extract Variable

Refatore o código abaixo usando Extract Variable.

```java
public void verificarAprovacao(double notaFinal, int frequencia, boolean fezRecuperacao) {
    if ((notaFinal >= 6.0 && frequencia >= 75) || (fezRecuperacao && notaFinal >= 5.0 && frequencia >= 80)) {
        System.out.println("Aluno aprovado");
    } else {
        System.out.println("Aluno reprovado");
    }
}
```
Crie variáveis com nomes que expliquem cada condição importante.

```java
public void verificarAprovacao(double notaFinal, int frequencia, boolean fezRecuperacao) {

    boolean isAprovadoNotaEFrequencia = notaFinal >= 6.0 && frequencia >= 75;
    boolean isAprovadoRecuperacao = fezRecuperacao && notaFinal >= 5.0 && frequencia >= 80;

    if (isAprovadoNotaEFrequencia || isAprovadoRecuperacao) {
        System.out.println("Aluno aprovado");
    } else {
        System.out.println("Aluno reprovado");
    }
}
```

---

## Parte 5 — Refatoração Orientada a Objetos

### 22. Move Method

Analise o cenário:

A classe PedidoService possui o método abaixo:

```java
public double calcularTotalPedido(Pedido pedido) {
    return pedido.getSubtotal() + pedido.getFrete() - pedido.getDesconto();
}
```
O método usa apenas dados da classe Pedido.

Faça o que se pede:

a) Explique por que esse método pode estar na classe errada.  
o metodo pode estar na classe errada porque ele utiliza apenas dados da própria classe Pedido. Pelo princípio de coesão, comportamentos que dependem exclusivamente dos atributos de uma classe devem ficar nela mesma. Assim, o cálculo do total é responsabilidade de pedido, e não de pedidoService
   
b) Mova o método para a classe Pedido.  
```java
public class Pedido {
    private double subtotal;
    private double frete;
    private double desconto;

    public double calcularTotalPedido() {
        return subtotal + frete - desconto;
    }
}
```
   
c) Ajuste a chamada em PedidoService.  
```java
public class PedidoService {
    public double calcularTotalPedido() {
         pedido.calcularTotalPedido(pedido);
    }
}

```

---

### 23. Move Field

Analise o cenário:

A classe Produto possui os campos:

```java
private LocalDate dataCompra;
private LocalDate dataValidadeGarantia;
```
Esses dados não descrevem o produto em geral, mas sim uma compra específica.

Faça o que se pede:

a) Explique por que esses campos podem estar na classe errada.  
Os campos não representam características do produto, mas sim informações relacionadas a uma compra específica desse produto. Como um mesmo produto pode ser comprado várias vezes em datas diferentes e possuir garantias distintas, esses atributos pertencem melhor a uma classe que represente a compra.
   
b) Crie uma classe ItemPedido ou CompraProduto.    
c) Mova os campos para a nova classe.  
```java
public class CompraProduto {
    private Produto produto;
    private LocalDate dataCompra;
    private LocalDate dataValidadeGarantia;
}
```

---

### 24. Extract Class

Analise a classe abaixo:

```java
public class Cliente {
    private String nome;
    private String cpf;
    private String email;
    private String banco;
    private String agencia;
    private String conta;
    private String metodoPagamentoPreferencial;
}
```
Faça o que se pede:

a) Identifique o grupo de atributos que forma outro conceito.  
banco, agencia, conta e metodoPagamentoPreferencial, pois descrevem o conceito de dados de cobrança, e nao representam a entidade
cliente em si.
  
b) Crie uma classe DadosCobranca.  
```java
public class DadosCobranca {
    private String banco;
    private String agencia;
    private String conta;
    private String metodoPagamentoPreferencial;
}
```
  
c) Atualize Cliente para usar essa nova classe.  
```java
public class Cliente {
    private String nome;
    private String cpf;
    private String email;
    private DadosCobranca dadosCobranca;
}
```

---

### 25. Introduce Local Extension

Um sistema financeiro usa diretamente BigDecimal para representar dinheiro.

Crie uma classe ValorMonetario que encapsule um BigDecimal e ofereça os métodos:
```java
formatarEmReais()
ehAltoValor()
getValor()
```
Depois, explique por que essa classe melhora a expressividade do domínio.

```java
public class ValorMonetario {
    private BigDecimal valor;

    public ValorMonetario(BigDecimal valor) {
        this.valor = valor;
    }

    public String formatarEmReais() {
        return "R$ "
                + valor.setScale(2, RoundingMode.HALF_UP)
                .toString()
                .replace(".", ",");
    }

    public boolean ehAltoValor() {
        return valor.compareTo(new BigDecimal("50000.00")) >= 0;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
```
a classe melhora a expressividade do domínio porque representa explicitamente o conceito de dinheiro dentro do sistema, em vez de utilizar diretamente um BigDecimal, que é uma classe genérica da biblioteca Java. Além disso, ela centraliza comportamentos relacionados a valores monetários, como formatação e validações de negócio (ehAltoValor()), aumentando a coesão e tornando o código mais legível e fácil de manter.

