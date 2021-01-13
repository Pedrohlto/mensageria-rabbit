package br.com.phelto.configuracao;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
	
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	public void enviarMensagem(String msg) {
		
		rabbitTemplate.convertAndSend(Configuracao.EXCHANGE_NAME, "foo.bar.#", msg);
	}
	
	

}
