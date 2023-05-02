package projetintra;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Jean-Ritchy Bastien
 */
public class NewClass {
    Programmation Pro = new Programmation();
    DataBase data = new DataBase();
    Reseau res = new Reseau();

    public ArrayList<Informaticien> tabAll() {
        Informaticien inf = new Informaticien();
        inf.tabArrayList = Pro.candidProgrammation("Programmation");
        inf.tabArrayList.addAll(data.candidatDatabase("DataBase"));
        inf.tabArrayList.addAll(res.candidatReseau("Reseau"));

        return inf.tabArrayList;
    }

    public Informaticien moyenneMax() {
        ArrayList<Informaticien> nw = new ArrayList<>();
        nw.addAll(data.candidatDatabase("DataBase"));
        nw.addAll(Pro.candidProgrammation("Programmation"));
        nw.addAll(res.candidatReseau("Reseau"));
        Informaticien inf = new Informaticien();
        double e = 0;
        for (Informaticien i : nw) {
            if (i.getMoyenne() > e) {
                e = i.getMoyenne();
                inf = i;
            }
        }
    
        return inf;
    }
    public void afficherMoyenneMax(){
        Informaticien in=moyenneMax();
        if (in.getNom()==(null)&&in.getPrenom()==(null)&&in.getCode()==(null)){
            System.out.println("\n\n\t\tAucun candidat enregistrer\n\n");
        } else {
            System.out.println(in.toString());
        }
    }

    public Informaticien maxMoy(ArrayList a) {
        Informaticien inf = new Informaticien();
        double e = 0;
        for (Informaticien i : inf.tabArrayList) {
            if (i.getMoyenne() > e) {
                e = i.getMoyenne();
                inf = i;
            }
        }
        return inf;
    }
    public Informaticien minMoy(ArrayList a) {
        Informaticien inf = new Informaticien();
        double e = 100;
        for (Informaticien i : inf.tabArrayList) {
            if (i.getMoyenne() < e) {
                e = i.getMoyenne();
                inf = i;
            }
        }
        return inf;
    }

    public ArrayList cinqPremier() {
        ArrayList<Informaticien> tb = new ArrayList<>();
        ArrayList<Informaticien> tb2 = new ArrayList<>();
        Informaticien in = new Informaticien();
        tb = tabAll();
        int i = 0;
        do {
            in = maxMoy(tb);
            tb2.add(in);
            tb.remove(in);
            i++;
        } while (i < 5);
        return tb2;
    }

    public void affichercinqLaureat() {
        ArrayList<Informaticien> in = new ArrayList<>();
        ArrayList<Informaticien> tb = new ArrayList<>();
        tb = tabAll();
        in = cinqPremier();
        if (tb.size()==0) {
            System.out.println("\n\n\t\tAucun candidats enregistrer !!!\n\n");
        }
        else if (tb.size() < 5) {
            System.out.println("I\n\n\t\tl n'y a que  " + tb.size() + " candidats enegistrer \n\n");
        } else {
            for (Informaticien t : in) {
                System.out.println(t);
            }
        }
    }

    public ArrayList deleteSemblable(ArrayList<Informaticien> tab,Informaticien inf){
        for (Informaticien in : tab) {
            if (in.getMoyenne()==inf.getMoyenne()) {
                tab.remove(in);
            }
            else{
                continue;
            }
        }
        return tab;
    }

    public ArrayList addSemblable(ArrayList<Informaticien> tab,Informaticien inf){
        for (Informaticien in : tab) {
            if (in.getMoyenne()==inf.getMoyenne()) {
                tab.remove(in);
            }
            else{
                continue;
            }
        }
        return tab;
    }
    public void supprimer() {
        ArrayList<Informaticien> infox = new ArrayList<>();
        infox = tabAll();
        Informaticien in = new Informaticien();
        in = minMoy(infox);
        try {
            infox.remove(in);
            File file = new File("Programmation.txt");
            File file_ = new File("DataBase.txt");
            File file__ = new File("Reseau.txt");
            FileWriter fw___ = null;
            FileWriter fw_ = null;
            FileWriter fw__ = null;
            fw___ = new FileWriter(file);
            fw_ = new FileWriter(file_);
            fw__ = new FileWriter(file__);

            for (Informaticien prog : infox) {

                if (prog instanceof Programmation) {
                    File file1 = new File("Programmation.txt");
        FileWriter fw1 = null;
        try {
            fw1 = new FileWriter(file1, true);
            fw1.write(prog.toString_());
            fw1.close();
        } catch (IOException ex) { }
                }
            if (prog instanceof DataBase) {
                    File file2 = new File("DataBase.txt");
        FileWriter fw2 = null;
        try {
            fw2 = new FileWriter(file2, true);
            fw2.write(prog.toString_());
            fw2.close();
        } catch (IOException ex) { }
                }
                if (prog instanceof Reseau)
                {
                    File file2 = new File("Reseau.txt");
        FileWriter fw2 = null;
        try {
            fw2 = new FileWriter(file2, true);
            fw2.write(prog.toString_());
            fw2.close();
        } catch (IOException ex) { }
                }
                
            }
            fw___.close();
            fw_.close();
            fw__.close();

        } catch (IOException ex) {
        }
    }


    public void goodDelete(){
        ArrayList<Informaticien> infox2 = new ArrayList<>();
        infox2 = tabAll();
        if (infox2.size()<5) {
            System.out.println("\n\n\t\tOn ne peut pas supprimer les 4 derniers il n'y a que "+infox2.size()+" candidats\n\n");
        } else {
            int o=0;
            do {
                supprimer();
                o++;
            } while (o<4);
        }
    }


    public void depart() {
        code co = new code();

        NewClass nw = new NewClass();
        Scanner scan = new Scanner(System.in);
        int exit = 0;
        do {
            System.out.print(
                    "\n1- enregistrer\n2- afficher les candidats selon un domaine\n3- Afficher tous les Candidat\n4- Afficher le laureat du concours\n5- les 5 premier laureats\n6- delete cinq dernier\n0- sortir");
            System.out.print("veuiller faire un choix : ");
            int choix;
            choix = co.borne(0, 6);
            System.out.println("\n\n");
            switch (choix) {
                case 1:
                    System.out.print("Choisir une option !!!");
                    String option = co.postName();
                    switch (option) {
                        case "Programmation":
                            Pro.enregistrer();
                            break;
                        case "DataBase":
                            data.enregistrer();
                            break;
                        case "Reseau":
                            res.enregistrer();
                            break;
                        case "null":
                            break;
                    }
                    break;
                case 2:
                    System.out.print(
                            "1- afficher tous les candidats en Programmation\n2- afficher tous les candidats en Base de Donnee\n3- afficher tous les candidats en Reseau\n0- Retour\n\n\n\t\tVeuiller choisir une option : ");
                    int choix1 = co.borne(0, 3);
                    switch (choix1) {
                        case 1:
                            Pro.afficherCandidatProgrammation();

                            break;
                        case 2:
                            data.afficherCandidatDataBase();

                            break;
                        case 3:
                            res.afficherCandidatReseau();
                            break;
                        case 0:
                            break;
                    }
                    break;
                case 0:
                    System.exit(choix);
                    break;

                case 3:
                    Pro.afficherCandidatProgrammation();
                    data.afficherCandidatDataBase();
                    res.afficherCandidatReseau();
                    break;
                case 4:
                afficherMoyenneMax();
                    break;
                case 5:
                    affichercinqLaureat();
                    break;

                case 6:
                    goodDelete();
                    break;

                default:
                    break;
            }

        } while (exit == 0);

    }
}
