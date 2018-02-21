import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.*;
import Calcul.*;


public class main {

  private static List<String> data;
  private static IMethodeMath Moyenne;
  private static IMethodeMath Variance;
  private static IMethodeMath EcartType;
  private static IMethodeMath Correlation;

  public static void main(String[] args) {
    // TODO Auto-generated method stub


    Moyenne = new Moyenne();
    Variance = new Variance();
    EcartType = new EcartType();
    Correlation = new Correlation();
    createWindow();
  }



  /**
   * Cette fonction permet d'afficher le menu GUI
   */
  public static void createWindow() {

    CSVReader CSV = new CSVReader();

    JFrame frame = new JFrame();

    JPanel panel = new JPanel();
    JButton button = new JButton("Ouvrir fichier CSV");
    JLabel labelMoyenne = new JLabel("");
    JLabel labelVariance = new JLabel("");
    JLabel labelEcartType = new JLabel("");
    JLabel labelDataList = new JLabel("");
    JLabel labelCorrelation = new JLabel("");

    AffichageHTML html = new AffichageHTML();


    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 400);
    panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
    frame.setVisible(true);



    // Bouton ouverture fichier CSV

    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JFileChooser fc = new JFileChooser();
        String absolutePath = null;

        fc.showOpenDialog(frame);
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);


        if (fc.getSelectedFile() != null) {
          absolutePath = fc.getSelectedFile().getAbsolutePath();

          DecimalFormat df = new DecimalFormat();
          df.setMaximumFractionDigits(2);



          try {

            // Fichier CSV Seulement
            if (absolutePath.endsWith(".csv")) {
              data = CSV.read(absolutePath);

              panel.add(labelDataList);
              panel.add(labelMoyenne);
              panel.add(labelVariance);
              panel.add(labelEcartType);
              panel.add(labelCorrelation);

              labelMoyenne.setText("");
              labelVariance.setText("");
              labelEcartType.setText("");
              labelDataList.setText("");
              labelCorrelation.setText("");



              // Fichier CSV a plusieurs Colone
              if (!CSV.isCorrelation()) {
                Moyenne.calculer(data, 0.0);
                Variance.calculer(data, Moyenne.get());
                EcartType.calculer(data, Variance.get());

                labelMoyenne.setText("Moyenne: " + String.valueOf(df.format(Moyenne.get())));
                labelVariance.setText("Variance: " + String.valueOf(df.format(Variance.get())));
                labelEcartType.setText("Ecart-Type: " + String.valueOf(df.format(EcartType.get())));



                // Affichage des donnees du fichier CSV

                labelDataList.setText(html.affichageCSV1ColoneL(data));
              } else // On cherche la correlation
              {
                labelMoyenne.setText("");
                labelVariance.setText("");
                labelEcartType.setText("");
                labelDataList.setText("");

                Correlation.calculer(data, 0.0);
                ValeurCorrelation valeurCorrelation = new ValeurCorrelation();

                double correlation = Correlation.get();
                String valeurNomimal = valeurCorrelation.getNominalValue(correlation);

                labelCorrelation.setText(html.correlationHTML(correlation, valeurNomimal));


              }



            } else {
              throw new Exception("Erreur: Le fichier sélectionné n'est pas un fichier CSV.");
            }

          } catch (Exception ex) {
            System.out.println(ex.getMessage());
          }

        }

      }
    });



    // Ajout des composants
    panel.add(button);

    frame.getContentPane().add(panel);

    frame.setVisible(true);
  }



}
