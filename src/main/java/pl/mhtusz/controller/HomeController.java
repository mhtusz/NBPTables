package pl.mhtusz.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import pl.mhtusz.data.NBPTableRepository;
import pl.mhtusz.model.NBPTable;



@Controller
public class HomeController {
	
	
    private NBPTableRepository nBPTableRepository;

    @Autowired
    public HomeController(NBPTableRepository nBPTableRepository) {
        this.nBPTableRepository = nBPTableRepository;
    }	

	
	@GetMapping("/")
    public String refresch(Model model) {
		RestTemplate restTemplate = new RestTemplate();
    	NBPTable[] nbpTable = restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/tables/a", NBPTable[].class);
    	model.addAttribute("tableA", nbpTable[0]);

       	NBPTable[] nbpTableB = restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/tables/b", NBPTable[].class);
        model.addAttribute("tableB", nbpTableB[0]);
               
    	if (nBPTableRepository.findByNo(nbpTable[0].getNo()).size()==0) {
    		nBPTableRepository.save(nbpTable[0]); 
    	};
    	
    	
    	if (nBPTableRepository.findByNo(nbpTableB[0].getNo()).size()==0) {
    		nBPTableRepository.save(nbpTableB[0]);
    	};   	
    	

        return "nbptables";
    }
	
	
    
}