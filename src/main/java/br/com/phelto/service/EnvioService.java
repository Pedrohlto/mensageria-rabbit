package br.com.phelto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.phelto.configuracao.Sender;

@Service
public class EnvioService {
	
	@Autowired
	Sender sender;
	
	public void enviarMensagem (String msg) {
		sender.enviarMensagem(msg);
	}

}
