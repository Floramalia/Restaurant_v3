package SDA.Restaurant_v3.service;

import SDA.Restaurant_v3.entities.ReservationsModel;
import SDA.Restaurant_v3.entities.TableStatus;
import SDA.Restaurant_v3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public void addReservation(ReservationsModel reservationsModel){
        List<ReservationsModel> reservationsModelList = reservationRepository.findAll();
        for (ReservationsModel reservations:reservationsModelList) {
            if(reservationsModel.getStartDateTime() != reservations.getStartDateTime() &&
                    reservationsModel.getEndDateTime() != reservations.getEndDateTime()) {

            }
        }
    }
}
