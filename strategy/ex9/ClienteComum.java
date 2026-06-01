public class ClienteComum implements Pontuacao {

    @Override
    public int calcularPontos(double valorCompra) {
        return (int)(valorCompra / 10);
    }
}
