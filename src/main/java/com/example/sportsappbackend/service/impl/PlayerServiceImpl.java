package com.example.sportsappbackend.service.impl;

import com.example.sportsappbackend.exception.ResourceNotFoundException;
import com.example.sportsappbackend.model.Player;
import com.example.sportsappbackend.repository.PlayerRepository;
import com.example.sportsappbackend.service.PlayerService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {
    private PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        super();
        this.playerRepository = playerRepository;
    }

    @Override
    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public Player getPlayerById(long id) {
        return playerRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Player", "Id", id));
    }

    @Override
    public Player updatePlayer(Player player, long id) {
        Player existingPlayer = playerRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Player", "Id", id));

        existingPlayer.setIsactive(player.getIsactive());
        existingPlayer.setCreated(player.getCreated());
        existingPlayer.setUpdated(player.getUpdated());
        existingPlayer.setValue(player.getValue());
        existingPlayer.setFname(player.getFname());
        existingPlayer.setLaname(player.getLaname());
        existingPlayer.setEmail(player.getEmail());
        existingPlayer.setUsername(player.getUsername());
        existingPlayer.setPhone_no(player.getPhone_no());
        existingPlayer.setInterested_sports(player.getInterested_sports());
        existingPlayer.setLatitude(player.getLatitude());
        existingPlayer.setLongitude(player.getLongitude());
        existingPlayer.setDescription(player.getDescription());
        existingPlayer.setImage_address(player.getImage_address());
        playerRepository.save(existingPlayer);
        return existingPlayer;
    }

    @Override
    public Player getPlayerByUsernameAndPassword(String username, String password) {
     return playerRepository.findByUsernameAndPassword(username,password);
    }

    @Override
    public void deletePlayer(long id) {
        playerRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Player", "Id", id));
        playerRepository.deleteById(id);
    }
}
