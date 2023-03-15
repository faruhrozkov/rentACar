package kodlama.io.rentACar.besiness.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.besiness.abstracts.ModelService;
import kodlama.io.rentACar.besiness.requests.CreateModelRequest;
import kodlama.io.rentACar.besiness.responses.GetAllModelsResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMepperService;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentACar.entiries.concretes.Model;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private ModelRepository modelRepository;
    private ModelMepperService modelMepperService;
    
	@Override
	public List<GetAllModelsResponse> getAll() {
List<Model>models = modelRepository.findAll();
		
		List<GetAllModelsResponse> modelsResponses = models.stream()
				.map(model->this.modelMepperService.forResponse()
						.map(model,GetAllModelsResponse.class)).collect(Collectors.toList());
          return modelsResponses;
    }

	@Override
	public void add(CreateModelRequest createModelRequest) {
		 Model model = this.modelMepperService.forRequest().map(createModelRequest, Model.class);
			this.modelRepository.save(model);
		
	}

}
