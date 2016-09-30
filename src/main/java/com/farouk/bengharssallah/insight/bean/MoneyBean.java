package com.farouk.bengharssallah.insight.bean;

import java.util.Iterator;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.farouk.bengharssallah.rss.parser.abc.ABCNews;
import com.farouk.bengharssallah.rss.extractor.ABCRSSExtractor;

import com.farouk.bengharssallah.rss.parser.bloomberg.BloombergNews;
import com.farouk.bengharssallah.rss.extractor.BloombergRSSExtractor;

import com.farouk.bengharssallah.rss.parser.market.MarketNews;
import com.farouk.bengharssallah.rss.util.RSSTools;
import com.farouk.bengharssallah.rss.extractor.MarketRSSExtractor;
import com.farouk.bengharssallah.rss.model.News;

import com.farouk.bengharssallah.asset.financial.data.model.BondNews;
import com.farouk.bengharssallah.asset.financial.data.model.CurrencyNews;
import com.farouk.bengharssallah.asset.financial.data.model.ExchangeNews;
import com.farouk.bengharssallah.asset.financial.data.model.SectorNews;
import com.farouk.bengharssallah.asset.financial.data.parser.FinancialDataParser;



@Component("money")
public class MoneyBean {
	
	       @Autowired
	    private ABCRSSExtractor aBCRSSExtractor;
	       @Autowired
		private MarketRSSExtractor marketRSSExtractor;
	       @Autowired
	    private BloombergRSSExtractor bloombergRSSExtractor;
	      
	    
	    private FinancialDataParser financialDataParser = new FinancialDataParser();
	       
	    private LinkedList<ABCNews> abc_money_news_list = null;
	    private LinkedList<ABCNews> abc_business_news_list = null;
	    private LinkedList<MarketNews> market_news_list = null;
	    private LinkedList<BloombergNews> bloomberg_news_list = null;
	   
	    
	    public LinkedList<ABCNews> getABCBusinessNews(){
								    	    LinkedList<ABCNews> list = new LinkedList<ABCNews>();
								            if(abc_business_news_list == null){
														   try {
															   abc_business_news_list = aBCRSSExtractor.getABCBusinessNews();
															             } 
											               catch (Exception e) {
																           e.printStackTrace();
															             }
								                        }
								            @SuppressWarnings("rawtypes")
											  Iterator it = abc_business_news_list.iterator();
								              int i = 0;
								              while(it.hasNext() && i<6){
								            	           ABCNews news = (ABCNews) it.next();
								            	           if(news.getContent_picture_627() != null ){
								            	        	                  list.add(news);
								            	                              i++;
								            	                         }
								                           }
								            return list; 
							         }
	    
	    
  
	    
	    public LinkedList<ABCNews> getABCMoneyNews(){
							    	    LinkedList<ABCNews> list = new LinkedList<ABCNews>();
							            if(abc_money_news_list == null){
													   try {
														            abc_money_news_list = aBCRSSExtractor.getABCMoneyNews();
														             } 
										               catch (Exception e) {
															           e.printStackTrace();
														             }
							                        }
							            @SuppressWarnings("rawtypes")
										  Iterator it = abc_money_news_list.iterator();
							              int i = 0;
							              while(it.hasNext() && i<6){
							            	           ABCNews news = (ABCNews) it.next();
							            	           if(news.getContent_picture_627() != null ){
							            	        	                  list.add(news);
							            	                              i++;
							            	                         }
							                           }
							            return list; 
                                }
	    
	    
	    
	    public LinkedList<MarketNews> getMarketNews(){
							    	    LinkedList<MarketNews> list = new LinkedList<MarketNews>();
							            if(market_news_list == null){
													   try {
														   market_news_list = marketRSSExtractor.getMarketNews();
														             } 
										               catch (Exception e) {
															           e.printStackTrace();
														             }
							                        }
							            @SuppressWarnings("rawtypes")
										  Iterator it = market_news_list.iterator();
							              int i = 0;
							              while(it.hasNext() && i<6){
							            	           MarketNews news = (MarketNews) it.next();
							            	           if(news.getImage() != null){
							            	        	                  list.add(news);
							            	                              i++;
							            	                         }
							                           }
							            return list; 
                                }
	    
	    
	    
	    public LinkedList<BloombergNews> getETFNews(){
							    	    LinkedList<BloombergNews> list = new LinkedList<BloombergNews>();
							            if(bloomberg_news_list == null){
													   try {
														   bloomberg_news_list = bloombergRSSExtractor.getBloombergETFStories();
														             } 
										               catch (Exception e) {
															           e.printStackTrace();
														             }
							                        }
							            @SuppressWarnings("rawtypes")
										  Iterator it = bloomberg_news_list.iterator();
							              int i = 0;
							              while(it.hasNext() && i<6){
							            	           BloombergNews news = (BloombergNews) it.next();
							            	           list.add(news);
							            	           i++;
							                           }
							            return list; 
                                }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    public LinkedList<ExchangeNews> getExhangeNews(){
	    	                                return financialDataParser.getExchangeData();
	                               }
	    
	    public LinkedList<CurrencyNews> getCurrencyNews(){
								            return financialDataParser.getCurrencyData();
                                    }
	    
	    public LinkedList<BondNews> getBondNews(){
								            return financialDataParser.getBondData();
                                     }
	    
	    public LinkedList<SectorNews> getSectorNews(){
	    	                                LinkedList<SectorNews> list = financialDataParser.getSectorData();
	    	                                 {
	    	                                LinkedList<SectorNews> strippedList = new LinkedList<>();
	    	                                for(SectorNews news :list){
	    	                                	                   if(!news.getName().contains("...")){
	    	                                	                	                        strippedList.add(news);
	    	                                	                                  }
	    	                                                       }
	    	                                list = strippedList;
	    	                                 }
								            return list;
                                   }
	    
	      
	      public News getSingletNews(String reference){
	    	                                      String[] src_catg = RSSTools.getRSSSourceCategory(reference).split("~");
	    	                                      String source = src_catg[0];
	    	                                      String category = src_catg[1];
	    	                                      if(source.equals("ABC")){
	    	                                    	                if(category.equals("money")){
	    	                                    	                	             for(News news : abc_money_news_list){
	    	                                    	                	            	                    if(news.getReference().equals(reference)){
	    	                                    	                	            	                    	                                return news;
	    	                                    	                	            	                                    }
	    	                                    	                	                           }
	    	                                    	                                  }
	    	                                                 }
									              return null; 
							 }

         }