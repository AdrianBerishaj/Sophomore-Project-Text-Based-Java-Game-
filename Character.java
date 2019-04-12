/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adrian
 */

package hod_game;


import java.util.*;

public class Character<E> {
    int lvl, health, exp, inv;
    int maxExp = 100 + (50 * lvl);
    String name, gameClass;
    int[] stats;
    Items[] inventory, equipment;
    Skills skill;
    private int str, dex, con, intel, wis, cha;
    int difficultyNum = 0; //Used for determining stats of enemies
    
    public Character(){
        this.lvl = 0;
        this.health = 100;
        this.exp = 0;
        this.inv = 8;
        inventory = (Items[]) new Items[10];
        equipment = (Items[]) new Items[5];
        name = "";
        gameClass = "";
    }
    public int getCurrLevel(){
        return this.lvl;
    }
    public int getCurrHealth(){
        return this.health;
    }
    public int getCurrExp(){
        return this.exp;
    }
    public int getCurrInv(){
        return this.inv;
    }
    public void loseHealth(int loss){
        this.health = health - loss;
        if (this.health <= 0){   //Checking if character is dead
            System.out.println("You Have Died.");
            System.exit(0);
        }
    }
    public void gainHealth(int gain){
        this.health = health + gain;
        if (this.health > 100)   //Limiting health to 100
            this.health = 100;
    }
    
    
    public void useInvSlot(){
        this.inv = inv - 1;
        if (inv <= 0)
            System.out.println("Inventory is full.");
    }
    public int getDifficulty(){
        Scanner sc = new Scanner(System.in);
        //Choosing difficulty
        
        System.out.println("What difficulty would you like to play?");
        System.out.println("  Easy, Normal, Hard, or Very Hard?");
        System.out.println("  (This just changes your character's starting level)");
        System.out.println("Type Below:");
        while (lvl == 0){   //Ensuring that a correct choice is entered
            String dif = sc.nextLine();
            if (dif.equalsIgnoreCase("Easy")){
                lvl = 15;
                difficultyNum = 1;
            }
            
            else if (dif.equalsIgnoreCase("Normal")){
                lvl = 10;
                difficultyNum = 2;
            }
            
            else if (dif.equalsIgnoreCase("Hard")){
                lvl = 5;
                difficultyNum = 3;
            }
            
            else if (dif.equalsIgnoreCase("Very Hard")){
                lvl = 1;
                difficultyNum = 4;
            }
            
            else
                System.out.println("Please enter a valid difficulty:");
                
        }
        return difficultyNum;
    }
    
    public int getDiffNum(){
        return difficultyNum;
    }
    public void getName(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of your character: ");
        this.name = sc.nextLine();
    }
    public void getCharClass(){
        String c;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter which class you would like to play: ");
        System.out.println("  Knight, Cleric, Ranger, Sorcerer");
        c = sc.nextLine();
        while(true){
            if (c.equalsIgnoreCase("Knight")){
                skill = new Skills("Dash Attack", 15, 0, true);
                System.out.println();
                System.out.println("You chose to be a Knight!");
                System.out.println("You gained the Dash Attack skill!\n");
                break;
            }
            if (c.equalsIgnoreCase("Cleric")){
                skill = new Skills("Blessing", 0, 25, true);
                System.out.println();
                System.out.println("You chose to be a Cleric!");
                System.out.println("You gained the Blessing skill!\n");
                break;
            }
            if (c.equalsIgnoreCase("Ranger")){
                skill = new Skills("Rapid Fire", 10, 0, true);
                System.out.println();
                System.out.println("You chose to be a Ranger!");
                System.out.println("You gained the Rapid Fire skill!\n");
                break;
            }
            if (c.equalsIgnoreCase("Sorcerer")){
                skill = new Skills("Firebolt", 20, 0, true);
                System.out.println();
                System.out.println("You chose to be a Sorcerer!");
                System.out.println("You gained the Firebolt skill!\n");
                break;
            }
            else{
                System.out.println("Please choose a valid class: ");
                c = sc.nextLine();
            }
        }
        this.gameClass = c;
    }
    
    public void getStats(){
        Scanner sc = new Scanner(System.in);
        int str, dex, con, intel, wis, cha;
        int one = new Random().nextInt(14) + 7;
        int two = new Random().nextInt(14) + 7;
        if (two == one){
            while (two == one)
                two = new Random().nextInt(14) + 7;
        }    
        int three = new Random().nextInt(14) + 7;
        if (three == two || three == one){
            while (three == two || three == one)
                three = new Random().nextInt(14) + 7;
        }    
        int four = new Random().nextInt(14) + 7;
        if (four == three || four == two || four == one){
            while (four == three || four == two || four == one)
                four = new Random().nextInt(14) + 7;
        }   
        int five = new Random().nextInt(14) + 7;
        if (five == four || five == three || five == two || five == one){
            while (five == four || five == three || five == two || five == one)
                five = new Random().nextInt(14) + 7;
        }
        int six = new Random().nextInt(14) + 7;
        if (six == five || six == four || six == three || six == two || six == one){
            while (six == five || six == four || six == three || six == two || six == one)
                six = new Random().nextInt(14) + 7;
        }
        System.out.println("Please assign the following randomly generated numbers to the following stats:");
        System.out.println(one + ", " + two + ", " + three + ", " + four + ", " + five + ", " + six);
        System.out.println();
        System.out.println("Choose the number you want your Strength stat to be:");
        while(true){
            try{
                str = Integer.parseInt(sc.nextLine());
                if(str == one){
                    System.out.println("Strength: " + one);
                    break;
                }
                if(str == two){
                    System.out.println("Strength: " + two);
                    break;
                }
                if(str == three){
                    System.out.println("Strength: " + three);
                    break;
                }
                if(str == four){
                    System.out.println("Strength: " + four);
                    break;
                }
                if(str == five){
                    System.out.println("Strength: " + five);
                    break;
                }
                if(str == six){
                    System.out.println("Strength: " + six);
                    break;
                }
                else{
                    System.out.println("Please choose a valid number: ");
                }
            }
            catch(NumberFormatException e){
                System.out.println("Please enter a number.");
            }
        }
        System.out.println("Choose the number you want your Dexterity stat to be:");
        while(true){
            try{
                dex = Integer.parseInt(sc.nextLine());
                if(dex == str){
                    System.out.println("You already chose that number.");
                    while(dex == str){
                        System.out.println("Please choose another number: ");
                        dex = Integer.parseInt(sc.nextLine());
                    }
                }
                if(dex == one){
                    System.out.println("Dexterity: " + one);
                    break;
                }
                if(dex == two){
                    System.out.println("Dexterity: " + two);
                    break;
                }
                if(dex == three){
                    System.out.println("Dexterity: " + three);
                    break;
                }
                if(dex == four){
                    System.out.println("Dexterity: " + four);
                    break;
                }
                if(dex == five){
                    System.out.println("Dexterity: " + five);
                    break;
                }
                if(dex == six){
                    System.out.println("Dexterity: " + six);
                    break;
                }
                else{
                    System.out.println("Please choose a valid number: ");
                }
            }
            catch(NumberFormatException e){
                System.out.println("Please enter a number.");
            }
        }
        System.out.println("Choose the number you want your Constitution stat to be:");
        while(true){
            try{
                con = Integer.parseInt(sc.nextLine());
                if(con == dex || con == str){
                    System.out.println("You already chose that number.");
                    while(con == dex || con == str){
                        System.out.println("Please choose another number: ");
                        con = Integer.parseInt(sc.nextLine());
                    }
                }
                if(con == one){
                    System.out.println("Constitution: " + one);
                    break;
                }
                if(con == two){
                    System.out.println("Constitution: " + two);
                    break;
                }
                if(con == three){
                    System.out.println("Constitution: " + three);
                    break;
                }
                if(con == four){
                    System.out.println("Constitution: " + four);
                    break;
                }
                if(con == five){
                    System.out.println("Constitution: " + five);
                    break;
                }
                if(con == six){
                    System.out.println("Constitution: " + six);
                    break;
                }
                else{
                    System.out.println("Please choose a valid number: ");
                }
            }
            catch(NumberFormatException e){
                System.out.println("Please enter a number.");
            }
        }
        System.out.println("Choose the number you want your Intelligence stat to be:");
        while(true){
            try{
                intel = Integer.parseInt(sc.nextLine());
                if(intel == con || intel == dex || intel == str){
                    System.out.println("You already chose that number.");
                    while(intel == con || intel == dex || intel == str){
                        System.out.println("Please choose another number: ");
                        intel = Integer.parseInt(sc.nextLine());
                    }
                }
                if(intel == one){
                    System.out.println("Intelligence: " + one);
                    break;
                }
                if(intel == two){
                    System.out.println("Intelligence: " + two);
                    break;
                }
                if(intel == three){
                    System.out.println("Intelligence: " + three);
                    break;
                }
                if(intel == four){
                    System.out.println("Intelligence: " + four);
                    break;
                }
                if(intel == five){
                    System.out.println("Intelligence: " + five);
                    break;
                }
                if(intel == six){
                    System.out.println("Intelligence: " + six);
                    break;
                }
                else{
                    System.out.println("Please choose a valid number: ");
                }
            }
            catch(NumberFormatException e){
                System.out.println("Please enter a number.");
            }
        }
        System.out.println("Choose the number you want your Wisdom stat to be:");
        while(true){
            try{
                wis = Integer.parseInt(sc.nextLine());
                if(wis == intel || wis == con || wis == dex || wis == str){
                    System.out.println("You already chose that number.");
                    while(wis == intel || wis == con || wis == dex || wis == str){
                        System.out.println("Please choose another number: ");
                        wis = Integer.parseInt(sc.nextLine());
                    }
                }
                if(wis == one){
                    System.out.println("Wisdom: " + one);
                    break;
                }
                if(wis == two){
                    System.out.println("Wisdom: " + two);
                    break;
                }
                if(wis == three){
                    System.out.println("Wisdom: " + three);
                    break;
                }
                if(wis == four){
                    System.out.println("Wisdom: " + four);
                    break;
                }
                if(wis == five){
                    System.out.println("Wisdom: " + five);
                    break;
                }
                if(wis == six){
                    System.out.println("Wisdom: " + six);
                    break;
                }
                else{
                    System.out.println("Please choose a valid number: ");
                }
            }
            catch(NumberFormatException e){
                System.out.println("Please enter a number.");
            }
        }
        if (str != one && dex != one && con != one && intel != one && wis != one)
            cha = one;
        else if (str != two && dex != two && con != two && intel != two && wis != two)
            cha = two;
        else if (str != three && dex != three && con != three && intel != three && wis != three)
            cha = three;
        else if (str != four && dex != four && con != four && intel != four && wis != four)
            cha = four;
        else if (str != five && dex != five && con != five && intel != five && wis != five)
            cha = five;
        else
            cha = six;
        System.out.println("Therefore, Charisma is assigned the last number.");
        System.out.println("Charisma: " + cha);
        this.stats = new int[]{health, str, dex, con, intel, wis, cha};
    }
    public void gainExp(int gain){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Exp has been gained" );
        this.exp = exp + gain; 
       
        if (this.exp >= maxExp){ //Checking if a level up is in order
           System.out.println("You have attained more power to yeet your enemies!!!");
           System.out.println("Choose a stat to increase by 3");
           System.out.println("1 = strength");
           System.out.println("2 = Dexterity");
           System.out.println("3 = Constitution");
           System.out.println("4 = Intelligence");
           System.out.println("5 = Wisdom");
           System.out.println("6 = Charisma");
           
           int statPoint = sc.nextInt() ;
           switch (statPoint){
           case 1:
            str = str + 3;
            System.out.println("3 points has been added to your strength");
            break;
            
           case 2:
            dex = dex + 3;
            System.out.println("3 points have been added to your dexterity");
            break;
            
            case 3:
            con = con + 3;
            System.out.println("3 points have been added to your constitution");
            break;
            
            case 4:
            intel = intel + 3;
            System.out.println("3 points have been added to your intelligence");
            break;
            
            case 5:
            wis = wis + 3;
            System.out.println("3 points have been added to your wisdom");
            break;
            
            case 6:
            cha = cha + 3;
            System.out.println("3 points have been added to your charisma");
            break;
            
            default:
                System.out.println("Choose a stat please");
           
           }
          this.exp = exp - maxExp;
            this.lvl++;
            this.stats = new int[]{health, str, dex, con, intel, wis, cha};
                
        }        
            
        }
     public void showInv() //command "bag"
    {
        for (Items inventory1 : inventory) {
            System.out.println(inventory1); 
        }
    }
     public void showEquip() //command "equipment"
    {
        for (Items equipment1 : equipment) {
            System.out.println(equipment1); 
        }
    }
     public void showStats() // command "stats"
     {
         System.out.println("\n\tHP: " +stats[0] + "\n\tSTR: " + stats[1] + "\n\tDEX: " + stats[2] + "\n\tCON: " + stats[3] + "\n\tINT: " + stats[4] + "\n\tWIS: " + stats[5] + "\n\tCHA: " + stats[6]);
         
     }
     public void help()
     {
         System.out.println("\n\n\tbasic commands:");
         System.out.println("\tforward (or f) - move forward");
         System.out.println("\tequipment (or \"se\") - show player equipment");
         System.out.println("\tbag (or \"b\") - display player inventory");
         System.out.println("\tstats (or \"s\") - display current player stats");
         System.out.println("\tskill info (or \"si\") - display info of player's skill");
         System.out.println("\titem stats (or \"is\") - show how a specific item will echange your character stats when equipped");
         System.out.println("\n\tcommands for managing items:");
         System.out.println("\tdrop (or \"d\") - drop an item from your bag or equipment");
         System.out.println("\tuse (or \"u\") - use any usable item from your bag");
         System.out.println("\tequip (or \"e\") - equip an item from your bag to your equipment");
         System.out.println("\tunequip (or \"ue\") - unequip an item from your equipment and place it in your bag");
        // System.out.println("\td");
     }
     public void combatHelp()
     {
         System.out.println("\n\n\tcombat commands:");
         System.out.println("\tattack (or \"a\") - attack the enemy head on with a melee attack \n\t(if used while still >0 turns from enemy, you will \"run up to\" enemy, bringing the amount to 0)");
         System.out.println("\tuse skill (or \"us\")- uses your character's skill! It can only be used once per battle. \n\t(like \"attack\", it will set \"turns away\" to 0)");
         System.out.println("\tskill info (or \"si\") - display info of player's skill");
         System.out.println("\tuse (or \"u\") - use any usable item from your bag \n\t(will consume a turn, even if you try using an \"empty\" item)");
         System.out.println("\titem stats (\"is\") - show how a specific item will echange your character stats when equipped");
         System.out.println("\tranged attack (or \"ra\") - attack the enemy from afar with a ranged attack! (need a ranged weapon)");
         System.out.println("\tidentify (or \"i\") - use your wisdom to possibly identify enemy stats! (will consume a turn!)");
         System.out.println("\tany time during combat you may CHECK your current equipment, inventory, and current stats; will NOT consume a turn");
     }
}
