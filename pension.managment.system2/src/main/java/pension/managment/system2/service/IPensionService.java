package pension.managment.system2.service;


import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import pension.managment.system2.service.IPensionService;
import pension.managment.system2.repository.IPensionRepository;
import pension.managment.system2.exception.PensionDetailsNotFoundException;
import pension.managment.system2.model.PensionDetails;

@Service
public class IPensionService {

	private static final Logger LOG = LoggerFactory.getLogger(IPensionService.class);
	@Autowired
	private IPensionRepository pensionRepository;
	
	public PensionDetails addPensionDetails(PensionDetails pensionDetails) {
		
		LOG.info("Service Addpension");
		if (pensionRepository.findById(pensionDetails.getPensioner_id())!=null)
			return pensionRepository.save(pensionDetails);
		System.out.println(pensionDetails.getPensioner_id() + " already exists.");
		return null;
	}
	
	public PensionDetails updatePensionDetails(PensionDetails pensionDetails) {
		LOG.info("Service update");
		if (pensionRepository.findById(pensionDetails.getPensioner_id()) != null)

			return pensionRepository.save(pensionDetails);
		LOG.info(pensionDetails.getPensioner_id() + " does not exist.");
		return null;
	}
	
	public PensionDetails viewPensionDetails(int pensionerId) {
		LOG.info("Service View pension details");
		Optional<PensionDetails> empOpt = pensionRepository.findById(pensionerId);
		if(empOpt.isPresent()) {
			LOG.info("pension deatils present");
			return empOpt.get();
		} else {
			LOG.info("pension details is NOT available.");
			throw new PensionDetailsNotFoundException(pensionerId + " this employee is not found.");
		}
	}
	public PensionDetails deletePensionDetails(int pensionerId) {
		LOG.info("service delete pension details");
		Optional<PensionDetails> empOpt = pensionRepository.findById(pensionerId);
		if (empOpt.isPresent()) {
			pensionRepository.deleteById(pensionerId);
			return empOpt.get();
		} else {
			throw new PensionDetailsNotFoundException(pensionerId + " this employee does not exist.");
		}
	}
}

