package com.example.sportsappbackend.service.impl;

import com.example.sportsappbackend.model.InterestedSports;
import com.example.sportsappbackend.repository.InterestedSportsRepository;
import com.example.sportsappbackend.service.InterestedSportsService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class InterestedSportsServiceImpl implements InterestedSportsService {
    private InterestedSportsRepository interestedSportsRepository;

    public InterestedSportsServiceImpl(InterestedSportsRepository interestedSportsRepository) {
        super();
        this.interestedSportsRepository = interestedSportsRepository;
    }


    @Override
    public List<InterestedSports> getAllInterestedSports() {
        return interestedSportsRepository.findAll();
    }

    @Override
    public List<InterestedSports> getInterestedSportsById(long id) {
        return interestedSportsRepository.findAllByPlayerID(id);
    }


}
