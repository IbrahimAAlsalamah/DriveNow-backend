package com.example.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class FirebaseInitializer {

    @PostConstruct
    public void initFirebase() {
        try {
            InputStream serviceAccount = getClass().getClassLoader()
                    .getResourceAsStream("serviceAccountKey.json");

            if (serviceAccount == null) {
                throw new RuntimeException("Firebase service account file not found");
            }

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
                System.out.println("✅ Firebase has been initialized successfully.");
            }

        } catch (IOException e) {
            throw new RuntimeException("Firebase initialization error", e);
        }
    }

    @Bean
    public FirebaseAuth firebaseAuth() {
        return FirebaseAuth.getInstance();
    }
}
