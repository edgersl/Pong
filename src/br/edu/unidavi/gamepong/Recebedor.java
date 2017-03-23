package br.edu.unidavi.gamepong;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edgar
 */
public class Recebedor implements Runnable {

    Player play;
    GeradorPonto humor = new GeradorPonto();

    private InputStream servidor;

    public Recebedor(InputStream servidor) {
        this.servidor = servidor;
    }

    public void run() {
     // recebe mensagens do servidor e imprime na tela

        Scanner s = new Scanner(this.servidor);
        while (s.hasNextLine()) {
            String resposta = s.nextLine();
            String respostaSeparada[] = resposta.split(";");
            if (respostaSeparada[0].equals("gamer01")) {
                humor.setBarra02(respostaSeparada[1]);
            } else if (respostaSeparada[0].equals("bola01")) {
                humor.setBola01x(respostaSeparada[1]);
                humor.setBola01y(respostaSeparada[2]);
            } else if (respostaSeparada[0].equals("pontos")) {
                humor.setPontuacaoa(respostaSeparada[1]);
                humor.setPontuacaob(respostaSeparada[2]);
            }

        }
    }
}
