package com.farouk.bengharssallah.insight.bean;

import java.util.Iterator;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.farouk.bengharssallah.rss.parser.abc.ABCNews;
import com.farouk.bengharssallah.rss.parser.abc.ABCINews;
import com.farouk.bengharssallah.rss.extractor.ABCRSSExtractor;

import com.farouk.bengharssallah.rss.parser.bloomberg.BloombergNews;
import com.farouk.bengharssallah.rss.extractor.BloombergRSSExtractor;

import com.farouk.bengharssallah.rss.parser.cnn.CNNNews;
import com.farouk.bengharssallah.rss.extractor.CNNRSSExtractor;

import com.farouk.bengharssallah.rss.parser.market.MarketNews;
import com.farouk.bengharssallah.rss.util.RSSTools;
import com.farouk.bengharssallah.rss.extractor.MarketRSSExtractor;
import com.farouk.bengharssallah.rss.model.News;


@Component("home")
public class HomeBean {
	
	      @Autowired
	    private BloombergRSSExtractor bloombergRSSExtractor;
	      @Autowired
	    private CNNRSSExtractor cNNRSSExtractor;
	      @Autowired
	    private ABCRSSExtractor aBCRSSExtractor;
	      @Autowired
	    private MarketRSSExtractor marketRSSExtractor;
	    
	    private LinkedList<ABCNews> abc_money_news_list = null;
	    private LinkedList<ABCNews> abc_sport_news_list = null;
	    private LinkedList<ABCNews> abc_news_list = null;
	    private LinkedList<ABCINews> abci_technology_news_list = null;
	    private LinkedList<ABCNews>  abc_world_news_list = null;
	    private LinkedList<BloombergNews> bloomberg_etf_audio_news_list = null;
	    private LinkedList<ABCNews> abc_arts_news_list = null;
	    private LinkedList<CNNNews> cnn_travel_news_list = null;
	    private LinkedList<MarketNews> market_news_list = null;
	    
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
	    
	    

	    
	    public  LinkedList<ABCNews> getABCSportPicturePartOne(){
									    	LinkedList<ABCNews> list = new LinkedList<ABCNews>();
								            if(abc_sport_news_list == null){
														   try {
																abc_sport_news_list = aBCRSSExtractor.getABCSportNews();
																             } 
												           catch (Exception e) {
																	           e.printStackTrace();
																             }
								                         }
								            @SuppressWarnings("rawtypes")
											  Iterator it = abc_sport_news_list.iterator();
								              int i = 0;
								              while(it.hasNext() && i<9){
								            	           ABCNews news = (ABCNews) it.next();
								            	           if(news.getContent_picture_627() != null ){
								            	        	                  list.add(news);
								            	                              i++;
								            	                         }
								                           }
								            return list; 
							 }
	    
	    
	    
	    
	    public  LinkedList<ABCNews> getABCSportPicturePartTwo(){
									    	LinkedList<ABCNews> list = new LinkedList<ABCNews>();
								            if(abc_sport_news_list == null){
															try {
																abc_sport_news_list = aBCRSSExtractor.getABCSportNews();
																             } 
												            catch (Exception e) {
																	           e.printStackTrace();
																             }
								                       }
								              @SuppressWarnings("rawtypes")
											Iterator it = abc_sport_news_list.iterator();
								            int i = 0;
								            while(it.hasNext() && i<9){
								            	           ABCNews news = (ABCNews) it.next();
								            	           if(news.getContent_picture_627() != null ){
								            	                              i++;
								            	                         }
								                           }
								            while(it.hasNext() && i<18){
								            	           ABCNews news = (ABCNews) it.next();
								            	           if(news.getContent_picture_627() != null ){
								            	        	                  list.add(news);
								            	                              i++;
								            	                         }
								                           }
								            return list; 
							}
	    
	    
	    
	    
	    public  LinkedList<ABCNews> getABCNews(){
									    	LinkedList<ABCNews> list = new LinkedList<ABCNews>();
								            if(abc_news_list == null){
															try {
																abc_news_list = aBCRSSExtractor.getABCTopStories();
																             } 
												            catch (Exception e) {
																	           e.printStackTrace();
																             }
								                        }
								            @SuppressWarnings("rawtypes")
											  Iterator it = abc_news_list.iterator();
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
	    
	    

	    
	    
	    public  LinkedList<ABCINews> getABCITechnologyNews(){
								    	  LinkedList<ABCINews> list = new LinkedList<ABCINews>();
							              if(abci_technology_news_list == null){
														  try {
															  abci_technology_news_list = aBCRSSExtractor.getABCITechnologyNews();
															             } 
											              catch (Exception e) {
																           e.printStackTrace();
															             }
							                           }
							              @SuppressWarnings("rawtypes")
										  Iterator it = abci_technology_news_list.iterator();
							              int i = 0;
							              while(it.hasNext() && i<6){
							            	           ABCINews news = (ABCINews) it.next();
							            	           if(!news.getThumbnail_picture_608().getSrc().contains("abc_news_default") && !news.getThumbnail_picture_608().getSrc().contains("abc_default_image")){
							            	        	                  list.add(news);
							            	                              i++;
							            	                         }
							                           }
							              return list; 
							}
													
	    
	    
		  public  LinkedList<ABCNews> getABCWorldNews(){
								    	  LinkedList<ABCNews> list = new LinkedList<ABCNews>();
							              if(abc_world_news_list== null){
														try {
															abc_world_news_list = aBCRSSExtractor.getABCWorldNews();
															             } 
											            catch (Exception e) {
																           e.printStackTrace();
															             }
							                        }
							              @SuppressWarnings("rawtypes")
										  Iterator it = abc_world_news_list.iterator();
							              int i = 0;
							              while(it.hasNext() && i<3){
							            	           ABCNews news = (ABCNews) it.next();
							            	           if(news.getContent_picture_627() != null ){
							            	        	                  list.add(news);
							            	                              i++;
							            	                         }
							                           }
							              return list; 
		                      }
	    
	  
		public LinkedList<BloombergNews> getETFAudioNews(){
	    	                                      LinkedList<BloombergNews> list = new LinkedList<BloombergNews>();
	    	                                      if(bloomberg_etf_audio_news_list == null)
												  try {
													               bloomberg_etf_audio_news_list = bloombergRSSExtractor.getBloombergETFStories();
													                         }
	    	                                      catch (Exception e) {
														           e.printStackTrace();
													                         }
	    	                                      for(int i=0; i<6; i++){
	    	                                    	               list.add(bloomberg_etf_audio_news_list.get(i));
	    	                                                            }
	    	                                      return list; 
	                          }
		
		
	     
	      public  LinkedList<ABCNews> getABCArtsNews(){
										    	  LinkedList<ABCNews> list = new LinkedList<ABCNews>();
									              if(abc_arts_news_list == null)
												  try {
													  abc_arts_news_list = aBCRSSExtractor.getABCArtsNews();
													             } 
									              catch (Exception e) {
														           e.printStackTrace();
													             }
									              @SuppressWarnings("rawtypes")
												  Iterator it = abc_arts_news_list.iterator();
									              int i = 0;
									              while(it.hasNext() && i<15){
									            	           ABCNews news = (ABCNews) it.next();
									            	           if(news.getContent_picture_627() != null ){
									            	        	                  list.add(news);
									            	                              i++;
									            	                         }
									                               }
									              return list; 
                            }
		
		
		
		
	      
	      public  LinkedList<CNNNews> getCNNTravelNews(){
										    	  LinkedList<CNNNews> list = new LinkedList<CNNNews>();
									              if(cnn_travel_news_list == null)
												  try {
													  cnn_travel_news_list = cNNRSSExtractor.getCNNTravelNews();
													             } 
									              catch (Exception e) {
														           e.printStackTrace();
													             }
									              @SuppressWarnings("rawtypes")
												  Iterator it = cnn_travel_news_list.iterator();
									              int i = 0;
									              while(it.hasNext() && i<6){
									            	           CNNNews news = (CNNNews) it.next();
									            	           if(news.getContent_picture_619() != null ){
									            	        	                  list.add(news);
									            	                              i++;
									            	                         }
									                           }
									              return list; 
                            }
	      
	      public  LinkedList<MarketNews> getMarketNews(){
										    	  LinkedList<MarketNews> list = new LinkedList<MarketNews>();
									              if(market_news_list == null)
												  try {
													  market_news_list = marketRSSExtractor.getMarketNews();
													             } 
									              catch (Exception e) {
														           e.printStackTrace();
													             }
									              @SuppressWarnings("rawtypes")
												  Iterator it = market_news_list.iterator();
									              int i = 0;
									              while(it.hasNext() && i<2){
									            	           MarketNews news = (MarketNews) it.next();
									            	           if(news.getChartOnePicture() != null ){
									            	        	                  list.add(news);
									            	                              i++;
									            	                         }
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
	    	                                    	                else if(category.equals("sport")){
				                                   	                	             for(News news : abc_sport_news_list){
				                                   	                	            	                    if(news.getReference().equals(reference)){
				                                   	                	            	                    	                            return news;
				                                   	                	            	                                    }
				                                   	                	                                   }
                                   	                                                  }
	    	                                    	                	          
	    	                                                 }
										    
									              return null; 
							 }

         }