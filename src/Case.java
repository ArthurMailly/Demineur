import java.util.ArrayList;
import java.awt.Point;
abstract class Case {
    private Point Coordonnee;
    private EtatCase etatCourant;
    private ArrayList<Case> voisines;

    public Case()
    {
        Coordonnee =new Point(-1,-1);
        etatCourant= new EtatCouverte();
        voisines = new ArrayList<Case>();
    }

    public Case(Point c)
    {
        Coordonnee=c;
        etatCourant= new EtatCouverte();
        voisines = new ArrayList<Case>();
    }

    public void marquer() {
        etatCourant.marquer(this);
    }

    public void decouvrir(){
        etatCourant.decouvrir(this);
    }

    public abstract void devoiler();

    public void setEtatCourant(EtatCase e){
        etatCourant = e;
    }

    public abstract void afficher();

    public Point getCoordonnee(){
        return Coordonnee;
    }

    public EtatCase getEtatCourant() { return etatCourant; }

    public ArrayList<Case> getVoisine(){
        return voisines;
    }

    public void ajouterVoisine(Case c){ voisines.add(c); }

}