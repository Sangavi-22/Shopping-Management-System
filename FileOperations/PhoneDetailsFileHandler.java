package FileOperations;

import Model.MobilePhone.PhoneDetailsModel;

import java.io.*;
import java.util.HashMap;

public class PhoneDetailsFileHandler implements PhoneDetailsFileHandlerService{
    File PhoneDetails=new File("/Users/sangavi-pt5468/Desktop/Shopping-1/PhoneDetails.txt");
    public void writePhoneDetails(int productId, String modelName, String batteryCapacity, double displaySize,int price){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(PhoneDetails,true));
            bw.write("productId:"+productId+", modelName:"+modelName+", batteryCapacity:"+batteryCapacity+", displaySize:"+displaySize+", price:"+price+"\n");
            bw.flush();
            bw.close();
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
    public int readLastPhoneId(){
        int id=0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(PhoneDetails));
            String sentence;
            while ((sentence =br.readLine()) != null) {
                String[] words=sentence.split(", ");
                id=Integer.parseInt(words[0].split(":")[1]);
            }
            br.close();
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            return id;
        }
    }
    public HashMap<Integer, PhoneDetailsModel> readPhoneDetails(){
        HashMap<Integer, PhoneDetailsModel>phoneDetails=new HashMap<>();
        String sentence;
        try{
            String[] words;
            BufferedReader br=new BufferedReader(new FileReader(PhoneDetails));
            while(br.ready()){
                words=br.readLine().split(", ");
                PhoneDetailsModel phoneDetailsModel=new PhoneDetailsModel();
                phoneDetailsModel.setProductId(Integer.parseInt(words[0].split(":")[1]));
                phoneDetailsModel.setModelName(words[1].split(":")[1]);
                phoneDetailsModel.setBatteryCapacity(words[2].split(":")[1]);
                phoneDetailsModel.setDisplaySize(Double.parseDouble(words[3].split(":")[1]));
                phoneDetailsModel.setPrice(Integer.parseInt(words[4].split(":")[1]));
                phoneDetails.put(Integer.parseInt(words[0].split(":")[1]),phoneDetailsModel);
            }
            br.close();
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            return phoneDetails;
        }

    }
    public void removePhoneDetails(int productId){
        try {
            File PhoneDetailsTemp=new File("/Users/sangavi-pt5468/Desktop/Shopping-1/PhoneDetailsTemp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(PhoneDetails));
            BufferedWriter writer = new BufferedWriter(new FileWriter(PhoneDetailsTemp,true));
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
            PhoneDetails.delete();
            PhoneDetailsTemp.renameTo(PhoneDetails);
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

}
