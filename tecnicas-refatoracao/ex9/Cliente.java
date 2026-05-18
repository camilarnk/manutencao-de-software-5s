package br.edu.refactoring.estacionamento;

public class Cliente {

    private String nome;
    private String cpf;
    private String telefone;
    private int pontosFidelidade;
    private int mesesComoCliente;
    private boolean mensalista;
    private DadosBancarios dadosBancarios;


    public Cliente(String nome, String cpf, String telefone,
                   int pontosFidelidade, int mesesComoCliente, boolean mensalista,
                   DadosBancarios dadosBancarios) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.pontosFidelidade = pontosFidelidade;
        this.mesesComoCliente = mesesComoCliente;
        this.mensalista = mensalista;
        this.dadosBancarios = dadosBancarios;
    }

    public void imprimirResumo() {
        System.out.println("Cliente: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Telefone: " + telefone);
        System.out.println("Pontos de fidelidade: " + pontosFidelidade);
        System.out.println("Mensalista: " + mensalista);
        System.out.println("Cobrança: " + dadosBancarios.getDadosCobrancaFormatados());
    }


    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public int getPontosFidelidade() {
        return pontosFidelidade;
    }

    public int getMesesComoCliente() {
        return mesesComoCliente;
    }

    public boolean isMensalista() {
        return mensalista;
    }

    public int calcularDescontoCliente(Cliente cliente) {
        if (cliente.isMensalista() && cliente.getPontosFidelidade() >= 4000) {
            return 20;
        }

        if (cliente.getMesesComoCliente() >= 12 && cliente.getPontosFidelidade() >= 2000) {
            return 10;
        }

        if (cliente.getPontosFidelidade() >= 1000) {
            return 5;
        }

        return 0;
    }
}
