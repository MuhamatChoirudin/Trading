package com.bootcamp.sti.wall.dao;

import java.text.ParseException;
import java.util.List;

import com.bootcamp.sti.wall.dto.OutstandingDto;
import com.bootcamp.sti.wall.model.Outstanding;

public interface OutstandingDao {
	Outstanding outstanding(OutstandingDto outstanding) throws ParseException;
	List<Outstanding> getList(String idTrader);
	List<Outstanding> getListAll();
	Outstanding setData (OutstandingDto dto);

}
