package tn.dari.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.dari.entities.Credit;
import tn.dari.repository.CreditRep;
import tn.dari.repository.UserRep;
import tn.dari.service.CreditService;
import tn.dari.service.ICreditService;

@RestController
public class CreditRestController {
	@Autowired
	CreditService cr;
	@Autowired
	UserRep rp;
	@Autowired
	CreditRep crp;
	@Autowired
	ICreditService iCreditService;
	
	@GetMapping(value="/listofcredit")
	@ResponseBody
	public List<Credit> getAllCredit()  {
		return cr.getAllCredit();
	}
	
	
	@PostMapping("/cr/addCredit")
	public void ajouterCredit( @RequestBody Credit c)
	{
		cr.addCredit(c);
		}
	
	@DeleteMapping("/delete_credit/{id_credit}")
	public void  delete_Credit(@PathVariable("id_credit") int id_credit) {
		
		 cr.deleteCreditById(id_credit);
	}


	
	@PutMapping("/updateCredit")
	public Credit updateCredit(@RequestBody Credit c )
	{
		return cr.updateCredit(c);
	}
	
	// http://localhost:8087/SpringMVC/servlet/calculate_paiement/1
	@PutMapping(value = "calculate_paiement/{CreditId}")
	@ResponseBody
	public Double calculate_paiement(@PathVariable("CreditId") int CreditId) {


		return cr.calculate_paiement(CreditId);
	}
	
	@GetMapping("credits/{id}/get")
	public Credit afficherCredit(@PathVariable("id") int id)
	{
		return cr.afficherCredit(id);
	}
	
	// http://localhost:8087/SpringMVC/servlet/affectUserTOCredit/2/2
		@PutMapping(value = "/affectUserTOCredit/{iduser}/{idCredit}")
		public void affectUserTOCredit(@PathVariable("iduser") Long userID,
				@PathVariable("idCredit") int CreditID) {

			iCreditService.affectUserTOCredit(userID, CreditID);

		}
		
		// http://localhost:8087/SpringMVC/servlet/Simulate_credit/1
		@PutMapping(value = "Simulate_credit/{CreditID}")
		@ResponseBody
		public void Simulate_credit(@PathVariable("CreditID") int CreditID) {
			iCreditService.Simulate_credit(CreditID);
			
		}
		
		
		

}
