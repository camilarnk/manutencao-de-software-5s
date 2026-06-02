public class RelatorioPDF implements Relatorio {
    @Override
    public void gerarRelatorio(String conteudo) {
        System.out.printf("Gerando relatório em PDF: %s\n", conteudo);
    }

    @Override
    public String getFormato() {
        return "PDF";
    }
}
