package kodlama.io.rentACar.besiness.abstracts;

import java.util.List;

import kodlama.io.rentACar.besiness.requests.CreactBrandRequest;
import kodlama.io.rentACar.besiness.requests.UpdateBrandRequest;
import kodlama.io.rentACar.besiness.responses.GetAllBrandResponse;
import kodlama.io.rentACar.besiness.responses.GetByIdBrandResponse;

public interface BrandService {
    List<GetAllBrandResponse> getAll();
    GetByIdBrandResponse getById(int id);
    void add(CreactBrandRequest creactBrandRequest);
    void update( UpdateBrandRequest updateBrandRequest);
    void delete( int id);
}
