
package bugants;

import java.util.Random;               //Import java standard library for random generation numbers
import bugants.CheckLocation;

public class Movement
{
  private int x=0;                   //Just for return purposes
  private CheckLocation cj;
  private int y=0;                 //Just for return purposes
  private int[][] k;                 //Just for return purposes
  static private int[] randint = {0,1,2,3};   //Allow randomization numbers in the range


  public int getDirection()               //Generate random number from 0-3
  {
    int rnd = new Random().nextInt(randint.length);
    return randint[rnd];
  }


  public void moveUp(int y, int x)
  {

  }
  public void moveDown(int y, int x)
  {

  }
  public void moveLeft(int y, int x)
  {

  }
  public void moveRight(int y, int x)
  {

  }

  public int getlocx()
  {
    return x;
  }

  public int getlocy()
  {
    return y;
  }

  public void clearPrevLoc(int y, int x)          //Clear the previous location with tile
  {
    cj =  new CheckLocation();
    cj.clearPrevLoc(y,x);

  }

  public int[][] getBugsLife()                   //Represent the function that will be replace in bug class to return the number of bug's life each
  {
    return k;
  }




}
