package fr.fms;

import fr.fms.dao.TrainingRepository;
import fr.fms.entities.Training;
import fr.fms.service.ImplTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiTrainingsApplication implements CommandLineRunner{

	@Autowired
	private TrainingRepository trainingRepository;

	public static void main(String[] args) {
		SpringApplication.run(ApiTrainingsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	trainingRepository.save(new Training(null, "Java","Java Standard Edition 8 sur 5 jours", 3500.0, "\\assets\\java.jpg", 1));
	trainingRepository.save(new Training(null, "DotNet","DotNet & entity framework en 5 jours", 2750.0, "\\assets\\asp.webp", 1));
	trainingRepository.save(new Training(null, "PowerBi","Business Intelligence en 5 jours", 3000.0, "\\assets\\powerbi.png", 1));
	trainingRepository.save(new Training(null, "NodeJs","Prise en main de NodeJs/Express 2 jours", 3500.0, "\\assets\\nodejs.png", 1));
	trainingRepository.save(new Training(null, "Php","Initiation au Dev/Web avec hp 4 jours", 1300.0, "\\assets\\php.png", 1));

	System.out.println("Ready!");

	}

}
