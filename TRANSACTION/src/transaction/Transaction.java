/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transaction;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


class Transaction
{
    static String[] users = new String[20];
   public static void main( String[] args ) throws IOException
   {	
       Path file1 = Paths.get("C:\\Users\\kimaya\\Desktop\\Transaction\\src\\transaction\\Transactions.txt");
       List<String> lines = Files.readAllLines(file1, StandardCharsets.UTF_8);
       String[][] dat = new String[40][12];
       for(int i=0;i<lines.size();i++)
       {
           System.out.println(lines.get(i)+"  "+lines.size());
           dat[i] = lines.get(i).split(",");
       }
       
       String[][] items = new String[lines.size()][12];
       int strength=1;
       int l=1;
       System.out.println(dat[l][0]+"   "+dat[l+1][0]);
       items[strength-1][0]=dat[l][0];
       while(l<lines.size()-1)
       {
           if(dat[l][0].equals(dat[l+1][0]))
           {
               l++;
           }else
           {
               l++;
               items[strength][0]=dat[l][0];
               strength++;
           }
       }
       System.out.println(strength+"    "+l);
       System.out.println(dat[1][0]+"   "+items[0][0]);
       for(int h=0;h<strength;h++)
       {
           int count=0;
           int amount=0;
           int f=0;
           int OD=0;
           for(int g=1;g<lines.size();g++)
           {   
               if(items[h][0].equals(dat[g][0]))
               {
                   count++;
                   items[h][1]="111";
                   items[h][2]=dat[g][2];
                   items[h][3]=dat[g][3];
                   items[h][4]=dat[g][4];
                   items[h][5]=dat[g][5];
                   items[h][6]=dat[g][6];
                   items[h][7]=count+"";
                   items[h][8]=dat[g][7];
                   items[h][9]=count+"";
                   if(dat[g][9]=="1")
                   OD=1;
                   items[h][10]=""+OD;
                   f=amount+Integer.parseInt(dat[g][10]);
                   items[h][11]=f+"";
                   amount=f;
               }
           }
       }
       
       for(int k=0;k<strength;k++)
       for(int j=0;j<12;j++)
       {
           System.out.println(items[k][j]);
       }

       
       
       
       
      try{
          String content=new String();
        for(int d=0;d<strength;d++)
        {
    	content = content+"\n"+items[d][0]+","+items[d][1]+","+items[d][2]+","+items[d][3]+","+items[d][4]+","+items[d][5]+","+items[d][6]+","+items[d][7]+","+items[d][8]+","+items[d][9]+","+items[d][10]+","+items[d][11]+"\n";
        }
        //Specify the file name and path here
    	File file =new File("C:\\Users\\kimaya\\Desktop\\Base.txt");

    	/* This logic is to create the file if the
    	 * file is not already present
    	 */
       
    	if(!file.exists()){
    	   file.createNewFile();
    	}

    	//Here true is to append the content to file
    	FileWriter fw = new FileWriter(file,true);
    	//BufferedWriter writer give better performance
    	BufferedWriter bw = new BufferedWriter(fw);
    	bw.write(content);
    	//Closing BufferedWriter Stream
    	bw.close();

        }catch(IOException ioe){
         System.out.println("Exception occurred:");
    	 ioe.printStackTrace();
       }
   }
}