public class SessaoStreaming {
    public SessaoStreaming(IPlayer player) {
        player.reproduzir();
        player.pausar();
        player.parar();

        if (player instanceof IBaixavel) { // testar se o 'player' implementa a interface 'baixavel'
            ((IBaixavel) player).baixar();
            // os parenteses com um tipo de dado estao tratando 'player' como uma instancia de 'baixavel'
        }
    }
}
