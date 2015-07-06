import com.ajit.domain.VoucherAgent

class BootStrap {

    def init = { servletContext ->
		new VoucherAgent(voucher_name:"PROMO EYDON RAMADAN",first_name: "MOUSSA", last_name:"FAYE",voucher_img_url: "RAS").save()
    }
    def destroy = {
    }
}
