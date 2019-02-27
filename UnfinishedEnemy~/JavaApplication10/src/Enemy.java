
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adrian
 */

public class Enemy extends Character {
    String enemyType[] = {"Skeleton Knight", "Lesser Imp", "Undead Mage"};
    int lvl, enemyHealth, maxAtt, minAtt, def;
    Random rand = new Random();
    String enemy = enemyType[rand.nextInt(enemyType.length)];
    
   int attack() {
		Random randatt = new Random();
		int enemyDamage = randatt.nextInt(10); 
		int playerDamage= randatt.nextInt();
                
                enemyHealth -= playerDamage;
                this.health -= enemyDamage;
        
                return 0;
   
        
    
                
                
   }
   public void damageDealt(int loss){
        this.enemyHealth = enemyHealth - loss;
        if (this.enemyHealth <= 0){ 
            System.out.println("Enemy Slain");
        }
   }
}
