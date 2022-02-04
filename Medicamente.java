/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProduseAnimaleCompanie;

/**
 *
 * @author Nicoleta
 */

class Medicamente extends ProduseAnimaleCompanie {
    String rol; //antibiotic, antiparazitar, antiinflamator, antidiareic
    String forma; //capsule, gel, granule, masticabil, tablete, pulberi, lichide, injectabile
    boolean perioadaGestatie; //permis sau nepermis

//CONSTRUCTOR FARA PARAMETRI
    Medicamente() {
        super();
        rol = ""; //antibiotic, antiparazitar, antiinflamator, antidiareic
        forma = ""; //capsule, gel, granule, masticabil, tablete, pulberi, lichide, injectabile
        perioadaGestatie = false; //permis sau nepermis
    }
    
//CONSTRUCTOR CU PARAMETRI
    Medicamente(boolean d, String s, String n, String p, float pr, String c, String r, String f, boolean pg)
    {
        super(d, s, n, p, pr, c);
        rol = r;
        forma = f;
        perioadaGestatie = pg;
    }
    
//CONSTRUCTOR DE COPIERE
    Medicamente (Medicamente m) {
        super(m);
        rol = m.rol;
        forma = m.forma;
        perioadaGestatie = m.perioadaGestatie;
    }
    
    // METODA TOSTRING
    public String toString() {
        return super.toString()
               + "\nrol: " + this.rol
               + "\nforma: " + this.forma
               + "\nperioadaGestatie: " + this.perioadaGestatie;
    }
}
