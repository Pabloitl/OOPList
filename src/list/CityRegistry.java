package list;

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
            f.write(stretch(name, 50));
            f.write(stretch(country, 30));
            f.write(stretch(continent, 20));
            f.write(temperature);
            f.write(stretch(information, 100));
            f.write(stretch(path, 30));
        }catch(Exception e){
            Display.showMessage(e.getMessage());
        }
    }

    public void read(RandomFile f, int row){
        try{
            name        = f.read(Integer.toUnsignedLong(row * DIM), 50);
            country     = f.read(Integer.toUnsignedLong(row * DIM + 50), 30);
            continent   = f.read(Integer.toUnsignedLong(row * DIM + 80), 20);
            temperature = f.readFloat(row * DIM + 100);
            information = f.read(Integer.toUnsignedLong(row * DIM + 104), 100);
            path        = f.read(Integer.toUnsignedLong(row * DIM + 204), 30);
        }catch(Exception e){
            Display.showMessage("Error reading" + e.getMessage());
        }

    }

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
