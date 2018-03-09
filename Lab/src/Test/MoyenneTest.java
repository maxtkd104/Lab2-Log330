package Test;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import Calcul.*;

public class MoyenneTest {

  String csvLowerBound = "CSV/TEST_VARIANCE/LowerBound.csv";
  String csvUpperBound = "CSV/TEST_VARIANCE/UpperBound.csv";
  String csvInvalide = "CSV/TEST_VARIANCE//Invalide.csv";
  CSVReader reader = new CSVReader();

  /***
   * Test de la Moyenne avec des donnees plus petite
   */
  @Test
  public void testeMoyenneLowerBound() {
    System.out.println("\n\tTest: Moyenne Lower Bound");
    IMethodeMath moyenne = new Moyenne();
    reader.setPath(csvLowerBound);
    List<String> listData = reader.read(null);
    moyenne.calculer(listData, 0.0);
    double moy = moyenne.getValue();
    String result = String.valueOf(moy);

    String valeurAttendu = "253.9";

    if (result.startsWith(valeurAttendu)) {
      System.out.println(
          "Succes: La valeur " + result + " correspond a la valeur attendu: " + valeurAttendu);
    } else {
      System.out.println("Erreur: La valeur " + result + " ne correspond pas a la valeur attendu: "
          + valeurAttendu);
      fail(result + " ne correspond pas a la valeur attendu " + valeurAttendu);
    }
  }

  /***
   * Test de la moyenne avec des donnees plus Grande
   */
  @Test
  public void testMoyenneUpperBound() {
    System.out.println("\n\tTest: Moyenne Upper Bound");
    IMethodeMath moyenne = new Moyenne();
    reader.setPath(csvUpperBound);
    List<String> listData = reader.read(null);
    moyenne.calculer(listData, 0.0);
    double moy = moyenne.getValue();
    String result = String.valueOf(moy);

    String valeurAttendu = "1580.5";

    if (result.startsWith(valeurAttendu)) {
      System.out.println(
          "Succes: La valeur " + result + " correspond a la valeur attendu: " + valeurAttendu);
    } else {
      System.out.println("Erreur: La valeur " + result + " ne correspond pas a la valeur attendu: "
          + valeurAttendu);
      fail(result + " ne correspond pas a la valeur attendu " + valeurAttendu);
    }
  }

  /***
   * Test de la moyenne avec des donnees invalides
   */
  @Test
  public void testMoyenneInvalideValue() {
    System.out.println("\n\tTest: Moyenne Invalide");
    IMethodeMath moyenne = new Moyenne();
    reader.setPath(csvInvalide);
    List<String> listData = reader.read(null);
    moyenne.calculer(listData, 0.0);
    double moy = moyenne.getValue();
    String result = String.valueOf(moy);

    String valeurAttendu = "0.0";

    if (result.startsWith(valeurAttendu)) {
      System.out.println(
          "Succes: La valeur " + result + " correspond a la valeur attendu: " + valeurAttendu);
    } else {
      System.out.println("Erreur: La valeur " + result + " ne correspond pas a la valeur attendu: "
          + valeurAttendu);
      fail(result + " ne correspond pas a la valeur attendu " + valeurAttendu);
    }
  }

}
