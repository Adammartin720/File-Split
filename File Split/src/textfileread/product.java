package textfileread;

import java.io.File;
import java.io.PrintWriter;
import java.io.FileOutputStream;

public class product {
    String ProductID;
    String ProductName;
    String ProductPrice;

    String[] aProductID = new String[10000];
    String[] aProductName = new String[10000];
    String[] aProductPrice = new String[10000]; 
    
    product(){
    ProductID = "";
    ProductName = "";
    ProductPrice = "";
    }
    
    public void SplitProduct (String Rec) {
    
        ProductID = GetProductID(Rec);
        aProductID[GetProductIndex(Rec)] = ProductID;
    
        aProductName[GetProductIndex(Rec)] = GetProductName(Rec);
        aProductPrice[GetProductIndex(Rec)] = GetProductPrice(Rec);

    }
    
    public void ProductSaveRec()throws Exception {
        
        File ProductFile = new File("product.Dat");
        Boolean Append = false; 
        PrintWriter SaveProdRec = new PrintWriter(new FileOutputStream( ProductFile, Append));
        
        for (int i=1; i <10000;i++){
             if (aProductID[i]!= null){
                System.out.print( i + " " + aProductID[i]  + " ");
                System.out.println( aProductName[i]);
                System.out.println( aProductPrice[i]);

                
                SaveProdRec.println(aProductID[i]);
                SaveProdRec.println(aProductName[i]);
                SaveProdRec.println(aProductPrice[i]);
            }
        }
        SaveProdRec.close();
    }
    
    
    public String  GetProductID (String Rec) {
        return Rec.substring(195,215).trim();
    }
    
    public int GetProductIndex (String Rec) {
        int idx = 0;
        
         try {    
            idx = Integer.parseInt(Rec.substring(195,215).trim());
        }
        catch (Exception e) { 
        
             idx = 0;
       
        }
        
        return idx;
     }
    
    
    public String GetProductName (String Rec) {
    ProductName = Rec.substring(215,265).trim();
    return ProductName;
    }
    public String GetProductPrice (String Rec) {
    ProductPrice = Rec.substring(265,285).trim();
    return ProductPrice;
    }
    
}