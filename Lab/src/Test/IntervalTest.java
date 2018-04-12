package Test;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import Calcul.*;

public class IntervalTest {

  String csvLowerBound = "CSV/TEST_INTERVAL/LowerBound.csv";
  String csvUpperBound = "CSV/TEST_INTERVAL/UpperBound.csv";
  String csvInvalide = "CSV/TEST_INTERVAL/Invalide.csv";
  CSVReader reader = new CSVReader();

  /***
   * Test de Interval avec des donnees plus petite
   */
  @Test
  public void testIntervalLowerBound() {
    System.out.println("\n\tTest: Interval Lower Bound");
    IMethodeMath Interval = new IntervalConfiance();
    reader.setPath(csvLowerBound);
    List<String> listData = reader.read(null);
    Interval.calculer(listData, 0.0);

    String result = Interval.getString();

    String valeurAttendu = "[1 371,36 ; 1 725,45]-[1 251,2 ; 1 845,61]";

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
   * Test de Interval avec des donnees plus Grande
   */
  @Test
  public void testIntervalUpperBound() {
    System.out.println("\n\tTest: Interval Upper Bound");
    IMethodeMath Interval = new IntervalConfiance();
    reader.setPath(csvUpperBound);
    List<String> listData = reader.read(null);
    Interval.calculer(listData, 0.0);
    String result = Interval.getString();

    String valeurAttendu = "[-894,51 ; 15 495,6]-[-6 456,5 ; 21 057,59]";

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
   * Test de Interval avec des donnees invalide
   */
  @Test
  public void testIntervalTypeInvalide() {
    System.out.println("\n\tTest: Interval Invalide");
    IMethodeMath Interval = new IntervalConfiance();
    reader.setPath(csvInvalide);
    List<String> listData = reader.read(null);
    Interval.calculer(listData, 0.0);

    String result = Interval.getString();

    String valeurAttendu = "[0 ; 0]-[0 ; 0]";

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
