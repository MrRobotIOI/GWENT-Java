import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class UnitCard extends Card implements AbilityInterface{
	
	private boolean hasAbility;
	private int counter;
	public UnitCard(int strength, String name, Color col, int row) {
		super();
		this.name = name;
		super.strength = strength;
		super.col = col;
		super.row = row;
		super.defaultStrength = strength;
		if(this.name.equals("Blue Stripes Commando")) {
			super.abilityDesc = "Tight Bonds";
			this.hasAbility = true;
		}
	
	}
	@Override
	public void ability(ArrayList<UnitCard> row) {
		// TODO Auto-generated method stub
		if(this.hasAbility) {
			this.counter = 0;
			int i = 0;
			while(i< row.size()) {
				if(row.get(i).name.equals(this.name)) {
			
					++counter;
					if(counter >=2 ) {
					
					int j = 0;
					while(j< row.size()) {
						if(row.get(j).name.equals(this.name))
						row.get(j).strength =row.get(j).defaultStrength * 2;
						j++;
					}
					System.out.println(this.name +" activated ability " +super.abilityDesc);
					
					}
				}
			
				i++;
			}
			counter = 0;
		}
		
	}
	public void draw(Graphics2D g) {
		super.draw(g);
		if(hasAbility) {
		Font stats2 = g.getFont().deriveFont((float) (this.CARDSIZE/8));
		g.setFont(stats2);
	
	g.setColor(Color.WHITE);
	g.drawString("A", this.CARDSIZE/10*2 - (this.CARDSIZE/10/8), this.CARDSIZE/10*8 + (this.CARDSIZE/10/2));
		}
	}




}
