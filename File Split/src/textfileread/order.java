package textfileread;

import java.io.File;
import java.io.PrintWriter;
import java.io.FileOutputStream;

public class order {
    String OrderID;
    String OrderDate;
    
    String CustID;
    String ProductID;
    String SalesRepID;

    String[] aOrderID = new String[10000];
    String[] aOrderDate = new String[10000];
    
    String[] aCustID = new String[10000];
    String[] aProductID = new String[10000];
    String[] aSalesRepID = new String[10000];
    
    order(){
    OrderID = "";
    OrderDate = "";
    
    CustID = "";
    ProductID = "";
    SalesRepID = "";
    }
    
    public void SplitOrder (String Rec) {
        OrderID = GetOrderID(Rec);
        aOrderID[GetOrderIndex(Rec)] = OrderID;
    
        aOrderDate[GetOrderIndex(Rec)] = GetOrderDate(Rec);
        
        
        aCustID[GetOrderIndex(Rec)] = GetCustID(Rec);
        aProductID[GetOrderIndex(Rec)] = GetProductID(Rec);
        aSalesRepID[GetOrderIndex(Rec)] = GetSalesRepID(Rec);
    }
    
    public void OrderSaveRec()throws Exception {
        
        File OrderFile = new File("order.Dat");
        Boolean Append = false; 
        PrintWriter SaveOrderRec = new PrintWriter(new FileOutputStream( OrderFile, Append));
        
        for (int i=1; i <10000;i++){
             if (aOrderID[i]!= null){
                System.out.print( i + " " + aOrderID[i]  + " ");
                System.out.println( aOrderDate[i]);
                
                System.out.println( aCustID[i]);
                System.out.println( aProductID[i]);
                System.out.println( aSalesRepID[i]);
                

                
                SaveOrderRec.println(aOrderID[i]);
                SaveOrderRec.println(aOrderDate[i]);
                
                SaveOrderRec.println(aCustID[i]);
                SaveOrderRec.println(aProductID[i]);
                SaveOrderRec.println(aSalesRepID[i]);
            }
        }
        SaveOrderRec.close();
    }
    
    public String GetOrderID (String Rec) {
    OrderID = Rec.substring(160,180).trim();
    return OrderID;
    }
    
    public int GetOrderIndex (String Rec) {
        int idx = 0;
        
         try {    
            idx = Integer.parseInt(Rec.substring(160,180).trim());
        }
        catch (Exception e) { 
        
             idx = 0;
       
        }
        return idx;
     }
    
    
    
    public String GetOrderDate (String Rec) {
    OrderDate = Rec.substring(180,195).trim();
    return OrderDate;
    }
    
    
    public String  GetCustID (String Rec) {
        return Rec.substring(0,20).trim();
    }
    
    public String  GetProductID (String Rec) {
        return Rec.substring(195,215).trim();
    }
    
    public String  GetSalesRepID (String Rec) {
        return Rec.substring(285,305).trim();
    }
    
    
}


