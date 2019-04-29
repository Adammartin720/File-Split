package textfileread;

import java.io.File;
import java.util.Scanner;

public class Textfileread {

public static void main(String[] args)  throws Exception { 
    
    String ImportRec;
    
    customer ProcessCustomer = new customer();
    product ProcessProduct = new product();
    salesrep ProcessSalesRep = new salesrep();
    order ProcessOrder = new order();
        
    File DataFile = new File("eFood6910.Dat"); 
    Scanner ImportFile = new Scanner(DataFile); 
    
    while( ImportFile.hasNext() ) {   
        ImportRec = ImportFile.nextLine();
        ProcessCustomer.SplitCustomer(ImportRec);
        ProcessProduct.SplitProduct(ImportRec);
        ProcessSalesRep.SplitSalesRep(ImportRec);
        ProcessOrder.SplitOrder(ImportRec);
     }
    
    ImportFile.close();
    
    ProcessCustomer.CustomerSaveRec();
    ProcessProduct.ProductSaveRec();
    ProcessSalesRep.SalesRepSaveRec();
    ProcessOrder.OrderSaveRec();
   
}
}