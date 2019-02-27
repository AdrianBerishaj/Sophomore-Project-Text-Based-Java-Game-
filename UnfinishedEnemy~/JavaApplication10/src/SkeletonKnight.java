
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



public class SkeletonKnight extends Enemy {

    
    
    public SkeletonKnight(int lvl, int health, int def, int maxAtt, int minAtt){
        this.lvl = 1;
        this.health = 35;
        this.def = 2;
        this.maxAtt = 6;
        this.minAtt = 0;
  }
    public int attack() {
		Random rand = new Random();
		int damage = rand.nextInt(7); 
		return damage;
	}
    
            
        }

     
