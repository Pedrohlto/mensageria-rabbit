package br.com.phelto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.phelto.dto.MensagemDto;
import br.com.phelto.service.EnvioService;

@RestController
@RequestMapping("/mensagem")
public class EnvioController {

	@Autowired
	EnvioService envioService;
	
	@PostMapping
	public void enviarMensagem(@RequestBody MensagemDto msgDto) {
		
		envioService.enviarMensagem(msgDto.getMensagem());
		
	}

}

