package kodlama.io.rentACar;

import java.util.HashMap;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import kodlama.io.rentACar.core.utilities.exceptions.BusinessException;
import kodlama.io.rentACar.core.utilities.exceptions.ProblimDetails;
import kodlama.io.rentACar.core.utilities.exceptions.ValidationProblimDetails;

@SpringBootApplication
@RestControllerAdvice
public class RentACarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentACarApplication.class, args);
	}
	
	@ExceptionHandler
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ProblimDetails handelBusinessException(BusinessException businessException){
		ProblimDetails problimDetails = new ProblimDetails();
		problimDetails.setMassage(businessException.getMessage());
		
		return problimDetails;
	}
	
	@ExceptionHandler
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ProblimDetails handelValidationException(MethodArgumentNotValidException mathodArgumentNotValidException){
		ValidationProblimDetails validationProblimDetails = new ValidationProblimDetails ();
		validationProblimDetails.setMassage("VALIDETION.EXCEPTION");
		
	    validationProblimDetails.setValidationErrors(new HashMap<String,String>());
		 for (FieldError fielsError : mathodArgumentNotValidException.getBindingResult().getFieldErrors()) {
			 validationProblimDetails.getValidationErrors().put(fielsError. getField(),(fielsError.getDefaultMessage()));
		 }
		return validationProblimDetails;
	}
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
