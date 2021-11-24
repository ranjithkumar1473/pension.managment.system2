package pension.managment.system2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pension.managment.system2.repository.IPensionRepository;
import pension.managment.system2.model.PensionDetails;

@Repository
public interface IPensionRepository extends JpaRepository<PensionDetails, Integer> {
	
		
	}

