package libraryAPI.example.CRUDapplication;

import libraryAPI.example.CRUDapplication.model.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ListResourceBundle;

@SpringBootApplication
public class CruDapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruDapplicationApplication.class, args);
	}


}
