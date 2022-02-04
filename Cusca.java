
package ProduseAnimaleCompanie;

import java.awt.Color;
import java.io.Serializable;

class Cusca extends ProduseAnimaleCompanie implements Serializable{
   private char dimensiune;    //S, M, L
   private String material;
   Color culoare;
 
    Cusca()          //constructor fara parametri
    { 
        super();
        dimensiune = ' ';
        material = "necunoscut";
        culoare = null;
        
    }
    
    Cusca(boolean disponibilitate, String specieAnimal, String numeProdus, String numeProducator, float pret, String categorieVarsta, char dimensiune, String material, Color culoare)  //constructor cu parametri
    {
        super(disponibilitate, specieAnimal, numeProdus, numeProducator, pret, categorieVarsta);
        this.dimensiune = dimensiune;
        this.material = material;
        this.culoare = culoare;
       
    }
    
    Cusca(Cusca c)                                                            //constructor de copiere
    {
        super(c);
        dimensiune = c.dimensiune;
        material = c.material;
        culoare = c.culoare;
    }
    
    public Color getCuloare(){
        return culoare;
    }
    
    public String getMaterial(){
        return material;
    }
    
    public char getDimensiune(){
        return dimensiune;
    }
    
     public void setCuloare(Color culoare){
        this.culoare = culoare;
    }
    
    public void setMaterial(String material){
       this.material = material;
    }
    
    public void setDimensiune(char dimensiune){
        this.dimensiune = dimensiune;
    }
    
       public String getNumeProdus(){
        return super.getNumeProdus();
    }
    
     public String getSpecieAnimal(){
        return super.getSpecieAnimal();
    }
     
     public boolean getDisponibilitate(){
        return super.getDisponibilitate();
    }
    
     public String getNumeProducator(){
        return super.getNumeProducator();
    }
     
     public float getPret(){
        return super.getPret();
    }
     
     public String getCategorieVarsta(){
        return super.getCategorieVarsta();
    }
    
     public String getNumeCuloare(Color culoare){
         String numeCuloare = "";
      if(culoare!=null)
      {
          if(culoare == Color.BLACK)
                 numeCuloare = "Negru";
             else if (culoare == Color.BLUE)
                        numeCuloare ="Albastru";
                 else if(culoare == Color.DARK_GRAY)
                        numeCuloare = "Gri Inchis";
                     else if(culoare == Color.YELLOW)
                            numeCuloare = "Galben";
                         else if(culoare==Color.WHITE)
                                numeCuloare = "Alb";
                            else if(culoare == Color.GREEN)
                                numeCuloare = "Verde";
                            else if(culoare == Color.GRAY)
                                numeCuloare = "Gri";
                            else if(culoare == Color.RED)
                                 numeCuloare = "Rosu";
      }
      else
          numeCuloare = "necunoscut";
                           
         return numeCuloare;
     }
     
     public void setCuloare(String numeCuloare)
     {
            switch(numeCuloare){
                case "Negru" :this.culoare=Color.BLACK;
                break;
                case "Albastru":this.culoare =Color.BLUE;
                break;
                case "Gri Inchis":this.culoare = Color.DARK_GRAY;
                break;
                case "Galben":this.culoare = Color.YELLOW;
                break;
                case "Alb":this.culoare = Color.WHITE;
                break;
                case "Verde":this.culoare = Color.GREEN;
                break;
                case "Gri":this.culoare = Color.GRAY;
                break;
                case "Rosu":this.culoare = Color.RED;
                break;
                default: this.culoare = null;
                
            }
                                              
                          
     }
     
     
    @Override
    public String toString()
    {
        return super.toString() + 
                "\nDimensiunea produsului: " + dimensiune + 
                "\nMaterial: " + material +
                "\nCuloare: " + getNumeCuloare(culoare)+"\t";
    }
    
}
