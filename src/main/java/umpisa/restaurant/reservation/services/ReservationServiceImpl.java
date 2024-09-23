package umpisa.restaurant.reservation.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import umpisa.restaurant.reservation.controller.NotFoundException;
import umpisa.restaurant.reservation.entities.Reservation;
import umpisa.restaurant.reservation.mappers.ReservationMapper;
import umpisa.restaurant.reservation.model.ReservationDTO;
import umpisa.restaurant.reservation.repositories.ReservationRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    private final ReservationMapper reservationMapper;



    @Override
    public List<ReservationDTO> viewReservations() {

        return reservationRepository.findAllByIsActiveAndReservationDateTimeGreaterThan(true, LocalDateTime.now())
//        log.debug("List Size: " + rList.size());
//        return reservationRepository.findAll()
                .stream()
                .map(reservationMapper::reservationToReservationDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ReservationDTO saveNewReservation(ReservationDTO reservationDTO) {
        return reservationMapper.reservationToReservationDTO(
                reservationRepository.save(
                        reservationMapper.reservationDTOToReservation(reservationDTO)));
    }

    @Override
    public void updateReservationById(Long reservationId, ReservationDTO reservationDTO) {
        reservationRepository.findById(reservationId).ifPresentOrElse(foundReservation -> {
            foundReservation.setNumberOfGuests(reservationDTO.getNumberOfGuests());
            foundReservation.setReservationDateTime(reservationDTO.getReservationDateTime());
            foundReservation.setUpdateDate(LocalDateTime.now());
            reservationRepository.save(foundReservation);
        }, () -> {
            throw new NotFoundException("Reservation was not found");
        });
    }

    @Override
    public void cancelReservation(Long reservationId) {
        reservationRepository.findById(reservationId).ifPresentOrElse(deletedReservation -> {
            deletedReservation.setActive(false);
            reservationRepository.save(deletedReservation);
        }, () -> {
            throw new NotFoundException("Reservation was not found");
        });
    }


}