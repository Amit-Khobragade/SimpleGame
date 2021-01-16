package com.game;
import java.util.Random;

public class Player extends Character {
	public Player( String name, int health, int energy ){
		super( name, health, energy );
	}
	
	
	public int attack() {
		if( !super.canAttack() ) {
			return 0;
		}
		super.decreseEnergy( this.energyPerAttack );
		Random num = new Random();
		return num.nextInt( this.attackStrength );
	}
	public void recoverEnergy() {
		super.recoverEnergy( this.recoveringCapacity );
		
	}
	
	
	private int energyPerAttack = 10;
	private int recoveringCapacity = 20;
	private int attackStrength = 20;
}
