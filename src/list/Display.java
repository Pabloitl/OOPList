
package list;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class Display {
    
    public void select(){
        JPanel panel = new JPanel();
        JLabel title = new JLabel("Ciudades por visitar");
        JLabel city  = new JLabel("Seleccione");
        JLabel icon  = new JLabel();
        ImageIcon imag = new ImageIcon(new ImageIcon("src/view/teotihuacán.png")
                .getImage().getScaledInstance(380, 350, Image.SCALE_SMOOTH));
        
        UIManager.put("OptionPane.minimumSize", new Dimension(550, 480));
        
        title.setFont(new Font("Castellar", Font.BOLD, 30));
        title.setBounds(50, 0, 500, 40);
        
        city.setBounds(395, 100, 100, 20);
        
        icon.setIcon(imag);
        icon.setBounds(0, 60, 400, 350);
        
        panel.setLayout(null);
        panel.add(title);
        panel.add(city);
        panel.add(icon);
        panel.setVisible(true);
        
        JOptionPane.showMessageDialog(null, 
                                        panel, 
                                        "Ciudades por visitar", 
                                        JOptionPane.DEFAULT_OPTION);
    }
    
    public void city(City c){
        JPanel panel = new JPanel();
        JLabel title = new JLabel("Ciudades por visitar");
        JLabel lCity  = new JLabel("Ciudad");
        JLabel lCountry = new JLabel("País");
        JLabel lContinent = new JLabel("Continente");
        JLabel lTemperature = new JLabel(String.valueOf("Temperatura"));
        JLabel lInformation = new JLabel("Información");
        JLabel eCity  = new JLabel(c.getName());
        JLabel eCountry = new JLabel(c.getContry());
        JLabel eContinent = new JLabel(c.getContinent());
        JLabel eTemperature = new JLabel(String.valueOf(c.getTemperature()+"°"));
        JLabel eInformation = new JLabel(c.getInformation());
        JLabel icon = new JLabel();
        ImageIcon imag = new ImageIcon(new ImageIcon(c.getPath())
                .getImage().getScaledInstance(400, 390, Image.SCALE_SMOOTH));
        
        UIManager.put("OptionPane.minimumSize", new Dimension(600, 500));
        
        title.setFont(new Font("Castellar", Font.BOLD, 30));
        title.setBounds(70, 0, 500, 40);
        
        lCity.setFont(new Font("AR JULIAN", Font.BOLD, 20));
        lCity.setBounds(410, 50, 200, 30);
        eCity.setFont(new Font("Clarendon Blk BT", Font.PLAIN, 20));
        eCity.setForeground(Color.blue);
        eCity.setBounds(420, 75, 350, 30);
        
        lCountry.setFont(new Font("AR JULIAN", Font.BOLD, 20));
        lCountry.setBounds(410, 110, 200, 20);
        eCountry.setFont(new Font("Clarendon Blk BT", Font.PLAIN, 20));
        eCountry.setForeground(Color.blue);
        eCountry.setBounds(420, 135, 300, 30);
        
        lContinent.setFont(new Font("AR JULIAN", Font.BOLD, 20));
        lContinent.setBounds(410, 170, 200, 20);
        eContinent.setFont(new Font("Clarendon Blk BT", Font.PLAIN, 20));
        eContinent.setForeground(Color.blue);
        eContinent.setBounds(420, 195, 300, 30);
        
        lTemperature.setFont(new Font("AR JULIAN", Font.BOLD, 20));
        lTemperature.setBounds(410, 230, 200, 20);
        eTemperature.setFont(new Font("Clarendon Blk BT", Font.PLAIN, 30));
        eTemperature.setForeground(Color.orange);
        eTemperature.setBounds(420, 255, 100, 30);
        
        lInformation.setFont(new Font("AR JULIAN", Font.BOLD, 20));
        lInformation.setBounds(410, 290, 200, 20);
        
        icon.setIcon(imag);
        icon.setBounds(0, 50, 400, 390);
        
        panel.setLayout(null);
        panel.add(title);
        panel.add(lCity);
        panel.add(lCountry);
        panel.add(lContinent);
        panel.add(lTemperature);
        panel.add(lInformation);
        panel.add(eCity);
        panel.add(eCountry);
        panel.add(eContinent);
        panel.add(eTemperature);
        panel.add(eInformation);
        panel.add(icon);
        panel.setVisible(true);
        
        JOptionPane.showMessageDialog(null, 
                                        panel, 
                                        "Ciudades por visitar", 
                                        JOptionPane.DEFAULT_OPTION);
    }
}
