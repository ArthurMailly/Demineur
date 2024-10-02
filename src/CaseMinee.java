import java.awt.Point;

public class CaseMinee extends Case{

    public CaseMinee(){}

    public CaseMinee(Point coord){super(coord);}

    public void devoiler(){
        Partie.getInstance().perdre();
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
            System.out.print("B");
        }

    }
}