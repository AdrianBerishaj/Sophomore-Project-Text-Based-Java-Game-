package hod_game;


public class Area<E> 
{
    Area<E> forelink, backlink, player_pos;
    int data; //for list of encounter: 0 = nothing, 1 = enemy, 2 = exit

 public<E>  Area(int initialData, Area initialForeLink, Area initialBackLink) 
    {
        data = initialData;
        forelink = initialForeLink;
        backlink = initialBackLink;
        Area head;
        head = new Area(data, forelink, backlink);
        player_pos = head;
    }
 
 public<E> Area getForeLink() //traversing player forward one node
 {
     player_pos = forelink;
     return forelink;
 }
 
public<E> Area getBackLink() //traversing player back one node
 {
     player_pos = backlink;
     return backlink;
 }

public int getData() //getting encounter type number
{
    return data;
}

public<E> void addNodeAfter(int E_type) // encounter type
 {
        
     this.forelink = new Area(E_type, this.forelink, this);
 }
 
  public static<E> int listLength(Area head) //for testing purposes (Area length, encounter type in each area)
    {
        Area cursor;
        int answer = 0;
        for(cursor = head; cursor!=null; cursor = cursor.getForeLink())
            answer++;
       // System.out.println();
        //System.out.println(answer);
        return answer;
    }
 
 
 
 
}