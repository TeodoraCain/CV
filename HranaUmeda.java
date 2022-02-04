package ProduseAnimaleCompanie;

class HranaUmeda extends ProduseAnimaleCompanie {
    String tipAmbalaj; //Conserva, Cutie, Plic sau Sac
    int gramaj; //Se explica de la sine
    String aroma; //Pui, Vita, Ton etc.
    String beneficiu; //Sistem digestiv, Ingrijire piele si blana, Sistem urinar etc.
    String dietaSpeciala; //Bogata in proteine, Fara coloranti, Bio etc.

    HranaUmeda() {
        super();
        tipAmbalaj="Necunoscut";
        gramaj=0;
        aroma="Necunoscuta";
        beneficiu="Necunoscut";
        dietaSpeciala="Nu este cazul";
    }
    HranaUmeda(boolean d, String s, String n, String p, float pr, String c, String ta, int g, String a, String b, String di) {
        super(d,s,n,p,pr,c);
        tipAmbalaj=ta;
        gramaj=g;
        aroma=a;
        beneficiu=b;
        dietaSpeciala=di;
    }
    HranaUmeda(HranaUmeda hum) {
        super(hum);
        tipAmbalaj=hum.tipAmbalaj;
        gramaj=hum.gramaj;
        aroma=hum.aroma;
        beneficiu=hum.beneficiu;
        dietaSpeciala=hum.dietaSpeciala;
    }
    public String toString() {
        return super.toString()+"\nTip ambalaj: "+tipAmbalaj+";\nGramaj: "+gramaj+" grame;\nAroma: "+aroma+";\nBeneficiu: "+beneficiu+";\nDieta speciala:"+dietaSpeciala+".\n";
    }
}