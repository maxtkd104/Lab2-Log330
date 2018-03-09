package Test;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import Calcul.*;

public class VarianceTest {

  String csvLowerBound = "CSV/TEST_VARIANCE/LowerBound.csv";
  String csvUpperBound = "CSV/TEST_VARIANCE/UpperBound.csv";
  String csvInvalide = "CSV/TEST_VARIANCE/Invalide.csv";
  CSVReader reader = new CSVReader();


  /***
   * Test de la variance avec des donnees plus petites
   */
  @Test
  public void testVarianceLowerBound() {
    // assertTrue(true);

    System.out.println("\n\tTest: Variance LowerBound");
    double moyenne = 253.9;
    IMethodeMath variance = new Calcul.Variance();
    reader.setPath(csvLowerBound);
    List<String> listData = reader.read(null);
    variance.calculer(listData, moyenne);
    double var = variance.getValue();

    String result = String.valueOf(var);


    if (result.startsWith("63057.877")) {
      System.out
          .println("Succes: La valeur " + result + " correspond a la valeur attendu: 63057.877");

    } else {
      System.out.println(
          "Erreur: La valeur " + result + " ne correspond pas a la valeur attendu: 63057.877");
      fail(result + " ne correspond pas a la valeur attendu 63057.877");
    }
  }


  /***
   * Test de la variance avec des donnees plus Grande
   */
  @Test
  public void testVarianceUpperBound() {
    // assertTrue(true);

    System.out.println("\n\tTest: Variance UpperBound");
    double moyenne = 1580.5;
    IMethodeMath variance = new Calcul.Variance();
    CSVReader reader = new CSVReader();
    reader.setPath(csvUpperBound);
    List<String> listData = reader.read(null);
    variance.calculer(listData, moyenne);
    double var = variance.getValue();

    String result = String.valueOf(var);


    if (result.startsWith("667524.72")) {
      System.out
          .println("Succes: La valeur " + result + " correspond a la valeur attendu: 667524.722");

    } else {
      System.out.println(
          "Erreur: La valeur " + result + " ne correspond pas a la valeur attendu: 667524.722");
      fail(result + " ne correspond pas a la valeur attendu 667524.722");
    }
  }


  /***
   * Test de la variance avec des donnees invalides
   */
  @Test
  public void testVarianceInvalideValue() {
    // assertTrue(true);

    System.out.println("\n\tTest: Variance Invalide");
    double moyenne = 1580.5;
    IMethodeMath variance = new Calcul.Variance();
    CSVReader reader = new CSVReader();

    double var = 0.0;
    reader.setPath(csvInvalide);
    List<String> listData = reader.read(null);
    variance.calculer(listData, moyenne);
    var = variance.getValue();


    String result = String.valueOf(var);


    if (result.startsWith("0.0")) {
      System.out.println("Succes: La valeur " + result + " correspond a la valeur attendu: 0.0");

    } else {
      System.out
          .println("Erreur: La valeur " + result + " ne correspond pas a la valeur attendu: 0.0");
      fail(result + " ne correspond pas a la valeur attendu 0.0");
    }
  }

}
