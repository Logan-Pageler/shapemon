

public class AIMovement 
{
	private int direction = (int)(Math.random()*8);
	private int opponentX = 590;
	private int opponentY = 310;
	private int playerX = 130;
	private int playerY = 310;
	
	public void direction(int a)
	{
			switch(a)
			{
			case 0://up
				if(opponentY > 105) {
					opponentY-=5;
					direction = 0;
				}
				else {
					direction = 1;
				}
				break;
			case 1://down
				if(opponentY < 445) {
					opponentY+=5;
					direction = 1;	
				}
				else {
					direction = 0;
				}
				break;
			case 2://left
				if(opponentX > 360) {
					opponentX-=5;
					direction = 2;	
				}
				else {
					direction = 3;
				}
				break;
			case 3://right
				if(opponentX < 620) {
					opponentX+=5;
					direction = 3;	
				}
				else {
					direction = 2;
				}
				break;
			case 4://up and left
				if(opponentY > 105 && opponentX > 360) {
					opponentY-=5;
					opponentX-=5;
					direction = 4;
				}
				else {
					direction = 7;
				}
				break;
			case 5:// up and right
				if(opponentY > 105 && opponentX < 620) {
					opponentY-=5;
					opponentX+=5;
					direction = 5;	
				}
				else {
					direction = 6;
				}
				break;
			case 6://down and left
				if(opponentY < 445 && opponentX > 360) {
					opponentY+=5;
					opponentX-=5;
					direction = 6;	
				}
				else {
					direction = 5;
				}
				break;
			case 7://down and right
				if(opponentY < 445 && opponentX < 620) {
					opponentY+=5;
					opponentX+=5;
					direction = 7;
				}
				else {
					direction = 4;
				}
				break;
			default://stay
				direction = 8;
				break;
			}
	}
	public int changeDirection()
	{
		if(direction != 8)
		{
			int c = (int)(Math.random()*125);
			if(c<=116 && c>=0)//same
			{
				return direction;
			}
			else if(c==117)//up
				return 0;
			else if(c==118)//down
				return 1;
			else if(c==119)//left
				return 2;
			else if(c==120)//right
				return 3;
			else if(c==121)//up and left
				return 4;
			else if(c==122)//up and right
				return 5;
			else if(c==123)//down and left
				return 6;
			else if(c==124)//down and right
				return 7;
			else return 8;//stay
		}
		else
		{
			int c = (int)(Math.random()*32);
			if(7>=c && c<=0)//same
				return direction;
			else if(10>=c && c<=8)//up
				return 0;
			else if(13>=c && c<=11)//down
				return 1;
			else if(16>=c && c<=14)//left
				return 2;
			else if(19>=c && c<=17)//right
				return 3;
			else if(22>=c && c<=20)//up and left
				return 4;
			else if(25>=c && c<=23)//up and right
				return 5;
			else if(28>=c && c<=26)//down and left
				return 6;
			else if(31>=c && c<=29)//down and right
				return 7;
			else return 8;//same
		}
	}
	public int getX()
	{
		return opponentX;
	}
	
	public void setX(int x)
	{
		opponentX = x;
	}
	
	public int getY()
	{
		return opponentY;
	}
	 
	public void moveToPlayer()
	{
		int yDirection = (playerY-opponentY);
		if(yDirection>0)
		{
			int chance = (int)(Math.random()*3);
			switch(chance)
			{
			case 0://up
				direction = 0;
				break;
			case 1://up and left
				direction = 4;
				break;
			case 2://up and right
				direction = 5;
				break;
			}
		}
		else if(yDirection<0)
		{
			int chance = (int)(Math.random()*3);
			switch(chance)
			{
			case 0:
				direction = 1;//down
				break;
			case 1:
				direction = 6;//down and left
				break;
			case 2:
				direction = 7;//down and right
				break;
			}
		}
		else
		{
			int chance = (int)(Math.random()*2);
			switch(chance)
			{
			case 0:
				direction = 2;//left
				break;
			case 1:
				direction = 3;//right
				break;
			}
		}
	}
	public void reset() {
		direction = (int)(Math.random()*8);
		opponentX = 590;
		opponentY = 310;
		playerX = 130;
		playerY = 310;
	}
	
}
