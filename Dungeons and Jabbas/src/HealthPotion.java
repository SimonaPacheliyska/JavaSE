
public class HealthPotion implements Treasure{
	private int healingPoints;
	
	public HealthPotion(int healingPoints) {
		this.healingPoints = healingPoints;
	}
	
	public int getHealingPoints() {
		return this.healingPoints;
	}
	
	public int heal() {
		return this.healingPoints;
	}
	
	@Override
	public String collect(Hero hero) {
		hero.takeHealing(this.heal());
		return "Mana potion found! " + this.heal() + " health points added to your hero!";
	}
	
	

}
