package kodlama.io.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACar.entiries.concretes.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer>{
	boolean existsByName(String name); //sprin jpa keywors
	

	
	
}
