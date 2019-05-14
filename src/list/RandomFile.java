package list;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomFile {
    
    public static String   PATH = "src/data/",
                    COUNTRIES = PATH + "countries.data";

    private RandomAccessFile file;
    
    public boolean open(String path) throws FileNotFoundException{
        if(file != null) return false;
        
        file = new RandomAccessFile(path, "rw");
        return true;
    }
    
    public void write(Object data){
        try {
            write(data, file.getFilePointer());
        } catch (IOException ex) {
            System.out.println(ex.getMessage().toString());
        }
    }
    
    public void write(Object data, long pointer){
        if(data instanceof String){
            try{
                file.writeUTF((String) data);
                System.out.println("String");
            }catch(IOException ex){}
        }else if(data instanceof Float){
            try{
                file.writeFloat((Float) data);
                System.out.println("Float");
            }catch (IOException ex){}
        }
    }
    
    public boolean close() throws IOException{
        if(file == null) return false;
        
        file.close();
        return true;
    }
}
