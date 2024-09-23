package umpisa.restaurant.reservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umpisa.restaurant.reservation.entities.Reservation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findAllByIsActiveAndReservationDateTimeGreaterThan(Boolean isActive, LocalDateTime today);

    Optional<Reservation> findByIdAndIsActive(Long id, Boolean isActive);

}
