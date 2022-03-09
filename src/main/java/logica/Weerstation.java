package logica;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Weerstation : Weerstation
 *
 * @author Tim Billiet
 * @version 9/03/2022
 */
public class Weerstation {
    private ArrayList<ArrayList<Integer>> meetwaarden;
    private final String naam;
    private final int jaar;

    public Weerstation(String naam, int jaar){
        this.meetwaarden = new ArrayList<>();
        this.naam = naam;
        this.jaar = jaar;
        for(int i = 0; i < 31; i ++) {
            meetwaarden.add(new ArrayList<>(Arrays.asList(0,0,0,0)));
        }
    }

    public void voegDagToe(int dag, int[] waarden) {
        meetwaarden.set(dag - 1, new ArrayList<>(Arrays.asList(waarden[0], waarden[1], waarden[2], waarden[3])));
    }


}
