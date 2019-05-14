
package ooplist;

public class City{
    protected String name;
    protected String contry;
    protected String continent;
    protected int temperature;
    protected String information;
    protected String path;
    
    public City(){
        
    }

    public City(String name, String contry, String continent, int temperature, 
                String information, String path) {
        this.name = name;
        this.contry = contry;
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
    
    public void setContry(String contry) {
        this.contry = contry;
    }
    
    public String getContry(){
        return contry;
    }
    
    public void setContinent(String continent) {
        this.continent = continent;
    }
    
    public String getContinent(){
        return continent;
    }
    
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
    
    public int getTemperature(){
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
    
