package FileOperations;

import Model.Users.SellerAccountModel;

import java.io.*;
import java.util.HashMap;

public class SellerDetailsFileHandler implements SellerDetailsFileHandlerService {
    File SellerDetails = new File("/Users/sangavi-pt5468/Desktop/Shopping-1/SellerDetails.txt");
    public void writeSellerDetails(int userId,String userName,String password,String name,String email,long mobileNum){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(SellerDetails,true));
            bw.write("SellerId:"+userId+", userName:"+userName+", password:"+password+", name:"+name+", email:"+email+", mobileNum:"+mobileNum+"\n");
            bw.flush();
            bw.close();
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateSellerDetails(int userId, String userName, String password, String name, String email, long mobileNum){
        try {
            File SellerDetailsTemp = new File("/Users/sangavi-pt5468/Desktop/Shopping-1/SellerDetailsTemp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(SellerDetails));
            BufferedWriter writer = new BufferedWriter(new FileWriter(SellerDetailsTemp,true));
            String lineToUpdate="SellerId:"+userId+", userName:"+userName;
            String newLine="SellerId:"+userId+", userName:"+userName+", password:"+password+", name:"+name+", email:"+email+", mobileNum:"+mobileNum;
            String currentLine;
            while((currentLine = reader.readLine()) != null) {
                String trimmedLine = currentLine.trim();
                if(trimmedLine.contains(lineToUpdate)) {
                    writer.write(newLine + System.getProperty("line.separator"));
                }
                else {
                    writer.write(currentLine + System.getProperty("line.separator"));
                }
            }
            writer.flush();
            writer.close();
            reader.close();
            SellerDetails.delete();
            SellerDetailsTemp.renameTo(SellerDetails);
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
    public int readLastSellerId(){
        String sentence;
        int id=0;
        try{
            String[] words={};
            BufferedReader br=new BufferedReader(new FileReader(SellerDetails));
            while(br.ready()) {
                sentence=br.readLine();
                words=sentence.split(", ");
            }
            id=Integer.parseInt(words[0].split(":")[1]);
            br.close();
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            return id;
        }
    }
    public HashMap<String,SellerAccountModel>readSellers(){
        HashMap<String, SellerAccountModel>sellers= new HashMap<>();
        String sentence;
        try{
            String[] words;
            BufferedReader br=new BufferedReader(new FileReader(SellerDetails));
            while(br.ready()){
                words=br.readLine().split(", ");
                SellerAccountModel sellerAccountModel=new SellerAccountModel();
                sellerAccountModel.setUserId(Integer.parseInt(words[0].split(":")[1]));
                sellerAccountModel.setUserName(words[1].split(":")[1]);
                sellerAccountModel.setPassword(words[2].split(":")[1]);
                sellerAccountModel.setName(words[3].split(":")[1]);
                sellerAccountModel.setEmail(words[4].split(":")[1]);
                sellerAccountModel.setMobileNum(Long.parseLong(words[5].split(":")[1]));
                sellers.put(sellerAccountModel.getUserName(),sellerAccountModel);
            }
            br.close();
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            return sellers;
        }
    }
    public void removeSellerDetailsFromFile(String userName){
        try {
            File SellerDetailsTemp = new File("/Users/sangavi-pt5468/Desktop/Shopping-1/SellerDetailsTemp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(SellerDetails));
            BufferedWriter writer = new BufferedWriter(new FileWriter(SellerDetailsTemp,true));
            String lineToRemove=", userName:"+userName;
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
            SellerDetails.delete();
            SellerDetailsTemp.renameTo(SellerDetails);
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}
