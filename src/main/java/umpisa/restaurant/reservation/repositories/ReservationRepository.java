package umpisa.restaurant.reservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umpisa.restaurant.reservation.entities.Reservation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

//    @Query("SELECT Reservation as e FROM Reservation  e WHERE e.reservationDateTime >= :today AND e.isActive = true")
//    List<Reservation> findByReservationDateGreaterThanAndIsActiveTrue(@Param("today") LocalDateTime today);

    List<Reservation> findAllByIsActiveAndReservationDateTimeGreaterThan(Boolean isActive, LocalDateTime today);

}
