package list;

import java.util.ArrayList;
import static list.Display.showMessage;

public class CityRegistry extends City{

//  name          50
//  country       30
//  continent     20
//  temperature   4
//  information   100
//  path          30
//=========================
//  Total         234

    private final int   DIM                 = 234,
                        NAME_LENGTH         = 50,
                        COUNTRY_LENGTH      = 30,
                        CONTINENT_LENGTH    = 20,
                        TEMPERATURE_LENGTH  = 4,
                        INFORMATION_LENGTH  = 100,
                        PATH_LENGTH         = 30;

    public CityRegistry(){}
    
    public CityRegistry(City c){
        super(c.getName(), c.getCountry(), c.getContinent(), c.getTemperature(),
                c.getInformation(), c.getPath());
    }

    public CityRegistry(String name, String country, String continent,
                          float temperature, String description, String img){

        super(name, country, continent, temperature, description, img);
    }

    public void write(RandomFile f){
        try{
            f.write(stretch(name, NAME_LENGTH));
            f.write(stretch(country, COUNTRY_LENGTH));
            f.write(stretch(continent, CONTINENT_LENGTH));
            f.write(temperature);
            f.write(stretch(information, INFORMATION_LENGTH));
            f.write(stretch(path, PATH_LENGTH));
        }catch(Exception e){
            Display.showMessage(e.getMessage());
        }
    }

    public void read(RandomFile f, int row){
        int counter = 0;
        
        try{
            name        = f.read(Integer.toUnsignedLong(row * DIM), NAME_LENGTH);
            counter += NAME_LENGTH;
            
            country     = f.read(Integer.toUnsignedLong(row * DIM + counter), COUNTRY_LENGTH);
            counter += COUNTRY_LENGTH;
            
            continent   = f.read(Integer.toUnsignedLong(row * DIM + counter), CONTINENT_LENGTH);
            counter += CONTINENT_LENGTH;
            
            temperature = f.readFloat(row * DIM + counter);
            counter += TEMPERATURE_LENGTH;
            
            information = f.read(Integer.toUnsignedLong(row * DIM + counter), INFORMATION_LENGTH);
            counter += INFORMATION_LENGTH;
            
            path        = f.read(Integer.toUnsignedLong(row * DIM + counter), PATH_LENGTH);
        }catch(Exception e){
            Display.showMessage("Error reading " + e.getMessage());
        }

    }

    public String stretch(String s, int length){
        StringBuilder sb = new StringBuilder(s);
        sb.setLength(length);
        return sb.toString();
    }
    
    public void append(RandomFile f){
        try{
            f.setSeek(-1);
            write(f);
        }catch(Exception e){
            Display.showMessage("Failes appending" + e.getMessage());
        }
    }
    
    public void update(RandomFile f, City c){
        long row = getRow(f);
        if(row < 0) Display.showMessage("row -");
        System.out.println("row: " + row);
        try{
            f.setSeek(row * DIM);
            new CityRegistry(c).write(f);
        }catch(Exception e){
            Display.showMessage("Failed updating" + e.getMessage());
        }
    }
    
    private int getRow(RandomFile f){
        try{
            ArrayList<String> c = loadCities(f);
            for(int i = 0; i < c.size(); i++){
                if(c.get(i).equals(name))
                    return i;
            }
        }catch(Exception e){
            Display.showMessage("Failes getting row" + e.getMessage());
        }
        return -1;
    }
    
    
    public ArrayList<String> loadCities(RandomFile f){
        ArrayList<String> buff = new ArrayList();
        
        try{
            for(int i = 0; i * DIM < f.getLength(); i++){
                buff.add(f.read(i * DIM, NAME_LENGTH));
            }
        }catch(Exception e){
            showMessage(e.getMessage());
        }
        
        return buff;
    }
    
    public void search(String name){
        RandomFile f = new RandomFile();
        try {
            if(f.open(RandomFile.COUNTRIES)){
                for(int i = 0; i * DIM < f.getLength(); i++){
                    read(f, i);
                    if(this.name.equals(name))
                        return;
                }
            }
            f.close();
        } catch (Exception e) {
            Display.showMessage("Failed searching " + e.getMessage());
        }
    }

    @Override
    public String toString(){
        return  name + "\n" +
                country + "\n" +
                continent + "\n" +
                temperature + "\n" +
                information + "\n" +
                path + "\n";
    }
}
