public class Main {
    public static void main(String[] args) {

        String caminho = "csv/pessoas.csv";

        LeitorCSVPessoas leitorCSVPessoas = new LeitorCSVPessoas();

        System.out.println("Lendo direto do CSV:");

        for(String[] pessoa : leitorCSVPessoas.lerArquivo(caminho)) {
            System.out.println(pessoa[0]);
        }

        System.out.println();
        System.out.println("Convertendo:");

        for(Pessoa p : new PessoaCSVAdapter(new LeitorCSVPessoas(), caminho).listarPessoas()) {
            System.out.println(p.getNome());
        }

    }
}