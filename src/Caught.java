
public class Caught 
{
	public static boolean caught(int oppLvl, int itemLvl)
	{
		int item = itemLvl;
		int opp = oppLvl;
		double c = 0;
		if(1<=opp && opp<=20)
		{
			double chance=0;
			switch(item)
			{
			case 1:
				chance = (-0.050581*opp*opp)-(0.375243*opp) + 81.4784;
				break;
			case 2:
				chance = (-0.050581*opp*opp)-(0.375243*opp) + 86.4784;
				break;
			case 3:
				chance = (-0.050581*opp*opp)-(0.375243*opp) + 91.4784;
				break;
			case 4:
				chance =(-0.050581*opp*opp)-(0.375243*opp) + 96.4784;
				break;
			}
			c = chance;
		}
		else if(21<=opp && opp<=40)
		{
			double chance=0;
			switch(item)
			{
			case 1:
				chance = (44-(0.5*(opp-21)*(opp-21)+(0.5*(opp-21))))/10;
				break;
			case 2:
				chance = (54-(0.5*(opp-21)*(opp-21)+(0.5*(opp-21))))/10;
				break;
			case 3:
				chance = (64-(0.5*(opp-21)*(opp-21)+(0.5*(opp-21))))/10;
				break;
			case 4:
				chance = (74-(0.5*(opp-21)*(opp-21)+(0.5*(opp-21))))/10;
				break;
			}
			c = chance;
		}
		else if(41<=opp && opp<=60)
		{
			double chance=0;
			switch(item)
			{
			case 1:
				chance = (76/3)-(0.5*(opp-41)*(opp-41)+0.5*(opp-41))/12;
				break;
			case 2:
				chance = (106/3)-(0.5*(opp-41)*(opp-41)+0.5*(opp-41))/12;
				break;
			case 3:
				chance = (136/3)-(0.5*(opp-41)*(opp-41)+0.5*(opp-41))/12;
				break;
			case 4:
				chance = (176/3)-(0.5*(opp-41)*(opp-41)+0.5*(opp-41))/12;
				break;
			}
			c = chance;
		}
		else if(61<=opp && opp<=100)
		{
			double chance=0;
			switch(item)
			{
			case 1:
				chance = 7-(((opp-61)*(opp-61))/100.0);
				break;
			case 2:
				chance = 17-(((opp-61)*(opp-61))/100.0);
				break;
			case 3:
				chance = 27-(((opp-61)*(opp-61))/100.0);
				break;
			case 4:
				chance = 37-(((opp-61)*(opp-61))/100.0);
				break;
			}
			c = chance;
		}
		double x = Math.random();
//		System.out.println(c/100 +" "+x);
		if(c/100>x)
			return true;
		else return false;
	}
}
