import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.Icon;

public class Card{
	

	// CLASS FIELDS =======================================
	protected String name;
	protected int strength;
	protected int row;
	protected int defaultStrength;
	protected boolean onBoard;
	protected String abilityDesc;
	public int CARDSIZE;
	protected Color col;
	protected Color borderColor;
	
	
	
	public Card() {
		this.strength =0;
		this.name = "Empty";
		this.onBoard = false;
		this.row = 1;
		this.defaultStrength = this.strength;
		 this.borderColor = Color.orange;
		this.CARDSIZE = 80;
			
	}
	
	

	public String toString() {
		String cardType = "";
			switch (this.row) {
			case 1:
				cardType = "MeleeCard";
				break;
			case 2:
				cardType = "RangedCard";
				break;
			
			case 3:
				cardType = "SiegeCard";
				break;
			
			default:
				break;
			}

		String result = "";
		result 	= 	cardType+" \n";
		result 	+=	"\t[ Strength = " + this.strength + " ]\n";
		result  +=  "\t[ Name = " + (this.name +" ]\n");
		result  +=  "\t[ Ability = " + (this.abilityDesc +" ]\n");
		result  +=  "\t[ OnBoard = " + (this.onBoard +" ]\n");
		
		return result;


	}
	
	






	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub

          g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
          g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
          g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	
		g.setRenderingHint(
		        RenderingHints.KEY_TEXT_ANTIALIASING,
		        RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
		g.translate(0, 0);

		g.setColor(Color.black);
		
		g.fillRoundRect(this.CARDSIZE/10, this.CARDSIZE/10, this.CARDSIZE, this.CARDSIZE*2  -  this.CARDSIZE/5, this.CARDSIZE/10, this.CARDSIZE/10);
		g.setColor(Color.white);
		g.fillRect(this.CARDSIZE/10, this.CARDSIZE/10*15, this.CARDSIZE, (this.CARDSIZE*2)/5);
		
		g.setColor(this.col);
		g.fillRect(this.CARDSIZE/10*2 - (this.CARDSIZE/10/3), this.CARDSIZE/10, this.CARDSIZE/8, (this.CARDSIZE*2- this.CARDSIZE/2));
	
		
		
		g.setColor(borderColor);
		g.drawRoundRect(this.CARDSIZE/10, this.CARDSIZE/10*15, this.CARDSIZE, (this.CARDSIZE*2)/5,this.CARDSIZE/10,this.CARDSIZE/10);
		g.drawRoundRect(this.CARDSIZE/10, this.CARDSIZE/10, this.CARDSIZE, this.CARDSIZE*2 -  this.CARDSIZE/5,this.CARDSIZE/10,this.CARDSIZE/10);
		Font stats = g.getFont().deriveFont((float) (this.CARDSIZE/10));
		Font stats2 = g.getFont().deriveFont((float) (this.CARDSIZE/8));
		g.setFont(stats2);
		
		g.setColor(Color.white);
		g.drawString(Integer.toString(this.strength) , this.CARDSIZE/10*2 - (this.CARDSIZE/10/3), this.CARDSIZE/10*2 + (this.CARDSIZE/10/2));
		
		
		g.drawString("R"+Integer.toString(this.row) , this.CARDSIZE/10*2 - (this.CARDSIZE/10/3), this.CARDSIZE/10*5 + (this.CARDSIZE/10/2));
		g.setFont(stats);
		g.setColor(Color.black);
		g.drawString(this.name , this.CARDSIZE/10*4, this.CARDSIZE/10*13 + (this.CARDSIZE/4)+(this.CARDSIZE/20));
		
		/*if(this.ability != null) {
		
			g.setColor(Color.black);
			g.drawString(this.ability.substring(0, 1), this.CARDSIZE/10*2 - (this.CARDSIZE/10/8), this.CARDSIZE/10*8 + (this.CARDSIZE/10/2));
			
		}
		*/

	}

	public static void main(String[] args) {
		Card test = new Card();
		System.out.println(test.toString());
	}











}
