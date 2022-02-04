/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProduseAnimaleCompanie;



import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

public class FrameProduse extends javax.swing.JFrame {

    /**
     * Creates new form PaneProduse
     */
    Test test;
    //-------------------------TEODORA------------------------------------------
    ArrayList<Cusca> cuscaFromFile = new ArrayList<Cusca>();
    ArrayList<CutieTransport> cutieTransportFromFile = new ArrayList<CutieTransport>();

    String[] vectorMateriale = new String[20];
    String[] vectorProducatori = new String[10];

    //----------------------------NICOLETA--------------------------------------
    String[] vectRol = new String[10];
    String[] vectBeneficii = new String[20];

    //-----------------------------ANDREI---------------------------------------
    ArrayList<HranaUmeda> listaHum = new ArrayList<HranaUmeda>();
    ArrayList<HranaUscata> listaHus = new ArrayList<HranaUscata>();
    DefaultListModel jListModel = new DefaultListModel();
    
    //----------------------------MIRELA----------------------------------------
    String[] vectorMaterial = new String[20];
    String[] vectorForma = new String[20];
    
    //----------------------------VALENTIN--------------------------------------
     String[] vectorProduseIgiena = new String[20];
    ArrayList<ProduseIgiena> ProduseIgienaFromFile = new ArrayList<ProduseIgiena>();
    DefaultListModel jListModelIg = new DefaultListModel();
    
    String[] vectorNisip = new String[20];
    ArrayList<Nisip> NisipFromFile = new ArrayList<Nisip>();
    DefaultListModel jListModelN = new DefaultListModel();

    public FrameProduse() {
        initComponents();
        test = new Test();
        

        //---------------------------NICOLETA-----------------------------------
        for (int j = 0; j < test.listaMedicamente.size(); j++) {
            vectRol[j] = test.listaMedicamente.get(j).rol;
        RoMed.setModel(new DefaultComboBoxModel(vectRol));
        }
        for (int k = 0; k < test.listaSuplimente.size(); k++) {
            vectBeneficii[k] = test.listaSuplimente.get(k).beneficii;
            BenSup.setModel(new DefaultComboBoxModel(vectBeneficii));
        }

        //------------------------ANDREI----------------------------------------
        //writeObjectToFileHum(test.listaHranaUmeda);
        //writeObjectToFileHus(test.listaHranaUscata);
        listaHum = readObjectFromFileHum();
        listaHus = readObjectFromFileHus();
        StringBuffer deAfisatHum = new StringBuffer("");
        for (int i = 0; i < listaHum.size(); i++) {
            deAfisatHum.append(listaHum.get(i));
            jListModel.addElement(listaHum.get(i));
        }
        StringBuffer deAfisatHus = new StringBuffer("");
        for (int i = 0; i < listaHus.size(); i++) {
            deAfisatHus.append(listaHus.get(i));
            jListModel.addElement(listaHus.get(i));
        }

        int lungimeVector = listaHum.size() + listaHus.size();
        String[] vectProducator = new String[lungimeVector + 1];
        String[] vectCategorieVarsta = new String[lungimeVector + 1];
        String[] vectTipAmbalaj = new String[lungimeVector + 1];

        //Definire lista Producator
        int index = 1;
        for (int i = 0; i < lungimeVector / 2; i++) {
            boolean duplicata = false;
            for (int j = 0; j < index; j++) {
                if (listaHum.get(i).numeProducator.equals(vectProducator[j])) {
                    duplicata = true;
                }
            }
            if (duplicata == false) {
                vectProducator[index] = listaHum.get(i).numeProducator;
                index++;
            }
        }
        for (int i = 0; i < lungimeVector / 2; i++) {
            boolean duplicata = false;
            for (int j = 0; j < index; j++) {
                if (listaHus.get(i).numeProducator.equals(vectProducator[j])) {
                    duplicata = true;
                }
            }
            if (duplicata == false) {
                vectProducator[index] = listaHus.get(i).numeProducator;
                index++;
            }
        }
        String[] listaProducator = new String[index];
        for (int i = 1; i <= index - 1; i++) {
            listaProducator[i] = vectProducator[i];
        }

        //Definire lista CategorieVarsta
        index = 1;
        for (int i = 0; i < lungimeVector / 2; i++) {
            boolean duplicata = false;
            for (int j = 0; j < index; j++) {
                if (listaHum.get(i).categorieVarsta.equals(vectCategorieVarsta[j])) {
                    duplicata = true;
                }
            }
            if (duplicata == false) {
                vectCategorieVarsta[index] = listaHum.get(i).categorieVarsta;
                index++;
            }
        }
        for (int i = 0; i < lungimeVector / 2; i++) {
            boolean duplicata = false;
            for (int j = 0; j < index; j++) {
                if (listaHus.get(i).categorieVarsta.equals(vectCategorieVarsta[j])) {
                    duplicata = true;
                }
            }
            if (duplicata == false) {
                vectCategorieVarsta[index] = listaHus.get(i).categorieVarsta;
                index++;
            }
        }
        String[] listaCategorieVarsta = new String[index];
        for (int i = 1; i <= index - 1; i++) {
            listaCategorieVarsta[i] = vectCategorieVarsta[i];
        }

        //Definire lista TipAmbalaj
        index = 1;
        for (int i = 0; i < lungimeVector / 2; i++) {
            boolean duplicata = false;
            for (int j = 0; j < index; j++) {
                if (listaHum.get(i).tipAmbalaj.equals(vectTipAmbalaj[j])) {
                    duplicata = true;
                }
            }
            if (duplicata == false) {
                vectTipAmbalaj[index] = listaHum.get(i).tipAmbalaj;
                index++;
            }
        }
        for (int i = 0; i < lungimeVector / 2; i++) {
            boolean duplicata = false;
            for (int j = 0; j < index; j++) {
                if (listaHus.get(i).tipAmbalaj.equals(vectTipAmbalaj[j])) {
                    duplicata = true;
                }
            }
            if (duplicata == false) {
                vectTipAmbalaj[index] = listaHus.get(i).tipAmbalaj;
                index++;
            }
        }
        String[] listaTipAmbalaj = new String[index];
        for (int i = 1; i <= index - 1; i++) {
            listaTipAmbalaj[i] = vectTipAmbalaj[i];
        }

        StringBuilder afisat = new StringBuilder("");
        afisat.append("Rezultatele vor fi afisate aici\n");
        if (listaHum.isEmpty()) {
            afisat.append("(HranaUmeda.txt not found)\n");
        }
        if (listaHus.isEmpty()) {
            afisat.append("(HranaUscata.txt not found)\n");
        }
        jTextAreaRezultate.setText(afisat.toString().trim());

        listaProducator[0] = "Toate";
        listaCategorieVarsta[0] = "Toate";
        listaTipAmbalaj[0] = "Toate";
        jComboBoxProducator.setModel(new javax.swing.DefaultComboBoxModel(listaProducator));
        jComboBoxCategorieVarsta.setModel(new javax.swing.DefaultComboBoxModel(listaCategorieVarsta));
        jComboBoxTipMancare.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Toate", "Hrana Umeda", "Hrana Uscata"}));
        jComboBoxTipAmbalaj.setModel(new javax.swing.DefaultComboBoxModel(listaTipAmbalaj));

        ActionListener l = ae -> {
            jButtonCautare.doClick();
        };
        jTextFieldPretMin.addActionListener(l);
        jTextFieldPretMax.addActionListener(l);
        jTextFieldGramajMin.addActionListener(l);
        jTextFieldGramajMax.addActionListener(l);
        
        //----------------------------MIRELA----------------------------------------
        for(int i = 0;i< test.listaCulcus.size();i++){
            vectorMaterial[i]=test.listaCulcus.get(i).material;
        }
        
        ComboBoxC.setModel(new DefaultComboBoxModel<>(vectorMaterial));
        
        for(int i = 0;i< test.listaJucarii.size();i++){
            vectorForma[i]=test.listaJucarii.get(i).forma;
        }
        
        ComboBoxJ.setModel(new DefaultComboBoxModel<>(vectorForma));
        
        //---------------------------VALENTIN-------------------------------------
        vectorProduseIgiena[0] = "Toate";
        for (int i = 1; i < test.listaProduseIgiena.size() + 1; i++) {
            vectorProduseIgiena[i] = test.listaProduseIgiena.get(i - 1).tip;
            jComboBox1Ig.setModel(new DefaultComboBoxModel(vectorProduseIgiena));
        }
        for (int i = 1; i < test.listaProduseIgiena.size() + 1; i++) {
            vectorProduseIgiena[i] = test.listaProduseIgiena.get(i - 1).recipient;
            jComboBox2Ig.setModel(new DefaultComboBoxModel(vectorProduseIgiena));
        }

        //writeObjectToFileIg(test.listaProduseIgiena);
        ProduseIgienaFromFile = readObjectFromFileIg();
        StringBuffer deAfisat = new StringBuffer("");
        for (int i = 0; i < ProduseIgienaFromFile.size(); i++) {
            deAfisat.append(ProduseIgienaFromFile.get(i));
            deAfisat.append('\n');
            jListModelIg.addElement(ProduseIgienaFromFile.get(i).tip + ProduseIgienaFromFile.get(i).recipient);
        }
        jTextArea1Ig.setText(deAfisat.toString());
        
         
        vectorNisip[0] = "Toate";
        for (int i = 1; i < test.listaNisip.size() + 1; i++) {
            vectorNisip[i] = test.listaNisip.get(i - 1).parfum;
            jComboBox1N.setModel(new DefaultComboBoxModel(vectorNisip));
        }
        for (int i = 1; i < test.listaNisip.size() + 1; i++) {
            vectorNisip[i] = test.listaNisip.get(i - 1).asternut;
            jComboBox2N.setModel(new DefaultComboBoxModel(vectorNisip));
        }
        
        //writeObjectToFileNisip(test.listaNisip);
        NisipFromFile = readObjectFromFileNisip();
        StringBuffer deAfisatNisip = new StringBuffer("");
        for (int i = 0; i < NisipFromFile.size(); i++) {
            deAfisatNisip.append(NisipFromFile.get(i));
            deAfisatNisip.append('\n');
            jListModelN.addElement(NisipFromFile.get(i).parfum + NisipFromFile.get(i).asternut);
        }
        jTextArea1N.setText(deAfisatNisip.toString());
        
        //-------------------------TEODORA---------------------------------------
        for (int i = 0; i < test.listaCusti.size(); i++) {
            vectorMateriale[i] = test.listaCusti.get(i).getMaterial();
        }
        //jComboBox1.setModel(new DefaultComboBoxModel(vectorMateriale));
        
        //writeObjectCuscaToFile(test.listaCusti);
        //writeObjectCutieToFile(test.listaCutii);
        cuscaFromFile=readObjectCuscaFromFile();
        cutieTransportFromFile=readObjectCutieFromFile();
        
        StringBuffer afisatCusti = new StringBuffer("");
        for(int i=0;i<cuscaFromFile.size();i++){
            afisatCusti.append(cuscaFromFile.get(i));
            afisatCusti.append("\n\t\t\t\t"+cuscaFromFile.get(i).getPret()+"RON");
        }
        jTextAreaCusti.setText(afisatCusti.toString());
        
        
        StringBuffer afisatCutii = new StringBuffer("");
        for(int i=0;i<cutieTransportFromFile.size();i++){
            afisatCutii.append(cutieTransportFromFile.get(i));
            afisatCutii.append("\n\t\t\t\t"+cutieTransportFromFile.get(i).getPret()+"RON");
        }
        jTextAreaCutiiTransport.setText(afisatCutii.toString());
        
        vectorProducatori[0] = "Toti Producatorii";
        for (int i = 1; i < test.listaCutii.size(); i++) {
            vectorProducatori[i] = test.listaCutii.get(i).getNumeProducator();
        }
        jComboBoxProducatori.setModel(new DefaultComboBoxModel(vectorProducatori));
        

    }
    
    public static void writeObjectCuscaToFile(ArrayList<Cusca> listaCusti) {

        try {
            FileOutputStream fileOut = new FileOutputStream(new File("Custi.txt"));
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(listaCusti);
            objectOut.close();
            fileOut.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Exceptie " + ex);
        }
    }

    public static ArrayList<Cusca> readObjectCuscaFromFile() {
        ArrayList<Cusca> listaCusti = new ArrayList<Cusca>();
        try {
            FileInputStream fileIn = new FileInputStream(new File("Custi.txt"));
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            listaCusti = (ArrayList<Cusca>) objectIn.readObject();
            objectIn.close();
            fileIn.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Exceptie " + ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listaCusti;
    }
    //----------------------------CUTII TRANSPORT-------------------------------
    public static void writeObjectCutieToFile(ArrayList<CutieTransport> listaCutii) {

        try {
            FileOutputStream fileOut = new FileOutputStream(new File("Cutii.txt"));
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(listaCutii);
            objectOut.close();
            fileOut.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Exceptie " + ex);
        }
    }

    public static ArrayList<CutieTransport> readObjectCutieFromFile() {
        ArrayList<CutieTransport> listaCutii = new ArrayList<CutieTransport>();
        try {
            FileInputStream fileIn = new FileInputStream(new File("Cutii.txt"));
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            listaCutii = (ArrayList<CutieTransport>) objectIn.readObject();
            objectIn.close();
            fileIn.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Exceptie " + ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listaCutii;
    }
    //--------------------------VALENTIN----------------------------------------
     public static void writeObjectToFileIg(ArrayList<ProduseIgiena> listaProduseIgiena) {

        try {
            FileOutputStream fileOut = new FileOutputStream(new File("ProduseIgiena.txt"));
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(listaProduseIgiena);
            objectOut.close();
            fileOut.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Exceptie " + ex);
        }
    }

    public static ArrayList<ProduseIgiena> readObjectFromFileIg() {
        ArrayList<ProduseIgiena> listaProduseIgiena = new ArrayList<ProduseIgiena>();
        try {
            FileInputStream fileIn = new FileInputStream(new File("ProduseIgiena.txt"));
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            listaProduseIgiena = (ArrayList<ProduseIgiena>) objectIn.readObject();
            objectIn.close();
            fileIn.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Exceptie " + ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listaProduseIgiena;
    }
    
    public static void writeObjectToFileNisip(ArrayList<Nisip> listaNisip) {

        try {
            FileOutputStream fileOut = new FileOutputStream(new File("Nisip.txt"));
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(listaNisip);
            objectOut.close();
            fileOut.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Exceptie " + ex);
        }
    }

    public static ArrayList<Nisip> readObjectFromFileNisip() {
        ArrayList<Nisip> listaNisip = new ArrayList<Nisip>();
        try {
            FileInputStream fileIn = new FileInputStream(new File("Nisip.txt"));
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            listaNisip = (ArrayList<Nisip>) objectIn.readObject();
            objectIn.close();
            fileIn.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Exceptie " + ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listaNisip;
    }
    //--------------------------ANDREI--------------------------------------------
    public static void writeObjectToFileHum(ArrayList<HranaUmeda> listaHum) {
        try {
            FileOutputStream fileOut = new FileOutputStream(new File("HranaUmeda.txt"));
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(listaHum);
            objectOut.close();
            fileOut.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Exceptie " + ex);
        }
    }

    public static void writeObjectToFileHus(ArrayList<HranaUscata> listaHus) {
        try {
            FileOutputStream fileOut = new FileOutputStream(new File("HranaUscata.txt"));
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(listaHus);
            objectOut.close();
            fileOut.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Exceptie " + ex);
        }
    }

    public static ArrayList<HranaUmeda> readObjectFromFileHum() {
        ArrayList<HranaUmeda> listaHum = new ArrayList<HranaUmeda>();
        try {
            FileInputStream fileIn = new FileInputStream(new File("HranaUmeda.txt"));
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            listaHum = (ArrayList<HranaUmeda>) objectIn.readObject();
            objectIn.close();
            fileIn.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Exceptie " + ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listaHum;
    }

    public static ArrayList<HranaUscata> readObjectFromFileHus() {
        ArrayList<HranaUscata> listaHus = new ArrayList<HranaUscata>();
        try {
            FileInputStream fileIn = new FileInputStream(new File("HranaUscata.txt"));
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            listaHus = (ArrayList<HranaUscata>) objectIn.readObject();
            objectIn.close();
            fileIn.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Exceptie " + ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listaHus;
    }

    
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        MainPane = new javax.swing.JPanel();
        MenuPanel = new javax.swing.JPanel();
        jLabelMeniu = new javax.swing.JLabel();
        labelHrana = new javax.swing.JLabel();
        labelJucarii = new javax.swing.JLabel();
        jLabelCusti = new javax.swing.JLabel();
        jLabelCutiiTransport = new javax.swing.JLabel();
        jLabelProduseIgiena = new javax.swing.JLabel();
        jLabelMedicamente = new javax.swing.JLabel();
        jLabelSuplimente = new javax.swing.JLabel();
        jLabelCulcus = new javax.swing.JLabel();
        jLabelNisip = new javax.swing.JLabel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        Welcome = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        CutiiTransport = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldGreutateAnimal = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaCutiiTransport = new javax.swing.JTextArea();
        jLabelRecomandare = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabelPliabil = new javax.swing.JLabel();
        jComboBoxProducatori = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        ProduseIgiena = new javax.swing.JPanel();
        jLabelIg1 = new javax.swing.JLabel();
        jComboBox1Ig = new javax.swing.JComboBox<>();
        jLabelIg2 = new javax.swing.JLabel();
        jTextField1Ig = new javax.swing.JTextField();
        jTextField2Ig = new javax.swing.JTextField();
        jLabelIg3 = new javax.swing.JLabel();
        jComboBox2Ig = new javax.swing.JComboBox<>();
        jButton1Ig = new javax.swing.JButton();
        jScrollPane1Ig = new javax.swing.JScrollPane();
        jTextArea1Ig = new javax.swing.JTextArea();
        jScrollPane2Ig = new javax.swing.JScrollPane();
        jList1Ig = new javax.swing.JList<>();
        Custi = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        CheckCaine = new javax.swing.JCheckBox();
        CheckPisica = new javax.swing.JCheckBox();
        CheckToate = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaCusti = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxMateriale = new javax.swing.JComboBox<>();
        ButonCautare = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxCuloare = new javax.swing.JComboBox<>();
        jSlider1 = new javax.swing.JSlider();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSlider2 = new javax.swing.JSlider();
        jLabel11 = new javax.swing.JLabel();
        Hrana = new javax.swing.JPanel();
        textInstructiune = new javax.swing.JLabel();
        textProducator = new javax.swing.JLabel();
        jComboBoxProducator = new javax.swing.JComboBox<>();
        textPret = new javax.swing.JLabel();
        jTextFieldPretMin = new javax.swing.JTextField();
        jTextFieldPretMax = new javax.swing.JTextField();
        textDividerPret = new javax.swing.JLabel();
        textCategorieVarsta = new javax.swing.JLabel();
        jComboBoxCategorieVarsta = new javax.swing.JComboBox<>();
        textTipMancare = new javax.swing.JLabel();
        jComboBoxTipMancare = new javax.swing.JComboBox<>();
        textTipAmbalaj = new javax.swing.JLabel();
        jComboBoxTipAmbalaj = new javax.swing.JComboBox<>();
        textGramaj = new javax.swing.JLabel();
        jTextFieldGramajMin = new javax.swing.JTextField();
        jTextFieldGramajMax = new javax.swing.JTextField();
        textDividerGramaj = new javax.swing.JLabel();
        textRezultate = new javax.swing.JLabel();
        jButtonCautare = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaRezultate = new javax.swing.JTextArea();
        jLabelPretLei = new javax.swing.JLabel();
        jLabelGramajGrame = new javax.swing.JLabel();
        Nisip = new javax.swing.JPanel();
        jLabelN1 = new javax.swing.JLabel();
        jLabelN2 = new javax.swing.JLabel();
        jComboBox1N = new javax.swing.JComboBox<>();
        jTextField1N = new javax.swing.JTextField();
        jTextField2N = new javax.swing.JTextField();
        jLabelN3 = new javax.swing.JLabel();
        jComboBox2N = new javax.swing.JComboBox<>();
        jButton1N = new javax.swing.JButton();
        jScrollPane1N = new javax.swing.JScrollPane();
        jTextArea1N = new javax.swing.JTextArea();
        jScrollPane2N = new javax.swing.JScrollPane();
        jList1N = new javax.swing.JList<>();
        PanelC = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TextAreaC = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        MiniPanelC = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        CheckCSC = new javax.swing.JCheckBox();
        ComboBoxC = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        CheckAsternut = new javax.swing.JCheckBox();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        MiniPanelPAC = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        ButonPisiciC = new javax.swing.JRadioButton();
        ButonCainiC = new javax.swing.JRadioButton();
        ButonHamsteriC = new javax.swing.JRadioButton();
        ButonIepuriC = new javax.swing.JRadioButton();
        jLabel18 = new javax.swing.JLabel();
        SliderC = new javax.swing.JSlider();
        ButonDispC = new javax.swing.JButton();
        PretC = new javax.swing.JTextField();
        PanelJ = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane5 = new javax.swing.JScrollPane();
        TextAreaJ = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        MiniPanelPAC1 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        ButonPisiciJ = new javax.swing.JRadioButton();
        ButonCainiJ = new javax.swing.JRadioButton();
        ButonHamsteriJ = new javax.swing.JRadioButton();
        ButonIepuriJ = new javax.swing.JRadioButton();
        jLabel21 = new javax.swing.JLabel();
        PretJ = new javax.swing.JTextField();
        SliderJ = new javax.swing.JSlider();
        ButonDispJ = new javax.swing.JButton();
        MiniPanelC1 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        CheckZornaitoare = new javax.swing.JCheckBox();
        ComboBoxJ = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        PanSup = new javax.swing.JPanel();
        PretMinSup = new javax.swing.JTextField();
        PretSup = new javax.swing.JLabel();
        PretMaxSup = new javax.swing.JTextField();
        BeneficiiSup = new javax.swing.JLabel();
        BenSup = new javax.swing.JComboBox<>();
        CautaSup = new javax.swing.JButton();
        PrescriptieSup = new javax.swing.JRadioButton();
        PreSup = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        TextSup = new javax.swing.JTextArea();
        Medicamente = new javax.swing.JPanel();
        PretMed = new javax.swing.JLabel();
        RolMed = new javax.swing.JLabel();
        PerMed = new javax.swing.JLabel();
        PretMinMed = new javax.swing.JTextField();
        PretMaxMed = new javax.swing.JTextField();
        RoMed = new javax.swing.JComboBox<>();
        PerioadaMed = new javax.swing.JRadioButton();
        CautaMed = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        TextMed = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Produse Animale Companie");
        setBackground(new java.awt.Color(204, 204, 255));

        MainPane.setBackground(new java.awt.Color(204, 204, 255));
        MainPane.setForeground(new java.awt.Color(255, 255, 255));
        MainPane.setAutoscrolls(true);
        MainPane.setName("Main Pane"); // NOI18N
        MainPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MenuPanel.setBackground(new java.awt.Color(255, 255, 255));
        MenuPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MenuPanel.setAutoscrolls(true);
        MenuPanel.setFocusable(false);

        jLabelMeniu.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMeniu.setFont(new java.awt.Font("Harrington", 3, 24)); // NOI18N
        jLabelMeniu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProduseAnimaleCompanie/PetsIcon.PNG"))); // NOI18N
        jLabelMeniu.setText("MENIU");
        jLabelMeniu.setAutoscrolls(true);
        jLabelMeniu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMeniu.setName("Meniu"); // NOI18N
        jLabelMeniu.setOpaque(true);
        jLabelMeniu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMeniuMouseClicked(evt);
            }
        });

        labelHrana.setFont(new java.awt.Font("Harrington", 3, 18)); // NOI18N
        labelHrana.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelHrana.setText("Hrana");
        labelHrana.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelHrana.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelHranaMouseClicked(evt);
            }
        });

        labelJucarii.setFont(new java.awt.Font("Harrington", 3, 18)); // NOI18N
        labelJucarii.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelJucarii.setText("Jucarii");
        labelJucarii.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelJucarii.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelJucariiMouseClicked(evt);
            }
        });

        jLabelCusti.setFont(new java.awt.Font("Harrington", 3, 18)); // NOI18N
        jLabelCusti.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCusti.setText("Custi");
        jLabelCusti.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelCusti.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCustiMouseClicked(evt);
            }
        });

        jLabelCutiiTransport.setFont(new java.awt.Font("Harrington", 3, 18)); // NOI18N
        jLabelCutiiTransport.setText("Cutii de Transport");
        jLabelCutiiTransport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelCutiiTransport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCutiiTransportMouseClicked(evt);
            }
        });

        jLabelProduseIgiena.setFont(new java.awt.Font("Harrington", 3, 18)); // NOI18N
        jLabelProduseIgiena.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProduseIgiena.setText("Produse Igiena");
        jLabelProduseIgiena.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelProduseIgiena.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProduseIgienaMouseClicked(evt);
            }
        });

        jLabelMedicamente.setFont(new java.awt.Font("Harrington", 3, 18)); // NOI18N
        jLabelMedicamente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMedicamente.setText("Medicamente");
        jLabelMedicamente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMedicamente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMedicamenteMouseClicked(evt);
            }
        });

        jLabelSuplimente.setFont(new java.awt.Font("Harrington", 3, 18)); // NOI18N
        jLabelSuplimente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSuplimente.setText("Suplimente");
        jLabelSuplimente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSuplimente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSuplimenteMouseClicked(evt);
            }
        });

        jLabelCulcus.setFont(new java.awt.Font("Harrington", 3, 18)); // NOI18N
        jLabelCulcus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCulcus.setText("Culcus");
        jLabelCulcus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelCulcus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCulcusMouseClicked(evt);
            }
        });

        jLabelNisip.setFont(new java.awt.Font("Harrington", 3, 18)); // NOI18N
        jLabelNisip.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNisip.setText("Nisip");
        jLabelNisip.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNisip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNisipMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout MenuPanelLayout = new javax.swing.GroupLayout(MenuPanel);
        MenuPanel.setLayout(MenuPanelLayout);
        MenuPanelLayout.setHorizontalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanelLayout.createSequentialGroup()
                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelSuplimente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, MenuPanelLayout.createSequentialGroup()
                        .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelJucarii, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabelMeniu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelCusti, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, MenuPanelLayout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(jLabelProduseIgiena, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabelMedicamente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabelCulcus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelNisip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(491, 491, 491))
            .addGroup(MenuPanelLayout.createSequentialGroup()
                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelHrana, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                    .addComponent(jLabelCutiiTransport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        MenuPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabelCusti, jLabelCutiiTransport, jLabelMedicamente, labelHrana, labelJucarii});

        MenuPanelLayout.setVerticalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanelLayout.createSequentialGroup()
                .addComponent(jLabelMeniu, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCusti, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelHrana, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCutiiTransport, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelProduseIgiena, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelJucarii)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelMedicamente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelSuplimente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCulcus, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelNisip, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        MenuPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabelCusti, jLabelCutiiTransport, jLabelMedicamente, labelHrana, labelJucarii});

        MainPane.add(MenuPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 170, 450));

        jTabbedPane4.setBackground(new java.awt.Color(204, 204, 255));
        jTabbedPane4.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane4.setAutoscrolls(true);
        jTabbedPane4.setName("Welcome"); // NOI18N
        jTabbedPane4.setOpaque(true);

        Welcome.setBackground(new java.awt.Color(204, 204, 255));
        Welcome.setAutoscrolls(true);
        Welcome.setFocusable(false);

        jLabel1.setFont(new java.awt.Font("Harrington", 3, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setLabelFor(Welcome);
        jLabel1.setText("Bun venit!");
        jLabel1.setAutoscrolls(true);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProduseAnimaleCompanie/CateiWelcome.PNG"))); // NOI18N
        jLabel6.setToolTipText("");
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel6.setAutoscrolls(true);
        jLabel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel6.setOpaque(true);

        javax.swing.GroupLayout WelcomeLayout = new javax.swing.GroupLayout(Welcome);
        Welcome.setLayout(WelcomeLayout);
        WelcomeLayout.setHorizontalGroup(
            WelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WelcomeLayout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WelcomeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        WelcomeLayout.setVerticalGroup(
            WelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WelcomeLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jTabbedPane4.addTab("Welcome", Welcome);

        CutiiTransport.setBackground(new java.awt.Color(204, 204, 255));
        CutiiTransport.setAutoscrolls(true);
        CutiiTransport.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Harrington", 1, 14)); // NOI18N
        jLabel5.setText("Introduceti greutatea animalului:");
        CutiiTransport.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 240, 20));

        jTextFieldGreutateAnimal.setText("0.0");
        jTextFieldGreutateAnimal.setToolTipText("");
        CutiiTransport.add(jTextFieldGreutateAnimal, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 50, -1));

        jScrollPane3.setAutoscrolls(true);

        jTextAreaCutiiTransport.setColumns(20);
        jTextAreaCutiiTransport.setRows(5);
        jScrollPane3.setViewportView(jTextAreaCutiiTransport);

        CutiiTransport.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 500, 280));

        jLabelRecomandare.setFont(new java.awt.Font("Harrington", 1, 14)); // NOI18N
        jLabelRecomandare.setText("Recomandarea noastra:");
        CutiiTransport.add(jLabelRecomandare, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 150, -1, 20));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Harrington", 1, 14)); // NOI18N
        jButton1.setText("Cauta");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        CutiiTransport.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, -1, -1));
        CutiiTransport.add(jLabelPliabil, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 200, 20));

        jComboBoxProducatori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxProducatori.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CutiiTransport.add(jComboBoxProducatori, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 140, -1));

        jLabel10.setFont(new java.awt.Font("Harrington", 1, 14)); // NOI18N
        jLabel10.setLabelFor(jComboBoxProducatori);
        jLabel10.setText("Cauta dupa producator:");
        CutiiTransport.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 200, -1));

        jRadioButton1.setBackground(new java.awt.Color(204, 204, 255));
        jRadioButton1.setFont(new java.awt.Font("Harrington", 1, 14)); // NOI18N
        jRadioButton1.setText("Pliabil");
        jRadioButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        CutiiTransport.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel7.setFont(new java.awt.Font("Harrington", 1, 14)); // NOI18N
        jLabel7.setText("KG");
        CutiiTransport.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, 30));

        jTabbedPane4.addTab("Cutii Transport", CutiiTransport);

        ProduseIgiena.setBackground(new java.awt.Color(204, 204, 255));

        jLabelIg1.setText("tip");

        jComboBox1Ig.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabelIg2.setText("nrUtilizari");

        jTextField1Ig.setText("1");

        jTextField2Ig.setText("50");

        jLabelIg3.setText("recipient");

        jComboBox2Ig.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1Ig.setText("Cauta");
        jButton1Ig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1IgActionPerformed(evt);
            }
        });

        jTextArea1Ig.setColumns(20);
        jTextArea1Ig.setRows(5);
        jScrollPane1Ig.setViewportView(jTextArea1Ig);

        jList1Ig.setModel(jListModelIg);
        jScrollPane2Ig.setViewportView(jList1Ig);

        javax.swing.GroupLayout ProduseIgienaLayout = new javax.swing.GroupLayout(ProduseIgiena);
        ProduseIgiena.setLayout(ProduseIgienaLayout);
        ProduseIgienaLayout.setHorizontalGroup(
            ProduseIgienaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProduseIgienaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ProduseIgienaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1Ig)
                    .addGroup(ProduseIgienaLayout.createSequentialGroup()
                        .addComponent(jLabelIg1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1Ig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1Ig))
                    .addGroup(ProduseIgienaLayout.createSequentialGroup()
                        .addGroup(ProduseIgienaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ProduseIgienaLayout.createSequentialGroup()
                                .addComponent(jLabelIg2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1Ig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2Ig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ProduseIgienaLayout.createSequentialGroup()
                                .addComponent(jLabelIg3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox2Ig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2Ig, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE))
                .addContainerGap())
        );
        ProduseIgienaLayout.setVerticalGroup(
            ProduseIgienaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProduseIgienaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ProduseIgienaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelIg1)
                    .addComponent(jComboBox1Ig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1Ig))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProduseIgienaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1Ig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelIg2)
                    .addComponent(jTextField2Ig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProduseIgienaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelIg3)
                    .addComponent(jComboBox2Ig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1Ig, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2Ig, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane4.addTab("tab5", ProduseIgiena);

        Custi.setBackground(new java.awt.Color(204, 204, 255));
        Custi.setAutoscrolls(true);
        Custi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(204, 204, 255));
        jLabel3.setFont(new java.awt.Font("Harrington", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Selecteaza tipul animalului");
        jLabel3.setOpaque(true);
        Custi.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 210, 30));

        CheckCaine.setBackground(new java.awt.Color(204, 204, 255));
        buttonGroup1.add(CheckCaine);
        CheckCaine.setFont(new java.awt.Font("Harrington", 1, 14)); // NOI18N
        CheckCaine.setText("Caine");
        CheckCaine.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CheckCaine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckCaineActionPerformed(evt);
            }
        });
        Custi.add(CheckCaine, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, -1));

        CheckPisica.setBackground(new java.awt.Color(204, 204, 255));
        buttonGroup1.add(CheckPisica);
        CheckPisica.setFont(new java.awt.Font("Harrington", 1, 14)); // NOI18N
        CheckPisica.setText("Pisica");
        CheckPisica.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CheckPisica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckPisicaActionPerformed(evt);
            }
        });
        Custi.add(CheckPisica, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, -1));

        CheckToate.setBackground(new java.awt.Color(204, 204, 255));
        buttonGroup1.add(CheckToate);
        CheckToate.setFont(new java.awt.Font("Harrington", 1, 14)); // NOI18N
        CheckToate.setSelected(true);
        CheckToate.setText("Toate");
        CheckToate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CheckToate.setName("Toate"); // NOI18N
        CheckToate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckToateActionPerformed(evt);
            }
        });
        Custi.add(CheckToate, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, -1));

        jTextAreaCusti.setColumns(20);
        jTextAreaCusti.setRows(5);
        jScrollPane1.setViewportView(jTextAreaCusti);

        Custi.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 500, 280));

        jLabel2.setFont(new java.awt.Font("Harrington", 1, 14)); // NOI18N
        jLabel2.setLabelFor(jComboBoxMateriale);
        jLabel2.setText("Cauta dupa material:");
        Custi.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 190, 20));

        jComboBoxMateriale.setFont(new java.awt.Font("Harrington", 1, 14)); // NOI18N
        jComboBoxMateriale.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Toate materialele", "Lemn", "Rachita", "Plastic", "PVC", "Carton" }));
        jComboBoxMateriale.setSelectedIndex(0);
        jComboBoxMateriale.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Custi.add(jComboBoxMateriale, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 140, 20));

        ButonCautare.setBackground(new java.awt.Color(255, 255, 255));
        ButonCautare.setFont(new java.awt.Font("Harrington", 1, 14)); // NOI18N
        ButonCautare.setText("Cauta");
        ButonCautare.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButonCautare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButonCautareActionPerformed(evt);
            }
        });
        Custi.add(ButonCautare, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, -1, -1));

        jLabel8.setFont(new java.awt.Font("Harrington", 1, 14)); // NOI18N
        jLabel8.setLabelFor(jComboBoxCuloare);
        jLabel8.setText("Cauta dupa culoare:");
        Custi.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jComboBoxCuloare.setFont(new java.awt.Font("Harrington", 1, 14)); // NOI18N
        jComboBoxCuloare.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Toate culorile", "Alb", "Verde", "Galben", "Negru", "Gri", "Gri Inchis", "Rosu", "Albastru" }));
        jComboBoxCuloare.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Custi.add(jComboBoxCuloare, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 140, 20));

        jSlider1.setFont(new java.awt.Font("Harrington", 1, 10)); // NOI18N
        jSlider1.setMajorTickSpacing(5);
        jSlider1.setMaximum(20);
        jSlider1.setMinorTickSpacing(1);
        jSlider1.setPaintLabels(true);
        jSlider1.setSnapToTicks(true);
        jSlider1.setToolTipText("1");
        jSlider1.setValue(0);
        jSlider1.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });
        Custi.add(jSlider1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 180, 30));

        jLabel4.setFont(new java.awt.Font("Harrington", 1, 14)); // NOI18N
        jLabel4.setLabelFor(jSlider1);
        jLabel4.setText("Cauta dupa varsta animalului:");
        Custi.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, -1, -1));

        jLabel9.setBackground(new java.awt.Color(204, 204, 255));
        jLabel9.setFont(new java.awt.Font("Harrington", 1, 14)); // NOI18N
        jLabel9.setLabelFor(jSlider1);
        jLabel9.setOpaque(true);
        Custi.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 90, 20));

        jSlider2.setFont(new java.awt.Font("Harrington", 1, 10)); // NOI18N
        jSlider2.setMajorTickSpacing(3);
        jSlider2.setMaximum(12);
        jSlider2.setMinorTickSpacing(1);
        jSlider2.setPaintLabels(true);
        jSlider2.setSnapToTicks(true);
        jSlider2.setToolTipText("1");
        jSlider2.setValue(0);
        jSlider2.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jSlider2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider2StateChanged(evt);
            }
        });
        Custi.add(jSlider2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 180, 30));

        jLabel11.setBackground(new java.awt.Color(204, 204, 255));
        jLabel11.setFont(new java.awt.Font("Harrington", 1, 14)); // NOI18N
        jLabel11.setLabelFor(jSlider1);
        jLabel11.setOpaque(true);
        Custi.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 90, 20));

        jTabbedPane4.addTab("Custi", Custi);

        Hrana.setBackground(new java.awt.Color(204, 204, 255));

        textInstructiune.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textInstructiune.setText("Introduceti conditiile de cautare:");

        textProducator.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textProducator.setText("Producator:");

        jComboBoxProducator.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Toate", "Whiskas", "Felix", "Brit Premium", "Royal Canin", "Gourmet", "Friskies", "Kirby Cat", "Purina One", "Advance" }));

        textPret.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textPret.setText("Pret:");

        jTextFieldPretMin.setText("13.7");
        jTextFieldPretMin.setToolTipText("Pret minim");

        jTextFieldPretMax.setText("139");
        jTextFieldPretMax.setToolTipText("Pret maxim");

        textDividerPret.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textDividerPret.setText("-");

        textCategorieVarsta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textCategorieVarsta.setText("Categorie varsta:");

        jComboBoxCategorieVarsta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Toate", "Senior/Adult", "Adult", "Junior" }));

        textTipMancare.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textTipMancare.setText("Tip mancare:");

        jComboBoxTipMancare.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Toate", "Hrana Umeda", "Hrana Uscata" }));

        textTipAmbalaj.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textTipAmbalaj.setText("Tip ambalaj:");

        jComboBoxTipAmbalaj.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Toate", "Plic", "Conserva", "Sac" }));

        textGramaj.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textGramaj.setText("Gramaj:");

        jTextFieldGramajMin.setText("510");
        jTextFieldGramajMin.setToolTipText("Gramaj minim");
        jTextFieldGramajMin.setMinimumSize(new java.awt.Dimension(60, 22));
        jTextFieldGramajMin.setPreferredSize(new java.awt.Dimension(60, 22));

        jTextFieldGramajMax.setText("14000");
        jTextFieldGramajMax.setToolTipText("Gramaj maxim");

        textDividerGramaj.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textDividerGramaj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textDividerGramaj.setText("-");

        textRezultate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textRezultate.setText("Rezultate cautare:");

        jButtonCautare.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonCautare.setText("Cautare");
        jButtonCautare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCautareActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jTextAreaRezultate.setEditable(false);
        jTextAreaRezultate.setColumns(20);
        jTextAreaRezultate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextAreaRezultate.setLineWrap(true);
        jTextAreaRezultate.setRows(5);
        jTextAreaRezultate.setText("Rezultatele vor fi afisate aici");
        jScrollPane2.setViewportView(jTextAreaRezultate);

        jLabelPretLei.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelPretLei.setText("lei");

        jLabelGramajGrame.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelGramajGrame.setText("g");

        javax.swing.GroupLayout HranaLayout = new javax.swing.GroupLayout(Hrana);
        Hrana.setLayout(HranaLayout);
        HranaLayout.setHorizontalGroup(
            HranaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HranaLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(HranaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonCautare)
                    .addComponent(textInstructiune)
                    .addGroup(HranaLayout.createSequentialGroup()
                        .addGroup(HranaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textCategorieVarsta)
                            .addComponent(textPret, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textProducator, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(HranaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, HranaLayout.createSequentialGroup()
                                .addComponent(jTextFieldPretMin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textDividerPret)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldPretMax, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelPretLei))
                            .addComponent(jComboBoxProducator, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxCategorieVarsta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(HranaLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(HranaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textTipAmbalaj)
                            .addComponent(textTipMancare)
                            .addComponent(textGramaj))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(HranaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HranaLayout.createSequentialGroup()
                                .addComponent(jTextFieldGramajMin, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textDividerGramaj, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldGramajMax, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelGramajGrame))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HranaLayout.createSequentialGroup()
                                .addGroup(HranaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxTipMancare, 0, 137, Short.MAX_VALUE)
                                    .addComponent(jComboBoxTipAmbalaj, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(1, 1, 1)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(HranaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HranaLayout.createSequentialGroup()
                        .addComponent(textRezultate)
                        .addGap(0, 78, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
                .addContainerGap())
        );
        HranaLayout.setVerticalGroup(
            HranaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HranaLayout.createSequentialGroup()
                .addGroup(HranaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, HranaLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(textRezultate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2))
                    .addGroup(HranaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, HranaLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(textInstructiune)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(HranaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textProducator)
                            .addComponent(jComboBoxProducator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(HranaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textPret)
                            .addComponent(textDividerPret)
                            .addComponent(jTextFieldPretMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldPretMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPretLei))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(HranaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textCategorieVarsta)
                            .addComponent(jComboBoxCategorieVarsta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(HranaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textTipMancare)
                            .addComponent(jComboBoxTipMancare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(HranaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textTipAmbalaj)
                            .addComponent(jComboBoxTipAmbalaj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(HranaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textGramaj)
                            .addComponent(jTextFieldGramajMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textDividerGramaj)
                            .addComponent(jTextFieldGramajMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelGramajGrame))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 221, Short.MAX_VALUE)
                        .addComponent(jButtonCautare)))
                .addGap(14, 14, 14))
        );

        jTabbedPane4.addTab("tab4", Hrana);

        Nisip.setBackground(new java.awt.Color(204, 204, 255));

        jLabelN1.setText("parfum");

        jLabelN2.setText("gramaj");

        jComboBox1N.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTextField1N.setText("1");

        jTextField2N.setText("50");

        jLabelN3.setText("asternut");

        jComboBox2N.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1N.setText("Cauta");
        jButton1N.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1NActionPerformed(evt);
            }
        });

        jTextArea1N.setColumns(20);
        jTextArea1N.setRows(5);
        jScrollPane1N.setViewportView(jTextArea1N);

        jList1N.setModel(jListModelN);
        jScrollPane2N.setViewportView(jList1N);

        javax.swing.GroupLayout NisipLayout = new javax.swing.GroupLayout(Nisip);
        Nisip.setLayout(NisipLayout);
        NisipLayout.setHorizontalGroup(
            NisipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NisipLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(NisipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1N)
                    .addGroup(NisipLayout.createSequentialGroup()
                        .addComponent(jLabelN1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1N, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1N))
                    .addGroup(NisipLayout.createSequentialGroup()
                        .addGroup(NisipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(NisipLayout.createSequentialGroup()
                                .addComponent(jLabelN2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1N, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2N, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(NisipLayout.createSequentialGroup()
                                .addComponent(jLabelN3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox2N, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2N, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE))
                .addContainerGap())
        );
        NisipLayout.setVerticalGroup(
            NisipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NisipLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(NisipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelN1)
                    .addComponent(jComboBox1N, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1N))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(NisipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelN2)
                    .addComponent(jTextField1N, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2N, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(NisipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelN3)
                    .addComponent(jComboBox2N, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1N, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2N, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("tab7", Nisip);

        PanelC.setBackground(new java.awt.Color(204, 204, 255));

        TextAreaC.setEditable(false);
        TextAreaC.setColumns(20);
        TextAreaC.setRows(5);
        jScrollPane4.setViewportView(TextAreaC);

        jLabel12.setText("Rezultat:");

        jLabel13.setText("Alte optiuni:");

        CheckCSC.setText("Cerinte speciale");
        CheckCSC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckCSCActionPerformed(evt);
            }
        });

        ComboBoxC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxCActionPerformed(evt);
            }
        });

        jLabel14.setText("Material:");

        CheckAsternut.setText("Asternut:");
        CheckAsternut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckAsternutActionPerformed(evt);
            }
        });

        jLabel15.setText("Pernute");

        jLabel16.setText("Perna captusita");

        javax.swing.GroupLayout MiniPanelCLayout = new javax.swing.GroupLayout(MiniPanelC);
        MiniPanelC.setLayout(MiniPanelCLayout);
        MiniPanelCLayout.setHorizontalGroup(
            MiniPanelCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MiniPanelCLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MiniPanelCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MiniPanelCLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(48, 48, 48)
                        .addComponent(ComboBoxC, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MiniPanelCLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(MiniPanelCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CheckCSC)
                            .addGroup(MiniPanelCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel15)
                                .addComponent(CheckAsternut))
                            .addGroup(MiniPanelCLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel16)))))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        MiniPanelCLayout.setVerticalGroup(
            MiniPanelCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MiniPanelCLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(MiniPanelCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(ComboBoxC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CheckCSC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CheckAsternut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel17.setText("Specia animalului:");

        ButonPisiciC.setText("Pisici");
        ButonPisiciC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButonPisiciCActionPerformed(evt);
            }
        });

        ButonCainiC.setText("Caini");
        ButonCainiC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButonCainiCActionPerformed(evt);
            }
        });

        ButonHamsteriC.setText("Hamsteri");
        ButonHamsteriC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButonHamsteriCActionPerformed(evt);
            }
        });

        ButonIepuriC.setText("Iepuri");
        ButonIepuriC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButonIepuriCActionPerformed(evt);
            }
        });

        jLabel18.setText("Pret:");

        SliderC.setMaximum(300);
        SliderC.setPaintLabels(true);
        SliderC.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SliderCStateChanged(evt);
            }
        });

        ButonDispC.setText("Arata doar produsele in stoc");
        ButonDispC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButonDispCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MiniPanelPACLayout = new javax.swing.GroupLayout(MiniPanelPAC);
        MiniPanelPAC.setLayout(MiniPanelPACLayout);
        MiniPanelPACLayout.setHorizontalGroup(
            MiniPanelPACLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MiniPanelPACLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MiniPanelPACLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ButonHamsteriC)
                    .addComponent(ButonCainiC)
                    .addComponent(jLabel17)
                    .addComponent(ButonPisiciC)
                    .addComponent(ButonDispC)
                    .addGroup(MiniPanelPACLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PretC, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SliderC, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(ButonIepuriC))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        MiniPanelPACLayout.setVerticalGroup(
            MiniPanelPACLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MiniPanelPACLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButonPisiciC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButonCainiC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButonHamsteriC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButonIepuriC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MiniPanelPACLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MiniPanelPACLayout.createSequentialGroup()
                        .addGroup(MiniPanelPACLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PretC, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                            .addComponent(jLabel18))
                        .addGap(16, 16, 16)
                        .addComponent(ButonDispC, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MiniPanelPACLayout.createSequentialGroup()
                        .addComponent(SliderC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout PanelCLayout = new javax.swing.GroupLayout(PanelC);
        PanelC.setLayout(PanelCLayout);
        PanelCLayout.setHorizontalGroup(
            PanelCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(PanelCLayout.createSequentialGroup()
                .addComponent(MiniPanelPAC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 311, Short.MAX_VALUE))
            .addGroup(PanelCLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(PanelCLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(MiniPanelC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        PanelCLayout.setVerticalGroup(
            PanelCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCLayout.createSequentialGroup()
                .addGroup(PanelCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCLayout.createSequentialGroup()
                        .addComponent(MiniPanelPAC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelCLayout.createSequentialGroup()
                        .addComponent(MiniPanelC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(7, 7, 7)))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );

        jTabbedPane4.addTab("tab9", PanelC);

        PanelJ.setBackground(new java.awt.Color(204, 204, 255));

        TextAreaJ.setColumns(20);
        TextAreaJ.setRows(5);
        jScrollPane5.setViewportView(TextAreaJ);

        jLabel19.setText("Rezultat:");

        jLabel20.setText("Specia animalului:");

        ButonPisiciJ.setText("Pisici");
        ButonPisiciJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButonPisiciJActionPerformed(evt);
            }
        });

        ButonCainiJ.setText("Caini");
        ButonCainiJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButonCainiJActionPerformed(evt);
            }
        });

        ButonHamsteriJ.setText("Hamsteri");
        ButonHamsteriJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButonHamsteriJActionPerformed(evt);
            }
        });

        ButonIepuriJ.setText("Iepuri");
        ButonIepuriJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButonIepuriJActionPerformed(evt);
            }
        });

        jLabel21.setText("Pret:");

        PretJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PretJActionPerformed(evt);
            }
        });

        SliderJ.setMaximum(50);
        SliderJ.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SliderJStateChanged(evt);
            }
        });

        ButonDispJ.setText("Arata doar produsele in stoc");
        ButonDispJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButonDispJActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MiniPanelPAC1Layout = new javax.swing.GroupLayout(MiniPanelPAC1);
        MiniPanelPAC1.setLayout(MiniPanelPAC1Layout);
        MiniPanelPAC1Layout.setHorizontalGroup(
            MiniPanelPAC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MiniPanelPAC1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MiniPanelPAC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(MiniPanelPAC1Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PretJ, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SliderJ, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(ButonHamsteriJ)
                    .addComponent(ButonIepuriJ)
                    .addComponent(ButonCainiJ)
                    .addComponent(jLabel20)
                    .addComponent(ButonPisiciJ)
                    .addComponent(ButonDispJ))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        MiniPanelPAC1Layout.setVerticalGroup(
            MiniPanelPAC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MiniPanelPAC1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButonPisiciJ)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButonCainiJ)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButonHamsteriJ)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButonIepuriJ)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MiniPanelPAC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MiniPanelPAC1Layout.createSequentialGroup()
                        .addComponent(SliderJ, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MiniPanelPAC1Layout.createSequentialGroup()
                        .addGroup(MiniPanelPAC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PretJ, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addGap(18, 18, 18)))
                .addComponent(ButonDispJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel22.setText("Alte optiuni:");

        CheckZornaitoare.setText("Zornaitoare");
        CheckZornaitoare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckZornaitoareActionPerformed(evt);
            }
        });

        jLabel23.setText("Forma:");

        jLabel24.setText("Cantitate: ");

        jLabel25.setText("O singura jucarie");

        jLabel26.setText("Pachet de 3 jucarii");

        javax.swing.GroupLayout MiniPanelC1Layout = new javax.swing.GroupLayout(MiniPanelC1);
        MiniPanelC1.setLayout(MiniPanelC1Layout);
        MiniPanelC1Layout.setHorizontalGroup(
            MiniPanelC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MiniPanelC1Layout.createSequentialGroup()
                .addGroup(MiniPanelC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MiniPanelC1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(MiniPanelC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, MiniPanelC1Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(57, 57, 57)
                                .addComponent(ComboBoxJ, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, MiniPanelC1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(CheckZornaitoare))))
                    .addGroup(MiniPanelC1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(MiniPanelC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MiniPanelC1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel26))
                            .addComponent(jLabel25))))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        MiniPanelC1Layout.setVerticalGroup(
            MiniPanelC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MiniPanelC1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(MiniPanelC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(ComboBoxJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CheckZornaitoare)
                .addGap(39, 39, 39)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelJLayout = new javax.swing.GroupLayout(PanelJ);
        PanelJ.setLayout(PanelJLayout);
        PanelJLayout.setHorizontalGroup(
            PanelJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(PanelJLayout.createSequentialGroup()
                .addGroup(PanelJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelJLayout.createSequentialGroup()
                        .addComponent(MiniPanelPAC1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MiniPanelC1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PanelJLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5)))
                .addContainerGap())
            .addGroup(PanelJLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelJLayout.setVerticalGroup(
            PanelJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelJLayout.createSequentialGroup()
                .addGroup(PanelJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(MiniPanelPAC1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MiniPanelC1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("tab10", PanelJ);

        PanSup.setBackground(new java.awt.Color(204, 204, 255));

        PretMinSup.setText("1");
        PretMinSup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PretMinSupActionPerformed(evt);
            }
        });

        PretSup.setText("PREȚ");

        PretMaxSup.setText("50");

        BeneficiiSup.setText("BENEFICII");

        BenSup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        CautaSup.setText("Caută");
        CautaSup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CautaSupActionPerformed(evt);
            }
        });

        PrescriptieSup.setBackground(new java.awt.Color(204, 204, 255));
        PrescriptieSup.setText("DA");

        PreSup.setText("PRESCRIPȚIE");

        TextSup.setColumns(20);
        TextSup.setRows(5);
        jScrollPane6.setViewportView(TextSup);

        javax.swing.GroupLayout PanSupLayout = new javax.swing.GroupLayout(PanSup);
        PanSup.setLayout(PanSupLayout);
        PanSupLayout.setHorizontalGroup(
            PanSupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanSupLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanSupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane6)
                    .addGroup(PanSupLayout.createSequentialGroup()
                        .addComponent(PretSup)
                        .addGap(18, 18, 18)
                        .addComponent(PretMinSup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PretMaxSup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CautaSup))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanSupLayout.createSequentialGroup()
                        .addGroup(PanSupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanSupLayout.createSequentialGroup()
                                .addComponent(BeneficiiSup)
                                .addGap(18, 18, 18)
                                .addComponent(BenSup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanSupLayout.createSequentialGroup()
                                .addComponent(PreSup)
                                .addGap(18, 18, 18)
                                .addComponent(PrescriptieSup)))
                        .addGap(0, 371, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanSupLayout.setVerticalGroup(
            PanSupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanSupLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanSupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PretSup)
                    .addComponent(PretMinSup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PretMaxSup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CautaSup))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanSupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BeneficiiSup)
                    .addComponent(BenSup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanSupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PreSup)
                    .addComponent(PrescriptieSup))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane4.addTab("tab10", PanSup);

        Medicamente.setBackground(new java.awt.Color(204, 204, 255));

        PretMed.setText("PREȚ");

        RolMed.setText("ROL");

        PerMed.setText("PERIOADĂ GESTAȚIE");

        PretMinMed.setText("1");

        PretMaxMed.setText("50");

        RoMed.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        PerioadaMed.setBackground(new java.awt.Color(204, 204, 255));
        PerioadaMed.setText("DA");
        PerioadaMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PerioadaMedActionPerformed(evt);
            }
        });

        CautaMed.setText("Caută");
        CautaMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CautaMedActionPerformed(evt);
            }
        });

        TextMed.setColumns(20);
        TextMed.setRows(5);
        jScrollPane7.setViewportView(TextMed);

        javax.swing.GroupLayout MedicamenteLayout = new javax.swing.GroupLayout(Medicamente);
        Medicamente.setLayout(MedicamenteLayout);
        MedicamenteLayout.setHorizontalGroup(
            MedicamenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MedicamenteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(MedicamenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7)
                    .addGroup(MedicamenteLayout.createSequentialGroup()
                        .addGroup(MedicamenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PretMed)
                            .addComponent(RolMed))
                        .addGap(18, 18, 18)
                        .addGroup(MedicamenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RoMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(MedicamenteLayout.createSequentialGroup()
                                .addComponent(PretMinMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PretMaxMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 335, Short.MAX_VALUE)
                        .addComponent(CautaMed))
                    .addGroup(MedicamenteLayout.createSequentialGroup()
                        .addComponent(PerMed)
                        .addGap(18, 18, 18)
                        .addComponent(PerioadaMed)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        MedicamenteLayout.setVerticalGroup(
            MedicamenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MedicamenteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MedicamenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PretMed)
                    .addComponent(PretMinMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PretMaxMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CautaMed))
                .addGap(18, 18, 18)
                .addGroup(MedicamenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RolMed)
                    .addComponent(RoMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(MedicamenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PerMed)
                    .addComponent(PerioadaMed))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane4.addTab("tab10", Medicamente);

        MainPane.add(jTabbedPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, -30, 520, 500));
        jTabbedPane4.getAccessibleContext().setAccessibleName("Welcome");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(MainPane, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        MainPane.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CheckCaineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckCaineActionPerformed
        // TODO add your handling code here:

        /*StringBuffer afisat=new StringBuffer("");
         if(CheckCaine.isSelected())
            for(Cusca c:test.listaCusti)
            {
            if(c.getSpecieAnimal().compareToIgnoreCase("caine")==0)
                afisat.append(c.toString());
            }
        jTextArea1.setText(afisat.toString());*/

    }//GEN-LAST:event_CheckCaineActionPerformed

    private void CheckPisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckPisicaActionPerformed
        // TODO add your handling code here:

        /*StringBuffer afisat=new StringBuffer("");
         if(CheckPisica.isSelected())
            for(Cusca c:test.listaCusti)
            {
            if(c.getSpecieAnimal().compareToIgnoreCase("pisica")==0)
                afisat.append(c.toString());
           
            }
        jTextArea1.setText(afisat.toString());*/
    }//GEN-LAST:event_CheckPisicaActionPerformed

    private void CheckToateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckToateActionPerformed
        // TODO add your handling code here:

        /*StringBuffer afisat=new StringBuffer("");
        for(Cusca c:test.listaCusti)
        {afisat.append(c.toString());
       
        }
        jTextArea1.setText(afisat.toString());*/
    }//GEN-LAST:event_CheckToateActionPerformed

    private void ButonCautareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButonCautareActionPerformed
        // TODO add your handling code here:
        String material;
        material = jComboBoxMateriale.getSelectedItem().toString();
        String culoare = jComboBoxCuloare.getSelectedItem().toString();
        StringBuffer afisat = new StringBuffer("");
        String categorieVarsta = "";
        if (jSlider1.getValue() <= 1) {
            categorieVarsta = "junior";
        } else if (jSlider1.getValue() > 1 && jSlider1.getValue() <= 8) {
            categorieVarsta = "adult";
        } else if (jSlider1.getValue() > 8) {
            categorieVarsta = "senior";
        }

        if (material.compareToIgnoreCase("Toate materialele") == 0 && culoare.compareToIgnoreCase("Toate culorile") == 0) {
            if (CheckPisica.isSelected()) {
                for (Cusca c : test.listaCusti) {
                    if (c.getSpecieAnimal().compareToIgnoreCase("pisica") == 0 && (c.getCategorieVarsta().compareToIgnoreCase("toate categoriile de varsta") == 0 || c.getCategorieVarsta().compareToIgnoreCase(categorieVarsta) == 0)) {
                        afisat.append(c.toString());
                        afisat.append("\n\t\t\t\t" + c.getPret() + "RON");

                    }

                }
            } else if (CheckCaine.isSelected()) {
                for (Cusca c : test.listaCusti) {
                    if (c.getSpecieAnimal().compareToIgnoreCase("caine") == 0 && (c.getCategorieVarsta().compareToIgnoreCase("toate categoriile de varsta") == 0 || c.getCategorieVarsta().compareToIgnoreCase(categorieVarsta) == 0)) {
                        afisat.append(c.toString());
                        afisat.append("\n\t\t\t\t" + c.getPret() + "RON");
                    }
                }
            } else if (CheckToate.isSelected()) {
                for (Cusca c : test.listaCusti) {
                    if (c.getCategorieVarsta().compareToIgnoreCase("toate categoriile de varsta") == 0 || c.getCategorieVarsta().compareToIgnoreCase(categorieVarsta) == 0) {
                        afisat.append(c.toString());
                        afisat.append("\n\t\t\t\t" + c.getPret() + "RON");
                    }
                }
            }
        } else if (material.compareToIgnoreCase("Toate materialele") == 0) {
            if (CheckPisica.isSelected()) {
                for (Cusca c : test.listaCusti) {
                    if (c.getSpecieAnimal().compareToIgnoreCase("pisica") == 0) {
                        if (culoare.compareToIgnoreCase(c.getNumeCuloare(c.getCuloare())) == 0 && (c.getCategorieVarsta().compareToIgnoreCase("toate categoriile de varsta") == 0 || c.getCategorieVarsta().compareToIgnoreCase(categorieVarsta) == 0)) {
                            afisat.append(c.toString());
                            afisat.append("\n\t\t\t\t" + c.getPret() + "RON");
                        }
                    }

                }
            } else if (CheckCaine.isSelected()) {
                for (Cusca c : test.listaCusti) {
                    if (c.getSpecieAnimal().compareToIgnoreCase("caine") == 0) {
                        if (culoare.compareToIgnoreCase(c.getNumeCuloare(c.getCuloare())) == 0 && (c.getCategorieVarsta().compareToIgnoreCase("toate categoriile de varsta") == 0 || c.getCategorieVarsta().compareToIgnoreCase(categorieVarsta) == 0)) {
                            afisat.append(c.toString());
                            afisat.append("\n\t\t\t\t" + c.getPret() + "RON");
                        }
                    }
                }
            } else if (CheckToate.isSelected()) {
                for (Cusca c : test.listaCusti) {
                    if (culoare.compareToIgnoreCase(c.getNumeCuloare(c.getCuloare())) == 0 && (c.getCategorieVarsta().compareToIgnoreCase("toate categoriile de varsta") == 0 || c.getCategorieVarsta().compareToIgnoreCase(categorieVarsta) == 0)) {
                        afisat.append(c.toString());
                        afisat.append("\n\t\t\t\t" + c.getPret() + "RON");
                    }
                }
            }
        } else if (culoare.compareToIgnoreCase("Toate culorile") == 0) {
            if (CheckPisica.isSelected()) {
                for (Cusca c : test.listaCusti) {
                    if (c.getSpecieAnimal().compareToIgnoreCase("pisica") == 0 && (c.getCategorieVarsta().compareToIgnoreCase("toate categoriile de varsta") == 0 || c.getCategorieVarsta().compareToIgnoreCase(categorieVarsta) == 0)) {
                        if (c.getMaterial().compareToIgnoreCase(material) == 0) {
                            afisat.append(c.toString());
                            afisat.append("\n\t\t\t\t" + c.getPret() + "RON");
                        }
                    }

                }
            } else if (CheckCaine.isSelected()) {
                for (Cusca c : test.listaCusti) {
                    if (c.getSpecieAnimal().compareToIgnoreCase("caine") == 0 && (c.getCategorieVarsta().compareToIgnoreCase("toate categoriile de varsta") == 0 || c.getCategorieVarsta().compareToIgnoreCase(categorieVarsta) == 0)) {
                        if (c.getMaterial().compareToIgnoreCase(material) == 0) {
                            afisat.append(c.toString());
                            afisat.append("\n\t\t\t\t" + c.getPret() + "RON");
                        }
                    }
                }
            } else if (CheckToate.isSelected()) {
                for (Cusca c : test.listaCusti) {
                    if (c.getMaterial().compareToIgnoreCase(material) == 0 && (c.getCategorieVarsta().compareToIgnoreCase("toate categoriile de varsta") == 0 || c.getCategorieVarsta().compareToIgnoreCase(categorieVarsta) == 0)) {
                        afisat.append(c.toString());
                        afisat.append("\n\t\t\t\t" + c.getPret() + "RON");
                    }
                }
            }
        } else {
            {
                if (CheckPisica.isSelected()) {
                    for (Cusca c : test.listaCusti) {
                        if (c.getSpecieAnimal().compareToIgnoreCase("pisica") == 0 && (c.getCategorieVarsta().compareToIgnoreCase("toate categoriile de varsta") == 0 || c.getCategorieVarsta().compareToIgnoreCase(categorieVarsta) == 0)) {
                            if (c.getMaterial().compareToIgnoreCase(material) == 0) {
                                if (culoare.compareToIgnoreCase(c.getNumeCuloare(c.getCuloare())) == 0) {
                                    afisat.append(c.toString());
                                    afisat.append("\n\t\t\t\t" + c.getPret() + "RON");
                                }
                            }
                        }

                    }
                } else if (CheckCaine.isSelected()) {
                    for (Cusca c : test.listaCusti) {
                        if (c.getSpecieAnimal().compareToIgnoreCase("caine") == 0 && (c.getCategorieVarsta().compareToIgnoreCase("toate categoriile de varsta") == 0 || c.getCategorieVarsta().compareToIgnoreCase(categorieVarsta) == 0)) {
                            if (c.getMaterial().compareToIgnoreCase(material) == 0) {
                                if (culoare.compareToIgnoreCase(c.getNumeCuloare(c.getCuloare())) == 0) {
                                    afisat.append(c.toString());
                                    afisat.append("\n\t\t\t\t" + c.getPret() + "RON");
                                }
                            }
                        }
                    }
                } else if (CheckToate.isSelected()) {
                    for (Cusca c : test.listaCusti) {
                        if (c.getMaterial().compareToIgnoreCase(material) == 0) {
                            if (culoare.compareToIgnoreCase(c.getNumeCuloare(c.getCuloare())) == 0 && (c.getCategorieVarsta().compareToIgnoreCase("toate categoriile de varsta") == 0 || c.getCategorieVarsta().compareToIgnoreCase(categorieVarsta) == 0)) {
                                afisat.append(c.toString());
                                afisat.append("\n\t\t\t\t" + c.getPret() + "RON");
                            }
                        }
                    }
                }
            }
        }

        jTextAreaCusti.setText(afisat.toString());

    }//GEN-LAST:event_ButonCautareActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        StringBuffer afisat = new StringBuffer("");
        float greutate = Float.parseFloat(jTextFieldGreutateAnimal.getText());

        String producator = jComboBoxProducatori.getSelectedItem().toString();

        if (producator.compareToIgnoreCase("toti producatorii") == 0) {
            if (jRadioButton1.isSelected()) {
                for (CutieTransport c : test.listaCutii) {
                    if (c.getCapacitate() >= greutate && c.pliabil() == true) {
                        afisat.append(c.toString());
                        afisat.append("\t\t\t\t" + c.getPret() + "RON");
                    }
                }
            } else {
                for (CutieTransport c : test.listaCutii) {
                    if (c.getCapacitate() >= greutate && c.pliabil() == false) {
                        afisat.append(c.toString());
                        afisat.append("\t\t\t\t" + c.getPret() + "RON");
                    }
                }
            }
        } else {
            if (jRadioButton1.isSelected()) {
                for (CutieTransport c : test.listaCutii) {
                    if (c.getCapacitate() >= greutate && c.pliabil() == true && c.getNumeProducator() == producator) {
                        afisat.append(c.toString());
                        afisat.append("\t\t\t\t" + c.getPret() + "RON");
                    }
                }
            } else {
                for (CutieTransport c : test.listaCutii) {
                    if (c.getCapacitate() >= greutate && c.pliabil() == false && c.getNumeProducator() == producator) {
                        afisat.append(c.toString());
                        afisat.append("\t\t\t\t" + c.getPret() + "RON");
                    }
                }
            }
        }

        jTextAreaCutiiTransport.setText(afisat.toString());
    }//GEN-LAST:event_jButton1MouseClicked

    private void jLabelCustiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCustiMouseClicked

        jTabbedPane4.setSelectedComponent(Custi);
       /* StringBuffer afisat = new StringBuffer("");
        for (Cusca c : test.listaCusti) {
            afisat.append(c.toString());
            afisat.append("\n\t\t\t\t");
            afisat.append(c.getPret());
            afisat.append("RON");
        }
        jTextArea1.setText(afisat.toString());*/
    }//GEN-LAST:event_jLabelCustiMouseClicked

    private void jLabelCutiiTransportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCutiiTransportMouseClicked
        // TODO add your handling code here:
        jTabbedPane4.setSelectedComponent(CutiiTransport);
        /*StringBuffer afisat = new StringBuffer("");
        for (CutieTransport c : test.listaCutii) {
            afisat.append(c.toString());
            afisat.append("\n\t\t\t\t" + c.getPret() + "RON");
        }
        jTextAreaCutiiTransport.setText(afisat.toString());*/
    }//GEN-LAST:event_jLabelCutiiTransportMouseClicked

    private void jLabelMeniuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMeniuMouseClicked
        // TODO add your handling code here:
        jTabbedPane4.setSelectedComponent(Welcome);
    }//GEN-LAST:event_jLabelMeniuMouseClicked

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        // TODO add your handling code here:
        jLabel11.setText(Integer.toString(jSlider1.getValue()) + (jSlider1.getValue() != 1 ? "ani" : "an"));
    }//GEN-LAST:event_jSlider1StateChanged

    private void jSlider2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider2StateChanged
        // TODO add your handling code here:
        jLabel9.setText("si " + Integer.toString(jSlider2.getValue()) + (jSlider2.getValue() != 1 ? "luni" : "luna"));
    }//GEN-LAST:event_jSlider2StateChanged

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        jLabelPliabil.setText(jRadioButton1.isSelected() ? "Pliabil a fost selectat" : "Pliabil a fost deselectat");

    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jButtonCautareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCautareActionPerformed
        String producator, categorieVarsta, tipMancare, tipAmbalaj;
        float pretMinim = 13.7f, pretMaxim = 139;
        int gramajMinim = 510, gramajMaxim = 14000;
        producator = jComboBoxProducator.getSelectedItem().toString();
        pretMinim = Float.parseFloat(jTextFieldPretMin.getText());
        pretMaxim = Float.parseFloat(jTextFieldPretMax.getText());
        categorieVarsta = jComboBoxCategorieVarsta.getSelectedItem().toString();
        tipMancare = jComboBoxTipMancare.getSelectedItem().toString();
        tipAmbalaj = jComboBoxTipAmbalaj.getSelectedItem().toString();
        gramajMinim = Integer.parseInt(jTextFieldGramajMin.getText());
        gramajMaxim = Integer.parseInt(jTextFieldGramajMax.getText());
        StringBuilder afisat = new StringBuilder("");
        if (tipMancare.equals("Hrana Umeda") || tipMancare.equals("Toate")) {
            for (HranaUmeda l : listaHum) {
                if ((l.numeProducator.equals(producator) || producator.equals("Toate")) && (l.pret >= pretMinim && l.pret <= pretMaxim)
                        && (l.categorieVarsta.equals(categorieVarsta) || categorieVarsta.equals("Toate")) && (l.tipAmbalaj.equals(tipAmbalaj) || tipAmbalaj.equals("Toate"))
                        && (l.gramaj >= gramajMinim && l.gramaj <= gramajMaxim) && l.disponibilitate) {
                    afisat.append(l);
                }
            }
        }
        jTextAreaRezultate.setText(afisat.toString().trim());
        if (tipMancare.equals("Hrana Uscata") || tipMancare.equals("Toate")) {
            for (HranaUscata l : listaHus) {
                if ((l.numeProducator.equals(producator) || producator.equals("Toate")) && (l.pret >= pretMinim && l.pret <= pretMaxim)
                        && (l.categorieVarsta.equals(categorieVarsta) || categorieVarsta.equals("Toate")) && (l.tipAmbalaj.equals(tipAmbalaj) || tipAmbalaj.equals("Toate"))
                        && (l.gramaj >= gramajMinim && l.gramaj <= gramajMaxim) && l.disponibilitate) {
                    afisat.append(l);
                }
            }
        }
        if (afisat == null) {
            jTextAreaRezultate.setText("Niciun rezultat");
        } else {
            jTextAreaRezultate.setText(afisat.toString().trim());
        }
    }//GEN-LAST:event_jButtonCautareActionPerformed

    private void labelHranaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelHranaMouseClicked
        // TODO add your handling code here:
        jTabbedPane4.setSelectedComponent(Hrana);
    }//GEN-LAST:event_labelHranaMouseClicked

    private void jLabelMedicamenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMedicamenteMouseClicked
        // TODO add your handling code here:
        jTabbedPane4.setSelectedComponent(Medicamente);
    }//GEN-LAST:event_jLabelMedicamenteMouseClicked

    private void jLabelSuplimenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSuplimenteMouseClicked
        // TODO add your handling code here:
        jTabbedPane4.setSelectedComponent(PanSup);
    }//GEN-LAST:event_jLabelSuplimenteMouseClicked

    private void CheckCSCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckCSCActionPerformed
        StringBuffer afisat=new StringBuffer("");
        if(CheckCSC.isSelected()){
            for(Culcus C:test.listaCulcus){
                if(C.cerinteSpeciale != "nu are")
                afisat.append(C.toString());
            }
        }
        TextAreaC.setText(afisat.toString());
    }//GEN-LAST:event_CheckCSCActionPerformed

    private void ComboBoxCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxCActionPerformed
        StringBuffer afisat=new StringBuffer("");
        String material;
        material = ComboBoxC.getSelectedItem().toString();
        if(material == "bumbac" &&(ButonPisiciC.isSelected() || ButonCainiC.isSelected() || ButonHamsteriC.isSelected() || ButonIepuriC.isSelected()))
        for(Culcus C:test.listaCulcus)
        if(C.material.compareToIgnoreCase("bumbac")==0)
        afisat.append(C.toString());

        if (material =="lemn" && (ButonPisiciC.isSelected() || ButonCainiC.isSelected() || ButonHamsteriC.isSelected() || ButonIepuriC.isSelected()))
        for(Culcus C:test.listaCulcus)
        if(C.material.compareToIgnoreCase("lemn")==0)
        afisat.append(C.toString());

        if (material =="nailon" && (ButonPisiciC.isSelected() || ButonCainiC.isSelected() || ButonHamsteriC.isSelected() || ButonIepuriC.isSelected()))
        for(Culcus C:test.listaCulcus)
        if(C.material.compareToIgnoreCase("nailon")==0)
        afisat.append(C.toString());

        if (material =="rachita" && (ButonPisiciC.isSelected() || ButonCainiC.isSelected() || ButonHamsteriC.isSelected() || ButonIepuriC.isSelected()))
        for(Culcus C:test.listaCulcus)
        if(C.material.compareToIgnoreCase("rachita")==0)
        afisat.append(C.toString());

        if (material =="poliester" && (ButonPisiciC.isSelected() || ButonCainiC.isSelected() || ButonHamsteriC.isSelected() || ButonIepuriC.isSelected()))
        for(Culcus C:test.listaCulcus)
        if(C.material.compareToIgnoreCase("poliester")==0)
        afisat.append(C.toString());

        TextAreaC.setText(afisat.toString());
    }//GEN-LAST:event_ComboBoxCActionPerformed

    private void CheckAsternutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckAsternutActionPerformed
        StringBuffer afisat=new StringBuffer("");
        if(CheckAsternut.isSelected()){
            for(Culcus C:test.listaCulcus){
                if(C.asternut == true)
                afisat.append(C.toString());
            }
        }
        TextAreaC.setText(afisat.toString());
    }//GEN-LAST:event_CheckAsternutActionPerformed

    private void ButonPisiciCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButonPisiciCActionPerformed
        StringBuffer afisat=new StringBuffer("");
        if(ButonPisiciC.isSelected()){
            ButonCainiC.setSelected(false);
            ButonHamsteriC.setSelected(false);
            ButonIepuriC.setSelected(false);
            for(Culcus C:test.listaCulcus){
                if(C.specieAnimal.compareToIgnoreCase("pisica")==0)
                afisat.append(C.toString());
            }

            TextAreaC.setText(afisat.toString());

            if (ButonCainiC.isSelected()||ButonHamsteriC.isSelected()||ButonIepuriC.isSelected()){
                for(Culcus C:test.listaCulcus){
                    if(C.specieAnimal.compareToIgnoreCase("pisica")==0)
                    ButonPisiciC.setSelected(false);
                }
                TextAreaC.setText("");
            }
        }
    }//GEN-LAST:event_ButonPisiciCActionPerformed

    private void ButonCainiCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButonCainiCActionPerformed
        StringBuffer afisat=new StringBuffer("");
        if(ButonCainiC.isSelected()){
            ButonPisiciC.setSelected(false);
            ButonHamsteriC.setSelected(false);
            ButonIepuriC.setSelected(false);
            for(Culcus C:test.listaCulcus){
                if(C.specieAnimal.compareToIgnoreCase("caine")==0)
                afisat.append(C.toString());
            }
            TextAreaC.setText(afisat.toString());

            if (ButonPisiciC.isSelected()||ButonHamsteriC.isSelected()||ButonIepuriC.isSelected()){
                for(Culcus C:test.listaCulcus){
                    if(C.specieAnimal.compareToIgnoreCase("caine")==0)
                    ButonCainiC.setSelected(false);
                }
                TextAreaC.setText("");
            }
        }
    }//GEN-LAST:event_ButonCainiCActionPerformed

    private void ButonHamsteriCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButonHamsteriCActionPerformed
        StringBuffer afisat=new StringBuffer("");
        if(ButonHamsteriC.isSelected()){
            ButonPisiciC.setSelected(false);
            ButonCainiC.setSelected(false);
            ButonIepuriC.setSelected(false);
            for(Culcus C:test.listaCulcus){
                if(C.specieAnimal.compareToIgnoreCase("hamster")==0)
                afisat.append(C.toString());
            }

            TextAreaC.setText(afisat.toString());

            if (ButonPisiciC.isSelected()||ButonCainiC.isSelected()||ButonIepuriC.isSelected()){
                for(Culcus C:test.listaCulcus){
                    if(C.specieAnimal.compareToIgnoreCase("hamster")==0)
                    ButonHamsteriC.setSelected(false);
                }
                TextAreaC.setText("");
            }
        }
    }//GEN-LAST:event_ButonHamsteriCActionPerformed

    private void ButonIepuriCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButonIepuriCActionPerformed
        StringBuffer afisat=new StringBuffer("");
        if(ButonIepuriC.isSelected()){
            ButonPisiciC.setSelected(false);
            ButonCainiC.setSelected(false);
            ButonHamsteriC.setSelected(false);
            for(Culcus C:test.listaCulcus){
                if(C.specieAnimal.compareToIgnoreCase("iepuri")==0)
                afisat.append(C.toString());
            }

            TextAreaC.setText(afisat.toString());

            if (ButonPisiciC.isSelected()||ButonCainiC.isSelected()||ButonHamsteriC.isSelected()){
                for(Culcus C:test.listaCulcus){
                    if(C.specieAnimal.compareToIgnoreCase("iepuri")==0)
                    ButonIepuriC.setSelected(false);
                }
                TextAreaC.setText("");
            }
        }
    }//GEN-LAST:event_ButonIepuriCActionPerformed

    private void SliderCStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SliderCStateChanged
        int x = SliderC.getValue();
        PretC.setText(""+x);
    }//GEN-LAST:event_SliderCStateChanged

    private void ButonDispCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButonDispCActionPerformed
        StringBuffer afisat=new StringBuffer("");
        for(Culcus C:test.listaCulcus){
            if(C.disponibilitate == true && C.pret<SliderC.getValue())
            afisat.append(C.toString());

            TextAreaC.setText(afisat.toString());
        }
    }//GEN-LAST:event_ButonDispCActionPerformed

    private void ButonPisiciJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButonPisiciJActionPerformed
        StringBuffer afisat=new StringBuffer("");
        if(ButonPisiciJ.isSelected()){
            ButonCainiJ.setSelected(false);
            ButonHamsteriJ.setSelected(false);
            ButonIepuriJ.setSelected(false);
            for(Jucarii J:test.listaJucarii){
                if(J.specieAnimal.compareToIgnoreCase("pisica")==0)
                afisat.append(J.toString());
            }

            TextAreaJ.setText(afisat.toString());

            if (ButonCainiJ.isSelected()||ButonHamsteriJ.isSelected()||ButonIepuriJ.isSelected()){
                for(Jucarii J:test.listaJucarii){
                    if(J.specieAnimal.compareToIgnoreCase("pisica")==0)
                    ButonPisiciJ.setSelected(false);
                }
                TextAreaC.setText("");
            }
        }
    }//GEN-LAST:event_ButonPisiciJActionPerformed

    private void ButonCainiJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButonCainiJActionPerformed
        StringBuffer afisat=new StringBuffer("");
        if(ButonCainiJ.isSelected()){
            ButonPisiciJ.setSelected(false);
            ButonHamsteriJ.setSelected(false);
            ButonIepuriJ.setSelected(false);
            for(Jucarii J:test.listaJucarii){
                if(J.specieAnimal.compareToIgnoreCase("caine")==0)
                afisat.append(J.toString());
            }

            TextAreaJ.setText(afisat.toString());

            if (ButonPisiciJ.isSelected()||ButonHamsteriJ.isSelected()||ButonIepuriJ.isSelected()){
                for(Jucarii J:test.listaJucarii){
                    if(J.specieAnimal.compareToIgnoreCase("caine")==0)
                    ButonCainiJ.setSelected(false);
                }
                TextAreaC.setText("");
            }
        }
    }//GEN-LAST:event_ButonCainiJActionPerformed

    private void ButonHamsteriJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButonHamsteriJActionPerformed
        StringBuffer afisat=new StringBuffer("");
        if(ButonHamsteriJ.isSelected()){
            ButonPisiciJ.setSelected(false);
            ButonCainiJ.setSelected(false);
            ButonIepuriJ.setSelected(false);
            for(Jucarii J:test.listaJucarii){
                if(J.specieAnimal.compareToIgnoreCase("hamster")==0)
                afisat.append(J.toString());
            }

            TextAreaJ.setText(afisat.toString());

            if (ButonPisiciJ.isSelected()||ButonCainiJ.isSelected()||ButonIepuriJ.isSelected()){
                for(Jucarii J:test.listaJucarii){
                    if(J.specieAnimal.compareToIgnoreCase("hamster")==0)
                    ButonHamsteriJ.setSelected(false);
                }
                TextAreaC.setText("");
            }
        }
    }//GEN-LAST:event_ButonHamsteriJActionPerformed

    private void ButonIepuriJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButonIepuriJActionPerformed
        StringBuffer afisat=new StringBuffer("");
        if(ButonIepuriJ.isSelected()){
            ButonPisiciJ.setSelected(false);
            ButonHamsteriJ.setSelected(false);
            ButonCainiJ.setSelected(false);
            for(Jucarii J:test.listaJucarii){
                if(J.specieAnimal.compareToIgnoreCase("iepure")==0)
                afisat.append(J.toString());
            }

            TextAreaJ.setText(afisat.toString());

            if (ButonPisiciJ.isSelected()||ButonHamsteriJ.isSelected()||ButonCainiJ.isSelected()){
                for(Jucarii J:test.listaJucarii){
                    if(J.specieAnimal.compareToIgnoreCase("iepure")==0)
                    ButonIepuriJ.setSelected(false);
                }
                TextAreaC.setText("");
            }
        }
    }//GEN-LAST:event_ButonIepuriJActionPerformed

    private void PretJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PretJActionPerformed

    }//GEN-LAST:event_PretJActionPerformed

    private void SliderJStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SliderJStateChanged
        int x = SliderJ.getValue();
        PretJ.setText(""+x);
    }//GEN-LAST:event_SliderJStateChanged

    private void ButonDispJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButonDispJActionPerformed
        StringBuffer afisat=new StringBuffer("");
        for(Jucarii J:test.listaJucarii){
            if(J.disponibilitate == true && J.pret<SliderJ.getValue())
            afisat.append(J.toString());

            TextAreaJ.setText(afisat.toString());
        }
    }//GEN-LAST:event_ButonDispJActionPerformed

    private void CheckZornaitoareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckZornaitoareActionPerformed
        StringBuffer afisat=new StringBuffer("");
        if(CheckZornaitoare.isSelected()){
            for(Jucarii J:test.listaJucarii){
                if(J.zornaitoare == true )
                afisat.append(J.toString());
            }
        }
        TextAreaJ.setText(afisat.toString());
    }//GEN-LAST:event_CheckZornaitoareActionPerformed

    private void labelJucariiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelJucariiMouseClicked
        // TODO add your handling code here:
        jTabbedPane4.setSelectedComponent(PanelJ);
    }//GEN-LAST:event_labelJucariiMouseClicked

    private void jLabelCulcusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCulcusMouseClicked
        // TODO add your handling code here:
        jTabbedPane4.setSelectedComponent(PanelC);
    }//GEN-LAST:event_jLabelCulcusMouseClicked

    private void jButton1IgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1IgActionPerformed
        float nrUtilizariMinim = 0, nrUtilizariMaxim = 50;
        String tip, recipient;
        StringBuffer afisat = new StringBuffer("");
        tip = jComboBox1Ig.getSelectedItem().toString();
        recipient = jComboBox2Ig.getSelectedItem().toString();
        nrUtilizariMinim = Float.parseFloat(jTextField1Ig.getText());
        nrUtilizariMaxim = Float.parseFloat(jTextField2Ig.getText());
        for (ProduseIgiena pig : test.listaProduseIgiena) {
            if ((pig.nrUtilizari >= nrUtilizariMinim && pig.nrUtilizari <= nrUtilizariMaxim) && (pig.tip.equals(tip) || tip.equals("Toate"))
                && (pig.recipient.equals(recipient) || recipient.equals("Toate"))) {
                afisat.append(pig);
            }
        }
        jTextArea1Ig.setText(afisat.toString());
        System.out.println(afisat.toString());
    }//GEN-LAST:event_jButton1IgActionPerformed

    private void jLabelProduseIgienaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProduseIgienaMouseClicked
        jTabbedPane4.setSelectedComponent(ProduseIgiena);
    }//GEN-LAST:event_jLabelProduseIgienaMouseClicked

    private void jLabelNisipMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNisipMouseClicked
        jTabbedPane4.setSelectedComponent(Nisip);
    }//GEN-LAST:event_jLabelNisipMouseClicked

    private void jButton1NActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1NActionPerformed
        int gramajMinim = 0, gramajMaxim = 50;
        String parfum, asternut;
        StringBuffer afisat = new StringBuffer("");
        parfum = jComboBox1N.getSelectedItem().toString();
        asternut = jComboBox2N.getSelectedItem().toString();
        gramajMinim = Integer.parseInt(jTextField1N.getText());
        gramajMaxim = Integer.parseInt(jTextField2N.getText());
        for (Nisip ns : test.listaNisip) {
            if ((ns.gramaj >= gramajMinim && ns.gramaj <= gramajMaxim) && (ns.parfum.equals(parfum) || parfum.equals("Toate"))
                && (ns.asternut.equals(asternut) || asternut.equals("Toate"))) {
                afisat.append(ns);
            }
        }
        jTextArea1N.setText(afisat.toString());
        System.out.println(afisat.toString());
    }//GEN-LAST:event_jButton1NActionPerformed

    private void PretMinSupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PretMinSupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PretMinSupActionPerformed

    private void CautaSupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CautaSupActionPerformed
        // TODO add your handling code here:
        float pretMinim = 1, pretMaxim = 50;
        String ben = BenSup.getSelectedItem().toString();
        StringBuffer afisat = new StringBuffer("");
        pretMinim = Float.parseFloat(PretMinSup.getText());
        pretMaxim = Float.parseFloat(PretMaxSup.getText());
        if (PrescriptieSup.isSelected())
        for (Suplimente s : test.listaSuplimente) {
            if (s.pret >= pretMinim && s.pret <= pretMaxim && s.beneficii.equals(ben) && s.prescriptie == true)
            afisat.append(s.toString());
        } else
        for (Suplimente s : test.listaSuplimente) {
            if (s.pret >= pretMinim && s.pret <= pretMaxim && s.beneficii.equals(ben) && s.prescriptie == false)
            afisat.append(s.toString());
        }
        TextSup.setText(afisat.toString());
        System.out.println(afisat.toString());
    }//GEN-LAST:event_CautaSupActionPerformed

    private void PerioadaMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PerioadaMedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PerioadaMedActionPerformed

    private void CautaMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CautaMedActionPerformed
        // TODO add your handling code here:
        float pretMinim = 1, pretMaxim = 50;
        String rol = RoMed.getSelectedItem().toString();
        StringBuffer afisat = new StringBuffer("");
        pretMinim = Float.parseFloat(PretMinMed.getText());
        pretMaxim = Float.parseFloat(PretMaxMed.getText());
        if (PerioadaMed.isSelected())
        for (Medicamente m : test.listaMedicamente) {
            if (m.pret >= pretMinim && m.pret <= pretMaxim && m.rol.equals(rol) && m.perioadaGestatie == true)
            afisat.append(m.toString());
        } else
        for (Medicamente m : test.listaMedicamente) {
            if (m.pret >= pretMinim && m.pret <= pretMaxim && m.rol.equals(rol) && m.perioadaGestatie == false)
            afisat.append(m.toString());
        }
        TextMed.setText(afisat.toString());
        System.out.println(afisat.toString());

    }//GEN-LAST:event_CautaMedActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameProduse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameProduse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameProduse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameProduse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameProduse().setVisible(true);
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BenSup;
    private javax.swing.JLabel BeneficiiSup;
    private javax.swing.JRadioButton ButonCainiC;
    private javax.swing.JRadioButton ButonCainiJ;
    private javax.swing.JButton ButonCautare;
    private javax.swing.JButton ButonDispC;
    private javax.swing.JButton ButonDispJ;
    private javax.swing.JRadioButton ButonHamsteriC;
    private javax.swing.JRadioButton ButonHamsteriJ;
    private javax.swing.JRadioButton ButonIepuriC;
    private javax.swing.JRadioButton ButonIepuriJ;
    private javax.swing.JRadioButton ButonPisiciC;
    private javax.swing.JRadioButton ButonPisiciJ;
    private javax.swing.JButton CautaMed;
    private javax.swing.JButton CautaSup;
    private javax.swing.JCheckBox CheckAsternut;
    private javax.swing.JCheckBox CheckCSC;
    private javax.swing.JCheckBox CheckCaine;
    private javax.swing.JCheckBox CheckPisica;
    private javax.swing.JCheckBox CheckToate;
    private javax.swing.JCheckBox CheckZornaitoare;
    private javax.swing.JComboBox<String> ComboBoxC;
    private javax.swing.JComboBox<String> ComboBoxJ;
    private javax.swing.JPanel Custi;
    private javax.swing.JPanel CutiiTransport;
    private javax.swing.JPanel Hrana;
    private javax.swing.JPanel MainPane;
    private javax.swing.JPanel Medicamente;
    private javax.swing.JPanel MenuPanel;
    private javax.swing.JPanel MiniPanelC;
    private javax.swing.JPanel MiniPanelC1;
    private javax.swing.JPanel MiniPanelPAC;
    private javax.swing.JPanel MiniPanelPAC1;
    private javax.swing.JPanel Nisip;
    private javax.swing.JPanel PanSup;
    private javax.swing.JPanel PanelC;
    private javax.swing.JPanel PanelJ;
    private javax.swing.JLabel PerMed;
    private javax.swing.JRadioButton PerioadaMed;
    private javax.swing.JLabel PreSup;
    private javax.swing.JRadioButton PrescriptieSup;
    private javax.swing.JTextField PretC;
    private javax.swing.JTextField PretJ;
    private javax.swing.JTextField PretMaxMed;
    private javax.swing.JTextField PretMaxSup;
    private javax.swing.JLabel PretMed;
    private javax.swing.JTextField PretMinMed;
    private javax.swing.JTextField PretMinSup;
    private javax.swing.JLabel PretSup;
    private javax.swing.JPanel ProduseIgiena;
    private javax.swing.JComboBox<String> RoMed;
    private javax.swing.JLabel RolMed;
    private javax.swing.JSlider SliderC;
    private javax.swing.JSlider SliderJ;
    private javax.swing.JTextArea TextAreaC;
    private javax.swing.JTextArea TextAreaJ;
    private javax.swing.JTextArea TextMed;
    private javax.swing.JTextArea TextSup;
    private javax.swing.JPanel Welcome;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton1Ig;
    private javax.swing.JButton jButton1N;
    private javax.swing.JButton jButtonCautare;
    private javax.swing.JComboBox<String> jComboBox1Ig;
    private javax.swing.JComboBox<String> jComboBox1N;
    private javax.swing.JComboBox<String> jComboBox2Ig;
    private javax.swing.JComboBox<String> jComboBox2N;
    private javax.swing.JComboBox<String> jComboBoxCategorieVarsta;
    private javax.swing.JComboBox<String> jComboBoxCuloare;
    private javax.swing.JComboBox<String> jComboBoxMateriale;
    private javax.swing.JComboBox<String> jComboBoxProducator;
    private javax.swing.JComboBox<String> jComboBoxProducatori;
    private javax.swing.JComboBox<String> jComboBoxTipAmbalaj;
    private javax.swing.JComboBox<String> jComboBoxTipMancare;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCulcus;
    private javax.swing.JLabel jLabelCusti;
    private javax.swing.JLabel jLabelCutiiTransport;
    private javax.swing.JLabel jLabelGramajGrame;
    private javax.swing.JLabel jLabelIg1;
    private javax.swing.JLabel jLabelIg2;
    private javax.swing.JLabel jLabelIg3;
    private javax.swing.JLabel jLabelMedicamente;
    private javax.swing.JLabel jLabelMeniu;
    private javax.swing.JLabel jLabelN1;
    private javax.swing.JLabel jLabelN2;
    private javax.swing.JLabel jLabelN3;
    private javax.swing.JLabel jLabelNisip;
    private javax.swing.JLabel jLabelPliabil;
    private javax.swing.JLabel jLabelPretLei;
    private javax.swing.JLabel jLabelProduseIgiena;
    private javax.swing.JLabel jLabelRecomandare;
    private javax.swing.JLabel jLabelSuplimente;
    private javax.swing.JList<String> jList1Ig;
    private javax.swing.JList<String> jList1N;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane1Ig;
    private javax.swing.JScrollPane jScrollPane1N;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane2Ig;
    private javax.swing.JScrollPane jScrollPane2N;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JSlider jSlider2;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTextArea jTextArea1Ig;
    private javax.swing.JTextArea jTextArea1N;
    private javax.swing.JTextArea jTextAreaCusti;
    private javax.swing.JTextArea jTextAreaCutiiTransport;
    private javax.swing.JTextArea jTextAreaRezultate;
    private javax.swing.JTextField jTextField1Ig;
    private javax.swing.JTextField jTextField1N;
    private javax.swing.JTextField jTextField2Ig;
    private javax.swing.JTextField jTextField2N;
    private javax.swing.JTextField jTextFieldGramajMax;
    private javax.swing.JTextField jTextFieldGramajMin;
    private javax.swing.JTextField jTextFieldGreutateAnimal;
    private javax.swing.JTextField jTextFieldPretMax;
    private javax.swing.JTextField jTextFieldPretMin;
    private javax.swing.JLabel labelHrana;
    private javax.swing.JLabel labelJucarii;
    private javax.swing.JLabel textCategorieVarsta;
    private javax.swing.JLabel textDividerGramaj;
    private javax.swing.JLabel textDividerPret;
    private javax.swing.JLabel textGramaj;
    private javax.swing.JLabel textInstructiune;
    private javax.swing.JLabel textPret;
    private javax.swing.JLabel textProducator;
    private javax.swing.JLabel textRezultate;
    private javax.swing.JLabel textTipAmbalaj;
    private javax.swing.JLabel textTipMancare;
    // End of variables declaration//GEN-END:variables
}
