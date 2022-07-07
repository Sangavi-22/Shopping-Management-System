package FileOperations;

import Model.ShoppingCart.ShoppingCartModel;

import java.io.*;
import java.util.HashMap;

public class ShoppingCartFileHandler implements ShoppingCartFileHandlerService{
    File ShoppingCart= new File("/Users/sangavi-pt5468/Desktop/Shopping-1/ShoppingCart.txt");
    public void writeToCart(String userName, HashMap<Integer,Integer> shoppingCart){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(ShoppingCart,true));
            for(int key: shoppingCart.keySet()) {
                bw.write("userName:"+userName+", productId:"+key+", quantity:"+shoppingCart.get(key)+"\n");
            }
            bw.flush();
            bw.close();
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean containsShoppingCart(String userName){
        boolean found=false;
        String sentence;
        try{
            String[] words;
            BufferedReader br=new BufferedReader(new FileReader(ShoppingCart));
            while(br.ready()) {
                sentence=br.readLine();
                words=sentence.split(", ");
                if(words[0].split(":")[1].equals(userName)) {
                   found=true;
                    break;
                }
            }
            br.close();
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            return found;
        }
    }
    public ShoppingCartModel getShoppingCart(String userName){
        ShoppingCartModel shoppingCartModel=new ShoppingCartModel();
        String sentence;
        try{
            String[] words;
            BufferedReader br=new BufferedReader(new FileReader(ShoppingCart));
            while(br.ready()) {
                sentence=br.readLine();
                words=sentence.split(", ");
                if(words[0].split(":")[1].equals(userName)) {
                    shoppingCartModel.addProductsToCart(Integer.parseInt(words[1].split(":")[1]),Integer.parseInt(words[2].split(":")[1]));
                }

            }
            br.close();
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            return shoppingCartModel;
        }
    }
    public void removeFromCart(String userName){
        try {
            File ShoppingCartTemp= new File("/Users/sangavi-pt5468/Desktop/Shopping-1/ShoppingCartTemp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(ShoppingCart));
            BufferedWriter writer = new BufferedWriter(new FileWriter(ShoppingCartTemp, true));
            String lineToRemove ="userName: "+userName ;
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String trimmedLine = currentLine.trim();
                if (trimmedLine.contains(lineToRemove)) {
                    continue;
                }
                else {
                    writer.write(currentLine + System.getProperty("line.separator"));
                }

            }
            writer.flush();
            writer.close();
            reader.close();
            ShoppingCart.delete();
            ShoppingCartTemp.renameTo(ShoppingCart);
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}

