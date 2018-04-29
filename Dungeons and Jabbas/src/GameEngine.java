
public class GameEngine {
	private char[][] map;
	private Hero hero;
	private Enemy[] enemies;
	private Treasure[] treasures;
	
	public GameEngine(char[][] map, Hero hero, Enemy[] enemies, Treasure[] treasures) {
		this.map = map;
		this.hero = hero;
		this.enemies = enemies;
		this.treasures = treasures;
	}
	
	public char[][] getMap() {
		return this.map;
	}
	
	private boolean isCharAtPos(int position, char symbol){
		 switch(position) {
		 case 0:
			 return this.map[hero.getPosition().getXpos()][hero.getPosition().getYpos()-1] == symbol;
		 case 1:
			 return this.map[hero.getPosition().getXpos()-1][hero.getPosition().getYpos()]==symbol;
		 case 2:
			 return this.map[hero.getPosition().getXpos()][hero.getPosition().getYpos()+1]==symbol;
		 case 3:
			 return this.map[hero.getPosition().getXpos()+1][hero.getPosition().getYpos()]==symbol;
		 }
		return false;
	}
	
	private void findTreasures(int command){
		for(int i =0;i<treasures.length;i++) {
			if(treasures[i]!=null) {
				if(command==0){
				 this.hero.getPosition().setYpos(this.hero.getPosition().getYpos()-1);
				 this.map[hero.getPosition().getXpos()][hero.getPosition().getYpos()-1] = 'H';
				}
				if(command==1){
				 this.hero.getPosition().setXpos(this.hero.getPosition().getXpos()-1);
				 this.map[hero.getPosition().getXpos()-1][hero.getPosition().getYpos()] = 'H';
				}
				if(command==2){
				 this.hero.getPosition().setYpos(this.hero.getPosition().getYpos()+1);
				 this.map[hero.getPosition().getXpos()][hero.getPosition().getYpos()+1] = 'H';
				}
				if(command==3){
				 this.hero.getPosition().setXpos(this.hero.getPosition().getXpos()+1);
				 this.map[hero.getPosition().getXpos()+1][hero.getPosition().getYpos()] = 'H';
				}
				this.map[hero.getPosition().getXpos()][hero.getPosition().getYpos()] = '.';
				treasures[i].collect(this.hero);
				treasures[i]=null;
				return;
				}
		 }
}
	
	private String findEnemy(int command) {
		Enemy involved = null;
		for(int i = 0;i<this.enemies.length;i++){
			if(enemies[i]!=null){
				while(this.hero.isAlive() && this.enemies[i].isAlive()){
					this.enemies[i].takeDamage(this.hero.attack());
					if(this.enemies[i].isAlive()){
					this.hero.takeDamage(this.enemies[i].attack());
					}
			     }
				involved = enemies[i];
				this.enemies[i]=null;
				break;
		     }
	     }
		if (involved.isAlive()) {
			return "Hero is dead! Game over!";
		}
		if(command==0) {
			this.map[hero.getPosition().getXpos()][hero.getPosition().getYpos()-1]='H';
		}
		if(command==1) {
			this.map[hero.getPosition().getXpos()+1][hero.getPosition().getYpos()]='H';
		}
		if(command==2) {
			this.map[hero.getPosition().getXpos()][hero.getPosition().getYpos()+1]='H';
		}
		if(command==3) {
			this.map[hero.getPosition().getXpos()+1][hero.getPosition().getYpos()]='H';
		}
		this.map[hero.getPosition().getXpos()][hero.getPosition().getYpos()]='.';
		return "Enemy died.";
	}
	
	
	public String makeMove(int command) {
		switch(command) {
		case 0:
			if(isCharAtPos(0, '#')){
					return "Wrong move. There is an obstacle and you cannot bypass it.";
			}
			
			if(isCharAtPos(0, 'T')){
				findTreasures(0);
			 return "You moved successfully to the next position.";
			} 
			
			if(isCharAtPos(0, 'E')) {
				findEnemy(0);
			}
			
			if(isCharAtPos(0, 'G')) {
				return "You have successfully passed through the dungeon. Congrats!";
			}
		case 1:
			if(isCharAtPos(1, '#')) {
				return "Wrong move. There is an obstacle and you cannot bypass it.";
			}
			
			if(isCharAtPos(1,'T')) {
					findTreasures(1);
					return "You moved successfully to the next position.";
			}
			
			if(isCharAtPos(1, 'E')) {
				findEnemy(1);
			}
			
			if(isCharAtPos(1,'G')) {
				return "You have successfully passed through the dungeon. Congrats!";
			}
		case 2: 
				if(isCharAtPos(2,'#')) {
					return "Wrong move. There is an obstacle and you cannot bypass it.";
				}
				if(isCharAtPos(2,'T')) {
					findTreasures(2);
					return "You moved successfully to the next position.";
				}
				
				if(isCharAtPos(2,'E')) {
					findEnemy(2);
				}

				if(isCharAtPos(2,'G')) {
					return "You have successfully passed through the dungeon. Congrats!";
				}
		case 3:
					if(isCharAtPos(3,'#')) {
						return "Wrong move. There is an obstacle and you cannot bypass it.";
					}
		
					if(isCharAtPos(3,'T')) {
						findTreasures(3);
						return "You moved successfully to the next position";
					}

					if(isCharAtPos(3, 'E')) {
						findEnemy(3);
					}
						
					if(isCharAtPos(3,'G')) {
						return "You have successfully passed through the dungeon. Congrats!";
					}
					
		default : return "Unknown command entered.";
	 }
	}
}
