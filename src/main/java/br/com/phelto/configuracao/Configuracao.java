package br.com.phelto.configuracao;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Configuracao {

	static final String QUEUE_NAME = "queueTeste";
	
	static final String EXCHANGE_NAME = "exchange.direct";
	
	 @Bean
	 Queue queue() {
	    return new Queue(QUEUE_NAME, true);
	 }
	 
	 @Bean
	 DirectExchange exchange() {
	    return new DirectExchange(EXCHANGE_NAME, true, true);
	 }
	 
	 @Bean
	 Binding binding(Queue queue, DirectExchange exchange) {
	    return BindingBuilder.bind(queue).to(exchange).with("foo.bar.*");
	 }
	 
	 @Bean
	 SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
	    
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
	    container.setConnectionFactory(connectionFactory);
	    container.setQueueNames(QUEUE_NAME);
	    container.setMessageListener(listenerAdapter);
	    return container;
	  }
	 
	  @Bean
	  MessageListenerAdapter listenerAdapter(Receiver receiver) {
	    return new MessageListenerAdapter(receiver, "receiveMessage");
	  }
}
