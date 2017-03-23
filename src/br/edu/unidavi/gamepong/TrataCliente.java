package br.edu.unidavi.gamepong;

import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author Edgar
 */
public class TrataCliente implements Runnable {

    private InputStream cliente;
    private Servidor servidor;

    //tratamento de cliente

    public TrataCliente(InputStream cliente, Servidor servidor) {
        this.cliente = cliente;
        this.servidor = servidor;
    }

    public void run() {
        // quando chegar uma mensagem, distribui pra todos
        Scanner s = new Scanner(this.cliente);
        while (s.hasNextLine()) {
            servidor.distribuiMensagem(s.nextLine());
        }
        s.close();
    }
}
