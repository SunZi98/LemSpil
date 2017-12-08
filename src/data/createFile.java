package data;

import java.util.Formatter;

public class createFile {
        
    private Formatter file;
public void openFile(){
    
        try{
            file = new Formatter("saveFile.txt");
        }
       catch(Exception e){
            System.out.println("Couldn't open file");
        }
}


public void addFile(){
}

}
