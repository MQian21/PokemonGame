package ca.on.appleby.pokemon;

public abstract class Pokemon {
	// Variables + attributes

	private double hitPercentage = 0.90;
	private String elementName;
	private String name;
	private int health;
	private int damage;
	private int defense;
	private int speed;
	private String attackMode;
	private String defenseMode;
	private boolean active;

	// Methods

	// Change Pokemon Attack Stat

	public void changeAttackData(int pokemonStrength) {
		if (pokemonStrength == 1) {
			this.damage = this.damage + 5;
		} else if (pokemonStrength == -1) {
			this.damage = this.damage - 5;
		}
	}

	// Change Pokemon hitPercentage

	public void changeHitPercentage(int pokemonStrength) {
		if (pokemonStrength == 1) {
			this.hitPercentage = this.hitPercentage + 0.05;
		} else if (pokemonStrength == -1) {
			this.hitPercentage = this.hitPercentage - 0.05;
		}
	}


	public abstract int compareElement(Pokemon OppPokemon);

	// Get/Set methods

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getAttackMode() {
		return attackMode;
	}

	public void setAttackMode(String attackMode) {
		this.attackMode = attackMode;
	}

	public String getDefenseMode() {
		return defenseMode;
	}

	public void setDefenseMode(String defenseMode) {
		this.defenseMode = defenseMode;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public double getHitPercentage() {
		return hitPercentage;
	}

	public void setHitPercentage(double hitPercentage) {
		this.hitPercentage = hitPercentage;
	}

	public String getElementName() {
		return elementName;
	}

	public void setElementName(String elementName) {
		this.elementName = elementName;
	}

}
