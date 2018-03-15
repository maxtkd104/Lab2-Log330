package Calcul;

import java.util.List;

/**
 * Interface pour toute les classes de calcul
 * 
 * @author Maxime
 *
 */
public interface IMethodeMath {

  public void calculer(List<String> listDonner, double inputValue);

  public String getString();

  public double getValue();
}
