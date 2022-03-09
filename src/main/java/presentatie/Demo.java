package presentatie;


/**
 * ProjectWeerstation : Demo
 *
 * @author Tim Billiet
 * @version 9/03/2022
 */
public class Demo {
    public static void main(String[] args) {
        String invoer = "";
        do {
            System.out.println("Welkom, wat wil je doen?");
            System.out.println("\t [D]: Toevoegen van de meetwaarde");
            System.out.println("\t [A]: Afprinten van de meningen");
            System.out.println("\t [R]: Weerrapport genereren");
            System.out.println("\t [S]: Stoppen");
            Scanner scan = new Scanner(System.in);
            invoer = scan.next();
        }while (!invoer.equals("S"));
    }

}
