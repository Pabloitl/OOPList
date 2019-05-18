package process;

import list.City;
import list.CityRegistry;
import list.Display;
import list.RandomFile;

public class Process {

    public static void register(City c){
        RandomFile f = new RandomFile();

        try {            
            if(f.open(RandomFile.COUNTRIES))
                new CityRegistry(c).append(f);
            f.close();
        }catch (Exception ex) {
            Display.showMessage(ex.getMessage());
        }
    }

    public static void edit(City c){
        RandomFile f = new RandomFile();
        City c2 = Display.editRegistry(c);
        
        try{
            if(f.open(RandomFile.COUNTRIES))
                new CityRegistry(c).update(f, c2);
            f.close();
        }catch(Exception e){
            Display.showMessage(e.getMessage());
        }
    }
}
