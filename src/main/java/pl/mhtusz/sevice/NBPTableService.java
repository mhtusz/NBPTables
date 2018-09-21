package pl.mhtusz.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.mhtusz.data.NBPTableRepository;
import pl.mhtusz.model.NBPTable;

@Service
public class NBPTableService {

	@Autowired
	private NBPTableRepository nBPTableRepository;

	public NBPTable getNBPTable(String tableType) {
		RestTemplate restTemplate = new RestTemplate();
		NBPTable[] nbpTable = restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/tables/" + tableType,
				NBPTable[].class);

		if (nBPTableRepository.findByNo(nbpTable[0].getNo()).size() == 0) {
			nBPTableRepository.save(nbpTable[0]);
		}
		;
		return nbpTable[0];
	}

}
