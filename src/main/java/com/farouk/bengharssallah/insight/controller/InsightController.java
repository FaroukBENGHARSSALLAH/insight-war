package com.farouk.bengharssallah.insight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.farouk.bengharssallah.insight.bean.HomeBean;
import com.farouk.bengharssallah.insight.bean.MoneyBean;
import com.farouk.bengharssallah.insight.bean.SportBean;

@Controller
public class InsightController {

	@Autowired
	private HomeBean home;
	
	@Autowired
	private MoneyBean money;
		

	@RequestMapping(value = "/")
	public String getNews(ModelMap model) {
					try {
						model.addAttribute("abc_money_news", home.getABCMoneyNews());
						model.addAttribute("sport_picture_part_one", home.getABCSportPicturePartOne());
						model.addAttribute("sport_picture_part_two", home.getABCSportPicturePartTwo());
						model.addAttribute("abc_news", home.getABCNews());
						model.addAttribute("abc_technology_news", home.getABCITechnologyNews());
						model.addAttribute("abc_world_news", home.getABCWorldNews());
						model.addAttribute("eTF_news", home.getETFAudioNews());
						model.addAttribute("arts_news", home.getABCArtsNews());
						model.addAttribute("cnn_travel_news", home.getCNNTravelNews());
						model.addAttribute("market_news", home.getMarketNews());
					           }
					catch (Exception e) {
						e.printStackTrace();
					}
					return "home";
	          }
	
	
	@RequestMapping(value = "/home")
	public String getHome(ModelMap model) {
					  return getNews(model);
	           }
	
	

	@RequestMapping(value = "/money")
	public String getMoneyNews(ModelMap model) {
					try {
						model.addAttribute("abc_business_news", money.getABCBusinessNews());
						model.addAttribute("abc_money_news", money.getABCMoneyNews());
						model.addAttribute("market_news", money.getMarketNews());
						model.addAttribute("etf_news", money.getETFNews());
					           }
					catch (Exception e) {
						e.printStackTrace();
					}
					return "money";
	          }

     }