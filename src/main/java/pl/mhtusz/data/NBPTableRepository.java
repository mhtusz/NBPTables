package pl.mhtusz.data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mhtusz.model.NBPTable;



@Repository
public interface NBPTableRepository extends JpaRepository<NBPTable, Long>{

	List<NBPTable> findByNo(String table);

	
}
