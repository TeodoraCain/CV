
package ProduseAnimaleCompanie;

import java.io.Serializable;
import javax.swing.JFrame;

class ProduseAnimaleCompanie implements Serializable{
    
    boolean disponibilitate;
    String numeProducator, numeProdus, specieAnimal, categorieVarsta;
    float pret;      
    
    ProduseAnimaleCompanie()                                        //constructor fara parametri
    {             
        this(false, "nespecificat", "necunoscut", "necunoscut", 0.0f, "nespecificat");
       /* disponibilitate = false;
        specieAnimal = "nespecificat";
        numeProdus = "necunoscut";
        numeProducator = "necunoscut";
        pret = 0.0;
        categorieVarsta = "nespecificat";*/
    }
    
    ProduseAnimaleCompanie(boolean disponibilitate, String specieAnimal, String numeProdus, String numeProducator, float pret, String categorieVarsta) //constructor cu parametri
    {
        this.disponibilitate = disponibilitate;
        this.specieAnimal = specieAnimal;
        this.numeProdus = numeProdus;
        this.numeProducator = numeProducator;
        this.pret = pret;
        this.categorieVarsta = categorieVarsta;
        
    }
    
    ProduseAnimaleCompanie(ProduseAnimaleCompanie p)                //constructor de copiere
    {
        disponibilitate = p.disponibilitate;
        specieAnimal = p.specieAnimal;
        numeProdus = p.numeProdus;
        numeProducator = p.numeProducator;
        pret = p.pret;
        categorieVarsta = p.categorieVarsta;
        
    };
       
    public String getNumeProdus(){
        return numeProdus;
    }
    
     public String getSpecieAnimal(){
        return specieAnimal;
    }
     
     public boolean getDisponibilitate(){
        return disponibilitate;
    }
    
     public String getNumeProducator(){
        return numeProducator;
    }
     
     public float getPret(){
        return pret;
    }
     
     public String getCategorieVarsta(){
        return categorieVarsta;
    }
     
    public String toString()
    {
        return "\n\nNume produs: " + numeProdus  
            + "\nNume producator: " + numeProducator
            + "\nDisponibilitate: " + (disponibilitate?"disponibil":"indisponibil") 
            + "\nSpecie animal: " + specieAnimal 
            + " \nCategorie varsta: " + categorieVarsta;
            //+ "\nPret:" + pret + '\n';
    }
    
    JFrame NewJFrame = new JFrame();
}
