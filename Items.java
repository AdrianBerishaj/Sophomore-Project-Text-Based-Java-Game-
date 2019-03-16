package hod_game;

import java.util.Arrays;


public class Items<E>
{ 
   private String name;
   private int type; //type 1 = weapon, type 2 = armor, type 3 = consumable
   private int ADD_hp, ADD_str, ADD_dex, ADD_con, ADD_int, ADD_wis, ADD_cha, SUB_hp, SUB_str, SUB_dex, SUB_con, SUB_int, SUB_wis, SUB_cha;
   private int[] ADDstats = new int[]{ADD_hp, ADD_str, ADD_dex, ADD_con, ADD_int, ADD_wis, ADD_cha};
   private int[] SUBstats = new int[]{SUB_hp, SUB_str, SUB_dex, SUB_con, SUB_int, SUB_wis, SUB_cha};
  public Items(String Iname, int Ahp, int Astr, int Adex, int Acon, int Aint, int Awis, int Acha, int Shp, int Sstr, int Sdex, int Scon, int Sint, int Swis, int Scha , int Itype)
  {
      name = Iname;
      type = Itype;
      ADD_hp = Ahp;
      ADD_str = Astr;
      ADD_dex = Adex;
      ADD_con = Acon;
      ADD_int = Aint;
      ADD_wis = Awis;
      ADD_cha = Acha;
      SUB_hp = Shp;
      SUB_str = Sstr;
      SUB_dex = Sdex;
      SUB_con = Scon;
      SUB_int = Sint;
      SUB_wis = Swis;
      SUB_cha = Scha;
      
  }   
  public void getName()
  {
      System.out.println(name);
  }
  public void getType()
  {
      if(type == 1)
          System.out.println("weapon");
      if(type == 2)
          System.out.println("armor");
      if(type == 3)
          System.out.println("consumable");
  }
  public int[] ADDstats(int[] stats)
  {
     
     if(type == 1 || type == 2)
     {
        int[] new_stats = new int[]{stats[0], stats[1]+ADD_str-SUB_str, stats[2]+ADD_dex-SUB_dex, stats[3]+ADD_con-SUB_con, stats[4]+ADD_int-SUB_int, stats[5]+ADD_wis-SUB_wis, stats[6]+ADD_cha-SUB_cha};  
        return new_stats;
     }
     else
     {
         int[] new_stats = new int[]{stats[0]+ADD_hp-SUB_hp, stats[1]+ADD_str-SUB_str, stats[2]+ADD_dex-SUB_dex, stats[3]+ADD_con-SUB_con, stats[4]+ADD_int-SUB_int, stats[5]+ADD_wis-SUB_wis, stats[6]+ADD_cha-SUB_cha};
         return new_stats;
     }
  }
  public E[] ADDequipment(E[] equipment)
  {
      int full_slots = 0;
      E[] new_equipment = (E[]) new Object[equipment.length];   //create new object array to replace old (passed)
      
       System.arraycopy(equipment, 0, new_equipment, 0, new_equipment.length);  //make new array copy of old (passed) array (return passed array if array not null)
       
       for(int y = 0; y<new_equipment.length; y++)  //loop checks to see if equipment is already "full"
       {
           if(new_equipment[y]!=null)
           full_slots++;
       }
       
      if(full_slots==new_equipment.length-1)
      {
          System.out.println("\n\tYour equipment is full! cannot equip any more items!");
          return equipment;
      }
      
      for(int z = 0; z<new_equipment.length; z++)
      {
          if(new_equipment[z] == null)
          {
              new_equipment[z] = (E) this.name;
              break;
          }
          
      }
      //System.out.println(Arrays.toString(new_equipment));
      return new_equipment;
  }
}
