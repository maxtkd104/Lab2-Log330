package Test;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import Calcul.*;

public class RegressionTest {

  String csvLowerBound = "CSV/TEST_REGRESSION/LowerBound.csv";
  String csvUpperBound = "CSV/TEST_REGRESSION/UpperBound.csv";
  String csvInvalide = "CSV/TEST_REGRESSION/Invalide.csv";
  String csv = "CSV/TEST_REGRESSION/dataRegression.csv";
  CSVReader reader = new CSVReader();


  /***
   * Test de regression avec des donnees plus petite
   */
  @Test
  public void testRegressionLowerBound() {
    System.out.println("\n\tTest: Regression Lower Bound");
    Regression regression = new Regression();
    reader.setPath(csvLowerBound);
    List<String> listData = reader.read(null);
    regression.calculer(listData);

    String b1 = regression.getPente();
    String b2 = regression.getConstante();


    String resultb1 = "-0.03739";
    String resultb2 = "214.96982";;


    if (b1.startsWith(resultb1) && b2.startsWith(resultb2)) {
      System.out
          .println("Succes: La valeur " + b1 + " correspond a la valeur attendu: " + resultb1);
      System.out
          .println("Succes: La valeur " + b2 + " correspond a la valeur attendu: " + resultb2);

    } else {
      System.out.println("Erreur: La valeur " + b1 + " et " + b2
          + " ne correspond pas a la valeur attendu: " + resultb1 + " et " + resultb2);
      fail(b1 + " et " + b2 + " ne correspond pas a la valeur attendu " + resultb1 + " et "
          + resultb2);
    }

  }


  /***
   * Test de regression avec des donnees plus Grande
   */
  @Test
  public void testCorrelationUpperBound() {
    System.out.println("\n\tTest: Regression Upper Bound");
    Regression regression = new Regression();
    reader.setPath(csvUpperBound);
    List<String> listData = reader.read(null);
    regression.calculer(listData);

    String b1 = regression.getPente();
    String b2 = regression.getConstante();


    String resultb1 = "-0.29091";
    String resultb2 = "993.86771";


    if (b1.equals(resultb1) && b2.equals(resultb2)) {
      System.out
          .println("Succes: La valeur " + b1 + " correspond a la valeur attendu: " + resultb1);
      System.out
          .println("Succes: La valeur " + b2 + " correspond a la valeur attendu: " + resultb2);

    } else {
      System.out.println("Erreur: La valeur " + b1 + " et " + b2
          + " ne correspond pas a la valeur attendu: " + resultb1 + " et " + resultb2);
      fail(b1 + " et " + b2 + " ne correspond pas a la valeur attendu " + resultb1 + " et "
          + resultb2);
    }

  }

  /***
   * Test de correlation avec des donnees invalide
   */
  @Test
  public void testCorrelationTypeInvalide() {
    System.out.println("\n\tTest: Regression Invalide");
    Regression regression = new Regression();
    reader.setPath(csvInvalide);
    List<String> listData = reader.read(null);
    regression.calculer(listData);

    String b1 = regression.getPente();
    String b2 = regression.getConstante();


    String resultb1 = "0.0";
    String resultb2 = "0.0";;


    if (b1.startsWith(resultb1) && b2.startsWith(resultb2)) {
      System.out
          .println("Succes: La valeur " + b1 + " correspond a la valeur attendu: " + resultb1);
      System.out
          .println("Succes: La valeur " + b2 + " correspond a la valeur attendu: " + resultb2);

    } else {
      System.out.println("Erreur: La valeur " + b1 + " et " + b2
          + " ne correspond pas a la valeur attendu: " + resultb1 + " et " + resultb2);
      fail(b1 + " et " + b2 + " ne correspond pas a la valeur attendu " + resultb1 + " et "
          + resultb2);
    }

  }
  
  /***
   * Test trouver X avec Y
   */
  @Test
  public void testFindX() {
    System.out.println("\n\tTest: Trouver X avec Y");
    Regression regression = new Regression();
    reader.setPath(csv);
    List<String> listData = reader.read(null);
    regression.calculer(listData);

    String x = regression.calculateXFromY("58");


    String result = "46.61794";


    if (x.equals(result)) {
      System.out
          .println("Succes: La valeur " + x + " correspond a la valeur attendu: " + result);
      
    } else {
      System.out.println("Erreur: La valeur " + x + " ne correspond pas a la valeur attendu: " + result);
      fail(x + " ne correspond pas a la valeur attendu " + result);
    }
  }
  
  /***
   * Test trouver Y avec X
   */
  @Test
  public void testFindY() {
    System.out.println("\n\tTest: Trouver Y avec X");
    Regression regression = new Regression();
    reader.setPath(csv);
    List<String> listData = reader.read(null);
    regression.calculer(listData);

    String y = regression.calculateYFromX("58");


    String result = "77.66741";


    if (y.equals(result)) {
      System.out
          .println("Succes: La valeur " + y + " correspond a la valeur attendu: " + result);
      
    } else {
      System.out.println("Erreur: La valeur " + y + " ne correspond pas a la valeur attendu: " + result);
      fail(y + " ne correspond pas a la valeur attendu " + result);
    }
  }

}
