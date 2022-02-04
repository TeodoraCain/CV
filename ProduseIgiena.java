package ProduseAnimaleCompanie;

import java.io.Serializable;

public class ProduseIgiena extends ProduseAnimaleCompanie implements Serializable{
    String tip; //creme/solutie pentru lacrimi/aparat curatat blana/manusa pentru periat/scutec absorbant/gel dentar
    int nrUtilizari;
    String recipient; //tub/cutie/pachet

//CONSTRUCTOR FARA PARAMETRI
public ProduseIgiena()
{       super();
        tip = "";
        nrUtilizari = 0;
        recipient = "";
}

//CONSTRUCTOR CU PARAMETRI
ProduseIgiena(boolean d, String s, String n, String p, float pr, String c,String tp,int nu,String r)
{
    super(d,s,n,p,pr,c);
    tip = tp;
    nrUtilizari = nu;
    recipient = r;
}

//CONSTRUCTOR DE COPIERE
ProduseIgiena (ProduseIgiena d) {
        super(d);
        tip = d.tip;
        nrUtilizari = d.nrUtilizari;
        recipient = d.recipient;
    }

public Boolean Conditie(int nrUtilizari)
{
    if(this.nrUtilizari>=nrUtilizari)
        return true;
    else
        return false;
}

public String toString()
{
    return super.toString()
            +"\ntip:" + this.tip
            +"\nnrUtilizari:" + this.nrUtilizari
            +"\nrecipient:" + this.recipient;
}
}