package Main;

import java.util.List;

public class AffichageHTML {

  /**
   * Html de la correlation pour l'affichage
   * 
   * @param correlation
   * @param valeurNominal
   * @return
   */
  public String afficher(List<String> data, int rowCount) {

    String ret = "";

    if (rowCount == 1) {
      String textLabelData = "";
      textLabelData = "<html><br/><a style=\"color: red\">Valeurs du fichier CSV:</a>";

      for (int i = 1; i < data.size(); i++) {
        textLabelData += "<br/>" + data.get(i);
      }

      textLabelData += "<br/><br/></html>";

      ret = textLabelData;
    }

    if (rowCount == 2) {
      String textLabelData = "";
      textLabelData = "<html><br/><a style=\"color: red\">Valeurs du fichier CSV:</a><table><td>";

      for (int i = 1; i < data.size(); i++) {
        String[] parts = data.get(i).split(";");

        textLabelData += parts[0] + "<br/>";
      }

      textLabelData += "</td><td>";
      for (int i = 1; i < data.size(); i++) {
        String[] parts = data.get(i).split(";");

        textLabelData += parts[1] + "<br/>";
      }

      textLabelData += "</td></tr></table><br/><br/></html>";

      ret = textLabelData;
    }

    return ret;
  }

  public String afficherEffortNote(String data) {
    String ret = "<html><table><tr>";
    ValeurCorrelation val = new ValeurCorrelation();
    String[] split = data.split(";");

    for (int i = 0; i < split.length; i++) {
      ret += "<td><a style=\"color: Red\">Correlation C" + (i + 1)
          + ":</a><br><a style=\"color: green\">Valeur de correlation: </a></td>" + "<td>" + "<td>"
          + split[i].replaceAll(";", "") + "<br>"
          + val.getNominalValueEffortNote(Double.parseDouble(split[i].replaceAll(";", ""))) + "</td></tr>";
    }

    ret += "</table></html>";

    return ret;
  }
}
