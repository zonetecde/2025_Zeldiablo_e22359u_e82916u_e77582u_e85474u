package Zeldiablo.StrategieDeplacement;

import Zeldiablo.Direction;
import Zeldiablo.Entities.Monstre;
import Zeldiablo.Entities.Player;
import Zeldiablo.Labyrinthe;

import java.io.Serializable;

/**
 * Echec d'une tentative de déplacement vers le joueur. 
 * Ça a fait cette de stratégie de déplacement "Fuyard" qui permet au monstre de fuir le joueur.
 * Je le laisse car peut être intéressant pour une future implémentation (un monstre qui drop la clé de sortie?)
 */
public class DeplacementFuyard implements DeplacementStrategie, Serializable {
    @Override
    public void deplacement(Player joueur, Monstre monstre) {
        int[] prochainePosition = Labyrinthe.getSuivant(monstre.getY(), monstre.getX(), Direction.DROITE);
        if (joueur.getLabyrinthe().canEntityMoveTo(prochainePosition[0], prochainePosition[1])) {
            monstre.setPosition(prochainePosition[0], prochainePosition[1]);
        } else {
            prochainePosition = Labyrinthe.getSuivant(monstre.getY(), monstre.getX(), Direction.BAS);
            if (joueur.getLabyrinthe().canEntityMoveTo(prochainePosition[0], prochainePosition[1])) {
                monstre.setPosition(prochainePosition[0], prochainePosition[1]);
            } else {
                prochainePosition = Labyrinthe.getSuivant(monstre.getY(), monstre.getX(), Direction.GAUCHE);
                if (joueur.getLabyrinthe().canEntityMoveTo(prochainePosition[0], prochainePosition[1])) {
                    monstre.setPosition(prochainePosition[0], prochainePosition[1]);
                } else {
                    prochainePosition = Labyrinthe.getSuivant(monstre.getY(), monstre.getX(), Direction.HAUT);
                    if (joueur.getLabyrinthe().canEntityMoveTo(prochainePosition[0], prochainePosition[1])) {
                        monstre.setPosition(prochainePosition[0], prochainePosition[1]);
                    }
                }
            }
        }
    }

    public String toString(){return "Fuyard";}
}
