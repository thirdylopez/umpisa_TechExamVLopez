package umpisa.restaurant.reservation.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;



import java.time.LocalDateTime;
@Builder
@Data
@ToString
@EqualsAndHashCode(of = {"id"})
public class ReservationDTO {
    private Long id;
    private Integer version;
    private String customerName;
    private String phoneNumber;
    private String email;
    private String preferredMethod;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime reservationDateTime;
    private Integer numberOfGuests;
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;

}