package textfileread;

import java.io.File;
import java.io.PrintWriter;
import java.io.FileOutputStream;

public class customer {
    String CustID;
    String CustFirstName;
    String CustLastName;
    String CustAddress;
    String CustCity;
    String CustZip;
    
    String[] aCustID = new String[10000];
    String[] aCustFirstName = new String[10000];
    String[] aCustLastName = new String[10000];
    String[] aCustAddress = new String[10000];
    String[] aCustCity = new String[10000];
    String[] aCustZip = new String[10000];
    
    
    customer(){
    CustID = "";
    CustFirstName = "";
    CustLastName = "";
    CustAddress = "";
    CustCity = "";
    CustZip = "";
    }
    
    public void SplitCustomer (String Rec) {
    
        CustID = GetCustID(Rec);
        aCustID[GetCustIndex(Rec)] = CustID;
    
        aCustFirstName[GetCustIndex(Rec)] = GetCustFirstName(Rec);
        aCustLastName[GetCustIndex(Rec)] = GetCustLastName(Rec);
        aCustAddress[GetCustIndex(Rec)] = GetCustAddress(Rec);
        aCustCity[GetCustIndex(Rec)] = GetCustCity(Rec);
        aCustZip[GetCustIndex(Rec)] = GetCustZip(Rec);
    }
    
    public void CustomerSaveRec()throws Exception {
        
        File CustFile = new File("customer.Dat");
        Boolean Append = false; 
        PrintWriter SaveRec = new PrintWriter(new FileOutputStream( CustFile, Append));
        
        for (int i=1; i <10000;i++){
             if (aCustID[i]!= null){
                System.out.print( i + " " + aCustID[i]  + " ");
                System.out.println( aCustFirstName[i]);
                System.out.println( aCustLastName[i]);
                System.out.println( aCustAddress[i]);
                System.out.println( aCustCity[i]);
                System.out.println( aCustZip[i]);
                
                SaveRec.println(aCustID[i]);
                SaveRec.println(aCustFirstName[i]);
                SaveRec.println(aCustLastName[i]);
                SaveRec.println(aCustAddress[i]);
                SaveRec.println(aCustCity[i]);
                SaveRec.println(aCustZip[i]);
            }
        }
        SaveRec.close();
    }
    
    
    public String  GetCustID (String Rec) {
        return Rec.substring(0,20).trim();
    }
    
    public int GetCustIndex (String Rec) {
        int idx=0;
        
         try {    
          idx = Integer.parseInt(Rec.substring(0,20).trim());
        }
        catch (Exception e) { 
        
             idx= 0;
            
        }
        
        return idx;
     }
    
    
    public String GetCustFirstName (String Rec) {
    CustFirstName = Rec.substring(20,45).trim();
    return CustFirstName;
    }
    public String GetCustLastName (String Rec) {
    CustLastName = Rec.substring(45,70).trim();
    return CustLastName;
    }
    public String GetCustAddress (String Rec) {
    CustAddress = Rec.substring(70,120).trim();
    return CustAddress;
    }
    public String GetCustCity (String Rec) {
    CustCity = Rec.substring(120,140).trim();
    return CustCity;
    }
    public String GetCustZip (String Rec) {
    CustZip = Rec.substring(140,160).trim();
    return CustZip;
    }
    
}