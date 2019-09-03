package ro.siit.IOandEnums;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


//Writing the messages from messageList in file3.txt
public class WritingFile {
    static List<String> messageList = new ArrayList<>();
    public static void WritingFile(){

        {
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter("src\\ro\\siit\\IOandEnums\\file3.txt"));
                for (String message: messageList){
                    bw.write(message);
                }
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
