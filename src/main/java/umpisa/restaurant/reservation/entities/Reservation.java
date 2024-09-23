package umpisa.restaurant.reservation.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = {"id"})
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Version
    private Integer version;
    private String customerName;
    @Column(nullable = true)
    private String phoneNumber;
    @Column(nullable = true)
    private String email;
    private LocalDateTime reservationDateTime;
    private String preferredMethod;
    private Integer numberOfGuests;
    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime updateDate;
    @Column(nullable = false, columnDefinition = "boolean default true")
    private boolean isActive;


}