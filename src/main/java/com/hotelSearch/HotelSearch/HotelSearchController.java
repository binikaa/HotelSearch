package com.hotelSearch.HotelSearch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hotelSearch.HotelSearch.dao.HotelSearchDao;
import com.hotelSearch.HotelSearch.entity.Hotel;


@Controller
public class HotelSearchController {
	
	@Autowired
	HotelSearchDao hotelSearchDao;
	@RequestMapping("/")
	public ModelAndView list()
	{
		return new ModelAndView("index");
	}
	@RequestMapping("/result")
	public ModelAndView listHotel(
			
		@RequestParam(value="city", required=false) String city) {
		ModelAndView mav = new ModelAndView("result");
		if (city != null && !city.isEmpty()) {
			mav.addObject("cities", hotelSearchDao.findByCity(city));
		}
		 else {
			mav.addObject("cities", hotelSearchDao.findAll());
		}
		
		return mav;
	}


	
	
}
