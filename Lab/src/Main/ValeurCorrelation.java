package Main;

/**
 * Cette calsse permet de determiner la valeur du lien nominal d'une correlation
 * 
 * @author Maxime
 *
 */
public class ValeurCorrelation {


  public String getNominalValue(double correlation) {
    String output = "";
    double abs = 0.0;

    if (correlation < 0.0)
      abs = correlation * -1;
    else
      abs = correlation;

    if (abs < 0.0)
      output = "Coeffecient negatif";
    if (abs >= 0.0 && abs < 0.2)
      output = "Nulle a faible";
    if (abs >= 0.2 && abs < 0.4)
      output = "Faible a moyenne";
    if (abs >= 0.4 && abs < 0.7)
      output = "Moyenne a forte";
    if (abs >= 0.7 && abs < 0.9)
      output = "Forte a tres forte";
    if (abs >= 0.9 && abs <= 1)
      output = "Tres forte a parfaite";

    return output;
  }
}
