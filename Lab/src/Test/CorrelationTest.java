package Test;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import Calcul.*;

public class CorrelationTest {

  String csvLowerBound = "CSV_TEST_CORRELATION/LowerBound.csv";
  String csvUpperBound = "CSV_TEST_CORRELATION/UpperBound.csv";
  String csvInvalide = "CSV_TEST_CORRELATION/Invalide.csv";
  CSVReader reader = new CSVReader();


  /***
   * Test de correlation avec des donnees plus petite
   */
  @Test
  public void testCorrelationLowerBound() {
    System.out.println("\n\tTest: Ecart-Type Lower Bound");
    IMethodeMath correlation = new Correlation();
    List<String> listData = reader.read(csvLowerBound);
    double corre = correlation.calculer(listData, 0.0);

    String result = String.valueOf(corre);

    String valeurAttendu = "0.91227001418853";

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
   * Test de correlation avec des donnees plus Grande
   */
  @Test
  public void testCorrelationUpperBound() {
    System.out.println("\n\tTest: Ecart-Type Upper Bound");
    IMethodeMath correlation = new Correlation();
    List<String> listData = reader.read(csvUpperBound);
    double corre = correlation.calculer(listData, 0.0);

    String result = String.valueOf(corre);

    String valeurAttendu = "0.13244518444069";

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
   * Test de correlation avec des donnees invalide
   */
  @Test
  public void testCorrelationTypeInvalide() {
    System.out.println("\n\tTest: Correlation Invalide");
    IMethodeMath correlation = new Correlation();
    List<String> listData = reader.read(csvInvalide);
    double corre = correlation.calculer(listData, 0.0);

    String result = String.valueOf(corre);

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
