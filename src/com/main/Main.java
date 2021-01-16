package com.main;
import com.option.Choice;
import com.game.*;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		menuCreater();
		Player p1 = new Player( "Lucifer", 100, 100 );
		ArrayList<Monster> monsters = new ArrayList<Monster>();
		monsters.add( new Monster( "zombie", 50, 50 ));
		monsters.add( new Monster( "zombie", 50, 50 ));
		monsters.add( new Monster( "zombie boss", 150, 50 ));

		/////////////////////////////////////////////////////
		/////////////// print current status ////////////////
		/////////////////////////////////////////////////////
		p1.printAll();
		for( Monster m : monsters )
			m.printAll();
		while( !p1.isDead() ) {
			

			/////////////////////////////////////////////////////
			/////////////////// Player's move ///////////////////
			/////////////////////////////////////////////////////
			int opt = playerMenu.getInt();
			switch( opt ) {
			case 1:
				int choice = target.getInt();
				if( choice > monsters.size() ) {
					System.out.println( "Wrong move..." );
					break;
				}
				monsters.get( choice - 1 ).decreaseHealth(p1.attack());
				break;
			case 2:
				p1.recoverEnergy();
			case 3:
				break;
			default:
				System.out.println("Wrong choice");
			}
			if( opt == 3 )
				break;
			
			

			/////////////////////////////////////////////////////
			///////////////// monster's chance //////////////////
			/////////////////////////////////////////////////////
			for( Monster m: monsters) {
				if( m.hasEnergy() && !m.isDead()) 
					p1.decreaseHealth(m.attack());
				else if( !m.isDead() )
					m.recoverEnergy();
			}
			/////////////////////////////////////////////////////
			/////////////// print current status ////////////////
			/////////////////////////////////////////////////////
			boolean didWin = false;
			for( Monster m: monsters) {
				if( !m.isDead() ) {
					didWin = false;
					break;
				}
				else
					didWin = true;
			}
			if( didWin ) {
				System.out.println( "Victoryyyy......" );
				break;
			}
			p1.printAll();
			for( Monster m : monsters )
				m.printAll();
			
			
		}
		System.out.println( "game over..");
	}
	public static void menuCreater() {
		playerMenu.add("1: attack");
		playerMenu.add("2: gain energy");
		playerMenu.add("3: exit");
		target.add("1:: Zombie 1");
		target.add("2:: Zombie 2");
		target.add("3:: Zombie boss");
	}
	public static Choice playerMenu = new Choice(); 
	public static Choice target = new Choice(1,"choose your target::");
}
