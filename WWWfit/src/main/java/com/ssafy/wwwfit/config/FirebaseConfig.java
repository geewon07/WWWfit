package com.ssafy.wwwfit.config;

import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.messaging.FirebaseMessaging;

@Configuration
public class FirebaseConfig {
	
	@Bean
    public FirebaseApp firebaseApp() throws IOException {
        FileInputStream serviceAccount =
        new FileInputStream("src/main/resources/fit-66c29-firebase-adminsdk-1zdfi-cebc828cc2.json");

        if (FirebaseApp.getApps().isEmpty()) {
	        FirebaseOptions options = new FirebaseOptions.Builder()
	        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
	        .build();
	        FirebaseApp.initializeApp(options);
	    }
        
        return FirebaseApp.getInstance();
    }


	@Bean
	public FirebaseAuth getFirebaseAuth() throws IOException{
		FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(firebaseApp());
		return firebaseAuth;
	}
	
	@Bean
	FirebaseMessaging firebaseMessaging(FirebaseApp firebaseApp) {
	    return FirebaseMessaging.getInstance(firebaseApp);
	}
}