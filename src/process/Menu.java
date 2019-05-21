package process;

import java.util.ArrayList;
import list.City;
import list.CityRegistry;
import static list.Display.*;
import list.RandomFile;
import static process.Process.*;

public class Menu {

    public static int prompt(){
        return showOptions("Register", "View", "Edit");
    }

    public static void filter(int opt){
        switch(opt){
            case 0:
                //Add
                register(registry());
                break;
            case 1:
                //View
                showCity(askCity());
                break;
            case 2:
                //Edit
                edit(askCity());
                break;
            default: System.exit(0);
        }
    }
    
    private static City askCity(){
        String[] arr = getCities();
        CityRegistry c = new CityRegistry();
        c.search(selectCity(arr));
        
        return c;
    }
    
    private static String[] getCities(){
        RandomFile f = new RandomFile();
        ArrayList<String> options = new ArrayList();
        try{
            f.open(RandomFile.COUNTRIES);
            options = new CityRegistry().loadCities(f);
            f.close();
        }catch(Exception e){
            showMessage(e.getMessage());
        }
        return options.toArray(new String[options.size()]);
    }
}
