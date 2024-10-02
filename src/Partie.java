import java.awt.Point;

public class Partie
{
    private static Partie uniqueInstance = null;
    private Plateau plateau;
    private int nbMinesInitiales;
    protected int nbMinesRestantes;
    private String niveau;
    private boolean encours;
    private boolean resultat;

    private Partie()
    {
        resultat = false;
        encours = true;
        niveau = "Débutant";
        nbMinesRestantes=10;
        nbMinesInitiales=10;
        plateau = new Plateau(9,9,nbMinesInitiales);
    }

    private Partie(String niv)
    {
        resultat = false;
        encours = true;
        niveau = niv;

        if (niveau.equals("Débutant"))
        {
            nbMinesRestantes=10;
            nbMinesInitiales=10;
            plateau = new Plateau(9,9,nbMinesInitiales);
        }
        else if (niveau.equals("Intermédiaire"))
        {
            nbMinesRestantes=40;
            nbMinesInitiales=40;
            plateau = new Plateau(16,16,nbMinesInitiales);
        }
        else if (niveau.equals("Avancé"))
        {
            nbMinesRestantes=99;
            nbMinesInitiales=99;
            plateau = new Plateau(30,16,nbMinesInitiales);
        }


    }

    public static Partie setInstance(String niveau)
    {
        uniqueInstance = new Partie (niveau);
        return uniqueInstance;
    }

    public static Partie getInstance()
    {
        return uniqueInstance;
    }

    public int getNbMinesRestantes()
    {
        return nbMinesRestantes;
    }

    public int getNbMinesInitiales()
    {
        return nbMinesInitiales;
    }

    public String getNiveau()
    {
        return niveau;
    }

    public boolean isResultat()
    {
        return resultat;
    }

    public boolean isEncours()
    {
        return encours;
    }

    public void marquerCase(Point pt)
    {
        plateau.marquerCase(pt);
    }

    public void decouvrirCase(Point pt)
    {
        plateau.decouvrirCase(pt);
    }

    public void decrNbMines()
    {
        nbMinesRestantes--;
    } //exceptions

    public void incrNbMines()
    {
        nbMinesRestantes++;
    } //exceptions

    public void perdre()
    {
        encours = false;
        System.out.println("Tu as perdu !");
    }

    public void testerSiGagne()
    {
        if (plateau.testerSiGagne() == true)
        {
            encours = false;
            resultat = true;
            System.out.println("Tu as gagné !");
        }
    }

    public void afficher()
    {
        plateau.afficher();
    }
}
