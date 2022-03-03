package com.example.demo;

import org.axonframework.eventhandling.gateway.EventGateway;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main( final String[] args ) {
		final ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder( DemoApplication.class )
				.logStartupInfo( false )
				.bannerMode( Mode.OFF )
				.run( args );

		final Object demoEventHandler1 = applicationContext.getBean( "demoEventHandler1" );
		System.out.println( String.format( "DemoEventHandler1 is of type %s", demoEventHandler1.getClass( ) ) );
		final Object demoEventHandler2 = applicationContext.getBean( "demoEventHandler2" );
		System.out.println( String.format( "DemoEventHandler2 is of type %s", demoEventHandler2.getClass( ) ) );

		final EventGateway eventGateway = applicationContext.getBean( EventGateway.class );
		eventGateway.publish( 42 );
	}

}
