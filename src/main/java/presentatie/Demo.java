package presentatie;


import logica.Weerstation;

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
        String maand;
        int jaar;
        int dag;
        int temperatuur;
        int luchtvochtigheid;
        int neerslagkans;
        int windsterkte;
        Weerstation weerstation = null;
        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("Welkom, wat wil je doen?");
            System.out.println("\t [D]: Toevoegen van de meetwaarde");
            System.out.println("\t [A]: Afprinten van de metingen");
            System.out.println("\t [R]: Weerrapport genereren");
            System.out.println("\t [S]: Stoppen");
            invoer = scan.next();
            if(!invoer.equals("D") && !invoer.equals("A") && !invoer.equals("R") && !invoer.equals("S")) {
                System.out.println("Ongeldige invoer");
            }
            if(!invoer.equals("S") && invoer.equals("D") || invoer.equals("A") || invoer.equals("R")) {
                System.out.println("Voer een maand in");
                maand = scan.next();
                System.out.println("Voer een jaar in");
                jaar = scan.nextInt();
                weerstation = new Weerstation(maand, jaar);
            }

            switch(invoer) {
                case "D":
                    do {
                        System.out.println("Welke dag wil je selecteren (1-31)");
                        dag = scan.nextInt();
                        if(dag < 1 || dag > 31) {
                            System.out.println("Ongeldige dag");
                        }
                    }while(dag < 1 || dag > 31);
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
                    break;
                case "R":
                    break;
            }

        }while (!invoer.equals("S"));
        System.out.println("Programma gestopt");

    }
}
