package Calcul;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import Main.CreateWindow;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {


  private int rowCount = 0;
  private String path = "";

  /**
   * Lis un fichier CSV ligne par ligne et retourne les donnees sous forme de tableu de int
   * 
   * @param filePath
   * @return tableau des donnees a tester
   */
  public List<String> read(CreateWindow frame) {

    List<String> data = new ArrayList<String>();
    String absolutePath = null;
    // Aucun fichier n'est specifie
    if (path.equals("")) {
      JFileChooser fc = new JFileChooser();
      fc.showOpenDialog(frame);
      fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
      if (fc.getSelectedFile() != null) {
        absolutePath = fc.getSelectedFile().getAbsolutePath();
      }
    } else {
      absolutePath = path;
    }

    if (absolutePath != null && absolutePath != "") {

      File file = new File(absolutePath);

      try {
        Scanner inputStream = new Scanner(file);
        inputStream.useDelimiter("\r");
        while (inputStream.hasNext()) {
          String dataText = inputStream.next();
          data.add(dataText.replaceAll("\n", ""));

        }
        inputStream.close();


        String[] parts = null;

        if (data.get(1).contains(";"))
          parts = data.get(1).split(";");
        else
          parts = data.get(1).split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");

        rowCount = parts.length;


      } catch (FileNotFoundException e) {

        e.printStackTrace();
      }
    }



    return data;
  }

  /**
   * Set the path manually
   */
  public void setPath(String pathToSet) {
    path = pathToSet;
  }

  /**
   * @return the isCorrelation
   */
  public int getRowCount() {
    return rowCount;
  }

}
