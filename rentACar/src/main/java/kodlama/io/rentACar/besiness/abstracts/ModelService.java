package kodlama.io.rentACar.besiness.abstracts;

import java.util.List;

import kodlama.io.rentACar.besiness.requests.CreateModelRequest;
import kodlama.io.rentACar.besiness.responses.GetAllModelsResponse;

public interface ModelService {
	 List<GetAllModelsResponse> getAll();
	 void add(CreateModelRequest createModelRequest);
}
