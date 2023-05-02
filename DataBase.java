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
public class DataBase extends Informaticien {
    private double noteConceptionDataBase;
    private double noteQuestion;
    private double noteQuestion2;
    // private double moyenne;

    ArrayList<DataBase> tabData = new ArrayList<>();
    code co = new code();

    public double getNoteConceptionDataBase() {
        return noteConceptionDataBase;
    }

    public void setNoteConceptionDataBase(double noteConceptionDataBase) {
        this.noteConceptionDataBase = noteConceptionDataBase;
    }

    public double getNoteQuestion() {
        return noteQuestion;
    }

    public void setNoteQuestion(double noteQuestion) {
        this.noteQuestion = noteQuestion;
    }

    public double getNoteQuestion2() {
        return noteQuestion2;
    }

    public void setNoteQuestion2(double noteQuestion2) {
        this.noteQuestion2 = noteQuestion2;
    }

    @Override
    public Informaticien enregistrer() {
        DataBase data = new DataBase();
        Informaticien Info = new Informaticien();
        // TODO Auto-generated method stub
        Info = super.enregistrer();
        data.setNom(Info.getNom());
        data.setPrenom(Info.getPrenom());
        data.setSexe(Info.getSexe());
        data.setCode(Info.getCode());
        data.setOption("Base de donnee");
        System.out.print("Note pour la conception de base de donnee");
        data.setNoteConceptionDataBase(co.goodFloat(300));
        System.out.print("Note pour la premiere question : ");
        data.setNoteQuestion(co.goodFloat(250));
        System.out.print("\n");
        System.out.print("Note pour la deuxieme question : ");
        data.setNoteQuestion2(co.goodFloat(250));
        double e = (Info.getMoyenne() + data.getNoteConceptionDataBase() + data.getNoteQuestion()
                + data.getNoteQuestion2())/800;
        data.setMoyenne(e * 100);
        System.out.println();
 

        co.ecrire(data.toString_(), "DataBase.txt");
        return null;
    }

    public String toString_(){
        return (getNom() + "!" + getPrenom() + "!" + getCode()
        + "!" + getOption() + "!" + getSexe() + "!"
        + getNoteConceptionDataBase() + "!" + getNoteQuestion() + "!"
        + getNoteQuestion2() + "!" + getMoyenne() + "\n");
    }

    public ArrayList candidatDatabase(String fileName) {

        File file = new File(fileName + ".txt");
        ArrayList<DataBase> tabTemp = new ArrayList<>();
        String mots[] = null;
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
            DataBase pro = new DataBase();
                mots = sc.nextLine().split("!");
                pro.setNom(mots[0]);
                pro.setPrenom(mots[1]);
                pro.setCode(mots[2]);
                pro.setOption((mots[3]));
                pro.setSexe((mots[4]).charAt(0));
                pro.setNoteConceptionDataBase(Double.parseDouble((mots[5])));
                pro.setNoteQuestion(Double.parseDouble(mots[6]));
                pro.setNoteQuestion2(Double.parseDouble(mots[7]));
                pro.setMoyenne(Double.parseDouble(mots[8]));
                tabTemp.add(pro);
                myTemp.add(pro);
            }
        } catch (Exception ex) {
        }
        return tabTemp;
    }

    public void afficherCandidatDataBase() {
        ArrayList<Informaticien> t = new ArrayList<>();
        t = candidatDatabase("DataBase");
        if (t.size()==0) {
            System.out.println("\n\n\t\tAucun candidat en DataBase !!!\n\n");
        } else {
            for (Informaticien in : t) {
                System.out.println(in);
            }
        }
        
    }

    @Override
    public String toString() {
        return super.toString() + "\nnote Conception DataBase : " + noteConceptionDataBase + "\nnoteQuestion : "
                + noteQuestion
                + "\nnoteQuestion2 : " + noteQuestion2 + "\nMoyenne" + getMoyenne() + "\n";
    }

}