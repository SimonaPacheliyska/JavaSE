	
public class Hero implements Actor {
	private String name;
	private int health;
	private int mana;
	private Position position;
	private Weapon weapon;
	private Spell spell;
	
	public Hero(String name, int health, int mana, Position position){
		this.name = name;
		this.health = health;
		this.mana = mana;
		this.position = position;
		this.weapon=null;
		this.spell = null;
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public int getHealth() {
		return this.health;
	}
	
	@Override
	public int getMana() {
		return this.mana;
	}
	
	public Position getPosition() {
		return this.position;
	}
	
	@Override
	public boolean isAlive() {
		return (this.health>0);
	}
	
	public void takeHealing(int healingPoints) {
		if(isAlive() && healingPoints < this.health) {
			this.health += healingPoints;
		}
	}
	
	@Override
	public void takeDamage(int damagePoints) {
		if (isAlive() && damagePoints <= this.health) {
			this.health -= damagePoints;
		}
	}
	
	public void takeMana(int manaPoints) {
		if(isAlive() && manaPoints < this.mana) {
			this.mana += manaPoints;
		}
	}
	
	public void equip(Weapon weapon) {
		if(weapon.getDamage() > this.weapon.getDamage() || this.weapon == null) {
			this.weapon = weapon;
		}
	}
	
	public Weapon getWeapon() {
		return this.weapon;
	}
	
	public void learn(Spell spell) {
		if (this.spell == null || this.spell.getDamage() < spell.getDamage()) {
			this.spell = spell;
		}
	}
	
	public Spell getSpell() {
		return this.spell;
	}
	
	@Override
	public int attack() {
		if (this.weapon==null && this.spell == null) {
			return 0;
		}
		if(this.weapon!=null && this.spell==null) {
			return this.weapon.getDamage();
		}
		if(this.weapon==null && this.spell!=null) {
			return this.spell.getDamage();
		}
		if(this.weapon.getDamage()>this.spell.getDamage()) {
			return this.weapon.getDamage();
		}
		else if(this.spell.getDamage()>this.mana) {
			this.mana -=this.spell.getDamage();
			return this.spell.getDamage();
		}
		return this.weapon.getDamage();
	}

}