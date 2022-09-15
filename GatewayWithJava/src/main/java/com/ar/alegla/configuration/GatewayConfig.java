package com.ar.alegla.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;



@Configuration
public class GatewayConfig implements GlobalFilter{

	private static final Logger log = LoggerFactory.getLogger(GatewayConfig.class);
	
	private static final String URI = "http://localhost:8080";
	private static final String REWRITE_PATH = "/api/service/person";
	private static final String ALL_PERSONS = "/allPersons";
	private static final String FIND_PERSON = "/findPerson";
	private static final String ADD_PERSON = "/addPerson";
	private static final String UPDATE_PERSON = "/updatePerson";
	private static final String DELETE_PERSON = "/deletePerson";
	private static final String ORDER_PATH_MONEY_STANDARD = "/order/money";
	private static final String ORDER_PATH_AGE_STANDARD = "/order/age";
	private static final String ORDER_LOW_TO_HIGH_MONEY = "/orderLowToHighMoney";
	private static final String ORDER_HIGH_TO_LOW_MONEY = "/orderHighToLowMoney";
	private static final String ORDER_LOW_TO_HIGH_AGE = "/orderLowToHighAge";
	private static final String ORDER_HIGH_TO_LOW_AGE = "/orderHighToLowAge";
	private static final String FIND_PERSON_BY_NATIONALITY = "/findPersonByNationality";
	private static final String FIND_PERSON_BY_NATIONALITY_AND_ORDER_LOW_TO_HIGH_MONEY = "/findPersonByNationalityAndOrderLowToHighMoney";
	private static final String FIND_PERSON_BY_NATIONALITY_AND_ORDER_HIGH_TO_LOW_MONEY = "/findPersonByNationalityAndOrderHighToLowMoney";
	private static final String FIND_PERSON_BY_NATIONALITY_AND_ORDER_LOW_TO_HIGH_AGE = "/findPersonByNationalityAndOrderLowToHighAge";
	private static final String FIND_PERSON_BY_NATIONALITY_AND_HIGH_TO_LOW_AGE = "/findPersonByNationalityAndOrderHighToLowAge";
	private static final String FIND_PERSONS_AVAILABLE_TO_TRANSFER = "/findPersonsAvailableToTransfer";
	private static final String MONEY_TRANSFER = "/moneytransfer";
	
	
	@Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				
				//ALL PERSON SERVICE
	               .route("allPersons", r -> {
	                  return r.path(GatewayConfig.REWRITE_PATH + "/all")
	                        .filters(f -> f	                        		
	                        		.addRequestHeader("Content-Type", "application/json")
	                        		.rewritePath(GatewayConfig.REWRITE_PATH + "/all", GatewayConfig.ALL_PERSONS))
	                        .uri(GatewayConfig.URI);
	                        })
	               
	           
	            //FIND PERSON SERVICE
	               .route("findPerson", r -> {
	            	   System.out.println("Redirect to " + GatewayConfig.URI + GatewayConfig.FIND_PERSON);
		                  return r.path(GatewayConfig.REWRITE_PATH + "/find")
		                        .filters(f -> f
		                        		.addRequestHeader("Content-Type", "application/json")
		                        		.rewritePath(GatewayConfig.REWRITE_PATH + "/find", GatewayConfig.FIND_PERSON))
		                        .uri(GatewayConfig.URI);})
	          
	               
	          //ADD PERSON - SERVICE
	               .route("addPerson", r -> {
		                  return r.path(GatewayConfig.REWRITE_PATH + "/add")
		                        .filters(f -> f
		                        		.addRequestHeader("Content-Type", "application/json")
		                        		.rewritePath(GatewayConfig.REWRITE_PATH + "/add", GatewayConfig.ADD_PERSON))
		                        .uri(GatewayConfig.URI);})
	               
	               
	         //UPDATE PERSON - SERVICE
	               .route("updatePerson", r -> {
		                  return r.path(GatewayConfig.REWRITE_PATH + "/update")
		                        .filters(f -> f
		                        		.addRequestHeader("Content-Type", "application/json")
		                        		.rewritePath(GatewayConfig.REWRITE_PATH + "/update", GatewayConfig.UPDATE_PERSON))
		                        .uri(GatewayConfig.URI);})
	               
	               
	         //DELETE PERSON - SERVICE
	               .route("deletePerson", r -> {
		                  return r.path(GatewayConfig.REWRITE_PATH + "/delete")
		                        .filters(f -> f
		                        		.addRequestHeader("Content-Type", "application/json")
		                        		.rewritePath(GatewayConfig.REWRITE_PATH + "/delete",GatewayConfig.DELETE_PERSON))
		                        .uri(GatewayConfig.URI);})
	               
	               
	         //ORDER LOW TO HIGH MONEY - SERVICE
	               .route("orderLowToHighMoney", r -> {
		                  return r.path(GatewayConfig.REWRITE_PATH + GatewayConfig.ORDER_PATH_MONEY_STANDARD + "/lowtohigh")
		                        .filters(f -> f
		                        		.addRequestHeader("Content-Type", "application/json")
		                        		.rewritePath(GatewayConfig.REWRITE_PATH + GatewayConfig.ORDER_PATH_MONEY_STANDARD + "/lowtohigh",GatewayConfig.ORDER_LOW_TO_HIGH_MONEY))
		                        .uri(GatewayConfig.URI);})
	               
	         
	         //ORDER HIGH TO LOW MONEY - SERVICE   
	               .route("orderHighToLowMoney", r -> {
		                  return r.path(GatewayConfig.REWRITE_PATH + GatewayConfig.ORDER_PATH_MONEY_STANDARD + "/hightolow")
		                        .filters(f -> f
		                        		.addRequestHeader("Content-Type", "application/json")
		                        		.rewritePath(GatewayConfig.REWRITE_PATH + GatewayConfig.ORDER_PATH_MONEY_STANDARD + "/hightolow",GatewayConfig.ORDER_HIGH_TO_LOW_MONEY))
		                        .uri(GatewayConfig.URI);})
	               
	               
	         //ORDER LOW TO HIGH AGE - SERVICE      
	               .route("orderLowToHighAge", r -> {
		                  return r.path(GatewayConfig.REWRITE_PATH + GatewayConfig.ORDER_PATH_AGE_STANDARD + "/lowtohigh")
		                        .filters(f -> f
		                        		.addRequestHeader("Content-Type", "application/json")
		                        		.rewritePath(GatewayConfig.REWRITE_PATH + GatewayConfig.ORDER_PATH_AGE_STANDARD + "/lowtohigh",GatewayConfig.ORDER_LOW_TO_HIGH_AGE))
		                        .uri(GatewayConfig.URI);})
	               
	               
	         //ORDER HIGH TO LOW AGE - SERVICE      
	               .route("orderHighToLowAge", r -> {
		                  return r.path(GatewayConfig.REWRITE_PATH + GatewayConfig.ORDER_PATH_AGE_STANDARD + "/hightolow")
		                        .filters(f -> f
		                        		.addRequestHeader("Content-Type", "application/json")
		                        		.rewritePath(GatewayConfig.REWRITE_PATH + GatewayConfig.ORDER_PATH_AGE_STANDARD + "/hightolow",GatewayConfig.ORDER_HIGH_TO_LOW_AGE))
		                        .uri(GatewayConfig.URI);})
	               
	               
	         //FIND PERSON BY NATIONALITY - SERVICE
	               .route("findByNationality", r -> {
		                  return r.path(GatewayConfig.REWRITE_PATH + "/find/by/nationality")
		                        .filters(f -> f
		                        		.addRequestHeader("Content-Type", "application/json")
		                        		.rewritePath(GatewayConfig.REWRITE_PATH + "/find/by/nationality",GatewayConfig.FIND_PERSON_BY_NATIONALITY))
		                        .uri(GatewayConfig.URI);})
	               
	               
	         //FIND PERSON BY NATIONALITY AND ORDER LOW TO HIGH MONEY - SERVICE
	               .route("findByNationalityAndOrderLowToHighMoney", r -> {
		                  return r.path(GatewayConfig.REWRITE_PATH + GatewayConfig.ORDER_PATH_MONEY_STANDARD + "/lowtohigh/and/nationality")
		                        .filters(f -> f
		                        		.addRequestHeader("Content-Type", "application/json")
		                        		.rewritePath(GatewayConfig.REWRITE_PATH + GatewayConfig.ORDER_PATH_MONEY_STANDARD + "/lowtohigh/and/nationality",GatewayConfig.FIND_PERSON_BY_NATIONALITY_AND_ORDER_LOW_TO_HIGH_MONEY))
		                        .uri(GatewayConfig.URI);})
	               
	               
	         //FIND PERSON BY NATIONALITY AND ORDER HIGH TO LOW MONEY - SERVICE   
	               .route("findByNationalityAndOrderHighToLowMoney", r -> {
		                  return r.path(GatewayConfig.REWRITE_PATH + GatewayConfig.ORDER_PATH_MONEY_STANDARD + "/hightolow/and/nationality")
		                        .filters(f -> f
		                        		.addRequestHeader("Content-Type", "application/json")
		                        		.rewritePath(GatewayConfig.REWRITE_PATH + GatewayConfig.ORDER_PATH_MONEY_STANDARD + "/hightolow/and/nationality",GatewayConfig.FIND_PERSON_BY_NATIONALITY_AND_ORDER_HIGH_TO_LOW_MONEY))
		                        .uri(GatewayConfig.URI);})
	               
	               
	         //FIND PERSON BY NATIONALITY AND ORDER LOW TO HIGH AGE - SERVICE   
	               .route("findByNationalityAndOrderLowToHighAge", r -> {
		                  return r.path(GatewayConfig.REWRITE_PATH + GatewayConfig.ORDER_PATH_AGE_STANDARD + "/lowtohigh/and/nationality")
		                        .filters(f -> f
		                        		.addRequestHeader("Content-Type", "application/json")
		                        		.rewritePath(GatewayConfig.REWRITE_PATH + GatewayConfig.ORDER_PATH_AGE_STANDARD + "/lowtohigh/and/nationality",GatewayConfig.FIND_PERSON_BY_NATIONALITY_AND_ORDER_LOW_TO_HIGH_AGE))
		                        .uri(GatewayConfig.URI);})
	               
	               
	         //FIND PERSON BY NATIONALITY AND ORDER HIGH TO LOW AGE - SERVICE     
	               .route("findByNationalityAndOrderHighToLowAge", r -> {
		                  return r.path(GatewayConfig.REWRITE_PATH + GatewayConfig.ORDER_PATH_AGE_STANDARD + "/hightolow/and/nationality")
		                        .filters(f -> f
		                        		.addRequestHeader("Content-Type", "application/json")
		                        		.rewritePath(GatewayConfig.REWRITE_PATH + GatewayConfig.ORDER_PATH_AGE_STANDARD + "/hightolow/and/nationality",GatewayConfig.FIND_PERSON_BY_NATIONALITY_AND_HIGH_TO_LOW_AGE))
		                        .uri(GatewayConfig.URI);})
	               
	               
	         //FIND PERSONS AVAILABLE TO TRANSFER - SERVICE
	               .route("findPersonsAvailableToTransfer", r -> {
		                  return r.path(GatewayConfig.REWRITE_PATH +  "/available/transfer")
		                        .filters(f -> f
		                        		.addRequestHeader("Content-Type", "application/json")
		                        		.rewritePath(GatewayConfig.REWRITE_PATH + "/available/transfer", GatewayConfig.FIND_PERSONS_AVAILABLE_TO_TRANSFER))
		                        .uri(GatewayConfig.URI);})
	               
	               
	         //MONEY TRANSFER - SERVICE
	               .route("moneyTransfer", r -> {
		                  return r.path(GatewayConfig.REWRITE_PATH +  "/transfer")
		                        .filters(f -> f
		                        		.addRequestHeader("Content-Type", "application/json")
		                        		.rewritePath(GatewayConfig.REWRITE_PATH + "/transfer", GatewayConfig.MONEY_TRANSFER))
		                        .uri(GatewayConfig.URI);})
	               
	               
	               
	               .build();

    }


	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		// TODO Auto-generated method stub
		String requestURL =  exchange.getRequest().getURI().getPath().toString();
		String id = exchange.getRequest().getId();
		String method = exchange.getRequest().getMethodValue();
		
		
		if (requestURL.equals(GatewayConfig.ALL_PERSONS)) this.saveLog(id, method, requestURL, GatewayConfig.ALL_PERSONS);
		else if (requestURL.equals(GatewayConfig.FIND_PERSON)) this.saveLog(id, method, requestURL, GatewayConfig.FIND_PERSON);
		else if (requestURL.equals(GatewayConfig.UPDATE_PERSON)) this.saveLog(id, method, requestURL, GatewayConfig.UPDATE_PERSON);
		else if (requestURL.equals(GatewayConfig.DELETE_PERSON)) this.saveLog(id, method, requestURL, GatewayConfig.DELETE_PERSON);
		else if (requestURL.equals(GatewayConfig.FIND_PERSON_BY_NATIONALITY)) this.saveLog(id, method, requestURL, GatewayConfig.FIND_PERSON_BY_NATIONALITY);
		else if (requestURL.equals(GatewayConfig.FIND_PERSON_BY_NATIONALITY_AND_ORDER_LOW_TO_HIGH_AGE)) this.saveLog(id, method, requestURL, GatewayConfig.FIND_PERSON_BY_NATIONALITY_AND_ORDER_LOW_TO_HIGH_AGE);
		else if (requestURL.equals(GatewayConfig.FIND_PERSON_BY_NATIONALITY_AND_HIGH_TO_LOW_AGE)) this.saveLog(id, method, requestURL, GatewayConfig.FIND_PERSON);
		else if (requestURL.equals(GatewayConfig.FIND_PERSON_BY_NATIONALITY_AND_ORDER_LOW_TO_HIGH_MONEY)) this.saveLog(id, method, requestURL, GatewayConfig.FIND_PERSON_BY_NATIONALITY_AND_ORDER_LOW_TO_HIGH_MONEY);
		else if (requestURL.equals(GatewayConfig.FIND_PERSON_BY_NATIONALITY_AND_ORDER_HIGH_TO_LOW_MONEY)) this.saveLog(id, method, requestURL, GatewayConfig.FIND_PERSON_BY_NATIONALITY_AND_ORDER_HIGH_TO_LOW_MONEY);
		else if (requestURL.equals(GatewayConfig.ORDER_LOW_TO_HIGH_AGE)) this.saveLog(id, method, requestURL, GatewayConfig.ORDER_LOW_TO_HIGH_AGE);
		else if (requestURL.equals(GatewayConfig.ORDER_HIGH_TO_LOW_AGE)) this.saveLog(id, method, requestURL, GatewayConfig.ORDER_HIGH_TO_LOW_AGE);
		else if (requestURL.equals(GatewayConfig.ORDER_LOW_TO_HIGH_MONEY)) this.saveLog(id, method, requestURL, GatewayConfig.ORDER_LOW_TO_HIGH_MONEY);
		else if (requestURL.equals(GatewayConfig.ORDER_HIGH_TO_LOW_MONEY)) this.saveLog(id, method, requestURL, GatewayConfig.ORDER_LOW_TO_HIGH_MONEY);
		else if (requestURL.equals(GatewayConfig.FIND_PERSONS_AVAILABLE_TO_TRANSFER)) this.saveLog(id, method, requestURL, GatewayConfig.FIND_PERSONS_AVAILABLE_TO_TRANSFER);
		else if (requestURL.equals(GatewayConfig.MONEY_TRANSFER)) this.saveLog(id, method, requestURL, GatewayConfig.MONEY_TRANSFER);
		
		return chain.filter(exchange);
	}
	
	
	public void saveLog(String id, String method, String requestURL, String redirectURL) {
		log.info("{'id' : " + id + ", 'method' : " + method + ", 'Path received' : " + requestURL + ", 'RedirectTo' : " + GatewayConfig.URI + redirectURL + "}");		
	}
}
