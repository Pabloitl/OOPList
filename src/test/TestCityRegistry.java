package test;

import list.CityRegistry;
import list.RandomFile;

public class TestCityRegistry {
    
    public static void main(String[] args) throws Exception{
        CityRegistry c = new CityRegistry("adf", "asdf", "3", 5f, "4", "5");
        RandomFile f = new RandomFile();
        if(f.open("src/data/countries.data")){
            c.write(f);
            c.setCountry("other thing");
            c.write(f);
        }
        
        CityRegistry s =new CityRegistry(null, null, null, 0f, null, null);
        for(int i = 0; i < 2; i++){
            s.read(f, i);
            System.out.printf("Registry %d\n", i);
            System.out.println(s.getName());
            System.out.println(s.getCountry());
            System.out.println(s.getContinent());
            System.out.println(s.getTemperature());
            System.out.println(s.getInformation());
            System.out.println(s.getPath());
        }
        f.close();
    }
}
