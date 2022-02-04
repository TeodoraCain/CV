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

class Suplimente extends ProduseAnimaleCompanie {
    String beneficii; //imunitate, oase si articulatii, piele si blana, apetit si digestive, fertilitate
    String forma; //capsule, gel, granule, masticabil, tablete, pulberi, lichide, injectabile
    boolean prescriptie; //necesara sau nu

//CONSTRUCTOR FARA PARAMETRI
    Suplimente() {
        super();
        beneficii = ""; //imunitate, oase si articulatii, piele si blana, apetit si digestiv, fertilitate
        forma = ""; //capsule, gel, granule, masticabil, tablete, pulberi, lichide, injectabile
        prescriptie = false; //necesara sau nu
    }
    
//CONSTRUCTOR CU PARAMETRI
    Suplimente(boolean d, String s, String n, String p, float pr, String c, String b, String f, boolean pre )
    {
        super(d, s, n, p, pr, c);
        beneficii = b;
        forma = f;
        prescriptie = pre;
    }
    
//CONSTRUCTOR DE COPIERE
    Suplimente (Suplimente s) {
        super(s);
        beneficii = s.beneficii;
        forma = s.forma;
        prescriptie = s.prescriptie;
    }
    
    // METODA TOSTRING
    public String toString() {
        return super.toString()
               + "\nbeneficii: " + this.beneficii
               + "\nforma: " + this.forma
               + "\nprescriptie: " + this.prescriptie;
    }
}
