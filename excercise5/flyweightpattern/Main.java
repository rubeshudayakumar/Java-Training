package flyweightpattern;

import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		System.out.println("First victor and sara logins the game and playes together");
        GameClient victor =  GameClient.getClient("victor", 0);
        GameClient sara =   GameClient.getClient("sara", 0);
		          
		victor.setNumberOfKills(4);
		sara.setNumberOfKills(2);
		
		System.out.println("victor logins again");
		GameClient victorTwo = GameClient.getClient("victor", 0);
		System.out.println("Kills of victor : "+victorTwo.kills);
	}
}

interface Player{
	public void displayNoOfKills(int count);
}


class GamePlayer implements Player{
	
	public String battleGround;
	
	GamePlayer(String battleGround){
		this.battleGround = battleGround;
	}

	@Override
	public void displayNoOfKills(int count) {
		System.out.println("Number of kills : "+count+" in "+this.battleGround);
	}
}


class PlayerFactory{
	public static Player player;
	
	static HashMap<String,GameClient>  players = new HashMap<String,GameClient>();
	
	public static Player getPlayer() {
		if(player==null) {
			player = new GamePlayer("Erangel");
		}
		return player;
	}
}

class GameClient{
	public int kills;
	
	public Player player = PlayerFactory.getPlayer();
	
	public String name;
	
	GameClient(String name,int kills){
		this.name = name;
		this.kills = kills;
	}
	
	public static GameClient getClient(String name,int kills) {
		
		if(PlayerFactory.players.containsKey(name)) {
			return (GameClient)PlayerFactory.players.get(name);
		}
		else {
			GameClient client =new GameClient(name,kills);
			PlayerFactory.players.put(name,client);
			return client;
		}
	}
	
	public void setNumberOfKills(int count) {
		player.displayNoOfKills(count);
		this.kills+=count;
	}
}


