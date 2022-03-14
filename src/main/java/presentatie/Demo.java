package presentatie;


import logica.Weerstation;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

/**
 * ProjectWeerstation : Demo
 *
 * @author Tim Billiet
 * @version 9/03/2022
 */

public class Demo {
    public static void main(String[] args) {
        String invoer;
        String maand = "";
        int jaar;
        int dag = 1;
        int temperatuur;
        int luchtvochtigheid;
        int neerslagkans;
        int windsterkte;
        Weerstation weerstation = null;
        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("Welkom, wat wil je doen?");
            System.out.println("\t [D]: Toevoegen van meetwaarden voor een nieuwe dag");
            System.out.println("\t [A]: Afprinten van de metingen");
            System.out.println("\t [R]: Weerrapport genereren");
            System.out.println("\t [S]: Stoppen");
            invoer = scan.next();
            if(!invoer.equals("D") && !invoer.equals("A") && !invoer.equals("R") && !invoer.equals("S")) {
                System.out.println("Ongeldige invoer");
            }
//test
            switch(invoer) {
                case "D":
                    if(maand.equals("")) {
                        System.out.println("Voer een maand in");
                        maand = scan.next();
                        System.out.println("Voer een jaar in");
                        jaar = scan.nextInt();
                        weerstation = new Weerstation(maand, jaar);
                    }
                    maand = maand.toLowerCase();
                    switch (maand) {
                        case "april":
                        case "juni":
                        case "september":
                        case "november":
                            do {
                                System.out.println("Welke dag wil je selecteren (1-30)");
                                dag = scan.nextInt();
                                if (dag < 1 || dag > 30) {
                                    System.out.println("Ongeldige dag");
                                }
                            } while (dag < 1 || dag > 30);
                            break;
                        case "februari":
                            do {
                                System.out.println("Welke dag wil je selecteren (1-28)");
                                dag = scan.nextInt();
                                if (dag < 1 || dag > 28) {
                                    System.out.println("Ongeldige dag");
                                }
                            } while (dag < 1 || dag > 28);
                            break;
                        case "januari":
                        case "maart":
                        case "mei":
                        case "juli":
                        case "augustus":
                        case "oktober":
                        case "december":
                        default:
                            do {
                                System.out.println("Welke dag wil je selecteren (1-31)");
                                dag = scan.nextInt();
                                if (dag < 1 || dag > 31) {
                                    System.out.println("Ongeldige dag");
                                }
                            } while (dag < 1 || dag > 31);
                            break;
                    }
                    System.out.println("Voer de 4 meetwaarden in van deze dag");
                    System.out.println("Temperatuur (°C):");
                    temperatuur = scan.nextInt();
                    System.out.println("Luchtvochtigheid (%):");
                    luchtvochtigheid = scan.nextInt();
                    System.out.println("Neerslagkans (%):");
                    neerslagkans = scan.nextInt();
                    System.out.println("Windsterkte (km/h):");
                    windsterkte = scan.nextInt();
                    weerstation.voegDagToe(dag, new int[]{temperatuur,luchtvochtigheid,neerslagkans,windsterkte} );
                    break;
                case "A":
                    try {
                        assert weerstation != null;
                        System.out.println(weerstation.geefOverzichtMeetWaarden());
                    } catch (NullPointerException e){
                        System.out.println("Er zijn nog geen meetwaarden");
                    }
                    break;
                case "R":
                    try {
                        assert weerstation != null;
                        double [] waarde = weerstation.berekenGemiddelden();
                        String koudegolf;
                        String bovenkant = "Gemiddelden voor de maand " + weerstation.getMaand() + " " + weerstation.getJaar() + " :\n";
                        String waarden = "Temperatuur : " + waarde[0] + "°" + "\n" + "Luchtvochtigheid : " + waarde[1] + " %" + "\n" + "Neerslagkans : " + waarde[2] + " %" + "\n" + "Windsterkte : " + waarde[3] + " km/h" + "\n\n";
                        if (weerstation.bevatKoudeGolf()){
                            koudegolf = "Wel een koudegolf \n\n";
                        } else {
                            koudegolf = "Geen koudegolf \n\n";
                        }
                        System.out.println(bovenkant + waarden + koudegolf);
                    } catch (NullPointerException e){
                        System.out.println("Er zijn nog geen meetwaarden");
                    }
                    break;
            }
        }while (!invoer.equals("S"));
        System.out.println("Programma gestopt");
    }
}
