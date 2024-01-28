package bugants;


import bugants.Board;
import bugants.Movement;
import java.util.Random;       //Import java standard library for randomization functionlity
import bugants.Bug;
import bugants.Ant;

public class CheckLocation
{
  private Board hboard;
  private int valx;                  //New location for x-axis
  private int valy;                     //New location for y-axis
  private int bugCounter;       // For Breeding
  private int antCounter;       // For Breeding
  private Movement mvBug;           //Instance for bug class
  private int[] randBreed = {1,2,3,4,5,6,7,8,9,10};  //Random percentage chance to breed
  private Movement mvAnt;           //Instance for ant class
  private int direction;                 //Direction that indicates the axis to move to
  public int[][] bugsLife =  new int[20][20];        //The bug's life array
  private String[][] cboard;                         //copy of the main board
  private int[][] mem =
  {
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
  };                                                   // Memory of the movement to avoid move twice per round
  private int[][] stepsCounter=
  {
    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},



  };                                                          //How many steps for organisms. 1 disallow new breeds to breed

  public CheckLocation()         //constructor
  {
    hboard =  new Board();
    mvBug  =  new Bug();
    mvAnt  =  new Ant();             //Inheritance that applies polymorphism
    cboard =  hboard.abBoard;
  }

  public void searchRandBug(int y, int x)          //Search random location to move for bug
  {
    direction = mvBug.getDirection(); //Getting a random direction
    switch(direction)
    {
      case 0:
          mvBug.moveLeft(y,x);
          break;
      case 1:
          mvBug.moveUp(y,x);
          break;
      case 2:
          mvBug.moveRight(y,x);
          break;
      case 3:
          mvBug.moveDown(y,x);
          break;
      default:
          mvBug.moveUp(y,x);
    }
    valx = mvBug.getlocx();             //Set new location by getting the values from the bug class
    valy = mvBug.getlocy();

    countSteps(valy,valx,y,x);           //Set counts for breeding
    checkCanBreed(valy,valx,y,x,"B");    //Check can breed or not
  }

  public void killBug()   // Function for starving bug
  {
    bugsLife= mvBug.getBugsLife();
    for(int y=0; y<20; y++)
    {
      for( int x=0; x<20; x++)
      {
        if(bugsLife[y][x]>3)
        {
          cboard[y][x]=" ";     //If the bug has not eaten any ants continuously for more than 3 steps it going to die
        }
      }
    }
  }


  public void checkCanBreed(int newy, int newx, int oldy, int oldx, String type)  //For Breeding check
  {
    int rnd = new Random().nextInt(randBreed.length);    // Percentage for breeding chance
    bugCounter = stepsCounter[newy][newx] % 9;                    //8+1 because steps start with 1
    antCounter = stepsCounter[newy][newx] % 4;                   //3+1 because steps start with 1
    if(bugCounter==0 && randBreed[rnd]>=1 && type=="B")   //80% chance to breed for bugs supposely >=3
    {
      bugBreeding(oldy,oldx);
    }
    if (antCounter==0 && randBreed[rnd]>=1 && type=="A")   //50% chance to breed for ants supposely >=6
    {
      antBreeding(oldy,oldx);
    }
  }

  public void bugBreeding(int y, int x)    //breeding function for bug
  {
    cboard[y][x]="B";
  }

  public void antBreeding(int y, int x)   //breeding function for ant
  {
     cboard[y][x]="A";
  }


  public void searchRandAnt(int y, int x)  //Search random location to move for ant
  {
    direction = mvAnt.getDirection();
    switch(direction)
    {
      case 0:
          mvAnt.moveLeft(y,x);
          break;
      case 1:
          mvAnt.moveUp(y,x);
          break;
      case 2:
          mvAnt.moveRight(y,x);
          break;
      case 3:
          mvAnt.moveDown(y,x);
          break;
      default:
          mvAnt.moveUp(y,x);
    }
    valx = mvAnt.getlocx();           //Set new location by getting the values from the ant class
    valy = mvAnt.getlocy();
    countSteps(valy,valx,y,x);               //Set counts for breeding
    checkCanBreed(valy,valx,y,x,"A");       //Check can breed or not

  }


  public void countSteps(int newy, int newx, int oldy, int oldx)   //Calculate for every organisms steps individually for breeding.
  {
    stepsCounter[newy][newx] = stepsCounter[oldy][oldx];
    if (newy==oldy && newx==oldx)
    {
      stepsCounter[newy][newx] = stepsCounter[newy][newx] + 1;
    }
    else
    {
      stepsCounter[oldy][oldx] = 1;
      stepsCounter[newy][newx] = stepsCounter[newy][newx] + 1;
    }

  }


  public void clearPrevLoc(int y, int x)
  {
    cboard[y][x]=" ";
  }

 public void resetMem()                        //Reset the memory for the movement
 {
   for(int i=0; i<20; i++)
   {
     for(int j=0; j<20; j++)
     {
       mem[i][j]=0;
     }
   }
 }



  public void checkmaptomove()              //Main function that has been execute from on clicked event
  {
    cboard = hboard.abBoard;
    for(int y=0; y<20; y++)
    {
      for (int x=0; x<20; x++)
      {
        if(cboard[y][x]=="B" && mem[y][x]==0)          //Move for bugs
        {
            searchRandBug(y,x);
            cboard[valy][valx]="B";
            mem[valy][valx]=1;

        }
        else if (cboard[y][x]=="A" && mem[y][x]==0)    //Move for ants
        {
            searchRandAnt(y,x);
            cboard[valy][valx]="A";
            mem[valy][valx]=1;
        }
      }
    }
    hboard.abBoard = cboard;
    killBug();                       //Killing the bug after board has been generated
    resetMem();                      //Reset the memory to avoid more than one movement for organims per round
  }


}
