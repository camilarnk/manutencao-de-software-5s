package adapter;

import java.util.ArrayList;
import java.util.List;

import domain.ItemGlobal;
import domain.Produto;
import externo.GlobalMarketApi;
import repository.CatalogoProdutos;

public class GlobalMarketAdapter implements CatalogoProdutos {

    private static final double COTACAO_DOLAR = 5.0;

    private GlobalMarketApi api;

    public GlobalMarketAdapter(GlobalMarketApi api) {
        this.api = api;
    }

    @Override
    public List<Produto> listarProdutos() {

        List<Produto> produtos = new ArrayList<>();

        for (ItemGlobal item : api.fetchAvailableItems()) {
            
            double precoEmReais = item.getPriceInDollars() * COTACAO_DOLAR;
            boolean disponivel = item.getAvailableUnits() > 0;

            Produto produto = new Produto(item.getSku(), item.getDescription(), precoEmReais,
                    item.getAvailableUnits(), "Global Market", disponivel);

            produtos.add(produto);
         }

        return produtos;
    }
    
}
