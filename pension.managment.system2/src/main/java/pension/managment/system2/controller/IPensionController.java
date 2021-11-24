package pension.managment.system2.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



import pension.managment.system2.controller.IPensionController;
import pension.managment.system2.model.PensionDetails;
import pension.managment.system2.service.IPensionService;

@RestController
public class IPensionController {
	
	private static final Logger LOG = LoggerFactory.getLogger(IPensionController.class);

	@Autowired
	private IPensionService pensionService;

	@PostMapping(path= "/addpension")
	public ResponseEntity<PensionDetails> addPension(@RequestBody PensionDetails pensionDetails){
		LOG.info("Adding pension Details");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "pension details added successfully.");
		return new ResponseEntity<PensionDetails>(pensionService.addPensionDetails(pensionDetails), headers, HttpStatus.CREATED);
		
		
	}
	
	@PutMapping("/updatepension")
	public ResponseEntity<PensionDetails> updatepension(@RequestBody  PensionDetails pensionDetails ){
		LOG.info("update pension");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "pension details updated successfully.");
		return new ResponseEntity<PensionDetails>(pensionService.updatePensionDetails(pensionDetails), headers, HttpStatus.CREATED);
		
				
	}
	
	@GetMapping("/getpensiondetailsbyid/{pensionid}")
	public ResponseEntity<PensionDetails> viewPension(@PathVariable (name = "pensionid") int pensionid){
		LOG.info("get pension details");
		PensionDetails pen = pensionService.viewPensionDetails(pensionid);// line
		LOG.info(pen.toString());
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This pension details is available in the database.");
		LOG.info(headers.toString());
		ResponseEntity<PensionDetails> response = new ResponseEntity<PensionDetails>(pen, headers, HttpStatus.OK);
		return response;
		
	}
	
	@DeleteMapping("/deletepensionbyid/{pensionid}")
	public ResponseEntity<PensionDetails> deletePension(@PathVariable int pensionid){
		LOG.info("Delete pension");
		PensionDetails pen = pensionService.deletePensionDetails(pensionid);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Employee deleted successfully.");
		ResponseEntity<PensionDetails> response = new ResponseEntity<PensionDetails>(pen, headers, HttpStatus.OK);
		return response;
		
	}
}
