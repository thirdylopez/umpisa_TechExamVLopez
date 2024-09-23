package umpisa.restaurant.reservation.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import umpisa.restaurant.reservation.entities.Reservation;
import umpisa.restaurant.reservation.model.ReservationDTO;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReservationMapper {
    ReservationDTO reservationToReservationDTO(Reservation reservationDTO);

    Reservation reservationDTOToReservation(ReservationDTO reservation);
}

