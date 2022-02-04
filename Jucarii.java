package ProduseAnimaleCompanie;

//JUCARII. SUBCLASA1
    public class Jucarii extends ProduseAnimaleCompanie  
    { boolean zornaitoare; //da/nu
      String forma; //sferica/cilindrica/os/pasare
      int cantitate; //vin in pachet de cate 2/3/5/etc.
      
    public Jucarii()
    { super();
      zornaitoare = false;
      forma = "Necunoscuta"; 
      cantitate = 0;
    }
    
    public Jucarii(boolean a, String b, int c, boolean disp, String sp, String nume, String prod, float pret, String catVrst)
    { super(disp, sp, nume, prod, pret, catVrst);
      this.zornaitoare = a;
      this.forma = b;
      this.cantitate = c;
    }
    
    public Jucarii(Jucarii j)
    { this.zornaitoare = j.zornaitoare;
      this.forma = j.forma;
      this.cantitate = j.cantitate;
    }   
 
    
@Override
public String toString()
{ return super.toString() + "INFORMATII DESPRE JUCARII \n" + 
        "Jucaria zornaie? " + zornaitoare + "\n" +
        "Forma jucariei: " + forma + "\n" +
        "Cantitate: " + cantitate + "\n\n";
}

public Jucarii ConditieJ (Jucarii j)
{
    if (j.pret>=30.00f)
        System.out.println("Urmatoarele jucarii costa mai mult de 30RON: " + numeProdus); 
    return j;  
}

    }
