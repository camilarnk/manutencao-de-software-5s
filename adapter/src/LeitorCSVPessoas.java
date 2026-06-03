import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeitorCSVPessoas implements LeitorCSV {

    @Override
    public List<String[]> lerArquivo(String caminhoArquivo) {
        List<String[]> linhas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;

            br.readLine();

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");

                if (dados.length == 3) {
                    linhas.add(dados);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return linhas;
    }
}
