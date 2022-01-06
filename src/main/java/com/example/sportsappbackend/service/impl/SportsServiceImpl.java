package com.example.sportsappbackend.service.impl;

import com.example.sportsappbackend.exception.ResourceNotFoundException;
import com.example.sportsappbackend.model.Player;
import com.example.sportsappbackend.model.Sports;
import com.example.sportsappbackend.repository.SportsRepository;
import com.example.sportsappbackend.repository.UserRepository;
import com.example.sportsappbackend.service.SportsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportsServiceImpl implements SportsService {
    private SportsRepository sportsRepository;

    public SportsServiceImpl(SportsRepository sportsRepository) {
        super();
        this.sportsRepository = sportsRepository;
    }

    @Override
    public Sports saveSports(Sports sports) {
        return sportsRepository.save(sports);
    }

    @Override
    public List<Sports> getAllSports() {
        return sportsRepository.findAll();
    }

    @Override
    public Sports getSportsById(long id) {
        return sportsRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Sports", "Id", id));
    }

    @Override
    public Sports updateSPorts(Sports sports, long id) {
        Sports existingSports = sportsRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Sports", "Id", id));

        existingSports.setIsactive(sports.getIsactive());
        existingSports.setCreated(sports.getCreated());
        existingSports.setUpdated(sports.getUpdated());
        existingSports.setValue(sports.getValue());
        existingSports.setName(sports.getName());
        existingSports.setDescription(sports.getDescription());
        existingSports.setIsSummary(sports.getIsSummary());
        existingSports.setMember_count(sports.getMember_count());
        existingSports.setImage_address(sports.getImage_address());
        sportsRepository.save(existingSports);
        return existingSports;
    }

    @Override
    public void deleteSports(long id) {
        sportsRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Sports", "Id", id));
        sportsRepository.deleteById(id);
    }
}
