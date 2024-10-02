import java.awt.Point;
import java.util.HashMap;
import java.util.Random;
import java.util.ArrayList;

public class Plateau {

    private int largeur;
    private  int hauteur;
    private int NbMinesIni;
    private HashMap<Point, Case> liste_cases;

    public Plateau()
    {
        largeur = 0;
        largeur = 0;
        liste_cases =new HashMap<Point,Case>();
    }

    public Plateau(int l, int h, int nbrMines)
    {
        int i=0;
        int j=0;
        int i2=0;
        int j2=0;
        largeur = l;
        hauteur = h;
        NbMinesIni=nbrMines;
        liste_cases =new HashMap<Point,Case>();
        for (i=0;i<hauteur;i++) {
            for (j=0; j<largeur; j++)
            {
                liste_cases.put(new Point(i,j),new CaseVide(new Point(i,j)));
            }
        }

        i=0;
        while (i<nbrMines) {
            Random r1 = new Random();
            Random r2 = new Random();
            int n1 =r1.nextInt(largeur);
            int n2 = r2.nextInt(hauteur);

            if (!(liste_cases.get(new Point(n1,n2))instanceof CaseMinee)) {
                i++;
                liste_cases.put(new Point(n1,n2),new CaseMinee());

                ArrayList<Point> liste_vois =new ArrayList<Point>();
                if (n1==0)
                {
                    if (n2==0){
                        liste_vois.add(new Point(1,0));
                        liste_vois.add(new Point(0,1));
                        liste_vois.add(new Point(1,1));
                    }
                    else if (n2==hauteur-1){
                        liste_vois.add(new Point(1,hauteur-2));
                        liste_vois.add(new Point(0,hauteur-2));
                        liste_vois.add(new Point(1,hauteur-1));
                    }
                    else{
                        liste_vois.add(new Point(0,n2-1));
                        liste_vois.add(new Point(0,n2+1));
                        liste_vois.add(new Point(1,n2-1));
                        liste_vois.add(new Point(1,n2));
                        liste_vois.add(new Point(1,n2+1));
                    }
                }
                else if (n1==largeur-1){
                    if (n2==0){
                        liste_vois.add(new Point(largeur-2,0));
                        liste_vois.add(new Point(largeur-2,1));
                        liste_vois.add(new Point(largeur-1,1));
                    }
                    else if (n2==hauteur-1){
                        liste_vois.add(new Point(largeur-2,hauteur-2));
                        liste_vois.add(new Point(largeur-1,hauteur-2));
                        liste_vois.add(new Point(largeur-2,hauteur-1));
                    }
                    else{
                        liste_vois.add(new Point(largeur-1,n2-1));
                        liste_vois.add(new Point(largeur-1,n2+1));
                        liste_vois.add(new Point(largeur-2,n2-1));
                        liste_vois.add(new Point(largeur-2,n2));
                        liste_vois.add(new Point(largeur-2,n2+1));
                    }
                }
                else if (n2==0){
                    liste_vois.add(new Point(n1-1,0));
                    liste_vois.add(new Point(n1+1,0));
                    liste_vois.add(new Point(n1-1,1));
                    liste_vois.add(new Point(n1,1));
                    liste_vois.add(new Point(n1+1,1));
                }
                else if (n2==hauteur-1){
                    liste_vois.add(new Point(n1-1,hauteur-1));
                    liste_vois.add(new Point(n1+1,hauteur-1));
                    liste_vois.add(new Point(n1-1,hauteur-2));
                    liste_vois.add(new Point(n1,hauteur-2));
                    liste_vois.add(new Point(n1+1,hauteur-2));
                }
                else {
                    liste_vois.add(new Point(n1-1,n2-1));
                    liste_vois.add(new Point(n1-1,n2));
                    liste_vois.add(new Point(n1-1,n2+1));
                    liste_vois.add(new Point(n1+1,n2-1));
                    liste_vois.add(new Point(n1+1,n2));
                    liste_vois.add(new Point(n1+1,n2+1));
                    liste_vois.add(new Point(n1,n2-1));
                    liste_vois.add(new Point(n1,n2+1));

                }

                for (Point pt: liste_vois) {
                    Case cv=liste_cases.get(pt);
                    if (cv instanceof CaseNumerotee) {
                        ((CaseNumerotee) cv).incNbVoisinesMinees();
                    }
                    else if (cv instanceof CaseVide){
                        liste_cases.put(pt,new CaseNumerotee(pt,1));

                    }
                }
            }
        }
        for (i=0;i<hauteur;i++)
        {
            for (j =0;j<largeur;j++)
            {
                for (i2 = i-1; i2 <i+2; i2++)
                {
                    for (j2 = j-1; j2 <j+2; j2++)
                    {
                        if ((0<=i2) && (0<=j2) && (i2 < hauteur) && (j2 < largeur))
                        {
                            if ((i2!=i) || (j2!=j))
                                liste_cases.get(new Point(i,j)).ajouterVoisine(liste_cases.get(new Point(i2,j2)));
                        }
                    }
                }
            }
        }

    }


    public boolean testerSiGagne()
    {
        int verif=0;

        for (int i=0;i<hauteur;i++) {
            for (int j=0; j<largeur; j++)
            {
                if (liste_cases.get(new Point(i,j)).getEtatCourant()instanceof EtatDecouverte)
                {
                    verif++;
                }
            }
        }

        if (verif== largeur*hauteur-NbMinesIni)
        {
            return true;
        }
        else
            return false;
    }

    public void marquerCase(Point pt)
    {
        if ((pt.x>=0)&&(pt.y>=0)&&(pt.x<hauteur)&&(pt.y<largeur))
            liste_cases.get(pt).marquer();
        else{
            System.out.println("Vous n'avez pas rentré une case valide");
        }
    }


    public void decouvrirCase(Point pt) {
        if ((pt.x>=0)&&(pt.y>=0)&&(pt.x<hauteur)&&(pt.y<largeur))
            liste_cases.get(pt).decouvrir();
        else{
            System.out.println("Vous n'avez pas rentré une case valide");
        }

    }

    public void afficher() {
        System.out.print("  ");
        for (int j = 0; j < largeur; j++)
        {
            if (j<10)
                System.out.print("   "+j);
            else
                System.out.print("  "+j);
        }
        System.out.println("");
        for (int i = 0; i < hauteur; i++) {
            System.out.print(i);
            if (i<10)
            {
                System.out.print(" ");
            }
            System.out.print(" ");
            for (int j = 0; j < largeur; j++) {
                System.out.print("  ");
                liste_cases.get(new Point(i,j)).afficher();
                System.out.print(" ");
            }
            System.out.println(" ");
        }
    }

    public HashMap<Point, Case> getListe_cases(){
        return liste_cases;
    }
}