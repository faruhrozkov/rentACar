package kodlama.io.rentACar.besiness.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBrandRequest {
	 private int id;
	   private String name;
}
