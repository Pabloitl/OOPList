package list;

public class City{
    protected String name;
    protected String country;
    protected String continent;
    protected float temperature;
    protected String information;
    protected String path;
    
    public City(){
        
    }

    public City(String name, String country, String continent, float temperature, 
                String information, String path) {
        this.name = name;
        this.country = country;
        this.continent = continent;
        this.temperature = temperature;
        this.information = information;
        this.path = path;
    }
    
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    
    public String getCountry(){
        return country;
    }
    
    public void setContinent(String continent) {
        this.continent = continent;
    }
    
    public String getContinent(){
        return continent;
    }
    
    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }
    
    public float getTemperature(){
        return temperature;
    }

    public void setInformation(String information) {
        this.information = information;
    }
    
    public String getInformation(){
        return information;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    public String getPath(){
        return path;
    } 
}
    
