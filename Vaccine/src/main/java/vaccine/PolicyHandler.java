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
    @Autowired VaccineRepository vaccineRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverVaccineBacked_BackVaccine(@Payload VaccineBacked vaccineBacked){

        if(!vaccineBacked.validate()) return;

        System.out.println("\n\n##### listener BackVaccine : " + vaccineBacked.toJson() + "\n\n");



        // Sample Logic //
        // Vaccine vaccine = new Vaccine();
        // vaccineRepository.save(vaccine);

    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}