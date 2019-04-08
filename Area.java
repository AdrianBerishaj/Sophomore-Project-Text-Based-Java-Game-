
package hod_game;

import java.util.Random;
import java.util.Scanner;


public class Area<E> 
{
   Area<E> forelink, backlink;
   int data;
   Scanner scan = new Scanner(System.in);
   Random rand = new Random();
   String input;
   boolean nodeCleared;
   
   public<E> Area(int Encounter_Data, Area initialForeLink, Area initialBackLink)
   {
       forelink = initialForeLink;
       backlink = initialBackLink;
       data = Encounter_Data;
       nodeCleared = false;
   }
   
   public int getData()
   {
       return data;
   }
   
   public void setData(int newData)
   {
       data = newData;
   }
   public Area getForeLink() // command "forward"
   {
       return forelink;
   }
   
   public Area getBackLink() // command "back"
   {
       return backlink;
   }
   
   public void addNode(int data)
   {
       this.forelink = new Area(data, this.forelink, this);
       System.out.println("Data: " + data);
   }
   
   public void ensureBoss()
   {
      this.addNode(3);
   }
   
   public void ensureExit()
   {
     this.addNode(4);
   }
   
   public static int listLength(Area head) // FOR TESTING PURPOSES
    {
        Area cursor;
        int answer = 0;
        for(cursor = head; cursor!=null; cursor = cursor.getForeLink())
            answer++;
        System.out.println(answer);      //LENGTH OF AREA
        return answer;
    }
}