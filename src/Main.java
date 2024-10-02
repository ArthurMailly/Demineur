import java.awt.Point;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner lectureClavier = new Scanner(System.in);
        int niv=10;

        System.out.println("Bienvenue dans ce jeu du déminieur");
        Partie p;
        while(niv!=0){
            System.out.println("\nQuel niveau souhaitez-vous affronter ?");
            System.out.println("1: Débutant");
            System.out.println("2: Intermédiaire");
            System.out.println("3: Avancé");
            System.out.println("0: Quitter");
            niv=lectureClavier.nextInt();

            String niveau= "Débutant";
            //if (p.getNiveau().equals( "Débutant"));
            switch (niv) {
                case 1:
                    niveau = "Débutant";
                    break;
                case 2:
                    niveau = "Intermédiaire";
                    break;
                case 3:
                    niveau = "Avancé";
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Entrer une valeur valide");
                    break;
            }

            if ((niv>=1)&&(niv<=3)) {


                p = Partie.setInstance(niveau);
                p.afficher();

                int valeur = 10;
                while ((p.isEncours()) && (valeur != 0)) {
                    System.out.println("\nQue voulez-vous faire ?");
                    System.out.println("1: Marquer une case");
                    System.out.println("2: Dévoiler une case");
                    System.out.println("0: Quitter");
                    valeur = lectureClavier.nextInt();
                    System.out.println(" ");
                    switch (valeur) {
                        case 1:
                            Point pt1 = new Point(0, 0);
                            System.out.println("Entrer l'abscisse");
                            int y1 = lectureClavier.nextInt();
                            System.out.println("Entrer l'ordonnee");
                            int x1 = lectureClavier.nextInt();
                            pt1.setLocation(x1, y1);
                            p.marquerCase(pt1);
                            break;
                        case 2:
                            Point pt2 = new Point(0, 0);
                            System.out.println("Entrer l'abscisse");
                            int y2 = lectureClavier.nextInt();
                            System.out.println("Entrer l'ordonnee");
                            int x2 = lectureClavier.nextInt();
                            pt2.setLocation(x2, y2);
                            p.decouvrirCase(pt2);
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("Entrer une valeur valide");
                            break;
                    }
                    if (valeur!=0) {
                        p.afficher();
                        if (p.isEncours()) {
                            int reste = p.getNbMinesRestantes();
                            System.out.println("Il reste " + reste + " mines.\n");
                        }

                    }
                }
            }
        }
    }
}
