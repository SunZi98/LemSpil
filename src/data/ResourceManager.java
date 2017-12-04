package data;

import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ResourceManager {

        
        public static void save(Serializable data, String fileName) throws Exception { //Serializeable data that can we written, What we call fileName on the disc
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) { //ObjectOutPutStream so we can save data
            oos.writeObject(data); //call method to save data
        }
    }

    public static Object load(String fileName) throws Exception { 
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) { //Input stream so we can load
            return ois.readObject(); //call method to read data
        }
    }
}
    
