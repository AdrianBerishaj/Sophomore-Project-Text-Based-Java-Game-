package hod_game;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/////GUI/////
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class HOD_GAME {

   
    public static void main(String[] args) throws IOException 
    {
         
        boolean running = true;
        boolean selection = true;
        String input;
        Items dummy = new Items("Dummy Item for Method Calling",0,0,0,0,0,0,0,0,0,0,0,0,0,0,1);
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        Character player = new Character(); 
        player.getDifficulty();
        player.getName();
        player.getCharClass();
        player.getStats();      //depending on class, give starting inventory
          
            if(player.gameClass.equalsIgnoreCase("Knight"))
            {
                Items longsword = new Items("Longsword",0,3,0,0,0,0,0,0,0,0,0,0,0,0,1);
                Items chainmail = new Items("Chainmail",0,0,0,3,0,0,0,0,0,0,0,0,0,0,3);
                player.equipment = longsword.ADDequipment(player.equipment);
                player.equipment = chainmail.ADDequipment(player.equipment);
                player.stats = longsword.ADDstats(player.stats);
                player.stats = chainmail.ADDstats(player.stats);
            }
             if(player.gameClass.equalsIgnoreCase("Cleric"))
            {
                Items robes = new Items("Robes",0,0,0,2,0,0,0,0,0,0,0,0,0,0,3);
                Items mace = new Items("Mace",0,2,0,0,0,0,0,0,0,0,0,0,0,0,1);
                player.equipment=mace.ADDequipment(player.equipment);
                player.equipment=robes.ADDequipment(player.equipment);
                player.stats=mace.ADDstats(player.stats);
                player.stats=robes.ADDstats(player.stats);
            } 
              if(player.gameClass.equalsIgnoreCase("Ranger"))
            {
                Items bow = new Items("Bow",0,0,3,0,0,0,0,0,0,0,0,0,0,0,2);
                Items BLK_leather = new Items("Black Leather Armor",0,0,0,3,0,0,0,0,0,0,0,0,0,0,3);
                player.equipment=bow.ADDequipment(player.equipment);
                player.equipment=BLK_leather.ADDequipment(player.equipment);
                player.stats=bow.ADDstats(player.stats);
                player.stats=BLK_leather.ADDstats(player.stats);
            }
               if(player.gameClass.equalsIgnoreCase("Sorcerer"))
            {         
                Items staff = new Items("Staff",0,0,0,0,3,0,0,0,0,0,0,0,0,0,2);
                Items BLK_robes = new Items("Black Robes",0,0,0,3,0,0,0,0,0,0,0,0,0,0,3);
                player.equipment=staff.ADDequipment(player.equipment);
                player.equipment=BLK_robes.ADDequipment(player.equipment);
                player.stats=staff.ADDstats(player.stats);
                player.stats=BLK_robes.ADDstats(player.stats);
            }
               int MAX_HEALTH = player.stats[0];
               boolean TrueNameRevealed = false;
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
            /////////////////////////////AREA 1 CREATION/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
               Area area1 = new Area(0, null, null);
               int area1_L = rand.nextInt(3) + 5;
               //System.out.println(area1_L);
               area1.ensureExit();
               area1.ensureBoss();
               for(int i = 0; i<area1_L-1; i++)
               {
                   area1.addNode(rand.nextInt(3));
                   //area1.addNode(0);
               }
               //Area.listLength(area1);
               Area area1_pp = area1;
               Chest area1_chest = new Chest();
               Enemy a1_enemy = new Enemy(1, 1, 1, 1, 1, 1, 1, 1);
               a1_enemy.newEnemy(player.getDiffNum());
               /////////////////////////////AREA 1 CREATION////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
               ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
               ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      while(running)
      {
       
          boolean area1_cleared = false;
          boolean area2_cleared = false;
          boolean area3_cleared = false;
          boolean area4_cleared = false;
          
           System.out.println("\n\t\tAt any time, type \"help\" for a list of basic commands");
           System.out.println("\n\n\t\tYou wake up and you have no clue where you are. It's dark, smells bad, and you feel evil prescenses all around. "
                      + "\n\t\tAll you can remember is who you are, and what you are good at... mostly");
              
            HOD_GAME area1_pic = new HOD_GAME (5);
            while (area1_cleared == false) {
                System.out.println("\n\t\tWhat would you like to do?");
                input = scan.nextLine();
              OUTER_4:
                OUTER_5:
                switch (input) {
                    case "help":
                        player.help();
                        break;
                    case "forward":
                    case "f":
                        area1_pp = area1_pp.getForeLink();
                        //System.out.println(area1_pp.getData());
                        switch (area1_pp.getData()) {
                            case 0:
                                int area1_encounter;
                                area1_encounter = area1.area_1_Encounter(rand.nextInt(4), player.stats[2], player.name);
                                if(area1_encounter<1000)
                                    player.stats[0] = player.stats[0] - area1_encounter;
                                else if(area1_encounter == 1111)
                                {
                                    Items Bandit_Dagger = new Items("Bandit Dagger",0,2,5,0,0,0,0,0,0,0,0,0,0,0,1); //gives +2 str, +5 dex
                                    player.inventory = Bandit_Dagger.ADDinventory(player.inventory);
                                }
                                else if(area1_encounter == 1112)
                                {
                                    Enemy bounty_hunter = new Enemy(5, 100, 15, 15, 8, 5, 5, 3);
                                    int turnsAway = rand.nextInt(3);
                                    System.out.println("\n\n----------------------------F I G H T !!!----------------------------");
                                    System.out.println("combat commands can be pulled up at any time by typing \"combat help\"");
                                    OUTER:
                                    while (true) {
                                        
                                        if(turnsAway > 0)
                                        {
                                            System.out.println("\n\n\tThe enemy is currently " + turnsAway + " turn(s) away!\n\tNow's your chance for ranged attacks "
                                                    + "(type \"ranged attack\"), or just type \"attack\" or \"a\" to charge the enemy straight on!\n\t"
                                                    + "(all skills are considered ranged)\n\t(you can still identify enemy and/or manage items)");
                                        }
                                        System.out.println("\nWhat will you do " + player.name + "?");
                                        input = scan.nextLine();
                                        OUTER_1:
                                        switch (input) {
                                            case "ranged attack":
                                            case "ra":    
                                                if(turnsAway == 0 || turnsAway<0)
                                                {
                                                    System.out.println("\n\tThe enemy is within melee distance! You cannot use ranged attacks right now!");
                                                }
                                                else if(turnsAway > 0)
                                                {
                                                   int weaponChecker = 0;
                                            for (Items equipment : player.equipment) {
                                                if (equipment.typeCheckRanged()) {
                                                    int dmg = rand.nextInt((player.stats[1]/2) + (player.stats[2]/2));
                                                    turnsAway--;
                                                    System.out.println("You deal " + dmg + " to the enemy from afar!\n\tThe enemy is now " + turnsAway + " turn(s) away!");
                                                    bounty_hunter.enemyStats[1] -= dmg;
                                                    break;
                                                } else if (equipment.typeCheckRanged() == false) {
                                                    weaponChecker++;
                                                    if(weaponChecker == 5)
                                                        System.out.println("\n\tYou don't have a ranged weapon in your equipment! You cannot do ranged attacks!");
                                                }
                                            }
                                                }
                                                    break;
                                            case "attack":
                                            case "a":
                                                if(turnsAway > 0)
                                                {
                                                    System.out.println("\n\tEven though the enemy is " + turnsAway + " turn(s) away, you decide to charge them head on!");
                                                }
                                                turnsAway = 0;
                                                if (player.stats[2]>=bounty_hunter.enemyStats[3]) {
                                                    int dmgDealt = rand.nextInt(player.stats[1]);
                                                    int EdmgDealt = rand.nextInt(bounty_hunter.enemyStats[2]);
                                                    System.out.println("The enemy has taken " + dmgDealt + " damage!");
                                                    bounty_hunter.enemyStats[1] -= dmgDealt;
                                                    if (bounty_hunter.enemyStats[1]<0) {
                                                        System.out.println("ENEMY DEFEATED!!!");
                                                        System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                                        System.out.println("\n\n\tUpon killing the bounty hunter, you've looted his Bandit Dagger!");
                                                        Items Bandit_Dagger = new Items("Bandit Dagger",0,2,5,0,0,0,0,0,0,0,0,0,0,0,1); //gives +2 str, +5 dex
                                                        player.inventory = Bandit_Dagger.ADDinventory(player.inventory);
                                                        player.stats[0] = MAX_HEALTH;
                                                        player.skill.recharge();
                                                        int gain = rand.nextInt(15) + 15;
                                                        player.gainExp(gain);
                                                        break OUTER;
                                                    }
                                                    System.out.println("The enemy does " + EdmgDealt + " damage back at you!");
                                                    player.stats[0] -= EdmgDealt;
                                                    if (player.stats[0]<0) {
                                                        System.out.println("YOU DIED");
                                                        System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                        area1_cleared = true;
                                                        area2_cleared = true;
                                                        area3_cleared = true;
                                                        area4_cleared = true;
                                                        running = false;
                                                        break OUTER;
                                                    }
                                                }
                                                if (player.stats[2]<bounty_hunter.enemyStats[3]) {
                                                    int dmgDealt = rand.nextInt(player.stats[1]);
                                                    int EdmgDealt = rand.nextInt(bounty_hunter.enemyStats[2]);
                                                    System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                                    player.stats[0] -= EdmgDealt;
                                                    if (player.stats[0]<0) {
                                                        System.out.println("YOU DIED");
                                                        System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                        area1_cleared = true;
                                                        area2_cleared = true;
                                                        area3_cleared = true;
                                                        area4_cleared = true;
                                                        running = false;
                                                        break OUTER;
                                                    }
                                                    System.out.println("The enemy has taken " + dmgDealt + " damage!");
                                                    bounty_hunter.enemyStats[1] -= dmgDealt;
                                                    if (bounty_hunter.enemyStats[1]<0) {
                                                        System.out.println("ENEMY DEFEATED!!!");
                                                        System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                                        System.out.println("\n\n\tUpon killing the bounty hunter, you've looted his Bandit Dagger!");
                                                        Items Bandit_Dagger = new Items("Bandit Dagger",0,2,5,0,0,0,0,0,0,0,0,0,0,0,1); //gives +2 str, +5 dex
                                                        player.inventory = Bandit_Dagger.ADDinventory(player.inventory);
                                                        player.stats[0] = MAX_HEALTH;
                                                        player.skill.recharge();
                                                        int gain = rand.nextInt(15) + 15;
                                                        player.gainExp(gain);
                                                        break OUTER;
                                                    }
                                                }
                                                break;
                                            case "identify":
                                            case "i":
                                                if(player.stats[5]>=7)
                                                {
                                                    System.out.println("\n\tyou take time to analyze your enemy\n\t...\n\tyou were able to identify their stats!");
                                                    bounty_hunter.showEnemyStats();
                                                }
                                                else
                                                {
                                                    System.out.println("\n\tyou take time to analyze your enemy\n\t...\n\tyou fail to accurately tell their stats...");
                                                }
                                                if(turnsAway>0)
                                                     {
                                                         turnsAway--;
                                                         System.out.println("\n\n\tThe enemy is now " + turnsAway + " turn(s) away!");
                                                     }
                                                     else if(turnsAway == 0 || turnsAway<0)
                                                     {
                                                        int EdmgDealt = rand.nextInt(bounty_hunter.enemyStats[2]);
                                                            System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                                            player.stats[0] -= EdmgDealt;
                                                            if (player.stats[0]<0) 
                                                            {
                                                                System.out.println("YOU DIED");
                                                                System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                                area1_cleared = true;
                                                                area2_cleared = true;
                                                                area3_cleared = true;
                                                                area4_cleared = true;
                                                                running = false;
                                                                break OUTER; 
                                                            }
                                                     }
                                                break;
                                            case "use skill":
                                            case "us":
                                                if(turnsAway > 0)
                                                {
                                                    System.out.println("\n\tEven though the enemy is " + turnsAway + " turn(s) away, you decide to face them right away!");
                                                }
                                                turnsAway = 0;
                                                if(player.skill.uses){
                                                    if(player.skill.getName().equalsIgnoreCase("Blessing")){
                                                        if (player.stats[2]>=bounty_hunter.enemyStats[3]) {
                                                            int EdmgDealt = rand.nextInt(bounty_hunter.enemyStats[2]);
                                                            int HPgained = player.skill.use(player.stats);
                                                            System.out.println("You were healed for " + HPgained + " health points by your skill!");
                                                            player.stats[0] += HPgained;
                                                            System.out.println("The enemy does " + EdmgDealt + " damage back at you!");
                                                            player.stats[0] -= EdmgDealt;
                                                            if (player.stats[0]<0) {
                                                                System.out.println("YOU DIED");
                                                                System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                                area1_cleared = true;
                                                                area2_cleared = true;
                                                                area3_cleared = true;
                                                                area4_cleared = true;
                                                                running = false;
                                                                break OUTER;
                                                            }
                                                        }
                                                        if (player.stats[2]<bounty_hunter.enemyStats[3]) {
                                                            int HPgained = player.skill.use(player.stats);
                                                            int EdmgDealt = rand.nextInt(bounty_hunter.enemyStats[2]);
                                                            System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                                            player.stats[0] -= EdmgDealt;
                                                            if (player.stats[0]<0) {
                                                                System.out.println("YOU DIED");
                                                                System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                                area1_cleared = true;
                                                                area2_cleared = true;
                                                                area3_cleared = true;
                                                                area4_cleared = true;
                                                                running = false;
                                                                break OUTER;
                                                            }
                                                            System.out.println("You were healed for " + HPgained + " health points by your skill!");
                                                            player.stats[0] += HPgained;
                                                        }
                                                    }
                                                    else{
                                                        if (player.stats[2]>=bounty_hunter.enemyStats[3]) {
                                                            int dmgDealt = player.skill.use(player.stats);
                                                            int EdmgDealt = rand.nextInt(bounty_hunter.enemyStats[2]);
                                                            System.out.println("The enemy has taken " + dmgDealt + " damage becuase of your skill!");
                                                            bounty_hunter.enemyStats[1] -= dmgDealt;
                                                            if (bounty_hunter.enemyStats[1]<0) {
                                                                System.out.println("ENEMY DEFEATED!!!");
                                                                System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                                                System.out.println("\n\n\tUpon killing the bounty hunter, you've looted his Bandit Dagger!");
                                                                Items Bandit_Dagger = new Items("Bandit Dagger",0,2,5,0,0,0,0,0,0,0,0,0,0,0,1); //gives +2 str, +5 dex
                                                                player.inventory = Bandit_Dagger.ADDinventory(player.inventory);
                                                                player.stats[0] = MAX_HEALTH;
                                                                player.skill.recharge();
                                                                int gain = rand.nextInt(15) + 15;
                                                                player.gainExp(gain);
                                                                break OUTER;
                                                            }
                                                            System.out.println("The enemy does " + EdmgDealt + " damage back at you!");
                                                            player.stats[0] -= EdmgDealt;
                                                            if (player.stats[0]<0) {
                                                                System.out.println("YOU DIED");
                                                                System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                                area1_cleared = true;
                                                                area2_cleared = true;
                                                                area3_cleared = true;
                                                                area4_cleared = true;
                                                                running = false;
                                                                break OUTER;
                                                            }
                                                        }
                                                        if (player.stats[2]<bounty_hunter.enemyStats[3]) {
                                                            int dmgDealt = player.skill.use(player.stats);
                                                            int EdmgDealt = rand.nextInt(bounty_hunter.enemyStats[2]);
                                                            System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                                            player.stats[0] -= EdmgDealt;
                                                            if (player.stats[0]<0) {
                                                                System.out.println("YOU DIED");
                                                                System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                                area1_cleared = true;
                                                                area2_cleared = true;
                                                                area3_cleared = true;
                                                                area4_cleared = true;
                                                                running = false;
                                                                break OUTER;
                                                            }
                                                            System.out.println("The enemy has taken " + dmgDealt + " damage because of your skill!");
                                                            bounty_hunter.enemyStats[1] -= dmgDealt;
                                                            if (bounty_hunter.enemyStats[1]<0) {
                                                                System.out.println("ENEMY DEFEATED!!!");
                                                                System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                                                System.out.println("\n\n\tUpon killing the bounty hunter, you've looted his Bandit Dagger!");
                                                                Items Bandit_Dagger = new Items("Bandit Dagger",0,2,5,0,0,0,0,0,0,0,0,0,0,0,1); //gives +2 str, +5 dex
                                                                player.inventory = Bandit_Dagger.ADDinventory(player.inventory);
                                                                player.stats[0] = MAX_HEALTH;
                                                                player.skill.recharge();
                                                                int gain = rand.nextInt(15) + 15;
                                                                player.gainExp(gain);
                                                                break OUTER;
                                                            }
                                                        }
                                                    }
                                                }
                                                else
                                                    System.out.println("You cannot use that skill again this battle!");
                                                break;  case "skill info":
                                                case "si":
                                                    System.out.println("\t"+player.skill.getSkillInfo());
                                                    break;
                                                case "equipment":
                                                case"se":
                                                    System.out.println(Arrays.toString(player.equipment));
                                                    break;
                                                case "bag":
                                                case "b":
                                                    System.out.println(Arrays.toString(player.inventory));
                                                    break;
                                                case "use":
                                                case "u":
                                                     System.out.println("What item did you want to use from your bag? Type 1 for first item, 2 for second, and so on.");
                                                     System.out.println("\t" + Arrays.toString(player.inventory));
                                                     try{
                                                         int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                                         if(tempa < player.inventory.length){
                                                            if(player.inventory[tempa] != null){
                                                                if(player.inventory[tempa].typeCheckConsumable()){
                                                                    System.out.println("You use " + player.inventory[tempa].name + ".");
                                                                    player.stats = player.inventory[tempa].ADDstats(player.stats);
                                                                    player.inventory = player.inventory[tempa].dropInventory(player.inventory);
                                                                }
                                                                else
                                                                    System.out.println("That is not a usable item.");
                                                            }
                                                            else
                                                             System.out.println("You do not have an item in that slot.");
                                                         }
                                                         else
                                                             System.out.println("You do not have an item in that slot.");
                                                     }
                                                     catch(NumberFormatException e){
                                                         System.out.println("Please enter a number.");
                                                         break;
                                                     }
                                                     if(turnsAway>0)
                                                     {
                                                         turnsAway--;
                                                         System.out.println("\n\n\tThe enemy is now " + turnsAway + " turn(s) away!");
                                                     }
                                                     else if(turnsAway == 0 || turnsAway<0)
                                                     {
                                                        int EdmgDealt = rand.nextInt(bounty_hunter.enemyStats[2]);
                                                            System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                                            player.stats[0] -= EdmgDealt;
                                                            if (player.stats[0]<0) 
                                                            {
                                                                System.out.println("YOU DIED");
                                                                System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                                area1_cleared = true;
                                                                area2_cleared = true;
                                                                area3_cleared = true;
                                                                area4_cleared = true;
                                                                running = false;
                                                                break OUTER; 
                                                            }
                                                     }
                                                     break;
                                                case "item stats":
                                                case "is":
                                                    System.out.println("Where is this item located?\n\t1. Bag\n\t2. Equipment");
                                                    try {
                                                        int temp = Integer.parseInt(scan.nextLine());
                                                        switch (temp) {
                                                            case 1:
                                                                System.out.println("What item do you want to know the stats for? Type 1 for first item, 2 for second, and so on.");
                                                                System.out.println("\tBag: " + Arrays.toString(player.inventory));
                                                                try {
                                                                    int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                                                    if(player.inventory[tempa] != null){
                                                                        System.out.println(player.inventory[tempa].name + " alters your stats in this way:");
                                                                        player.inventory[tempa].getStats();
                                                                    }
                                                                    else{
                                                                        System.out.println("You do not have an item in that slot. Please try again.");
                                                                    }
                                                                } catch (NumberFormatException e) {
                                                                    System.out.println("Please try again and enter a number.");
                                                                    break OUTER_1;
                                                                }
                                                                break OUTER_1;
                                                            case 2:
                                                                System.out.println("What item do you want to know the stats for? Type 1 for first item, 2 for second, and so on.");
                                                                System.out.println("\tEquipment: " + Arrays.toString(player.equipment));
                                                                try {
                                                                    int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                                                    if(player.equipment[tempa] != null){
                                                                        System.out.println(player.equipment[tempa].name + " alters your stats in this way:");
                                                                        player.equipment[tempa].getStats();
                                                                    }
                                                                    else{
                                                                        System.out.println("You do not have an item in that slot. Please try again.");
                                                                    }
                                                                } catch (NumberFormatException e) {
                                                                    System.out.println("Please try again and enter a number.");
                                                                    break OUTER_1;
                                                                }
                                                                break OUTER_1;
                                                            default:
                                                                System.out.println("Please try again and enter a valid answer.");
                                                                break;
                                                        }
                                                    }catch(NumberFormatException e){
                                                        System.out.println("Please try again and enter a number.");
                                                        break;
                                                    }
                                                    break;
                                                case "stats":
                                                case "s":
                                                    player.showStats();
                                                    break;
                                                case "combat help":
                                                    player.combatHelp();
                                                    break;
                                                default:
                                                    System.out.println("enter a valid command (use \"combat help\" for a list of basic combat commands");
                                                    break;
                                        }
                                    }//NORMAL COMBAT END
                                }
                                else if(area1_encounter == 1113)
                                {
                                    Items DEX_Boost_Potion = new Items("DEX_Boost Potion",0,0,10,0,0,0,0,0,0,0,0,0,0,0,4);
                                    player.inventory = DEX_Boost_Potion.ADDinventory(player.inventory);
                                }
                                break;
                            case 1:
                                a1_enemy.getEnemy();
                                int turnsAway = rand.nextInt(3);
                                System.out.println("\n\n----------------------------F I G H T !!!----------------------------");
                                System.out.println("combat commands can be pulled up at any time by typing \"combat help\"");
                                OUTER:
                                while (true) {
                                    if(turnsAway > 0)
                                        {
                                            System.out.println("\n\n\tThe enemy is currently " + turnsAway + " turn(s) away!\n\tNow's your chance for ranged attacks "
                                                    + "(type \"ranged attack\"), or just type \"attack\" or \"a\" to charge the enemy straight on!\n\t"
                                                    + "(all skills are considered ranged)\n\t(you can still identify enemy and/or manage items)");
                                        }
                                    System.out.println("\nWhat will you do " + player.name + "?");
                                    input = scan.nextLine();
                                    OUTER_2:
                                    switch (input) {
                                        case "ranged attack":
                                        case "ra": 
                                                if(turnsAway == 0 || turnsAway<0)
                                                {
                                                    System.out.println("\n\tThe enemy is within melee distance! You cannot use ranged attacks right now!");
                                                }
                                                else if(turnsAway > 0)
                                                {
                                                   try{
                                        for (Items equipment : player.equipment) 
                                        {
                                            if (equipment.typeCheckRanged())  
                                            {
                                                int dmg = rand.nextInt((player.stats[1]) + (player.stats[2]));
                                                turnsAway--;
                                                System.out.println("You deal " + dmg + " to the enemy from afar!\n\tThe enemy is now " + turnsAway + " turn(s) away!");
                                                a1_enemy.enemyStats[1] -= dmg;
                                                break;
                                            } 
                                        }
                                                   }catch(NullPointerException e){System.out.println("\n\tYou don't have a ranged weapon in your equipment! You cannot do ranged attacks!");}
                                                }
                                                    break;
                                        case "attack":
                                        case "a":
                                            if (player.stats[2]>=a1_enemy.enemyStats[3]) {
                                                int dmgDealt = rand.nextInt(player.stats[1]);
                                                int EdmgDealt = rand.nextInt(a1_enemy.enemyStats[2]);
                                                System.out.println("The enemy has taken " + dmgDealt + " damage!");
                                                a1_enemy.enemyStats[1] -= dmgDealt;
                                                if (a1_enemy.enemyStats[1]<0) {
                                                    System.out.println("ENEMY DEFEATED!!!");
                                                    System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                                    a1_enemy.newEnemy(player.getDiffNum());
                                                    player.stats[0] = MAX_HEALTH;
                                                    player.skill.recharge();
                                                    int gain = rand.nextInt(15) + 15;
                                                    player.gainExp(gain);
                                                    break OUTER;
                                                }
                                                System.out.println("The enemy does " + EdmgDealt + " damage back at you!");
                                                player.stats[0] -= EdmgDealt;
                                                if (player.stats[0]<0) {
                                                    System.out.println("YOU DIED");
                                                    System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                    area1_cleared = true;
                                                    area2_cleared = true;
                                                    area3_cleared = true;
                                                    area4_cleared = true;
                                                    running = false;
                                                    break OUTER;
                                                }
                                            }
                                            if (player.stats[2]<a1_enemy.enemyStats[3]) {
                                                int dmgDealt = rand.nextInt(player.stats[1]);
                                                int EdmgDealt = rand.nextInt(a1_enemy.enemyStats[2]);
                                                System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                                player.stats[0] -= EdmgDealt;
                                                if (player.stats[0]<0) {
                                                    System.out.println("YOU DIED");
                                                    System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                    area1_cleared = true;
                                                    area2_cleared = true;
                                                    area3_cleared = true;
                                                    area4_cleared = true;
                                                    running = false;
                                                    break OUTER;
                                                }
                                                System.out.println("The enemy has taken " + dmgDealt + " damage!");
                                                a1_enemy.enemyStats[1] -= dmgDealt;
                                                if (a1_enemy.enemyStats[1]<0) {
                                                    System.out.println("ENEMY DEFEATED!!!");
                                                    System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                                    a1_enemy.newEnemy(player.getDiffNum());
                                                    player.stats[0] = MAX_HEALTH;
                                                    player.skill.recharge();
                                                    int gain = rand.nextInt(15) + 15;
                                                    player.gainExp(gain);
                                                    break OUTER;
                                                }
                                            }
                                            break;
                                        case "identify":
                                        case "i":
                                            if(player.stats[5]>=7)
                                            {
                                                System.out.println("\n\tyou take time to analyze your enemy\n\t...\n\tyou were able to identify their stats!");
                                                a1_enemy.showEnemyStats();
                                            }
                                            else
                                            {
                                                System.out.println("\n\tyou take time to analyze your enemy\n\t...\n\tyou fail to accurately tell their stats...");
                                            }
                                            if(turnsAway>0)
                                                     {
                                                         turnsAway--;
                                                         System.out.println("\n\n\tThe enemy is now " + turnsAway + " turn(s) away!");
                                                     }
                                                     else if(turnsAway == 0 || turnsAway<0)
                                                     {
                                                        int EdmgDealt = rand.nextInt(a1_enemy.enemyStats[2]);
                                                            System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                                            player.stats[0] -= EdmgDealt;
                                                            if (player.stats[0]<0) 
                                                            {
                                                                System.out.println("YOU DIED");
                                                                System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                                area1_cleared = true;
                                                                area2_cleared = true;
                                                                area3_cleared = true;
                                                                area4_cleared = true;
                                                                running = false;
                                                                break OUTER; 
                                                            }
                                                     }
                                            break;
                                        case "use skill":
                                        case "us":
                                            if(turnsAway > 0)
                                                {
                                                    System.out.println("\n\tEven though the enemy is " + turnsAway + " turn(s) away, you decide to face them right away!");
                                                }
                                                turnsAway = 0;
                                            if(player.skill.uses){
                                                if(player.skill.getName().equalsIgnoreCase("Blessing")){
                                                    if (player.stats[2]>=a1_enemy.enemyStats[3]) {
                                                        int EdmgDealt = rand.nextInt(a1_enemy.enemyStats[2]);
                                                        int HPgained = player.skill.use(player.stats);
                                                        System.out.println("You were healed for " + HPgained + " health points by your skill!");
                                                        player.stats[0] += HPgained;
                                                        if(turnsAway == 0 || turnsAway<0)
                                                        {
                                                        System.out.println("The enemy does " + EdmgDealt + " damage back at you!");
                                                        player.stats[0] -= EdmgDealt;
                                                        if (player.stats[0]<0) {
                                                            System.out.println("YOU DIED");
                                                            System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                            area1_cleared = true;
                                                            area2_cleared = true;
                                                            area3_cleared = true;
                                                            area4_cleared = true;
                                                            running = false;
                                                            break OUTER;
                                                        }
                                                        }
                                                        else if(turnsAway>0)
                                                        {
                                                            turnsAway--;
                                                            System.out.println("The enemy is now " + turnsAway + " turn(s) away!");
                                                        }
                                                    }
                                                    if (player.stats[2]<a1_enemy.enemyStats[3]) {
                                                        int HPgained = player.skill.use(player.stats);
                                                        int EdmgDealt = rand.nextInt(a1_enemy.enemyStats[2]);
                                                        System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                                        player.stats[0] -= EdmgDealt;
                                                        if (player.stats[0]<0) {
                                                            System.out.println("YOU DIED");
                                                            System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                            area1_cleared = true;
                                                            area2_cleared = true;
                                                            area3_cleared = true;
                                                            area4_cleared = true;
                                                            running = false;
                                                            break OUTER;
                                                        }
                                                        System.out.println("You were healed for " + HPgained + " health points by your skill!");
                                                        player.stats[0] += HPgained;
                                                    }
                                                }
                                                else{
                                                    if (player.stats[2]>=a1_enemy.enemyStats[3]) {
                                                        int dmgDealt = player.skill.use(player.stats);
                                                        int EdmgDealt = rand.nextInt(a1_enemy.enemyStats[2]);
                                                        System.out.println("The enemy has taken " + dmgDealt + " damage becuase of your skill!");
                                                        a1_enemy.enemyStats[1] -= dmgDealt;
                                                        if (a1_enemy.enemyStats[1]<0) {
                                                            System.out.println("ENEMY DEFEATED!!!");
                                                            System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                                            a1_enemy.newEnemy(player.getDiffNum());
                                                            player.stats[0] = MAX_HEALTH;
                                                            player.skill.recharge();
                                                            int gain = rand.nextInt(15) + 15;
                                                            player.gainExp(gain);
                                                            break OUTER;
                                                        }
                                                        System.out.println("The enemy does " + EdmgDealt + " damage back at you!");
                                                        player.stats[0] -= EdmgDealt;
                                                        if (player.stats[0]<0) {
                                                            System.out.println("YOU DIED");
                                                            System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                            area1_cleared = true;
                                                            area2_cleared = true;
                                                            area3_cleared = true;
                                                            area4_cleared = true;
                                                            running = false;
                                                            break OUTER;
                                                        }
                                                    }
                                                    if (player.stats[2]<a1_enemy.enemyStats[3]) {
                                                        int dmgDealt = player.skill.use(player.stats);
                                                        int EdmgDealt = rand.nextInt(a1_enemy.enemyStats[2]);
                                                        System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                                        player.stats[0] -= EdmgDealt;
                                                        if (player.stats[0]<0) {
                                                            System.out.println("YOU DIED");
                                                            System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                            area1_cleared = true;
                                                            area2_cleared = true;
                                                            area3_cleared = true;
                                                            area4_cleared = true;
                                                            running = false;
                                                            break OUTER;
                                                        }
                                                        System.out.println("The enemy has taken " + dmgDealt + " damage because of your skill!");
                                                        a1_enemy.enemyStats[1] -= dmgDealt;
                                                        if (a1_enemy.enemyStats[1]<0) {
                                                            System.out.println("ENEMY DEFEATED!!!");
                                                            System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                                            a1_enemy.newEnemy(player.getDiffNum());
                                                            player.stats[0] = MAX_HEALTH;
                                                            player.skill.recharge();
                                                            int gain = rand.nextInt(15) + 15;
                                                            player.gainExp(gain);
                                                            break OUTER;
                                                        }
                                                    }
                                                }
                                            }
                                            else
                                                System.out.println("You cannot use that skill again this battle!");
                                            break;
                                        case "skill info":
                                        case "si":
                                            System.out.println("\t"+player.skill.getSkillInfo());
                                            break;
                                        case "equipment":
                                        case"se":
                                            System.out.println(Arrays.toString(player.equipment));
                                            break;
                                        case "bag":
                                        case "b":
                                            System.out.println(Arrays.toString(player.inventory));
                                            break;
                                        case "use":
                                        case "u":
                                             System.out.println("What item did you want to use from your bag? Type 1 for first item, 2 for second, and so on.");
                                             System.out.println("\t" + Arrays.toString(player.inventory));
                                             try{
                                                 int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                                 if(tempa < player.inventory.length){
                                                    if(player.inventory[tempa] != null){
                                                        if(player.inventory[tempa].typeCheckConsumable()){
                                                            System.out.println("You use " + player.inventory[tempa].name + ".");
                                                            player.stats = player.inventory[tempa].ADDstats(player.stats);
                                                            player.inventory = player.inventory[tempa].dropInventory(player.inventory);
                                                        }
                                                        else
                                                            System.out.println("That is not a usable item.");
                                                    }
                                                    else
                                                     System.out.println("You do not have an item in that slot.");
                                                 }
                                                 else
                                                     System.out.println("You do not have an item in that slot.");
                                             }
                                             catch(NumberFormatException e){
                                                 System.out.println("Please enter a number.");
                                                 break;
                                             }
                                             if(turnsAway>0)
                                                     {
                                                         turnsAway--;
                                                         System.out.println("\n\n\tThe enemy is now " + turnsAway + " turn(s) away!");
                                                     }
                                                     else if(turnsAway == 0 || turnsAway<0)
                                                     {
                                                        int EdmgDealt = rand.nextInt(a1_enemy.enemyStats[2]);
                                                            System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                                            player.stats[0] -= EdmgDealt;
                                                            if (player.stats[0]<0) 
                                                            {
                                                                System.out.println("YOU DIED");
                                                                System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                                area1_cleared = true;
                                                                area2_cleared = true;
                                                                area3_cleared = true;
                                                                area4_cleared = true;
                                                                running = false;
                                                                break OUTER; 
                                                            }
                                                     }
                                             break;
                                        case "item stats":
                                        case "is":
                                            System.out.println("Where is this item located?\n\t1. Bag\n\t2. Equipment");
                                            try {
                                                int temp = Integer.parseInt(scan.nextLine());
                                                switch (temp) {
                                                    case 1:
                                                        System.out.println("What item do you want to know the stats for? Type 1 for first item, 2 for second, and so on.");
                                                        System.out.println("\tBag: " + Arrays.toString(player.inventory));
                                                        try {
                                                            int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                                            if(player.inventory[tempa] != null){
                                                                System.out.println(player.inventory[tempa].name + " alters your stats in this way:");
                                                                player.inventory[tempa].getStats();
                                                            }
                                                            else{
                                                                System.out.println("You do not have an item in that slot. Please try again.");
                                                            }
                                                        } catch (NumberFormatException e) {
                                                            System.out.println("Please try again and enter a number.");
                                                            break OUTER_2;
                                                        }
                                                        break OUTER_2;
                                                    case 2:
                                                        System.out.println("What item do you want to know the stats for? Type 1 for first item, 2 for second, and so on.");
                                                        System.out.println("\tEquipment: " + Arrays.toString(player.equipment));
                                                        try {
                                                            int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                                            if(player.equipment[tempa] != null){
                                                                System.out.println(player.equipment[tempa].name + " alters your stats in this way:");
                                                                player.equipment[tempa].getStats();
                                                            }
                                                            else{
                                                                System.out.println("You do not have an item in that slot. Please try again.");
                                                            }
                                                        } catch (NumberFormatException e) {
                                                            System.out.println("Please try again and enter a number.");
                                                            break OUTER_2;
                                                        }
                                                        break OUTER_2;
                                                    default:
                                                        System.out.println("Please try again and enter a valid answer.");
                                                        break;
                                                }
                                            }catch(NumberFormatException e){
                                                System.out.println("Please try again and enter a number.");
                                                break;
                                            }
                                            break;
                                        case "stats":
                                        case "s":
                                            player.showStats();
                                            break;
                                        case "combat help":
                                            player.combatHelp();
                                            break;
                                        default:
                                            System.out.println("enter a valid command (use \"combat help\" for a list of basic combat commands");
                                            break;
                                    }
                                }//NORMAL COMBAT END
                                break;
                            case 2:
                                System.out.println("You found a chest! It contained: " + area1_chest.open());
                                OUTER:
                                while (true) {
                                    System.out.println("\n\tWould you like to keep the item?");
                                    System.out.println("\t\t 1. Yes");
                                    System.out.println("\t\t 2. No");
                                    input = scan.nextLine();
                                    switch (input) {
                                        case "1":
                                            System.out.println("You yank the item from the chest!\nYou gained: " + area1_chest.open());
                                            player.inventory = area1_chest.open().ADDinventory(player.inventory);
                                            System.out.println(Arrays.toString(player.inventory));
                                            area1_chest.newItem();
                                            break OUTER;
                                        case "2":
                                            System.out.println("You decided to leave the item behind.");
                                            area1_chest.newItem();
                                            break OUTER;
                                        default:
                                            System.out.println("Please enter a valid option.");
                                            break;
                                    }
                                } //CHEST END
                                break;
                            case 3:
                                    int mod = 1;
                                    switch (player.getDiffNum()) {
                                        case 1:
                                            {
                                                mod = 1;
                                                break;
                                            }
                                        case 2:
                                            {
                                                mod = 2;
                                                break;
                                            }
                                        case 3:
                                            {
                                                mod = 3;
                                                break;
                                            }
                                        case 4:
                                            {
                                                mod = 4;
                                                break;
                                            }
                                        default:
                                            break;
                                    }
                                Enemy bigBoi = new Enemy(100 * mod, 50 * mod, 15 * mod, 15, 15, 15, 15, 15);
                                turnsAway = 2;
                                HOD_GAME boss1 = new HOD_GAME (1);
                                System.out.println("\n\n----------------------------I T ' S   B O S S   T I M E   B O i S----------------------------");
                                System.out.println("combat commands can be pulled up at any time by typing \"combat help\"");
                                OUTER:
                                while (true) {
                                    if(turnsAway > 0)
                                        {
                                            System.out.println("\n\n\tThe enemy is currently " + turnsAway + " turn(s) away!\n\tNow's your chance for ranged attacks "
                                                    + "(type \"ranged attack\"), or just type \"attack\" or \"a\" to charge the enemy straight on!\n\t"
                                                    + "(all skills are considered ranged)\n\t(you can still identify enemy and/or manage items)");
                                        }
                                    System.out.println("\nWhat will you do " + player.name + "?");
                                    input = scan.nextLine();
                                    OUTER_3:
                                    switch (input) {
                                        case "ranged attack":
                                        case "ra": 
                                                if(turnsAway == 0 || turnsAway<0)
                                                {
                                                    System.out.println("\n\tThe enemy is within melee distance! You cannot use ranged attacks right now!");
                                                }
                                                else if(turnsAway > 0)
                                                {
                                                   try{
                                        for (Items equipment : player.equipment) 
                                        {
                                            if (equipment.typeCheckRanged())  
                                            {
                                                int dmg = rand.nextInt((player.stats[1]) + (player.stats[2]));
                                                turnsAway--;
                                                System.out.println("\n\tYou deal " + dmg + " to the enemy from afar!\n\tThe enemy is now " + turnsAway + " turn(s) away!");
                                                a1_enemy.enemyStats[1] -= dmg;
                                                break;
                                            } 
                                        }
                                                   }catch(NullPointerException e){System.out.println("\n\tYou don't have a ranged weapon in your equipment! You cannot do ranged attacks!");}
                                                }
                                                    break;
                                        case "attack":
                                        case "a":
                                            if (player.stats[2]>=bigBoi.enemyStats[3]) {
                                                int dmgDealt = rand.nextInt(player.stats[1]);
                                                int EdmgDealt;
                                                System.out.println("The enemy has taken " + dmgDealt + " damage!");
                                                bigBoi.enemyStats[1] -= dmgDealt;
                                                if (bigBoi.enemyStats[1]<0) {
                                                    System.out.println("ENEMY DEFEATED!!!");
                                                    System.out.println("\n\n----------------------------BOSS HAS BEEN Y E E T E D----------------------------\n\n");
                                                    bigBoi.enemyStats[1] = 100;
                                                    player.stats[0] = MAX_HEALTH;
                                                    player.skill.recharge();
                                                    int gain = player.maxExp;
                                                    player.gainExp(gain);
                                                    break OUTER;
                                                }
                                                EdmgDealt = bigBoi.bossOneSkills(rand.nextInt(2),player.stats[2] , player.stats[1], player.stats[3], bigBoi.enemyStats[2]);
                                                player.stats[0] -= EdmgDealt;
                                                if (player.stats[0]<0) {
                                                    System.out.println("YOU DIED");
                                                    System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                    area1_cleared = true;
                                                    area2_cleared = true;
                                                    area3_cleared = true;
                                                    area4_cleared = true;
                                                    running = false;
                                                    break OUTER;
                                                }
                                            }
                                            if (player.stats[2]<bigBoi.enemyStats[3]) {
                                                int dmgDealt = rand.nextInt(player.stats[1]);
                                                int EdmgDealt = 0;
                                                EdmgDealt = bigBoi.bossOneSkills(rand.nextInt(2),player.stats[2] , player.stats[1], player.stats[3], bigBoi.enemyStats[2]);
                                                player.stats[0] -= EdmgDealt;
                                                if (player.stats[0]<0) {
                                                    System.out.println("YOU DIED");
                                                    System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                    area1_cleared = true;
                                                    area2_cleared = true;
                                                    area3_cleared = true;
                                                    area4_cleared = true;
                                                    running = false;
                                                    break OUTER;
                                                }
                                                System.out.println("\n\tThe enemy has taken " + dmgDealt + " damage!");
                                                bigBoi.enemyStats[1] -= dmgDealt;
                                                if (bigBoi.enemyStats[1]<0) {
                                                    System.out.println("ENEMY DEFEATED!!!");
                                                    System.out.println("\n\n----------------------------BOSS HAS BEEN Y E E T E D----------------------------\n\n");
                                                    bigBoi.enemyStats[1] = 100;
                                                    player.stats[0] = MAX_HEALTH;
                                                    player.skill.recharge();
                                                    int gain = player.maxExp;
                                                    player.gainExp(gain);
                                                    break OUTER;
                                                }
                                            }
                                            break;
                                        case "identify":
                                        case "i":
                                            if(player.stats[5]>=7)
                                            {
                                                System.out.println("\n\tyou take time to analyze your enemy\n\t...\n\tyou were able to identify their stats!");
                                                bigBoi.showEnemyStats();
                                            }
                                            else
                                            {
                                                System.out.println("\n\tyou take time to analyze your enemy\n\t...\n\tyou fail to accurately tell their stats...");
                                            }
                                            if(turnsAway>0)
                                                     {
                                                         turnsAway--;
                                                         System.out.println("\n\n\tThe enemy is now " + turnsAway + " turn(s) away!");
                                                     }
                                                     else if(turnsAway == 0 || turnsAway<0)
                                                     {
                                                        int EdmgDealt = 0;
                                                        EdmgDealt = bigBoi.bossOneSkills(rand.nextInt(2),player.stats[2] , player.stats[1], player.stats[3], bigBoi.enemyStats[2]);
                                                            player.stats[0] -= EdmgDealt;
                                                            if (player.stats[0]<0) 
                                                            {
                                                                System.out.println("YOU DIED");
                                                                System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                                area1_cleared = true;
                                                                area2_cleared = true;
                                                                area3_cleared = true;
                                                                area4_cleared = true;
                                                                running = false;
                                                                break OUTER; 
                                                            }
                                                     }
                                            break;
                                        case "use skill":
                                        case "us":
                                            if(turnsAway > 0)
                                                {
                                                    System.out.println("\n\tEven though the enemy is " + turnsAway + " turn(s) away, you decide to face them right away!");
                                                }
                                                turnsAway = 0;
                                            if(player.skill.uses){
                                                if(player.skill.getName().equalsIgnoreCase("Blessing")){
                                                    if (player.stats[2]>=bigBoi.enemyStats[3]) {
                                                        int HPgained = player.skill.use(player.stats);
                                                        System.out.println("You were healed for " + HPgained + " health points by your skill!");
                                                        player.stats[0] += HPgained;
                                                        int EdmgDealt = bigBoi.bossOneSkills(rand.nextInt(2),player.stats[2] , player.stats[1], player.stats[3], bigBoi.enemyStats[2]);
                                                        player.stats[0] -= EdmgDealt;
                                                        if (player.stats[0]<0) {
                                                            System.out.println("YOU DIED");
                                                            System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                            area1_cleared = true;
                                                            area2_cleared = true;
                                                            area3_cleared = true;
                                                            area4_cleared = true;
                                                            running = false;
                                                            break OUTER;
                                                        }
                                                    }
                                                    if (player.stats[2]<bigBoi.enemyStats[3]) {
                                                        int HPgained = player.skill.use(player.stats);
                                                        int EdmgDealt = bigBoi.bossOneSkills(rand.nextInt(2),player.stats[2] , player.stats[1], player.stats[3], bigBoi.enemyStats[2]);
                                                        player.stats[0] -= EdmgDealt;
                                                        if (player.stats[0]<0) {
                                                            System.out.println("YOU DIED");
                                                            System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                            area1_cleared = true;
                                                            area2_cleared = true;
                                                            area3_cleared = true;
                                                            area4_cleared = true;
                                                            running = false;
                                                            break OUTER;
                                                        }
                                                        System.out.println("You were healed for " + HPgained + " health points by your skill!");
                                                        player.stats[0] += HPgained;
                                                    }
                                                }
                                                else{
                                                    if (player.stats[2]>=bigBoi.enemyStats[3]) {
                                                        int dmgDealt = player.skill.use(player.stats);
                                                        System.out.println("The enemy has taken " + dmgDealt + " damage becuase of your skill!");
                                                        bigBoi.enemyStats[1] -= dmgDealt;
                                                        if (bigBoi.enemyStats[1]<0) {
                                                            System.out.println("ENEMY DEFEATED!!!");
                                                            System.out.println("\n\n----------------------------bigboi HAS BEEN Y E E T E D----------------------------\n\n");
                                                            bigBoi.newEnemy(player.getDiffNum());
                                                            player.stats[0] = MAX_HEALTH;
                                                            player.skill.recharge();
                                                            int gain = player.maxExp;
                                                            player.gainExp(gain);
                                                            break OUTER;
                                                        }
                                                        int EdmgDealt = 0;
                                                        EdmgDealt = bigBoi.bossOneSkills(rand.nextInt(2),player.stats[2] , player.stats[1], player.stats[3], bigBoi.enemyStats[2]);
                                                        player.stats[0] -= EdmgDealt;
                                                        if (player.stats[0]<0) {
                                                            System.out.println("YOU DIED");
                                                            System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                            area1_cleared = true;
                                                            area2_cleared = true;
                                                            area3_cleared = true;
                                                            area4_cleared = true;
                                                            running = false;
                                                            break OUTER;
                                                        }
                                                    }
                                                    if (player.stats[2]<bigBoi.enemyStats[3]) {
                                                        int dmgDealt = player.skill.use(player.stats);
                                                        int EdmgDealt = 0;
                                                        EdmgDealt = bigBoi.bossOneSkills(rand.nextInt(2),player.stats[2] , player.stats[1], player.stats[3], bigBoi.enemyStats[2]);
                                                        player.stats[0] -= EdmgDealt;
                                                        if (player.stats[0]<0) {
                                                            System.out.println("YOU DIED");
                                                            System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                            area1_cleared = true;
                                                            area2_cleared = true;
                                                            area3_cleared = true;
                                                            area4_cleared = true;
                                                            running = false;
                                                            break OUTER;
                                                        }
                                                        System.out.println("The enemy has taken " + dmgDealt + " damage because of your skill!");
                                                        bigBoi.enemyStats[1] -= dmgDealt;
                                                        if (bigBoi.enemyStats[1]<0) {
                                                            System.out.println("ENEMY DEFEATED!!!");
                                                            System.out.println("\n\n----------------------------BOSS HAS BEEN Y E E T E D----------------------------\n\n");
                                                            bigBoi.newEnemy(player.getDiffNum());
                                                            player.stats[0] = MAX_HEALTH;
                                                            player.skill.recharge();
                                                            int gain = player.maxExp;
                                                            player.gainExp(gain);
                                                            break OUTER;
                                                        }
                                                    }
                                                }
                                            }
                                            else
                                                System.out.println("You cannot use that skill again this battle!");
                                            break;
                                        case "skill info":
                                        case "si":
                                            System.out.println("\t"+player.skill.getSkillInfo());
                                            break;
                                        case "equipment":
                                        case"se":
                                            System.out.println(Arrays.toString(player.equipment));
                                            break;
                                        case "bag":
                                        case "b":
                                            System.out.println(Arrays.toString(player.inventory));
                                            break;
                                        case "use":
                                        case "u":
                                             System.out.println("What item did you want to use from your bag? Type 1 for first item, 2 for second, and so on.");
                                             System.out.println("\t" + Arrays.toString(player.inventory));
                                             try{
                                                 int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                                 if(tempa < player.inventory.length){
                                                    if(player.inventory[tempa] != null){
                                                        if(player.inventory[tempa].typeCheckConsumable()){
                                                            System.out.println("You use " + player.inventory[tempa].name + ".");
                                                            player.stats = player.inventory[tempa].ADDstats(player.stats);
                                                            player.inventory = player.inventory[tempa].dropInventory(player.inventory);
                                                        }
                                                        else
                                                            System.out.println("That is not a usable item.");
                                                    }
                                                    else
                                                     System.out.println("You do not have an item in that slot.");
                                                 }
                                                 else
                                                     System.out.println("You do not have an item in that slot.");
                                             }
                                             catch(NumberFormatException e){
                                                 System.out.println("Please enter a number.");
                                                 break;
                                             }
                                             if(turnsAway>0)
                                                     {
                                                         turnsAway--;
                                                         System.out.println("\n\n\tThe enemy is now " + turnsAway + " turn(s) away!");
                                                     }
                                                     else if(turnsAway == 0 || turnsAway<0)
                                                     {
                                                        int EdmgDealt = rand.nextInt(bigBoi.enemyStats[2]);
                                                            System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                                            player.stats[0] -= EdmgDealt;
                                                            if (player.stats[0]<0) 
                                                            {
                                                                System.out.println("YOU DIED");
                                                                System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                                area1_cleared = true;
                                                                area2_cleared = true;
                                                                area3_cleared = true;
                                                                area4_cleared = true;
                                                                running = false;
                                                                break OUTER; 
                                                            }
                                                     }
                                             break;
                                        case "item stats":
                                        case "is":
                                            System.out.println("Where is this item located?\n\t1. Bag\n\t2. Equipment");
                                            try {
                                                int temp = Integer.parseInt(scan.nextLine());
                                                switch (temp) {
                                                    case 1:
                                                        System.out.println("What item do you want to know the stats for? Type 1 for first item, 2 for second, and so on.");
                                                        System.out.println("\tBag: " + Arrays.toString(player.inventory));
                                                        try {
                                                            int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                                            if(player.inventory[tempa] != null){
                                                                System.out.println(player.inventory[tempa].name + " alters your stats in this way:");
                                                                player.inventory[tempa].getStats();
                                                            }
                                                            else{
                                                                System.out.println("You do not have an item in that slot. Please try again.");
                                                            }
                                                        } catch (NumberFormatException e) {
                                                            System.out.println("Please try again and enter a number.");
                                                            break OUTER_3;
                                                        }
                                                        break OUTER_3;
                                                    case 2:
                                                        System.out.println("What item do you want to know the stats for? Type 1 for first item, 2 for second, and so on.");
                                                        System.out.println("\tEquipment: " + Arrays.toString(player.equipment));
                                                        try {
                                                            int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                                            if(player.equipment[tempa] != null){
                                                                System.out.println(player.equipment[tempa].name + " alters your stats in this way:");
                                                                player.equipment[tempa].getStats();
                                                            }
                                                            else{
                                                                System.out.println("You do not have an item in that slot. Please try again.");
                                                            }
                                                        } catch (NumberFormatException e) {
                                                            System.out.println("Please try again and enter a number.");
                                                            break OUTER_3;
                                                        }
                                                        break OUTER_3;
                                                    default:
                                                        System.out.println("Please try again and enter a valid answer.");
                                                        break;
                                                }
                                            }catch(NumberFormatException e){
                                                System.out.println("Please try again and enter a number.");
                                                break;
                                            }
                                            break;
                                        case "stats":
                                        case "s":
                                            player.showStats();
                                            break;
                                        case "combat help":
                                            player.combatHelp();
                                            break;
                                        case "help":
                                            player.help();
                                            break;
                                        default:
                                            System.out.println("enter a valid command (use \"combat help\" for a list of basic combat commands");
                                            break;
                                    }
                                } // BOSS FIGHT END
                                break;
                            case 4:
                                System.out.println("You have found the exit to the area! But alas... you only get deeper into this hell hole instead of having freedom");
                                area1_cleared = true;
                                break;
                            default:
                                break;
                        } // AREA GET DATA END
                        break;
                    case "equipment":
                    case"se":
                        System.out.println(Arrays.toString(player.equipment));
                        break;
                    case "bag":
                    case "b":
                        System.out.println(Arrays.toString(player.inventory));
                        break;
                    case "drop":
                    case "d":
                     System.out.println("From where would you like to drop something?\n\t1. Bag\n\t2. Equipment");
                     try {
                         int temp = Integer.parseInt(scan.nextLine());
                         switch (temp) {
                             case 1:
                                 System.out.println("Which item did you want to drop from your bag? Type 1 for first item, 2 for second, and so on.");
                                 System.out.println("\t" + Arrays.toString(player.inventory));
                                 try {
                                     int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                     if(tempa < player.inventory.length){
                                        if (player.inventory[tempa] != null) {
                                            System.out.println("You dropped your " + player.inventory[tempa].name + ".");
                                            player.inventory = player.inventory[tempa].dropInventory(player.inventory);
                                            break OUTER_4;
                                        }
                                        else
                                            System.out.println("You do not have an item in that slot.");
                                     }
                                     else {
                                         System.out.println("You do not have an item in that slot. Please try again.");
                                     }
                                 } catch (NumberFormatException e) {
                                     System.out.println("Please try again and enter a number.");
                                     break OUTER_4;
                                 }
                                 break OUTER_4;
                             case 2:
                                 System.out.println("Which item did you want to drop from your equipment? Type 1 for first item, 2 for second, and so on.");
                                 System.out.println("\t" + Arrays.toString(player.equipment));
                                 try {
                                     int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                     if(tempa < player.equipment.length){
                                        if (player.equipment[tempa] != null) {
                                            System.out.println("You dropped your " + player.equipment[tempa].name + ".");
                                            player.stats = player.equipment[tempa].SUBstats(player.stats);
                                            player.equipment = player.equipment[tempa].dropEquipment(player.equipment);
                                            break OUTER_4;
                                        }
                                        else
                                            System.out.println("You do not have an item in that slot.");
                                     }
                                     else {
                                         System.out.println("You do not have an item in that slot. Please try again.");
                                     }
                                 } catch (NumberFormatException e) {
                                     System.out.println("Please try again and enter a number.");
                                     break OUTER_4;
                                 }
                                 break;
                             default:
                                 System.out.println("Please try again and enter a valid answer.");
                                 break;
                         }
                     }catch(NumberFormatException e){
                         System.out.println("Please try again and enter a number.");
                         break;
                     }
                     break;
                 case "equip":
                 case "e":
                    if(!dummy.isFull(player.equipment)){
                        System.out.println("What item did you want to equip from your bag? Type 1 for first item, 2 for second, and so on.");
                        System.out.println("\t" + Arrays.toString(player.inventory));
                        try{
                            int tempa = Integer.parseInt(scan.nextLine()) - 1;
                            if(tempa < player.inventory.length){
                                if(player.inventory[tempa] != null){
                                    System.out.println("You equipped your " + player.inventory[tempa].name + ".");
                                    player.stats = player.inventory[tempa].ADDstats(player.stats);
                                    Items[][] temp = player.inventory[tempa].equip(player.inventory, player.equipment);
                                    player.inventory = temp[0];
                                    player.equipment = temp[1];
                                    break;
                                }
                                else
                                    System.out.println("You do not have an item in that slot.");
                            }
                            else
                                System.out.println("You do not have an equipped item in that slot.");
                        }
                        catch(NumberFormatException e){
                            System.out.println("Please enter a number.");
                            break;
                        }
                        break;
                    }
                    else
                        System.out.println("Your equipment is full! You can't equip an item.");
                    break;
                case "unequip":
                case "ue":
                    if(!dummy.isFull(player.inventory)){
                        System.out.println("What item did you want to unequip from your equipment? Type 1 for first item, 2 for second, and so on.");
                        System.out.println("\t" + Arrays.toString(player.equipment));
                        try{
                            int tempa = Integer.parseInt(scan.nextLine()) - 1;
                            if(tempa < player.equipment.length){
                                if(player.equipment[tempa] != null){
                                    System.out.println("You unequipped your " + player.equipment[tempa].name + ".");
                                    player.stats = player.equipment[tempa].SUBstats(player.stats);
                                    Items[][] temp = player.equipment[tempa].unequip(player.inventory, player.equipment);
                                    player.inventory = temp[0];
                                    player.equipment = temp[1];
                                    break;
                                }
                                else
                                    System.out.println("You do not have an item in that slot.");
                            }
                            else
                                System.out.println("You do not have an equipped item in that slot.");
                        }
                        catch(NumberFormatException e){
                            System.out.println("Please enter a number.");
                            break;
                        }
                        break;
                    }
                  else
                    System.out.println("Your bag is full! You can't unequip an item.");
                  break;
                 case "use":
                 case "u":
                     System.out.println("What item did you want to use from your bag? Type 1 for first item, 2 for second, and so on.");
                     System.out.println("\t" + Arrays.toString(player.inventory));
                     try{
                         int tempa = Integer.parseInt(scan.nextLine()) - 1;
                         if(tempa < player.inventory.length){
                            if(player.inventory[tempa] != null){
                                if(player.inventory[tempa].typeCheckConsumable()){
                                    System.out.println("You use " + player.inventory[tempa].name + ".");
                                    player.stats = player.inventory[tempa].ADDstats(player.stats);
                                    player.inventory = player.inventory[tempa].dropInventory(player.inventory);
                                }
                                else
                                    System.out.println("That is not a usable item.");
                            }
                            else
                             System.out.println("You do not have an item in that slot.");
                         }
                         else
                             System.out.println("You do not have an item in that slot.");
                     }
                     catch(NumberFormatException e){
                         System.out.println("Please enter a number.");
                         break;
                     }
                     break;
                 case "item stats":
                 case "is":
                     System.out.println("Where is this item located?\n\t1. Bag\n\t2. Equipment");
                     try {
                         int temp = Integer.parseInt(scan.nextLine());
                         switch (temp) {
                             case 1:
                                 System.out.println("What item do you want to know the stats for? Type 1 for first item, 2 for second, and so on.");
                                 System.out.println("\tBag: " + Arrays.toString(player.inventory));
                                 try {
                                     int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                     if(tempa < player.inventory.length){
                                        if(player.inventory[tempa] != null){
                                            System.out.println(player.inventory[tempa].name + " alters your stats in this way:");
                                            player.inventory[tempa].getStats();
                                        }
                                        else
                                            System.out.println("You do not have an item in that slot.");
                                     }
                                     else{
                                         System.out.println("You do not have an item in that slot. Please try again.");
                                     }
                                 } catch (NumberFormatException e) {
                                     System.out.println("Please try again and enter a number.");
                                     break OUTER_5;
                                 }
                                 break OUTER_5;
                             case 2:
                                 System.out.println("What item do you want to know the stats for? Type 1 for first item, 2 for second, and so on.");
                                 System.out.println("\tEquipment: " + Arrays.toString(player.equipment));
                                 try {
                                     int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                     if(tempa < player.equipment.length){
                                        if(player.equipment[tempa] != null){
                                            System.out.println(player.equipment[tempa].name + " alters your stats in this way:");
                                            player.equipment[tempa].getStats();
                                        }
                                        else
                                            System.out.println("You do not have an item in that slot.");
                                     }
                                     else{
                                         System.out.println("You do not have an item in that slot. Please try again.");
                                     }
                                 } catch (NumberFormatException e) {
                                     System.out.println("Please try again and enter a number.");
                                     break OUTER_5;
                                 }
                                 break OUTER_5;
                             default:
                                 System.out.println("Please try again and enter a valid answer.");
                                 break;
                         }
                     }catch(NumberFormatException e){
                         System.out.println("Please try again and enter a number.");
                         break;
                     }
                     break;
                    case "stats":
                    case "s":
                        player.showStats();
                        break;
                    case "skill info":
                    case "si":
                        System.out.println("\t"+player.skill.getSkillInfo());
                        break;
                    default:
                        System.out.println("enter a valid command (use \"help\" for a list of basic commands)");
                        break;
                }
            } //WHILE AREA_1 CLEARED END
          ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
          /////////////////////////////AREA 2 CREATION///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
               int area2_L;
               Area area2 = new Area(0, null, null);
               area2_L = rand.nextInt(3) + 5;
               //System.out.println(area2_L);
               area2.ensureExit();
               area2.ensureBoss();
               for(int i = 0; i<area2_L-1; i++)
               {
                   area2.addNode(rand.nextInt(3));
                   //area2.addNode(0);
               }
               //Area.listLength(area2);
               Area area2_pp = area2;
               Chest area2_chest = new Chest();
               Enemy a2_enemy = new Enemy(1, 1, 1, 1, 1, 1, 1, 1);
               a2_enemy.newEnemy2(player.getDiffNum());
          /////////////////////////////AREA 2 CREATION////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          if(area2_cleared == false)
          {
              System.out.println("\n\n\tYou some how find yourself in a forest like area. Massive vegatation and gigantic forest creatures are visable everywhere around you."
                     + "\n\tYou decide there really is no going back now, and continue to press on.");
              HOD_GAME area2_pic = new HOD_GAME (6);
          }
          while(area2_cleared == false)
          {
             System.out.println("\n\t\tWhat would you like to do?");
                input = scan.nextLine();
              OUTER_9:
             OUTER_10:
             switch (input) {
                 case "help":
                     player.help();
                     break;
                 case "forward":
                 case "f":
                     area2_pp = area2_pp.getForeLink();
                     //System.out.println(area2_pp.getData());
                     switch (area2_pp.getData()) {
                         case 0:
                             int area2_encounter;
                             area2_encounter = area2.area_2_Encounter(rand.nextInt(4), player.stats[4], player.name); /////////////////ERROR///////////////////////
                             if(area2_encounter<1000)
                                 player.stats[0] = player.stats[0] - area2_encounter;
                             else if(area2_encounter == 2221)
                             {
                                 for(int i = 1; i<player.stats.length; i++)
                                     player.stats[i] = player.stats[i] - 3;
                             }
                             else if(area2_encounter == 2222)
                             {
                                 for(int i = 1; i<player.stats.length; i++)
                                     player.stats[i] = player.stats[i] + 3;
                             }
                             else if(area2_encounter == 2223)
                             {
                                 player.stats[4] = player.stats[4] + 5;
                             }
                             else if(area2_encounter == 2224)
                             {
                                 player.stats[4] = player.stats[4] + 5;
                                 Enemy Giant_Angry_Thing = new Enemy(10, 120, 25, 15, 10, 10, 4, 1);
                                 int turnsAway = rand.nextInt(3);
                                 System.out.println("\n\n----------------------------F I G H T !!!----------------------------");
                                 System.out.println("combat commands can be pulled up at any time by typing \"combat help\"");
                                 OUTER:
                                 while (true) {
                                     if(turnsAway > 0)
                                        {
                                            System.out.println("\n\n\tThe enemy is currently " + turnsAway + " turn(s) away!\n\tNow's your chance for ranged attacks "
                                                    + "(type \"ranged attack\"), or just type \"attack\" or \"a\" to charge the enemy straight on!\n\t"
                                                    + "(all skills are considered ranged)\n\t(you can still identify enemy and/or manage items)");
                                        }
                                     System.out.println("\nWhat will you do " + player.name + "?");
                                     input = scan.nextLine();
                                     OUTER_6:
                                     switch (input) {
                                         case "ranged attack":
                                         case "ra": 
                                                if(turnsAway == 0 || turnsAway<0)
                                                {
                                                    System.out.println("\n\tThe enemy is within melee distance! You cannot use ranged attacks right now!");
                                                }
                                                else if(turnsAway > 0)
                                                {
                                                   try{
                                        for (Items equipment : player.equipment) 
                                        {
                                            if (equipment.typeCheckRanged()) 
                                            {
                                                int dmg = rand.nextInt((player.stats[1]) + (player.stats[2]));
                                                turnsAway--;
                                                System.out.println("You deal " + dmg + " to the enemy from afar!\n\tThe enemy is now " + turnsAway + " turn(s) away!");
                                                a1_enemy.enemyStats[1] -= dmg;
                                                break;
                                            } 
                                        }
                                                   }catch(NullPointerException e){System.out.println("\n\tYou don't have a ranged weapon in your equipment! You cannot do ranged attacks!");}
                                                }
                                                    break;
                                         case "attack":
                                         case "a":
                                             if (player.stats[2]>=Giant_Angry_Thing.enemyStats[3]) {
                                                 int dmgDealt = rand.nextInt(player.stats[1]);
                                                 int EdmgDealt = rand.nextInt(Giant_Angry_Thing.enemyStats[2]);
                                                 System.out.println("The enemy has taken " + dmgDealt + " damage!");
                                                 Giant_Angry_Thing.enemyStats[1] -= dmgDealt;
                                                 if (Giant_Angry_Thing.enemyStats[1]<0) {
                                                     System.out.println("ENEMY DEFEATED!!!");
                                                     System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                                     System.out.println("\n\n\tUpon killing the Giant angry looking thing, you've looted its claw as a weapon!");
                                                     Items Giant_Claw = new Items("Giant Claw",0,6,-2,0,0,0,0,0,0,0,0,0,0,0,1); //gives +6 str, -2 dex
                                                     player.inventory = Giant_Claw.ADDinventory(player.inventory);
                                                     player.stats[0] = MAX_HEALTH;
                                                     player.skill.recharge();
                                                     int gain = rand.nextInt(25) + 15;
                                                     player.gainExp(gain);
                                                     break OUTER;
                                                 }
                                                 System.out.println("The enemy does " + EdmgDealt + " damage back at you!");
                                                 player.stats[0] -= EdmgDealt;
                                                 if (player.stats[0]<0) {
                                                     System.out.println("YOU DIED");
                                                     System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                     area2_cleared = true;
                                                     area3_cleared = true;
                                                     area4_cleared = true;
                                                     running = false;
                                                     break OUTER;
                                                 }
                                             }
                                             if (player.stats[2]<Giant_Angry_Thing.enemyStats[3]) {
                                                 int dmgDealt = rand.nextInt(player.stats[1]);
                                                 int EdmgDealt = rand.nextInt(Giant_Angry_Thing.enemyStats[2]);
                                                 System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                                 player.stats[0] -= EdmgDealt;
                                                 if (player.stats[0]<0) {
                                                     System.out.println("YOU DIED");
                                                     System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                     area2_cleared = true;
                                                     area3_cleared = true;
                                                     area4_cleared = true;
                                                     running = false;
                                                     break OUTER;
                                                 }
                                                 System.out.println("The enemy has taken " + dmgDealt + " damage!");
                                                 Giant_Angry_Thing.enemyStats[1] -= dmgDealt;
                                                 if (Giant_Angry_Thing.enemyStats[1]<0) {
                                                     System.out.println("ENEMY DEFEATED!!!");
                                                     System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                                     System.out.println("\n\n\tUpon killing the Giant angry looking thing, you've looted its claw as a weapon!");
                                                     Items Giant_Claw = new Items("Giant Claw",0,6,-2,0,0,0,0,0,0,0,0,0,0,0,1); //gives +6 str, -2 dex
                                                     player.inventory = Giant_Claw.ADDinventory(player.inventory);
                                                     player.stats[0] = MAX_HEALTH;
                                                     player.skill.recharge();
                                                     int gain = rand.nextInt(25) + 15;
                                                     player.gainExp(gain);
                                                     break OUTER;
                                                 }
                                             }
                                             break;
                                         case "identify":
                                         case "i":
                                             if(player.stats[5]>=7)
                                             {
                                                 System.out.println("\n\tyou take time to analyze your enemy\n\t...\n\tyou were able to identify their stats!");
                                                 Giant_Angry_Thing.showEnemyStats();
                                             }
                                             else
                                             {
                                                 System.out.println("\n\tyou take time to analyze your enemy\n\t...\n\tyou fail to accurately tell their stats...");
                                             }
                                             if(turnsAway>0)
                                                     {
                                                         turnsAway--;
                                                         System.out.println("\n\n\tThe enemy is now " + turnsAway + " turn(s) away!");
                                                     }
                                                     else if(turnsAway == 0 || turnsAway<0)
                                                     {
                                                        int EdmgDealt = rand.nextInt(Giant_Angry_Thing.enemyStats[2]);
                                                            System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                                            player.stats[0] -= EdmgDealt;
                                                            if (player.stats[0]<0) 
                                                            {
                                                                System.out.println("YOU DIED");
                                                                System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                                area1_cleared = true;
                                                                area2_cleared = true;
                                                                area3_cleared = true;
                                                                area4_cleared = true;
                                                                running = false;
                                                                break OUTER; 
                                                            }
                                                     }
                                             break;
                                         case "use skill":
                                         case "us":
                                             if(turnsAway > 0)
                                                {
                                                    System.out.println("\n\tEven though the enemy is " + turnsAway + " turn(s) away, you decide to face them right away!");
                                                }
                                                turnsAway = 0;
                                             if(player.skill.uses){
                                                 if(player.skill.getName().equalsIgnoreCase("Blessing")){
                                                     if (player.stats[2]>=Giant_Angry_Thing.enemyStats[3]) {
                                                         int EdmgDealt = rand.nextInt(Giant_Angry_Thing.enemyStats[2]);
                                                         int HPgained = player.skill.use(player.stats);
                                                         System.out.println("You were healed for " + HPgained + " health points by your skill!");
                                                         player.stats[0] += HPgained;
                                                         System.out.println("The enemy does " + EdmgDealt + " damage back at you!");
                                                         player.stats[0] -= EdmgDealt;
                                                         if (player.stats[0]<0) {
                                                             System.out.println("YOU DIED");
                                                             System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                             area2_cleared = true;
                                                             area3_cleared = true;
                                                             area4_cleared = true;
                                                             running = false;
                                                             break OUTER;
                                                         }
                                                     }
                                                     if (player.stats[2]<Giant_Angry_Thing.enemyStats[3]) {
                                                         int HPgained = player.skill.use(player.stats);
                                                         int EdmgDealt = rand.nextInt(Giant_Angry_Thing.enemyStats[2]);
                                                         System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                                         player.stats[0] -= EdmgDealt;
                                                         if (player.stats[0]<0) {
                                                             System.out.println("YOU DIED");
                                                             System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                             area2_cleared = true;
                                                             area3_cleared = true;
                                                             area4_cleared = true;
                                                             running = false;
                                                             break OUTER;
                                                         }
                                                         System.out.println("You were healed for " + HPgained + " health points by your skill!");
                                                         player.stats[0] += HPgained;
                                                     }
                                                 }
                                                 else{
                                                     if (player.stats[2]>=Giant_Angry_Thing.enemyStats[3]) {
                                                         int dmgDealt = player.skill.use(player.stats);
                                                         int EdmgDealt = rand.nextInt(Giant_Angry_Thing.enemyStats[2]);
                                                         System.out.println("The enemy has taken " + dmgDealt + " damage becuase of your skill!");
                                                         Giant_Angry_Thing.enemyStats[1] -= dmgDealt;
                                                         if (Giant_Angry_Thing.enemyStats[1]<0) {
                                                             System.out.println("ENEMY DEFEATED!!!");
                                                             System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                                             System.out.println("\n\n\tUpon killing the Giant angry looking thing, you've looted its claw as a weapon!");
                                                             Items Giant_Claw = new Items("Giant Claw",0,6,-2,0,0,0,0,0,0,0,0,0,0,0,1); //gives +6 str, -2 dex
                                                             player.inventory = Giant_Claw.ADDinventory(player.inventory);
                                                             player.stats[0] = MAX_HEALTH;
                                                             player.skill.recharge();
                                                             int gain = rand.nextInt(25) + 15;
                                                             player.gainExp(gain);
                                                             break OUTER;
                                                         }
                                                         System.out.println("The enemy does " + EdmgDealt + " damage back at you!");
                                                         player.stats[0] -= EdmgDealt;
                                                         if (player.stats[0]<0) {
                                                             System.out.println("YOU DIED");
                                                             System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                             area2_cleared = true;
                                                             area3_cleared = true;
                                                             area4_cleared = true;
                                                             running = false;
                                                             break OUTER;
                                                         }
                                                     }
                                                     if (player.stats[2]<Giant_Angry_Thing.enemyStats[3]) {
                                                         int dmgDealt = player.skill.use(player.stats);
                                                         int EdmgDealt = rand.nextInt(Giant_Angry_Thing.enemyStats[2]);
                                                         System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                                         player.stats[0] -= EdmgDealt;
                                                         if (player.stats[0]<0) {
                                                             System.out.println("YOU DIED");
                                                             System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                             area2_cleared = true;
                                                             area3_cleared = true;
                                                             area4_cleared = true;
                                                             running = false;
                                                             break OUTER;
                                                         }
                                                         System.out.println("The enemy has taken " + dmgDealt + " damage because of your skill!");
                                                         Giant_Angry_Thing.enemyStats[1] -= dmgDealt;
                                                         if (Giant_Angry_Thing.enemyStats[1]<0) {
                                                             System.out.println("ENEMY DEFEATED!!!");
                                                             System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                                             System.out.println("\n\n\tUpon killing the Giant angry looking thing, you've looted its claw as a weapon!");
                                                             Items Giant_Claw = new Items("Giant Claw",0,6,-2,0,0,0,0,0,0,0,0,0,0,0,1); //gives +6 str, -2 dex
                                                             player.inventory = Giant_Claw.ADDinventory(player.inventory);
                                                             player.stats[0] = MAX_HEALTH;
                                                             player.skill.recharge();
                                                             int gain = rand.nextInt(25) + 15;
                                                             player.gainExp(gain);
                                                             break OUTER;
                                                         }
                                                     }
                                                 }
                                             }
                                             else
                                                 System.out.println("You cannot use that skill again this battle!");
                                             break;
                                         case "skill info":
                                         case "si":
                                             System.out.println("\t"+player.skill.getSkillInfo());
                                             break;
                                         case "equipment":
                                         case"se":
                                             System.out.println(Arrays.toString(player.equipment));
                                             break;
                                         case "bag":
                                         case "b":
                                             System.out.println(Arrays.toString(player.inventory));
                                             break;
                                         case "use":
                                         case "u":
                                             System.out.println("What item did you want to use from your bag? Type 1 for first item, 2 for second, and so on.");
                                             System.out.println("\t" + Arrays.toString(player.inventory));
                                             try{
                                                 int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                                 if(tempa < player.inventory.length){
                                                    if(player.inventory[tempa] != null){
                                                        if(player.inventory[tempa].typeCheckConsumable()){
                                                            System.out.println("You use " + player.inventory[tempa].name + ".");
                                                            player.stats = player.inventory[tempa].ADDstats(player.stats);
                                                            player.inventory = player.inventory[tempa].dropInventory(player.inventory);
                                                        }
                                                        else
                                                            System.out.println("That is not a usable item.");
                                                    }
                                                    else
                                                     System.out.println("You do not have an item in that slot.");
                                                 }
                                                 else
                                                     System.out.println("You do not have an item in that slot.");
                                             }
                                             catch(NumberFormatException e){
                                                 System.out.println("Please enter a number.");
                                                 break;
                                             }
                                             if(turnsAway>0)
                                                     {
                                                         turnsAway--;
                                                         System.out.println("\n\n\tThe enemy is now " + turnsAway + " turn(s) away!");
                                                     }
                                                     else if(turnsAway == 0 || turnsAway<0)
                                                     {
                                                        int EdmgDealt = rand.nextInt(Giant_Angry_Thing.enemyStats[2]);
                                                            System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                                            player.stats[0] -= EdmgDealt;
                                                            if (player.stats[0]<0) 
                                                            {
                                                                System.out.println("YOU DIED");
                                                                System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                                area1_cleared = true;
                                                                area2_cleared = true;
                                                                area3_cleared = true;
                                                                area4_cleared = true;
                                                                running = false;
                                                                break OUTER; 
                                                            }
                                                     }
                                             break;
                                        case "item stats":
                                        case "is":
                                            System.out.println("Where is this item located?\n\t1. Bag\n\t2. Equipment");
                                            try {
                                                int temp = Integer.parseInt(scan.nextLine());
                                                switch (temp) {
                                                    case 1:
                                                        System.out.println("What item do you want to know the stats for? Type 1 for first item, 2 for second, and so on.");
                                                        System.out.println("\tBag: " + Arrays.toString(player.inventory));
                                                        try {
                                                            int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                                            if(player.inventory[tempa] != null){
                                                                System.out.println(player.inventory[tempa].name + " alters your stats in this way:");
                                                                player.inventory[tempa].getStats();
                                                            }
                                                            else{
                                                                System.out.println("You do not have an item in that slot. Please try again.");
                                                            }
                                                        } catch (NumberFormatException e) {
                                                            System.out.println("Please try again and enter a number.");
                                                            break OUTER_6;
                                                        }
                                                        break OUTER_6;
                                                    case 2:
                                                        System.out.println("What item do you want to know the stats for? Type 1 for first item, 2 for second, and so on.");
                                                        System.out.println("\tEquipment: " + Arrays.toString(player.equipment));
                                                        try {
                                                            int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                                            if(player.equipment[tempa] != null){
                                                                System.out.println(player.equipment[tempa].name + " alters your stats in this way:");
                                                                player.equipment[tempa].getStats();
                                                            }
                                                            else{
                                                                System.out.println("You do not have an item in that slot. Please try again.");
                                                            }
                                                        } catch (NumberFormatException e) {
                                                            System.out.println("Please try again and enter a number.");
                                                            break OUTER_6;
                                                        }
                                                        break OUTER_6;
                                                    default:
                                                        System.out.println("Please try again and enter a valid answer.");
                                                        break;
                                                }
                                            }catch(NumberFormatException e){
                                                System.out.println("Please try again and enter a number.");
                                                break;
                                            }
                                            break;
                                         case "stats":
                                         case "s":
                                             player.showStats();
                                             break;
                                         case "combat help":
                                             player.combatHelp();
                                             break;
                                         default:
                                             System.out.println("enter a valid command (use \"combat help\" for a list of basic combat commands");
                                             break;
                                     }
                                 }//NORMAL COMBAT END
                             }
                             else if(area2_encounter == 2225)
                             {
                                 player.stats[0] = player.stats[0] - 10;
                                 player.stats[1] = player.stats[1] - 3;
                             }
                             break;
                         case 1:
                             a2_enemy.getEnemy2();
                             int turnsAway = rand.nextInt(3);
                             System.out.println("\n\n----------------------------F I G H T !!!----------------------------");
                             System.out.println("combat commands can be pulled up at any time by typing \"combat help\"");
                             OUTER:
                             while (true) {
                                 if(turnsAway > 0)
                                        {
                                            System.out.println("\n\n\tThe enemy is currently " + turnsAway + " turn(s) away!\n\tNow's your chance for ranged attacks "
                                                    + "(type \"ranged attack\"), or just type \"attack\" or \"a\" to charge the enemy straight on!\n\t"
                                                    + "(all skills are considered ranged)\n\t(you can still identify enemy and/or manage items)");
                                        }
                                 System.out.println("\nWhat will you do " + player.name + "?");
                                 input = scan.nextLine();
                                 OUTER_7:
                                 switch (input) {
                                     case "ranged attack":
                                     case "ra": 
                                                if(turnsAway == 0 || turnsAway<0)
                                                {
                                                    System.out.println("\n\tThe enemy is within melee distance! You cannot use ranged attacks right now!");
                                                }
                                                else if(turnsAway > 0)
                                                {
                                                   try{
                                        for (Items equipment : player.equipment) 
                                        {
                                            if (equipment.typeCheckRanged()) 
                                            {
                                                int dmg = rand.nextInt((player.stats[1]) + (player.stats[2]));
                                                turnsAway--;
                                                System.out.println("You deal " + dmg + " to the enemy from afar!\n\tThe enemy is now " + turnsAway + " turn(s) away!");
                                                a1_enemy.enemyStats[1] -= dmg;
                                                break;
                                            } 
                                        }
                                                   }catch(NullPointerException e){System.out.println("\n\tYou don't have a ranged weapon in your equipment! You cannot do ranged attacks!");}
                                                }
                                                    break;
                                     case "attack":
                                     case "a":
                                         if (player.stats[2]>=a2_enemy.enemyStats[3]) {
                                             int dmgDealt = rand.nextInt(player.stats[1]);
                                             int EdmgDealt = rand.nextInt(a2_enemy.enemyStats[2]);
                                             System.out.println("The enemy has taken " + dmgDealt + " damage!");
                                             a2_enemy.enemyStats[1] -= dmgDealt;
                                             if (a2_enemy.enemyStats[1]<0) {
                                                 System.out.println("ENEMY DEFEATED!!!");
                                                 System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                                 a2_enemy.newEnemy2(player.getDiffNum());
                                                 player.stats[0] = MAX_HEALTH;
                                                 player.skill.recharge();
                                                 int gain = rand.nextInt(30) + 20;
                                                 player.gainExp(gain);
                                                 break OUTER;
                                             }
                                             System.out.println("The enemy does " + EdmgDealt + " damage back at you!");
                                             player.stats[0] -= EdmgDealt;
                                             if (player.stats[0]<0) {
                                                 System.out.println("YOU DIED");
                                                 System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                 area2_cleared = true;
                                                 area3_cleared = true;
                                                 area4_cleared = true;
                                                 running = false;
                                                 break OUTER;
                                             }
                                         }
                                         if (player.stats[2]<a2_enemy.enemyStats[3]) {
                                             int dmgDealt = rand.nextInt(player.stats[1]); //////////////////////NOT POSITIVE????/////////////////////////////
                                             int EdmgDealt = rand.nextInt(a2_enemy.enemyStats[2]);
                                             System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                             player.stats[0] -= EdmgDealt;
                                             if (player.stats[0]<0) {
                                                 System.out.println("YOU DIED");
                                                 System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                 area2_cleared = true;
                                                 area3_cleared = true;
                                                 area4_cleared = true;
                                                 running = false;
                                                 break OUTER;
                                             }
                                             System.out.println("The enemy has taken " + dmgDealt + " damage!");
                                             a2_enemy.enemyStats[1] -= dmgDealt;
                                             if (a2_enemy.enemyStats[1]<0) {
                                                 System.out.println("ENEMY DEFEATED!!!");
                                                 System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                                 a2_enemy.newEnemy2(player.getDiffNum());
                                                 player.stats[0] = MAX_HEALTH;
                                                 player.skill.recharge();
                                                 int gain = rand.nextInt(30) + 20;
                                                 player.gainExp(gain);
                                                 break OUTER;
                                             }
                                         }
                                         break;
                                     case "identify":
                                     case "i":
                                         if(player.stats[5]>=7)
                                         {
                                             System.out.println("\n\tyou take time to analyze your enemy\n\t...\n\tyou were able to identify their stats!");
                                             a2_enemy.showEnemyStats();
                                         }
                                         else
                                         {
                                             System.out.println("\n\tyou take time to analyze your enemy\n\t...\n\tyou fail to accurately tell their stats...");
                                         }
                                         if(turnsAway>0)
                                                     {
                                                         turnsAway--;
                                                         System.out.println("\n\n\tThe enemy is now " + turnsAway + " turn(s) away!");
                                                     }
                                                     else if(turnsAway == 0 || turnsAway<0)
                                                     {
                                                        int EdmgDealt = rand.nextInt(a2_enemy.enemyStats[2]);
                                                            System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                                            player.stats[0] -= EdmgDealt;
                                                            if (player.stats[0]<0) 
                                                            {
                                                                System.out.println("YOU DIED");
                                                                System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                                area1_cleared = true;
                                                                area2_cleared = true;
                                                                area3_cleared = true;
                                                                area4_cleared = true;
                                                                running = false;
                                                                break OUTER; 
                                                            }
                                                     }
                                         break;
                                     case "use skill":
                                     case "us":
                                         if(turnsAway > 0)
                                                {
                                                    System.out.println("\n\tEven though the enemy is " + turnsAway + " turn(s) away, you decide to face them right away!");
                                                }
                                                turnsAway = 0;
                                         if(player.skill.uses){
                                             if(player.skill.getName().equalsIgnoreCase("Blessing")){
                                                 if (player.stats[2]>=a2_enemy.enemyStats[3]) {
                                                     int EdmgDealt = rand.nextInt(a2_enemy.enemyStats[2]);
                                                     int HPgained = player.skill.use(player.stats);
                                                     System.out.println("You were healed for " + HPgained + " health points by your skill!");
                                                     player.stats[0] += HPgained;
                                                     System.out.println("The enemy does " + EdmgDealt + " damage back at you!");
                                                     player.stats[0] -= EdmgDealt;
                                                     if (player.stats[0]<0) {
                                                         System.out.println("YOU DIED");
                                                         System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                         area2_cleared = true;
                                                         area3_cleared = true;
                                                         area4_cleared = true;
                                                         running = false;
                                                         break OUTER;
                                                     }
                                                 }
                                                 if (player.stats[2]<a2_enemy.enemyStats[3]) {
                                                     int HPgained = player.skill.use(player.stats);
                                                     int EdmgDealt = rand.nextInt(a2_enemy.enemyStats[2]);
                                                     System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                                     player.stats[0] -= EdmgDealt;
                                                     if (player.stats[0]<0) {
                                                         System.out.println("YOU DIED");
                                                         System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                         area2_cleared = true;
                                                         area3_cleared = true;
                                                         area4_cleared = true;
                                                         running = false;
                                                         break OUTER;
                                                     }
                                                     System.out.println("You were healed for " + HPgained + " health points by your skill!");
                                                     player.stats[0] += HPgained;
                                                 }
                                             }
                                             else{
                                                 if (player.stats[2]>=a2_enemy.enemyStats[3]) {
                                                     int dmgDealt = player.skill.use(player.stats);
                                                     int EdmgDealt = rand.nextInt(a2_enemy.enemyStats[2]);
                                                     System.out.println("The enemy has taken " + dmgDealt + " damage becuase of your skill!");
                                                     a2_enemy.enemyStats[1] -= dmgDealt;
                                                     if (a2_enemy.enemyStats[1]<0) {
                                                         System.out.println("ENEMY DEFEATED!!!");
                                                         System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                                         a2_enemy.newEnemy(player.getDiffNum());
                                                         player.stats[0] = MAX_HEALTH;
                                                         player.skill.recharge();
                                                         int gain = rand.nextInt(30) + 20;
                                                         player.gainExp(gain);
                                                         break OUTER;
                                                     }
                                                     System.out.println("The enemy does " + EdmgDealt + " damage back at you!");
                                                     player.stats[0] -= EdmgDealt;
                                                     if (player.stats[0]<0) {
                                                         System.out.println("YOU DIED");
                                                         System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                         area2_cleared = true;
                                                         area3_cleared = true;
                                                         area4_cleared = true;
                                                         running = false;
                                                         break OUTER;
                                                     }
                                                 }
                                                 if (player.stats[2]<a2_enemy.enemyStats[3]) {
                                                     int dmgDealt = player.skill.use(player.stats);
                                                     int EdmgDealt = rand.nextInt(a2_enemy.enemyStats[2]);
                                                     System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                                     player.stats[0] -= EdmgDealt;
                                                     if (player.stats[0]<0) {
                                                         System.out.println("YOU DIED");
                                                         System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                         area2_cleared = true;
                                                         area3_cleared = true;
                                                         area4_cleared = true;
                                                         running = false;
                                                         break OUTER;
                                                     }
                                                     System.out.println("The enemy has taken " + dmgDealt + " damage because of your skill!");
                                                     a2_enemy.enemyStats[1] -= dmgDealt;
                                                     if (a2_enemy.enemyStats[1]<0) {
                                                         System.out.println("ENEMY DEFEATED!!!");
                                                         System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                                         a2_enemy.newEnemy(player.getDiffNum());
                                                         player.stats[0] = MAX_HEALTH;
                                                         player.skill.recharge();
                                                         int gain = rand.nextInt(30) + 20;
                                                         player.gainExp(gain);  
                                                         break OUTER;
                                                     }
                                                 }
                                             }
                                         }
                                         else
                                             System.out.println("You cannot use that skill again this battle!");
                                         break;
                                     case "skill info":
                                     case "si":
                                         System.out.println("\t"+player.skill.getSkillInfo());
                                         break;
                                     case "equipment":
                                     case"se":
                                         System.out.println(Arrays.toString(player.equipment));
                                         break;
                                     case "bag":
                                     case "b":
                                         System.out.println(Arrays.toString(player.inventory));
                                         break;
                                     case "use":
                                     case "u":
                                         System.out.println("What item did you want to use from your bag? Type 1 for first item, 2 for second, and so on.");
                                         System.out.println("\t" + Arrays.toString(player.inventory));
                                         try{
                                             int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                             if(tempa < player.inventory.length){
                                                if(player.inventory[tempa] != null){
                                                    if(player.inventory[tempa].typeCheckConsumable()){
                                                        System.out.println("You use " + player.inventory[tempa].name + ".");
                                                        player.stats = player.inventory[tempa].ADDstats(player.stats);
                                                        player.inventory = player.inventory[tempa].dropInventory(player.inventory);
                                                    }
                                                    else
                                                        System.out.println("That is not a usable item.");
                                                }
                                                else
                                                 System.out.println("You do not have an item in that slot.");
                                             }
                                             else
                                                 System.out.println("You do not have an item in that slot.");
                                         }
                                         catch(NumberFormatException e){
                                             System.out.println("Please enter a number.");
                                             break;
                                         }
                                         if(turnsAway>0)
                                                     {
                                                         turnsAway--;
                                                         System.out.println("\n\n\tThe enemy is now " + turnsAway + " turn(s) away!");
                                                     }
                                                     else if(turnsAway == 0 || turnsAway<0)
                                                     {
                                                        int EdmgDealt = rand.nextInt(a2_enemy.enemyStats[2]);
                                                            System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                                            player.stats[0] -= EdmgDealt;
                                                            if (player.stats[0]<0) 
                                                            {
                                                                System.out.println("YOU DIED");
                                                                System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                                area1_cleared = true;
                                                                area2_cleared = true;
                                                                area3_cleared = true;
                                                                area4_cleared = true;
                                                                running = false;
                                                                break OUTER; 
                                                            }
                                                     }
                                         break;
                                    case "item stats":
                                    case "is":
                                        System.out.println("Where is this item located?\n\t1. Bag\n\t2. Equipment");
                                        try {
                                            int temp = Integer.parseInt(scan.nextLine());
                                            switch (temp) {
                                                case 1:
                                                    System.out.println("What item do you want to know the stats for? Type 1 for first item, 2 for second, and so on.");
                                                    System.out.println("\tBag: " + Arrays.toString(player.inventory));
                                                    try {
                                                        int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                                        if(player.inventory[tempa] != null){
                                                            System.out.println(player.inventory[tempa].name + " alters your stats in this way:");
                                                            player.inventory[tempa].getStats();
                                                        }
                                                        else{
                                                            System.out.println("You do not have an item in that slot. Please try again.");
                                                        }
                                                    } catch (NumberFormatException e) {
                                                        System.out.println("Please try again and enter a number.");
                                                        break OUTER_7;
                                                    }
                                                    break OUTER_7;
                                                case 2:
                                                    System.out.println("What item do you want to know the stats for? Type 1 for first item, 2 for second, and so on.");
                                                    System.out.println("\tEquipment: " + Arrays.toString(player.equipment));
                                                    try {
                                                        int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                                        if(player.equipment[tempa] != null){
                                                            System.out.println(player.equipment[tempa].name + " alters your stats in this way:");
                                                            player.equipment[tempa].getStats();
                                                        }
                                                        else{
                                                            System.out.println("You do not have an item in that slot. Please try again.");
                                                        }
                                                    } catch (NumberFormatException e) {
                                                        System.out.println("Please try again and enter a number.");
                                                        break OUTER_7;
                                                    }
                                                    break OUTER_7;
                                                default:
                                                    System.out.println("Please try again and enter a valid answer.");
                                                    break;
                                            }
                                        }catch(NumberFormatException e){
                                            System.out.println("Please try again and enter a number.");
                                            break;
                                        }
                                        break;
                                     case "stats":
                                     case "s":
                                         player.showStats();
                                         break;
                                     case "combat help":
                                         player.combatHelp();
                                         break;
                                     case "help":
                                         player.help();
                                         break;
                                     default:
                                         System.out.println("enter a valid command (use \"combat help\" for a list of basic combat commands");
                                         break;
                                 }
                             }//NORMAL COMBAT END
                             break;
                         case 2:
                             System.out.println("You found a chest! It contained: " + area1_chest.open());
                             OUTER:
                             while (true) {
                                 System.out.println("\n\tWould you like to keep the item?");
                                 System.out.println("\t\t 1. Yes");
                                 System.out.println("\t\t 2. No");
                                 input = scan.nextLine();
                                 switch (input) {
                                     case "1":
                                         System.out.println("You yank the item from the chest!\nYou gained: " + area1_chest.open());
                                         player.inventory = area1_chest.open().ADDinventory(player.inventory);
                                         System.out.println(Arrays.toString(player.inventory));
                                         area1_chest.newItem();
                                         break OUTER;
                                     case "2":
                                         System.out.println("You decided to leave the item behind.");
                                         area1_chest.newItem();
                                         break OUTER;
                                     default:
                                         System.out.println("Please enter a valid option.");
                                         break;
                                 }
                             } //CHEST END
                             break;
                         case 3:
                             int mod = 1;
                                    switch (player.getDiffNum()) {
                                        case 1:
                                            {
                                                mod = 1;
                                                break;
                                            }
                                        case 2:
                                            {
                                                mod = 2;
                                                break;
                                            }
                                        case 3:
                                            {
                                                mod = 3;
                                                break;
                                            }
                                        case 4:
                                            {
                                                mod = 4;
                                                break;
                                            }
                                        default:
                                            break;
                                    }
                             Enemy bigBoi = new Enemy(100 * mod, 50 * mod, 15 * mod, 15, 15, 15, 15, 15);
                             turnsAway = 2;
                             HOD_GAME boss2 = new HOD_GAME (2);
                             System.out.println("\n\n----------------------------I T ' S   B O S S   T I M E   B O i S----------------------------");
                             System.out.println("combat commands can be pulled up at any time by typing \"combat help\"");
                             OUTER:
                             while (true) {
                                 if(turnsAway > 0)
                                        {
                                            System.out.println("\n\n\tThe enemy is currently " + turnsAway + " turn(s) away!\n\tNow's your chance for ranged attacks "
                                                    + "(type \"ranged attack\"), or just type \"attack\" or \"a\" to charge the enemy straight on!\n\t"
                                                    + "(all skills are considered ranged)\n\t(you can still identify enemy and/or manage items)");
                                        }
                                 System.out.println("\nWhat will you do " + player.name + "?");
                                 input = scan.nextLine();
                                 OUTER_8:
                                 switch (input) {
                                     case "ranged attack":
                                     case "ra": 
                                                if(turnsAway == 0 || turnsAway<0)
                                                {
                                                    System.out.println("\n\tThe enemy is within melee distance! You cannot use ranged attacks right now!");
                                                }
                                                else if(turnsAway > 0)
                                                {
                                                   try{
                                        for (Items equipment : player.equipment) 
                                        {
                                            if (equipment.typeCheckRanged())  
                                            {
                                                int dmg = rand.nextInt((player.stats[1]) + (player.stats[2]));
                                                turnsAway--;
                                                System.out.println("You deal " + dmg + " to the enemy from afar!\n\tThe enemy is now " + turnsAway + " turn(s) away!");
                                                a1_enemy.enemyStats[1] -= dmg;
                                                break;
                                            } 
                                        }
                                                   }catch(NullPointerException e){System.out.println("\n\tYou don't have a ranged weapon in your equipment! You cannot do ranged attacks!");}
                                                }
                                                    break;
                                     case "attack":
                                        case "a":
                                            if (player.stats[2]>=bigBoi.enemyStats[3]) {
                                                int dmgDealt = rand.nextInt(player.stats[1]);
                                                int EdmgDealt;
                                                System.out.println("The enemy has taken " + dmgDealt + " damage!");
                                                bigBoi.enemyStats[1] -= dmgDealt;
                                                if (bigBoi.enemyStats[1]<0) {
                                                    System.out.println("ENEMY DEFEATED!!!");
                                                    System.out.println("\n\n----------------------------BOSS HAS BEEN Y E E T E D----------------------------\n\n");
                                                    bigBoi.enemyStats[1] = 100;
                                                    player.stats[0] = MAX_HEALTH;
                                                    player.skill.recharge();
                                                    int gain = player.maxExp;
                                                    player.gainExp(gain);
                                                    break OUTER;
                                                }
                                                EdmgDealt = bigBoi.bossTwoSkills(rand.nextInt(2),player.stats[1] , player.stats[2], player.stats[4], player.stats[6], bigBoi.enemyStats[2], bigBoi.enemyStats[5]);
                                                player.stats[0] -= EdmgDealt;
                                                if (player.stats[0]<0) {
                                                    System.out.println("YOU DIED");
                                                    System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                    area1_cleared = true;
                                                    area2_cleared = true;
                                                    area3_cleared = true;
                                                    area4_cleared = true;
                                                    running = false;
                                                    break OUTER;
                                                }
                                            }
                                            if (player.stats[2]<bigBoi.enemyStats[3]) {
                                                int dmgDealt = rand.nextInt(player.stats[1]);///////////////////NOT POSITIVE?????/////////////////////////////////////
                                                int EdmgDealt = 0;
                                                EdmgDealt = bigBoi.bossTwoSkills(rand.nextInt(2),player.stats[1] , player.stats[2], player.stats[4], player.stats[6], bigBoi.enemyStats[2], bigBoi.enemyStats[5]);
                                                player.stats[0] -= EdmgDealt;
                                                if (player.stats[0]<0) {
                                                    System.out.println("YOU DIED");
                                                    System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                    area1_cleared = true;
                                                    area2_cleared = true;
                                                    area3_cleared = true;
                                                    area4_cleared = true;
                                                    running = false;
                                                    break OUTER;
                                                }
                                                System.out.println("\n\tThe enemy has taken " + dmgDealt + " damage!");
                                                bigBoi.enemyStats[1] -= dmgDealt;
                                                if (bigBoi.enemyStats[1]<0) {
                                                    System.out.println("ENEMY DEFEATED!!!");
                                                    System.out.println("\n\n----------------------------BOSS HAS BEEN Y E E T E D----------------------------\n\n");
                                                    bigBoi.enemyStats[1] = 100;
                                                    player.stats[0] = MAX_HEALTH;
                                                    player.skill.recharge();
                                                    int gain = player.maxExp;
                                                    player.gainExp(gain);
                                                    break OUTER;
                                                }
                                            }
                                            break;
                                     case "identify":
                                     case "i":
                                         if(player.stats[5]>=7)
                                         {
                                             System.out.println("\n\tyou take time to analyze your enemy\n\t...\n\tyou were able to identify their stats!");
                                             bigBoi.showEnemyStats();
                                         }
                                         else
                                         {
                                             System.out.println("\n\tyou take time to analyze your enemy\n\t...\n\tyou fail to accurately tell their stats...");
                                         }
                                         if(turnsAway>0)
                                                     {
                                                         turnsAway--;
                                                         System.out.println("\n\n\tThe enemy is now " + turnsAway + " turn(s) away!");
                                                     }
                                                     else if(turnsAway == 0 || turnsAway<0)
                                                     {
                                                         int EdmgDealt = 0;
                                                         EdmgDealt = bigBoi.bossTwoSkills(rand.nextInt(2),player.stats[1] , player.stats[2], player.stats[4], player.stats[6], bigBoi.enemyStats[2], bigBoi.enemyStats[5]);
                                                            player.stats[0] -= EdmgDealt;
                                                            if (player.stats[0]<0) 
                                                            {
                                                                System.out.println("YOU DIED");
                                                                System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                                area1_cleared = true;
                                                                area2_cleared = true;
                                                                area3_cleared = true;
                                                                area4_cleared = true;
                                                                running = false;
                                                                break OUTER; 
                                                            }
                                                     }
                                         break;
                                     case "use skill":
                                     case "us":
                                         if(turnsAway > 0)
                                                {
                                                    System.out.println("\n\tEven though the enemy is " + turnsAway + " turn(s) away, you decide to face them right away!");
                                                }
                                                turnsAway = 0;
                                         if(player.skill.uses){
                                             if(player.skill.getName().equalsIgnoreCase("Blessing")){
                                                 if (player.stats[2]>=bigBoi.enemyStats[3]) {
                                                     int HPgained = player.skill.use(player.stats);
                                                     System.out.println("You were healed for " + HPgained + " health points by your skill!");
                                                     player.stats[0] += HPgained;
                                                     int EdmgDealt = 0;
                                                     EdmgDealt = bigBoi.bossTwoSkills(rand.nextInt(2),player.stats[1] , player.stats[2], player.stats[4], player.stats[6], bigBoi.enemyStats[2], bigBoi.enemyStats[5]);
                                                     player.stats[0] -= EdmgDealt;
                                                     if (player.stats[0]<0) {
                                                         System.out.println("YOU DIED");
                                                         System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                         area2_cleared = true;
                                                         area3_cleared = true;
                                                         area4_cleared = true;
                                                         running = false;
                                                         break OUTER;
                                                     }
                                                 }
                                                 if (player.stats[2]<bigBoi.enemyStats[3]) {
                                                     int HPgained = player.skill.use(player.stats);
                                                     int EdmgDealt = 0;
                                                     EdmgDealt = bigBoi.bossTwoSkills(rand.nextInt(2),player.stats[1] , player.stats[2], player.stats[4], player.stats[6], bigBoi.enemyStats[2], bigBoi.enemyStats[5]);
                                                     player.stats[0] -= EdmgDealt;
                                                     if (player.stats[0]<0) {
                                                         System.out.println("YOU DIED");
                                                         System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                         area2_cleared = true;
                                                         area3_cleared = true;
                                                         area4_cleared = true;
                                                         running = false;
                                                         break OUTER;
                                                     }
                                                     System.out.println("You were healed for " + HPgained + " health points by your skill!");
                                                     player.stats[0] += HPgained;
                                                 }
                                             }
                                             else{
                                                 if (player.stats[2]>=bigBoi.enemyStats[3]) {
                                                     int dmgDealt = player.skill.use(player.stats);
                                                     System.out.println("The enemy has taken " + dmgDealt + " damage becuase of your skill!");
                                                     bigBoi.enemyStats[1] -= dmgDealt;
                                                     if (bigBoi.enemyStats[1]<0) {
                                                         System.out.println("ENEMY DEFEATED!!!");
                                                         System.out.println("\n\n----------------------------BOSS HAS BEEN Y E E T E D----------------------------\n\n");
                                                         bigBoi.newEnemy(player.getDiffNum());
                                                         player.stats[0] = MAX_HEALTH;
                                                         player.skill.recharge();
                                                         int gain = player.maxExp;
                                                         player.gainExp(gain);
                                                         break OUTER;
                                                     }
                                                     int EdmgDealt = 0;
                                                     EdmgDealt = bigBoi.bossTwoSkills(rand.nextInt(2),player.stats[1] , player.stats[2], player.stats[4], player.stats[6], bigBoi.enemyStats[2], bigBoi.enemyStats[5]);
                                                     player.stats[0] -= EdmgDealt;
                                                     if (player.stats[0]<0) {
                                                         System.out.println("YOU DIED");
                                                         System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                         area2_cleared = true;
                                                         area3_cleared = true;
                                                         area4_cleared = true;
                                                         running = false;
                                                         break OUTER;
                                                     }
                                                 }
                                                 if (player.stats[2]<bigBoi.enemyStats[3]) {
                                                     int dmgDealt = player.skill.use(player.stats);
                                                     int EdmgDealt = 0;
                                                     EdmgDealt = bigBoi.bossTwoSkills(rand.nextInt(2),player.stats[1] , player.stats[2], player.stats[4], player.stats[6], bigBoi.enemyStats[2], bigBoi.enemyStats[5]);
                                                     player.stats[0] -= EdmgDealt;
                                                     if (player.stats[0]<0) {
                                                         System.out.println("YOU DIED");
                                                         System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                         area2_cleared = true;
                                                         area3_cleared = true;
                                                         area4_cleared = true;
                                                         running = false;
                                                         break OUTER;
                                                     }
                                                     System.out.println("The enemy has taken " + dmgDealt + " damage because of your skill!");
                                                     bigBoi.enemyStats[1] -= dmgDealt;
                                                     if (bigBoi.enemyStats[1]<0) {
                                                         System.out.println("ENEMY DEFEATED!!!");
                                                         System.out.println("\n\n----------------------------BOSS HAS BEEN Y E E T E D----------------------------\n\n");
                                                         bigBoi.newEnemy(player.getDiffNum());
                                                         player.stats[0] = MAX_HEALTH;
                                                         player.skill.recharge();
                                                         int gain = player.maxExp;
                                                         player.gainExp(gain);
                                                         break OUTER;
                                                     }
                                                 }
                                             }
                                         }
                                         else
                                             System.out.println("You cannot use that skill again this battle!");
                                         break;
                                     case "skill info":
                                     case "si":
                                         System.out.println("\t"+player.skill.getSkillInfo());
                                         break;
                                     case "equipment":
                                     case"se":
                                         System.out.println(Arrays.toString(player.equipment));
                                         break;
                                     case "bag":
                                     case "b":
                                         System.out.println(Arrays.toString(player.inventory));
                                         break;
                                     case "use":
                                     case "u":
                                         System.out.println("What item did you want to use from your bag? Type 1 for first item, 2 for second, and so on.");
                                         System.out.println("\t" + Arrays.toString(player.inventory));
                                         try{
                                             int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                             if(tempa < player.inventory.length){
                                                if(player.inventory[tempa] != null){
                                                    if(player.inventory[tempa].typeCheckConsumable()){
                                                        System.out.println("You use " + player.inventory[tempa].name + ".");
                                                        player.stats = player.inventory[tempa].ADDstats(player.stats);
                                                        player.inventory = player.inventory[tempa].dropInventory(player.inventory);
                                                    }
                                                    else
                                                        System.out.println("That is not a usable item.");
                                                }
                                                else
                                                 System.out.println("You do not have an item in that slot.");
                                             }
                                             else
                                                 System.out.println("You do not have an item in that slot.");
                                         }
                                         catch(NumberFormatException e){
                                             System.out.println("Please enter a number.");
                                             break;
                                         }
                                         if(turnsAway>0)
                                                     {
                                                         turnsAway--;
                                                         System.out.println("\n\n\tThe enemy is now " + turnsAway + " turn(s) away!");
                                                     }
                                                     else if(turnsAway == 0 || turnsAway<0)
                                                     {
                                                        int EdmgDealt = rand.nextInt(bigBoi.enemyStats[2]);
                                                            System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                                            player.stats[0] -= EdmgDealt;
                                                            if (player.stats[0]<0) 
                                                            {
                                                                System.out.println("YOU DIED");
                                                                System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                                area1_cleared = true;
                                                                area2_cleared = true;
                                                                area3_cleared = true;
                                                                area4_cleared = true;
                                                                running = false;
                                                                break OUTER; 
                                                            }
                                                     }
                                         break;
                                    case "item stats":
                                    case "is":
                                        System.out.println("Where is this item located?\n\t1. Bag\n\t2. Equipment");
                                        try {
                                            int temp = Integer.parseInt(scan.nextLine());
                                            switch (temp) {
                                                case 1:
                                                    System.out.println("What item do you want to know the stats for? Type 1 for first item, 2 for second, and so on.");
                                                    System.out.println("\tBag: " + Arrays.toString(player.inventory));
                                                    try {
                                                        int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                                        if(player.inventory[tempa] != null){
                                                            System.out.println(player.inventory[tempa].name + " alters your stats in this way:");
                                                            player.inventory[tempa].getStats();
                                                        }
                                                        else{
                                                            System.out.println("You do not have an item in that slot. Please try again.");
                                                        }
                                                    } catch (NumberFormatException e) {
                                                        System.out.println("Please try again and enter a number.");
                                                        break OUTER_8;
                                                    }
                                                    break OUTER_8;
                                                case 2:
                                                    System.out.println("What item do you want to know the stats for? Type 1 for first item, 2 for second, and so on.");
                                                    System.out.println("\tEquipment: " + Arrays.toString(player.equipment));
                                                    try {
                                                        int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                                        if(player.equipment[tempa] != null){
                                                            System.out.println(player.equipment[tempa].name + " alters your stats in this way:");
                                                            player.equipment[tempa].getStats();
                                                        }
                                                        else{
                                                            System.out.println("You do not have an item in that slot. Please try again.");
                                                        }
                                                    } catch (NumberFormatException e) {
                                                        System.out.println("Please try again and enter a number.");
                                                        break OUTER_8;
                                                    }
                                                    break OUTER_8;
                                                default:
                                                    System.out.println("Please try again and enter a valid answer.");
                                                    break;
                                            }
                                        }catch(NumberFormatException e){
                                            System.out.println("Please try again and enter a number.");
                                            break;
                                        }
                                        break;
                                     case "stats":
                                     case "s":
                                         player.showStats();
                                         break;
                                     case "combat help":
                                         player.combatHelp();
                                         break;
                                     case "help":
                                         player.help();
                                         break;
                                     default:
                                         System.out.println("enter a valid command (use \"combat help\" for a list of basic combat commands");
                                         break;
                                 }
                             } // BOSS FIGHT END
                             break;
                         case 4:
                             System.out.println("You have found the exit to the area! But alas... you only get deeper into this hell hole instead of having freedom");
                             area2_cleared = true;
                             break;
                         default:
                             break;
                     } // AREA GET DATA END
                     break;
                 case "equipment":
                 case"se":
                     System.out.println(Arrays.toString(player.equipment));
                     break;
                 case "bag":
                 case "b":
                     System.out.println(Arrays.toString(player.inventory));
                     break;
                 case "drop":
                 case "d":
                     System.out.println("From where would you like to drop something?\n\t1. Bag\n\t2. Equipment");
                     try {
                         int temp = Integer.parseInt(scan.nextLine());
                         switch (temp) {
                             case 1:
                                 System.out.println("Which item did you want to drop from your bag? Type 1 for first item, 2 for second, and so on.");
                                 System.out.println("\t" + Arrays.toString(player.inventory));
                                 try {
                                     int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                     if(tempa < player.inventory.length){
                                        if (player.inventory[tempa] != null) {
                                            System.out.println("You dropped your " + player.inventory[tempa].name + ".");
                                            player.inventory = player.inventory[tempa].dropInventory(player.inventory);
                                            break OUTER_9;
                                        }
                                        else
                                            System.out.println("You do not have an item in that slot.");
                                     }
                                     else {
                                         System.out.println("You do not have an item in that slot. Please try again.");
                                     }
                                 } catch (NumberFormatException e) {
                                     System.out.println("Please try again and enter a number.");
                                     break OUTER_9;
                                 }
                                 break OUTER_9;
                             case 2:
                                 System.out.println("Which item did you want to drop from your equipment? Type 1 for first item, 2 for second, and so on.");
                                 System.out.println("\t" + Arrays.toString(player.equipment));
                                 try {
                                     int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                     if(tempa < player.equipment.length){
                                        if (player.equipment[tempa] != null) {
                                            System.out.println("You dropped your " + player.equipment[tempa].name + ".");
                                            player.stats = player.equipment[tempa].SUBstats(player.stats);
                                            player.equipment = player.equipment[tempa].dropEquipment(player.equipment);
                                            break OUTER_9;
                                        }
                                        else
                                            System.out.println("You do not have an item in that slot.");
                                     }
                                     else {
                                         System.out.println("You do not have an item in that slot. Please try again.");
                                     }
                                 } catch (NumberFormatException e) {
                                     System.out.println("Please try again and enter a number.");
                                     break OUTER_9;
                                 }
                                 break;
                             default:
                                 System.out.println("Please try again and enter a valid answer.");
                                 break;
                         }
                     }catch(NumberFormatException e){
                         System.out.println("Please try again and enter a number.");
                         break;
                     }
                     break;
                 case "equip":
                 case "e":
                    if(!dummy.isFull(player.equipment)){
                        System.out.println("What item did you want to equip from your bag? Type 1 for first item, 2 for second, and so on.");
                        System.out.println("\t" + Arrays.toString(player.inventory));
                        try{
                            int tempa = Integer.parseInt(scan.nextLine()) - 1;
                            if(tempa < player.inventory.length){
                                if(player.inventory[tempa] != null){
                                    System.out.println("You equipped your " + player.inventory[tempa].name + ".");
                                    player.stats = player.inventory[tempa].ADDstats(player.stats);
                                    Items[][] temp = player.inventory[tempa].equip(player.inventory, player.equipment);
                                    player.inventory = temp[0];
                                    player.equipment = temp[1];
                                    break;
                                }
                                else
                                    System.out.println("You do not have an item in that slot.");
                            }
                            else
                                System.out.println("You do not have an equipped item in that slot.");
                        }
                        catch(NumberFormatException e){
                            System.out.println("Please enter a number.");
                            break;
                        }
                        break;
                    }
                    else
                        System.out.println("Your equipment is full! You can't equip an item.");
                    break;
                case "unequip":
                case "ue":
                    if(!dummy.isFull(player.inventory)){
                        System.out.println("What item did you want to unequip from your equipment? Type 1 for first item, 2 for second, and so on.");
                        System.out.println("\t" + Arrays.toString(player.equipment));
                        try{
                            int tempa = Integer.parseInt(scan.nextLine()) - 1;
                            if(tempa < player.equipment.length){
                                if(player.equipment[tempa] != null){
                                    System.out.println("You unequipped your " + player.equipment[tempa].name + ".");
                                    player.stats = player.equipment[tempa].SUBstats(player.stats);
                                    Items[][] temp = player.equipment[tempa].unequip(player.inventory, player.equipment);
                                    player.inventory = temp[0];
                                    player.equipment = temp[1];
                                    break;
                                }
                                else
                                    System.out.println("You do not have an item in that slot.");
                            }
                            else
                                System.out.println("You do not have an equipped item in that slot.");
                        }
                        catch(NumberFormatException e){
                            System.out.println("Please enter a number.");
                            break;
                        }
                        break;
                    }
                  else
                    System.out.println("Your bag is full! You can't unequip an item.");
                  break;
                 case "use":
                 case "u":
                     System.out.println("What item did you want to use from your bag? Type 1 for first item, 2 for second, and so on.");
                     System.out.println("\t" + Arrays.toString(player.inventory));
                     try{
                         int tempa = Integer.parseInt(scan.nextLine()) - 1;
                         if(tempa < player.inventory.length){
                            if(player.inventory[tempa] != null){
                                if(player.inventory[tempa].typeCheckConsumable()){
                                    System.out.println("You use " + player.inventory[tempa].name + ".");
                                    player.stats = player.inventory[tempa].ADDstats(player.stats);
                                    player.inventory = player.inventory[tempa].dropInventory(player.inventory);
                                }
                                else
                                    System.out.println("That is not a usable item.");
                            }
                            else
                                System.out.println("You do not have an item in that slot.");
                         }
                         else
                             System.out.println("You do not have an item in that slot.");
                     }
                     catch(NumberFormatException e){
                         System.out.println("Please enter a number.");
                         break;
                     }
                     break;
                 case "item stats":
                 case "is":
                     System.out.println("Where is this item located?\n\t1. Bag\n\t2. Equipment");
                     try {
                         int temp = Integer.parseInt(scan.nextLine());
                         switch (temp) {
                             case 1:
                                 System.out.println("What item do you want to know the stats for? Type 1 for first item, 2 for second, and so on.");
                                 System.out.println("\tBag: " + Arrays.toString(player.inventory));
                                 try {
                                     int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                     if(tempa < player.inventory.length){
                                        if(player.inventory[tempa] != null){
                                            System.out.println(player.inventory[tempa].name + " alters your stats in this way:");
                                            player.inventory[tempa].getStats();
                                        }
                                        else
                                            System.out.println("You do not have an item in that slot.");
                                     }
                                     else{
                                         System.out.println("You do not have an item in that slot. Please try again.");
                                     }
                                 } catch (NumberFormatException e) {
                                     System.out.println("Please try again and enter a number.");
                                     break OUTER_10;
                                 }
                                 break OUTER_10;
                             case 2:
                                 System.out.println("What item do you want to know the stats for? Type 1 for first item, 2 for second, and so on.");
                                 System.out.println("\tEquipment: " + Arrays.toString(player.equipment));
                                 try {
                                     int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                     if(tempa < player.equipment.length){
                                        if(player.equipment[tempa] != null){
                                            System.out.println(player.equipment[tempa].name + " alters your stats in this way:");
                                            player.equipment[tempa].getStats();
                                        }
                                        else
                                            System.out.println("You do not have an item in that slot.");
                                     }
                                     else{
                                         System.out.println("You do not have an item in that slot. Please try again.");
                                     }
                                 } catch (NumberFormatException e) {
                                     System.out.println("Please try again and enter a number.");
                                     break OUTER_10;
                                 }
                                 break OUTER_10;
                             default:
                                 System.out.println("Please try again and enter a valid answer.");
                                 break;
                         }
                     }catch(NumberFormatException e){
                         System.out.println("Please try again and enter a number.");
                         break;
                     }
                     break;
                 case "stats":
                 case "s":
                     player.showStats();
                     break;
                 case "skill info":
                 case "si":
                     System.out.println("\t"+player.skill.getSkillInfo());
                     break;
                 default:
                     System.out.println("enter a valid command (use \"help\" for a list of basic commands)");
                     break;
             }
          }//WHILE AREA_2 CLEARED END
          ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
          /////////////////////////////AREA 3 CREATION///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
               int area3_L;
               Area area3 = new Area(0, null, null);
               area3_L = rand.nextInt(3) + 5;
               //System.out.println(area3_L);
               area3.ensureExit();
               area3.ensureBoss();
               for(int i = 0; i<area3_L-1; i++)
               {
                   area3.addNode(rand.nextInt(3));
                   //area3.addNode(0);
               }
               //Area.listLength(area3);
               Area area3_pp = area3;
               Chest area3_chest = new Chest();
               Enemy a3_enemy = new Enemy(1, 1, 1, 1, 1, 1, 1, 1);
               a3_enemy.newEnemy3(player.getDiffNum());
          /////////////////////////////AREA 3 CREATION////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          if(area3_cleared == false)
          {
              System.out.println("\n\n\tIt's very dark in these catacombs, and very sp00ky. This place smells worse than the first. Nonetheless, you continue"
                     + "\n\tto press forward, driven by what could possibly be at the end of all this devistation");
              HOD_GAME area3_pic = new HOD_GAME (7);
          }
          while(area3_cleared == false)
          {
             System.out.println("\n\t\tWhat would you like to do?");
                input = scan.nextLine();
              OUTER_14:
             OUTER_16:
             switch (input) {
                 case "help":
                     player.help();
                     break;
                 case "forward":
                 case "f":
                     area3_pp = area3_pp.getForeLink();
                     //System.out.println(area3_pp.getData());
                     switch (area3_pp.getData()) {
                         case 0:
                             int area3_encounter;
                             area3_encounter = area3.area_3_Encounter(rand.nextInt(4), player.stats[2], player.name);
                             if(area3_encounter<2000)
                             {
                                 player.stats[0] = player.stats[0] - area3_encounter;
                                 if(player.stats[0]<=0)
                                 {
                                     System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                     area3_cleared = true;
                                     area4_cleared = true;
                                     running = false;
                                     break;
                                 }
                             }
                             else if(area3_encounter == 3331)
                             {
                                 TrueNameRevealed = true;
                             }
                             else if(area3_encounter == 3332)
                             {
                                 Enemy Hellish_Abomination = new Enemy(100, 200, 25, 25, 25, 25, 25, 0);
                                 int turnsAway = 2;
                                 System.out.println("\n\n----------------------------F I G H T !!!----------------------------");
                                 System.out.println("combat commands can be pulled up at any time by typing \"combat help\"");
                                 OUTER:
                                 while (true) {
                                     if(turnsAway > 0)
                                        {
                                            System.out.println("\n\n\tThe enemy is currently " + turnsAway + " turn(s) away!\n\tNow's your chance for ranged attacks "
                                                    + "(type \"ranged attack\"), or just type \"attack\" or \"a\" to charge the enemy straight on!\n\t"
                                                    + "(all skills are considered ranged)\n\t(you can still identify enemy and/or manage items)");
                                        }
                                     System.out.println("\nWhat will you do " + player.name + "?");
                                     input = scan.nextLine();
                                     OUTER_11:
                                     switch (input) {
                                         case "ranged attack":
                                         case "ra": 
                                                if(turnsAway == 0 || turnsAway<0)
                                                {
                                                    System.out.println("\n\tThe enemy is within melee distance! You cannot use ranged attacks right now!");
                                                }
                                                else if(turnsAway > 0)
                                                {
                                                   try{
                                        for (Items equipment : player.equipment) 
                                        {
                                            if (equipment.typeCheckRanged())  
                                            {
                                                int dmg = rand.nextInt((player.stats[1]) + (player.stats[2]));
                                                turnsAway--;
                                                System.out.println("You deal " + dmg + " to the enemy from afar!\n\tThe enemy is now " + turnsAway + " turn(s) away!");
                                                a1_enemy.enemyStats[1] -= dmg;
                                                break;
                                            } 
                                        }
                                                   }catch(NullPointerException e){System.out.println("\n\tYou don't have a ranged weapon in your equipment! You cannot do ranged attacks!");}
                                                }
                                                    break;
                                         case "attack":
                                         case "a":
                                             if (player.stats[2]>=Hellish_Abomination.enemyStats[3]) {
                                                 int dmgDealt = rand.nextInt(player.stats[1]);
                                                 int EdmgDealt = rand.nextInt(Hellish_Abomination.enemyStats[2]);
                                                 System.out.println("The enemy has taken " + dmgDealt + " damage!");
                                                 Hellish_Abomination.enemyStats[1] -= dmgDealt;
                                                 if (Hellish_Abomination.enemyStats[1]<0) {
                                                     System.out.println("ENEMY DEFEATED!!!");
                                                     System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                                     System.out.println("\n\n\t\"I can't believe you actually lived... like wow...\n\tWell, for a performance like that, you deserve "
                                                             + "a great reward!\n\tYou've gained Scepter of the Void!");
                                                     Items SOTV = new Items("Scepter of the Void",50,15,15,10,10,10,10,10,0,0,0,0,0,0,2); //+50 HP, +15 STR & DEX, +10 everything else
                                                     player.inventory = SOTV.ADDinventory(player.inventory);
                                                     player.stats[0] = MAX_HEALTH;
                                                     player.skill.recharge();
                                                     int gain = rand.nextInt(35) + 25;
                                                     player.gainExp(gain);
                                                     break OUTER;
                                                 }
                                                 System.out.println("The enemy does " + EdmgDealt + " damage back at you!");
                                                 player.stats[0] -= EdmgDealt;
                                                 if (player.stats[0]<0) {
                                                     System.out.println("YOU DIED");
                                                     System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                     area3_cleared = true;
                                                     area4_cleared = true;
                                                     running = false;
                                                     break OUTER;
                                                 }
                                             }
                                             if (player.stats[2]<Hellish_Abomination.enemyStats[3]) {
                                                 int dmgDealt = rand.nextInt(player.stats[1]);
                                                 int EdmgDealt = rand.nextInt(Hellish_Abomination.enemyStats[2]);
                                                 System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                                 player.stats[0] -= EdmgDealt;
                                                 if (player.stats[0]<0) {
                                                     System.out.println("YOU DIED");
                                                     System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                     area3_cleared = true;
                                                     area4_cleared = true;
                                                     running = false;
                                                     break OUTER;
                                                 }
                                                 System.out.println("The enemy has taken " + dmgDealt + " damage!");
                                                 Hellish_Abomination.enemyStats[1] -= dmgDealt;
                                                 if (Hellish_Abomination.enemyStats[1]<0) {
                                                     System.out.println("ENEMY DEFEATED!!!");
                                                     System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                                     System.out.println("\n\n\t\"I can't believe you actually lived... like wow...\n\tWell, for a performance like that, you deserve "
                                                             + "a great reward!\n\tYou've gained Scepter of the Void!");
                                                     Items SOTV = new Items("Scepter of the Void",50,15,15,10,10,10,10,10,0,0,0,0,0,0,2); //+50 HP, +15 STR & DEX, +10 everything else
                                                     player.inventory = SOTV.ADDinventory(player.inventory);
                                                     player.stats[0] = MAX_HEALTH;
                                                     player.skill.recharge();
                                                     int gain = rand.nextInt(35) + 25;
                                                     player.gainExp(gain);
                                                     break OUTER;
                                                 }
                                             }
                                             break;
                                         case "identify":
                                         case "i":
                                             if(player.stats[5]>=7)
                                             {
                                                 System.out.println("\n\tyou take time to analyze your enemy\n\t...\n\tyou were able to identify their stats!");
                                                 Hellish_Abomination.showEnemyStats();
                                             }
                                             else
                                             {
                                                 System.out.println("\n\tyou take time to analyze your enemy\n\t...\n\tyou fail to accurately tell their stats...");
                                             }
                                             if(turnsAway>0)
                                                     {
                                                         turnsAway--;
                                                         System.out.println("\n\n\tThe enemy is now " + turnsAway + " turn(s) away!");
                                                     }
                                                     else if(turnsAway == 0 || turnsAway<0)
                                                     {
                                                        int EdmgDealt = rand.nextInt(Hellish_Abomination.enemyStats[2]);
                                                            System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                                            player.stats[0] -= EdmgDealt;
                                                            if (player.stats[0]<0) 
                                                            {
                                                                System.out.println("YOU DIED");
                                                                System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                                area1_cleared = true;
                                                                area2_cleared = true;
                                                                area3_cleared = true;
                                                                area4_cleared = true;
                                                                running = false;
                                                                break OUTER; 
                                                            }
                                                     }
                                             break;
                                         case "use skill":
                                         case "us":
                                             if(turnsAway > 0)
                                                {
                                                    System.out.println("\n\tEven though the enemy is " + turnsAway + " turn(s) away, you decide to face them right away!");
                                                }
                                                turnsAway = 0;
                                             if(player.skill.uses){
                                                 if(player.skill.getName().equalsIgnoreCase("Blessing")){
                                                     if (player.stats[2]>=Hellish_Abomination.enemyStats[3]) {
                                                         int EdmgDealt = rand.nextInt(Hellish_Abomination.enemyStats[2]);
                                                         int HPgained = player.skill.use(player.stats);
                                                         System.out.println("You were healed for " + HPgained + " health points by your skill!");
                                                         player.stats[0] += HPgained;
                                                         System.out.println("The enemy does " + EdmgDealt + " damage back at you!");
                                                         player.stats[0] -= EdmgDealt;
                                                         if (player.stats[0]<0) {
                                                             System.out.println("YOU DIED");
                                                             System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                             area3_cleared = true;
                                                             area4_cleared = true;
                                                             running = false;
                                                             break OUTER;
                                                         }
                                                     }
                                                     if (player.stats[2]<Hellish_Abomination.enemyStats[3]) {
                                                         int HPgained = player.skill.use(player.stats);
                                                         int EdmgDealt = rand.nextInt(Hellish_Abomination.enemyStats[2]);
                                                         System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                                         player.stats[0] -= EdmgDealt;
                                                         if (player.stats[0]<0) {
                                                             System.out.println("YOU DIED");
                                                             System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                             area3_cleared = true;
                                                             area4_cleared = true;
                                                             running = false;
                                                             break OUTER;
                                                         }
                                                         System.out.println("You were healed for " + HPgained + " health points by your skill!");
                                                         player.stats[0] += HPgained;
                                                     }
                                                 }
                                                 else{
                                                     if (player.stats[2]>=Hellish_Abomination.enemyStats[3]) {
                                                         int dmgDealt = player.skill.use(player.stats);
                                                         int EdmgDealt = rand.nextInt(Hellish_Abomination.enemyStats[2]);
                                                         System.out.println("The enemy has taken " + dmgDealt + " damage becuase of your skill!");
                                                         Hellish_Abomination.enemyStats[1] -= dmgDealt;
                                                         if (Hellish_Abomination.enemyStats[1]<0) {
                                                             System.out.println("ENEMY DEFEATED!!!");
                                                             System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                                             System.out.println("\n\n\t\"I can't believe you actually lived... like wow...\n\tWell, for a performance like that, you deserve "
                                                                     + "a great reward!\n\tYou've gained Scepter of the Void!");
                                                             Items SOTV = new Items("Scepter of the Void",50,15,15,10,10,10,10,10,0,0,0,0,0,0,2); //+50 HP, +15 STR & DEX, +10 everything else
                                                             player.inventory = SOTV.ADDinventory(player.inventory);
                                                             player.stats[0] = MAX_HEALTH;
                                                             player.skill.recharge();
                                                             int gain = rand.nextInt(35) + 25;
                                                             player.gainExp(gain);
                                                             break OUTER;
                                                         }
                                                         System.out.println("The enemy does " + EdmgDealt + " damage back at you!");
                                                         player.stats[0] -= EdmgDealt;
                                                         if (player.stats[0]<0) {
                                                             System.out.println("YOU DIED");
                                                             System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                             area3_cleared = true;
                                                             area4_cleared = true;
                                                             running = false;
                                                             break OUTER;
                                                         }
                                                     }
                                                     if (player.stats[2]<Hellish_Abomination.enemyStats[3]) {
                                                         int dmgDealt = player.skill.use(player.stats);
                                                         int EdmgDealt = rand.nextInt(Hellish_Abomination.enemyStats[2]);
                                                         System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                                         player.stats[0] -= EdmgDealt;
                                                         if (player.stats[0]<0) {
                                                             System.out.println("YOU DIED");
                                                             System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                             area3_cleared = true;
                                                             area4_cleared = true;
                                                             running = false;
                                                             break OUTER;
                                                         }
                                                         System.out.println("The enemy has taken " + dmgDealt + " damage because of your skill!");
                                                         Hellish_Abomination.enemyStats[1] -= dmgDealt;
                                                         if (Hellish_Abomination.enemyStats[1]<0) {
                                                             System.out.println("ENEMY DEFEATED!!!");
                                                             System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                                             System.out.println("\n\n\t\"I can't believe you actually lived... like wow...\n\tWell, for a performance like that, you deserve "
                                                                     + "a great reward!\n\tYou've gained Scepter of the Void!");
                                                             Items SOTV = new Items("Scepter of the Void",50,15,15,10,10,10,10,10,0,0,0,0,0,0,2); //+50 HP, +15 STR & DEX, +10 everything else
                                                             player.inventory = SOTV.ADDinventory(player.inventory);
                                                             player.stats[0] = MAX_HEALTH;
                                                             player.skill.recharge();
                                                             int gain = rand.nextInt(35) + 25;
                                                             player.gainExp(gain);
                                                             break OUTER;
                                                         }
                                                     }
                                                 }
                                             }
                                             else
                                                 System.out.println("You cannot use that skill again this battle!");
                                             break;
                                         case "skill info":
                                         case "si":
                                             System.out.println("\t"+player.skill.getSkillInfo());
                                             break;
                                         case "equipment":
                                         case"se":
                                             System.out.println(Arrays.toString(player.equipment));
                                             break;
                                         case "bag":
                                         case "b":
                                             System.out.println(Arrays.toString(player.inventory));
                                             break;
                                         case "use":
                                         case "u":
                                             System.out.println("What item did you want to use from your bag? Type 1 for first item, 2 for second, and so on.");
                                             System.out.println("\t" + Arrays.toString(player.inventory));
                                             try{
                                                 int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                                 if(tempa < player.inventory.length){
                                                    if(player.inventory[tempa] != null){
                                                        if(player.inventory[tempa].typeCheckConsumable()){
                                                            System.out.println("You use " + player.inventory[tempa].name + ".");
                                                            player.stats = player.inventory[tempa].ADDstats(player.stats);
                                                            player.inventory = player.inventory[tempa].dropInventory(player.inventory);
                                                        }
                                                        else
                                                            System.out.println("That is not a usable item.");
                                                    }
                                                    else
                                                     System.out.println("You do not have an item in that slot.");
                                                 }
                                                 else
                                                     System.out.println("You do not have an item in that slot.");
                                             }
                                             catch(NumberFormatException e){
                                                 System.out.println("Please enter a number.");
                                                 break;
                                             }
                                             if(turnsAway>0)
                                                     {
                                                         turnsAway--;
                                                         System.out.println("\n\n\tThe enemy is now " + turnsAway + " turn(s) away!");
                                                     }
                                                     else if(turnsAway == 0 || turnsAway<0)
                                                     {
                                                        int EdmgDealt = rand.nextInt(Hellish_Abomination.enemyStats[2]);
                                                            System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                                            player.stats[0] -= EdmgDealt;
                                                            if (player.stats[0]<0) 
                                                            {
                                                                System.out.println("YOU DIED");
                                                                System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                                area1_cleared = true;
                                                                area2_cleared = true;
                                                                area3_cleared = true;
                                                                area4_cleared = true;
                                                                running = false;
                                                                break OUTER; 
                                                            }
                                                     }
                                             break;
                                        case "item stats":
                                        case "is":
                                            System.out.println("Where is this item located?\n\t1. Bag\n\t2. Equipment");
                                            try {
                                                int temp = Integer.parseInt(scan.nextLine());
                                                switch (temp) {
                                                    case 1:
                                                        System.out.println("What item do you want to know the stats for? Type 1 for first item, 2 for second, and so on.");
                                                        System.out.println("\tBag: " + Arrays.toString(player.inventory));
                                                        try {
                                                            int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                                            if(player.inventory[tempa] != null){
                                                                System.out.println(player.inventory[tempa].name + " alters your stats in this way:");
                                                                player.inventory[tempa].getStats();
                                                            }
                                                            else{
                                                                System.out.println("You do not have an item in that slot. Please try again.");
                                                            }
                                                        } catch (NumberFormatException e) {
                                                            System.out.println("Please try again and enter a number.");
                                                            break OUTER_11;
                                                        }
                                                        break OUTER_11;
                                                    case 2:
                                                        System.out.println("What item do you want to know the stats for? Type 1 for first item, 2 for second, and so on.");
                                                        System.out.println("\tEquipment: " + Arrays.toString(player.equipment));
                                                        try {
                                                            int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                                            if(player.equipment[tempa] != null){
                                                                System.out.println(player.equipment[tempa].name + " alters your stats in this way:");
                                                                player.equipment[tempa].getStats();
                                                            }
                                                            else{
                                                                System.out.println("You do not have an item in that slot. Please try again.");
                                                            }
                                                        } catch (NumberFormatException e) {
                                                            System.out.println("Please try again and enter a number.");
                                                            break OUTER_11;
                                                        }
                                                        break OUTER_11;
                                                    default:
                                                        System.out.println("Please try again and enter a valid answer.");
                                                        break;
                                                }
                                            }catch(NumberFormatException e){
                                                System.out.println("Please try again and enter a number.");
                                                break;
                                            }
                                            break;
                                         case "stats":
                                         case "s":
                                             player.showStats();
                                             break;
                                         case "combat help":
                                             player.combatHelp();
                                             break;
                                         default:
                                             System.out.println("enter a valid command (use \"combat help\" for a list of basic combat commands");
                                             break;
                                     }
                                 }//NORMAL COMBAT END
                             }
                             break;
                         case 1:
                             a3_enemy.getEnemy3();
                             int turnsAway = rand.nextInt(3);
                             System.out.println("\n\n----------------------------F I G H T !!!----------------------------");
                             System.out.println("combat commands can be pulled up at any time by typing \"combat help\"");
                             OUTER:
                             while (true) {
                                 if(turnsAway > 0)
                                        {
                                            System.out.println("\n\n\tThe enemy is currently " + turnsAway + " turn(s) away!\n\tNow's your chance for ranged attacks "
                                                    + "(type \"ranged attack\"), or just type \"attack\" or \"a\" to charge the enemy straight on!\n\t"
                                                    + "(all skills are considered ranged)\n\t(you can still identify enemy and/or manage items)");
                                        }
                                 System.out.println("\nWhat will you do " + player.name + "?");
                                 input = scan.nextLine();
                                 OUTER_12:
                                 switch (input) {
                                     case "ranged attack":
                                     case "ra": 
                                                if(turnsAway == 0 || turnsAway<0)
                                                {
                                                    System.out.println("\n\tThe enemy is within melee distance! You cannot use ranged attacks right now!");
                                                }
                                                else if(turnsAway > 0)
                                                {
                                                   try{
                                        for (Items equipment : player.equipment) 
                                        {
                                            if (equipment.typeCheckRanged()) 
                                            {
                                                int dmg = rand.nextInt((player.stats[1]) + (player.stats[2]));
                                                turnsAway--;
                                                System.out.println("You deal " + dmg + " to the enemy from afar!\n\tThe enemy is now " + turnsAway + " turn(s) away!");
                                                a1_enemy.enemyStats[1] -= dmg;
                                                break;
                                            } 
                                        }
                                                   }catch(NullPointerException e){System.out.println("\n\tYou don't have a ranged weapon in your equipment! You cannot do ranged attacks!");}
                                                }
                                                    break;
                                     case "attack":
                                     case "a":
                                         if (player.stats[2]>=a3_enemy.enemyStats[3]) {
                                             int dmgDealt = rand.nextInt(player.stats[1]);
                                             int EdmgDealt = rand.nextInt(a3_enemy.enemyStats[2]);
                                             System.out.println("The enemy has taken " + dmgDealt + " damage!");
                                             a3_enemy.enemyStats[1] -= dmgDealt;
                                             if (a3_enemy.enemyStats[1]<0) {
                                                 System.out.println("ENEMY DEFEATED!!!");
                                                 System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                                 a3_enemy.newEnemy3(player.getDiffNum());
                                                 player.stats[0] = MAX_HEALTH;
                                                 player.skill.recharge();
                                                 int gain = rand.nextInt(40) + 25;
                                                 player.gainExp(gain);
                                                 break OUTER;
                                             }
                                             System.out.println("The enemy does " + EdmgDealt + " damage back at you!");
                                             player.stats[0] -= EdmgDealt;
                                             if (player.stats[0]<0) {
                                                 System.out.println("YOU DIED");
                                                 System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                 area3_cleared = true;
                                                 area4_cleared = true;
                                                 running = false;
                                                 break OUTER;
                                             }
                                         }
                                         if (player.stats[2]<a3_enemy.enemyStats[3]) {
                                             int dmgDealt = rand.nextInt(player.stats[1]);
                                             int EdmgDealt = rand.nextInt(a3_enemy.enemyStats[2]);
                                             System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                             player.stats[0] -= EdmgDealt;
                                             if (player.stats[0]<0) {
                                                 System.out.println("YOU DIED");
                                                 System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                 area3_cleared = true;
                                                 area4_cleared = true;
                                                 running = false;
                                                 break OUTER;
                                             }
                                             System.out.println("The enemy has taken " + dmgDealt + " damage!");
                                             a3_enemy.enemyStats[1] -= dmgDealt;
                                             if (a3_enemy.enemyStats[1]<0) {
                                                 System.out.println("ENEMY DEFEATED!!!");
                                                 System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                                 a3_enemy.newEnemy3(player.getDiffNum());
                                                 player.stats[0] = MAX_HEALTH;
                                                 player.skill.recharge();
                                                 int gain = rand.nextInt(40) + 25;
                                                 player.gainExp(gain);
                                                 break OUTER;
                                             }
                                         }
                                         break;
                                     case "identify":
                                     case "i":
                                         if(player.stats[5]>=7)
                                         {
                                             System.out.println("\n\tyou take time to analyze your enemy\n\t...\n\tyou were able to identify their stats!");
                                             a3_enemy.showEnemyStats();
                                         }
                                         else
                                         {
                                             System.out.println("\n\tyou take time to analyze your enemy\n\t...\n\tyou fail to accurately tell their stats...");
                                         }
                                         if(turnsAway>0)
                                                     {
                                                         turnsAway--;
                                                         System.out.println("\n\n\tThe enemy is now " + turnsAway + " turn(s) away!");
                                                     }
                                                     else if(turnsAway == 0 || turnsAway<0)
                                                     {
                                                        int EdmgDealt = rand.nextInt(a3_enemy.enemyStats[2]);
                                                            System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                                            player.stats[0] -= EdmgDealt;
                                                            if (player.stats[0]<0) 
                                                            {
                                                                System.out.println("YOU DIED");
                                                                System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                                area1_cleared = true;
                                                                area2_cleared = true;
                                                                area3_cleared = true;
                                                                area4_cleared = true;
                                                                running = false;
                                                                break OUTER; 
                                                            }
                                                     }
                                         break;
                                     case "use skill":
                                     case "us":
                                         if(turnsAway > 0)
                                                {
                                                    System.out.println("\n\tEven though the enemy is " + turnsAway + " turn(s) away, you decide to face them right away!");
                                                }
                                                turnsAway = 0;
                                         if(player.skill.uses){
                                             if(player.skill.getName().equalsIgnoreCase("Blessing")){
                                                 if (player.stats[2]>=a3_enemy.enemyStats[3]) {
                                                     int EdmgDealt = rand.nextInt(a3_enemy.enemyStats[2]);
                                                     int HPgained = player.skill.use(player.stats);
                                                     System.out.println("You were healed for " + HPgained + " health points by your skill!");
                                                     player.stats[0] += HPgained;
                                                     System.out.println("The enemy does " + EdmgDealt + " damage back at you!");
                                                     player.stats[0] -= EdmgDealt;
                                                     if (player.stats[0]<0) {
                                                         System.out.println("YOU DIED");
                                                         System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                         area3_cleared = true;
                                                         area4_cleared = true;
                                                         running = false;
                                                         break OUTER;
                                                     }
                                                 }
                                                 if (player.stats[2]<a3_enemy.enemyStats[3]) {
                                                     int HPgained = player.skill.use(player.stats);
                                                     int EdmgDealt = rand.nextInt(a3_enemy.enemyStats[2]);
                                                     System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                                     player.stats[0] -= EdmgDealt;
                                                     if (player.stats[0]<0) {
                                                         System.out.println("YOU DIED");
                                                         System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                         area3_cleared = true;
                                                         area4_cleared = true;
                                                         running = false;
                                                         break OUTER;
                                                     }
                                                     System.out.println("You were healed for " + HPgained + " health points by your skill!");
                                                     player.stats[0] += HPgained;
                                                 }
                                             }
                                             else{
                                                 if (player.stats[2]>=a3_enemy.enemyStats[3]) {
                                                     int dmgDealt = player.skill.use(player.stats);
                                                     int EdmgDealt = rand.nextInt(a3_enemy.enemyStats[2]);
                                                     System.out.println("The enemy has taken " + dmgDealt + " damage becuase of your skill!");
                                                     a3_enemy.enemyStats[1] -= dmgDealt;
                                                     if (a3_enemy.enemyStats[1]<0) {
                                                         System.out.println("ENEMY DEFEATED!!!");
                                                         System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                                         a3_enemy.newEnemy(player.getDiffNum());
                                                         player.stats[0] = MAX_HEALTH;
                                                         player.skill.recharge();
                                                         int gain = rand.nextInt(40) + 25;
                                                         player.gainExp(gain);
                                                         break OUTER;
                                                     }
                                                     System.out.println("The enemy does " + EdmgDealt + " damage back at you!");
                                                     player.stats[0] -= EdmgDealt;
                                                     if (player.stats[0]<0) {
                                                         System.out.println("YOU DIED");
                                                         System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                         area3_cleared = true;
                                                         area4_cleared = true;
                                                         running = false;
                                                         break OUTER;
                                                     }
                                                 }
                                                 if (player.stats[2]<a3_enemy.enemyStats[3]) {
                                                     int dmgDealt = player.skill.use(player.stats);
                                                     int EdmgDealt = rand.nextInt(a3_enemy.enemyStats[2]);
                                                     System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                                     player.stats[0] -= EdmgDealt;
                                                     if (player.stats[0]<0) {
                                                         System.out.println("YOU DIED");
                                                         System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                         area3_cleared = true;
                                                         area4_cleared = true;
                                                         running = false;
                                                         break OUTER;
                                                     }
                                                     System.out.println("The enemy has taken " + dmgDealt + " damage because of your skill!");
                                                     a3_enemy.enemyStats[1] -= dmgDealt;
                                                     if (a3_enemy.enemyStats[1]<0) {
                                                         System.out.println("ENEMY DEFEATED!!!");
                                                         System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                                         a3_enemy.newEnemy(player.getDiffNum());
                                                         player.stats[0] = MAX_HEALTH;
                                                         player.skill.recharge();
                                                         int gain = rand.nextInt(40) + 25;
                                                         player.gainExp(gain);
                                                         break OUTER;
                                                     }
                                                 }
                                             }
                                         }
                                         else
                                             System.out.println("You cannot use that skill again this battle!");
                                         break;
                                     case "skill info":
                                     case "si":
                                         System.out.println("\t"+player.skill.getSkillInfo());
                                         break;
                                     case "equipment":
                                     case"se":
                                         System.out.println(Arrays.toString(player.equipment));
                                         break;
                                     case "bag":
                                     case "b":
                                         System.out.println(Arrays.toString(player.inventory));
                                         break;
                                     case "use":
                                     case "u":
                                         System.out.println("What item did you want to use from your bag? Type 1 for first item, 2 for second, and so on.");
                                         System.out.println("\t" + Arrays.toString(player.inventory));
                                         try{
                                             int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                             if(tempa < player.inventory.length){
                                                if(player.inventory[tempa] != null){
                                                    if(player.inventory[tempa].typeCheckConsumable()){
                                                        System.out.println("You use " + player.inventory[tempa].name + ".");
                                                        player.stats = player.inventory[tempa].ADDstats(player.stats);
                                                        player.inventory = player.inventory[tempa].dropInventory(player.inventory);
                                                    }
                                                    else
                                                        System.out.println("That is not a usable item.");
                                                }
                                                else
                                                 System.out.println("You do not have an item in that slot.");
                                             }
                                             else
                                                 System.out.println("You do not have an item in that slot.");
                                         }
                                         catch(NumberFormatException e){
                                             System.out.println("Please enter a number.");
                                             break;
                                         }
                                         if(turnsAway>0)
                                                     {
                                                         turnsAway--;
                                                         System.out.println("\n\n\tThe enemy is now " + turnsAway + " turn(s) away!");
                                                     }
                                                     else if(turnsAway == 0 || turnsAway<0)
                                                     {
                                                        int EdmgDealt = rand.nextInt(a3_enemy.enemyStats[2]);
                                                            System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                                            player.stats[0] -= EdmgDealt;
                                                            if (player.stats[0]<0) 
                                                            {
                                                                System.out.println("YOU DIED");
                                                                System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                                area1_cleared = true;
                                                                area2_cleared = true;
                                                                area3_cleared = true;
                                                                area4_cleared = true;
                                                                running = false;
                                                                break OUTER; 
                                                            }
                                                     }
                                         break;
                                    case "item stats":
                                    case "is":
                                        System.out.println("Where is this item located?\n\t1. Bag\n\t2. Equipment");
                                        try {
                                            int temp = Integer.parseInt(scan.nextLine());
                                            switch (temp) {
                                                case 1:
                                                    System.out.println("What item do you want to know the stats for? Type 1 for first item, 2 for second, and so on.");
                                                    System.out.println("\tBag: " + Arrays.toString(player.inventory));
                                                    try {
                                                        int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                                        if(player.inventory[tempa] != null){
                                                            System.out.println(player.inventory[tempa].name + " alters your stats in this way:");
                                                            player.inventory[tempa].getStats();
                                                        }
                                                        else{
                                                            System.out.println("You do not have an item in that slot. Please try again.");
                                                        }
                                                    } catch (NumberFormatException e) {
                                                        System.out.println("Please try again and enter a number.");
                                                        break OUTER_12;
                                                    }
                                                    break OUTER_12;
                                                case 2:
                                                    System.out.println("What item do you want to know the stats for? Type 1 for first item, 2 for second, and so on.");
                                                    System.out.println("\tEquipment: " + Arrays.toString(player.equipment));
                                                    try {
                                                        int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                                        if(player.equipment[tempa] != null){
                                                            System.out.println(player.equipment[tempa].name + " alters your stats in this way:");
                                                            player.equipment[tempa].getStats();
                                                        }
                                                        else{
                                                            System.out.println("You do not have an item in that slot. Please try again.");
                                                        }
                                                    } catch (NumberFormatException e) {
                                                        System.out.println("Please try again and enter a number.");
                                                        break OUTER_12;
                                                    }
                                                    break OUTER_12;
                                                default:
                                                    System.out.println("Please try again and enter a valid answer.");
                                                    break;
                                            }
                                        }catch(NumberFormatException e){
                                            System.out.println("Please try again and enter a number.");
                                            break;
                                        }
                                        break;
                                     case "stats":
                                     case "s":
                                         player.showStats();
                                         break;
                                     case "combat help":
                                         player.combatHelp();
                                         break;
                                     case "help":
                                         player.help();
                                         break;
                                     default:
                                         System.out.println("enter a valid command (use \"combat help\" for a list of basic combat commands");
                                         break;
                                 }
                             }//NORMAL COMBAT END
                             break;
                         case 2:
                             System.out.println("You found a chest! It contained: " + area1_chest.open());
                             OUTER:
                             while (true) {
                                 System.out.println("\n\tWould you like to keep the item?");
                                 System.out.println("\t\t 1. Yes");
                                 System.out.println("\t\t 2. No");
                                 input = scan.nextLine();
                                 switch (input) {
                                     case "1":
                                         System.out.println("You yank the item from the chest!\nYou gained: " + area1_chest.open());
                                         player.inventory = area1_chest.open().ADDinventory(player.inventory);
                                         System.out.println(Arrays.toString(player.inventory));
                                         area1_chest.newItem();
                                         break OUTER;
                                     case "2":
                                         System.out.println("You decided to leave the item behind.");
                                         area1_chest.newItem();
                                         break OUTER;
                                     default:
                                         System.out.println("Please enter a valid option.");
                                         break;
                                 }
                             } //CHEST END
                             break;
                         case 3:
                             int mod = 1;
                                    switch (player.getDiffNum()) {
                                        case 1:
                                            {
                                                mod = 1;
                                                break;
                                            }
                                        case 2:
                                            {
                                                mod = 2;
                                                break;
                                            }
                                        case 3:
                                            {
                                                mod = 3;
                                                break;
                                            }
                                        case 4:
                                            {
                                                mod = 4;
                                                break;
                                            }
                                        default:
                                            break;
                                    }
                             Enemy bigBoi = new Enemy(100 * mod, 50 * mod, 15 * mod, 15, 15, 15, 15, 15);
                             turnsAway = 2;
                             HOD_GAME boss3 = new HOD_GAME (3);
                             System.out.println("\n\n----------------------------I T ' S   B O S S   T I M E   B O i S----------------------------");
                             System.out.println("combat commands can be pulled up at any time by typing \"combat help\"");
                             OUTER:
                             while (true) {
                                 if(turnsAway > 0)
                                        {
                                            System.out.println("\n\n\tThe enemy is currently " + turnsAway + " turn(s) away!\n\tNow's your chance for ranged attacks "
                                                    + "(type \"ranged attack\"), or just type \"attack\" or \"a\" to charge the enemy straight on!\n\t"
                                                    + "(all skills are considered ranged)\n\t(you can still identify enemy and/or manage items)");
                                        }
                                 System.out.println("\nWhat will you do " + player.name + "?");
                                 input = scan.nextLine();
                                 OUTER_13:
                                 switch (input) {
                                     case "ranged attack":
                                     case "ra": 
                                                if(turnsAway == 0 || turnsAway<0)
                                                {
                                                    System.out.println("\n\tThe enemy is within melee distance! You cannot use ranged attacks right now!");
                                                }
                                                else if(turnsAway > 0)
                                                {
                                                   try{
                                        for (Items equipment : player.equipment) 
                                        {
                                            if (equipment.typeCheckRanged())  
                                            {
                                                int dmg = rand.nextInt((player.stats[1]) + (player.stats[2]));
                                                turnsAway--;
                                                System.out.println("You deal " + dmg + " to the enemy from afar!\n\tThe enemy is now " + turnsAway + " turn(s) away!");
                                                a1_enemy.enemyStats[1] -= dmg;
                                                break;
                                            } 
                                        }
                                                   }catch(NullPointerException e){System.out.println("\n\tYou don't have a ranged weapon in your equipment! You cannot do ranged attacks!");}
                                                }
                                                    break;
                                     case "attack":
                                        case "a":
                                            if (player.stats[2]>=bigBoi.enemyStats[3]) {
                                                int dmgDealt = rand.nextInt(player.stats[1]);
                                                int EdmgDealt;
                                                System.out.println("The enemy has taken " + dmgDealt + " damage!");
                                                bigBoi.enemyStats[1] -= dmgDealt;
                                                if (bigBoi.enemyStats[1]<0) {
                                                    System.out.println("ENEMY DEFEATED!!!");
                                                    System.out.println("\n\n----------------------------BOSS HAS BEEN Y E E T E D----------------------------\n\n");
                                                    bigBoi.enemyStats[1] = 100;
                                                    player.stats[0] = MAX_HEALTH;
                                                    player.skill.recharge();
                                                    int gain = player.maxExp;
                                                    player.gainExp(gain);
                                                    break OUTER;
                                                }
                                                EdmgDealt = bigBoi.bossThreeSkills(rand.nextInt(2),player.stats[2] , player.stats[1], player.stats[3], player.stats[6], bigBoi.enemyStats[2]);
                                                player.stats[0] -= EdmgDealt;
                                                if (player.stats[0]<0) {
                                                    System.out.println("YOU DIED");
                                                    System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                    area1_cleared = true;
                                                    area2_cleared = true;
                                                    area3_cleared = true;
                                                    area4_cleared = true;
                                                    running = false;
                                                    break OUTER;
                                                }
                                            }
                                            if (player.stats[2]<bigBoi.enemyStats[3]) {
                                                int dmgDealt = rand.nextInt(player.stats[1]);
                                                int EdmgDealt = 0;
                                                EdmgDealt = bigBoi.bossThreeSkills(rand.nextInt(2),player.stats[2] , player.stats[1], player.stats[3], player.stats[6], bigBoi.enemyStats[2]);
                                                player.stats[0] -= EdmgDealt;
                                                if (player.stats[0]<0) {
                                                    System.out.println("YOU DIED");
                                                    System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                    area1_cleared = true;
                                                    area2_cleared = true;
                                                    area3_cleared = true;
                                                    area4_cleared = true;
                                                    running = false;
                                                    break OUTER;
                                                }
                                                System.out.println("\n\tThe enemy has taken " + dmgDealt + " damage!");
                                                bigBoi.enemyStats[1] -= dmgDealt;
                                                if (bigBoi.enemyStats[1]<0) {
                                                    System.out.println("ENEMY DEFEATED!!!");
                                                    System.out.println("\n\n----------------------------BOSS HAS BEEN Y E E T E D----------------------------\n\n");
                                                    bigBoi.enemyStats[1] = 100;
                                                    player.stats[0] = MAX_HEALTH;
                                                    player.skill.recharge();
                                                    int gain = player.maxExp;
                                                    player.gainExp(gain);
                                                    break OUTER;
                                                }
                                            }
                                            break;
                                     case "identify":
                                     case "i":
                                         if(player.stats[5]>=7)
                                         {
                                             System.out.println("\n\tyou take time to analyze your enemy\n\t...\n\tyou were able to identify their stats!");
                                             bigBoi.showEnemyStats();
                                         }
                                         else
                                         {
                                             System.out.println("\n\tyou take time to analyze your enemy\n\t...\n\tyou fail to accurately tell their stats...");
                                         }
                                         if(turnsAway>0)
                                                     {
                                                         turnsAway--;
                                                         System.out.println("\n\n\tThe enemy is now " + turnsAway + " turn(s) away!");
                                                     }
                                                     else if(turnsAway == 0 || turnsAway<0)
                                                     {
                                                        int EdmgDealt = 0;
                                                        EdmgDealt = bigBoi.bossThreeSkills(rand.nextInt(2),player.stats[2] , player.stats[1], player.stats[3], player.stats[6], bigBoi.enemyStats[2]);
                                                            player.stats[0] -= EdmgDealt;
                                                            if (player.stats[0]<0) 
                                                            {
                                                                System.out.println("YOU DIED");
                                                                System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                                area1_cleared = true;
                                                                area2_cleared = true;
                                                                area3_cleared = true;
                                                                area4_cleared = true;
                                                                running = false;
                                                                break OUTER; 
                                                            }
                                                     }
                                         break;
                                     case "use skill":
                                     case "us":
                                         if(turnsAway > 0)
                                                {
                                                    System.out.println("\n\tEven though the enemy is " + turnsAway + " turn(s) away, you decide to face them right away!");
                                                }
                                                turnsAway = 0;
                                         if(player.skill.uses){
                                             if(player.skill.getName().equalsIgnoreCase("Blessing")){
                                                 if (player.stats[2]>=bigBoi.enemyStats[3]) {
                                                     int HPgained = player.skill.use(player.stats);
                                                     System.out.println("You were healed for " + HPgained + " health points by your skill!");
                                                     player.stats[0] += HPgained;
                                                     int EdmgDealt = bigBoi.bossThreeSkills(rand.nextInt(2),player.stats[2] , player.stats[1], player.stats[3], player.stats[6], bigBoi.enemyStats[2]);
                                                     player.stats[0] -= EdmgDealt;
                                                     if (player.stats[0]<0) {
                                                         System.out.println("YOU DIED");
                                                         System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                         area3_cleared = true;
                                                         area4_cleared = true;
                                                         running = false;
                                                         break OUTER;
                                                     }
                                                 }
                                                 if (player.stats[2]<bigBoi.enemyStats[3]) {
                                                     int HPgained = player.skill.use(player.stats);
                                                     int EdmgDealt = 0;
                                                     EdmgDealt = bigBoi.bossThreeSkills(rand.nextInt(2),player.stats[2] , player.stats[1], player.stats[3], player.stats[6], bigBoi.enemyStats[2]);
                                                     player.stats[0] -= EdmgDealt;
                                                     if (player.stats[0]<0) {
                                                         System.out.println("YOU DIED");
                                                         System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                         area3_cleared = true;
                                                         area4_cleared = true;
                                                         running = false;
                                                         break OUTER;
                                                     }
                                                     System.out.println("You were healed for " + HPgained + " health points by your skill!");
                                                     player.stats[0] += HPgained;
                                                 }
                                             }
                                             else{
                                                 if (player.stats[2]>=bigBoi.enemyStats[3]) {
                                                     int dmgDealt = player.skill.use(player.stats);
                                                     System.out.println("The enemy has taken " + dmgDealt + " damage becuase of your skill!");
                                                     bigBoi.enemyStats[1] -= dmgDealt;
                                                     if (bigBoi.enemyStats[1]<0) {
                                                         System.out.println("ENEMY DEFEATED!!!");
                                                         System.out.println("\n\n----------------------------BOSS HAS BEEN Y E E T E D----------------------------\n\n");
                                                         bigBoi.newEnemy(player.getDiffNum());
                                                         player.stats[0] = MAX_HEALTH;
                                                         player.skill.recharge();
                                                         int gain = player.maxExp;
                                                         player.gainExp(gain);
                                                         break OUTER;
                                                     }
                                                     int EdmgDealt = 0;
                                                     EdmgDealt = bigBoi.bossThreeSkills(rand.nextInt(2),player.stats[2] , player.stats[1], player.stats[3], player.stats[6], bigBoi.enemyStats[2]);
                                                     player.stats[0] -= EdmgDealt;
                                                     if (player.stats[0]<0) {
                                                         System.out.println("YOU DIED");
                                                         System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                         area3_cleared = true;
                                                         area4_cleared = true;
                                                         running = false;
                                                         break OUTER;
                                                     }
                                                 }
                                                 if (player.stats[2]<bigBoi.enemyStats[3]) {
                                                     int dmgDealt = player.skill.use(player.stats);
                                                     int EdmgDealt = 0;
                                                     EdmgDealt = bigBoi.bossThreeSkills(rand.nextInt(2),player.stats[2] , player.stats[1], player.stats[3], player.stats[6], bigBoi.enemyStats[2]);
                                                     player.stats[0] -= EdmgDealt;
                                                     if (player.stats[0]<0) {
                                                         System.out.println("YOU DIED");
                                                         System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                         area3_cleared = true;
                                                         area4_cleared = true;
                                                         running = false;
                                                         break OUTER;
                                                     }
                                                     System.out.println("The enemy has taken " + dmgDealt + " damage because of your skill!");
                                                     bigBoi.enemyStats[1] -= dmgDealt;
                                                     if (bigBoi.enemyStats[1]<0) {
                                                         System.out.println("ENEMY DEFEATED!!!");
                                                         System.out.println("\n\n----------------------------BOSS HAS BEEN Y E E T E D----------------------------\n\n");
                                                         bigBoi.newEnemy(player.getDiffNum());
                                                         player.stats[0] = MAX_HEALTH;
                                                         player.skill.recharge();
                                                         int gain = player.maxExp;
                                                         player.gainExp(gain);
                                                         break OUTER;
                                                     }
                                                 }
                                             }
                                         }
                                         else
                                             System.out.println("You cannot use that skill again this battle!");
                                         break;
                                     case "skill info":
                                     case "si":
                                         System.out.println("\t"+player.skill.getSkillInfo());
                                         break;
                                     case "equipment":
                                     case"se":
                                         System.out.println(Arrays.toString(player.equipment));
                                         break;
                                     case "bag":
                                     case "b":
                                         System.out.println(Arrays.toString(player.inventory));
                                         break;
                                     case "use":
                                     case "u":
                                         System.out.println("What item did you want to use from your bag? Type 1 for first item, 2 for second, and so on.");
                                         System.out.println("\t" + Arrays.toString(player.inventory));
                                         try{
                                             int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                             if(tempa < player.inventory.length){
                                                if(player.inventory[tempa] != null){
                                                    if(player.inventory[tempa].typeCheckConsumable()){
                                                        System.out.println("You use " + player.inventory[tempa].name + ".");
                                                        player.stats = player.inventory[tempa].ADDstats(player.stats);
                                                        player.inventory = player.inventory[tempa].dropInventory(player.inventory);
                                                    }
                                                    else
                                                        System.out.println("That is not a usable item.");
                                                }
                                                else
                                                 System.out.println("You do not have an item in that slot.");
                                             }
                                             else
                                                 System.out.println("You do not have an item in that slot.");
                                         }
                                         catch(NumberFormatException e){
                                             System.out.println("Please enter a number.");
                                             break;
                                         }
                                         if(turnsAway>0)
                                                     {
                                                         turnsAway--;
                                                         System.out.println("\n\n\tThe enemy is now " + turnsAway + " turn(s) away!");
                                                     }
                                                     else if(turnsAway == 0 || turnsAway<0)
                                                     {
                                                        int EdmgDealt = rand.nextInt(bigBoi.enemyStats[2]);
                                                            System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                                            player.stats[0] -= EdmgDealt;
                                                            if (player.stats[0]<0) 
                                                            {
                                                                System.out.println("YOU DIED");
                                                                System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                                area1_cleared = true;
                                                                area2_cleared = true;
                                                                area3_cleared = true;
                                                                area4_cleared = true;
                                                                running = false;
                                                                break OUTER; 
                                                            }
                                                     }
                                         break;
                                    case "item stats":
                                    case "is":
                                        System.out.println("Where is this item located?\n\t1. Bag\n\t2. Equipment");
                                        try {
                                            int temp = Integer.parseInt(scan.nextLine());
                                            switch (temp) {
                                                case 1:
                                                    System.out.println("What item do you want to know the stats for? Type 1 for first item, 2 for second, and so on.");
                                                    System.out.println("\tBag: " + Arrays.toString(player.inventory));
                                                    try {
                                                        int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                                        if(player.inventory[tempa] != null){
                                                            System.out.println(player.inventory[tempa].name + " alters your stats in this way:");
                                                            player.inventory[tempa].getStats();
                                                        }
                                                        else{
                                                            System.out.println("You do not have an item in that slot. Please try again.");
                                                        }
                                                    } catch (NumberFormatException e) {
                                                        System.out.println("Please try again and enter a number.");
                                                        break OUTER_13;
                                                    }
                                                    break OUTER_13;
                                                case 2:
                                                    System.out.println("What item do you want to know the stats for? Type 1 for first item, 2 for second, and so on.");
                                                    System.out.println("\tEquipment: " + Arrays.toString(player.equipment));
                                                    try {
                                                        int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                                        if(player.equipment[tempa] != null){
                                                            System.out.println(player.equipment[tempa].name + " alters your stats in this way:");
                                                            player.equipment[tempa].getStats();
                                                        }
                                                        else{
                                                            System.out.println("You do not have an item in that slot. Please try again.");
                                                        }
                                                    } catch (NumberFormatException e) {
                                                        System.out.println("Please try again and enter a number.");
                                                        break OUTER_13;
                                                    }
                                                    break OUTER_13;
                                                default:
                                                    System.out.println("Please try again and enter a valid answer.");
                                                    break;
                                            }
                                        }catch(NumberFormatException e){
                                            System.out.println("Please try again and enter a number.");
                                            break;
                                        }
                                        break;
                                     case "stats":
                                     case "s":
                                         player.showStats();
                                         break;
                                     case "combat help":
                                         player.combatHelp();
                                         break;
                                     case "help":
                                         player.help();
                                         break;
                                     default:
                                         System.out.println("enter a valid command (use \"combat help\" for a list of basic combat commands");
                                         break;
                                 }
                             } // BOSS FIGHT END
                             break;
                         case 4:
                             System.out.println("You have found the exit to the area! But alas... you only get deeper into this hell hole instead of having freedom");
                             area3_cleared = true;
                             break;
                         default:
                             break;
                     } // AREA GET DATA END
                     break;
                 case "equipment":
                 case"se":
                     System.out.println(Arrays.toString(player.equipment));
                     break;
                 case "bag":
                 case "b":
                     System.out.println(Arrays.toString(player.inventory));
                     break;
                 case "drop":
                 case "d":
                     System.out.println("From where would you like to drop something?\n\t1. Bag\n\t2. Equipment");
                     try {
                         int temp = Integer.parseInt(scan.nextLine());
                         switch (temp) {
                             case 1:
                                 System.out.println("Which item did you want to drop from your bag? Type 1 for first item, 2 for second, and so on.");
                                 System.out.println("\t" + Arrays.toString(player.inventory));
                                 try {
                                     int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                     if(tempa < player.inventory.length){
                                        if (player.inventory[tempa] != null) {
                                            System.out.println("You dropped your " + player.inventory[tempa].name + ".");
                                            player.inventory = player.inventory[tempa].dropInventory(player.inventory);
                                            break OUTER_14;
                                        }
                                        else
                                            System.out.println("You do not have an item in that slot.");
                                     }
                                     else {
                                         System.out.println("You do not have an item in that slot. Please try again.");
                                     }
                                 } catch (NumberFormatException e) {
                                     System.out.println("Please try again and enter a number.");
                                     break OUTER_14;
                                 }
                                 break OUTER_14;
                             case 2:
                                 System.out.println("Which item did you want to drop from your equipment? Type 1 for first item, 2 for second, and so on.");
                                 System.out.println("\t" + Arrays.toString(player.equipment));
                                 try {
                                     int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                     if(tempa < player.equipment.length){
                                        if (player.equipment[tempa] != null) {
                                            System.out.println("You dropped your " + player.equipment[tempa].name + ".");
                                            player.stats = player.equipment[tempa].SUBstats(player.stats);
                                            player.equipment = player.equipment[tempa].dropEquipment(player.equipment);
                                            break OUTER_14;
                                        }
                                        else
                                            System.out.println("You do not have an item in that slot.");
                                     }
                                     else {
                                         System.out.println("You do not have an item in that slot. Please try again.");
                                     }
                                 } catch (NumberFormatException e) {
                                     System.out.println("Please try again and enter a number.");
                                     break OUTER_14;
                                 }
                                 break;
                             default:
                                 System.out.println("Please try again and enter a valid answer.");
                                 break;
                         }
                     }catch(NumberFormatException e){
                         System.out.println("Please try again and enter a number.");
                         break;
                     }
                     break;
                 case "equip":
                 case "e":
                    if(!dummy.isFull(player.equipment)){
                        System.out.println("What item did you want to equip from your bag? Type 1 for first item, 2 for second, and so on.");
                        System.out.println("\t" + Arrays.toString(player.inventory));
                        try{
                            int tempa = Integer.parseInt(scan.nextLine()) - 1;
                            if(tempa < player.inventory.length){
                                if(player.inventory[tempa] != null){
                                    System.out.println("You equipped your " + player.inventory[tempa].name + ".");
                                    player.stats = player.inventory[tempa].ADDstats(player.stats);
                                    Items[][] temp = player.inventory[tempa].equip(player.inventory, player.equipment);
                                    player.inventory = temp[0];
                                    player.equipment = temp[1];
                                    break;
                                }
                                else
                                    System.out.println("You do not have an item in that slot.");
                            }
                            else
                                System.out.println("You do not have an equipped item in that slot.");
                        }
                        catch(NumberFormatException e){
                            System.out.println("Please enter a number.");
                            break;
                        }
                        break;
                    }
                    else
                        System.out.println("Your equipment is full! You can't equip an item.");
                    break;
                case "unequip":
                case "ue":
                    if(!dummy.isFull(player.inventory)){
                        System.out.println("What item did you want to unequip from your equipment? Type 1 for first item, 2 for second, and so on.");
                        System.out.println("\t" + Arrays.toString(player.equipment));
                        try{
                            int tempa = Integer.parseInt(scan.nextLine()) - 1;
                            if(tempa < player.equipment.length){
                                if(player.equipment[tempa] != null){
                                    System.out.println("You unequipped your " + player.equipment[tempa].name + ".");
                                    player.stats = player.equipment[tempa].SUBstats(player.stats);
                                    Items[][] temp = player.equipment[tempa].unequip(player.inventory, player.equipment);
                                    player.inventory = temp[0];
                                    player.equipment = temp[1];
                                    break;
                                }
                                else
                                    System.out.println("You do not have an item in that slot.");
                            }
                            else
                                System.out.println("You do not have an equipped item in that slot.");
                        }
                        catch(NumberFormatException e){
                            System.out.println("Please enter a number.");
                            break;
                        }
                        break;
                    }
                  else
                    System.out.println("Your bag is full! You can't unequip an item.");
                  break;
                 case "use":
                 case "u":
                     System.out.println("What item did you want to use from your bag? Type 1 for first item, 2 for second, and so on.");
                     System.out.println("\t" + Arrays.toString(player.inventory));
                     try{
                         int tempa = Integer.parseInt(scan.nextLine()) - 1;
                         if(tempa < player.inventory.length){
                            if(player.inventory[tempa] != null){
                                if(player.inventory[tempa].typeCheckConsumable()){
                                    System.out.println("You use " + player.inventory[tempa].name + ".");
                                    player.stats = player.inventory[tempa].ADDstats(player.stats);
                                    player.inventory = player.inventory[tempa].dropInventory(player.inventory);
                                }
                                else
                                    System.out.println("That is not a usable item.");
                            }
                            else
                                System.out.println("You do not have an item in that slot.");
                         }
                         else
                             System.out.println("You do not have an item in that slot.");
                     }
                     catch(NumberFormatException e){
                         System.out.println("Please enter a number.");
                         break;
                     }
                     break;
                 case "item stats":
                 case "is":
                     System.out.println("Where is this item located?\n\t1. Bag\n\t2. Equipment");
                     try {
                         int temp = Integer.parseInt(scan.nextLine());
                         switch (temp) {
                             case 1:
                                 System.out.println("What item do you want to know the stats for? Type 1 for first item, 2 for second, and so on.");
                                 System.out.println("\tBag: " + Arrays.toString(player.inventory));
                                 try {
                                     int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                     if(tempa < player.inventory.length){
                                        if(player.inventory[tempa] != null){
                                            System.out.println(player.inventory[tempa].name + " alters your stats in this way:");
                                            player.inventory[tempa].getStats();
                                        }
                                        else
                                            System.out.println("You do not have an item in that slot.");
                                     }
                                     else{
                                         System.out.println("You do not have an item in that slot. Please try again.");
                                     }
                                 } catch (NumberFormatException e) {
                                     System.out.println("Please try again and enter a number.");
                                     break OUTER_16;
                                 }
                                 break OUTER_16;
                             case 2:
                                 System.out.println("What item do you want to know the stats for? Type 1 for first item, 2 for second, and so on.");
                                 System.out.println("\tEquipment: " + Arrays.toString(player.equipment));
                                 try {
                                     int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                     if(tempa < player.equipment.length){
                                        if(player.equipment[tempa] != null){
                                            System.out.println(player.equipment[tempa].name + " alters your stats in this way:");
                                            player.equipment[tempa].getStats();
                                        }
                                        else
                                            System.out.println("You do not have an item in that slot.");
                                     }
                                     else{
                                         System.out.println("You do not have an item in that slot. Please try again.");
                                     }
                                 } catch (NumberFormatException e) {
                                     System.out.println("Please try again and enter a number.");
                                     break OUTER_16;
                                 }
                                 break OUTER_16;
                             default:
                                 System.out.println("Please try again and enter a valid answer.");
                                 break;
                         }
                     }catch(NumberFormatException e){
                         System.out.println("Please try again and enter a number.");
                         break;
                     }
                     break;
                 case "stats":
                 case "s":
                     player.showStats();
                     break;
                 case "skill info":
                 case "si":
                     System.out.println("\t"+player.skill.getSkillInfo());
                     break;
                 default:
                     System.out.println("enter a valid command (use \"help\" for a list of basic commands)");
                     break;
             }
          }//WHILE AREA_3 CLEARED END
          ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
          /////////////////////////////AREA 4 CREATION///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
               int area4_L;
               Area area4 = new Area(0, null, null);
               area4_L = rand.nextInt(3) + 5;
               //System.out.println(area4_L);
               area4.ensureExit();
               area4.ensureBoss();
               for(int i = 0; i<area4_L-1; i++)
               {
                   area4.addNode(rand.nextInt(3));
                   //area4.addNode(0);
               }
               //Area.listLength(area4);
               Area area4_pp = area4;
               Chest area4_chest = new Chest();
               Enemy a4_enemy = new Enemy(1, 1, 1, 1, 1, 1, 1, 1);
               a4_enemy.newEnemy4(player.getDiffNum());
          /////////////////////////////AREA 4 CREATION////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          if(area4_cleared == false)
          {
              System.out.println("\n\n\tYou've never seen anything like this place before. Massive floating landscapes amongst what seems like a never ending horizon"
                     + "\n\tVery dangerous looking enemies appear to roam these parts, each establishing its territory on the more bigger floating landscapes"
                     + "\n\tYou notice at the end of this floating trail there is a ginormous... very rediculos looking figure that appears to be... "
                     + "\n\twaiting for you(?) you'll just have to find out! You've made it this far (surprisingly), no giving up now!");
              HOD_GAME area4_pic = new HOD_GAME (8);
          }
          while(area4_cleared == false)
          {
             System.out.println("\n\t\tWhat would you like to do?");
                input = scan.nextLine();
              OUTER_18:
             OUTER_19:
             switch (input) {
                 case "help":
                     player.help();
                     break;
                 case "forward":
                 case "f":
                     area4_pp = area4_pp.getForeLink();
                     //System.out.println(area4_pp.getData());
                     switch (area4_pp.getData()) {
                         case 0:
                             int area4_encounter;
                             area4_encounter = area4.area_4_Encounter(rand.nextInt(2), player.stats[1], player.stats[2], player.stats[3]);
                             player.stats[0] = player.stats[0] - area4_encounter;
                             if(player.stats[0]<=0)
                             {
                                 System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                 area4_cleared = true;
                                 running = false;
                                 break;
                             }
                             break;
                         case 1:
                             a4_enemy.getEnemy4();
                             int turnsAway = rand.nextInt(3);
                             System.out.println("\n\n----------------------------F I G H T !!!----------------------------");
                             System.out.println("combat commands can be pulled up at any time by typing \"combat help\"");
                             OUTER:
                             while (true) {
                                 if(turnsAway > 0)
                                        {
                                            System.out.println("\n\n\tThe enemy is currently " + turnsAway + " turn(s) away!\n\tNow's your chance for ranged attacks "
                                                    + "(type \"ranged attack\"), or just type \"attack\" or \"a\" to charge the enemy straight on!\n\t"
                                                    + "(all skills are considered ranged)\n\t(you can still identify enemy and/or manage items)");
                                        }
                                 System.out.println("\nWhat will you do " + player.name + "?");
                                 input = scan.nextLine();
                                 OUTER_15:
                                 switch (input) {
                                     case "ranged attack":
                                     case "ra": 
                                                if(turnsAway == 0 || turnsAway<0)
                                                {
                                                    System.out.println("\n\tThe enemy is within melee distance! You cannot use ranged attacks right now!");
                                                }
                                                else if(turnsAway > 0)
                                                {
                                                   try{
                                        for (Items equipment : player.equipment) 
                                        {
                                            if (equipment.typeCheckRanged()) 
                                            {
                                                int dmg = rand.nextInt((player.stats[1]) + (player.stats[2]));
                                                turnsAway--;
                                                System.out.println("You deal " + dmg + " to the enemy from afar!\n\tThe enemy is now " + turnsAway + " turn(s) away!");
                                                a1_enemy.enemyStats[1] -= dmg;
                                                break;
                                            } 
                                        }
                                                   }catch(NullPointerException e){System.out.println("\n\tYou don't have a ranged weapon in your equipment! You cannot do ranged attacks!");}
                                                }
                                                    break;
                                     case "attack":
                                     case "a":
                                         if (player.stats[2]>=a4_enemy.enemyStats[3]) {
                                             int dmgDealt = rand.nextInt(player.stats[1]);
                                             int EdmgDealt = rand.nextInt(a4_enemy.enemyStats[2]);
                                             System.out.println("The enemy has taken " + dmgDealt + " damage!");
                                             a4_enemy.enemyStats[1] -= dmgDealt;
                                             if (a4_enemy.enemyStats[1]<0) {
                                                 System.out.println("ENEMY DEFEATED!!!");
                                                 System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                                 a4_enemy.newEnemy4(player.getDiffNum());
                                                 player.stats[0] = MAX_HEALTH;
                                                 player.skill.recharge();
                                                 int gain = rand.nextInt(40) + 35;
                                                 player.gainExp(gain);
                                                 break OUTER;
                                             }
                                             System.out.println("The enemy does " + EdmgDealt + " damage back at you!");
                                             player.stats[0] -= EdmgDealt;
                                             if (player.stats[0]<0) {
                                                 System.out.println("YOU DIED");
                                                 System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                 area4_cleared = true;
                                                 running = false;
                                                 break OUTER;
                                             }
                                         }
                                         if (player.stats[2]<a4_enemy.enemyStats[3]) {
                                             int dmgDealt = rand.nextInt(player.stats[1]);
                                             int EdmgDealt = rand.nextInt(a4_enemy.enemyStats[2]);
                                             System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                             player.stats[0] -= EdmgDealt;
                                             if (player.stats[0]<0) {
                                                 System.out.println("YOU DIED");
                                                 System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                 area4_cleared = true;
                                                 running = false;
                                                 break OUTER;
                                             }
                                             System.out.println("The enemy has taken " + dmgDealt + " damage!");
                                             a4_enemy.enemyStats[1] -= dmgDealt;
                                             if (a4_enemy.enemyStats[1]<0) {
                                                 System.out.println("ENEMY DEFEATED!!!");
                                                 System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                                 a4_enemy.newEnemy4(player.getDiffNum());
                                                 player.stats[0] = MAX_HEALTH;
                                                 player.skill.recharge();
                                                 int gain = rand.nextInt(40) + 35;
                                                 player.gainExp(gain);
                                                 break OUTER;
                                             }
                                         }
                                         break;
                                     case "identify":
                                     case "i":
                                         if(player.stats[5]>=7)
                                         {
                                             System.out.println("\n\tyou take time to analyze your enemy\n\t...\n\tyou were able to identify their stats!");
                                             a4_enemy.showEnemyStats();
                                         }
                                         else
                                         {
                                             System.out.println("\n\tyou take time to analyze your enemy\n\t...\n\tyou fail to accurately tell their stats...");
                                         }
                                         if(turnsAway>0)
                                                     {
                                                         turnsAway--;
                                                         System.out.println("\n\n\tThe enemy is now " + turnsAway + " turn(s) away!");
                                                     }
                                                     else if(turnsAway == 0 || turnsAway<0)
                                                     {
                                                        int EdmgDealt = rand.nextInt(a4_enemy.enemyStats[2]);
                                                            System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                                            player.stats[0] -= EdmgDealt;
                                                            if (player.stats[0]<0) 
                                                            {
                                                                System.out.println("YOU DIED");
                                                                System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                                area1_cleared = true;
                                                                area2_cleared = true;
                                                                area3_cleared = true;
                                                                area4_cleared = true;
                                                                running = false;
                                                                break OUTER; 
                                                            }
                                                     }
                                         break;
                                     case "use skill":
                                     case "us":
                                         if(turnsAway > 0)
                                                {
                                                    System.out.println("\n\tEven though the enemy is " + turnsAway + " turn(s) away, you decide to face them right away!");
                                                }
                                                turnsAway = 0;
                                         if(player.skill.uses){
                                             if(player.skill.getName().equalsIgnoreCase("Blessing")){
                                                 if (player.stats[2]>=a4_enemy.enemyStats[3]) {
                                                     int EdmgDealt = rand.nextInt(a4_enemy.enemyStats[2]);
                                                     int HPgained = player.skill.use(player.stats);
                                                     System.out.println("You were healed for " + HPgained + " health points by your skill!");
                                                     player.stats[0] += HPgained;
                                                     System.out.println("The enemy does " + EdmgDealt + " damage back at you!");
                                                     player.stats[0] -= EdmgDealt;
                                                     if (player.stats[0]<0) {
                                                         System.out.println("YOU DIED");
                                                         System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                         area4_cleared = true;
                                                         running = false;
                                                         break OUTER;
                                                     }
                                                 }
                                                 if (player.stats[2]<a4_enemy.enemyStats[3]) {
                                                     int HPgained = player.skill.use(player.stats);
                                                     int EdmgDealt = rand.nextInt(a4_enemy.enemyStats[2]);
                                                     System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                                     player.stats[0] -= EdmgDealt;
                                                     if (player.stats[0]<0) {
                                                         System.out.println("YOU DIED");
                                                         System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                         area4_cleared = true;
                                                         running = false;
                                                         break OUTER;
                                                     }
                                                     System.out.println("You were healed for " + HPgained + " health points by your skill!");
                                                     player.stats[0] += HPgained;
                                                 }
                                             }
                                             else{
                                                 if (player.stats[2]>=a4_enemy.enemyStats[3]) {
                                                     int dmgDealt = player.skill.use(player.stats);
                                                     int EdmgDealt = rand.nextInt(a4_enemy.enemyStats[2]);
                                                     System.out.println("The enemy has taken " + dmgDealt + " damage becuase of your skill!");
                                                     a4_enemy.enemyStats[1] -= dmgDealt;
                                                     if (a4_enemy.enemyStats[1]<0) {
                                                         System.out.println("ENEMY DEFEATED!!!");
                                                         System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                                         a4_enemy.newEnemy(player.getDiffNum());
                                                         player.stats[0] = MAX_HEALTH;
                                                         player.skill.recharge();
                                                         int gain = rand.nextInt(40) + 35;
                                                         player.gainExp(gain);
                                                         break OUTER;
                                                     }
                                                     System.out.println("The enemy does " + EdmgDealt + " damage back at you!");
                                                     player.stats[0] -= EdmgDealt;
                                                     if (player.stats[0]<0) {
                                                         System.out.println("YOU DIED");
                                                         System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                         area4_cleared = true;
                                                         running = false;
                                                         break OUTER;
                                                     }
                                                 }
                                                 if (player.stats[2]<a4_enemy.enemyStats[3]) {
                                                     int dmgDealt = player.skill.use(player.stats);
                                                     int EdmgDealt = rand.nextInt(a4_enemy.enemyStats[2]);
                                                     System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                                     player.stats[0] -= EdmgDealt;
                                                     if (player.stats[0]<0) {
                                                         System.out.println("YOU DIED");
                                                         System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                         area4_cleared = true;
                                                         running = false;
                                                         break OUTER;
                                                     }
                                                     System.out.println("The enemy has taken " + dmgDealt + " damage because of your skill!");
                                                     a4_enemy.enemyStats[1] -= dmgDealt;
                                                     if (a4_enemy.enemyStats[1]<0) {
                                                         System.out.println("ENEMY DEFEATED!!!");
                                                         System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                                         a4_enemy.newEnemy(player.getDiffNum());
                                                         player.stats[0] = MAX_HEALTH;
                                                         player.skill.recharge();
                                                         int gain = rand.nextInt(40) + 35;
                                                         player.gainExp(gain);
                                                         break OUTER;
                                                     }
                                                 }
                                             }
                                         }
                                         else
                                             System.out.println("You cannot use that skill again this battle!");
                                         break;
                                     case "skill info":
                                     case "si":
                                         System.out.println("\t"+player.skill.getSkillInfo());
                                         break;
                                     case "equipment":
                                     case"se":
                                         System.out.println(Arrays.toString(player.equipment));
                                         break;
                                     case "bag":
                                     case "b":
                                         System.out.println(Arrays.toString(player.inventory));
                                         break;
                                     case "use":
                                     case "u":
                                         System.out.println("What item did you want to use from your bag? Type 1 for first item, 2 for second, and so on.");
                                         System.out.println("\t" + Arrays.toString(player.inventory));
                                         try{
                                             int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                             if(tempa < player.inventory.length){
                                                if(player.inventory[tempa] != null){
                                                    if(player.inventory[tempa].typeCheckConsumable()){
                                                        System.out.println("You use " + player.inventory[tempa].name + ".");
                                                        player.stats = player.inventory[tempa].ADDstats(player.stats);
                                                        player.inventory = player.inventory[tempa].dropInventory(player.inventory);
                                                    }
                                                    else
                                                        System.out.println("That is not a usable item.");
                                                }
                                                else
                                                 System.out.println("You do not have an item in that slot.");
                                             }
                                             else
                                                 System.out.println("You do not have an item in that slot.");
                                         }
                                         catch(NumberFormatException e){
                                             System.out.println("Please enter a number.");
                                             break;
                                         }
                                         if(turnsAway>0)
                                                     {
                                                         turnsAway--;
                                                         System.out.println("\n\n\tThe enemy is now " + turnsAway + " turn(s) away!");
                                                     }
                                                     else if(turnsAway == 0 || turnsAway<0)
                                                     {
                                                        int EdmgDealt = rand.nextInt(a4_enemy.enemyStats[2]);
                                                            System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                                            player.stats[0] -= EdmgDealt;
                                                            if (player.stats[0]<0) 
                                                            {
                                                                System.out.println("YOU DIED");
                                                                System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                                area1_cleared = true;
                                                                area2_cleared = true;
                                                                area3_cleared = true;
                                                                area4_cleared = true;
                                                                running = false;
                                                                break OUTER; 
                                                            }
                                                     }
                                         break;
                                    case "item stats":
                                    case "is":
                                        System.out.println("Where is this item located?\n\t1. Bag\n\t2. Equipment");
                                        try {
                                            int temp = Integer.parseInt(scan.nextLine());
                                            switch (temp) {
                                                case 1:
                                                    System.out.println("What item do you want to know the stats for? Type 1 for first item, 2 for second, and so on.");
                                                    System.out.println("\tBag: " + Arrays.toString(player.inventory));
                                                    try {
                                                        int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                                        if(player.inventory[tempa] != null){
                                                            System.out.println(player.inventory[tempa].name + " alters your stats in this way:");
                                                            player.inventory[tempa].getStats();
                                                        }
                                                        else{
                                                            System.out.println("You do not have an item in that slot. Please try again.");
                                                        }
                                                    } catch (NumberFormatException e) {
                                                        System.out.println("Please try again and enter a number.");
                                                        break OUTER_15;
                                                    }
                                                    break OUTER_15;
                                                case 2:
                                                    System.out.println("What item do you want to know the stats for? Type 1 for first item, 2 for second, and so on.");
                                                    System.out.println("\tEquipment: " + Arrays.toString(player.equipment));
                                                    try {
                                                        int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                                        if(player.equipment[tempa] != null){
                                                            System.out.println(player.equipment[tempa].name + " alters your stats in this way:");
                                                            player.equipment[tempa].getStats();
                                                        }
                                                        else{
                                                            System.out.println("You do not have an item in that slot. Please try again.");
                                                        }
                                                    } catch (NumberFormatException e) {
                                                        System.out.println("Please try again and enter a number.");
                                                        break OUTER_15;
                                                    }
                                                    break OUTER_15;
                                                default:
                                                    System.out.println("Please try again and enter a valid answer.");
                                                    break;
                                            }
                                        }catch(NumberFormatException e){
                                            System.out.println("Please try again and enter a number.");
                                            break;
                                        }
                                        break;
                                     case "stats":
                                     case "s":
                                         player.showStats();
                                         break;
                                     case "combat help":
                                         player.combatHelp();
                                         break;
                                     case "help":
                                         player.help();
                                         break;
                                     default:
                                         System.out.println("enter a valid command (use \"combat help\" for a list of basic combat commands");
                                         break;
                                 }
                             }//NORMAL COMBAT END
                             break;
                         case 2:
                             System.out.println("You found a chest! It contained: " + area1_chest.open());
                             OUTER:
                             while (true) {
                                 System.out.println("\n\tWould you like to keep the item?");
                                 System.out.println("\t\t 1. Yes");
                                 System.out.println("\t\t 2. No");
                                 input = scan.nextLine();
                                 switch (input) {
                                     case "1":
                                         System.out.println("You yank the item from the chest!\nYou gained: " + area1_chest.open());
                                         player.inventory = area1_chest.open().ADDinventory(player.inventory);
                                         System.out.println(Arrays.toString(player.inventory));
                                         area1_chest.newItem();
                                         break OUTER;
                                     case "2":
                                         System.out.println("You decided to leave the item behind.");
                                         area1_chest.newItem();
                                         break OUTER;
                                     default:
                                         System.out.println("Please enter a valid option.");
                                         break;
                                 }
                             } //CHEST END
                             break;
                         case 3:
                             int mod = 1;
                                    switch (player.getDiffNum()) {
                                        case 1:
                                            {
                                                mod = 1;
                                                break;
                                            }
                                        case 2:
                                            {
                                                mod = 2;
                                                break;
                                            }
                                        case 3:
                                            {
                                                mod = 3;
                                                break;
                                            }
                                        case 4:
                                            {
                                                mod = 4;
                                                break;
                                            }
                                        default:
                                            break;
                                    }
                             Enemy bigBoi = new Enemy(100 * mod, 50 * mod, 15 * mod, 15, 15, 15, 15, 15);
                             turnsAway = 2;
                             HOD_GAME boss4 = new HOD_GAME (4);
                             System.out.println("\n\n----------------------------I T ' S   B O S S   T I M E   B O i S----------------------------");
                             System.out.println("combat commands can be pulled up at any time by typing \"combat help\"");
                             OUTER:
                             while (true) {
                                 if(turnsAway > 0)
                                        {
                                            System.out.println("\n\n\tThe enemy is currently " + turnsAway + " turn(s) away!\n\tNow's your chance for ranged attacks "
                                                    + "(type \"ranged attack\"), or just type \"attack\" or \"a\" to charge the enemy straight on!\n\t"
                                                    + "(all skills are considered ranged)\n\t(you can still identify enemy and/or manage items)");
                                        }
                                 System.out.println("\nWhat will you do " + player.name + "?");
                                 input = scan.nextLine();
                                 OUTER_17:
                                 switch (input) {
                                     case "ranged attack":
                                     case "ra": 
                                                if(turnsAway == 0 || turnsAway<0)
                                                {
                                                    System.out.println("\n\tThe enemy is within melee distance! You cannot use ranged attacks right now!");
                                                }
                                                else if(turnsAway > 0)
                                                {
                                                   try{
                                        for (Items equipment : player.equipment) 
                                        {
                                            if (equipment.typeCheckRanged())  
                                            {
                                                int dmg = rand.nextInt((player.stats[1]) + (player.stats[2]));
                                                turnsAway--;
                                                System.out.println("You deal " + dmg + " to the enemy from afar!\n\tThe enemy is now " + turnsAway + " turn(s) away!");
                                                a1_enemy.enemyStats[1] -= dmg;
                                                break;
                                            } 
                                        }
                                                   }catch(NullPointerException e){System.out.println("\n\tYou don't have a ranged weapon in your equipment! You cannot do ranged attacks!");}
                                                }
                                                    break;
                                     case "attack":
                                        case "a":
                                            if (player.stats[2]>=bigBoi.enemyStats[3]) {
                                                int dmgDealt = rand.nextInt(player.stats[1]);
                                                System.out.println("The enemy has taken " + dmgDealt + " damage!");
                                                bigBoi.enemyStats[1] -= dmgDealt;
                                                if (bigBoi.enemyStats[1]<0) {
                                                    System.out.println("ENEMY DEFEATED!!!");
                                                    System.out.println("\n\n----------------------------BOSS HAS BEEN Y E E T E D----------------------------\n\n");
                                                    bigBoi.enemyStats[1] = 100;
                                                    player.stats[0] = MAX_HEALTH;
                                                    player.skill.recharge();
                                                    int gain = player.maxExp;
                                                    player.gainExp(gain);
                                                    break OUTER;
                                                }
                                                player.stats = bigBoi.bossFourSkills(rand.nextInt(3), player.stats, bigBoi.enemyStats, TrueNameRevealed );
                                                if (player.stats[0]<0) {
                                                    System.out.println("YOU DIED");
                                                    System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                    area1_cleared = true;
                                                    area2_cleared = true;
                                                    area3_cleared = true;
                                                    area4_cleared = true;
                                                    running = false;
                                                    break OUTER;
                                                }
                                            }
                                            if (player.stats[2]<bigBoi.enemyStats[3]) {
                                                int dmgDealt = rand.nextInt(player.stats[1]);
                                                player.stats = bigBoi.bossFourSkills(rand.nextInt(3), player.stats, bigBoi.enemyStats, TrueNameRevealed );
                                                if (player.stats[0]<0) {
                                                    System.out.println("YOU DIED");
                                                    System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                    area1_cleared = true;
                                                    area2_cleared = true;
                                                    area3_cleared = true;
                                                    area4_cleared = true;
                                                    running = false;
                                                    break OUTER;
                                                }
                                                System.out.println("\n\tThe enemy has taken " + dmgDealt + " damage!");
                                                bigBoi.enemyStats[1] -= dmgDealt;
                                                if (bigBoi.enemyStats[1]<0) {
                                                    System.out.println("ENEMY DEFEATED!!!");
                                                    System.out.println("\n\n----------------------------BOSS HAS BEEN Y E E T E D----------------------------\n\n");
                                                    bigBoi.enemyStats[1] = 100;
                                                    player.stats[0] = MAX_HEALTH;
                                                    player.skill.recharge();
                                                    int gain = player.maxExp;
                                                    player.gainExp(gain);
                                                    break OUTER;
                                                }
                                            }
                                            break;
                                     case "identify":
                                     case "i":
                                         if(player.stats[5]>=7)
                                         {
                                             System.out.println("\n\tyou take time to analyze your enemy\n\t...\n\tyou were able to identify their stats!");
                                             bigBoi.showEnemyStats();
                                         }
                                         else
                                         {
                                             System.out.println("\n\tyou take time to analyze your enemy\n\t...\n\tyou fail to accurately tell their stats...");
                                         }
                                         if(turnsAway>0)
                                                     {
                                                         turnsAway--;
                                                         System.out.println("\n\n\tThe enemy is now " + turnsAway + " turn(s) away!");
                                                     }
                                                     else if(turnsAway == 0 || turnsAway<0)
                                                     {
                                                        player.stats = bigBoi.bossFourSkills(rand.nextInt(3), player.stats, bigBoi.enemyStats, TrueNameRevealed );
                                                            if (player.stats[0]<0) 
                                                            {
                                                                System.out.println("YOU DIED");
                                                                System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                                area1_cleared = true;
                                                                area2_cleared = true;
                                                                area3_cleared = true;
                                                                area4_cleared = true;
                                                                running = false;
                                                                break OUTER; 
                                                            }
                                                     }
                                         break;
                                     case "use skill":
                                     case "us":
                                         if(turnsAway > 0)
                                                {
                                                    System.out.println("\n\tEven though the enemy is " + turnsAway + " turn(s) away, you decide to face them right away!");
                                                }
                                                turnsAway = 0;
                                         if(player.skill.uses){
                                             if(player.skill.getName().equalsIgnoreCase("Blessing")){
                                                 if (player.stats[2]>=bigBoi.enemyStats[3]) {
                                                     int HPgained = player.skill.use(player.stats);
                                                     System.out.println("You were healed for " + HPgained + " health points by your skill!");
                                                     player.stats[0] += HPgained;
                                                     player.stats = bigBoi.bossFourSkills(rand.nextInt(3), player.stats, bigBoi.enemyStats, TrueNameRevealed );
                                                     if (player.stats[0]<0) {
                                                         System.out.println("YOU DIED");
                                                         System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                         area4_cleared = true;
                                                         running = false;
                                                         break OUTER;
                                                     }
                                                 }
                                                 if (player.stats[2]<bigBoi.enemyStats[3]) {
                                                     int HPgained = player.skill.use(player.stats);
                                                     player.stats = bigBoi.bossFourSkills(rand.nextInt(3), player.stats, bigBoi.enemyStats, TrueNameRevealed );
                                                     if (player.stats[0]<0) {
                                                         System.out.println("YOU DIED");
                                                         System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                         area4_cleared = true;
                                                         running = false;
                                                         break OUTER;
                                                     }
                                                     System.out.println("You were healed for " + HPgained + " health points by your skill!");
                                                     player.stats[0] += HPgained;
                                                 }
                                             }
                                             else{
                                                 if (player.stats[2]>=bigBoi.enemyStats[3]) {
                                                     int dmgDealt = player.skill.use(player.stats);
                                                     System.out.println("The enemy has taken " + dmgDealt + " damage becuase of your skill!");
                                                     bigBoi.enemyStats[1] -= dmgDealt;
                                                     if (bigBoi.enemyStats[1]<0) {
                                                         System.out.println("ENEMY DEFEATED!!!");
                                                         System.out.println("\n\n----------------------------BOSS HAS BEEN Y E E T E D----------------------------\n\n");
                                                         bigBoi.newEnemy(player.getDiffNum());
                                                         player.stats[0] = MAX_HEALTH;
                                                         player.skill.recharge();
                                                         int gain = player.maxExp;
                                                         player.gainExp(gain);
                                                         break OUTER;
                                                     }
                                                     player.stats = bigBoi.bossFourSkills(rand.nextInt(3), player.stats, bigBoi.enemyStats, TrueNameRevealed );
                                                     if (player.stats[0]<0) {
                                                         System.out.println("YOU DIED");
                                                         System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                         area4_cleared = true;
                                                         running = false;
                                                         break OUTER;
                                                     }
                                                 }
                                                 if (player.stats[2]<bigBoi.enemyStats[3]) {
                                                     int dmgDealt = player.skill.use(player.stats);
                                                     player.stats = bigBoi.bossFourSkills(rand.nextInt(3), player.stats, bigBoi.enemyStats, TrueNameRevealed );
                                                     if (player.stats[0]<0) {
                                                         System.out.println("YOU DIED");
                                                         System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                         area4_cleared = true;
                                                         running = false;
                                                         break OUTER;
                                                     }
                                                     System.out.println("The enemy has taken " + dmgDealt + " damage because of your skill!");
                                                     bigBoi.enemyStats[1] -= dmgDealt;
                                                     if (bigBoi.enemyStats[1]<0) {
                                                         System.out.println("ENEMY DEFEATED!!!");
                                                         System.out.println("\n\n----------------------------BOSS HAS BEEN Y E E T E D----------------------------\n\n");
                                                         bigBoi.newEnemy(player.getDiffNum());
                                                         player.stats[0] = MAX_HEALTH;
                                                         player.skill.recharge();
                                                         int gain = player.maxExp;
                                                         player.gainExp(gain);
                                                         break OUTER;
                                                     }
                                                 }
                                             }
                                         }
                                         else
                                             System.out.println("You cannot use that skill again this battle!");
                                         break;
                                     case "skill info":
                                     case "si":
                                         System.out.println("\t"+player.skill.getSkillInfo());
                                         break;
                                     case "equipment":
                                     case"se":
                                         System.out.println(Arrays.toString(player.equipment));
                                         break;
                                     case "bag":
                                     case "b":
                                         System.out.println(Arrays.toString(player.inventory));
                                         break;
                                     case "use":
                                     case "u":
                                         System.out.println("What item did you want to use from your bag? Type 1 for first item, 2 for second, and so on.");
                                         System.out.println("\t" + Arrays.toString(player.inventory));
                                         try{
                                             int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                             if(tempa < player.inventory.length){
                                                if(player.inventory[tempa] != null){
                                                    if(player.inventory[tempa].typeCheckConsumable()){
                                                        System.out.println("You use " + player.inventory[tempa].name + ".");
                                                        player.stats = player.inventory[tempa].ADDstats(player.stats);
                                                        player.inventory = player.inventory[tempa].dropInventory(player.inventory);
                                                    }
                                                    else
                                                        System.out.println("That is not a usable item.");
                                                }
                                                else
                                                 System.out.println("You do not have an item in that slot.");
                                             }
                                             else
                                                 System.out.println("You do not have an item in that slot.");
                                         }
                                         catch(NumberFormatException e){
                                             System.out.println("Please enter a number.");
                                             break;
                                         }
                                         if(turnsAway>0)
                                                     {
                                                         turnsAway--;
                                                         System.out.println("\n\n\tThe enemy is now " + turnsAway + " turn(s) away!");
                                                     }
                                                     else if(turnsAway == 0 || turnsAway<0)
                                                     {
                                                        int EdmgDealt = rand.nextInt(bigBoi.enemyStats[2]);
                                                            System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                                            player.stats[0] -= EdmgDealt;
                                                            if (player.stats[0]<0) 
                                                            {
                                                                System.out.println("YOU DIED");
                                                                System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                                area1_cleared = true;
                                                                area2_cleared = true;
                                                                area3_cleared = true;
                                                                area4_cleared = true;
                                                                running = false;
                                                                break OUTER; 
                                                            }
                                                     }
                                         break;
                                    case "item stats":
                                    case "is":
                                        System.out.println("Where is this item located?\n\t1. Bag\n\t2. Equipment");
                                        try {
                                            int temp = Integer.parseInt(scan.nextLine());
                                            switch (temp) {
                                                case 1:
                                                    System.out.println("What item do you want to know the stats for? Type 1 for first item, 2 for second, and so on.");
                                                    System.out.println("\tBag: " + Arrays.toString(player.inventory));
                                                    try {
                                                        int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                                        if(player.inventory[tempa] != null){
                                                            System.out.println(player.inventory[tempa].name + " alters your stats in this way:");
                                                            player.inventory[tempa].getStats();
                                                        }
                                                        else{
                                                            System.out.println("You do not have an item in that slot. Please try again.");
                                                        }
                                                    } catch (NumberFormatException e) {
                                                        System.out.println("Please try again and enter a number.");
                                                        break OUTER_17;
                                                    }
                                                    break OUTER_17;
                                                case 2:
                                                    System.out.println("What item do you want to know the stats for? Type 1 for first item, 2 for second, and so on.");
                                                    System.out.println("\tEquipment: " + Arrays.toString(player.equipment));
                                                    try {
                                                        int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                                        if(player.equipment[tempa] != null){
                                                            System.out.println(player.equipment[tempa].name + " alters your stats in this way:");
                                                            player.equipment[tempa].getStats();
                                                        }
                                                        else{
                                                            System.out.println("You do not have an item in that slot. Please try again.");
                                                        }
                                                    } catch (NumberFormatException e) {
                                                        System.out.println("Please try again and enter a number.");
                                                        break OUTER_17;
                                                    }
                                                    break OUTER_17;
                                                default:
                                                    System.out.println("Please try again and enter a valid answer.");
                                                    break;
                                            }
                                        }catch(NumberFormatException e){
                                            System.out.println("Please try again and enter a number.");
                                            break;
                                        }
                                        break;
                                     case "stats":
                                     case "s":
                                         player.showStats();
                                         break;
                                     case "combat help":
                                         player.combatHelp();
                                         break;
                                     case "help":
                                         player.help();
                                         break;
                                     default:
                                         System.out.println("enter a valid command (use \"combat help\" for a list of basic combat commands");
                                         break;
                                 }
                             } // BOSS FIGHT END
                             break;
                         case 4:
                             System.out.println("\n\n\tUpon killing Evil boi, you find a portal. You figure there is no point staying in such\n\tan area, so you go inside."
                                     + "\n\tEverything goes white. Then all a sudden you wake up, in the middle of a tranquil field. No enemies, no traps...\n\tNo "
                                     + "Evil Boi. You feel safe here. You feel like... you've finally returned \"home\" ");
                             area4_cleared = true;
                             break;
                         default:
                             break;
                     } // AREA GET DATA END
                     break;
                 case "equipment":
                 case"se":
                     System.out.println(Arrays.toString(player.equipment));
                     break;
                 case "bag":
                 case "b":
                     System.out.println(Arrays.toString(player.inventory));
                     break;
                 case "drop":
                 case "d":
                     System.out.println("From where would you like to drop something?\n\t1. Bag\n\t2. Equipment");
                     try {
                         int temp = Integer.parseInt(scan.nextLine());
                         switch (temp) {
                             case 1:
                                 System.out.println("Which item did you want to drop from your bag? Type 1 for first item, 2 for second, and so on.");
                                 System.out.println("\t" + Arrays.toString(player.inventory));
                                 try {
                                     int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                     if(tempa < player.inventory.length){
                                        if (player.inventory[tempa] != null) {
                                            System.out.println("You dropped your " + player.inventory[tempa].name + ".");
                                            player.inventory = player.inventory[tempa].dropInventory(player.inventory);
                                            break OUTER_18;
                                        }
                                        else
                                            System.out.println("You do not have an item in that slot.");
                                     }
                                     else {
                                         System.out.println("You do not have an item in that slot. Please try again.");
                                     }
                                 } catch (NumberFormatException e) {
                                     System.out.println("Please try again and enter a number.");
                                     break OUTER_18;
                                 }
                                 break OUTER_18;
                             case 2:
                                 System.out.println("Which item did you want to drop from your equipment? Type 1 for first item, 2 for second, and so on.");
                                 System.out.println("\t" + Arrays.toString(player.equipment));
                                 try {
                                     int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                     if(tempa < player.equipment.length){
                                        if (player.equipment[tempa] != null) {
                                            System.out.println("You dropped your " + player.equipment[tempa].name + ".");
                                            player.stats = player.equipment[tempa].SUBstats(player.stats);
                                            player.equipment = player.equipment[tempa].dropEquipment(player.equipment);
                                            break OUTER_18;
                                        }
                                        else
                                            System.out.println("You do not have an item in that slot.");
                                     }
                                     else {
                                         System.out.println("You do not have an item in that slot. Please try again.");
                                     }
                                 } catch (NumberFormatException e) {
                                     System.out.println("Please try again and enter a number.");
                                     break OUTER_18;
                                 }
                                 break;
                             default:
                                 System.out.println("Please try again and enter a valid answer.");
                                 break;
                         }
                     }catch(NumberFormatException e){
                         System.out.println("Please try again and enter a number.");
                         break;
                     }
                     break;
                 case "equip":
                 case "e":
                    if(!dummy.isFull(player.equipment)){
                        System.out.println("What item did you want to equip from your bag? Type 1 for first item, 2 for second, and so on.");
                        System.out.println("\t" + Arrays.toString(player.inventory));
                        try{
                            int tempa = Integer.parseInt(scan.nextLine()) - 1;
                            if(tempa < player.inventory.length){
                                if(player.inventory[tempa] != null){
                                    System.out.println("You equipped your " + player.inventory[tempa].name + ".");
                                    player.stats = player.inventory[tempa].ADDstats(player.stats);
                                    Items[][] temp = player.inventory[tempa].equip(player.inventory, player.equipment);
                                    player.inventory = temp[0];
                                    player.equipment = temp[1];
                                    break;
                                }
                                else
                                    System.out.println("You do not have an item in that slot.");
                            }
                            else
                                System.out.println("You do not have an equipped item in that slot.");
                        }
                        catch(NumberFormatException e){
                            System.out.println("Please enter a number.");
                            break;
                        }
                        break;
                    }
                    else
                        System.out.println("Your equipment is full! You can't equip an item.");
                    break;
                case "unequip":
                case "ue":
                    if(!dummy.isFull(player.inventory)){
                        System.out.println("What item did you want to unequip from your equipment? Type 1 for first item, 2 for second, and so on.");
                        System.out.println("\t" + Arrays.toString(player.equipment));
                        try{
                            int tempa = Integer.parseInt(scan.nextLine()) - 1;
                            if(tempa < player.equipment.length){
                                if(player.equipment[tempa] != null){
                                    System.out.println("You unequipped your " + player.equipment[tempa].name + ".");
                                    player.stats = player.equipment[tempa].SUBstats(player.stats);
                                    Items[][] temp = player.equipment[tempa].unequip(player.inventory, player.equipment);
                                    player.inventory = temp[0];
                                    player.equipment = temp[1];
                                    break;
                                }
                                else
                                    System.out.println("You do not have an item in that slot.");
                            }
                            else
                                System.out.println("You do not have an equipped item in that slot.");
                        }
                        catch(NumberFormatException e){
                            System.out.println("Please enter a number.");
                            break;
                        }
                        break;
                    }
                  else
                    System.out.println("Your bag is full! You can't unequip an item.");
                  break;
                 case "use":
                 case "u":
                     System.out.println("What item did you want to use from your bag? Type 1 for first item, 2 for second, and so on.");
                     System.out.println("\t" + Arrays.toString(player.inventory));
                     try{
                         int tempa = Integer.parseInt(scan.nextLine()) - 1;
                         if(tempa < player.inventory.length){
                            if(player.inventory[tempa] != null){
                                if(player.inventory[tempa].typeCheckConsumable()){
                                    System.out.println("You use " + player.inventory[tempa].name + ".");
                                    player.stats = player.inventory[tempa].ADDstats(player.stats);
                                    player.inventory = player.inventory[tempa].dropInventory(player.inventory);
                                }
                                else
                                    System.out.println("That is not a usable item.");
                            }
                            else
                                System.out.println("You do not have an item in that slot.");
                         }
                         else
                             System.out.println("You do not have an item in that slot.");
                     }
                     catch(NumberFormatException e){
                         System.out.println("Please enter a number.");
                         break;
                     }
                     break;
                 case "item stats":
                 case "is":
                     System.out.println("Where is this item located?\n\t1. Bag\n\t2. Equipment");
                     try {
                         int temp = Integer.parseInt(scan.nextLine());
                         switch (temp) {
                             case 1:
                                 System.out.println("What item do you want to know the stats for? Type 1 for first item, 2 for second, and so on.");
                                 System.out.println("\tBag: " + Arrays.toString(player.inventory));
                                 try {
                                     int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                     if(tempa < player.inventory.length){
                                        if(player.inventory[tempa] != null){
                                            System.out.println(player.inventory[tempa].name + " alters your stats in this way:");
                                            player.inventory[tempa].getStats();
                                        }
                                        else
                                            System.out.println("You do not have an item in that slot.");
                                     }
                                     else{
                                         System.out.println("You do not have an item in that slot. Please try again.");
                                     }
                                 } catch (NumberFormatException e) {
                                     System.out.println("Please try again and enter a number.");
                                     break OUTER_19;
                                 }
                                 break OUTER_19;
                             case 2:
                                 System.out.println("What item do you want to know the stats for? Type 1 for first item, 2 for second, and so on.");
                                 System.out.println("\tEquipment: " + Arrays.toString(player.equipment));
                                 try {
                                     int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                     if(tempa < player.equipment.length){
                                        if(player.equipment[tempa] != null){
                                            System.out.println(player.equipment[tempa].name + " alters your stats in this way:");
                                            player.equipment[tempa].getStats();
                                        }
                                        else
                                            System.out.println("You do not have an item in that slot.");
                                     }
                                     else{
                                         System.out.println("You do not have an item in that slot. Please try again.");
                                     }
                                 } catch (NumberFormatException e) {
                                     System.out.println("Please try again and enter a number.");
                                     break OUTER_19;
                                 }
                                 break OUTER_19;
                             default:
                                 System.out.println("Please try again and enter a valid answer.");
                                 break;
                         }
                     }catch(NumberFormatException e){
                         System.out.println("Please try again and enter a number.");
                         break;
                     }
                     break;
                 case "stats":
                 case "s":
                     player.showStats();
                     break;
                 case "skill info":
                 case "si":
                     System.out.println("\t"+player.skill.getSkillInfo());
                     break;
                 default:
                     System.out.println("enter a valid command (use \"help\" for a list of basic commands)");
                     break;
             }
          }//WHILE AREA_4 CLEARED END 
          if(area1_cleared == true && area2_cleared == true && area3_cleared == true && area4_cleared == true && running == true)
          {
              System.out.println("\n\n\n\tAnd with that... you've deafeated Evil Boi and freed his land from his tyrannical reign.\n\tYou have finally freed yourself"
                      + "from the eternal hour of devistation he has wrought upon you after\n\t(possibly) tens to hundreds of deaths.\n\tFinally... you are free from"
                      + "the Hour of Devistation.\n\n\n\tCongratulations! You've beaten the game " + player.name + "! Amazing job!\n\n\tQuestion is... are you willing"
                              + " to take it to the next difficulty?");
              running = false;
              System.exit(0);
              break;
          }
      }//WHILE RUNNING LOOP END       

      System.exit(0);
    }//MAIN END
    
    
    
     public HOD_GAME(int x) throws IOException
    {
        switch (x)
        {
            case 1:
        BufferedImage img=ImageIO.read(new File("C:\\Users\\G\\Documents\\OU\\HOD//big boi.png"));
        ImageIcon icon=new ImageIcon(img);
        JFrame frame=new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(960,1080);
        JLabel lbl=new JLabel();
        lbl.setIcon(icon);
        frame.add(lbl);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                break;
            case 2:
        BufferedImage img2=ImageIO.read(new File("C:\\Users\\G\\Documents\\OU\\HOD//hackerwoman.jpg"));
        ImageIcon icon2=new ImageIcon(img2);
        JFrame frame2=new JFrame();
        frame2.setLayout(new FlowLayout());
        frame2.setSize(960,1080);
        JLabel lbl2=new JLabel();
        lbl2.setIcon(icon2);
        frame2.add(lbl2);
        frame2.setVisible(true);
        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                break;
            case 3:
        BufferedImage img3=ImageIO.read(new File("C:\\Users\\G\\Documents\\OU\\HOD//girlCollage.jpg"));
        ImageIcon icon3=new ImageIcon(img3);
        JFrame frame3=new JFrame();
        frame3.setLayout(new FlowLayout());
        frame3.setSize(960,1080);
        JLabel lbl3=new JLabel();
        lbl3.setIcon(icon3);
        frame3.add(lbl3);
        frame3.setVisible(true);
        frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                break;
            case 4:
        BufferedImage img4=ImageIO.read(new File("C:\\Users\\G\\Documents\\OU\\HOD//Evil Boi.png"));
        ImageIcon icon4=new ImageIcon(img4);
        JFrame frame4=new JFrame();
        frame4.setLayout(new FlowLayout());
        frame4.setSize(960,1080);
        JLabel lbl4=new JLabel();
        lbl4.setIcon(icon4);
        frame4.add(lbl4);
        frame4.setVisible(true);
        frame4.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        break;
        case 5:
        BufferedImage img5=ImageIO.read(new File("C:\\Users\\G\\Documents\\OU\\HOD//cave.jpg"));
        ImageIcon icon5=new ImageIcon(img5);
        JFrame frame5=new JFrame();
        frame5.setLayout(new FlowLayout());
        frame5.setSize(960,1080);
        JLabel lbl5=new JLabel();
        lbl5.setIcon(icon5);
        frame5.add(lbl5);
        frame5.setVisible(true);
        frame5.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            break;
        case 6:
        BufferedImage img6=ImageIO.read(new File("C:\\Users\\G\\Documents\\OU\\HOD//forest.jpg"));
        ImageIcon icon6=new ImageIcon(img6);
        JFrame frame6=new JFrame();
        frame6.setLayout(new FlowLayout());
        frame6.setSize(960,1080);
        JLabel lbl6=new JLabel();
        lbl6.setIcon(icon6);
        frame6.add(lbl6);
        frame6.setVisible(true);
        frame6.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            break;
        case 7:
        BufferedImage img7=ImageIO.read(new File("C:\\Users\\G\\Documents\\OU\\HOD//catacombs.jpg"));
        ImageIcon icon7=new ImageIcon(img7);
        JFrame frame7=new JFrame();
        frame7.setLayout(new FlowLayout());
        frame7.setSize(960,1080);
        JLabel lbl7=new JLabel();
        lbl7.setIcon(icon7);
        frame7.add(lbl7);
        frame7.setVisible(true);
        frame7.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            break;
        case 8:
        BufferedImage img8=ImageIO.read(new File("C:\\Users\\G\\Documents\\OU\\HOD//floating islands.jpg"));
        ImageIcon icon8=new ImageIcon(img8);
        JFrame frame8=new JFrame();
        frame8.setLayout(new FlowLayout());
        frame8.setSize(960,1080);
        JLabel lbl8=new JLabel();
        lbl8.setIcon(icon8);
        frame8.add(lbl8);
        frame8.setVisible(true);
        frame8.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            break;
        }
        
    }
     
     
     
}//CLASS (HOD_GAME) END