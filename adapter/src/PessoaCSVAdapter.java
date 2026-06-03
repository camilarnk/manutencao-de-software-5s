import java.util.ArrayList;
import java.util.List;

public class PessoaCSVAdapter implements RepositorioPessoas {

    private LeitorCSVPessoas leitorCSVPessoas;
    private String caminhoCSV;

    public PessoaCSVAdapter(LeitorCSVPessoas leitorCSVPessoas, String caminhoCSV) {
        this.leitorCSVPessoas = leitorCSVPessoas;
        this.caminhoCSV = caminhoCSV;
    }

    @Override
    public List<Pessoa> listarPessoas() {
        List<String[]> listaPessoasCSV = leitorCSVPessoas.lerArquivo(caminhoCSV);
        List<Pessoa> listaPessoas = new ArrayList<>();

        for(String[] pessoa : listaPessoasCSV) {
            Pessoa p = new Pessoa();
            p.setNome(pessoa[0]);
            p.setIdade(Integer.parseInt(pessoa[0]));
            p.setEmail(pessoa[2]);

            listaPessoas.add(p);
        }

        return listaPessoas;
    }
}
