package ca.on.appleby.game;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import ca.on.appleby.player.Player;
import ca.on.appleby.pokemon.Pokemon;
import ca.on.appleby.pokemon.PokemonEarth;
import ca.on.appleby.pokemon.PokemonFire;
import ca.on.appleby.pokemon.PokemonWater;

public class GameUtil {

	//Method that will create every possible pokemon and return in ArrayList
	public static ArrayList<Pokemon> initializeGame() {
		ArrayList<Pokemon> pokemonInv = new ArrayList<Pokemon>();
		
		//Store all pokemon stats
		String[][] pokemonStats = {
			      {"Earth","Pikachu", "50", "25", "3", "90"}, 
			      {"Earth","Eevee",  "40", "25", "4", "85"}, 
			      {"Earth","Snorlax", "85", "35", "8", "30"}, 
			      {"Earth","Lucario", "75", "40", "6", "70"}, 
			      {"Earth","Bulbasaur", "90", "35", "7", "50"},
			      {"Earth","Excadrill", "75", "30", "8", "40"}, 
			      {"Earth","Rhyperior", "90", "40", "7", "20"}, 
			      {"Fire","Charizard", "70", "30", "5", "70"}, 
			      {"Fire","Magmortar", "75", "20", "8", "60"}, 
			      {"Fire","Coalossal", "95", "40", "10", "10"}, 
			      {"Fire","Entei", "70", "20", "7", "70"}, 
			      {"Fire","Blaziken", "75", "20", "5", "65"}, 
			      {"Fire","Infernape", "50", "30", "6", "70"}, 
			      {"Fire","Turtonator", "85", "20", "7", "70"}, 
			      {"Water","Gyarados", "80", "20", "8", "80"}, 
			      {"Water","Blastoise", "80", "20", "9", "65"}, 
			      {"Water","Psyduck", "60", "20", "4", "80"}, 
			      {"Water","Magikarp", "40", "15", "2", "90"}, 
			      {"Water","Totodile", "75", "25", "5", "70"}, 
			      {"Water","Octillery", "60", "30", "6", "80"}, 
			      {"Water","Lotad", "60", "30", "3", "60"}, 
			};
		
		//Create new Pokemons based on stats listed above and load into array list
		for (int i = 0; i < pokemonStats.length; i++) {
			Pokemon pokemon = null;
			if (pokemonStats[i][0].equals("Earth")) {
				pokemon = new PokemonEarth();
				pokemon.setElementName(pokemonStats[i][0]);
				pokemon.setName(pokemonStats[i][1]);
				pokemon.setHealth(Integer.parseInt(pokemonStats[i][2]));
				pokemon.setDamage(Integer.parseInt(pokemonStats[i][3]));
				pokemon.setDefense(Integer.parseInt(pokemonStats[i][4]));
				pokemon.setSpeed(Integer.parseInt(pokemonStats[i][5]));
			}
			else if (pokemonStats[i][0].equals("Water")) {
				pokemon = new PokemonWater();
				pokemon.setElementName(pokemonStats[i][0]);
				pokemon.setName(pokemonStats[i][1]);
				pokemon.setHealth(Integer.parseInt(pokemonStats[i][2]));
				pokemon.setDamage(Integer.parseInt(pokemonStats[i][3]));
				pokemon.setDefense(Integer.parseInt(pokemonStats[i][4]));
				pokemon.setSpeed(Integer.parseInt(pokemonStats[i][5]));
			}
			else if (pokemonStats[i][0].equals("Fire")) {
				pokemon = new PokemonFire();
				pokemon.setElementName(pokemonStats[i][0]);
				pokemon.setName(pokemonStats[i][1]);
				pokemon.setHealth(Integer.parseInt(pokemonStats[i][2]));
				pokemon.setDamage(Integer.parseInt(pokemonStats[i][3]));
				pokemon.setDefense(Integer.parseInt(pokemonStats[i][4]));
				pokemon.setSpeed(Integer.parseInt(pokemonStats[i][5]));
			}
			
			pokemonInv.add(pokemon);

		}
		
		return pokemonInv;
	}
	
	
	// Method to display User Pokemon Stats
		public static void displayPokemonInfoV2(Player player,ArrayList<Pokemon> pokemonCards) {
			// Formatting
			System.out.println("\n");
			System.out.println("\t\t*****************************************************************");
			System.out.printf("\t\t%-20s%-44s%1s%n", "*", "Player "+ player.getName() + ": Pokemons","*");
			System.out.println("\t\t*****************************************************************");
			System.out.printf("\t%-18s%-18s%-18s%-18s%-18s%-18s%n", "Pokemon Name", "Element", "Health", "Damage", "Defense","Speed");
			System.out.printf("\t%-18s%-18s%-18s%-18s%-18s%-18s%n", "---------", "---------", "---------", "---------", "---------","---------");

			// Determine which class each pokemon is in
			for (int i = 0; i < pokemonCards.size(); i++) {
				String pokemonElement = null;
				if (pokemonCards.get(i) instanceof PokemonFire) {
					pokemonElement = "Fire";
				} else if (pokemonCards.get(i) instanceof PokemonWater) {
					pokemonElement = "Water";
				} else if (pokemonCards.get(i) instanceof PokemonEarth) {
					pokemonElement = "Earth";
				} else {
					pokemonElement = "Uknown";
				}
				System.out.printf("\t%-18s%-18s%-18s%-18s%-18s%-18s%n", pokemonCards.get(i).getName(),
						pokemonElement, pokemonCards.get(i).getHealth(), pokemonCards.get(i).getDamage(),
						pokemonCards.get(i).getDefense(), pokemonCards.get(i).getSpeed());
			}
			
		
		}
	
	
	
	
	// Method to display User Pokemon Stats
	public static void displayPokemonInfo(ArrayList<Pokemon> pokemonCards) {
		// Formatting
		System.out.print("\n");
		System.out.printf("%-18s%-18s%-18s%-18s%-18s%-18s%n", "Pokemon Name", "Element", "Health", "Damage", "Defense","Speed");
		System.out.printf("%-18s%-18s%-18s%-18s%-18s%-18s%n", "---------", "---------", "---------", "---------", "---------","---------");

		// Determine which class each pokemon is in
		for (int i = 0; i < pokemonCards.size(); i++) {
			String pokemonElement = null;
			if (pokemonCards.get(i) instanceof PokemonFire) {
				pokemonElement = "Fire";
			} else if (pokemonCards.get(i) instanceof PokemonWater) {
				pokemonElement = "Water";
			} else if (pokemonCards.get(i) instanceof PokemonEarth) {
				pokemonElement = "Earth";
			} else {
				pokemonElement = "Uknown";
			}
			System.out.printf("%-18s%-18s%-18s%-18s%-18s%-18s%n", pokemonCards.get(i).getName(),
					pokemonElement, pokemonCards.get(i).getHealth(), pokemonCards.get(i).getDamage(),
					pokemonCards.get(i).getDefense(), pokemonCards.get(i).getSpeed());
		}
		
	
	}
	
	// Method to display the active pokemon's stats and the special abilities it possesses 
	public static void showActivePokemonSpecialAbilities(Player player,Pokemon activePokemonCard) {

		//Special Ability Description for Water Pokemons
		if (activePokemonCard.getElementName().equals("Water")) {
			System.out.println(
					"\n\t# info: Special Attack (Drown): Deal an additional 10 damage if opponent's pokemon is below 30 health");
			System.out.println(
					"\t# info: Special Defense (Tidal Wave): 20 percent chance your pokemon will deflect opponent's pokemon attack, or else take an additional 5 damage");
		}
		//Special Ability Description for Fire Pokemons
		else if (activePokemonCard.getElementName().equals("Fire")) {
			System.out.println(
					"\n\t# info: Special Attack (Burn): Deal an additional 10 damage but the chance of having a successful attack is decreased to 60 percent ");
			System.out.println(
					"\t# info: Special Defense (Ring of fire): If your Pokemon dies on this turn, there's a 40 percent to deal a final 30 damage to your opponent's pokemon ");
		} 
		//Special Ability Description for Earth Pokemons
		else if (activePokemonCard.getElementName().equals("Earth")) {
			System.out.println(
					"\n\t# info: Special Attack (Shake up): 60 percent chance your pokemon's attack will remove all defense from opponent's pokemon for that turn. If not, you can't attack for that turn");
			System.out.println(
					"\n\t# info: Special Defense (Fortify): 30 percent chance your Pokemon's defense increases by 10 for that turn. If not, your pokemon loses all defense for that turn");
		}
	}

	//Method to determine which pokemon is faster
	public static int compareSpeed(Pokemon p1, Pokemon p2) {
		int compareValue = 0;
		if (p1.getSpeed()>p2.getSpeed()) {
			compareValue = 1;
		}
		else if (p1.getSpeed()<p2.getSpeed()) {
			compareValue = -1;
		}
		else {
			Random random = new Random();
			int chooser = random.nextInt(2);
			if (chooser==1) {
				compareValue = 1;
			}
			else {
				compareValue = -1;
			}
		}
		return compareValue;
	}
	
	
	// Method will be called when attack is performed by each player
	public static void calculateHealth(Pokemon attackPokemon, Pokemon defensePokemon) {
		// Possibility of a successful attack
		Random random = new Random();

		// Initial defensive Pokemon health
		int defenseHealth = defensePokemon.getHealth(); 
		
		
		//normal attack
		if (attackPokemon.getAttackMode().equals("normal")) {
			//normal attack with normal defense
			if (defensePokemon.getDefenseMode().equals("normal")) {
				//successful attack
				if (random.nextInt(100)<90) { 
					defenseHealth = defensePokemon.getHealth()-(attackPokemon.getDamage()-defensePokemon.getDefense());
					System.out.println("\t# " + attackPokemon.getName()+"'s attack was a success!");
				}
				//unsuccessful attack
				else {
					System.out.println("\t# " + attackPokemon.getName()+" has missed the target!");
				}
			} 
			// normal attack with special defense	
			else if (defensePokemon.getDefenseMode().equals("special")) {
				// special fire defense
				if (defensePokemon.getElementName().equals("fire")) {
					if (defensePokemon.getHealth()<attackPokemon.getDamage()&&random.nextInt(100)<40) {
						defenseHealth = defensePokemon.getHealth()-(attackPokemon.getDamage()-defensePokemon.getDefense());
						attackPokemon.setHealth(attackPokemon.getHealth()-40);
						System.out.println("\t# " + defensePokemon.getName()+" has successfully used its special defense!, 40 damage was done to the attacking pokemon!");
					}
					else {
						defenseHealth = defensePokemon.getHealth()-(attackPokemon.getDamage()-defensePokemon.getDefense());
						System.out.println("\t# " + defensePokemon.getName()+" failed to use its special defense");
					}
				}
				// special water defense
				else if(defensePokemon.getElementName().equals("water")) {
					if (random.nextInt(100)<20) {
						System.out.println("\t# " + defensePokemon.getName()+" successfully used its special defense! The attack was deflected!");
					}
					else {
						defenseHealth = defensePokemon.getHealth()-((attackPokemon.getDamage()+5)-defensePokemon.getDefense());
						System.out.println("\t# " + defensePokemon.getName()+" failed to use its special defense, an extra 5 damage was done to the defending pokemon!");
					}
				}
				// special earth defense
				else {
					if (random.nextInt(100)<30) {
						defenseHealth = defensePokemon.getHealth()-(attackPokemon.getDamage()-(defensePokemon.getDefense()+10));
						System.out.println("\t# " + defensePokemon.getName()+" successfully used its special defense! Defense was increased by 10 for this turn!");
					}
					else {
						defenseHealth = defensePokemon.getHealth()-attackPokemon.getDamage();
						System.out.println("\t# " + defensePokemon.getName()+" failed to use its special defense, defending Pokemon lost all defense for this turn!");
					}
				}
			}	
		} 
		//special attack
		else if (attackPokemon.getAttackMode().equals("special")) {
			//special attack with normal defense
			if (defensePokemon.getDefenseMode().equals("normal")) {
				//special fire attack
				if (attackPokemon.getElementName().equals("fire")) {
					if (random.nextInt(100)<60) {
						defenseHealth = defensePokemon.getHealth()-((attackPokemon.getDamage()+10)-defensePokemon.getDefense());
						System.out.println("\t# " + attackPokemon.getName()+" successfully used its special attack! Attack was increased by 10 for this turn!");
					}
					else {
						System.out.println("\t# " + attackPokemon.getName()+" failed to use its special attack, that attack missed the target!");
					}
				}
				//special water attack
				else if(attackPokemon.getElementName().equals("water")) {
					if (defensePokemon.getHealth()<30) {
						defenseHealth = defensePokemon.getHealth()-((attackPokemon.getDamage()+10)-defensePokemon.getDefense());
						System.out.println("\t# " + attackPokemon.getName()+" successfully used its special attack! An additional 10 damage was done!");
					}
					else {
						defenseHealth = defensePokemon.getHealth()-(attackPokemon.getDamage()-defensePokemon.getDefense());
						System.out.println("\t# " + attackPokemon.getName()+" failed to use its special attack, normal attack was used");
					}
				}
				//special earth attack
				else {
					if (random.nextInt(100)<60) {
						defenseHealth = defensePokemon.getHealth()-attackPokemon.getDamage();
						System.out.println("\t# " + attackPokemon.getName()+" successfully used its special attack! Defending Pokemon's defense is completly removed!");
					}
					else {
						System.out.println("\t# " + attackPokemon.getName()+" failed to use its special attack, attacking pokemon cannot attack this round");
					}
				}
			}

		}
		// set the defending pokemon's health to the variable "defenseHealth"
		defensePokemon.setHealth(defenseHealth);
	}
	
	// This will occur if a player uses special attack on a special defense.
	public static void elementAdvantage (Player player1, Player player2) {
		
		if (player1.getActivePokemon().getAttackMode().equals("special")&&player2.getActivePokemon().getDefenseMode().equals("special")) {
			determineOverpower(player1.getActivePokemon(), player2.getActivePokemon());
		}
		
		if (player2.getActivePokemon().getAttackMode().equals("special")&&player1.getActivePokemon().getDefenseMode().equals("special")) {
			determineOverpower(player2.getActivePokemon(), player1.getActivePokemon());
		}
	}

	// The method will cancel out and replace a player's special attack/defense with normal attack/defense based on the strength and weakness of a Pokemon's element
	public static void determineOverpower(Pokemon attackPokemon, Pokemon defensePokemon) {
		Random random = new Random();
		int pokemonAdvantage = 0;
		// Calls on the method from the subclasses of the abstract "Pokemon" class to compare elements
		pokemonAdvantage = attackPokemon.compareElement(defensePokemon);
		// If attacking pokemon's element has advantage of defending pokemon's element
		if (pokemonAdvantage==1) {
			defensePokemon.setDefenseMode("normal");
			System.out.println("\t# " + attackPokemon.getName() + "'s element overpowers "+defensePokemon.getName()+"'s element: "+defensePokemon.getName()+"'s special defense is now a normal defense!");
		}
		// If defending pokemon's element has advantage of attacking pokemon's element
		else if (pokemonAdvantage==-1) {
			attackPokemon.setAttackMode("normal");
			System.out.println("\t# " + defensePokemon.getName() + "'s element overpowers "+attackPokemon.getName()+"'s element: "+attackPokemon.getName()+"'s special attack is now a normal attack!");
		}
		// If attacking pokemon's element is the same as defending pokemon's element
		else {
			// 50-50 chance as to which pokemon will have their special ability cancelled out
			System.out.println("\t# " + "Both attacking and defending Pokemon's have the same element, a coin will be flipped to determe which pokemon will overpower the other...");
			if (random.nextInt(100)<50) {
				defensePokemon.setDefenseMode("normal");
				System.out.println("\t# " + attackPokemon.getName() + "'s element overpowers "+defensePokemon.getName()+"'s element: "+defensePokemon.getName()+"'s special defense is now a normal defense!");
			}
			else {
				attackPokemon.setAttackMode("normal");
				System.out.println("\t# " + defensePokemon.getName() + "'s element overpowers "+attackPokemon.getName()+"'s element: "+attackPokemon.getName()+"'s special attack is now a normal attack!");
			}
		}
	}
	
	// Method to ask user to choose their Pokemon
	public static boolean choosePokemon(Player player) {
		Scanner scanner = new Scanner(System.in);
		boolean continueGame = true;
		String select=null;
		boolean isFound = false;
		String reselect = "";
		String displayMsg = null;
		// Player will choose pokemon if he or she does not have an active pokemon
		if (player.getActivePokemon() == null) {
			// Player chooses first pokemon
			if (player.getPokemonDeck().size()==3) {
				displayMsg = ", please choose your first Pokemon: ";
			}
			// Game will stop if player has to choose a pokemon but his lineup is empty 
			else if(player.getPokemonDeck().size()==0) {
				continueGame = false;
			}
			// Player selects a pokemon
			else {
				displayMsg = ", please choose a Pokemon to replace your dead Pokemon: ";
			}
			// Ask the player which pokemon they would like to choose
			while (!isFound) {
				System.out.println("\n\t# Hi "+ player.getName()+ reselect + displayMsg);
				System.out.println("\n\t# Here are the pokemons in your lineup (excluding active pokemon)... ");
				displayPokemonInfoV2(player,player.getPokemonDeck());
				System.out.print("\n\t# Select: ");
				select = scanner.nextLine(); 
				isFound = player.selectPokemon(select);
				// Defensive coding
				if (!isFound) {
					reselect = ", sorry, this pokemon is invalid";
				}
			}
		}
		// Player will be given the option to switch their pokemon 
		else {
			// Unable to switch due to lack of cards
			if (player.getPokemonDeck().size()==0) {
				System.out.println("\n\t# Sorry"+player.getName()+", you can't switch Pokemons because you have no Pokemons left");
			}
			// Ask user if user want to switch Pokemons
			else {
				System.out.println("\n\t# Hi "+ player.getName()+", do you want to switch your Pokemon?(yes/no): ");
				System.out.println("\t# Here are the pokemons in your lineup (excluding active pokemon)... ");
				displayPokemonInfoV2(player,player.getPokemonDeck());
				System.out.print("\n\tSelect: ");
				select = scanner.nextLine(); 
				// If user wants to switch Pokemons
				if (select.equals("yes")) {
					isFound = false;
					while (!isFound) {
						displayMsg = ", please choose a Pokemon to switch: ";
						System.out.println("\n\t# Hi "+ player.getName()+ reselect + displayMsg);
						displayPokemonInfo(player.getPokemonDeck());
						System.out.print("\n\t# Select: ");
						select = scanner.nextLine(); 
						isFound = player.switchPokemon(select);
						if (!isFound) {
							reselect = ", Sorry, this pokemon is invalid";
						}
					}
				}
			}
		}

		
		System.out.println("\t# " + player.getName()+", You have chosen: "+ player.getActivePokemon().getName() + "!");
		return continueGame;
	}
	
	
	public static void attack(Player priorityPlayer, Player nonPriorityPlayer) {
		Scanner scanner = new Scanner(System.in);
		String select = null;

		System.out.println("\n\t# Press enter to continue to " + priorityPlayer.getName() + "'s attack");
		select = scanner.nextLine();
		System.out.println("\t# Attack is starting for " + priorityPlayer.getName() + "...");
		GameUtil.calculateHealth(priorityPlayer.getActivePokemon(), nonPriorityPlayer.getActivePokemon());
		System.out.println("\n\t# " + priorityPlayer.getActivePokemon().getName() + " health: "
				+ priorityPlayer.getActivePokemon().getHealth() + "\n\t# " + nonPriorityPlayer.getActivePokemon().getName()
				+ " health: " + nonPriorityPlayer.getActivePokemon().getHealth());
	}
	
	
	
	
	// Method to ask User to choose attack and defense mode
	public static void chooseAttackDefenseMode(Player player) {
		
		Scanner scanner = new Scanner(System.in);
		String select=null;
		String reselect = "";
		ArrayList<Pokemon> pokemonCards = new ArrayList<Pokemon>();
		pokemonCards.add(player.getActivePokemon());
		displayPokemonInfoV2(player,pokemonCards);
		showActivePokemonSpecialAbilities(player, player.getActivePokemon());
		boolean isValid = false;
		reselect = "";
		while (!isValid) {
			System.out.print("\n\t# Hi "+ player.getName()+ reselect+ ", please choose your Pokemon's attack mode(normal/special): ");
			select = scanner.nextLine();
			if (select.equals("normal")||select.equals("special")) {
				player.getActivePokemon().setAttackMode(select);
				isValid = true;
			}
			if (!isValid) {
				reselect = ", sorry, this pokemon attack mode is invalid";
			}
		}
		
		isValid = false;
		reselect = "";
		while (!isValid) {
			System.out.print("\t# Hi "+ player.getName()+ reselect+ ", please choose your Pokemon's defense mode(normal/special): ");
			select = scanner.nextLine();
			if (select.equals("normal")||select.equals("special")) {
				player.getActivePokemon().setDefenseMode(select);;
				isValid = true;
			}
			if (!isValid) {
				reselect = ", sorry, this pokemon defense mode is invalid";
			}
		}
		/*System.out.print("\n\t# "+player.getName() + ", You have chosen: " + player.getActivePokemon().getAttackMode()
				+ " attack and " + player.getActivePokemon().getDefenseMode() + " defense!");*/
		
		System.out.print("\n\t# "+player.getName() + ", You have chosen: attack [" + player.getActivePokemon().getAttackMode()
				+ "] , defense [" + player.getActivePokemon().getDefenseMode() + "]");
		
	}
	// Method that when called upon will choose 3 Pokemons from given ArrayList and store it in new ArrayList
	public static ArrayList<Pokemon> randomChoose(ArrayList<Pokemon> pokemonCard) {
		Random random = new Random();
		ArrayList<Pokemon> selectPokemon = new ArrayList<Pokemon>();
		for (int i = 0; i < 3; i++) {
			int chooser = random.nextInt(pokemonCard.size());
			selectPokemon.add(pokemonCard.get(chooser));
			pokemonCard.remove(chooser);
		}
		return selectPokemon;

	}
	// Method to determine winner
	public static String determineWinner (Player player1, Player player2) {
		String winner = null;
		if (player1.getActivePokemon()==null) {
			winner = player2.getName();
		}
		else {
			winner = player1.getName();
		}
		return "\n\n\t***Congratulations! "+ winner + " has won the game!***";
	}
	
	// Remove dead Pokemon from player 
	public static void removeDeadPokemon (Player player1, Player player2) {
		if (player1.getActivePokemon().getHealth()<=0) {
			System.out.println("\n\t# Hi "+player1.getName()+", " + player1.getActivePokemon().getName() + " is dead");
			player1.setActivePokemon(null);
		}
		else if (player2.getActivePokemon().getHealth()<=0) {
			System.out.println("\n\t# Hi "+player2.getName()+", " + player2.getActivePokemon().getName() + " is dead");
			player2.setActivePokemon(null);
		}
		
	}
	
}

