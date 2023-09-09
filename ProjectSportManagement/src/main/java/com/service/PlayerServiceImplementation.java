package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.PlayerRepository;
import com.exception.NoSuchPlayerExits;
import com.model.Player;



@Service  //To declare service class as to suggest controller that this class is service
public class PlayerServiceImplementation implements PlayerService{

	@Autowired
	PlayerRepository playerRepository;
	
	
	@Override
	public Player savePlayer(Player player) {
		
		return playerRepository.save(player) ;
	}


	/*
	@Override
	public Player getPlayerById(int id) {
		
		return playerRepository.findById(id).orElse(null);
	}

*/
	
	@Override
	public Player getPlayerById(int id) {
		
		return playerRepository.findById(id).orElseThrow(
				()-> new NoSuchPlayerExits("No player found of this id"+id)
				
				);
	}
	@Override
	public Player updatePlayer(Player player) {
		Player existingPlayer = playerRepository.findById(player.getPlayerId()).orElse(null);
        existingPlayer.setPlayerName(player.getPlayerName());
       
        return playerRepository.save(existingPlayer);
	}


	@Override
	public Player deletePlayer(int id) {
		playerRepository.deleteById(id);
		return null ;
	}


	@Override
	public List<Player> getAllPlayers() {
		
		return playerRepository.findAll();
	}
	
	
	
	
	

}
