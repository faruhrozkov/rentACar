package kodlama.io.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACar.entiries.concretes.Model;

public interface ModelRepository extends JpaRepository<Model, Integer> {

}
