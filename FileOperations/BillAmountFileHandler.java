package FileOperations;

import java.io.*;

public class BillAmountFileHandler implements BillAmountFileHandlerService{
    File BillAmountFile=new File("/Users/sangavi-pt5468/Desktop/Shopping-1/BillAmountFile.txt");
    public void writeBillAmount(int orderId,int billAmount) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(BillAmountFile,true));
            bw.write("orderId:"+orderId+", billAmount:"+billAmount+"\n");
            bw.flush();
            bw.close();

        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
    public int readBillAmount(int orderId){
        int amount=0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(BillAmountFile));
            String sentence;
            while ((sentence = br.readLine()) != null) {
                String[] words = sentence.split(", ");
                if(words[0].split(":")[1].equals(Integer.toString(orderId))) {
                    amount=Integer.parseInt(words[1].split(":")[1]);
                }
            }
            br.close();
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            return amount;
        }
    }
    public void removeBillAmount(int orderId){
        try {
            File BillAmountFileTemp=new File("/Users/sangavi-pt5468/Desktop/Shopping-1/BillAmountFileTemp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(BillAmountFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(BillAmountFileTemp,true));
            String lineToRemove="orderId:"+orderId;
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
            BillAmountFile.delete();
            BillAmountFileTemp.renameTo(BillAmountFile);
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}
