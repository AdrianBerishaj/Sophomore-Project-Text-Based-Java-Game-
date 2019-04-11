package hod_game;

import java.util.Random;

public class Enemy  
{
    String enemyType[] = {"Skeley boi", "Lesser Imp", "(crappy) Mage"};
    String enemyType2[] = {"Big mossy boi", "Colossal Forest Spider", "Forest Gremlin"};
    String enemyType3[] = {"Sp00ky boi", "Zambie", "Ball of Bones"};
    String enemyType4[] = {"(high tier) Mage", "(not so good) Angel", "Gigantic Fist boi"};
    int lvl, enemyHealth, enemyatt, damageDealt, str, dex, con, intel, wis, cha; ;
    Random rand = new Random();
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
   
   public void bossOneSkills()
   {
       
   }
   
   public void bossTwoSkills()
   {
       
   }
   
   public void bossThreeSkills()
   {
       
   }
   
   public void bossFourSkills()
   {
       
   }
   
}