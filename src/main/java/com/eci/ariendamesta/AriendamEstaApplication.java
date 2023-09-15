package com.eci.ariendamesta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AriendamEstaApplication {

	/**
	 * Primero pull sobre dev
	 * Luego se crea su rama
	 * Le hace commit
	 * Push a su rama remota
	 * En github le hace el merge
	 * Y en intellij se cambia de rama a "dev"
	 * Y hace pull en esa rama
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(AriendamEstaApplication.class, args);
	}

}
