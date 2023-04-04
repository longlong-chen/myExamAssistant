package com.chenlong.demo.service;

import java.util.List;

import com.chenlong.demo.entity.Replay;

public interface ReplayService {
	List<Replay> findAll();

    List<Replay> findAllById(Integer messageId);

    Replay findById(Integer replayId);

    int delete(Integer replayId);

    int update(Replay replay);

    int add(Replay replay);
}
