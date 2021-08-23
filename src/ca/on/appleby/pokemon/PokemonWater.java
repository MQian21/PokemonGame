package ca.on.appleby.pokemon;

public class PokemonWater extends Pokemon {

	// Comparing the Pokemon's element to the other two types of elements 
	@Override
	public int compareElement(Pokemon OppPokemon) {
		int returnVal = 0;

		if (OppPokemon instanceof PokemonWater) {
			returnVal = 0;
		} else if (OppPokemon instanceof PokemonEarth) {
			returnVal = -1;
		} else if (OppPokemon instanceof PokemonFire) {
			returnVal = 1;
		} else {
			System.out.println("Not an existing pokemon");
		}

		return returnVal;
	}

}
