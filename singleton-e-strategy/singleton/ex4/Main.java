public class Main {
    public static void main(String[] args) {
        ConfiguracaoSistema config = ConfiguracaoSistema.getConfiguracaoSistema();
        System.out.println("Url da aplicação:" + ConfiguracaoSistema.getUrlBancoDeDados());
        System.out.println("Nome da aplicação:" + ConfiguracaoSistema.getNomeAplicacao());
        ConfiguracaoSistema.setAmbienteExecução("homologação");
        System.out.println("Ambiente da aplicação:" + ConfiguracaoSistema.getAmbienteExecução());
        ConfiguracaoSistema.setChaveApi("123");
        System.out.println("Chave Api do sistema:" + ConfiguracaoSistema.getChaveApi());
    }
}
