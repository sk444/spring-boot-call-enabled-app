package com.pixeltrice.springbootcallenabledapp;

import java.net.URI;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;

@SpringBootApplication
public class SpringBootCallEnabledAppApplication implements ApplicationRunner {

	        private final static String ACCOUNT_SID = "Your Twilio SID";
			private final static String AUTH_ID = "Twilio Auth ID";
			private final static String FROM_NUMBER="Twilio Mobile number";
			private final static String TO_NUMBER =" Mobile number To whom you want make a voice call";
	
			static {
				   Twilio.init(ACCOUNT_SID, AUTH_ID);
				}
			
	public static void main(String[] args) {
		SpringApplication.run(SpringBootCallEnabledAppApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Call.creator(new PhoneNumber(TO_NUMBER), new PhoneNumber(FROM_NUMBER),
				   new URI("http://demo.twilio.com/docs/voice.xml")).create();
		
	}

}
