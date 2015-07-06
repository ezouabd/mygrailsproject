package com.ajit.domain

import grails.rest.Resource

@Resource(uri='/VoucherAgent', formats=['json', 'xml'])

class VoucherAgent {

	String voucher_name
	String first_name
	String last_name
	String voucher_img_url
	
	
    static constraints = {
    }
}
