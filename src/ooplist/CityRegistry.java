package ooplist;

public class CityRegistry extends City{

    public CityRegistry(String name, String country, String continent,
                            float temperature, String description, String img){
        super(name, country, continent, temperature, description, img);
    }

//    public void write(File f){
//        f.write(toString());
//    }
//
//    public String read(File f, int bytes){
//        return f.read(bytes);
//    }

    public String stretch(String s, int length){
        StringBuilder sb = new StringBuilder(s);
        sb.setLength(length);
        return sb.toString();
    }
}
