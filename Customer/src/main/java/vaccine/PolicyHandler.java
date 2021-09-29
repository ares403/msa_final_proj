package vaccine;

import vaccine.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @Autowired CustomerRepository customerRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverVaccineOk_VaccineSucceded(@Payload VaccineOk vaccineOk){

        if(!vaccineOk.validate()) return;

        System.out.println("\n\n##### listener VaccineSucceded : " + vaccineOk.toJson() + "\n\n");

        Customer customer = customerRepository.findByVaccineId(vaccineOk.getId());
        customer.setVaccineId(vaccineOk.getId());
        customer.setVaccineName(vaccineOk.getName());
        customer.setReserveStatus("OK");

    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverVaccineNo_VaccineFailed(@Payload VaccineNo vaccineNo){

        if(!vaccineNo.validate()) return;

        System.out.println("\n\n##### listener VaccineFailed : " + vaccineNo.toJson() + "\n\n");

        Customer customer = customerRepository.findByVaccineId(vaccineNo.getId());
        customer.setVaccineId(vaccineNo.getId());
        customer.setVaccineName(vaccineNo.getName());
        customer.setReserveStatus("NO");

    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}