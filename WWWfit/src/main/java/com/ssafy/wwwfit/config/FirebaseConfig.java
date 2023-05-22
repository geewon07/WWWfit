package com.ssafy.wwwfit.config;

import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;

@Configuration
public class FirebaseConfig {
	
	@Bean
    public FirebaseApp firebaseApp() throws IOException {
        FileInputStream serviceAccount =
        new FileInputStream("src/main/resources/firebase/fit-66c29-firebase-adminsdk-1zdfi-cebc828cc2.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
        .build();
        
        FirebaseApp app = FirebaseApp.initializeApp(options);
        return app;
    }


	@Bean
	public FirebaseAuth getFirebaseAuth() throws IOException{
		FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(firebaseApp());
		return firebaseAuth;
	}
}
