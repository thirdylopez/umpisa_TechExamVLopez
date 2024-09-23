package umpisa.restaurant.reservation.services;
import umpisa.restaurant.reservation.model.ReservationDTO;



import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReservationService {

        List<ReservationDTO> viewReservations();

        ReservationDTO saveNewReservation(ReservationDTO reservationDTO);

        void updateReservationById(Long reservationId, ReservationDTO reservationDTO);

        void cancelReservation(Long reservationId);


}
