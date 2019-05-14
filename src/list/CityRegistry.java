package list;

import java.io.FileNotFoundException;

public class CityRegistry extends City{
    
//  name          50 * 2
//  country       30 * 2
//  continent     20 * 2
//  temperature   4
//  information   100* 2
//  path          30 * 2
//=========================    
//  Total         464
    
    private int DIM = 234;

    public CityRegistry(){}
    
    public CityRegistry(String name, String country, String continent,
                            float temperature, String description, String img){
        
        super(name, country, continent, temperature, description, img);
    }

    public void write(RandomFile f){
        f.write(stretch(name, 100));
        f.write(stretch(country, 60));
        f.write(stretch(continent, 40));
        f.write(temperature);
        f.write(stretch(information, 60));
        f.write(stretch(path, 60));
    }

//    public String read(RandomFile f, int row){
//    }

    public String stretch(String s, int length){
        StringBuilder sb = new StringBuilder(s);
        sb.setLength(length);
        return sb.toString();
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
