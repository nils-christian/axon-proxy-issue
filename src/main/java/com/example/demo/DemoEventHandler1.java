package com.example.demo;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DemoEventHandler1 implements DemoInterface {

	@EventHandler
	@Transactional( rollbackFor = Throwable.class )
	public void on( final Integer event ) {
		System.out.println( "DemoEventHandler1 received: " + event );
	}

	public void doSomething( ) {
	}

}
