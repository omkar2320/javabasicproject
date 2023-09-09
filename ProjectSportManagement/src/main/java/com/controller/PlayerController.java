package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Player;
import com.service.PlayerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PlayerController {
	
	@Autowired
	PlayerService playerService;
	
	/*
	
	@PostMapping("/save")
	public Player savePlayer(@RequestBody Player player) {
		
		return playerService.savePlayer(player) ;
	}
	*/
	
	@PostMapping("/save")
	public ResponseEntity<Player> savePlayer(@RequestBody Player player) {
		
		Player p= playerService.savePlayer(player) ;
		
		return ResponseEntity.status(HttpStatus.CREATED).header("Add","Player created").body(p);
	}
	
	@GetMapping("/get/{id}")
	public Player getPlayerById(@PathVariable int id) {
		
		return playerService.getPlayerById(id);
	}
	
	@GetMapping("/getAll")
	public List<Player> getAllPlayers() {
			
			return playerService.getAllPlayers();
		}		
	@PutMapping("/update")
	public Player updateplayer(@RequestBody Player player) {
        return playerService.updatePlayer(player);
    }
	
	@DeleteMapping("/delete/{id}")
	public Player deletePlayer(@PathVariable int id) {
		playerService.deletePlayer(id);
		return null ;
	}
	
}
