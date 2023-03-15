package kodlama.io.rentACar.core.utilities.mappers;

import org.modelmapper.ModelMapper;

public interface ModelMepperService {
    ModelMapper forResponse();
    ModelMapper forRequest();
    
}
