public class ClienteOuro implements Pontuacao {

    @Override
    public int calcularPontos(double valorCompra) {
        return (int)(valorCompra / 2);
    }
}
