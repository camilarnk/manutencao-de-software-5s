public class BrowserPlayer implements IPlayer {

    @Override
    public void reproduzir() {
        System.out.println("Reproduzindo via Browser");
    }

    @Override
    public void pausar() {
        System.out.println("Pausando via Browser");
    }

    @Override
    public void parar() {
        System.out.println("Parando via Browser");
    }
}
