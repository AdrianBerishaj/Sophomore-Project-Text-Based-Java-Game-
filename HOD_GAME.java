
package hod_game;

import java.util.Random;
import java.util.Scanner;


public class HOD_GAME {

   
    public static void main(String[] args) 
    {
        boolean running = true;
        boolean selection = true;
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        Character player = new Character(); 
        player.getDifficulty();
        player.getName();
        player.getCharClass();
        player.getStats();      //depending on class, give starting inventory
        switch(player.gameClass)
        {
            case "Knight": 
                Items longsword = new Items("longsword",0,3,0,0,0,0,0,0,0,0,0,0,0,0,1); //gives +3 str
                Items chainmail = new Items("Chainmail",0,0,0,3,0,0,0,0,0,0,0,0,0,0,2); // gives +3 con
                player.equipment=longsword.ADDequipment(player.equipment);
                player.equipment=chainmail.ADDequipment(player.equipment);
                player.stats=longsword.ADDstats(player.stats);
                player.stats=chainmail.ADDstats(player.stats);
                
            case "Cleric":
                Items mace = new Items("mace",0,2,0,0,0,0,0,0,0,0,0,0,0,0,1); //gives +2 str
                Items robes = new Items("Chainmail",0,0,0,2,0,0,0,0,0,0,0,0,0,0,2); // gives +2 con
                player.equipment=mace.ADDequipment(player.equipment);
                player.equipment=robes.ADDequipment(player.equipment);
                player.stats=mace.ADDstats(player.stats);
                player.stats=robes.ADDstats(player.stats);
                
            case "Ranger":
                Items bow = new Items("bow",0,0,3,0,0,0,0,0,0,0,0,0,0,0,1); //gives +3 dex
                Items BLK_leather = new Items("BLK_leather",0,0,0,3,0,0,0,0,0,0,0,0,0,0,2); // gives +3 con
                player.equipment=bow.ADDequipment(player.equipment);
                player.equipment=BLK_leather.ADDequipment(player.equipment);
                player.stats=bow.ADDstats(player.stats);
                player.stats=BLK_leather.ADDstats(player.stats);
                
            case "Sorcerer":
                Items staff = new Items("staff",0,0,0,0,3,0,0,0,0,0,0,0,0,0,1); //gives +3 int
                Items BLK_robes = new Items("BLK_robes",0,0,0,3,0,0,0,0,0,0,0,0,0,0,2); // gives +3 con
                player.equipment=staff.ADDequipment(player.equipment);
                player.equipment=BLK_robes.ADDequipment(player.equipment);
                player.stats=staff.ADDstats(player.stats);
                player.stats=BLK_robes.ADDstats(player.stats);
        }
        while(running)
        {
            while(selection)
           {
               System.out.println("\n\twhat would you like to do?\n\t1. equip sword\t2. equip armor\t3. use potion\t4. end game");
               String choice;
               choice = scan.nextLine();
               if(choice.equals("1"))
               {
                   
               }
               if(choice.equals("2"))
               {
                   
               }
               if(choice.equals("3"))
               {
                   
               }
               if(choice.equals("4"))
               {
                   selection = false;
                   running = false;
               }
               if(choice.equals("stats"))
               {
                   player.showStats();
               }
               if(choice.equals("equip"))
               {
                   player.showEquip();
               }
               if(choice.equals("bag"))
               {
                   player.showInv();
               }
           }
       }
        }
        
    }
    
  
