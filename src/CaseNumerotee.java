import java.awt.*;

public class CaseNumerotee extends Case{

    private int NbVoisinesMinees;

    public CaseNumerotee()
    {
        NbVoisinesMinees = 1;
    }

    public CaseNumerotee(Point coord,int NbVM)
    {
        super(coord);
        NbVoisinesMinees = NbVM;
    }

    public void devoiler()
    {
        Partie.getInstance().testerSiGagne();
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
            System.out.print(NbVoisinesMinees);
        }

    }

    public void incNbVoisinesMinees()
    {
        NbVoisinesMinees++;
    }
}
