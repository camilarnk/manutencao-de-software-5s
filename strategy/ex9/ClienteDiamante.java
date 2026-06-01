public class ClienteDiamante implements Pontuacao {

    @Override
    public int calcularPontos(double valorCompra) {
        if (valorCompra > 500) {
            return (int)(valorCompra / 2) * 2;
        }
        return (int)(valorCompra / 2);
    }
}
