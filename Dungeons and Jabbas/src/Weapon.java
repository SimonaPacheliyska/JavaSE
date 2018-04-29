
public class Weapon implements Treasure{
	private String name;
	private int damage;
	
	public Weapon(String name, int damage) {
		this.name = name;
		this.damage = damage;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getDamage() {
		return this.damage;
	}
	
	@Override
	public String collect(Hero hero) {
		if(hero.getWeapon().damage< this.damage) {
			hero.equip(this);
			return ("Weapon found! Damage points: "+ this.damage);
		}
		return ("Damage points "+ hero.getWeapon().damage);
	}

}
