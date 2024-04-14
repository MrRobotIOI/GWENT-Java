import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import java.util.ArrayList;
import java.util.Collections;


import javax.swing.ButtonGroup;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;



public class GameBoard extends JFrame  implements ActionListener, MouseMotionListener, MouseListener, KeyListener{
	private PlayMode playMode;
	private DechPhase dechPhase;
	private JRadioButton opt1;
	private JRadioButton opt2;
	private ButtonGroup grp;
	private JButton row1Ref;
	private JButton row2Ref;
	private JButton row3Ref;
	private JButton playRow;
	private int score1;
	private int score2;
	private int score3;
	private int scoreTotal;
	private JList cards ;
	private boolean handSizePicked;
	private int handSize;
	private Container pane;
	private boolean initialPhase = true;
	private ArrayList <Card> allCards;
	private ArrayList <JButton> buttonRefs;
	private ArrayList <UnitCard> row1;
	private ArrayList <UnitCard> row2;
	private ArrayList <UnitCard> row3;
	
	GameBoard(){
		this.score1 = 0;
		this.score2 = 0;
		this.score3 = 0;
		
		
		row1 = new ArrayList<>();
		row2 = new ArrayList<>();
		row3 = new ArrayList<>();
		
		this.buttonRefs = new ArrayList<>();
		this.playMode = new PlayMode();
		this.playMode.setBackground(Color.DARK_GRAY);
		this.playMode.setPreferredSize(new Dimension(600, 680));

		this.dechPhase = new DechPhase();
		this.dechPhase.setBackground(Color.DARK_GRAY);
		this.dechPhase.setPreferredSize(new Dimension(600, 680));
		
		 pane = this.getContentPane();
		
		//pane.add(this.status, BorderLayout.SOUTH);
		this.setContentPane(pane);

			allCards = new ArrayList<>();
			JLabel handSize = new JLabel("Size of player hand");
			handSize.setForeground(Color.white);
			handSize.setBounds(0, 0, 150, 20);
			 opt1 = new JRadioButton("4");
			opt1.setBounds(0, 20, 70, 20);
			opt1.addActionListener(this);
			opt1.setActionCommand("s");
			 opt2 = new JRadioButton("8");
			opt2.addActionListener(this);
			opt2.setActionCommand("s");
			opt2.setBounds(0, 50, 70, 20);
			pane.add(handSize);
			 grp = new ButtonGroup();
			grp.add(opt1);
			grp.add(opt2);
			pane.add(opt1);
			pane.add(opt2);
			String[] cardNames = {"Geralt","Blue Stripes Commando","Blue Stripes Commando","Poor Infantry","Poor Infantry","Poor Infantry","Dol Blathanna Scout","Siegfried of Denesle","Catapult","Catapult","Dethmold","Dun Banner Medic","Dun Banner Medic","Ballista","Ballista"};
			 cards = new JList(cardNames);
			JButton shuffle = new JButton("SHUFFLE AND PLAY");
			shuffle.setActionCommand("shuffle");
			shuffle.setBounds(300, 200, 200, 40);
			shuffle.addActionListener(this);
			pane.add(shuffle);
			cards.setBounds(0, 110, 200, 500);
			JLabel listLabel = new JLabel("Choose cards from deck: ");
			listLabel.setForeground(Color.WHITE);
			listLabel.setBounds(0, 90, 200, 10);
			pane.add(listLabel);
		pane.add(cards);
		
			pane.add(this.dechPhase, BorderLayout.CENTER);
		
	
		this.setTitle("Game Board");
		this.setSize(850, 650);
		this.setResizable(true); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	private class PlayMode extends JPanel{
		
		
		public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(143, 143, 143));
		if(!initialPhase) {
			g2d.fillRect(160, 20, 600, 120);
			g2d.fillRect(160, 150, 600, 120);
			g2d.fillRect(160, 280, 600, 120);
			 g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				        RenderingHints.VALUE_ANTIALIAS_ON);
			 
			 g2d.setFont(new Font(g2d.getFont().getName(), g2d.getFont().getStyle(), 20));
			 g2d.drawString(Integer.toString(score1) ,130,80); 
			 g2d.drawString(Integer.toString(score2) ,130,220); 
			 g2d.drawString(Integer.toString(score3) ,130,340); 
			 scoreTotal = score1+score2+score3;
			 g2d.setFont(new Font(g2d.getFont().getName(), g2d.getFont().getStyle(), 26));
			 g2d.drawString(Integer.toString(scoreTotal) ,50,220); 
			 g2d.setRenderingHint(
				        RenderingHints.KEY_TEXT_ANTIALIASING,
				        RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
		g2d.dispose();
		}
		
		else {
			
		}
			
			}

	

		
	}

	private class DechPhase extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(new Color(143, 143, 143));
		}
		
	}
	private class CardButton extends JButton {
		public Card card;
		public int cardx;
		public int cardy;
		
		public CardButton(Card card) {
			this.card = card;
		
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			this.paintBorder(g);
			this.setBackground(new Color(1f,0f,0f,.0f ));
			
			Graphics2D g2d = (Graphics2D) g;
		
			g2d.translate(-6.5, -7);
			
			card.draw(g2d);
			
			g2d.dispose();
			
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JRadioButton temp = null;
		switch (e.getActionCommand()) {
		case "s":
			handSizePicked = true;
			 temp = (JRadioButton) e.getSource();
			handSize = Integer.valueOf(temp.getText());
			System.out.println("Hand Size Setting: "+temp.getText());
			break;
		case "shuffle":
			if(!handSizePicked) {
				System.out.println("Must Pick Player Hand Size (4 or 8)");
				break;
			}
			int i = 0;
			while(i<cards.getSelectedValuesList().size()) {
			
					switch (cards.getSelectedValuesList().get(i).toString()) {
					case "Geralt":
						UnitCard card = new UnitCard(10, "Geralt",new Color(1f,0f,0f,.5f ),1);
						allCards.add(card);
						break;
					case "Poor Infantry":
						 card = new UnitCard(1, "Poor Infantry",Color.blue,1);
						allCards.add(card);
						break;
					case "Dol Blathanna Scout":
						 card = new UnitCard(6, "Dol Blathanna Scout",new Color(84, 133, 69),2);
							allCards.add(card);
						break;
					case "Siegfried of Denesle":
						 card = new UnitCard(10, "Siegfried of Denesle",Color.BLUE,1);
						allCards.add(card);
						break;
					case "Catapult":
						 card = new UnitCard(8, "Catapult",Color.BLUE,3);
						allCards.add(card);
						break;
					case "Dethmold":
						 card = new UnitCard(6, "Dethmold",Color.BLUE,2);
						allCards.add(card);
						break;
					case "Dun Banner Medic":
						 card = new UnitCard(6, "Dun Banner Medic",Color.BLUE,3);
						allCards.add(card);
						break;
					case "Ballista":
						 card = new UnitCard(6, "Ballista",Color.BLUE,3);
						allCards.add(card);
						break;
					case "Blue Stripes Commando":
						 card = new UnitCard(4, "Blue Stripes Commando",Color.BLUE,1);
						allCards.add(card);
						break;
					default:
						break;
					}
					i++;
			}
			 pane.removeAll();
			initialPhase = false;
			int xr1 = 160;
			Collections.shuffle(allCards);
			CardButton button;
			for(int a = 0; a<allCards.size(); a++) {
				if(a>= handSize)
					break;
				if(a != 0)
				xr1+=80;
				
				 button = new CardButton(allCards.get(a));
				 
				 button.setActionCommand(Integer.toString(a));
				 button.setBounds(xr1+8, 448, 83, 148);
				
			    button.addActionListener(this);
			    button.addMouseListener(this);
			    button.addMouseMotionListener(this);
				buttonRefs.add(button);
				
				
				pane.add(button);
			
				
				}
			 row1Ref = new JButton();
			 row1Ref.setBounds(160, 20, 600, 120);
			 row1Ref.setOpaque(false);
			 row1Ref.setContentAreaFilled(false);
			pane.add(row1Ref);
			
			 row2Ref = new JButton();
			 row2Ref.setBounds(160, 150, 600, 120);
			 row2Ref.setOpaque(false);
			 row2Ref.setContentAreaFilled(false);
			pane.add(row2Ref);
			
			 row3Ref = new JButton();
			 row3Ref.setBounds(160, 280, 600, 120);
			 row3Ref.setOpaque(false);
			 row3Ref.setContentAreaFilled(false);
			pane.add(row3Ref);
			
			pane.add(this.playMode, BorderLayout.CENTER);
		
			pane.addKeyListener(this);
			pane.requestFocus();

			    pane.revalidate();
			    pane.repaint();
			
			break;
	
		default:
			int index = Integer.valueOf(e.getActionCommand());
			if (e.getSource() instanceof CardButton ) {
				CardButton cardbutton =  (CardButton) e.getSource();
				switch (cardbutton.card.row) {
				case 1:
					playRow = row1Ref;
					break;
				case 2:
					playRow = row2Ref;
					break;
				case 3:
					playRow = row3Ref;
					break;
				default:
					break;
				}
			buttonRefs.get(index).setBounds(buttonRefs.get(index).getX(), playRow.getY(), buttonRefs.get(index).getWidth(), buttonRefs.get(index).getHeight());
		
				cardPlayed(cardbutton);
			
			
	
			 pane.repaint();
				pane.requestFocus();
			}
			break;
			
			
			
		}
		
		
		
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	
	
		GameBoard g = new GameBoard();
	}


	@Override
	public void mouseDragged(MouseEvent e) {
	
		// TODO Auto-generated method stub
		
		 if(playRow.getBounds().contains(e.getComponent().getParent().getMousePosition())) {
			
				e.getComponent().setBounds(e.getComponent().getParent().getMousePosition().x, playRow.getY(), e.getComponent().getWidth(), e.getComponent().getHeight());
		
				
				
				if (e.getSource() instanceof CardButton ) {
					CardButton cardbutton =  (CardButton) e.getSource();
					cardPlayed(cardbutton);
				}
				
			 }
			 else {
				 e.getComponent().setLocation(new Point(e.getComponent().getParent().getMousePosition()));
			 }
			 
			
			
			
	
		
			
	}

private void cardPlayed(CardButton cardbutton) {
	
	if(!cardbutton.card.onBoard) {
		int i;
		switch (cardbutton.card.row) {
		case 1:
			row1.add((UnitCard) cardbutton.card);
			((UnitCard) cardbutton.card).ability(row1);
			 i = 0;
			 this.score1 = 0;
			while (i< row1.size()) {
			
				
				this.score1 += this.row1.get(i).strength;
				i++;
			}
			i = 0;
			while (i< buttonRefs.size()) {
				buttonRefs.get(i).repaint();
				i++;
			}
			
		
			
			break;
		case 2:
			row2.add((UnitCard)cardbutton.card);
			this.score2 += cardbutton.card.strength;
			
			break;
		case 3:
			row3.add((UnitCard)cardbutton.card);
			this.score3 += cardbutton.card.strength;
			
			break;
		default:
			break;
		}
		this.playMode.repaint();
	cardbutton.card.onBoard = true;
	cardbutton.card.borderColor = Color.RED;
	cardbutton.repaint();
	}
}


	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() instanceof CardButton ) {
			CardButton cardbutton =  (CardButton) e.getSource();
			switch (cardbutton.card.row) {
			case 1:
				playRow = row1Ref;
				break;
			case 2:
				playRow = row2Ref;
				break;
			case 3:
				playRow = row3Ref;
				break;
			default:
				break;
			}
		
		}
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
		/* if(row1Ref.contains(e.getComponent().getParent().getMousePosition())) {
			e.getComponent().setBounds(e.getComponent().getParent().getMousePosition().x, row1Ref.getY(), e.getComponent().getWidth(), e.getComponent().getHeight());
			e.getComponent().setEnabled(false);
		
		 }
		 else {
			 e.getComponent().setLocation(new Point(e.getComponent().getParent().getMousePosition()));
		 }
		 
		 e.getComponent().getParent().repaint();
		*/ 
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		char typed = e.getKeyChar();
		if (Character.isDigit(typed) ) {
			int index = (typed - '0')-1;
			CardButton cardbutton =  (CardButton)buttonRefs.get(index);
			switch (cardbutton.card.row) {
			case 1:
				playRow = row1Ref;
				break;
			case 2:
				playRow = row2Ref;
				break;
			case 3:
				playRow = row3Ref;
				break;
			default:
				break;
			}
			if(index < buttonRefs.size() && index >= 0)
			{
			
			buttonRefs.get(index).setBounds(buttonRefs.get(index).getX(), playRow.getY(), buttonRefs.get(index).getWidth(), buttonRefs.get(index).getHeight());
		//	buttonRefs.get(index).setEnabled(false);
			
			cardPlayed(cardbutton);
			
			
			 pane.repaint();
			}
		}
		   
			
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}





	




	





}
