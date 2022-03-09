package logica;

import java.util.ArrayList;

/**
 * Weerstation : Weerstation
 *
 * @author Tim Billiet
 * @version 9/03/2022
 */
public class Weerstation {
    int dag = 0;
    //private ArrayList<ArrayList<Integer>>;
    public Weerstation(){
        dag++;
    }
    public Weerstation(int dag, int temp){
        this.dag = dag;
    }
}
