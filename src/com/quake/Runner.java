package com.quake;

import com.quake.weapons.DoubleBarelledShotgun;

public class Runner {

	public static void main(String[] args) {
		Player player1 = new Player("Kaushik");
		Player player2 = new Player("Sridhar");
		System.out.println(player1);
		System.out.println(player2);
		player1.addWeapon(new DoubleBarelledShotgun());
		player2.nextWeapon();
		System.out.println(player1);
		System.out.println(player2);

	}

}
