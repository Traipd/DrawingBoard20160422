package DrawingBoard20160422;

import java.awt.Graphics;
import java.util.Random;

public class sezi {
	
	
	public sezi(suijidian a,suijidian b,suijidian c,suijidian p){
		
	
			Random random=new Random();
			int i=random.nextInt(3);
			switch(i){
				case 0:  p.x=(a.x+p.x)/2;
				         p.y=(a.y+p.y)/2; 
					break;
				case 1:   p.x=(b.x+p.x)/2;
		         p.y=(b.y+p.y)/2;
					break;
				case 2:  p.x=(c.x+p.x)/2;
		         p.y=(c.y+p.y)/2;
					break;
			}
	}
}
