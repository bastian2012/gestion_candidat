package projetintra;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class code {
    Scanner sc = new Scanner(System.in);
    Scanner scan = new Scanner(System.in);

    public char sexe() {
        int choix;
        System.out.println("\n1- Masculin\n2- Feminin\n");
        choix = borne(1, 2);
        if (choix == 1) {
            return 'M';
        }
        return 'F';
    }

    public void ecrire(String e,String fileName){
        // File dos=new File("Concours");
        // dos.mkdir();
        File fic=new File(fileName);
        try {
        
            FileWriter fw = new FileWriter(fic, true);
            fw.append(e);
            
            fw.close();
        } catch (IOException ex) {
            System.out.println("une erreur s'est produite");
        }
    }

    public void ModeEcrire(String fileName) {
        // File dos=new File("Concours");
        // dos.mkdir();
        File fic=new File(fileName);
        try {
            FileWriter fw = new FileWriter(fic);
        
            fw.close();
        } catch (IOException ex) {
            System.out.println("une erreur s'est produite");
        }
    }

    public String postName() {
        int choix;
        System.out.println("\n1- Programmation\n2- DataBase\n3- Reseau\n");
        choix = borne(0, 3);
        if (choix == 0) {
            return null;
        } else if (choix == 1) {
            return "Programmation";

        } else if (choix == 2) {
            return "DataBase";
        }
        return "Reseau";
    }

    public int intervalle(int n) {
        int a = contrainte(sc);
        while (a < 0 || a > n) {
            System.out.println("La Note doit etre superieure a et  inferieure ou egal a " + n);
            a = contrainte(sc);
        }
        return a;
    }

    public boolean testInt(String n) {
        boolean resultat = true;
        for (int i = 0; i < n.length(); i++) {
            char c = n.charAt(i);
            if (!Character.isDigit(c)) {
                resultat = false;
                break;
            }
        }
        return resultat;
    }

    public void break_() {
        int e = 0;
        while (e == 0) {
            break;

        }
    }

    public int contrainte(Scanner sc) {
        int result = 0;
        String option2 = sc.nextLine();
        while (testInt(String.valueOf(option2)) == false || option2.isEmpty()) {
            System.out.print("entrer une une valeur numerique :  ");
            option2 = sc.nextLine();
        }
        result = Integer.parseInt(option2);
        return result;
    }

    public int borne(int x, int y) {

        int result = contrainte(sc);
        while (result < x || result > y) {
            System.out.println("choix incorrect,Veuillez reessayer : ");

            result = contrainte(sc);
        }
        return result;
    }

    /**
     * @param nbre
     * @return
     */

    public double contrainteFloat() {
        double a = 0.0;
        String str = scan.nextLine();
        isFloat(str);
        while (!isFloat(str)) {
            System.out.println("Invalid number !!!");
            isFloat(str);
        }

        return a;
    }

    public boolean isFloat(String str) {
        boolean verify = true;
        for (int i = 0; i < str.length(); i++) {
            char a = str.charAt(0);
            char b = str.charAt(str.length() - 1);
            if (a == '.' || b == '.') {
                verify = false;
            }
        }
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            verify = false;
        }

        return verify;
    }

    public double confirmFloat() {
        System.out.println("\nSaisir un nonbre entier ou a virgule\n\n\t\tNB la virgule est remplase par un point\n");
        String a = scan.nextLine();

        while (!isFloat(a)) {
            System.out.print("SAisir un nombre entier ou a virgule: ");
            a = scan.nextLine();
        }
        double b = Double.parseDouble(a);
        return b;
    }

    public double goodFloat(double e) {
        double a = confirmFloat();
        while (a < 0 || a > e) {
            System.out.println("\nNombre superieur a 0 et inferieur a " + e);
            a = confirmFloat();
        }

        return a;
    }
}


