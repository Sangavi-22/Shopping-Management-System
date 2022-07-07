package FileOperations;

import Model.ShoppingCart.ShoppingCartModel;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class OrdersFileHandler implements OrdersFileHandlerService{
    File OrdersFile=new File("/Users/sangavi-pt5468/Desktop/Shopping-1/OrdersFile.txt");
    File OrderedUsers=new File("/Users/sangavi-pt5468/Desktop/Shopping-1/OrderedUsers.txt");
    public void writeOrders(int orderNum,int productId,int quantity){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(OrdersFile,true));
            bw.write("orderId:"+orderNum+", productId:"+productId+", quantity:"+quantity+"\n");
            bw.flush();
            bw.close();
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
    public int readLastOrderNum(){
        int id=0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(OrderedUsers));
            String sentence;
            while ((sentence = br.readLine()) != null) {
                String[] words = sentence.split(", ");
                id = Integer.parseInt(words[1].split(":")[1]);

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
    public  void writeOrderedUsers(int orderNum, String userName, String deliveryStatus){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(OrderedUsers,true));
            bw.write("userName:"+userName+", orderNum:"+orderNum+", deliveryStatus:"+deliveryStatus+"\n");
            bw.flush();
            bw.close();
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String readOrderedUser(int orderId){
        String userName="";
        try {
            BufferedReader br = new BufferedReader(new FileReader(OrderedUsers));
            String sentence;
            while ((sentence = br.readLine()) != null) {
                String[] words = sentence.split(", ");
                if(words[1].split(":")[1].equals(Integer.toString(orderId))) {
                    userName=words[0].split(":")[1];
                }
            }
            br.close();
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            return userName;
        }
    }
    public ArrayList<Integer> readUserOrderId(String userName){
        ArrayList<Integer>orders=new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(OrderedUsers));
            String sentence;
            while ((sentence = br.readLine()) != null) {
                String[] words = sentence.split(", ");
                if(words[0].split(":")[1].equals(userName)) {
                    if(!orders.contains(Integer.parseInt(words[1].split(":")[1]))) {
                        orders.add(Integer.parseInt(words[1].split(":")[1]));
                    }
                    else {
                        continue;
                    }
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
            return orders;
        }
    }
   public ShoppingCartModel readProducts(int orderId){
        ShoppingCartModel shoppingCartModel=new ShoppingCartModel();
       try {
           BufferedReader br = new BufferedReader(new FileReader(OrdersFile));
           String sentence;
           while ((sentence = br.readLine()) != null) {
               String[] words = sentence.split(", ");
               if(Integer.parseInt(words[0].split(":")[1])==orderId) {
                   int productId=Integer.parseInt(words[1].split(":")[1]);
                   int quantity=Integer.parseInt(words[2].split(":")[1]);
                   shoppingCartModel.addProductsToCart(productId,quantity);
               }
               else{
                   continue;
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
   public ArrayList<Integer> readAllOrderFromFile(){
       ArrayList<Integer>orders=new ArrayList<>();
       try {
           BufferedReader br = new BufferedReader(new FileReader(OrdersFile));
           String sentence;
           while ((sentence = br.readLine()) != null) {
               String[] words = sentence.split(", ");
               if(!orders.contains(Integer.parseInt(words[0].split(":")[1]))) {
                   orders.add(Integer.parseInt(words[0].split(":")[1]));
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
           return orders;
       }
   }
    public HashMap<Integer, String> readStatusOfOrder(String userName){
        HashMap<Integer, String>orderStatus= new HashMap<>();
        String sentence;
        try{
            String[] words;
            BufferedReader br=new BufferedReader(new FileReader(OrderedUsers));
            while(br.ready()) {
                sentence=br.readLine();
                words=sentence.split(", ");
                if(words[0].split(":")[1].equals(userName)) {
                    orderStatus.put(Integer.parseInt(words[1].split(":")[1]),words[2].split(":")[1]);
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
            return orderStatus;
        }
    }
   public  void updateStatusOfOrder(String userName,int orderId){
       try {
           File OrderedUsersTemp=new File("/Users/sangavi-pt5468/Desktop/Shopping-1/OrderedUsersTemp.txt");
           BufferedReader reader = new BufferedReader(new FileReader(OrderedUsers));
           BufferedWriter writer = new BufferedWriter(new FileWriter(OrderedUsersTemp,true));
           String lineToUpdate="userName:"+userName+", orderNum:"+orderId;
           String currentLine;
           while((currentLine = reader.readLine()) != null) {
               String trimmedLine = currentLine.trim();
               String[] words=currentLine.split(",");
               String newLine="userName:"+userName+", orderNum:"+orderId+", deliveryStatus:"+"Delivered";
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
           OrderedUsers.delete();
           OrderedUsersTemp.renameTo(OrderedUsers);

       }
       catch(IOException e) {
           throw new RuntimeException(e);
       }
   }
    public void removeOrderFromFile(int orderId,String userName){
        try {
            File OrdersFileTemp=new File("/Users/sangavi-pt5468/Desktop/Shopping-1/OrdersFileTemp.txt");
            File OrderedUsersTemp=new File("/Users/sangavi-pt5468/Desktop/Shopping-1/OrderedUsersTemp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(OrdersFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(OrdersFileTemp,true));
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
            OrdersFile.delete();
            OrdersFileTemp.renameTo(OrdersFile);
            reader = new BufferedReader(new FileReader(OrderedUsers));
            writer = new BufferedWriter(new FileWriter(OrderedUsersTemp,true));
            lineToRemove=", orderNum:"+orderId;
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
            OrderedUsers.delete();
            OrderedUsersTemp.renameTo(OrderedUsers);
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}
