package com.game;
import java.util.ArrayList;
import java.util.List;

public class Character implements Savable{
	Character( String name, int health, int energy ){
		this.name = name;
		this.health = health;
		this.energy = energy;
	}
	@Override
	public List<String> save(){
		ArrayList<String> s = new ArrayList<String>( 3 );
		s.set( 0, this.name );
		s.set( 1, Integer.toString(this.health));
		s.set( 2, Integer.toString(this.energy));
		return s;
	}
	
	@Override
	public void load( List<String> l ) {
		this.name = l.get(0);
		this.health = Integer.parseInt(l.get(1));
		this.energy = Integer.parseInt(l.get(2));		
	}
	
	public void printAll() {
		System.out.println( "\n\n name::" + this.name );
		System.out.println( " health::" + this.health );
		System.out.println( " energy::" + this.energy );
	}
	
	public void decreaseHealth( int amount ) {
		if( amount < 0 ) 
			System.out.println( "Error:: invalid amount..");
		else if( amount == 0 ) 
			System.out.println( this.name + " didn't took damage");
		else if( this.health <= 0 )  
			System.out.println( this.name + " already dead");
		
		else if( this.health < amount ) { 
			System.out.println( this.name + ":: player dead");
			this.health = 0;
		}
		else
			this.health -= amount;
		
			
	}
	public boolean isDead() {
		return ( this.health <= 0 );
	}
	public String getName() {
		return this.name;
	}
	public boolean hasEnergy() {
		return ( this.energy > 0);
	}
	///////////////////////////////////////////////////////////
	///////////////// protected fields ////////////////////////
	///////////////////////////////////////////////////////////
	protected boolean canAttack() {
		if( this.isDead() ) {
			System.out.println( this.name + " cant attack :: status:: dead");
			return false;
		}
		if( this.energy <= 0 ) {
			System.out.println( this.name + " cant attack :: status:: energy over");
			return false;
		}
		return true;
	}
	protected void decreseEnergy( int amount ) {
		if( amount <= 0 ) 
			System.out.println( "Internal Error:: invalid amount..");
		
		else if( this.energy  < amount )  {
			System.out.println( this.name + " energy over");
			this.energy = 0;
		}
		else
			this.energy -= amount;
	}
	protected void recoverEnergy( int amount ) {
		if( amount <= 0 ) 
			System.out.println( "Error:: invalid amount..");
		
		else if( (this.energy + amount) > 100 )  {
			System.out.println( this.name + " energy Full");
			this.energy = 100;
		}
		else
			this.energy += amount;
	}
	
	
	///////////////////////////////////////////////////////////
	////////////////// private fields /////////////////////////
	///////////////////////////////////////////////////////////
	private String name;
	private int health;
	private int energy;
}
