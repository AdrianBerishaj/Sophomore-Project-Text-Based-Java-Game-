
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
public class UndeadMage extends Enemy {
    public UndeadMage(int lvl, int health, int def, int maxAtt, int minAtt){
        this.lvl = 1;
        this.health = 25;
        this.def = 1;
        this.maxAtt = 3;
        this.minAtt = 0;
  }
    public int attack() {
		Random rand = new Random();
		int damage = rand.nextInt(4); 
		return damage;
	}
}
