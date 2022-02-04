
package ProduseAnimaleCompanie;

import java.awt.Color;
import java.io.Serializable;

class CutieTransport extends Cusca implements Serializable{
   private int capacitate;              //greutatea maxima a animalului
   private float greutateProprie;       //greutatea cutiei de transport
   private boolean pliabil;             //daca cutia se poate plia sau nu
    
    
    CutieTransport()                //constructor fara parametri
    {
        super();
        capacitate = 0;
        greutateProprie = 0.0f;
        pliabil = false;
          
    }
    
    CutieTransport(boolean disponibilitate, String specieAnimal, String numeProdus, String numeProducator, float pret, String categorieVarsta, char dimensiune, String material, Color culoare, int capacitate, float greutateProprie, boolean pliabil)  //constructor cu parametri
    {
        super (disponibilitate, specieAnimal, numeProdus, numeProducator, pret, categorieVarsta, dimensiune, material, culoare);
        this.capacitate = capacitate;
        this.greutateProprie = greutateProprie;
        this.pliabil = pliabil;
      
    }
    
    CutieTransport (CutieTransport c)                   //constructor copiere
    {
        super(c);
        capacitate = c.capacitate;
        greutateProprie = c.greutateProprie;
        pliabil= c.pliabil;
       
    }
    
    public int getCapacitate(){
        return capacitate;
    }
    
    public float getGreutateProprie(){
        return greutateProprie;
    }
    
    public boolean pliabil(){
        return pliabil;
    }
    
    public void setCapacitate(int capacitate){
        this.capacitate = capacitate;
    }
    
    public void setGreutateProprie(float greutateProprie){
        this.greutateProprie = greutateProprie;
    }
    
    public void setpliabil(boolean pliabil){
        this.pliabil = pliabil;
    }
    
    
    public String toString()
    {
        return super.toString() + 
                "\nCapacitate(kg): " + capacitate + 
                "\nGreutate(kg): " + greutateProprie + 
                "\nPliabil: " + (pliabil?"Da":"Nu") ;
    }
}
