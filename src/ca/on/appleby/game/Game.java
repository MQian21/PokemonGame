package ca.on.appleby.game;

import java.util.ArrayList;
import java.util.Scanner;

import ca.on.appleby.player.Player;
import ca.on.appleby.pokemon.Pokemon;

public class Game {

	public static void main(String[] args) {
		// Create an ArrayList object that will store all the Pokemons to randomly
		// choose from
		ArrayList<Pokemon> pokemonInv = new ArrayList<Pokemon>();
		Scanner scanner = new Scanner(System.in);
		String select = null;
		// Create a player object that will store all the player's information
		Player player1 = new Player();

		Player player2 = new Player();

		String priorityPlayerName = null;
		
		// Welcoming Display
		System.out.println("\n");
		System.out.println("\t\t*****************************************************************");
		System.out.println("\t\t*              Welcome to the Pokemon Battle Grounds!!!         *");
		System.out.println("\t\t*                    Game made by: Michael Qian                 *");
		System.out.println("\t\t*****************************************************************");
		System.out.println("\n");
		

		// Stores all Pokemons in ArrayList pokemonInv
		pokemonInv = GameUtil.initializeGame();

		// User input for their name
		System.out.print("\t# Hello Player 1, Please enter your name:  ");
		select = scanner.nextLine();
		player1.setName(select);
		System.out.print("\n\t# Press enter when you're ready to see your 3 Pokemons:  ");
		select = scanner.nextLine();
		// Assigns each player 3 random Pokemons chosen from pokemonInv
		player1.setPokemonDeck(GameUtil.randomChoose(pokemonInv));
		GameUtil.displayPokemonInfoV2(player1,player1.getPokemonDeck());

		
		System.out.print("\n\t# Press enter to continue...: ");
		select = scanner.nextLine();
		
		System.out.print("\n\t# Hello Player 2, Please enter your name:  ");
		select = scanner.nextLine();
		player2.setName(select);
		System.out.print("\n\t# Press enter when you're ready to see your 3 Pokemons:  ");
		select = scanner.nextLine();
		// Assigns each player 3 random Pokemons chosen from pokemonInv
		player2.setPokemonDeck(GameUtil.randomChoose(pokemonInv));
		GameUtil.displayPokemonInfoV2(player2,player2.getPokemonDeck());
		
		System.out.print("\n\t# Press enter to continue...:");
		select = scanner.nextLine();

		// Variable used to exit out of the while loop if there is a winner
		boolean continueGame = true;
		int turn = 0;

		while (continueGame) {

			continueGame = GameUtil.choosePokemon(player1);
			
			System.out.println("\n\t# Press enter to continue...:");
			select = scanner.nextLine();

			if (!continueGame)
				break;

			// Player2 choose first pokemon

			continueGame = GameUtil.choosePokemon(player2);
			
			System.out.println("\n\t# Press enter to continue...:");
			select = scanner.nextLine();

			if (!continueGame)
				break;

			// Player1 choose attack mode
			GameUtil.chooseAttackDefenseMode(player1);

			// Player2 choose attack mode

			GameUtil.chooseAttackDefenseMode(player2);

			// Compare speed
			System.out.println("\n\n\t# Determining faster pokemon speed...");
			System.out.println("\n\t# Press enter to continue...:");
			select = scanner.nextLine();
			int compareSpeed = GameUtil.compareSpeed(player1.getActivePokemon(), player2.getActivePokemon());

			if (compareSpeed == 1) {
				priorityPlayerName = player1.getName();
				System.out.println("\t# " + player1.getName() + "'s pokemon is faster so he goes first!");
				
			} else {
				priorityPlayerName = player2.getName();
				System.out.println("\t# " + player2.getName() + "'s pokemon is faster so he goes first!");
			}

			// Determine which pokemon overpowers the other
			GameUtil.elementAdvantage(player1, player2);


			// Display fist attack for player with priority
			if (priorityPlayerName.equals(player1.getName())) {
				GameUtil.attack(player1, player2);
			} else if (priorityPlayerName.equals(player2.getName())) {
				GameUtil.attack(player2, player1);
			}
			
			// Remove dead Pokemon from player if getHealth less than or equal 0
			GameUtil.removeDeadPokemon(player1, player2);

			// Display attack for player without priority and if both active Pokemons are
			// still alive
			if (player1.getActivePokemon() != null && player2.getActivePokemon() != null) {
				if (priorityPlayerName.equals(player1.getName())) {
					GameUtil.attack(player2, player1);
				} else if (priorityPlayerName.equals(player2.getName())) {
					GameUtil.attack(player1, player2);
				}
			}
			
			// Remove dead Pokemon from player if getHealth less than or eaual 0
			GameUtil.removeDeadPokemon(player1, player2);
			turn++;
			System.out.println("\n\t# **Turn "+turn+" has ended!**");

			System.out.println("\n\t# Press enter to continue to next round...");
			select = scanner.nextLine();
		}
		// Display winner of the game
		System.out.println(GameUtil.determineWinner(player1, player2));

	}

}
