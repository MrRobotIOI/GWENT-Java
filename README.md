# Gwent-Java
Description\n
My project is based on and implements some of the gameplay and mechanics from the GWENT mini-card game from the video game "The Witcher 3: The Wild
Hunt". 

What It Does
It uses Java AWT components to allow a user to select cards, choose the maximum amount of cards in a hand and play those cards. 
The played cards add to the score of their row. The total score of each row is shown on the leftmost side.

How To Use It
Run the GameBoard class
Select the number of cards that should be in a hand (4 or 8).

Select the cards for a hand from the list of cards and press shuffle and play.

The cards selected are shuffled before being added to the hand and there is no limit to how many you can pick
but the more you pick the less likely you are to get a specific card.

When the game starts there are 3 grey/white rectangles which are rows and they have a number beside them that indicated the total score of the row. 

There is also another number that shows the total score of the player.

A card can be played by left-clicking on it, right-clicking and dragging it to its designated row (indicated on the card as R1, R2 or R3),or
pressing the number keys (1,2,3..), the keys correspond to the order they appear when the game starts. The strength of each card is on the 

There is a special card called "Blue Stripes Commando" that has an "A" when it is drawn. When this card is played and there is another instance of it present
on the row then the strength of both card instances is doubled and added to the total. 

