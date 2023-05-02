/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetintra;
import java.io.File;
import java.util.*;
/**
 *
 * @author Jean-Ritchy Bastien
 */
public class Reseau extends Informaticien {
    private double noteREseauLocal;
    private double noteQuestion1;
    private double noteQuestion2;
    private double noteQuestion3;
    private double noteQuestion4;
    //private double moyenne;
    ArrayList <Reseau> tabRes=new ArrayList<>();
    code co=new code();
    public double getNoteREseauLocal() {
        return noteREseauLocal;
    }
    public void setNoteREseauLocal(double noteREseauLocal) {
        this.noteREseauLocal = noteREseauLocal;
    }
    public double getNoteQuestion1() {
        return noteQuestion1;
    }
    public void setNoteQuestion1(double noteQuestion1) {
        this.noteQuestion1 = noteQuestion1;
    }
    public double getNoteQuestion2() {
        return noteQuestion2;
    }
    public void setNoteQuestion2(double noteQuestion2) {
        this.noteQuestion2 = noteQuestion2;
    }
    public double getNoteQuestion3() {
        return noteQuestion3;
    }
    public void setNoteQuestion3(double noteQuestion3) {
        this.noteQuestion3 = noteQuestion3;
    }
    public double getNoteQuestion4() {
        return noteQuestion4;
    }
    public void setNoteQuestion4(double noteQuestion4) {
        this.noteQuestion4 = noteQuestion4;
    }
    
@Override
public Informaticien enregistrer() {
    // TODO Auto-generated method stub
    Informaticien info= new Informaticien();
    Reseau res= new Reseau();
    info= super.enregistrer();
    res.setNom(info.getNom());
    res.setPrenom(info.getPrenom());
    res.setSexe(info.getSexe());
    res.setCode(info.getCode());
    res.setOption("Reseau");
    System.out.println();
    System.out.print("Note pour la mise en Reseau : ");
    res.setNoteREseauLocal(co.goodFloat(250));
    System.out.println();
    System.out.print("Note pour la premiere Question : ");
    res.setNoteQuestion1(co.goodFloat(150));
    System.out.println();

    System.out.print("Note pour la deuxieme Question : ");
    res.setNoteQuestion2(co.goodFloat(200));
    System.out.println();

    System.out.print("Note pour la troisieme Question : ");
    res.setNoteQuestion3(co.goodFloat(250));
    System.out.println();

    System.out.print("Note pour la quatrieme Question : ");
    res.setNoteQuestion4(co.goodFloat(300));
    double o=(((info.getMoyenne()+ res.getNoteREseauLocal()+res.getNoteQuestion1()+res.getNoteQuestion2()+res.getNoteQuestion3()+res.getNoteQuestion4())/1150));
    res.setMoyenne(o*100);
    System.out.println();
    
    co.ecrire(res.tostrString_(), "Reseau.txt");
    return null;
}
    public String tostrString_(){
        return ( getNom() + "!" + getPrenom() + "!" + getCode()
        + "!" + getOption() + "!" + getSexe() + "!"
        + getNoteREseauLocal() + "!" + getNoteQuestion1() + "!"
        + getNoteQuestion2() + "!" + getNoteQuestion3()+ "!" + getNoteQuestion4()
        + "!"+getMoyenne()+"\n");
    }

public ArrayList candidatReseau(String fileName) {
    ArrayList <Informaticien>tb=new ArrayList<>();
    try {
        File file1 = new File(fileName + ".txt");
        String mots1[] = null;
        Scanner sc1 = new Scanner(file1);
        while (sc1.hasNextLine()){
        Reseau pro1= new Reseau();
            mots1 = sc1.nextLine().split("!");
            pro1.setNom(mots1[0]);
            pro1.setPrenom(mots1[1]);
            pro1.setCode(mots1[2]);
            pro1.setOption((mots1[3]));
            pro1.setSexe((mots1[4]).charAt(0));
            pro1.setNoteREseauLocal(Double.parseDouble((mots1[5])));
            Double a=(Double.parseDouble((mots1[5])));
            pro1.setNoteQuestion1(Double.parseDouble(mots1[6]));
            pro1.setNoteQuestion2(Double.parseDouble(mots1[7]));
            pro1.setNoteQuestion3(Double.parseDouble(mots1[8]));
            pro1.setNoteQuestion4(Double.parseDouble(mots1[9]));
            pro1.setMoyenne(Double.parseDouble(mots1[10]));
            tb.add(pro1);
            myTemp.add(pro1);

        }
    } catch (Exception ex) {}
    //System.out.println(tabTemp);
    return tb;
}

public void afficherCandidatReseau(){
    ArrayList <Informaticien> t=new ArrayList<>();
    t=candidatReseau("Reseau");

    if (t.size()==0) {
        System.out.println("\n\n\t\tAucun candidats en Reseau !!!\n\n");
    } else {
        for (Informaticien in : t) {
            System.out.println(in);
        }
    }
    
}

@Override
public String toString() {
    return super.toString()+ "\nnote REseau Local : " + noteREseauLocal + "\nnote Question 1 : " + noteQuestion1 + "\nnoteQuestion2 : "
            + noteQuestion2 + "\nnoteQuestion3 : " + noteQuestion3 + "\nnoteQuestion4 : " + noteQuestion4 + "\nMoyenne : "+getMoyenne()+"\n";
}


}


