public class EtatMarquee extends EtatCase{

    public void decouvrir(Case c){

    }

    public void marquer(Case c) {
        Partie.getInstance().incrNbMines();
        c.setEtatCourant(new EtatCouverte());
    }
}
