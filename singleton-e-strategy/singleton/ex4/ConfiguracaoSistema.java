public final class ConfiguracaoSistema {
    private static ConfiguracaoSistema configuracaoSistema;
    private static String urlBancoDeDados = "http://localhost:8080/configuracaoSistema";
    private static String nomeAplicacao = "admin";
    private static String ambienteExecução;
    private static String chaveApi;

    private ConfiguracaoSistema() {
    }

    public static ConfiguracaoSistema getConfiguracaoSistema() {
        if (configuracaoSistema == null) {
            configuracaoSistema = new ConfiguracaoSistema();
        }

        return configuracaoSistema;
    }

    public static String getUrlBancoDeDados() {
        return urlBancoDeDados;
    }

    public static String getNomeAplicacao() {
        return nomeAplicacao;
    }

    public static String getAmbienteExecução() {
        return ambienteExecução;
    }

    public static String getChaveApi() {
        return chaveApi;
    }

    public static void setUrlBancoDeDados(String urlBancoDeDados) {
        ConfiguracaoSistema.urlBancoDeDados = urlBancoDeDados;
    }

    public static void setNomeAplicacao(String nomeAplicacao) {
        ConfiguracaoSistema.nomeAplicacao = nomeAplicacao;
    }

    public static void setAmbienteExecução(String ambienteExecução) {
        ConfiguracaoSistema.ambienteExecução = ambienteExecução;
    }

    public static void setChaveApi(String chaveApi) {
        ConfiguracaoSistema.chaveApi = chaveApi;
    }
}
