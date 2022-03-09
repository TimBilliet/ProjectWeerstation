package logica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Weerstation : Weerstation
 *
 * @author Tim Billiet
 * @version 9/03/2022
 */
public class Weerstation {
    private ArrayList<int[]> meetwaarden;
    private final String naam;
    private final int jaar;

    public Weerstation(String naam, int jaar){
        this.meetwaarden = new ArrayList<>();
        this.naam = naam;
        this.jaar = jaar;

    }

    public void voegDagToe(int dag, int[] waarden) {
        meetwaarden.add(dag - 1, waarden);
    }

    public ArrayList<int[]> getMeetwaarden() {
        return meetwaarden;
    }
}
