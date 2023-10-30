package com.exercise.RLMarket.services.impl;

import com.exercise.RLMarket.DTOs.TradeDTO;
import com.exercise.RLMarket.enteties.TradeOffer;
import com.exercise.RLMarket.mappers.TradeMapper;
import com.exercise.RLMarket.repositories.TradeOfferRepository;
import com.exercise.RLMarket.services.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeServiceImpl implements TradeService {
    private TradeOfferRepository tradeOfferRepository;

    @Autowired
    public TradeServiceImpl(TradeOfferRepository tradeOfferRepository) {
        this.tradeOfferRepository = tradeOfferRepository;
    }

    @Override
    public void saveTrade(TradeOffer trade) {
        tradeOfferRepository.save(trade);
    }

    @Override
    public void deleteTrade(int tradeId) {
        tradeOfferRepository.deleteById(tradeId);
    }

    @Override
    public List<TradeDTO> getAllTrades() {
        return tradeOfferRepository.findAll().stream().map(TradeMapper::tradeOfferToTradeDTO).toList();
    }

    @Override
    public TradeDTO getTrade(int id) {
        return TradeMapper.tradeOfferToTradeDTO(tradeOfferRepository.findById(id).orElse(new TradeOffer()));
    }
}
