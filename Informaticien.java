/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetintra;
import java.util.*;
import java.time.LocalDateTime;
/**
 *
 * @author Jean-Ritchy Bastien
 */
public class Informaticien {
    private String nom;
    private String prenom;
    private String code;
    private String option=null;
    private char sexe;
    private double moyenne=0;
    LocalDateTime d;
    code co=new code();
    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }
    

    public Informaticien() {
    }

    @Override
    public String toString() {
        return "nom : " + nom + "\nprenom : " + prenom + "\ncode : " + code + "\noption : " + option + "\nsexe : " + sexe;
    }

    public Informaticien(String nom, String prenom, String code, String option, char sexe) {
        this.nom = nom;
        this.prenom = prenom;
        this.code = code;
        this.option = option;
        this.sexe = sexe;
    }

public static ArrayList<Informaticien> tabInfo = new ArrayList<>();
public static ArrayList<Informaticien> myTemp = new ArrayList<>();
public static ArrayList<Informaticien> tabArrayList = new ArrayList<>();


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public char getSexe() {
        return sexe;
    }

    public void setSexe(char sexe) {
        this.sexe = sexe;
    }
    
public String toString_(){
    return "";
}


    Scanner scan=new Scanner(System.in);
    Scanner scanInt=new Scanner(System.in);
    
    public Informaticien enregistrer(){
        Informaticien Info = new Informaticien();
        code co= new code();
        String tp;
        do {
            System.out.print("Entrer votre nom : ");
            tp=scan.nextLine();
        } while (tp.isEmpty());
        Info.setNom(tp);
    
    System.out.print("\n");
    Info.setMoyenne(0);
    System.out.print("\n");
    String tp2;
    do {
        System.out.print("Entrer votre Prenom : ");
        tp2=scan.nextLine();
    } while (tp2.isEmpty());
    Info.setPrenom(tp2);


    System.out.print("\n");
    System.out.print("Entrer votre Sexe : ");
    Info.setSexe(co.sexe());
    System.out.print("\n");
    
    
    
    d=LocalDateTime.now();
    
    Info.setCode((Info.getNom().substring(0,1)+Info.getPrenom().substring(0,1)+Info.getSexe()+"-"+d.getDayOfMonth()+d.getSecond()+d.getMinute()).toUpperCase());
    return Info;
    }
    public double getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(double moyenne) {
        this.moyenne = moyenne;
    }

}