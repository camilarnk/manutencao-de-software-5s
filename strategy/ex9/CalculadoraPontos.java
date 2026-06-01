public class CalculadoraPontos {
    private Pontuacao pontuacao;

    public void setPontuacao(Pontuacao pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int calcularPontos(double valorCompra) {
        if (pontuacao == null) {
            throw new IllegalArgumentException("Tipo de pontuação não definido");
        }
        return pontuacao.calcularPontos(valorCompra);
    }
}
