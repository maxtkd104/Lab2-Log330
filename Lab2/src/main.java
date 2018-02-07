import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.*;

import Calcul.IMethodeMath;
import Calcul.Moyenne;
import Calcul.CSVReader;
import Calcul.EcartType;
import Calcul.Variance;


public class main {
	
	private static List<String> data;
	private static IMethodeMath Moyenne;
	private static IMethodeMath Variance;
	private static IMethodeMath EcartType;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Moyenne = new Moyenne();
		Variance = new Variance();
		EcartType = new EcartType();
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
				absolutePath = fc.getSelectedFile().getAbsolutePath();
				
				if(fc.getSelectedFile() !=null)
				{
					DecimalFormat df = new DecimalFormat();
					df.setMaximumFractionDigits(2);
					
					
					
					try {
						
						//Fichier CSV Seulement
						if(absolutePath.endsWith(".csv"))
						{
							data = CSV.read(absolutePath);
							Moyenne.calculer(data,0.0);
							Variance.calculer(data, Moyenne.get());
							EcartType.calculer(data, Variance.get());
							
							labelMoyenne.setText("Moyenne: " + String.valueOf(df.format(Moyenne.get())));
							labelVariance.setText("Variance: " + String.valueOf(df.format(Variance.get())));
							labelEcartType.setText("Ecart-Type: " + String.valueOf(df.format(EcartType.get())));
							
							String textLabelData = "<html>Valeurs du fichier CSV:";
							for(int i = 1; i< data.size();i++)
							{
								textLabelData += "<br/>" + data.get(i);
							}
							textLabelData += "<br/><br/></html>";
							
							labelDataList.setText(textLabelData);
						}
						else
						{
							throw new Exception("Erreur: Le fichier sélectionné n'est pas un fichier CSV.");
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
		panel.add(labelDataList);
		panel.add(labelMoyenne);
		panel.add(labelVariance);
		panel.add(labelEcartType);

		
		frame.getContentPane().add(panel);	
		
		frame.setVisible(true); 
	}
	
	  

}
