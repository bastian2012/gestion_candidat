package projetintra;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author Jean-Ritchy Bastien
 */
public class Programmation extends Informaticien {
    private double noteProgramme;
    private double noteQuestion1;
    private double noteQuestion2;
    private double noteQuestion3;
    ArrayList<Programmation> tabPro = new ArrayList<>();
    code co = new code();

    public double getNoteProgramme() {
        return noteProgramme;

    }
    public void setNoteProgramme(double noteProgramme) {
        this.noteProgramme = noteProgramme;
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

    public Programmation(double noteProgramme, double noteQuestion1, double noteQuestion2, double noteQuestion3,
            String nom, String prenom, String code, String option, char sexe) {
        super(nom, prenom, code, option, sexe);
        this.noteProgramme = noteProgramme;
        this.noteQuestion1 = noteQuestion1;
        this.noteQuestion2 = noteQuestion2;
        this.noteQuestion3 = noteQuestion3;

    }

    public Programmation() {
    }

    @Override
    public String toString() {
        return super.toString() + "Note Pour le Programme :  " + noteProgramme + "/500 pts\n" + "Note question 1 : "
                + noteQuestion1 + "/200 pts\n" + "Note question 2 : " + noteQuestion2 + "/150 pts\n"
                + "Note question 3 : " + noteQuestion3 + " /150 pts\nMoyenne : " + getMoyenne() + "\n";
    }

    Scanner scan = new Scanner(System.in);
    Scanner scanInt = new Scanner(System.in);

    @Override
    public Informaticien enregistrer() {
        // System.out.print("etape 1 succes !!");
        Programmation prog = new Programmation();
        Informaticien Info = new Informaticien();
        Info = super.enregistrer();
        prog.setNom(Info.getNom());
        prog.setPrenom(Info.getPrenom());
        prog.setSexe(Info.getSexe());
        prog.setCode(Info.getCode());
        prog.setOption("Programmation");
        System.out.print("Note pour le programme : ");
        prog.setNoteProgramme(co.goodFloat(500));
        System.out.print("'\n");
        System.out.print("Note pour la premiere question : ");
        prog.setNoteQuestion1(co.goodFloat(150));
        System.out.print("\n");
        System.out.print("Note pour la deuxieme question : ");
        prog.setNoteQuestion2(co.goodFloat(150));
        System.out.println();
        System.out.print("Note pour la troisieme question : ");

        prog.setNoteQuestion3(co.goodFloat(150));
        double e = ((Info.getMoyenne() + prog.getNoteProgramme() + prog.getNoteQuestion1() + prog.getNoteQuestion2()
                + prog.getNoteQuestion3())/950);
        prog.setMoyenne(e*100);

        System.out.println();
        
        co.ecrire(prog.toString_(), "Programmation.txt");
        return null;
    }
    public String toString_(){
         return  (getNom() + "!" + getPrenom() + "!" + getCode() + "!"
         + getOption() + "!" + getSexe() + "!" +getNoteProgramme() + "!"
         + getNoteQuestion1() + "!"
         +getNoteQuestion2() + "!" + getNoteQuestion3() + "!"
         + getMoyenne()
         + "\n");
    }

    public ArrayList candidProgrammation(String fileName) {
        File file = new File(fileName + ".txt");
        ArrayList<Programmation> tabTemp = new ArrayList<>();
        String mots[] = null;
        try {
            Scanner sc = new Scanner(file);
            
            while (sc.hasNextLine()){
                Programmation pro = new Programmation();
                mots = sc.nextLine().split("!");
                pro.setNom(mots[0]);
                pro.setPrenom(mots[1]);
                pro.setCode(mots[2]);
                pro.setOption((mots[3]));
                pro.setSexe((mots[4]).charAt(0));
                pro.setNoteProgramme(Double.parseDouble((mots[5])));
                Double a = (Double.parseDouble((mots[5])));
                pro.setNoteQuestion1(Double.parseDouble(mots[6]));
                pro.setNoteQuestion2(Double.parseDouble(mots[7]));
                pro.setNoteQuestion3(Double.parseDouble(mots[8]));
                pro.setMoyenne(Double.parseDouble(mots[9]));
                tabTemp.add(pro);
                myTemp.add(pro);
            }
        } catch (Exception ex) {
        }

        return tabTemp;
    }
    public void afficherCandidatProgrammation() {
        ArrayList<Informaticien> t = new ArrayList<>();
        t = candidProgrammation("Programmation");
        if (t.size()==0) {
            System.out.println("\n\n\t\tAucun candidat en programmation\n\n");
        }
        for (Informaticien in : t) {
            System.out.println(in);
        }
    }
}