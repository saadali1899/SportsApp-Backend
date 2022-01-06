package com.example.sportsappbackend.service.impl;

import com.example.sportsappbackend.exception.ResourceNotFoundException;
import com.example.sportsappbackend.model.Team;
import com.example.sportsappbackend.model.Tournament;
import com.example.sportsappbackend.repository.TeamRepository;
import com.example.sportsappbackend.repository.TournamentRepository;
import com.example.sportsappbackend.service.TeamService;
import com.example.sportsappbackend.service.TournamentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentServiceImpl implements TournamentService {
    private TournamentRepository tournamentRepository;

    public TournamentServiceImpl(TournamentRepository tournamentRepository) {
        super();
        this.tournamentRepository = tournamentRepository;
    }

    @Override
    public Tournament saveTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    @Override
    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    @Override
    public Tournament getTournamentById(long id) {
        return tournamentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Tournament", "Id", id));
    }

    @Override
    public Tournament updateTournament(Tournament tournament, long id) {
        Tournament existingTournament = tournamentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Tournament", "Id", id));

        existingTournament.setSportsID(tournament.getSportsID());
        existingTournament.setIsActive(tournament.getIsActive());
        existingTournament.setCreated(tournament.getCreated());
        existingTournament.setUpdated(tournament.getUpdated());
        existingTournament.setValue(tournament.getValue());
        existingTournament.setName(tournament.getName());
        existingTournament.setStartDate(tournament.getStartDate());
        existingTournament.setEndDate(tournament.getEndDate());
        existingTournament.setIsFree(tournament.getIsFree());
        existingTournament.setPrizeMoney(tournament.getPrizeMoney());
        existingTournament.setHostID(tournament.getHostID());
        existingTournament.setLatitude(tournament.getLatitude());
        existingTournament.setLongitude(tournament.getLongitude());
        existingTournament.setDescription(tournament.getDescription());
        existingTournament.setImageAddress(tournament.getImageAddress());

        tournamentRepository.save(existingTournament);
        return existingTournament;
    }

    @Override
    public void deleteTournament(long id) {
        tournamentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Tournament", "Id", id));
        tournamentRepository.deleteById(id);
    }
}
