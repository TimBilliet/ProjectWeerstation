package logica;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Weerstation : Weerstation
 *
 * @author Tim Billiet
 * @version 9/03/2022
 */
//test
public class Weerstation {
    private final ArrayList<ArrayList<Integer>> meetwaarden;
    private final String maand;
    private final int jaar;

    public Weerstation(String maand, int jaar){
        this.meetwaarden = new ArrayList<>();
        this.maand = maand;
        this.jaar = jaar;
        for (int i = 0; i < 31; i++) {
            meetwaarden.add(new ArrayList<>(Arrays.asList(null, null, null, null)));
        }
    }

    public void voegDagToe(int dag, int[] waarden) {
        meetwaarden.set(dag - 1, new ArrayList<>(Arrays.asList(waarden[0], waarden[1], waarden[2], waarden[3])));
    }

    public int getJaar() {
        return jaar;
    }

    public String getMaand() {
        return maand;
    }

    public String geefOverzichtMeetWaarden () {
        int dag;
        String waarden = "";
        String bovenkant = "Gegevens voor " + getMaand() + " " + getJaar() + "\n" +
                           "Dag             Temp            Lucht           Neerslagkans    Windsterkte   \n" +
                           "                                vochtigheid                                   \n" +
                           "______________________________________________________________________________\n";
        if(meetwaarden.size() > 0) {
            for (int i = 0; i < meetwaarden.size(); i++) {
                if (!meetwaarden.get(i).equals(new ArrayList<>(Arrays.asList(null, null, null, null)))) {
                    dag = i + 1;
                    waarden =  waarden + dag + "\t\t\t\t" + meetwaarden.get(i).get(0) + "\t\t\t\t" + meetwaarden.get(i).get(1) + "\t\t\t\t" + meetwaarden.get(i).get(2) + "\t\t\t\t" + meetwaarden.get(i).get(3) + "\n";
                }
            }
            return bovenkant + waarden;
        }
        return waarden;
    }
}