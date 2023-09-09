package com.service;

import java.util.List;

import com.model.Player;



public interface PlayerService {

	Player savePlayer(Player player);
	Player getPlayerById(int id);
	List<Player> getAllPlayers();
    Player updatePlayer(Player player);
    Player deletePlayer(int id);

}
