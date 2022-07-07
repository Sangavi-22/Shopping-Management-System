package FileOperations;

import Model.MobilePhone.PhoneCameraModel;

import java.io.*;
import java.util.HashMap;

public class PhoneCameraFileHandler implements PhoneCameraFileHandlerService{
    File PhoneCameraDetails=new File("/Users/sangavi-pt5468/Desktop/Shopping-1/PhoneCameraDetails.txt");
    public void writePhoneCameraDetails(int productId, String primaryCamera, String secondaryCamera){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(PhoneCameraDetails,true));
            bw.write("productId:"+productId+", primaryCamera:"+primaryCamera+", secondaryCamera:"+secondaryCamera+"\n");
            bw.flush();
            bw.close();
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
    public HashMap<Integer, PhoneCameraModel> readPhoneCameraDetails() {
        HashMap<Integer, PhoneCameraModel>phoneCameraDetails=new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(PhoneCameraDetails));
            String sentence;
            while ((sentence = br.readLine()) != null) {
                HashMap<String,String>details=new HashMap<>();
                String[] words = sentence.split(", ");
                for(String part:words) {
                    details.put(part.split(":")[0],part.split(":")[1]);
                }
                PhoneCameraModel phoneCameraModel=new PhoneCameraModel();
                phoneCameraModel.setPrimaryCamera(details.get("primaryCamera"));
                phoneCameraModel.setSecondaryCamera(details.get("secondaryCamera"));
                phoneCameraDetails.put(Integer.parseInt(details.get("productId")),phoneCameraModel);
            }
            br.close();

        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            return phoneCameraDetails;
        }

    }
    public void removePhoneCamera(int productId){
        try {
            File PhoneCameraDetailsTemp=new File("/Users/sangavi-pt5468/Desktop/Shopping-1/PhoneCameraDetailsTemp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(PhoneCameraDetails));
            BufferedWriter writer = new BufferedWriter(new FileWriter(PhoneCameraDetailsTemp,true));
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
            PhoneCameraDetails.delete();
            PhoneCameraDetailsTemp.renameTo(PhoneCameraDetails);
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}
