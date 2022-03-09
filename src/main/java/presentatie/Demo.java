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
        Scanner scan = new Scanner(System.in);
        Weerstation weerstation1 = new Weerstation("april", 2003); // tijdelijk
        weerstation1.voegDagToe(5, new int[]{20, 60, 20, 10});
        System.out.println(weerstation1.getMeetwaarden());
        /*do {
            System.out.println("Welkom, wat wil je doen?");
            System.out.println("\t [D]: Toevoegen van de meetwaarde");
            System.out.println("\t [A]: Afprinten van de meningen");
            System.out.println("\t [R]: Weerrapport genereren");
            System.out.println("\t [S]: Stoppen");

            invoer = scan.next();
            if(!invoer.equals("D") && !invoer.equals("A") && !invoer.equals("R") && !invoer.equals("S")) {
                System.out.println("Ongeldige invoer");
            }
        }while (!invoer.equals("S"));

         */

    }
}
