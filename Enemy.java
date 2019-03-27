/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Random;
/**
 *
 * @author Adrian
 * 
 */
public class Enemy extends Character {
    String enemyType[] = {"Skeleton Knight", "Lesser Imp", "Undead Mage"};
    int lvl, enemyHealth, enemyatt, damageDealt, str, dex, con, intel, wis, cha; ;
    Random rand = new Random();
    String enemy = enemyType[rand.nextInt(enemyType.length)];
    int[] enemyStats;
    private String damageTaken;
    public Enemy(String enemyType, int lvl, int enemyHealth, int str, int dex, int con, int intel, int wis, int cha)
    {
        
        this.enemyHealth = 50 + ( 10*con);
        
        enemyStats = new int[]{lvl, enemyHealth, str, dex, con, intel, wis, cha};                  
    }
        
   public void getEnemy()
           {
               System.out.println("\n\n\t" + enemy + " has appeared! What shall you do!?!?");
           }
    
   int EnemyAttack() 
   {
		Random randatt = new Random();
		int enemyDamage = randatt.nextInt(enemyStats[2]); 
		int playerDamage= randatt.nextInt();

                enemyHealth -= playerDamage;
                health -= enemyDamage;
        
                return 0;
     }
   
   
   public void damageDealt(int loss)
   {
       
        this.enemyHealth = enemyHealth - loss;
        System.out.println("\n\tYou have done " + damageDealt + " damage, but " + enemy + " has done " + damageTaken + " damage back!");
        if (this.enemyHealth <= 0){ 
            System.out.println("Enemy Has Been Yeeted");
        }
     
   }
}