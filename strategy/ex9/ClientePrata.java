public class ClientePrata implements Pontuacao{

    @Override
    public int calcularPontos(double valorCompra) {
        return (int)(valorCompra / 5);
    }
}
