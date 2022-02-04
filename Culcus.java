package ProduseAnimaleCompanie;
    class Culcus extends ProduseAnimaleCompanie
    { String material; //fetru/bumbac/plus
      String cerinteSpeciale; //ortopedic/termice/igienice
      boolean asternut; //da/nu
      String tipAsternut; //paie/fan/lemn/canepa
      
    public Culcus()
    { super();
      material = "Necunoscut";
      cerinteSpeciale = "nu are";
      asternut = false;
      tipAsternut = "Nu are"; 
    }
    
    public Culcus(String a, String b, boolean c, String d, boolean disp, String sp, String nume, String prod, float pret, String catVrst)
    { super(disp, sp, nume, prod, pret, catVrst);
      this.material = a;
      this.cerinteSpeciale = b;
      this.asternut = c;
      this.tipAsternut = d;
    }
    
    public Culcus(Culcus c)
    { this.material = c.material;
      this.cerinteSpeciale = c.cerinteSpeciale;
      this.asternut = c.asternut;
      this.tipAsternut = c.tipAsternut;
    }
    
        
@Override
public String toString()
{ return super.toString() + "INFORMATIII DESPRE CULCUS \n" +
        "Material: " + material + "\n" +
        "Functii speciale ale culcusului: " + cerinteSpeciale + "\n" +
        "Necesita asternut? " + asternut + "\n" + 
        "Tipul asternutului: " + tipAsternut + "\n\n";
}

public Culcus ConditieC (Culcus c)
{
    if (c.specieAnimal=="pisica")
        System.out.println("Urmatorul culcus este pentru pisici: " + numeProdus); 
    return c;  
}
    }