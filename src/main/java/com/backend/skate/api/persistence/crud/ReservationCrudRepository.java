package com.backend.skate.api.persistence.crud;

import com.backend.skate.api.persistence.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {

    @Query("SELECT c.client, COUNT(c.client) FROM Reservation AS c GROUP BY c.client ORDER BY COUNT(c.client) DESC"  )
    public List<Object[]> countTotalReservationsByClients();

    public List<Reservation> findAllByStartDateAfterAndDevolutionDateBefore(Date dateOne, Date dateTwo);

    public List<Reservation> findAllByStatus(String status);

}
