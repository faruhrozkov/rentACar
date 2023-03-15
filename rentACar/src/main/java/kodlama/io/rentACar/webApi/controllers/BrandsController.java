package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.rentACar.besiness.abstracts.BrandService;
import kodlama.io.rentACar.besiness.requests.CreactBrandRequest;
import kodlama.io.rentACar.besiness.requests.UpdateBrandRequest;
import kodlama.io.rentACar.besiness.responses.GetAllBrandResponse;
import kodlama.io.rentACar.besiness.responses.GetByIdBrandResponse;
import lombok.AllArgsConstructor;

@RestController//annotation
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
	private BrandService brandService;
	
    @GetMapping()
    public List<GetAllBrandResponse> getAll(){
    	return brandService.getAll();
    	
    }
    @GetMapping("/{id}")
    public GetByIdBrandResponse getById(@PathVariable int id){
    	return brandService.getById(id);
    }
    
    @PostMapping()
    @ResponseStatus(code=HttpStatus.CREATED)
    public void add(@RequestBody()@Valid CreactBrandRequest creactBrandRequest) {
    	this.brandService.add(creactBrandRequest);
    }
    @PutMapping
    public void update(@RequestBody() UpdateBrandRequest updateBrandRequest) {
    	this.brandService.update(updateBrandRequest);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@RequestBody int id){
    	this.brandService.delete(id);
    	
    }
}
