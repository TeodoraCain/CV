package ProduseAnimaleCompanie;

import java.io.Serializable;

class Nisip extends ProduseIgiena implements Serializable{
String parfum; //standard/argilos/silicat/cu parfum/fara parfum
int gramaj; //saci/cutii
String asternut; //biodegradabil/igienic/absorbant

//CONSTRUCTOR FARA PARAMETRI
Nisip(){
super();
parfum="necunoscut";
gramaj=0;
asternut="necunoscut";
}

//CONSTRUCTOR CU PARAMETRI
Nisip(boolean d, String s, String n, String p, float pr, String c,String tp,int nu,String r,String pf, int g, String a)
{
super(d,s,n,p,pr,c,tp,nu,r);
parfum=pf;
gramaj=g;
asternut=a;
}

//CONSTRUCTOR DE COPIERE
Nisip(Nisip ns){
super(ns);
parfum=ns.parfum;
gramaj=ns.gramaj;
asternut=ns.asternut;
}

public Boolean Conditie(int gramaj)
{
    if(this.gramaj>=gramaj)
        return true;
    else
        return false;
}

public String toString()
{
    return super.toString()
            +"\nparfum:" + this.parfum
            +"\ngramaj:" + this.gramaj
            +"\nasternut:" + this.asternut;
}
}