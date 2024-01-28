package bugants;

import bugants.Board;  //import Board Class


public class Bug extends Movement
{

  	private int Ax;     //Represents the new x-axis
  	private int Ay;     //Represents the new y-axis
    private Board b;
    private String[][] str;    // The copy of board class var
    private int[][] life =
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
    };                                        //The location that represents the bug's life

    public Bug()              //Constructor
    {
      Ax=0;
      Ay=0;
      str = b.abBoard;
    }

    public void checkBugLife(int y, int x, boolean state)   //Checking the bug's life
    {                                                       //State is for the condition if the bugs eat anything
      if (state == true)
      {
        life[y][x] = 0;
        life[Ay][Ax] = 0;
      }
      else
      {
        life[Ay][Ax] = life[y][x];
        life[y][x] = 0;
        life[Ay][Ax] = life[Ay][Ax] + 1;
      }
    }

  	public void moveUp(int y, int x)
  	{
      str = b.abBoard;
  		 if(y-1>=0 && str[y-1][x]==" ")
  		 {
         Ay = y-1;
         Ax = x;
         super.clearPrevLoc(y,x);
         checkBugLife(y,x,false);
  		 }
       else if(y-1>=0 && str[y-1][x]=="A")
       {
         Ay = y-1;
         Ax = x;
         super.clearPrevLoc(y,x);
         checkBugLife(y,x,true);
       }
  		 else
  		 {
         Ay = y;
         Ax = x;
         checkBugLife(y,x,false);
  		 }
  	}

  	public void moveDown(int y, int x)
  	{
      str = b.abBoard;
  	  if(y+1<20 && str[y+1][x]==" ")
  	  {
        Ay = y+1;
  			Ax = x;
        super.clearPrevLoc(y,x);
        checkBugLife(y,x,false);
  	  }
      else if (y+1<20 && str[y+1][x]=="A")
      {
        Ay = y+1;
  			Ax = x;
        super.clearPrevLoc(y,x);
        checkBugLife(y,x,true);
      }
  	  else
  	  {
        Ay = y;
  			Ax = x;
        checkBugLife(y,x,false);
  	  }
  	}

  	public void moveLeft(int y, int x)
  	{
      str = b.abBoard;
  	  if(x-1>=0 && str[y][x-1]==" ")
  	  {
        Ay = y;
  	  	Ax = x-1;
        super.clearPrevLoc(y,x);
        checkBugLife(y,x,false);
  	  }
      else if (x-1>=0 && str[y][x-1]=="A")
      {
        Ay = y;
  	  	Ax = x-1;
        super.clearPrevLoc(y,x);
        checkBugLife(y,x,true);
      }
  	  else
  	  {
        Ay = y;
  	  	Ax = x;
        checkBugLife(y,x,false);
  	  }

  	}

  	public void moveRight(int y, int x)
  	{
      str = b.abBoard;
  		if(x+1<20 && str[y][x+1]==" " )
  	  {
        Ay = y;
  	  	Ax = x+1;
        super.clearPrevLoc(y,x);
        checkBugLife(y,x,false);
  	  }
      else if (x+1<20 && str[y][x+1]=="A")
      {
        y = y;
  	  	Ax = x+1;
        super.clearPrevLoc(y,x);
        checkBugLife(y,x,true);
      }
  	  else
  	  {
        Ay = y;
  	  	Ax = x;
        checkBugLife(y,x,false);
      }

  	}

    public int getlocx()
    {
      return Ax;
    }

    public int getlocy()
    {
      return Ay;
    }
    @Override
    public int[][] getBugsLife()            // Return the bug's life array
    {
      return life;
    }

}
