package process;

import java.util.ArrayList;
import list.City;
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
                register(showCountries());
                break;
            case 1:
                //View
                showCity(showCountries());
                break;
            case 2:
                //Edit
                edit(showEdit(showCountries()));
                break;
        }
    }
}
