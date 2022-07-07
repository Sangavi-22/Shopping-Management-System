package FileOperations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EmployeeNumFileHandler implements EmployeeNumFileHandlerService{
    public boolean containsNum(String employeeNum){
        boolean flag=false;
        try {
            BufferedReader br = new BufferedReader(new FileReader("/Users/sangavi-pt5468/Desktop/Shopping-1/EmployeeNum.txt"));
            String sentence;
            while ((sentence = br.readLine()) != null) {
                if(sentence.equals(employeeNum)) {
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
