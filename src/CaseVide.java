import java.awt.*;
import java.util.ArrayList;

public class CaseVide extends Case{

    public CaseVide(){}

    public CaseVide(Point coord){super(coord);}

    public void devoiler()
    {
        Partie.getInstance().testerSiGagne();

        if (Partie.getInstance().isEncours())
        {
            int s;
            ArrayList<Case> vois;
            vois=getVoisine();

            s = getVoisine().size();
            for(int i=0; i<s ;i++)
            {
                vois.get(i).decouvrir();
            }
        }
    }

    public void afficher()
    {
        EtatCase etat;
        etat=this.getEtatCourant();

        if (etat instanceof EtatCouverte)
        {
            System.out.print("*");
        }
        else if (etat instanceof EtatMarquee)
        {
            System.out.print("M");
        }
        else
        {
            System.out.print(" ");
        }

    }
}
