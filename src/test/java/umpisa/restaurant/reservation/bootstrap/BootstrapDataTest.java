package umpisa.restaurant.reservation.bootstrap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import umpisa.restaurant.reservation.repositories.ReservationRepository;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class BootstrapDataTest {

    @Autowired
    ReservationRepository reservationRepository;

    BootstrapData bootstrapData;

    @BeforeEach
    void setUp() {
        bootstrapData = new BootstrapData(reservationRepository);
    }

    @Test
    void Testrun() throws Exception {
        bootstrapData.run(null);

        assertThat(reservationRepository.count()).isEqualTo(4);
    }
}





