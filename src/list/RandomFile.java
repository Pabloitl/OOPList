package list;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class RandomFile {
    
    public static final String   PATH = "src/data/",
                           COUNTRIES = PATH + "countries.data";

    private RandomAccessFile file;
    
    public boolean open(String path) throws FileNotFoundException{
        if(file != null) return false;
        
        file = new RandomAccessFile(path, "rw");
        return true;
    }
    
    public void write(Object data) throws Exception{
        write(data, file.getFilePointer());
    }
    
    public void write(Object data, long pointer) throws Exception{
        if(data instanceof String)
            file.write(((String) data).getBytes());
        else if(data instanceof Float)
            file.writeFloat((Float) data);
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
