public class Main {
    public static void main(String[] args) {

        IPlayer player = new SmartTVPlayer();
        SessaoStreaming sessaoStreaming = new SessaoStreaming(player);

        // ou:
        // SessaoStreaming sessaoStreaming = new SessaoStreaming(new BrowserPlayer());
    }
}