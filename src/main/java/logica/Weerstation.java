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
        switch (maand) {
            case "januari":
            case "maart":
            case "mei":
            case "juli":
            case "augustus":
            case "oktober":
            case "december":
                for (int i = 0; i < 31; i++) {
                    meetwaarden.add(new ArrayList<>(Arrays.asList(null, null, null, null)));
                }
                break;
            case "april":
            case "juni":
            case "september":
            case "november":
                for (int i = 0; i < 30; i++) {
                    meetwaarden.add(new ArrayList<>(Arrays.asList(null, null, null, null)));
                }
                break;
            case "februari":
                for (int i = 0; i < 28; i++) {
                    meetwaarden.add(new ArrayList<>(Arrays.asList(null, null, null, null)));
                }
                break;
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

    public double[] berekenGemiddelden() {
        int [] waarde = new int[meetwaarden.size()];
        double [] uitvoer = new double[4];
        if(meetwaarden.size() > 0) {
            for (int j = 0; j < 4; j++) {
                for (int i = 0; i < meetwaarden.size(); i++) {
                    if (!meetwaarden.get(i).equals(new ArrayList<>(Arrays.asList(null, null, null, null)))) {
                        waarde[i] = meetwaarden.get(i).get(j);
                    }
                }
                uitvoer[j] = berekenGemiddeldeRij(waarde);
            }
        }
        return uitvoer;
    }

    public double berekenGemiddeldeRij(int[] rij) {
        int totaal = 0;
        int lengte = 0;
        for (int element:rij) {
            if (element != 0){
                totaal += element;
                lengte++;
            }
        }
        return Math.round((totaal / (double)lengte) * 100) / 100.0;
    }

    public boolean bevatKoudeGolf() {
        int vriesdagen = 0;
        int diepe_vriesdagen = 0;
        if(meetwaarden.size() > 0) {
            for (int i = 0; i < meetwaarden.size(); i++) {
                if (!meetwaarden.get(i).equals(new ArrayList<>(Arrays.asList(null, null, null, null)))) {
                    if (meetwaarden.get(i).get(0) < 0) {
                        vriesdagen++;
                        if (meetwaarden.get(i).get(0) <= -10) {
                            diepe_vriesdagen++;
                        }
                    }
                }
            }
        }
        return vriesdagen >= 5 && diepe_vriesdagen >= 3;
    }

}