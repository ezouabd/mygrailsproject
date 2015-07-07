package com.ajit.controller

import com.ajit.domain.ErrorMessage
import com.ajit.domain.VoucherAgent;

import grails.converters.JSON
import grails.rest.RestfulController;
import grails.transaction.Transactional;

class VoucherAgentController extends RestfulController {
    static responseFormats = ['json', 'xml']
    VoucherAgentController() {
        super(VoucherAgent)
    }
	
	
	
	def index() 
	{
		respond VoucherAgent.list();
	}
		
	def show(VoucherAgent voucherAgent) {
    if(voucherAgent == null) {
		//errorMessage = new ErrorMessage(code:"404",message:"invalid credentials")
       // respond   code:"404",message:"invalid credentials" as JSON
		
		render(contentType: "text/json") {
			//new ErrorMessage(code:"404",message:"invalid credentials")
			respond  code:"404",message:"invalid credentials"
			}
		
		
    }
    
    else {
        respond  voucherAgent
    }
}
	
	@Transactional
	def save(VoucherAgent voucherAgent) {
		voucherAgent.save flush:true
    
    }
	
		
	
	@Transactional
	def update() {
		
		String valeur
		if ("${ request.contentType }".startsWith('application/json')) {
			request.JSON.entrySet().each {
			params.put it.key, it.value
			
			valeur = it.value;
			
		  }
		}
		
		
		respond VoucherAgent.get(params.id).with {
			title = valeur
            save()
        }
	}
	
	@Transactional
	def delete(VoucherAgent voucherAgent) {
	
		String valeur
		
		respond VoucherAgent.get(params.id).delete()
			
		
	}
	
	def called() {
		def book1 = new  VoucherAgent(title:"Bismilah")	
		//def book2 = new Book(title: title)	
		respond save(VoucherAgent);
		
	}
	
	def called1() {
		String valeur
		if ("${ request.contentType }".startsWith('application/json')) { 
        request.JSON.entrySet().each {
        params.put it.key, it.value
		//valeur = it.value;
		
		
      }
		//String first_name = it.value.
    }
		//def voucherAgent1 = new VoucherAgent(first_name:params.last_name,last_name:params.get("last_name"),voucher_img_url:params.get("voucher_img_url"),voucher_name:params.get("voucher_name"))
		def voucherAgent1 = new VoucherAgent(first_name:params.first_name,last_name:params.last_name,voucher_img_url:params.voucher_img_url,voucher_name:params.voucher_name)
		
		respond save(voucherAgent1);
	}
}

