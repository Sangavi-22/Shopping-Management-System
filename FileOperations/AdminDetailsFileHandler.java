package FileOperations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AdminDetailsFileHandler implements AdminDetailsFileHandlerService {
    public boolean containsAdmin(String userName){
        boolean flag=false;
        try {
            BufferedReader br = new BufferedReader(new FileReader("/Users/sangavi-pt5468/Desktop/Shopping-1/AdminDetails.txt"));
            String sentence;
            while ((sentence = br.readLine()) != null) {
                String[] words=sentence.split(",");
                if(words[0].equals(userName)) {
                    flag=true;
                }
                else {
                    continue;
                }
            }
            br.close();
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            return flag;
        }
    }
    public boolean passwordMatches(String userName,String password){
        boolean flag=false;
        try {
            BufferedReader br = new BufferedReader(new FileReader("/Users/sangavi-pt5468/Desktop/Shopping-1/AdminDetails.txt"));
            String sentence;
            while ((sentence = br.readLine()) != null) {
                String[] words=sentence.split(",");
                if(words[0].equals(userName) && words[1].equals(password)) {
                    flag=true;
                }
                else {
                    continue;
                }
            }
            br.close();
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            return flag;
        }
    }
}
