package bugants;

import bugants.Board;   //Importing the Board Class

public class Ant extends Movement
{

	private int Ax;     //Represents new x-axis
	private int Ay;     //Represents new y-axis
	private Board b;    // Instance of Board Class
	private String[][] str;   //Array that hole the same value as Board class array


  public Ant()
  {
    Ax=0;
    Ay=0;
		b = new Board();
		str = b.abBoard;
  }

	public void moveUp(int y, int x)   //When move up
	{
		str = b.abBoard;
		 if(y-1>=0 && str[y-1][x]==" ")
		 {
			 Ay = y-1;
			 Ax = x;
			 super.clearPrevLoc(y,x);
		 }
		 else
		 {
			 Ay = y;
			 Ax = x;

		 }
	}

	public void moveDown(int y, int x)    //When move down
	{
		str = b.abBoard;
	  if(y+1<20 && str[y+1][x]==" ")
	  {
			Ay = y+1;
			Ax = x;
			super.clearPrevLoc(y,x);

	  }
	  else
	  {
			Ay = y;
			Ax = x;
	  }
	}

	public void moveLeft(int y, int x)  //When move left
	{
		str = b.abBoard;
	  if(x-1>=0 && str[y][x-1]==" ")
	  {
			Ay = y;
	  	Ax = x-1;
			super.clearPrevLoc(y,x);

	  }
	  else
	  {
			Ay = y;
	  	Ax = x;
	  }

	}

	public void moveRight(int y, int x) //When move right
	{
		str = b.abBoard;
		if(x+1<20 && str[y][x+1]==" ")
	  {
			Ay = y;
	  	Ax = x+1;
			super.clearPrevLoc(y,x);
	  }
	  else
	  {
			Ay = y;
	  	Ax = x;
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


}
