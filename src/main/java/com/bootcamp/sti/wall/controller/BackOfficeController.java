package com.bootcamp.sti.wall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.sti.wall.dao.BackOfficeDao;
import com.bootcamp.sti.wall.dto.CommonResponse;
import com.bootcamp.sti.wall.dto.UserDto;
import com.bootcamp.sti.wall.model.BackOffice;


@CrossOrigin
@RestController
public class BackOfficeController {
	public static final String URL_BACKOFFICE = "backoffice";
	public static final String URL_LOGIN = "login";

	  @Autowired
	  private BackOfficeDao backOfficeDaoService;
	  
	  @PostMapping(value=URL_BACKOFFICE+"/"+URL_LOGIN)
		public CommonResponse<BackOffice> login(@RequestBody UserDto user){
			CommonResponse<BackOffice> resp = new CommonResponse<>();
			String temUserId = user.getIdUser();
			
			resp.setData(backOfficeDaoService.getByIdUser(temUserId));
			return resp;
		}
}
