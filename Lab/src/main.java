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
	public static void createWindow()
	{
		
		CSVReader CSV = new CSVReader();
		
		JFrame frame = new JFrame();
		
		JPanel panel = new JPanel();
		JButton button = new JButton("Ouvrir fichier CSV");
		JLabel labelMoyenne = new JLabel("");
		JLabel labelVariance = new JLabel("");
		JLabel labelEcartType= new JLabel("");
		JLabel labelDataList = new JLabel("");
		JLabel labelCorrelation = new JLabel("");
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setSize(400, 400);
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		frame.setVisible(true); 
		
		
		
		
		
		//Bouton ouverture fichier CSV
		
        button.addActionListener(new ActionListener()
        {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				String absolutePath = null;
				
				fc.showOpenDialog(frame);
				fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				
				
				if(fc.getSelectedFile() != null)
				{
					absolutePath = fc.getSelectedFile().getAbsolutePath();
					
					DecimalFormat df = new DecimalFormat();
					df.setMaximumFractionDigits(2);
					
					
					
					try {
						
						//Fichier CSV Seulement
						if(absolutePath.endsWith(".csv"))
						{
							data = CSV.read(absolutePath);
							
							panel.add(labelDataList);
							panel.add(labelMoyenne);
							panel.add(labelVariance);
							panel.add(labelEcartType);
							panel.add(labelCorrelation);
							
							
							
						
							//Fichier CSV a plusieurs Colone
							if(!CSV.isCorrelation())
							{
								Moyenne.calculer(data,0.0);
								Variance.calculer(data, Moyenne.get());
								EcartType.calculer(data, Variance.get());
								
								labelMoyenne.setText("Moyenne: " + String.valueOf(df.format(Moyenne.get())));
								labelVariance.setText("Variance: " + String.valueOf(df.format(Variance.get())));
								labelEcartType.setText("Ecart-Type: " + String.valueOf(df.format(EcartType.get())));
								
								
								
								// Affichage des donnees du fichier CSV
								String textLabelData = "";
								textLabelData = "<html>Valeurs du fichier CSV:";
						
								for(int i = 1; i< data.size();i++)
								{
									textLabelData += "<br/>" + data.get(i);
								}
								
								textLabelData += "<br/><br/></html>";
								labelDataList.setText(textLabelData);
							}
							else //On cherche la correlation
							{
								labelMoyenne.setText("");
								labelVariance.setText("");
								labelEcartType.setText("");
								labelDataList.setText("");
								
								Correlation.calculer(data, 0.0);
								double correlation = Correlation.get();
								double correlation2 = correlation * correlation;
								String value =  String.valueOf(correlation);
								String value2 = String.valueOf(correlation2);
								String correlationType = "";
								
								if(correlation >= 0.0  && correlation < 0.2)
									correlationType = "Nulle ‡ faible";
								if(correlation >= 0.2  && correlation < 0.4)
									correlationType = "Faible ‡ moyenne";
								if(correlation >= 0.4  && correlation < 0.7)
									correlationType = "Moyenne ‡ forte";
								if(correlation >= 0.7  && correlation < 0.9)
									correlationType = "Forte ‡ trËs forte";
								if(correlation >= 0.9  && correlation <= 1)
									correlationType = "TrËs forte ‡ parfaite";
								
								
								labelCorrelation.setText("<html>Correlation R:  " + value + 
														 "<br>Correlation R<SUP>2</SUP>: " + value2 + 
														 "<br>Valeur nominal du lien: " + correlationType + "</html>");	
								
								
							}
							
							
							
							
							
						}
						else
						{
							throw new Exception("Erreur: Le fichier s√©lectionn√© n'est pas un fichier CSV.");
						}
							
					}
					catch(Exception ex)
					{
						System.out.println(ex.getMessage());
					}

				}
				
			}
        	});
        
		
		
		//Ajout des composants
        panel.add(button);
		
		frame.getContentPane().add(panel);	
		
		frame.setVisible(true); 
	}
	
	  

}
