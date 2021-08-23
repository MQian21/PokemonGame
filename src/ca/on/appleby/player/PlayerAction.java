package ca.on.appleby.player;

import java.util.ArrayList;

import ca.on.appleby.pokemon.Pokemon;

public interface PlayerAction {
	public ArrayList<Pokemon> getPokemon();

	public void selectAttackMode(String attackMode);

	public void selectDefenseMode(String defenseMode);

	// Used for starting, selecting
	public boolean selectPokemon(String pokemonName);

	public boolean switchPokemon(String poke);

}
