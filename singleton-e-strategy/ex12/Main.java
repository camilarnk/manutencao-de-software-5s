public class Main {
    public static void main(String[] args) {

        GeradorRelatorio gerador = new GeradorRelatorio();

        gerador.setRelatorio(new RelatorioPDF());
        gerador.gerarRelatorio("conteudo relatorio em pdf");
        System.out.println();

        gerador.setRelatorio(new RelatorioHTML());
        gerador.gerarRelatorio("conteudo relatorio em html");

    }
}
