/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transaction;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Dhairyashil
 */
public class Retrieve {
            
            private static String URL_ITEMS = "http://ccf.esy.es/getCardDet.php";
            private static final String TAG_DB = "cards";
            private static final String TAG_ID = "CARD_ID";
            private static final String TAG_AUTH = "AUTH";
            private static final String TAG_CURBB = "CUR_BB";
            private static final String TAG_CU = "CU";
            private static final String TAG_AVGBB = "AVG_BB";
            private static final String TAG_OD = "OD";
            private static final String TAG_AGE = "CC_AGE";
            private static final String TAG_LOC = "LOC";
            private static final String TAG_LOCC = "LOC_CODE";
            private static final String TAG_ODC = "OD_CODE";
            private static final String TAG_AMT = "AMOUNT";
            static JSONArray matchFixture = null;
            static ArrayList<HashMap<String, String>> matchFixtureList = new ArrayList<HashMap<String, String>>();
            static ServiceHandler serviceClient = new ServiceHandler();
            private static String json = serviceClient.makeServiceCall(URL_ITEMS,ServiceHandler.GET);
            


        public static void main(String args[])
        {
            if(json!=null)
            {
                File file;
                FileWriter fw = null;
                BufferedWriter bw = null;
                
                try {
                    JSONObject jsonObj = new JSONObject(json);
                    // Getting JSON Array node
                    matchFixture = jsonObj.getJSONArray(TAG_DB);
                try
                {
                    file =new File("C:\\Users\\kimaya\\Desktop\\Transaction\\src\\transaction\\Transactions.txt");
                        
                        //Specify the file name and path here
         
                        if(!file.exists()){
                        file.createNewFile();
                        }

                        //Here true is to append the content to file
                        fw = new FileWriter(file);
                        //BufferedWriter writer give better performance
                        bw = new BufferedWriter(fw);
                        bw.write("");
                        bw.write("CardID,Auth,Cur.BB,CU,Avg.BB,OD,CCAge,Loc,LocCode,ODCode,AmtT" + "\n");
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                    int len = matchFixture.length();
                    for (int i = 0; i < len; i++) {
                        JSONObject c = matchFixture.getJSONObject(i);
                        String id = c.getString(TAG_ID);
                        String auth = c.getString(TAG_AUTH);
                        String curbb = c.getString(TAG_CURBB);
                        String avg = c.getString(TAG_AVGBB);
                        String cu = c.getString(TAG_CU);
                        String age = c.getString(TAG_AGE);
                        String od = c.getString(TAG_OD);
                        String odc = c.getString(TAG_ODC);
                        String loc = c.getString(TAG_LOC);
                        String locc = c.getString(TAG_LOCC);
                        String amt = c.getString(TAG_AMT);
                        System.out.println(id);
                        System.out.println(auth);
                        System.out.println(curbb);
                        System.out.println(avg);
                        System.out.println(cu);
                        System.out.println(age);
                        System.out.println(od);
                        System.out.println(odc);
                        System.out.println(loc);
                        System.out.println(locc);
                        System.out.println(amt);
                        //CardID,Auth,Cur.BB,CU,Avg.BB,OD,CCAge,Loc,LocCode,ODCode,AmtT
                        try
                        {
                            String content=new String();
                          content = "" + id + "," + auth + "," + curbb + "," + cu + "," + avg + "," + od + "," + age + "," + loc + "," + locc + "," + odc + "," + amt + "\n";  
                        bw.write(content);
                        //Closing BufferedWriter Stream
                        
                        }
                        catch(IOException e)
                        {
                            System.out.print(e);
                        }
                        
                        //  hashmap for single match
                        //HashMap<String, String> matchFixture = new HashMap<String, String>();
                        // adding each child node to HashMap key => value
                        //matchFixture.put(TAG_MATCHID, matchId);
                        //matchFixture.put(TAG_TEAMA, teamA);
                        //matchFixture.put(TAG_TEAMB, teamB);
                        //matchFixtureList.add(matchFixture);
                        
                    }
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
                
                try {
                    bw.close();
                } catch (IOException ex) {
                    Logger.getLogger(Retrieve.class.getName()).log(Level.SEVERE, null, ex);
                }
        
            }
            
        }
}
