public class SmartTVPlayer implements IPlayer {

    @Override
    public void reproduzir() {
        System.out.println("Reproduzindo via Smart TV");
    }

    @Override
    public void pausar() {
        System.out.println("Pausando via Smart TV");
    }

    @Override
    public void parar() {
        System.out.println("Parando via Smart TV");
    }
}
