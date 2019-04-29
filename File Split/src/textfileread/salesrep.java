package textfileread;

import java.io.File;
import java.io.PrintWriter;
import java.io.FileOutputStream;

public class salesrep {
    String SalesRepID;
    String SalesRepFirstName;
    String SalesRepLastName;
    String SalesRepAddress;
    String SalesRepCity;
    String SalesRepZip;
    String SalesRepTitle;
    String SalesRepDateOfHire;

    String[] aSalesRepID = new String[10000];
    String[] aSalesRepFirstName = new String[10000];
    String[] aSalesRepLastName = new String[10000];
    String[] aSalesRepAddress = new String[10000];
    String[] aSalesRepCity = new String[10000];
    String[] aSalesRepZip = new String[10000];
    String[] aSalesRepTitle = new String[10000];
    String[] aSalesRepDateOfHire = new String[10000]; 
    
    salesrep (){
    SalesRepID = "";
    SalesRepFirstName = "";
    SalesRepLastName = "";
    SalesRepAddress = "";
    SalesRepCity = "";
    SalesRepZip = "";
    SalesRepTitle = "";
    SalesRepDateOfHire = "";
    
    }
    
    public void SplitSalesRep (String Rec) {
    
        SalesRepID = GetSalesRepID(Rec);
        aSalesRepID[GetSalesRepIndex(Rec)] = SalesRepID;
    
        aSalesRepFirstName[GetSalesRepIndex(Rec)] = GetSalesRepFirstName(Rec);
        aSalesRepLastName[GetSalesRepIndex(Rec)] = GetSalesRepLastName(Rec);
        aSalesRepAddress[GetSalesRepIndex(Rec)] = GetSalesRepAddress(Rec);
        aSalesRepCity[GetSalesRepIndex(Rec)] = GetSalesRepCity(Rec);
        aSalesRepZip[GetSalesRepIndex(Rec)] = GetSalesRepZip(Rec);
        aSalesRepTitle[GetSalesRepIndex(Rec)] = GetSalesRepTitle(Rec);
        aSalesRepDateOfHire[GetSalesRepIndex(Rec)] = GetSalesRepDateOfHire(Rec);

    }
    
    public void SalesRepSaveRec()throws Exception {
        
        File SalesRepFile = new File("salesrep.Dat");
        Boolean Append = false; 
        PrintWriter SaveSalesRepRec = new PrintWriter(new FileOutputStream( SalesRepFile, Append));
        
        for (int i=1; i <10000;i++){
             if (aSalesRepID[i]!= null){
                System.out.print( i + " " + aSalesRepID[i]  + " ");
                System.out.println( aSalesRepFirstName[i]);
                System.out.println( aSalesRepLastName[i]);
                System.out.println( aSalesRepAddress[i]);
                System.out.println( aSalesRepCity[i]);
                System.out.println( aSalesRepZip[i]);
                System.out.println( aSalesRepTitle[i]);
                System.out.println( aSalesRepDateOfHire[i]);

                SaveSalesRepRec.println(aSalesRepID[i]);
                SaveSalesRepRec.println(aSalesRepFirstName[i]);
                SaveSalesRepRec.println(aSalesRepLastName[i]);
                SaveSalesRepRec.println(aSalesRepAddress[i]);
                SaveSalesRepRec.println(aSalesRepCity[i]);
                SaveSalesRepRec.println(aSalesRepZip[i]);
                SaveSalesRepRec.println(aSalesRepTitle[i]);
                SaveSalesRepRec.println(aSalesRepDateOfHire[i]);
                
            }
        }
        SaveSalesRepRec.close();
    }
    
    
    public String  GetSalesRepID (String Rec) {
        return Rec.substring(285,305).trim();
    }
    
    public int GetSalesRepIndex (String Rec) {
        int idx = 0;
        
         try {    
            idx = Integer.parseInt(Rec.substring(285,305).trim());
        }
        catch (Exception e) { 
        
             idx = 0;
       
        }
        
        return idx;
     }
    
    
    public String GetSalesRepFirstName (String Rec) {
    SalesRepFirstName = Rec.substring(305,330).trim();
    return SalesRepFirstName;
    }
    
    public String GetSalesRepLastName (String Rec) {
    SalesRepLastName = Rec.substring(330,355).trim();
    return SalesRepLastName;
    }
    
    public String GetSalesRepAddress (String Rec) {
    SalesRepAddress = Rec.substring(355,405).trim();
    return SalesRepAddress;
    }
    
    public String GetSalesRepCity (String Rec) {
    SalesRepCity = Rec.substring(405,425).trim();
    return SalesRepCity;
    }
    
    public String GetSalesRepZip (String Rec) {
    SalesRepLastName = Rec.substring(425,445).trim();
    return SalesRepLastName;
    }
    
    public String GetSalesRepTitle (String Rec) {
    SalesRepTitle = Rec.substring(445,470).trim();
    return SalesRepTitle;
    }
    
    public String GetSalesRepDateOfHire (String Rec) {
    SalesRepDateOfHire = Rec.substring(470,480).trim();
    return SalesRepDateOfHire;
    }
}