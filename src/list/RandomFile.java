package list;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomFile {
    
    public static final String PATH = "src/data/",
                               COUNTRIES = PATH + "countries.data";

    private RandomAccessFile file;
    
    public void setSeek(long pointer) throws IOException{
        if(pointer < 0){
            file.seek(file.length());
        }else
            file.seek(pointer);
    }
    
    public long getSeek(){
        try {
            return file.getFilePointer();
        } catch (IOException ex) {
            Display.showMessage("Error retrieving file pointer" + ex.getMessage());
        }
        return -1;
    }
    
    public long getLength() throws Exception{
        return file.length();
    }
    
    public boolean open(String path) throws FileNotFoundException{
        if(file != null) return false;
        
        file = new RandomAccessFile(path, "rw");
        return true;
    }
    
    public void write(String data) throws Exception{
        write(data, file.getFilePointer());
    }
    
    public void write(String data, long pointer) throws Exception{
        file.seek(pointer);
        file.write(data.getBytes());
    }
    
    public void write(float data) throws Exception{
        write(data, file.getFilePointer());
    }
    
    public void write(float data, long pointer) throws Exception{
        file.seek(pointer);
        file.writeFloat(data);
    }
    
    public String read(long pointer, int length) throws Exception{
        byte[] temp = new byte[length];
        
        file.seek(pointer);
        file.read(temp);

        return new String(temp);
    }
    
    public float readFloat(long pointer) throws Exception{
        file.seek(pointer);
        return file.readFloat();
    }
    
    public boolean close() throws Exception{
        if(file == null) return false;
        
        file.close();
        return true;
    }
}
