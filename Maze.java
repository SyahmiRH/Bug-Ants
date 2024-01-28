package bugants;

import java.awt.Image;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

public class Maze extends JPanel implements ActionListener{

	private Image tile, bug, ant, dirt;        // Image variable type
	private int noAnts, noBugs;               //Left Inside The Map
	private int[][] map1;                     //Temp variable for alternating the grass and dirt placement
	private boolean firstgenerate = false;      //Allow the random placement of dirt and grass only once
	Movement move;
	Board ABBoard;
  String[][] boardClone = Board.abBoard;                      //Represents the main board
	static private int[] randint = {1,2,3,4,5,6,7,8,9,10};      //Array for randomization int for random placement of dirt and grass

	public Maze() {
		checkNoOrganism();
		ImageIcon img = new ImageIcon("T.png");           //Locations for the images
		tile = img.getImage();
		img = new ImageIcon("Bug.png");
		bug = img.getImage();
		img = new ImageIcon("Ant.png");
		ant = img.getImage();
		img = new ImageIcon("D.png");
		dirt = img.getImage();
	}


	public Image getTile() {                    //Get grass
		return tile;
	}

	public Image getBug() {                     //get bug
		return bug;
	}

	public Image getAnt() {                    //Get ant
		return ant;
	}

	public Image getDirt()                     //get dirt
	{
		return dirt;
	}


 public int getNoAnts()                      //Get number of ants
 {
	 return noAnts;
 }

 public int getNoBugs()                       //Get number of bugs
 {
	 return noBugs;
 }



 public void checkNoOrganism()                      //Checking the number of organisms on the map
 {
	 noBugs = 0;
	 noAnts = 0;
	 for(int y=0; y<20; y++)
	 {
		 for(int x=0; x<20; x++)
		 {
			 if(boardClone[y][x] == "B")
			 {
				 noBugs = noBugs +1;
			 }
			 else if(boardClone[y][x] == "A")
			 {
				 noAnts = noAnts +1;
			 }
		 }
	 }
 }




	public void setMap()           // For Calculating randomization of Dirt and Grass Placement
	{
		if(firstgenerate==false)
		{
			map1 = new int [20][20];
			for(int y=0; y<20; y++)
			{
				for(int x=0; x<20; x++)
				{
					int rnd = new Random().nextInt(randint.length);
					map1[y][x]=randint[rnd];
				}
			}
		}
		firstgenera+te = true;                //Set variable to true to allow do once execution
	}

	public void actionPerformed(ActionEvent e) {

	}

	public void paint(Graphics g)
	{
		super.paint(g);
		boardClone = Board.abBoard;               //Set to the main board for accurate checking
		setMap();
		for (int y = 0; y < 20; y++) {
			for (int x = 0; x < 20; x++) {
				  if (boardClone[y][x]=="B")
					{
						if(map1[y][x]>=8)                // Put tile first and then bug
						{
							g.drawImage(getDirt(), x * 35, y * 35, 35, 35, null);
							g.drawImage(getBug(), x * 35, y * 35, 35, 35, null);
						}
						else
						{
							g.drawImage(getTile(), x * 35, y * 35, 35, 35, null);
							g.drawImage(getBug(), x * 35, y * 35, 35, 35, null);
						}
					}

					else if (boardClone[y][x]=="A")    // Put tile first and then ant
					{
						if(map1[y][x]>=8)
						{
							g.drawImage(getDirt(), x * 35, y * 35, 35, 35, null);
							g.drawImage(getAnt(), x * 35, y * 35, 35, 35, null);
						}
						else
						{
							g.drawImage(getTile(), x * 35, y * 35, 35, 35, null);
							g.drawImage(getAnt(), x * 35, y * 35, 35, 35, null);
						}

					}

					else
					{
						if(map1[y][x]>=8)           //Just put tile
						{
							g.drawImage(getDirt(), x * 35, y * 35, 35, 35, null);
						}
						else
						{
							g.drawImage(getTile(), x * 35, y * 35, 35, 35, null);
						}


					}

			}
		}
    checkNoOrganism();            //Calling check number of organism function

	}

}
