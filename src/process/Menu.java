package process;

import static list.Display.*;
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
            case 1:
                //View
                showCity(showList());
            case 2:
                //Edit
                edit(editRegistry(selectCity()));
        }
    }
}
