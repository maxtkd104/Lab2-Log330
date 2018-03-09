package Test;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;

import Calcul.*;

public class EcartTypeTest {

  String csvLowerBound = "CSV_TEST/LowerBound.csv";
  String csvUpperBound = "CSV_TEST/UpperBound.csv";
  String csvInvalide = "CSV_TEST/Invalide.csv";
  CSVReader reader = new CSVReader();


  /***
   * Test de ecart type avec des donnees plus petite
   */
  @Test
  public void testEcartTypeLowerBound() {
    System.out.println("\n\tTest: Ecart-Type Lower Bound");
    double variance = 63057.87777777;
    IMethodeMath ecartType = new EcartType();
    List<String> listData = reader.read(csvLowerBound);
    double ecart = ecartType.calculer(listData, variance);

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
    List<String> listData = reader.read(csvUpperBound);
    double ecart = ecartType.calculer(listData, variance);

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
    List<String> listData = reader.read(csvInvalide);
    double ecart = ecartType.calculer(listData, variance);

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
