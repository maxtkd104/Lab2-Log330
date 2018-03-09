package Test;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import Calcul.*;

public class EcartTypeTest {

  String csvLowerBound = "CSV/TEST_VARIANCE/LowerBound.csv";
  String csvUpperBound = "CSV/TEST_VARIANCE/UpperBound.csv";
  String csvInvalide = "CSV/TEST_VARIANCE/Invalide.csv";
  CSVReader reader = new CSVReader();


  /***
   * Test de ecart type avec des donnees plus petite
   */
  @Test
  public void testEcartTypeLowerBound() {
    System.out.println("\n\tTest: Ecart-Type Lower Bound");
    double variance = 63057.87777777;
    IMethodeMath ecartType = new EcartType();
    reader.setPath(csvLowerBound);
    List<String> listData = reader.read(null);
    ecartType.calculer(listData, variance);
    double ecart = ecartType.getValue();

    String result = String.valueOf(ecart);

    String valeurAttendu = "251.11";

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
   * Test de ecart type avec des donnees plus Grande
   */
  @Test
  public void testEcartTypeUpperBound() {
    System.out.println("\n\tTest: Ecart-Type Upper Bound");
    double variance = 667524.72;
    IMethodeMath ecartType = new EcartType();
    reader.setPath(csvUpperBound);
    List<String> listData = reader.read(null);
    ecartType.calculer(listData, variance);
    double ecart = ecartType.getValue();

    String result = String.valueOf(ecart);

    String valeurAttendu = "817.02";

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
   * Test de ecart type avec des donnees invalide
   */
  @Test
  public void testEcartTypeInvalide() {
    System.out.println("\n\tTest: Ecart-Type Invalide");
    double variance = 0.0;
    IMethodeMath ecartType = new EcartType();
    reader.setPath(csvInvalide);
    List<String> listData = reader.read(null);
    ecartType.calculer(listData, variance);
    double ecart = ecartType.getValue();

    String result = String.valueOf(ecart);

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
