
package list;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Display {
    
    public static int showOptions(String...args){
        JPanel panel = new JPanel();
        JLabel title = new JLabel("Ciudades por visitar");
        JLabel icon  = new JLabel();
        ImageIcon imag = new ImageIcon(new ImageIcon("src/data/montreal.jpg")
                .getImage().getScaledInstance(480, 350, Image.SCALE_SMOOTH));
        String [] option = {"Añadir ciudad" , "Mostrar ciudad"};
        
        UIManager.put("OptionPane.minimumSize", new Dimension(500, 430));
        
        title.setFont(new Font("Castellar", Font.BOLD, 30));
        title.setBounds(20, 0, 500, 40);
        
        icon.setIcon(imag);
        icon.setBounds(0, 60, 480, 350);
        
        panel.setLayout(null);
        panel.add(title);
        panel.add(icon);
        panel.setVisible(true);
        
        int op = JOptionPane.showOptionDialog(null, panel,  
                                        "Ciudades por visitar", 
                                        JOptionPane.DEFAULT_OPTION, 
                                        -1, null, option, null);
        return op;
    }
    
    public static City registry(){
        JPanel panel = new JPanel();
        JTextField city = new JTextField();
        JTextField country = new JTextField();
        JTextField continent = new JTextField();
        JTextField temperature = new JTextField();
        JTextField information = new JTextField();
        JTextField path = new JTextField();
        JLabel lCity  = new JLabel("Ciudad");
        JLabel lCountry = new JLabel("País");
        JLabel lContinent = new JLabel("Continente");
        JLabel lTemperature = new JLabel("Temperatura");
        JLabel lInformation = new JLabel("Información");
        JLabel lPath = new JLabel("Ruta de imagen");
        JLabel icon = new JLabel();
        ImageIcon imag = new ImageIcon(new ImageIcon(
                "src/data/catedral-san-basilio.jpg")
                .getImage().getScaledInstance(225, 230, Image.SCALE_SMOOTH));
        
        UIManager.put("OptionPane.minimumSize", new Dimension(600, 250));
        
        lCity.setBounds(210, 10, 80, 20);
        lCountry.setBounds(210, 40, 100, 20);
        lContinent.setBounds(210, 70, 100, 20);
        lTemperature.setBounds(210, 100, 100, 20);
        lInformation.setBounds(210, 130, 200, 20);
        lPath.setBounds(210, 160, 200, 20);
        
        city.setBounds(310, 10, 150, 20);
        country.setBounds(310, 40, 150, 20);
        continent.setBounds(310, 70, 150, 20);
        temperature.setBounds(310, 100, 50, 20);
        information.setBounds(310, 130, 250, 20);
        path.setBounds(310, 160, 250, 20);
        
        icon.setIcon(imag);
        icon.setBounds(0, 0, 200, 230);
        
        panel.setLayout(null);
        panel.add(lCity);
        panel.add(lCountry);
        panel.add(lContinent);
        panel.add(lTemperature);
        panel.add(lInformation);
        panel.add(lPath);
        panel.add(city);
        panel.add(country);
        panel.add(continent);
        panel.add(temperature);
        panel.add(information);
        panel.add(path);
        panel.add(icon);
        panel.setVisible(true);
        
        do{
        JOptionPane.showMessageDialog(null, panel, "Registro de ciudad", 
                                        JOptionPane.DEFAULT_OPTION);
        }while(!campos(city, country, continent, temperature,information,path));
        return new City(city.getText(), country.getText(), continent.getText(), 
                        Float.parseFloat(temperature.getText()), 
                        information.getText(), path.getText());
    }
    
    public static boolean campos(JTextField...args){
        for(JTextField j: args){
            String c = j.getText();
            
            //c es vacío o c es de longitud cero
            
            if(c == null || c.isEmpty()) 
                return false;
        }
        
        return true;
    }
    
    public static City editRegistry(City c){
        JPanel panel = new JPanel();
        JTextField city = new JTextField();
        JTextField country = new JTextField();
        JTextField continent = new JTextField();
        JTextField temperature = new JTextField();
        JTextField information = new JTextField();
        JTextField path = new JTextField();
        JLabel lCity  = new JLabel("Ciudad");
        JLabel lCountry = new JLabel("País");
        JLabel lContinent = new JLabel("Continente");
        JLabel lTemperature = new JLabel("Temperatura");
        JLabel lInformation = new JLabel("Información");
        JLabel lPath = new JLabel("Ruta de imagen");
        JLabel icon = new JLabel();
        ImageIcon imag = new ImageIcon(new ImageIcon(
                "src/data/catedral-san-basilio.jpg")
                .getImage().getScaledInstance(225, 230, Image.SCALE_SMOOTH));
        
        UIManager.put("OptionPane.minimumSize", new Dimension(600, 250));
        
        city.setText(c.getName());
        country.setText(c.getCountry());
        continent.setText(c.getContinent());
        temperature.setEditable(false);
        information.setText(c.getInformation());
        path.setText(c.getPath());
        
        lCity.setBounds(210, 10, 80, 20);
        lCountry.setBounds(210, 40, 100, 20);
        lContinent.setBounds(210, 70, 100, 20);
        lTemperature.setBounds(210, 100, 100, 20);
        lInformation.setBounds(210, 130, 200, 20);
        lPath.setBounds(210, 160, 200, 20);
        
        city.setBounds(310, 10, 150, 20);
        country.setBounds(310, 40, 150, 20);
        continent.setBounds(310, 70, 150, 20);
        temperature.setBounds(310, 100, 50, 20);
        information.setBounds(310, 130, 250, 20);
        path.setBounds(310, 160, 250, 20);
        
        icon.setIcon(imag);
        icon.setBounds(0, 0, 200, 230);
        
        panel.setLayout(null);
        panel.add(lCity);
        panel.add(lCountry);
        panel.add(lContinent);
        panel.add(lTemperature);
        panel.add(lInformation);
        panel.add(lPath);
        panel.add(city);
        panel.add(country);
        panel.add(continent);
        panel.add(temperature);
        panel.add(information);
        panel.add(path);
        panel.add(icon);
        panel.setVisible(true);
        
        do{
        JOptionPane.showMessageDialog(null, panel, "Editar registro de ciudad", 
                                        JOptionPane.DEFAULT_OPTION);
        }while(!campos(city, country, continent, temperature,information,path));
        return new City(city.getText(), country.getText(), continent.getText(), 
                        Float.parseFloat(temperature.getText()), 
                        information.getText(), path.getText());
    }
    
    public static City selectCity(City...args){
        JPanel panel = new JPanel();
        JLabel title = new JLabel("Ciudades por visitar");
        JLabel city  = new JLabel("Seleccione");
        JLabel icon  = new JLabel();
        ImageIcon imag = new ImageIcon(new ImageIcon("src/data/teotihuacán.png")
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
        return null;
    }
    
    public static void showCity(City c){
        JPanel panel = new JPanel();
        JLabel title = new JLabel("Ciudades por visitar");
        JLabel lCity  = new JLabel("Ciudad");
        JLabel lCountry = new JLabel("País");
        JLabel lContinent = new JLabel("Continente");
        JLabel lTemperature = new JLabel("Temperatura");
        JLabel lInformation = new JLabel("Información");
        JLabel eCity  = new JLabel(c.getName());
        JLabel eCountry = new JLabel(c.getCountry());
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
    
    public static void showMessage(String s){
        UIManager.put("OptionPane.minimumSize", new Dimension(0, 0));
        JOptionPane.showMessageDialog(null, s);
    }
}