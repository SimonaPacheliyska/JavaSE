
public class ManaPotion implements Treasure{
	private int manaPoints;
	
	public ManaPotion(int manaPoints) {
		this.manaPoints = manaPoints;
	}
	
	public int heal() {
		return this.manaPoints;
	}
	
	@Override
	public String collect(Hero hero) {
		hero.takeMana(this.heal());
		return "Mana potion found! " + this.heal() + " mana points added to your hero!";
	}
}
