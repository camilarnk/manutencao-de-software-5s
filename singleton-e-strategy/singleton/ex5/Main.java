public class Main {
    public static void main(String[] args) {
        LoggerSistema.getInstance().log("Pedido criado com sucesso");
        LoggerSistema.getInstance().log("Pagamento aprovado");
        LoggerSistema.getInstance().log("Erro ao calcular frete");
    }
}