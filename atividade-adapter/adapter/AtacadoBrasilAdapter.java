package adapter;

import java.util.ArrayList;
import java.util.List;

import domain.Produto;
import externo.AtacadoBrasilApi;
import repository.CatalogoProdutos;

public class AtacadoBrasilAdapter implements CatalogoProdutos {

    private AtacadoBrasilApi api;

    public AtacadoBrasilAdapter(AtacadoBrasilApi api) {
        this.api = api;
    }

    @Override
    public List<Produto> listarProdutos() {

        List<Produto> produtos = new ArrayList<>();

         for (String[] item : api.buscarProdutosAtacado()) {
            
            String codigo = item[0];
            String nome = item[1];
            double preco = Double.parseDouble(item[2]);
            int estoque = Integer.parseInt(item[3]);
            boolean disponivel = estoque > 0;

            Produto produto = new Produto(codigo, nome, preco,
                estoque, "Atacado Brasil", disponivel);

            produtos.add(produto);
         }

        return produtos;
    }

}
