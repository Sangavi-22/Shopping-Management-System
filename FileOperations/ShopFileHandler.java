package FileOperations;

import java.io.*;
import java.util.HashMap;

public class ShopFileHandler implements ShopFileHandlerService{
    File ShopProducts=new File("/Users/sangavi-pt5468/Desktop/Shopping-1/ShopProducts.txt");
    public void writeProductToShop(int productId, int quantity) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(ShopProducts,true));
            bw.write("ProductId:"+productId+", quantity:"+quantity+"\n");
            bw.flush();
            bw.close();
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
    public HashMap<Integer,Integer> readProducts(){
        HashMap<Integer,Integer>products=new HashMap<>();
        String sentence;
        try{
            String[] words;
            BufferedReader br=new BufferedReader(new FileReader(ShopProducts));
            while(br.ready()) {
                sentence=br.readLine();
                words=sentence.split(", ");
                products.put(Integer.parseInt(words[0].split(":")[1]),Integer.parseInt(words[1].split(":")[1]));
            }
            br.close();
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            return products;
        }
    }
    public void updateProductInShop(int productId,int quantity){
        int count = 0;
        try {
            File ShopProductsTemp=new File("/Users/sangavi-pt5468/Desktop/Shopping-1/ShopProductsTemp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(ShopProducts));
            BufferedWriter writer = new BufferedWriter(new FileWriter(ShopProductsTemp,true));
            String lineToUpdate="ProductId:"+productId;
            String currentLine;
            while((currentLine = reader.readLine()) != null) {
                String trimmedLine = currentLine.trim();
                String[] words=currentLine.split(",");
                if(trimmedLine.contains(lineToUpdate)) {
                    count = Integer.parseInt(words[1].split(":")[1]) + quantity;
                    writer.write("ProductId:" + productId + ", quantity:" + count + "\n");
                }
                else {
                    writer.write(currentLine + System.getProperty("line.separator"));
                }
            }
            writer.flush();
            writer.close();
            reader.close();
            ShopProducts.delete();
            ShopProductsTemp.renameTo(ShopProducts);
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void removePhoneFromShop(int productId){
        try {
            File ShopProductsTemp=new File("/Users/sangavi-pt5468/Desktop/Shopping-1/ShopProductsTemp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(ShopProducts));
            BufferedWriter writer = new BufferedWriter(new FileWriter(ShopProductsTemp,true));
            String lineToRemove="ProductId:"+productId;
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
            ShopProducts.delete();
            ShopProductsTemp.renameTo(ShopProducts);
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}
