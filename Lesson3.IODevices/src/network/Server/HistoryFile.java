package network.Server;

import java.io.*;

public class HistoryFile {
    File file;

    public HistoryFile(String fileName){
        file = new File(fileName);
    }

    public void saveHistory(String nickName, String message){
        try(FileWriter writer = new FileWriter(file, true))
        {
            writer.write(nickName + "-:-" + message + '\n');
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
