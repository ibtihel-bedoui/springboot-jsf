package tn.dari.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.dari.entities.Bank;
import tn.dari.repository.BankRep;
import tn.dari.service.BankService;
import tn.dari.service.IBankService;

@RestController
public class BankRestController {
	@Autowired
	IBankService ba;
	@Autowired
	BankRep rep;
	@Autowired
	BankService banks;
	@Autowired
	private ServletContext context;
	
		@GetMapping(value="/listofbank")
		@ResponseBody
		public List<Bank> getAllBank()  {
			return ba.getAllBank();
		}
		@DeleteMapping("/delete_Bank/{id_bank}")
		public void  delete_Bank(@PathVariable("id_bank") Long id_bank) {
			
			 ba.deleteBankById(id_bank);
		}
		

		@PostMapping("/banks/addbank")
		public void ajouterBank( @RequestBody Bank b)
		{
			ba.ajouterBanque(b);
				}
		
		@PutMapping("/updateBank")
		public Bank updateBank(@RequestBody Bank b )
		{
			return ba.updateBank(b);
		}
	/*************************Pdf********************************/
		  @GetMapping("/createPdf")
			public void createPdf (HttpServletRequest request, HttpServletResponse response){
				List <Bank> agencies = banks.getAllBank();
				boolean isFlag = banks.createPdf(agencies, context, request, response);
				 if(isFlag){
			        	String fullPath= request.getServletContext().getRealPath("/resources/reports"+"banks"+".pdf");
			        	filedownload(fullPath, response,"Banks.pdf");
			        }
		  }
		  
				 private void filedownload(String fullPath, HttpServletResponse response, String fileName) {
						
						File file = new File(fullPath);
						final int BUFFER_SIZE =4096;
						
						if(file.exists()){
							try{
								FileInputStream inputStream =new FileInputStream(file);
								String mimeType =context.getMimeType(fullPath);
								response.setContentType(mimeType);
								response.setHeader("content-disposition", "attachement; fileName="+ fileName);
								OutputStream outputStream = response.getOutputStream();
								byte[] buffer = new byte[BUFFER_SIZE];
								int bytesRead = -1;
								while((bytesRead = inputStream.read(buffer))!= -1){
									outputStream.write(buffer, 0, bytesRead);
								}
								inputStream.close();
								outputStream.close();
								file.delete();
								
							} catch (Exception e) {
								e.printStackTrace();
								
							}
						
					}

				 }
}
