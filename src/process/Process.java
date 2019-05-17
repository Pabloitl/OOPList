package process;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import list.City;
import list.CityRegistry;
import list.Display;
import list.RandomFile;

public class Process {

//    public static void register(City c){
//        RandomFile f = new RandomFile();
//
//        try {            
//            if(f.open("src/data/countries.data"))
//            new CityRegistry(c).append();
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Process.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public static void edit(City c, int row){
//        City c2 = Display.showEdit(c);
//
//        new CityRegistry(c2).update(row);
//    }

    public static City showList(){
        return Display.showCountries();
    }
}
