package DataStorage;

import FileOperations.*;
import Model.Users.CustomerAccountModel;
import Model.MobilePhone.*;
import Model.Users.SellerAccountModel;
import Model.ShoppingCart.ShoppingCartModel;

import java.util.ArrayList;
import java.util.HashMap;

public class DataSource implements DataSourceService {
    private static DataSource dataSource = null;
    private final AdminDetailsFileHandlerService adminDetailsFile = new AdminDetailsFileHandler();
    private final SellerDetailsFileHandlerService sellerDetailsFile = new SellerDetailsFileHandler();
    private final CustomerDetailsFileHandlerService customerDetailsFile = new CustomerDetailsFileHandler();
    private final PhoneDetailsFileHandlerService phoneDetailsFile=new PhoneDetailsFileHandler();
    private final PhoneCameraFileHandlerService phoneCameraFile=new PhoneCameraFileHandler();
    private final PhoneDimensionsFileHandlerService phoneDimensionsFile=new PhoneDimensionsFileHandler();
    private final PhoneManufacturerFileHandlerService phoneManufacturerFile=new PhoneManufacturerFileHandler();
    private final PhoneProcessorFileHandlerService phoneProcessorFile=new PhoneProcessorFileHandler();
    private final PhoneStorageCapacityFileHandlerService phoneStorageCapacityFile=new PhoneStorageCapacityFileHandler();
    private final ShopFileHandlerService shopFile=new ShopFileHandler();
    private final ShoppingCartFileHandlerService shoppingCartFile=new ShoppingCartFileHandler();
    private final StockNotAvailableFileHandlerService stockNotAvailableFile=new StockNotAvailableFileHandler();
    private final OrdersFileHandlerService ordersFile=new OrdersFileHandler();
    private final BillAmountFileHandlerService billFile=new BillAmountFileHandler();
    private final EmployeeNumFileHandlerService employeeNumFile=new EmployeeNumFileHandler();
    private HashMap<String, SellerAccountModel> sellers = new HashMap<>();
    private HashMap<String, CustomerAccountModel> customers = new HashMap<>();
    private HashMap<Integer,Integer>shopProductsMap=new HashMap<>();
    private HashMap<Integer,PhoneDetailsModel>phoneDetailsMap=new HashMap<>();
    private HashMap<Integer,PhoneCameraModel>phoneCameraMap=new HashMap<>();
    private HashMap<Integer,PhoneDimensionsModel>phoneDimensionsMap=new HashMap<>();
    private HashMap<Integer,PhoneManufacturerModel>phoneManufacturerMap=new HashMap<>();
    private HashMap<Integer,PhoneProcessorModel>phoneProcessorMap=new HashMap<>();
    private HashMap<Integer,PhoneStorageCapacityModel>phoneStorageCapacityMap=new HashMap<>();
    private DataSource() {
        //constructor
    }
    public static DataSource getInstance() {
        if (dataSource == null) {
            dataSource = new DataSource();
        }
        return dataSource;
    }
    public boolean containsAdmin(String userName){
        return adminDetailsFile.containsAdmin(userName);
    }
    public boolean passwordOfAdminMatches(String userName, String password){
        return adminDetailsFile.passwordMatches(userName,password);
    }
    public boolean containsEmployeeNum(String employmentNum ){
        return employeeNumFile.containsNum(employmentNum);
    }
    public int getIdForSeller() {
        return sellerDetailsFile.readLastSellerId();
    }
    public void addSeller(SellerAccountModel sellerAccountModel) {
        sellerDetailsFile.writeSellerDetails(sellerAccountModel.getUserId(), sellerAccountModel.getUserName(), sellerAccountModel.getPassword(), sellerAccountModel.getName(), sellerAccountModel.getEmail(), sellerAccountModel.getMobileNum());
        sellers.put(sellerAccountModel.getUserName(), sellerAccountModel);
    }
    public boolean containsSeller(String userName) {
        boolean flag;
        flag = getSellers().containsKey(userName);
        return flag;
    }
    public boolean passwordOfSellerMatches(String userName, String password){
        return getSellers().containsKey(userName) && getSellers().get(userName).getPassword().equals(password);
    }
    public void updateSellerDetailsInDataSource(SellerAccountModel sellerAccountModel){
        sellerDetailsFile.updateSellerDetails(sellerAccountModel.getUserId(), sellerAccountModel.getUserName(), sellerAccountModel.getPassword(), sellerAccountModel.getName(), sellerAccountModel.getEmail(), sellerAccountModel.getMobileNum());
        sellers.put(sellerAccountModel.getUserName(),sellerAccountModel);
    }
    public SellerAccountModel getSeller(String userName){
        return getSellers().get(userName);
    }
    public HashMap<String, SellerAccountModel> getSellers() {
        if (sellers.size() == 0) {
            sellers = sellerDetailsFile.readSellers();
        }
        return sellers;
    }
    public void removeSeller(String userName){
        sellerDetailsFile.removeSellerDetailsFromFile(userName);
        sellers.remove(userName);
    }
    public int getIdForCustomer() {
        return customerDetailsFile.readLastCustomerId();
    }
    public void addCustomer(CustomerAccountModel customerAccountModel) {
        customerDetailsFile.writeCustomerDetails(customerAccountModel.getUserId(), customerAccountModel.getUserName(), customerAccountModel.getPassword(), customerAccountModel.getName(), customerAccountModel.getEmail(), customerAccountModel.getMobileNum(), customerAccountModel.getShippingAddress());
        customers.put(customerAccountModel.getUserName(), customerAccountModel);
    }
    public boolean containsCustomer(String userName) {
        boolean flag;
        HashMap<String, CustomerAccountModel> customersList = getCustomers();
        flag = customersList.containsKey(userName);
        return flag;
    }
    public boolean passwordOfCustomerMatches(String userName, String password){
        return getCustomers().containsKey(userName) && getCustomers().get(userName).getPassword().equals(password);
    }
    public void updateCustomerDetailsInDataSource(CustomerAccountModel customerAccountModel){
        customerDetailsFile.updateCustomerDetails(customerAccountModel.getUserId(), customerAccountModel.getUserName(), customerAccountModel.getPassword(), customerAccountModel.getName(), customerAccountModel.getEmail(), customerAccountModel.getMobileNum(), customerAccountModel.getShippingAddress());
        customers.put(customerAccountModel.getUserName(),customerAccountModel);
    }
    public CustomerAccountModel getCustomer(String userName){
        return getCustomers().get(userName);
    }
    public HashMap<String, CustomerAccountModel> getCustomers() {
        if (customers.size() == 0) {
            customers = customerDetailsFile.readCustomers();
        }
        return customers;
    }
    public void removeCustomer(String userName){
        customerDetailsFile.removeCustomerDetailsFromFile(userName);
        customers.remove(userName);
    }
    public int getLastPhoneId(){
        return phoneDetailsFile.readLastPhoneId();
    }
    public int getPhoneId(String modelName) {
        int id=0;
        for(int productId: getPhoneDetails().keySet()) {
            if(getPhoneDetails().get(productId).getModelName().toLowerCase().contains(modelName.toLowerCase())) {
                id=productId;
            }
        }
        return id;
    }
    public void addPhoneToShop(int productId,int quantity) {
        shopFile.writeProductToShop(productId,quantity);
        shopProductsMap.put(productId,quantity);
    }
    public ArrayList<Integer> searchFromShop(String productId) {
        ArrayList<Integer>ids=new ArrayList<>();
        for(int id:getPhones().keySet()) {
            if(Integer.toString(id).contains(productId)) {
                ids.add(id);
            }
        }
        return ids;

    }
    public boolean containsPhone(int id){
        return shopProductsMap.containsKey(id);
    }
    public HashMap<Integer,Integer>getPhones(){
        if (shopProductsMap.size() == 0) {
            shopProductsMap= shopFile.readProducts();
        }
        return shopProductsMap;
    }
    public void updatePhoneQuantity(int id,int quantity){
        if(shopProductsMap.containsKey(id)) {
            shopProductsMap.put(id,quantity);
            shopFile.updateProductInShop(id,quantity);
        }
    }
    public void removePhone(int id){
        shopFile.removePhoneFromShop(id);
        shopProductsMap.remove(id);
        phoneDetailsFile.removePhoneDetails(id);
        phoneDetailsMap.remove(id);
        phoneCameraFile.removePhoneCamera(id);
        phoneCameraMap.remove(id);
        phoneDimensionsFile.removePhoneDimensions(id);
        phoneDimensionsMap.remove(id);
        phoneManufacturerFile.removePhoneManufacturer(id);
        phoneManufacturerMap.remove(id);
        phoneProcessorFile.removePhoneProcessor(id);
        phoneStorageCapacityFile.removePhoneStorageCapacity(id);
        phoneProcessorMap.remove(id);
    }
    public void addPhoneDetails(int productId, PhoneDetailsModel phoneDetailsModel){
        phoneDetailsFile.writePhoneDetails(productId,phoneDetailsModel.getModelName(),phoneDetailsModel.getBatteryCapacity(),phoneDetailsModel.getDisplaySize(),phoneDetailsModel.getPrice());
        phoneDetailsMap.put(productId,phoneDetailsModel);
    }
    public ArrayList<Integer>searchFromPhoneDetails(String input) {
        ArrayList<Integer> ids = new ArrayList<>();
        for(int id: getPhoneDetails().keySet()) {
            if(getPhoneDetails().get(id).getModelName().toLowerCase().contains(input.toLowerCase())) {
                ids.add(id);
            }
            else if(Integer.toString(getPhoneDetails().get(id).getPrice()).contains(input)){
                ids.add(id);
            }
            else if(getPhoneDetails().get(id).getBatteryCapacity().contains(input)) {
                ids.add(id);
            }
            else if(Double.toString(getPhoneDetails().get(id).getDisplaySize()).contains(input)) {
                ids.add(id);
            }
            else {
                continue;
            }
        }
        return ids;
    }
    public PhoneDetailsModel getParticularPhone(int id){
        return getPhoneDetails().get(id);
    }
    public HashMap<Integer,PhoneDetailsModel>getPhoneDetails(){
        if(phoneDetailsMap.size()==0) {
            phoneDetailsMap=phoneDetailsFile.readPhoneDetails();
        }
        return phoneDetailsMap;

    }
    public void addPhoneCamera(int productId, PhoneCameraModel phoneCameraModel){
        phoneCameraFile.writePhoneCameraDetails(productId,phoneCameraModel.getPrimaryCamera(),phoneCameraModel.getSecondaryCamera());
        phoneCameraMap.put(productId,phoneCameraModel);
    }
    public ArrayList<Integer>searchFromPhoneCameraDetails(String input){
        ArrayList<Integer>ids=new ArrayList<>();
        for(int id:getPhoneCameraDetails().keySet()) {
            if(getPhoneCameraDetails().get(id).getPrimaryCamera().toLowerCase().contains(input.toLowerCase())) {
                ids.add(id);
            }
            else if(getPhoneCameraDetails().get(id).getSecondaryCamera().toLowerCase().contains(input.toLowerCase())) {
                ids.add(id);
            }
            else {
                continue;
            }
        }
        return ids;
    }
    public PhoneCameraModel getParticularPhoneWithCamera(int id){
        return getPhoneCameraDetails().get(id);
    }
    public HashMap<Integer,PhoneCameraModel>getPhoneCameraDetails(){
        if(phoneCameraMap.size()==0) {
            phoneCameraMap=phoneCameraFile.readPhoneCameraDetails();
        }
        return phoneCameraMap;
    }
    public void addPhoneDimensions(int productId,PhoneDimensionsModel phoneDimensionsModel){
        phoneDimensionsFile.writePhoneDimensions(productId,phoneDimensionsModel.getWidth(),phoneDimensionsModel.getHeight(),phoneDimensionsModel.getWeight());
        phoneDimensionsMap.put(productId,phoneDimensionsModel);
    }
    public ArrayList<Integer>searchFromPhoneDimensionsDetails(String input){
        ArrayList<Integer>ids=new ArrayList<>();
        for(int id: getPhoneDimensions().keySet()) {
            if(Integer.toString(getPhoneDimensions().get(id).getWeight()).contains(input)) {
                ids.add(id);
            }
            else if(Integer.toString(getPhoneDimensions().get(id).getHeight()).contains(input)) {
                ids.add(id);
            }
            else if(Integer.toString(getPhoneDimensions().get(id).getWidth()).contains(input)) {
                ids.add(id);
            }
            else {
                continue;
            }
        }
        return ids;
    }
    public PhoneDimensionsModel getParticularPhoneWithDimensions(int id){
        return getPhoneDimensions().get(id);
    }
    public HashMap<Integer,PhoneDimensionsModel>getPhoneDimensions(){
        if(phoneDimensionsMap.size()==0) {
            phoneDimensionsMap=phoneDimensionsFile.readPhoneDimensionsDetails();
        }
        return phoneDimensionsMap;
    }
    public void addPhoneManufacturer(int productId,PhoneManufacturerModel phoneManufacturerModel ){
        phoneManufacturerFile.writePhoneManufacturerDetails(productId,phoneManufacturerModel.getManufacturerName());
        phoneManufacturerMap.put(productId,phoneManufacturerModel);
    }
    public ArrayList<Integer>searchFromPhoneManufacturer(String input){
        ArrayList<Integer>ids=new ArrayList<>();
        for(int id: getPhoneManufacturer().keySet()) {
            if(getPhoneManufacturer().get(id).getManufacturerName().toLowerCase().contains(input.toLowerCase())) {
                ids.add(id);
            }

        }
        return ids;
    }
    public PhoneManufacturerModel getParticularPhoneWithManufacturer(int id){
        return getPhoneManufacturer().get(id);
    }
    public HashMap<Integer,PhoneManufacturerModel>getPhoneManufacturer(){
        if(phoneManufacturerMap.size()==0) {
            phoneManufacturerMap=phoneManufacturerFile.readPhoneManufacturerDetails();
        }
        return phoneManufacturerMap;
    }
    public void addPhoneProcessor(int productId,PhoneProcessorModel phoneProcessorModel){
        phoneProcessorFile.writePhoneProcessorDetails(productId,phoneProcessorModel.getProcessorType(),phoneProcessorModel.getOperatingSystem());
        phoneProcessorMap.put(productId,phoneProcessorModel);
    }
    public ArrayList<Integer>searchFromPhoneProcessor(String input){
        ArrayList<Integer>ids=new ArrayList<>();
        for(int id: getPhoneProcessorDetails().keySet()) {
            if(getPhoneProcessorDetails().get(id).getProcessorType().toLowerCase().contains(input.toLowerCase())) {
                ids.add(id);
            }
            else if(getPhoneProcessorDetails().get(id).getOperatingSystem().toLowerCase().contains(input.toLowerCase())) {
                ids.add(id);
            }
            else {
                continue;
            }
        }
        return ids;
    }
    public PhoneProcessorModel getParticularPhoneWithProcessor(int id){
        return getPhoneProcessorDetails().get(id);
    }
    public HashMap<Integer,PhoneProcessorModel>getPhoneProcessorDetails(){
        if(phoneProcessorMap.size()==0) {
            phoneProcessorMap=phoneProcessorFile.readPhoneProcessorDetails();
        }
        return phoneProcessorMap;
    }
    public void addPhoneStorageCapacity(int productId, PhoneStorageCapacityModel phoneStorageCapacityModel){
        phoneStorageCapacityFile.writePhoneProcessorDetails(productId,phoneStorageCapacityModel.getStorageCapacity());
        phoneStorageCapacityMap.put(productId,phoneStorageCapacityModel);
    }

    public ArrayList<Integer>searchFromPhoneStorageCapacity(String input){
        ArrayList<Integer>ids=new ArrayList<>();
        for(int id: getPhoneStorageCapacityDetails().keySet()) {
            if(Integer.toString(getPhoneStorageCapacityDetails().get(id).getStorageCapacity()).contains(input)){
                ids.add(id);
            }

        }
        return ids;

    }
    public PhoneStorageCapacityModel getParticularPhoneWithStorageCapacity(int id){
        return getPhoneStorageCapacityDetails().get(id);
    }
    public HashMap<Integer,PhoneStorageCapacityModel>getPhoneStorageCapacityDetails(){
        if(phoneStorageCapacityMap.size()==0) {
            phoneStorageCapacityMap=phoneStorageCapacityFile.readPhoneStorageCapacityDetails();
        }
        return phoneStorageCapacityMap;

    }
    public ArrayList<Integer> searchPhoneFromFile(String input) {
        ArrayList<Integer>productIds=new ArrayList<>();
        productIds.addAll(searchFromShop(input));
        productIds.addAll(searchFromPhoneDetails(input));
        productIds.addAll(searchFromPhoneManufacturer(input));
        productIds.addAll(searchFromPhoneCameraDetails(input));
        productIds.addAll(searchFromPhoneDimensionsDetails(input));
        productIds.addAll(searchFromPhoneProcessor(input));
        productIds.addAll(searchFromPhoneStorageCapacity(input));
        return productIds;
    }
    public void addToStockNillList(int id){
        stockNotAvailableFile.writeToFile(id);
    }
    public  ArrayList<Integer> readStockNilProducts(){
        return stockNotAvailableFile.readStockNotAvailableProducts();
    }
    public  void removeFromStockNilList(int phoneId){
        System.out.println(phoneId);
        stockNotAvailableFile.removePhoneId(phoneId);
    }
    public void writeToCartFile(String userName, HashMap<Integer, Integer> productsFromCart){
        shoppingCartFile.writeToCart(userName,productsFromCart);
    }
    public boolean containsCart(String userName){
        return shoppingCartFile.containsShoppingCart(userName);
    }
    public ShoppingCartModel getCart(String userName){
        return shoppingCartFile.getShoppingCart(userName);
    }

    public int getLastOrderNum(){
        return ordersFile.readLastOrderNum();
    }
    public void writeToOrdersList(String userName, int orderNum, int productId, int quantity, String deliveryStatus){
        ordersFile.writeOrders(orderNum,productId,quantity);
        ordersFile.writeOrderedUsers(orderNum,userName,deliveryStatus);
    }
    public String getUserFromOrderedUsers(int orderId){
        return ordersFile.readOrderedUser(orderId);
    }
    public ArrayList<Integer> readParticularOrder(String userName){
        return ordersFile.readUserOrderId(userName);
    }
    public ShoppingCartModel getProductsOfThatOrder(int orderId){
        return ordersFile.readProducts(orderId);
    }
    public ArrayList<Integer> readAllOrders(){
        return ordersFile.readAllOrderFromFile();
    }
    public HashMap<Integer, String> readOrderStatus(String userName){
        return ordersFile.readStatusOfOrder(userName);
    }
    public void updateOrderStatus(String userName, int orderId){
        ordersFile.updateStatusOfOrder(userName,orderId);
    }

    public void removeOrder(int orderId,String userName){
        ordersFile.removeOrderFromFile(orderId,userName);
        billFile.removeBillAmount(orderId);
    }
    public void writeToBillFile(int orderNum, int totalAmount){
        billFile.writeBillAmount(orderNum,totalAmount);
    }
    public int readFromBillFile(int orderId){
        return billFile.readBillAmount(orderId);
    }
    public  void freeCartForUser(String userName){
        shoppingCartFile.removeFromCart(userName);
    }
}
