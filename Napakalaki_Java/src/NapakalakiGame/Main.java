/**
 *  Marco Manuel Fernández Pranno, 2015 (Granada)
 *  Para la asignatura PDOO (Universidad de Granada)
 *  Licencia GPLv3 a partir del 15/02/16, hasta entonces todos los derechos reservados.
 */

package NapakalakiGame;

import GUI.Dice;
import GUI.NapakalakiView;
import GUI.PlayerNamesCapture;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
      Napakalaki game = Napakalaki.getInstance();
      NapakalakiView napakalakiView = new NapakalakiView();
      Dice.createInstance(napakalakiView);
      PlayerNamesCapture namesCapture = new PlayerNamesCapture(napakalakiView,true);
      ArrayList<String> names = namesCapture.getNames();
      game.initGame(names);
      napakalakiView.setNapakalaki(game);
      napakalakiView.setVisible(true);
    }
}
