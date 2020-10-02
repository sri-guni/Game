package com.quake;

import java.util.ArrayList;
import java.util.List;

import com.quake.util.Position;
import com.quake.weapons.Axe;
import com.quake.weapons.Shotgun;
import com.quake.weapons.Weapon;

public class Player {
	private String name;
	private Weapon currentWeapon;
	private Position currentPosition;
	private List<Weapon> weaponStash;
	private int weaponIndex;
	private double healthPercentage;
	private double hitPercentage;
	private double armourPercentage;
	
	public Player() {
		this("Player-1");
	}
	
	public Player(String name) {
		this.name = name;
		weaponStash = new ArrayList<Weapon>();
		weaponStash.add(new Axe());
		weaponStash.add(new Shotgun());
		weaponIndex = 1;
		currentWeapon = weaponStash.get(weaponIndex);
		currentPosition = new Position(0,0);
		healthPercentage = 100;
	}
	
	public void fireWeapon() {
		currentWeapon.fire();
	}
	
	public void addWeapon(Weapon weapon) {
		if(!weaponStash.contains(weapon)) {
			weaponStash.add(weapon);
			weaponIndex++;
			currentWeapon = weaponStash.get(weaponIndex);
		}		
		
	}
	
	public Weapon nextWeapon() {
		weaponIndex++;
		
		if(weaponIndex >= weaponStash.size()) {
			weaponIndex = 0;
		}
		
		currentWeapon = weaponStash.get(weaponIndex);
		return currentWeapon;
	}
	
	public Weapon previousWeapon() {
		weaponIndex--;
		
		if(weaponIndex < 0) {
			weaponIndex = weaponStash.size() - 1;
		}
		
		currentWeapon = weaponStash.get(weaponIndex);
		return currentWeapon;
	}
	
	public Weapon selectWeapon(int index) {
		if(index < 0 || index >= weaponStash.size()) {
			return null;
		}
		
		weaponIndex = index;
		currentWeapon = weaponStash.get(weaponIndex);
		return currentWeapon;
	}
	
	@Override
	public String toString() {
		return "Player [name=" + name
				+ ",current weapon=" + currentWeapon.getClass().getName()
				+ ",current position=" + currentPosition
				+ ",weapon index=" + weaponIndex
				+ ",weapon stash[" + getWeaponStash() + "]"
				+ "]";
	}

	private String getWeaponStash() {
		StringBuilder weapons = new StringBuilder();
		for(Weapon weapon : weaponStash) {
			weapons.append(weapon.getClass().getName() + ",");
		}
		
		return weapons.toString();
	}

}
