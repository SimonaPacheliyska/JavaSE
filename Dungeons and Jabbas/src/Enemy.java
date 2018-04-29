
public class Enemy implements Actor {
	
	private String name;
	private int health;
	private int mana;
	private Weapon weapon;
	private Spell spell;
	
	public Enemy(String name, int health, int mana, Weapon weapon, Spell spell) {
		this.name = name;
		this.health = health;
		this.mana = mana;
		this.weapon = weapon;
		this.spell = spell;
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

	@Override
	public boolean isAlive() {
		return this.health > 0;
	}

	@Override
	public Weapon getWeapon() {
		return this.weapon;
	}

	@Override
	public Spell getSpell() {
		return this.spell;
	}

	@Override
	public void takeDamage(int damagePoints) {
		if(damagePoints < this.health) {
			this.health-=damagePoints;
		}

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
