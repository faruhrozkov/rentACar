package kodlama.io.rentACar.besiness.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.besiness.abstracts.BrandService;
import kodlama.io.rentACar.besiness.requests.CreactBrandRequest;
import kodlama.io.rentACar.besiness.requests.UpdateBrandRequest;
import kodlama.io.rentACar.besiness.responses.GetAllBrandResponse;
import kodlama.io.rentACar.besiness.responses.GetByIdBrandResponse;
import kodlama.io.rentACar.besiness.rules.BrandBusinessRules;
import kodlama.io.rentACar.core.utilities.mappers.ModelMepperService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entiries.concretes.Brand;
import lombok.AllArgsConstructor;

@Service//Bu sinf bir bisiness nesnesidir
@AllArgsConstructor
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;
    private ModelMepperService modelMepperService;
    private BrandBusinessRules brandBusinessRules;
	
  
	@Override
	public List<GetAllBrandResponse> getAll() {
		
		List<Brand>brands = brandRepository.findAll();
		
		List<GetAllBrandResponse> brandResponse = brands.stream()
				.map(brad->this.modelMepperService.forResponse()
						.map(brad,GetAllBrandResponse.class)).collect(Collectors.toList());
          return brandResponse;
    }
     
		@Override
		public void add(CreactBrandRequest creactBrandRequest) {			
			this.brandBusinessRules.checkIfBrandNameExists(creactBrandRequest.getName());
			
			 Brand brand = this.modelMepperService.forRequest().map(creactBrandRequest, Brand.class);
			this.brandRepository.save(brand);
			
		}

		@Override
		public GetByIdBrandResponse getById(int id) {
			this.brandRepository.findById(id).orElseThrow();
			GetByIdBrandResponse response
			= this.modelMepperService.forResponse().map(brand, GetByIdBrandResponse.class);
			
			return response;
		}

		@Override
		public void update(UpdateBrandRequest updateBrandRequest) {
			 Brand brand = this.modelMepperService.forRequest().map(updateBrandRequest, Brand.class);
				this.brandRepository.save(brand);
			
		}

		@Override
		public void delete(int id) {
			this.brandRepository.deleteById(id);
			
		}
}


