package ca.on.appleby.player;

import java.util.ArrayList;

import ca.on.appleby.game.GameUtil;
import ca.on.appleby.pokemon.Pokemon;

public class Player implements PlayerAction {
	private Pokemon tempPokemon;
	private Pokemon activePokemon;
	private String name;
	private ArrayList<Pokemon> pokemonDeck;

	@Override
	public ArrayList<Pokemon> getPokemon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void selectAttackMode(String attackMode) {
		// TODO Auto-generated method stub

	}

	@Override
	public void selectDefenseMode(String defenseMode) {
		// TODO Auto-generated method stub

	}


	@Override
	public boolean selectPokemon(String PokemonName) {
		boolean isFound = false;
		for (int i = 0; i < pokemonDeck.size(); i++) {
			if (PokemonName.equals(pokemonDeck.get(i).getName())) {
				activePokemon = pokemonDeck.get(i);
				pokemonDeck.remove(i);
				isFound = true;
			}
		}
		return isFound;
	}

	@Override
	public boolean switchPokemon(String poke) {
		boolean isFound = false;
		GameUtil x = new GameUtil();

		for (int i = 0; i < pokemonDeck.size(); i++) {
			if (poke.equals(pokemonDeck.get(i).getName())) {
				tempPokemon = activePokemon;
				activePokemon = pokemonDeck.get(i);
				pokemonDeck.remove(i);
				isFound = true;
			}
		}
		
		if (isFound) {
			pokemonDeck.add(tempPokemon);
		}
		
		return isFound;

	}

	public Pokemon getActivePokemon() {
		return activePokemon;
	}

	public void setActivePokemon(Pokemon activePokemon) {
		this.activePokemon = activePokemon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Pokemon> getPokemonDeck() {
		return pokemonDeck;
	}

	public void setPokemonDeck(ArrayList<Pokemon> pokemonDeck) {
		this.pokemonDeck = pokemonDeck;
	}

}
