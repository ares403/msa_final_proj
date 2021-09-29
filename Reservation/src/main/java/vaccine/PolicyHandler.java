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
    @Autowired ReservationRepository reservationRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverVaccineCanceled_Cancel(@Payload VaccineCanceled vaccineCanceled){

        if(!vaccineCanceled.validate()) return;

        System.out.println("\n\n##### listener Cancel : " + vaccineCanceled.toJson() + "\n\n");



        // Sample Logic //
        // Reservation reservation = new Reservation();
        // reservationRepository.save(reservation);

    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverVaccineReserved_Reserve(@Payload VaccineReserved vaccineReserved){

        if(!vaccineReserved.validate()) return;

        System.out.println("\n\n##### listener Reserve : " + vaccineReserved.toJson() + "\n\n");



        // Sample Logic //
        // Reservation reservation = new Reservation();
        // reservationRepository.save(reservation);

    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}