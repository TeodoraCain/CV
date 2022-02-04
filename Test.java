package ProduseAnimaleCompanie;

import java.awt.Color;
import java.util.ArrayList;

class Test {
    //-------------------------VALENTIN-----------------------------------------
    ArrayList<ProduseAnimaleCompanie> listaIgProduseAnimaleCompanie;
    ArrayList<ProduseIgiena> listaProduseIgiena;
    ArrayList<Nisip> listaNisip;
    //-------------------------MIRELA---------------------------------------------
    static ArrayList<Culcus> listaCulcus;
    static ArrayList<Jucarii> listaJucarii;

    //---------------------------TEODORA----------------------------------------
    ArrayList<Cusca> listaCusti;
    ArrayList<CutieTransport> listaCutii;

    //-------------------------NICOLETA-----------------------------------------
    ArrayList<ProduseAnimaleCompanie> listaProduseAnimaleCompanie;
    ArrayList<Medicamente> listaMedicamente;
    ArrayList<Suplimente> listaSuplimente;
    
    //------------------------ANDREI--------------------------------------------
    ArrayList<HranaUscata> listaHranaUscata;
    ArrayList<HranaUmeda> listaHranaUmeda;

    Test() {

        ProduseAnimaleCompanie p1, p2, p3;

        p1 = new ProduseAnimaleCompanie();
        p2 = new ProduseAnimaleCompanie(true, "caine", "Cusca", "Royal", 109.9f, "senior");
        p3 = new ProduseAnimaleCompanie(p2);

        /*System.out.println("ProduseAnimaleCompanie: " + p1
                + "\n\nConstructorul cu parametri: " + p2
                + "\n\nConstructor copiere: " + p3 + "\n");
        */

        //------------------------CUSTI----------------------------------------------------
        Cusca c0 = new Cusca();
        Cusca c1 = new Cusca(true, "caine", "Cusca Nature Lodge", "Trixie", 979.9f, "adult", 'L', "lemn", Color.BLACK);
        Cusca c2 = new Cusca(c1);

        Cusca c3 = new Cusca(false, "pisica", "Cusca Pueblo", "Pueblo", 189.9f, "junior", 'S', "rachita", Color.YELLOW);
        Cusca c4 = new Cusca(true, "caine", "Cusca Spike Comfort", "Royal", 229.9f, "toate categoriile de varsta", 'M', "plastic", Color.WHITE);
        Cusca c5 = new Cusca(true, "pisica", "Cusca Maisonette", "Trixie", 304.9f, "toate categoriile de varsta", 'M', "lemn", Color.DARK_GRAY);
        Cusca c6 = new Cusca(true, "caine", "Cusca Amsterdam", "Modern Living", 279.9f, "junior", 'S', "PVC", Color.BLACK);
        Cusca c7 = new Cusca(true, "pisica", "Cusca Sunroof", "Imperial", 479.9f, "junior", 'L', "lemn", Color.GREEN);
        Cusca c8 = new Cusca(false, "caine", "Cusca Bruno", "Bruno", 324.9f, "junior", 'S', "lemn", Color.YELLOW);
        Cusca c9 = new Cusca(true, "pisica", "Cusca Holiday Home", "Imperial", 37.9f, "toate categoriile de varsta", 'L', "carton", Color.WHITE);

        //----------------------AFISARE CONSTRUCTORI----------------------------
        /*System.out.println("Cusca:\n " + c0
                + "\n\nConstructorul cu parametri:\n " + c1
                + "\n\nConstructor copiere: \n" + c2 + "\n");
        */

        Cusca[] vectorCusti = {c0, c1, c2, c3, c4, c5, c6, c7, c8, c9};
        //----------------------AFISARE VECTOR COMPLET--------------------------
        /*for(Cusca index:vectorCusti)
          System.out.println(index);
         */
        //----------------------AFISARE VECTOR CU CONDITIE----------------------
        for (Cusca index : vectorCusti) {
            if (index.getCuloare() == Color.WHITE && (index.getCategorieVarsta().compareToIgnoreCase("junior") == 0 || index.getCategorieVarsta().compareToIgnoreCase("toate categoriile de varsta") == 0 ))
                System.out.println("\nCusca culoarea alb pentru juniori: " + index);
        }
        //----------------------ARRAY LIST--------------------------------------
        listaCusti = new ArrayList<Cusca>();
        for (Cusca index : vectorCusti) {
            listaCusti.add(index);
        }

        //-----------------------------CUTII TRANSPORT--------------------------
        CutieTransport t0 = new CutieTransport();
        CutieTransport t1 = new CutieTransport(true, "pisica", "Geanta de transport", "Karo", 139.9f, "junior", 'S', "Poliester", Color.RED, 5, 1.3f, true);
        //CutieTransport t2 = new CutieTransport(t1);
        CutieTransport t2 = new CutieTransport(true, "pisica", "Geanta de transport", "Lana", 139.9f, "junior", 'S', "Poliester", Color.RED, 5, 1.3f, true);

        CutieTransport t3 = new CutieTransport(true, "caine", "Geanta Outdoor Transportor", "Hunter", 394.9f, "toate categoriile", 'L', "Nailon", Color.BLACK, 52, 6.86f, true);
        CutieTransport t4 = new CutieTransport(true, "pisica", "Rucsac View", "Imperial", 149.9f, "junior", 'S', "Poliester", Color.BLACK, 6, 0.96f, false);
        CutieTransport t5 = new CutieTransport(true, "caine", "geanta pliabila basic", "First Class", 119.9f, "adult", 'M', "Poliester", Color.GRAY, 20, 2.3f, true);
        CutieTransport t6 = new CutieTransport(true, "pisica", "Geanta de transport cu extensie", "Onoen", 189.9f, "adult", 'L', "Poliester", Color.GRAY, 12, 1.6f, true);
        CutieTransport t7 = new CutieTransport(true, "caine", "Geanta de transport", "Technicolor", 74.9f, "junior", 'S', "Poliester", Color.GREEN, 7, 1.13f, false);
        CutieTransport t8 = new CutieTransport(false, "pisica", "Avior Transportor", "Nobby ", 114.9f, "adult", 'L', "Plastic", Color.BLUE, 10, 1.1f, false);
        CutieTransport t9 = new CutieTransport(true, "caine", "Geanta de transport", "AluRide", 829.9f, "toate categoriile", 'L', "Aluminiu", Color.BLUE, 25, 17.5f, false);

        //----------------------AFISARE CONSTRUCTORI----------------------------
        /*System.out.println("\nCutieTransport: \n" + t0
                + "\nConstructorul cu parametri: \n" + t1
                + "\nConstructor copiere: \n" + t2 + "\n");
        */

        CutieTransport[] vectorTransport = {t0, t1, t2, t3, t4, t5, t6, t7, t8, t9};
        //----------------------AFISARE VECTOR COMPLET--------------------------
        /*  for(CutieTransport index:vectorTransport)
               System.out.println(index);
         */
        //----------------------AFISARE VECTOR CU CONDITIE----------------------
        for (CutieTransport index : vectorTransport) {
            if (12 < index.getCapacitate() && index.pliabil() == true) {
                System.out.println("\nCutie Transport cu capcitatea mai mare decat 12kg, pliabila: " + index);
            }
        }
        //----------------------ARRAY LIST--------------------------------------
        listaCutii = new ArrayList<CutieTransport>();
        for (CutieTransport index : vectorTransport) {
            listaCutii.add(index);
        }

        //Nicoleta
        /*ProduseAnimaleCompanie p1, p2, p3; //initi 3 obiecte
        p1 = new ProduseAnimaleCompanie(); //se apeleaza const fara parametri din cl parinte
        p2 = new ProduseAnimaleCompanie(true, "iepure", "Hepabial", "Theseo", 55.99f, "junior"); ///*se apeleaza constructorul cu parametri in ordine
        p3 = new ProduseAnimaleCompanie(p2);
        System.out.println("ProduseAnimaleCompanie: \n" + p1 + "\n\nConstructorul cu parametri: " + p2 + "\n\nConstructorul de copiere: " + p3 + "\n");
         */
        Medicamente m1, m2, m3;
        m1 = new Medicamente();
        m2 = new Medicamente(true, "caine", "Convenia", "Zoetis", 99.99f, "senior", "antibiotic", "injectabil", true);
        m3 = new Medicamente(m2);
        System.out.println("\nMedicamente: \n" + m1 + "\nConstructorul cu parametri: " + m2 + "\nConstructorul de copiere: " + m3 + "\n");

        Suplimente s1, s2, s3;
        s1 = new Suplimente(); //construtorul clasei suplimente are date membre mostenite de la clasa parinte + campurile proprii
        s2 = new Suplimente(true, "pisica", "Impromune", "Bioiberica", 20.50f, "junior", "imunitate", "lichid", false);
        s3 = new Suplimente(s2);
        System.out.println("\nSuplimente: \n" + s1 + "\nConstructorul cu parametri: " + s2 + "\nConstructorul de copiere: " + s3 + "\n");

        ProduseAnimaleCompanie p5, p6, p7, p8, p9, p10, p11, p12, p13, p14;
        p5 = new ProduseAnimaleCompanie(true, "pisica", "Gastrointestinal", "Royal Canin Veterinary", 51.42f, "junior");
        p6 = new ProduseAnimaleCompanie(false, "pisica", "Food Sensitivities", "Hill's Prescription Diet", 53.14f, "senior");
        p7 = new ProduseAnimaleCompanie(true, "caine", "Satiety Weight Management", "Royal Canin Veterinary", 33.32f, "junior");
        p8 = new ProduseAnimaleCompanie(false, "caine", "Protect Intestinal", "Animonda Integra", 24.94f, "senior");
        p9 = new ProduseAnimaleCompanie(true, "pisica", "Protect Sensitive", "Animonda Integra", 38.17f, "junior");
        p10 = new ProduseAnimaleCompanie(false, "pisica", "Complete", "Felini", 37.96f, "senior");
        p11 = new ProduseAnimaleCompanie(true, "caine", "Renal", "Eukanuba Veterinary Diets", 19.99f, "junior");
        p12 = new ProduseAnimaleCompanie(false, "caine", "Gelenk", "Luposan", 135.15f, "senior");
        p13 = new ProduseAnimaleCompanie(true, "pisica", "Calmurofel", "Bioiberica", 96.53f, "junior");
        p14 = new ProduseAnimaleCompanie(false, "caine", "Derm Complete", "Hill's Prescription Diet", 30.41f, "senior");

        listaProduseAnimaleCompanie = new ArrayList<ProduseAnimaleCompanie>();
        listaProduseAnimaleCompanie.add(p5);
        listaProduseAnimaleCompanie.add(p6);
        listaProduseAnimaleCompanie.add(p7);
        listaProduseAnimaleCompanie.add(p8);
        listaProduseAnimaleCompanie.add(p9);
        listaProduseAnimaleCompanie.add(p10);
        listaProduseAnimaleCompanie.add(p11);
        listaProduseAnimaleCompanie.add(p12);
        listaProduseAnimaleCompanie.add(p13);
        listaProduseAnimaleCompanie.add(p14);

        //System.out.println("\nLista Produse Animale Companie:" + listaProduseAnimaleCompanie);
        System.out.println("\n\nLista Produse Animale Companie disponibile cu pret mai mic de 25 de lei:");
        for (int i = 0; i < listaProduseAnimaleCompanie.size(); i++) {
            if (listaProduseAnimaleCompanie.get(i).pret < 25 && listaProduseAnimaleCompanie.get(i).disponibilitate == true) {
                System.out.println(listaProduseAnimaleCompanie.get(i));
            }
        }

        Medicamente m5, m6, m7, m8, m9, m10, m11, m12, m13, m14;
        m5 = new Medicamente(true, "pisica", "Dehinel", "KRKA", 19.23f, "junior", "antiparazitar", "comprimate", false);
        m6 = new Medicamente(false, "pisica", "Rycarfa", "KRKA", 25.99f, "senior", "antiinflamator", "injectabil", true);
        m7 = new Medicamente(true, "caine", "Milprazon", "KRKA", 58.03f, "junior", "antiparazitar", "tablete", false);
        m8 = new Medicamente(false, "caine", "Rycarfa Flavour", "KRKA", 44.99f, "senior", "antiinflamator", "tablete", true);
        m9 = new Medicamente(true, "pisica", "Efex", "Ceva", 42.99f, "junior", "antibiotic", "comprimate", false);
        m10 = new Medicamente(false, "pisica", "Nelio", "Ceva", 436.31f, "senior", "afectiuni cardiologice", "tablete", true);
        m11 = new Medicamente(true, "caine", "Spectam", "Ceva", 57.00f, "junior", "antibiotic", "injectabil", false);
        m12 = new Medicamente(false, "caine", "Cardalis", "Ceva", 127.50f, "senior", "afectiuni cardiologice", "tablete", true);
        m13 = new Medicamente(true, "pisica", "Galastop", "Ceva", 108.50f, "junior", "afectiuni hormonale", "lichid", false);
        m14 = new Medicamente(false, "caine", "Zyme", "RX Vitamins", 136.70f, "senior", "afectiuni digestive", "pulbere", true);

        listaMedicamente = new ArrayList<Medicamente>();
        listaMedicamente.add(m5);
        listaMedicamente.add(m6);
        listaMedicamente.add(m7);
        listaMedicamente.add(m8);
        listaMedicamente.add(m9);
        listaMedicamente.add(m10);
        listaMedicamente.add(m11);
        listaMedicamente.add(m12);
        listaMedicamente.add(m13);
        listaMedicamente.add(m14);

        //System.out.println("\n\nLista Medicamente:" + listaMedicamente);
        System.out.println("\n\nLista Medicamente nepermise in perioada de gestatie cu pret mai mic de 50 de lei:");
        for (int j = 0; j < listaMedicamente.size(); j++) {
            if (listaMedicamente.get(j).pret < 50 && listaMedicamente.get(j).perioadaGestatie == false) {
                System.out.println(listaMedicamente.get(j));
            }
        }

        Suplimente s5, s6, s7, s8, s9, s10, s11, s12, s13, s14;
        s5 = new Suplimente(true, "pisica", "Oncovet", "Stangest", 568.34f, "junior", "imunitate", "pulbere", false);
        s6 = new Suplimente(false, "pisica", "CondroCare", "Stangest", 361.91f, "senior", "oase si articulatii", "tablete", true);
        s7 = new Suplimente(true, "caine", "Canine Plus Growth XL", "VetriScience", 666.15f, "junior", "crestere", "tablete", false);
        s8 = new Suplimente(false, "caine", "Neurovet", "Stangest", 606.87f, "senior", "afectiuni neurologice", "tablete", true);
        s9 = new Suplimente(true, "pisica", "Nausi Tab", "Alfavet", 86.69f, "junior", "antistres", "tablete", false);
        s10 = new Suplimente(false, "pisica", "Vitamina C", "Diafarm", 25.94f, "senior", "imunitate", "tablete", true);
        s11 = new Suplimente(true, "caine", "Immune Support", "Vet's Best", 80.22f, "junior", "imunitate", "tablete", false);
        s12 = new Suplimente(false, "caine", "Immuno Colastra", "PetWay", 95.25f, "senior", "imunitate", "tablete", true);
        s13 = new Suplimente(true, "pisica", "Kalsium Plus", "Vetiq", 36.40f, "junior", "crestere", "tablete", false);
        s14 = new Suplimente(false, "caine", "Kanavit", "Diafarm", 18.27f, "senior", "oase si articulatii", "tablete", true);

        listaSuplimente = new ArrayList<Suplimente>();
        listaSuplimente.add(s5);
        listaSuplimente.add(s6);
        listaSuplimente.add(s7);
        listaSuplimente.add(s8);
        listaSuplimente.add(s9);
        listaSuplimente.add(s10);
        listaSuplimente.add(s11);
        listaSuplimente.add(s12);
        listaSuplimente.add(s13);
        listaSuplimente.add(s14);

        //System.out.println("\n\nLista Suplimente" + listaSuplimente);
        System.out.println("\n\nLista Suplimente pentru imunitate cu pret mai mare de 50 de lei:");
        for (int k = 0; k < listaSuplimente.size(); k++) {
            if (listaSuplimente.get(k).pret > 50 && listaSuplimente.get(k).beneficii.contains("imunitate")) {
                System.out.println(listaSuplimente.get(k));
            }
        }

        //Andrei
        /*
        ProduseAnimaleCompanie p1,p2,p3;
        p1=new ProduseAnimaleCompanie(); 
        p2=new ProduseAnimaleCompanie(true,"pisica","Hrana Umeda","Sheba",59.9,"adult"); 
        p3=new ProduseAnimaleCompanie(p2);
        System.out.println("ProduseAnimaleCompanie:"+p1+"\nConstructorul cu parametri:"+p2+"\nConstructor copiere:"+p3+"\n");
         */
        //ArrayList<HranaUmeda> listaHranaUmeda;
        HranaUmeda hum1, hum2, hum3, hum4, hum5, hum6, hum7, hum8, hum9, hum10;
        hum1 = new HranaUmeda(true, "Pisica", "Hrana Umeda 1", "Whiskas", 55.9f, "Senior/Adult", "Plic", 4000, "Pasare", "Sistemul urinar/Ingrijire piele si blana", "Bogata in proteine/Fara coloranti");
        hum2 = new HranaUmeda(true, "Pisica", "Hrana Umeda 2", "Felix", 20.0f, "Adult", "Plic", 1000, "Pui", "Necunoscut", "Nu este cazul");
        hum3 = new HranaUmeda(true, "Pisica", "Hrana Umeda 3", "Brit Premium", 23.9f, "Adult", "Plic", 1200, "Vita/Pui/Somon/Peste alb", "Necunoscut", "Nu este cazul");
        hum4 = new HranaUmeda(true, "Pisica", "Hrana Umeda 4", "Whiskas", 23.9f, "Adult", "Plic", 1200, "Necunoscuta", "Necunoscut", "Nu este cazul");
        hum5 = new HranaUmeda(true, "Pisica", "Hrana Umeda 5", "Royal Canin", 56.2f, "Junior", "Plic", 2040, "Mix de carne", "Sistemul imunitar", "Nu este cazul");
        hum6 = new HranaUmeda(true, "Pisica", "Hrana Umeda 6", "Gourmet", 29.9f, "Adult", "Plic", 1020, "Vita/Pui/Miel/Rata/Iepure/Curcan/Vanat/Vitel", "Necunoscut", "Fara coloranti/Fara conservanti/Fara arome artificiale");
        hum7 = new HranaUmeda(true, "Pisica", "Hrana Umeda 7", "Felix", 44.9f, "Adult", "Plic", 2000, "Peste/Somon", "Necunoscut", "Nu este cazul");
        hum8 = new HranaUmeda(true, "Pisica", "Hrana Umeda 8", "Felix", 23.3f, "Adult", "Plic", 1000, "Somon", "Necunoscut", "Nu este cazul");
        hum9 = new HranaUmeda(true, "Pisica", "Hrana Umeda 9", "Friskies", 21.7f, "Adult", "Plic", 1105, "Curcan", "Pisici sterilizate", "Fara coloranti/Fara conservanti/Fara arome artificiale");
        hum10 = new HranaUmeda(true, "Pisica", "Hrana Umeda 10", "Gourmet", 15.5f, "Adult", "Conserva", 510, "Miel/Legume", "Necunoscut", "Fara coloranti/Fara conservanti/Fara arome artificiale");

        listaHranaUmeda = new ArrayList<HranaUmeda>();
        listaHranaUmeda.add(hum1);
        listaHranaUmeda.add(hum2);
        listaHranaUmeda.add(hum3);
        listaHranaUmeda.add(hum4);
        listaHranaUmeda.add(hum5);
        listaHranaUmeda.add(hum6);
        listaHranaUmeda.add(hum7);
        listaHranaUmeda.add(hum8);
        listaHranaUmeda.add(hum9);
        listaHranaUmeda.add(hum10);

        //ArrayList<HranaUscata> listaHranaUscata;
        HranaUscata hus1, hus2, hus3, hus4, hus5, hus6, hus7, hus8, hus9, hus10;
        hus1 = new HranaUscata(true, "Pisica", "Hrana Uscata 1", "Whiskas", 134.9f, "Adult", "Sac", 14000, "Vita", "Controlul greutatii/Sanatatea inimii", "Bogata in proteine");
        hus2 = new HranaUscata(true, "Pisica", "Hrana Uscata 2", "Kirby Cat", 69.9f, "Adult", "Sac", 12000, "Pui/Curcan", "Stimularea cresterii", "Bogata in proteine");
        hus3 = new HranaUscata(true, "Pisica", "Hrana Uscata 3", "Whiskas", 18.2f, "Adult", "Plic", 1400, "Pui", "Controlul greutatii", "Nu este cazul");
        hus4 = new HranaUscata(true, "Pisica", "Hrana Uscata 4", "Whiskas", 16.9f, "Adult", "Sac", 1400, "Ton", "Sanatatea rinichilor", "Nu este cazul");
        hus5 = new HranaUscata(true, "Pisica", "Hrana Uscata 5", "Purina One", 34.9f, "Adult", "Sac", 1500, "Somon", "Controlul greutatii/Sistemul digestiv/Pisici sterilizate", "Bogata in proteine/Fara coloranti/Fara conservanti/Fara arome artificiale");
        hus6 = new HranaUscata(true, "Pisica", "Hrana Uscata 6", "Whiskas", 13.7f, "Junior", "Sac", 800, "Pui", "Sistemul digestiv/Stimularea cresterii/Perioada de gestatie", "Nu este cazul");
        hus7 = new HranaUscata(true, "Pisica", "Hrana Uscata 7", "Purina One", 17.4f, "Adult", "Plic", 800, "Vita", "Controlul greutatii/Sistemul digestiv/Pisici sterilizate", "Nu este cazul");
        hus8 = new HranaUscata(true, "Pisica", "Hrana Uscata 8", "Royal Canin", 139.0f, "Adult", "Sac", 4000, "Pui", "Controlul greutatii/Pisici sterilizate", "Nu este cazul");
        hus9 = new HranaUscata(true, "Pisica", "Hrana Uscata 9", "Purina One", 34.9f, "Adult", "Sac", 1500, "Curcan", "Sistemul digestiv/Sistemul osos si articulatii/Ingrijire piele si blana", "Bogata in proteine/Fara coloranti/Fara conservanti/Fara arome artificiale");
        hus10 = new HranaUscata(true, "Pisica", "Hrana Uscata 10", "Advance", 69.9f, "Adult", "Sac", 3000, "Somon", "Pisici sterilizate", "Bogata in proteine");

        listaHranaUscata = new ArrayList<HranaUscata>();
        listaHranaUscata.add(hus1);
        listaHranaUscata.add(hus2);
        listaHranaUscata.add(hus3);
        listaHranaUscata.add(hus4);
        listaHranaUscata.add(hus5);
        listaHranaUscata.add(hus6);
        listaHranaUscata.add(hus7);
        listaHranaUscata.add(hus8);
        listaHranaUscata.add(hus9);
        listaHranaUscata.add(hus10);
        
        for (HranaUmeda hum:listaHranaUmeda)
            if(hum.gramaj>=1200)
                System.out.print("Produsul "+hum.numeProdus+" are mai mult de 1.2kg:\n"+hum);
        
        for (HranaUscata hus:listaHranaUscata)
            if(hus.gramaj>=1200)
                System.out.print("Produsul "+hus.numeProdus+" are mai mult de 1.2kg:\n"+hus);
         
        //new MagazinHrana().setVisible(true);
        //Valentin
        ProduseAnimaleCompanie pac1,pac2,pac3,pac4,pac5,pac6,pac7,pac8,pac9,pac10;
pac1=new ProduseAnimaleCompanie(true,"pisica","Elmex","Fortan",19.9f,"senior");
pac2=new ProduseAnimaleCompanie(true,"pisica","Nixodor Felina","Royal",29.9f,"senior");
pac3=new ProduseAnimaleCompanie(true,"caine","Trixie","Nora",13.7f,"junior");
pac4=new ProduseAnimaleCompanie(true,"pisica","Top Care","Luxury",17.3f,"senior");
pac5=new ProduseAnimaleCompanie(true,"pisica","Pet Head Fantastic Spray","Fortan",44.9f,"senior");
pac6=new ProduseAnimaleCompanie(true,"pisica","Ever Clean","Cora",30.7f,"junior");
pac7=new ProduseAnimaleCompanie(true,"pisica","Tigerino","Royal",29.8f,"senior");
pac8=new ProduseAnimaleCompanie(true,"pisica","Miau Miau","Luxury",34.7f,"senior");
pac9=new ProduseAnimaleCompanie(true,"caine","Vet's Best","Comod",39.8f,"junior");
pac10=new ProduseAnimaleCompanie(true,"pisica","Hygiene Plus","Nora",49.8f,"senior");
ProduseAnimaleCompanie[] vectorProduseAnimaleCompanie=new ProduseAnimaleCompanie[10];
vectorProduseAnimaleCompanie[0]=pac1;
vectorProduseAnimaleCompanie[1]=pac2;
vectorProduseAnimaleCompanie[2]=pac3;
vectorProduseAnimaleCompanie[3]=pac4;
vectorProduseAnimaleCompanie[4]=pac5;
vectorProduseAnimaleCompanie[5]=pac6;
vectorProduseAnimaleCompanie[6]=pac7;
vectorProduseAnimaleCompanie[7]=pac8;
vectorProduseAnimaleCompanie[8]=pac9;
vectorProduseAnimaleCompanie[9]=pac10;
listaProduseAnimaleCompanie=new ArrayList<ProduseAnimaleCompanie>();
listaProduseAnimaleCompanie.add(pac1);
listaProduseAnimaleCompanie.add(pac2);
listaProduseAnimaleCompanie.add(pac3);
listaProduseAnimaleCompanie.add(pac4);
listaProduseAnimaleCompanie.add(pac5);
listaProduseAnimaleCompanie.add(pac6);
listaProduseAnimaleCompanie.add(pac7);
listaProduseAnimaleCompanie.add(pac8);
listaProduseAnimaleCompanie.add(pac9);
listaProduseAnimaleCompanie.add(pac10);

ProduseIgiena pig1,pig2,pig3,pig4,pig5,pig6,pig7,pig8,pig9,pig10;
pig1=new ProduseIgiena(true,"pisica","Elmex","Fortan",19.9f,"senior","solutie lacrimi",10,"flacon");
pig2=new ProduseIgiena(true,"pisica","Nixodor Felina","Royal",29.9f,"senior","servetele antibacteriene",40,"pachet");
pig3=new ProduseIgiena(true,"caine","Trixie","Nora",13.7f,"junior","solutie pentru curatat ochi",15,"flacon");
pig4=new ProduseIgiena(true,"pisica","Top Care","Luxury",17.3f,"senior","sampon",20,"flacon");
pig5=new ProduseIgiena(true,"pisica","Pet Head Fantastic Spray","Fortan",44.9f,"senior","aparat curatare blana",50,"bucata");
pig6=new ProduseIgiena(true,"pisica","Ever Clean","Cora",30.7f,"junior","degetare curatare ochi",2,"bucata");
pig7=new ProduseIgiena(true,"pisica","Tigerino","Royal",29.8f,"senior","manusa pentru periat",20,"bucata");
pig8=new ProduseIgiena(true,"pisica","Miau Miau","Luxury",34.7f,"senior","scutec absorbant",5,"pachet");
pig9=new ProduseIgiena(true,"caine","Vet's Best","Comod",39.8f,"junior","gel dentar",20,"flacon");
pig10=new ProduseIgiena(true,"pisica","Hygiene Plus","Nora",49.8f,"senior","periute de dinti",2,"bucati");
ProduseIgiena[] vectorProduseIgiena=new ProduseIgiena[10];
vectorProduseIgiena[0]=pig1;
vectorProduseIgiena[1]=pig2;
vectorProduseIgiena[2]=pig3;
vectorProduseIgiena[3]=pig4;
vectorProduseIgiena[4]=pig5;
vectorProduseIgiena[5]=pig6;
vectorProduseIgiena[6]=pig7;
vectorProduseIgiena[7]=pig8;
vectorProduseIgiena[8]=pig9;
vectorProduseIgiena[9]=pig10;
listaProduseIgiena=new ArrayList<ProduseIgiena>();
listaProduseIgiena.add(pig1);
listaProduseIgiena.add(pig2);
listaProduseIgiena.add(pig3);
listaProduseIgiena.add(pig4);
listaProduseIgiena.add(pig5);
listaProduseIgiena.add(pig6);
listaProduseIgiena.add(pig7);
listaProduseIgiena.add(pig8);
listaProduseIgiena.add(pig9);
listaProduseIgiena.add(pig10);

Nisip ns1,ns2,ns3,ns4,ns5,ns6,ns7,ns8,ns9,ns10;
ns1=new Nisip(true,"pisica","Elmex","Fortan",19.9f,"senior","solutie lacrimi",10,"flacon","lavanda",5,"biodegradabil");
ns2=new Nisip(true,"pisica","Nixodor Felina","Royal",29.9f,"senior","servetele antibacteriene",40,"pachet","aloe vera",6,"antibacterian");
ns3=new Nisip(true,"caine","Trixie","Nora",13.7f,"junior","solutie pentru curatat ochi",15,"flacon","parfumat",12,"absorbant");
ns4=new Nisip(true,"pisica","Top Care","Luxury",17.3f,"senior","sampon",20,"flacon","levantica",25,"asternut igienic");
ns5=new Nisip(true,"pisica","Pet Head Fantastic Spray","Fortan",44.9f,"senior","aparat curatare blana",50,"bucata","lavanda",30,"asternut care formeaza bulgari");
ns6=new Nisip(true,"pisica","Ever Clean","Cora",30.7f,"junior","degetare curatare ochi",100,"bucata","iasomie",30,"elimina mirosul");
ns7=new Nisip(true,"pisica","Tigerino","Royal",29.8f,"senior","manusa pentru periat",20,"bucata","aloe vera",8,"asternut absorbant");
ns8=new Nisip(true,"pisica","Miau Miau","Luxury",34.7f,"senior","scutec absorbant",100,"pachet","parfumat",10,"parfum lavanda");
ns9=new Nisip(true,"caine","Vet's Best","Comod",39.8f,"junior","gel dentar",20,"flacon","lavanda",22,"aloe vera");
ns10=new Nisip(true,"pisica","Hygiene Plus","Nora",49.8f,"senior","periute de dinti",15,"tub","levantica",10,"cristale superabsorbante");
Nisip[] vectorNisip=new Nisip[10];
vectorNisip[0]=ns1;
vectorNisip[1]=ns2;
vectorNisip[2]=ns3;
vectorNisip[3]=ns4;
vectorNisip[4]=ns5;
vectorNisip[5]=ns6;
vectorNisip[6]=ns7;
vectorNisip[7]=ns8;
vectorNisip[8]=ns9;
vectorNisip[9]=ns10;
listaNisip=new ArrayList<Nisip>();
listaNisip.add(ns1);
listaNisip.add(ns2);
listaNisip.add(ns3);
listaNisip.add(ns4);
listaNisip.add(ns5);
listaNisip.add(ns6);
listaNisip.add(ns7);
listaNisip.add(ns8);
listaNisip.add(ns9);
listaNisip.add(ns10);
System.out.println("\n");
/*for (int i = 0; i < listaIgProduseAnimaleCompanie.size(); i++) {
            if (listaIgProduseAnimaleCompanie.get(i).pret < 20 && listaIgProduseAnimaleCompanie.get(i).disponibilitate == true) {
                System.out.println(listaIgProduseAnimaleCompanie.get(i));
            }
        }
*/
System.out.println("\n");
for(int n=0;n<listaProduseIgiena.size();n++){
    if(listaProduseIgiena.get(n).nrUtilizari < 10 && listaProduseIgiena.get(n).recipient =="flacon")
        System.out.println(listaProduseIgiena.get(n));
}

System.out.println("\n");
for(int i=0;i<listaNisip.size();i++){
    if(listaNisip.get(i).gramaj < 10 && listaNisip.get(i).asternut =="aloe vera")
        System.out.println(listaNisip.get(i));
}
        //Mirela
         // SUPERCLASA //CONSTR. FARA PARAMETRI
        ProduseAnimaleCompanie A1 = new ProduseAnimaleCompanie();

        //CONSTR. CU PARAMETRI 
        ProduseAnimaleCompanie A2 = new ProduseAnimaleCompanie(false, "pisica", "Jucarie undita cu pene", "ELS PETS", 4.96f, "senior");

        //CONSTR. COPIERE
        ProduseAnimaleCompanie A3 = new ProduseAnimaleCompanie(A2);

        System.out.println("TEST 1 CONSTRUCTORI SUPERCLASA\n\nA1- Constr. fara parametri :\n" + A1 + "\n"
                + "A2- Constr. cu parametri :\n" + A2 + "\n"
                + "A3- Constr. copiere :\n" + A3 + "\n\n");

        //SUBCLASA JUCARII
        //CONSTR. FARA PARAMETRI
        Jucarii B1 = new Jucarii();

        //CONSTR. CU PARAMETRI
        Jucarii B2 = new Jucarii(true, "sferica", 3, false, "pisica", "Jucarie undita cu pene", "ELS PETS", 4.96f, "senior");

        //CONSTR. COPIERE
        Jucarii B3 = new Jucarii(B2);

        System.out.println("TEST 2 CONSTRUCTORI SUBCLASA JUCARII\n\nB1- Constr. fara parametri :\n" + B1 + "\n"
                + "B2- Constr. cu parametri :\n" + B2 + "\n"
                + "B3- Constr. copiere :\n" + B3 + "\n");

        //SUBCLASA CULCUS
        //CONSTR. FARA PARAMETRI
        Culcus C1 = new Culcus();

        //CONSTR. CU PARAMETRI
        Culcus C2 = new Culcus("poliester", "Nu are", false, "Nu are", false, "pisica", "Pat pentru pervaz", "White Dream", 21.90f, "senior");

        //CONSTR. COPIERE
        Culcus C3 = new Culcus(C2);

        System.out.println("TEST 3 CONSTRUCTORI SUBCLASA CULCUS\n\nC1- Constr. fara parametri :\n" + C1 + "\n"
                + "C2- Constr. cu parametri :\n" + C2 + "\n"
                + "C3- Constr. copiere :\n" + C3 + "\n");

        //VECTORI DE OBIECTE
        //zornaitoare, forma, cantitate, disponibilitate, specie, nume, producator, pret, categorie varsta      
        Jucarii J1 = new Jucarii();
        Jucarii J2 = new Jucarii(false, "tunel", 1, true, "hamster", "Tunel din fan", "JD Farm", 17.58f, "pui");
        Jucarii J3 = new Jucarii(false, "soricel", 3, false, "pisica", "soricel de plus cu iarba matei", "Trixie", 22.90f, "adulta");
        Jucarii J4 = new Jucarii(false, "disc", 3, false, "caine", "Frisbee", "ELS PETS", 42.96f, "junior");
        Jucarii J5 = new Jucarii(true, "undita", 1, true, "pisica", "Undita pentru pisici", "ORILAND", 19.90f, "pisoi");
        Jucarii J6 = new Jucarii(false, "roata", 1, false, "hamster", "Roata pentru rozatoare", "Trixie", 37.90f, "adult");
        Jucarii J7 = new Jucarii(true, "lant de inele", 1, true, "pasare", "Clopotel pe un lant", "ORILAND", 4.85f, "adulta");
        Jucarii J8 = new Jucarii(true, "minge", 1, true, "caine", "Minge de tenis", "BEYMAN", 14.90f, "junior");
        Jucarii J9 = new Jucarii(true, "tabla", 1, false, "caine", "Dog Activity FlipBoard", "Trixie", 44.9f, "senior");
        Jucarii J10 = new Jucarii(true, "gaina", 3, true, "caine", "Jucarie gaina din latex pentru caini", "Trixie", 18.90f, "adult");
        
        Jucarii[] J = new Jucarii[] {J1,J2,J3,J4,J5,J6,J7,J8,J9,J10};
        
        listaJucarii = new ArrayList<Jucarii>();
        listaJucarii.add(J1);
        listaJucarii.add(J2);
        listaJucarii.add(J3);
        listaJucarii.add(J4);
        listaJucarii.add(J5);
        listaJucarii.add(J6);
        listaJucarii.add(J7);
        listaJucarii.add(J8);
        listaJucarii.add(J9);
        listaJucarii.add(J10);

        //material, cerinte speciale, asternut, tip asternut, disponibilitate, specie, nume, producator, pret, categorie varsta
        Culcus[] C = new Culcus[10];
        C[0] = new Culcus();
        C[1] = new Culcus("rachita", "nu are", true, "perna captusita", false, "pisica", "Vizuina tip cos", "Trixie", 164.90f, "pisoi");
        C[2] = new Culcus("poliester", "pentru cainii cu boli ale sistemului locomotor", true, "perna captusita", false, "caine", "Pat caini", "hyggelig", 209.90f, "senior");
        C[3] = new Culcus("bumbac", "nu are", true, "pernuta", false, "iepuri", "Casa pentru animale de companie", "ELS PETS", 24.45f, "tanar");
        C[4] = new Culcus("lemn", "nu are", false, "nu are", true, "hamster", "Adapost Pet Rest Arch", "ORILAND", 246f, "adult");
        C[5] = new Culcus("nailon", "nu are", false, "nu are", true, "pisica", "Cort pentru pisici", "Cat camp", 24.90f, "adult");
        C[6] = new Culcus("poliester", "racire", false, "nu are", true, "caine", "Covoras pentru racire", "Premium Paw", 119.90f, "senior");
        C[7] = new Culcus("poliester", "nu are", false, "nu are", true, "pisica", "Pat pentru calorifer", "Luxus", 94.90f, "pisoi");
        C[8] = new Culcus("bumbac", "termic", true, "pernuta", false, "hamster", "Culcus pentru animalute mici", "Trixie", 49.78f, "pui");
        C[9] = new Culcus("lemn", "nu are", false, "nu are", true, "pisica", "Casuta pentru pisici", "Palazzo", 324.90f, "pisoi");

        listaCulcus = new ArrayList<Culcus>();
        listaCulcus.add(C[0]);
        listaCulcus.add(C[1]);
        listaCulcus.add(C[2]);
        listaCulcus.add(C[3]);
        listaCulcus.add(C[4]);
        listaCulcus.add(C[5]);
        listaCulcus.add(C[6]);
        listaCulcus.add(C[7]);
        listaCulcus.add(C[8]);
        listaCulcus.add(C[9]);

        
        
          for(int i=0;i<=9;i++)
        {
            J[i].ConditieJ(J[i]);
        }
          
        System.out.println("\n");
                  
          for(int i=0;i<=9;i++)
        {
            C[i].ConditieC(C[i]);
        }
    }
}
