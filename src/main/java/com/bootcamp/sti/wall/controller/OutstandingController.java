package com.bootcamp.sti.wall.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.sti.wall.dao.OutstandingDao;
import com.bootcamp.sti.wall.dto.CommonResponse;
import com.bootcamp.sti.wall.dto.OutstandingDto;
import com.bootcamp.sti.wall.exception.EntityNotFoundException;
import com.bootcamp.sti.wall.model.Outstanding;

@CrossOrigin
@RestController
public class OutstandingController {
	public static final String URL_OUTSTANDING = "outstanding";
	public static final String URL_BACKOFFICE = "backoffice";
	public static final String URL_TRADER = "trader";
	public static final String URL_LISTS_OUTSTANDING = "outstandings";
	
	@Autowired
	private OutstandingDao outstandingService;
	
	@PostMapping(value=URL_BACKOFFICE+"/"+URL_OUTSTANDING)
	@Transactional
	public CommonResponse<Outstanding> outstanding(@RequestBody OutstandingDto outstanding) throws ParseException {
		CommonResponse<Outstanding> resp = new CommonResponse<>();
		resp.setData(outstandingService.outstanding(outstanding));
		return resp;
	}
	
	@GetMapping(value=URL_TRADER+"/"+URL_OUTSTANDING)
	public CommonResponse<List<Outstanding>> getOutstanding(@RequestParam(name = "idtrader", defaultValue = "")String idTrader) {
		CommonResponse<List<Outstanding>> resp = new CommonResponse<>();
		resp.setData(outstandingService.getList(idTrader));
		return resp;
	}
	
	@GetMapping(value =URL_BACKOFFICE+"/"+ URL_LISTS_OUTSTANDING)
	public CommonResponse<List<Outstanding>> getList() throws EntityNotFoundException {
		List<Outstanding> data = outstandingService.getListAll();
		CommonResponse<List<Outstanding>> resp = new CommonResponse<>();
		if (data.isEmpty()) {
			resp.setData(data);
			throw new EntityNotFoundException();
			
		} else {
			resp.setData(data);
		}
		return resp;
	}
}
