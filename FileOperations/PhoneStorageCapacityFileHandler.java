package FileOperations;

import Model.MobilePhone.PhoneStorageCapacityModel;

import java.io.*;
import java.util.HashMap;

public class PhoneStorageCapacityFileHandler implements PhoneStorageCapacityFileHandlerService {
    File PhoneStorageCapacity= new File("/Users/sangavi-pt5468/Desktop/Shopping-1/PhoneStorageCapacity.txt");
    File PhoneStorageCapacityTemp= new File("/Users/sangavi-pt5468/Desktop/Shopping-1/PhoneStorageCapacityTemp.txt");
    public void writePhoneProcessorDetails(int productId, int storageCapacity){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(PhoneStorageCapacity,true));
            bw.write("productId:"+productId+", storageCapacity:"+storageCapacity+"\n");
            bw.flush();
            bw.close();
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
    public HashMap<Integer, PhoneStorageCapacityModel> readPhoneStorageCapacityDetails(){
        HashMap<Integer, PhoneStorageCapacityModel>phoneStorageCapacityDetails=new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(PhoneStorageCapacity));
            String sentence;
            while ((sentence = br.readLine()) != null) {
                HashMap<String,String>details=new HashMap<>();
                String[] words = sentence.split(", ");
                for(String part:words) {
                    details.put(part.split(":")[0],part.split(":")[1]);
                }
                PhoneStorageCapacityModel phoneStorageCapacityModel=new PhoneStorageCapacityModel();
                phoneStorageCapacityModel.setStorageCapacity(Integer.parseInt(details.get("storageCapacity")));
                phoneStorageCapacityDetails.put(Integer.parseInt(details.get("productId")),phoneStorageCapacityModel);
            }
            br.close();
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            return phoneStorageCapacityDetails;
        }
    }
    public void removePhoneStorageCapacity(int productId){
        try {
            File PhoneProcessorTemp= new File("/Users/sangavi-pt5468/Desktop/Shopping-1/PhoneStorageCapacityTemp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(PhoneStorageCapacity));
            BufferedWriter writer = new BufferedWriter(new FileWriter(PhoneProcessorTemp,true));
            String lineToRemove="productId:"+productId;
            String currentLine;
            while((currentLine = reader.readLine()) != null) {
                String trimmedLine = currentLine.trim();
                if(trimmedLine.contains(lineToRemove)) {
                    continue;
                }
                else {
                    writer.write(currentLine + System.getProperty("line.separator"));
                }

            }
            writer.flush();
            writer.close();
            reader.close();
            PhoneStorageCapacity.delete();
            PhoneProcessorTemp.renameTo(PhoneStorageCapacity);
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}
