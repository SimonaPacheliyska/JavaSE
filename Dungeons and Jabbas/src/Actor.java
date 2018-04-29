
public interface Actor {
	
	String getName();
	
	int getHealth();
	
	int getMana();
	
	boolean isAlive();
	
	Weapon getWeapon();
	
	Spell getSpell();
	
	void takeDamage(int damagePoints);
	
	int attack();
}
