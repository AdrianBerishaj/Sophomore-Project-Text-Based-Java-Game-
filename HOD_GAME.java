package hod_game;

import java.util.Arrays;
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
          
            if(player.gameClass.equalsIgnoreCase("Knight"))
            {
                Items longsword = new Items("longsword",0,3,0,0,0,0,0,0,0,0,0,0,0,0,1); //gives +3 str
                Items chainmail = new Items("Chainmail",0,0,0,3,0,0,0,0,0,0,0,0,0,0,2); // gives +3 con
                player.equipment = longsword.ADDequipment(player.equipment);
                player.equipment = chainmail.ADDequipment(player.equipment);
                player.stats = longsword.ADDstats(player.stats);
                player.stats = chainmail.ADDstats(player.stats);
            }
             if(player.gameClass.equalsIgnoreCase("Cleric"))
            {
            
                Items mace = new Items("mace",0,2,0,0,0,0,0,0,0,0,0,0,0,0,1); //gives +2 str
                Items robes = new Items("Chainmail",0,0,0,2,0,0,0,0,0,0,0,0,0,0,2); // gives +2 con
                player.equipment=mace.ADDequipment(player.equipment);
                player.equipment=robes.ADDequipment(player.equipment);
                player.stats=mace.ADDstats(player.stats);
                player.stats=robes.ADDstats(player.stats);
            } 
              if(player.gameClass.equalsIgnoreCase("Ranger"))
            {
           
                Items bow = new Items("bow",0,0,3,0,0,0,0,0,0,0,0,0,0,0,1); //gives +3 dex
                Items BLK_leather = new Items("BLK_leather",0,0,0,3,0,0,0,0,0,0,0,0,0,0,2); // gives +3 con
                player.equipment=bow.ADDequipment(player.equipment);
                player.equipment=BLK_leather.ADDequipment(player.equipment);
                player.stats=bow.ADDstats(player.stats);
                player.stats=BLK_leather.ADDstats(player.stats);
            }
               if(player.gameClass.equalsIgnoreCase("Sorcerer"))
            {
            
                Items staff = new Items("staff",0,0,0,0,3,0,0,0,0,0,0,0,0,0,1); //gives +3 int
                Items BLK_robes = new Items("BLK_robes",0,0,0,3,0,0,0,0,0,0,0,0,0,0,2); // gives +3 con
                player.equipment=staff.ADDequipment(player.equipment);
                player.equipment=BLK_robes.ADDequipment(player.equipment);
                player.stats=staff.ADDstats(player.stats);
                player.stats=BLK_robes.ADDstats(player.stats);
            }
      while(running)
      {
          
      
          String[] enemies = {"evil zombie boi", "evil skeley boi", "super evil boi"};
          int maxEnemyHealth = 75;
          int enemyATK = 25;
          
          int enemyHP = rand.nextInt(maxEnemyHealth);
          String enemy = enemies[rand.nextInt(enemies.length)];
          System.out.println("\n\n\t" + enemy + " has appeared!");
          while(enemyHP > 0)
          {
              System.out.println("\tyour HP: " + player.stats[0]);
              System.out.println("\t" + enemy + "'s HP: " + enemyHP);
              System.out.println("\n\twhat would you like to do?");
              System.out.println("\n\t1. check stats, 2. check equipment, 3. check inventory, 4. attack!");
              String input = scan.nextLine();
              if(input.equals("4"))
              {
                  int dmgDealt = rand.nextInt(player.stats[1]);
                  int dmgTaken = rand.nextInt(enemyATK);
                  
                  enemyHP -= dmgDealt;
                  player.stats[0] -= dmgTaken;
                  
                  System.out.println("\n\tYou have done " + dmgDealt + " damage, but " + enemy + " has done " + dmgTaken + " damage back!");
                  if(player.stats[0] < 1)
                  {
                      System.out.println("YOU DIED");
                      running = false;
                      break;
                  }
                  if(enemyHP < 0)
                  {
                      System.out.println("\n\tYou have slain: " + enemy + ", one of the many evil bois.");
                      break;
                  }
              }
              else if(input.equals("3"))
              {
                  System.out.println(Arrays.toString(player.inventory));
              }
              else if(input.equals("2"))
              {
                  System.out.println(Arrays.toString(player.equipment));
              }
              else if(input.equals("1"))
              {
                  player.showStats();
              }
              else
              {
                  System.out.println("enter a valid input!");
              }
          }
          System.out.println("\n\n\tThe demo has come to an end, more evil bois await in the future");
          running = false;
          break;
     }       
       
    }
}       
    
    
  
