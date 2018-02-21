package Calcul;

import java.util.List;

/**
 * Interface pour toute les classes de calcul
 * 
 * @author Maxime
 *
 */
public interface IMethodeMath {

  public double calculer(List<String> listDonner, double inputValue);

  public double get();
}
