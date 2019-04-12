package hod_game;

import java.util.Random;
import java.util.Scanner;

public class Enemy  
{
    String enemyType[] = {"Skeley boi", "Lesser Imp", "(crappy) Mage"};
    String enemyType2[] = {"Big mossy boi", "Colossal Forest Spider", "Forest Gremlin"};
    String enemyType3[] = {"Sp00ky boi", "Zambie", "Ball of Bones"};
    String enemyType4[] = {"(high tier) Mage", "(not so good) Angel", "Gigantic Fist boi"};
    int lvl, enemyHealth, enemyatt, damageDealt, str, dex, con, intel, wis, cha; ;
    Random rand = new Random();
    Scanner scan = new Scanner(System.in);
    int[] enemyStats;
    int difficulty;
    public Enemy(int Elvl, int Ehealth, int Estr, int Edex, int Econ, int Eintel, int Ewis, int Echa)
    {
        lvl = Elvl;
        str = Estr;
        dex = Edex;
        con = Econ;
        intel = Eintel;
        wis = Ewis;
        cha = Echa;
        enemyHealth = Ehealth;
        enemyStats = new int[]{lvl, enemyHealth, str, dex, con, intel, wis, cha};
                     
    }
        
   public void getEnemy()
           {
               System.out.println("\n\n\tA " + enemyType[rand.nextInt(enemyType.length)] + " has appeared!");
           }
   public void getEnemy2()
           {
               System.out.println("\n\n\tA " + enemyType2[rand.nextInt(enemyType.length)] + " has appeared!");
           }
   public void getEnemy3()
           {
               System.out.println("\n\n\tA " + enemyType3[rand.nextInt(enemyType.length)] + " has appeared!");
           }
   public void getEnemy4()
           {
               System.out.println("\n\n\tA " + enemyType4[rand.nextInt(enemyType.length)] + " has appeared!");
           }
    
   public void showEnemyStats() // command "identify"
     {
         System.out.println("\n\tLEVEL: " +enemyStats[0] + "\n\tHP: " + enemyStats[1] + "\n\tSTR: " + enemyStats[2] + "\n\tDEX: " + enemyStats[3] + "\n\tCON: " + enemyStats[4] + "\n\tINT: " + enemyStats[5] + "\n\tWIS: " + enemyStats[6] + "\n\tCHA: " + enemyStats[7]);  
     }
   
    
    public void newEnemy(int difficultyNum)  //Different values depending on the difficulty chosen
   {
       difficulty = difficultyNum;
       
        switch (difficultyNum) {
            case 1:
                enemyStats[1] = rand.nextInt(16) + 50;
                enemyStats[2] = rand.nextInt(6) + 10;
                enemyStats[3] = rand.nextInt(8) + 8;
                enemyStats[4] = rand.nextInt(10) + 6;
                enemyStats[5] = rand.nextInt(10) + 6;
                enemyStats[6] = rand.nextInt(10) + 6;
                enemyStats[7] = rand.nextInt(10) + 6;
                break;
            case 2:
                enemyStats[1] = rand.nextInt(21) + 50;
                enemyStats[2] = rand.nextInt(8) + 10;
                enemyStats[3] = rand.nextInt(10) + 8;
                enemyStats[4] = rand.nextInt(10) + 6;
                enemyStats[5] = rand.nextInt(10) + 6;
                enemyStats[6] = rand.nextInt(10) + 6;
                enemyStats[7] = rand.nextInt(10) + 6;
                break;
            case 3:
                enemyStats[1] = rand.nextInt(26) + 50;
                enemyStats[2] = rand.nextInt(10) + 10;
                enemyStats[3] = rand.nextInt(11) + 8;
                enemyStats[4] = rand.nextInt(10) + 6;
                enemyStats[5] = rand.nextInt(10) + 6;
                enemyStats[6] = rand.nextInt(10) + 6;
                enemyStats[7] = rand.nextInt(10) + 6;
                break;
            case 4:
                enemyStats[1] = rand.nextInt(31) + 50;
                enemyStats[2] = rand.nextInt(12) + 10;
                enemyStats[3] = rand.nextInt(12) + 8;
                enemyStats[4] = rand.nextInt(10) + 6;
                enemyStats[5] = rand.nextInt(10) + 6;
                enemyStats[6] = rand.nextInt(10) + 6;
                enemyStats[7] = rand.nextInt(10) + 6;
                break;
            default:
                break;
        }
    }
       
       
   public void newEnemy2(int difficultyNum)
   {
       difficulty = difficultyNum;
       
        switch (difficultyNum) {
            case 1:
                enemyStats[1] = rand.nextInt(16) + 50;
                enemyStats[2] = rand.nextInt(6) + 10;
                enemyStats[3] = rand.nextInt(10) + 8;
                enemyStats[4] = rand.nextInt(10) + 6;
                enemyStats[5] = rand.nextInt(10) + 6;
                enemyStats[6] = rand.nextInt(10) + 6;
                enemyStats[7] = rand.nextInt(10) + 6;
                break;
            case 2:
                enemyStats[1] = rand.nextInt(21) + 50;
                enemyStats[2] = rand.nextInt(8) + 10;
                enemyStats[3] = rand.nextInt(10) + 8;
                enemyStats[4] = rand.nextInt(10) + 6;
                enemyStats[5] = rand.nextInt(10) + 6;
                enemyStats[6] = rand.nextInt(10) + 6;
                enemyStats[7] = rand.nextInt(10) + 6;
                break;
            case 3:
                enemyStats[1] = rand.nextInt(26) + 50;
                enemyStats[2] = rand.nextInt(10) + 10;
                enemyStats[3] = rand.nextInt(10) + 8;
                enemyStats[4] = rand.nextInt(10) + 6;
                enemyStats[5] = rand.nextInt(10) + 6;
                enemyStats[6] = rand.nextInt(10) + 6;
                enemyStats[7] = rand.nextInt(10) + 6;
                break;
            case 4:
                enemyStats[1] = rand.nextInt(31) + 50;
                enemyStats[2] = rand.nextInt(12) + 10;
                enemyStats[3] = rand.nextInt(10) + 8;
                enemyStats[4] = rand.nextInt(10) + 6;
                enemyStats[5] = rand.nextInt(10) + 6;
                enemyStats[6] = rand.nextInt(10) + 6;
                enemyStats[7] = rand.nextInt(10) + 6;
                break;
            default:
                break;
        }
   }
   public void newEnemy3(int difficultyNum)
   {
       difficulty = difficultyNum;
       
        switch (difficultyNum) {
            case 1:
                enemyStats[1] = rand.nextInt(16) + 50;
                enemyStats[2] = rand.nextInt(6) + 10;
                enemyStats[3] = rand.nextInt(10) + 8;
                enemyStats[4] = rand.nextInt(10) + 6;
                enemyStats[5] = rand.nextInt(10) + 6;
                enemyStats[6] = rand.nextInt(10) + 6;
                enemyStats[7] = rand.nextInt(10) + 6;
                break;
            case 2:
                enemyStats[1] = rand.nextInt(21) + 50;
                enemyStats[2] = rand.nextInt(8) + 10;
                enemyStats[3] = rand.nextInt(10) + 8;
                enemyStats[4] = rand.nextInt(10) + 6;
                enemyStats[5] = rand.nextInt(10) + 6;
                enemyStats[6] = rand.nextInt(10) + 6;
                enemyStats[7] = rand.nextInt(10) + 6;
                break;
            case 3:
                enemyStats[1] = rand.nextInt(26) + 50;
                enemyStats[2] = rand.nextInt(10) + 10;
                enemyStats[3] = rand.nextInt(10) + 8;
                enemyStats[4] = rand.nextInt(10) + 6;
                enemyStats[5] = rand.nextInt(10) + 6;
                enemyStats[6] = rand.nextInt(10) + 6;
                enemyStats[7] = rand.nextInt(10) + 6;
                break;
            case 4:
                enemyStats[1] = rand.nextInt(31) + 50;
                enemyStats[2] = rand.nextInt(12) + 10;
                enemyStats[3] = rand.nextInt(10) + 8;
                enemyStats[4] = rand.nextInt(10) + 6;
                enemyStats[5] = rand.nextInt(10) + 6;
                enemyStats[6] = rand.nextInt(10) + 6;
                enemyStats[7] = rand.nextInt(10) + 6;
                break;
            default:
                break;
        }
   }
   public void newEnemy4(int difficultyNum)
   {
       difficulty = difficultyNum;
       
        switch (difficultyNum) {
            case 1:
                enemyStats[1] = rand.nextInt(16) + 50;
                enemyStats[2] = rand.nextInt(6) + 10;
                enemyStats[3] = rand.nextInt(10) + 8;
                enemyStats[4] = rand.nextInt(10) + 6;
                enemyStats[5] = rand.nextInt(10) + 6;
                enemyStats[6] = rand.nextInt(10) + 6;
                enemyStats[7] = rand.nextInt(10) + 6;
                break;
            case 2:
                enemyStats[1] = rand.nextInt(21) + 50;
                enemyStats[2] = rand.nextInt(8) + 10;
                enemyStats[3] = rand.nextInt(10) + 8;
                enemyStats[4] = rand.nextInt(10) + 6;
                enemyStats[5] = rand.nextInt(10) + 6;
                enemyStats[6] = rand.nextInt(10) + 6;
                enemyStats[7] = rand.nextInt(10) + 6;
                break;
            case 3:
                enemyStats[1] = rand.nextInt(26) + 50;
                enemyStats[2] = rand.nextInt(10) + 10;
                enemyStats[3] = rand.nextInt(10) + 8;
                enemyStats[4] = rand.nextInt(10) + 6;
                enemyStats[5] = rand.nextInt(10) + 6;
                enemyStats[6] = rand.nextInt(10) + 6;
                enemyStats[7] = rand.nextInt(10) + 6;
                break;
            case 4:
                enemyStats[1] = rand.nextInt(31) + 50;
                enemyStats[2] = rand.nextInt(12) + 10;
                enemyStats[3] = rand.nextInt(10) + 8;
                enemyStats[4] = rand.nextInt(10) + 6;
                enemyStats[5] = rand.nextInt(10) + 6;
                enemyStats[6] = rand.nextInt(10) + 6;
                enemyStats[7] = rand.nextInt(10) + 6;
                break;
            default:
                break;
        }
   }
   
   public int bossOneSkills(int skillUse, int pDEX, int pSTR, int pCON, int eSTR)
   {
       int Bdmg = 0;
       String choice;
       switch (skillUse)
       {
           case 0:
               System.out.println("\n\tBig Boi enrages himself and charges straight toward you!");
               if(rand.nextInt(pDEX)>7)
               {
                   System.out.println("\n\tYou managed to dodge his charge attack!");
               }
               else
               {
                   Bdmg = rand.nextInt(eSTR) + (eSTR/2);
                   System.out.println("\n\tBig Boi slams you and knocks you down! You took " + Bdmg + " damage!");
               }
               break;
           case 1:
               System.out.println("\n\tBig Boi looks like he's going for a powerful swing, looks risky to try dodging, but the choice is yours.\n\n\t"
                       + "Do you   1. Shield yourself from the attack    2. Take a risk and try dodging    (type 1 or 2 for decision)");
               while(true)
               {
                   choice = scan.nextLine();
                   if(choice.equals("1"))
                   {
                       Bdmg = ((rand.nextInt(eSTR) + (eSTR/2))*3) - pSTR - pCON;
                       System.out.println("\n\tYou shield youself from his powerful blow, but still take " + Bdmg + " damage!");
                       break;
                   }
                   else if(choice.equals("2"))
                   {
                       if(rand.nextInt(pDEX)>7)
                        {
                            System.out.println("\n\tYou managed to dodge his charge attack!");
                        }
                       else
                       {
                           Bdmg = ((rand.nextInt(eSTR) + (eSTR/2))*3);
                           System.out.println("\n\tYou couldn't dodge his attack! You took " + Bdmg + " damage!");
                       }
                       break;
                   }
               }
               break;
       }
       return Bdmg;
   }
   
   public int bossTwoSkills(int skillUse, int pSTR, int pCON, int pINT, int pCHA, int eSTR, int eINT)
   {
       int Bdmg = 0;
       String choice;
       switch (skillUse)
       {
           case 0:
               System.out.println("\n\tHacker Girl whips out her laptop and starts to furiously type on the keyboard! You try to figure out what she's doing!");
               if(rand.nextInt(pINT)>7)
               {
                   System.out.println("\n\tYou were smart enough to realize that she is just furiously typing nothing but incoherent letters! You tell her as such and she just glares at you before putting her laptop away.");
               }
               else
               {
                   Bdmg = ((rand.nextInt(eSTR) + (eINT/2))*3);
                   System.out.println("\n\tYou can't figure out what she's doing! She laughs at you and says \"Ha! Your puny brain is no match for my superior intellect!\". You are ashamed and take " + Bdmg + " damage due to your humiliation!");
               }
               break;
           case 1:
               System.out.println("\n\tHacker Girl stares at a tree with an odd sense of purpose. Soon you realize that she is hacking into the world itself! You can't believe what you're seeing and rationalize that it shouldn't be possible unless you are in some sort of game! You need to try and stop her!\n\n\t"
                       + "Do you   1. Try to talk her out of doing anything.    2. Try to curl into a ball and defend yourself      3. Steel yourself for what she's about to do   (type 1, 2, or 3 for decision)");
               while(true)
               {
                   choice = scan.nextLine();
                   if(choice.equals("1"))
                   {
                       if(rand.nextInt(pCHA)>7)
                        {
                            System.out.println("\n\tYou were able to distract her enough for long enough that her hacking attempt fails! Whew!");
                        }
                       else
                       {
                           Bdmg = rand.nextInt(eSTR) + (eINT/2);
                           System.out.println("\n\tYour attempt to stall her fails! She is still able to complete her hack, but it seems to do a little less damage because of what you did. You took " + Bdmg + " damage!");
                       }
                       break;
                   }
                   else if(choice.equals("2"))
                   {
                       Bdmg = ((rand.nextInt(eSTR) + (eINT/2))*3) - pSTR - pCON;
                       System.out.println("\n\tYou curling into a ball seems to help you a bit with her changing your health value somehow, but you still take " + Bdmg + " damage!");
                       break;
                   }
                   else if(choice.equals("3")){
                       if(rand.nextInt(pCON)>7 && rand.nextInt(pSTR)>7){
                           System.out.println("\n\tSomehow that managed to work! It seems like a miracle, but you don't take any damage!");
                       }
                       else{
                           Bdmg = ((rand.nextInt(eSTR) + (eINT/2))*3);
                           System.out.println("\n\tYou just stand there uselessly. What did you think would happen? You took " + Bdmg + " damage since you allowed her to hack away your health!");
                       }
                   }
                   else
                       System.out.println("\n\tPlease choose a valid option!");
               }
               break;
       }
       return Bdmg;
   }
   
   public int bossThreeSkills(int skillUse, int pDEX, int pSTR, int pCON, int pCHA, int eSTR)
   {
       int Bdmg = 0;
       String choice;
       switch (skillUse)
       {
           case 0:
               System.out.println("The mob of girls appear to start hysterically crying! What will you do? \n\n\t" + 
                       "1. Try to calm them down!   2. Try to take this opportunity to attack them!     (type 1 or 2 for decision)");
               while(true)
               {
                   choice = scan.nextLine();
                   if(choice.equals("1"))
                   {
                       if(rand.nextInt(pCHA)>7)
                        {
                            System.out.println("\n\tYou were able to calm down the girls! That was weird.");
                        }
                       else
                       {
                           Bdmg = rand.nextInt(eSTR) + (eSTR/2);
                           System.out.println("\n\tYou couldn't calm them down, though they appreciate the effort! They stare at you with their tear-filled eyes and you feel extremely uncomfortable. You took " + Bdmg + " damage!");
                       }
                       break;
                   }
                   else if(choice.equals("2"))
                   {
                       Bdmg = ((rand.nextInt(eSTR) + (eSTR/2))*3);
                       System.out.println("\n\tWow, that's rude. They simply dismiss your attack as it appears that they were charging a powerful spell this whole time!  You took " + Bdmg + " damage!");
                   }
                   else
                       System.out.println("\n\tPlease choose a valid option!");
               }
               break;
           case 1:
               System.out.println("The weird children appear to be combining together to make one huge monstrosity! Children nowadays. How do you react? \n\n\t" + 
                       "1. Take a defensive stance!     2. Try to bring the beast down before it fully metamorphosizes!     3. Gawk at how ugly it is!      (type 1, 2, or 3 for decision)");
               while(true)
               {
                   choice = scan.nextLine();
                   if(choice.equals("1"))
                   {
                       Bdmg = ((rand.nextInt(eSTR) + (eSTR/2))*3) - pSTR - pCON;
                       System.out.println("\n\tYou have enough time to take a defensive stance and shield yourself from a powerful blow from their now huge fist, but still take " + Bdmg + " damage! They fall back out into individual girls after they hit you.");
                       break;
                   }
                   else if(choice.equals("2"))
                   {
                       if(rand.nextInt(pDEX)>8){
                           System.out.println("\n\tYou are able to reach out and pull back one of the girls in time! This interrupts their transformation and they all fall back!");
                       }
                       else{
                           Bdmg = ((rand.nextInt(eSTR) + (eSTR/2))*3);
                           System.out.println("\n\tYou aren't quick enough to stop them from transforming! They kick you away as hard as they can in their enlargened state before returning to their original individual children selves. You took " + Bdmg + " damage!");
                       }
                   }
                   else if(choice.equals("3"))
                   {
                       Bdmg = ((rand.nextInt(eSTR) + (eSTR/2))*4);
                       System.out.println("\n\tThat's really mean, they're just trying to live their abnormal lives you meanie! Once they fully transform, they see how you're looking at them and scream at you! They bring their now mighty fist down for one attack before all falling out back into their original formation. You took " + Bdmg + " damage!");
                   }
                   else
                       System.out.println("\n\tPlease choose a valid option!");
               }
               break;
       }
       return Bdmg;
   }
   
   public int bossFourSkills()
   {
       int Bdmg = 0;
       
       return Bdmg;
   }
}
