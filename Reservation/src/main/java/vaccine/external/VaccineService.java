package vaccine.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name="Vaccine", url="http://Vaccine:8080")
public interface VaccineService {
    @RequestMapping(method= RequestMethod.GET, path="/vaccines")
    public void checkVaccine(@RequestBody Vaccine vaccine);

}

