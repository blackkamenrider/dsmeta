package com.hosias.dsmeta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hosias.dsmeta.entities.Sale;
import com.hosias.dsmeta.repositories.SaleRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsService {

	@Value("${twilio.sid}")//este twilio.sid é o mesmo do aplication.properties, o @value faz a busca la na variavel de ambiente(coloco separado por questao de segurança) e coloca neste caso dentro da variavel private String twilioSid 
	private String twilioSid;

	@Value("${twilio.key}")
	private String twilioKey;

	@Value("${twilio.phone.from}")
	private String twilioPhoneFrom;

	@Value("${twilio.phone.to}")
	private String twilioPhoneTo;
	
	@Autowired
	private SaleRepository saleRepository;//usarei para buscar o id no banco de dados

	public void sendSms(Long saleId) { 
// esta funçao metodo envia a ,esagem ... o codigo foi baseado na documentaçao da api da twilio como se usa a api no caso java.

		Sale sale = saleRepository.findById(saleId).get(); // com essa linha pego o id 
		
		String date = sale.getDate().getMonthValue() + "/" + sale.getDate().getYear(); // com esta linha eu coloquei dentro de date a variavel string uma data no formato mes e ano
		
		String msg = "Vendedor " +sale.getSellerName() + "\nVendeu R$: " + String.format("%.2f", sale.getAmount()) + "\n na data : " + date ;// string fomat para colocar o valor formatado com duas casas decimais
		
		Twilio.init(twilioSid, twilioKey);

		PhoneNumber to = new PhoneNumber(twilioPhoneTo);
		PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

		Message message = Message.creator(to, from, msg).create();

		System.out.println(message.getSid());
	}
}