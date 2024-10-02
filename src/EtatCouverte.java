public class EtatCouverte extends EtatCase{

    public void decouvrir(Case c){
        c.setEtatCourant(new EtatDecouverte());
        c.devoiler();
    }

    public void marquer(Case c){
        Partie.getInstance().decrNbMines();
        c.setEtatCourant(new EtatMarquee());
    }
}
