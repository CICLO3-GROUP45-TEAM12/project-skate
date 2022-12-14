package com.backend.skate.api.persistence;

import com.backend.skate.api.persistence.crud.ReservationCrudRepository;
import com.backend.skate.api.persistence.dto.CountClient;
import com.backend.skate.api.persistence.entity.Client;
import com.backend.skate.api.persistence.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public ReservationRepository() {
    }

    @Query("SELECT c.client, COUNT(c.client) FROM Reservation AS c GROUP BY c.client ORDER BY COUNT(c.client) DESC"  )
    public List<Object[]> countTotalReservationsByClients() {
        return reservationCrudRepository.countTotalReservationsByClients();
    }

    public List<Reservation> findAllByStartDateAfterAndDevolutionDateBefore(Date dateOne, Date dateTwo) {
        return reservationCrudRepository.findAllByStartDateAfterAndDevolutionDateBefore(dateOne, dateTwo);
    }

    public List<Reservation> findAllByStatus(String status) {
        return reservationCrudRepository.findAllByStatus(status);
    }

    public <S extends Reservation> S save(S entity) {
        return reservationCrudRepository.save(entity);
    }

    public <S extends Reservation> Iterable<S> saveAll(Iterable<S> entities) {
        return reservationCrudRepository.saveAll(entities);
    }

    public Optional<Reservation> findById(Integer integer) {
        return reservationCrudRepository.findById(integer);
    }

    public boolean existsById(Integer integer) {
        return reservationCrudRepository.existsById(integer);
    }

    public Iterable<Reservation> findAll() {
        return reservationCrudRepository.findAll();
    }

    public Iterable<Reservation> findAllById(Iterable<Integer> integers) {
        return reservationCrudRepository.findAllById(integers);
    }

    public long count() {
        return reservationCrudRepository.count();
    }

    public void deleteById(Integer integer) {
        reservationCrudRepository.deleteById(integer);
    }

    public void delete(Reservation entity) {
        reservationCrudRepository.delete(entity);
    }

    public void deleteAllById(Iterable<? extends Integer> integers) {
        reservationCrudRepository.deleteAllById(integers);
    }

    public void deleteAll(Iterable<? extends Reservation> entities) {
        reservationCrudRepository.deleteAll(entities);
    }
    public void deleteAll() {
        reservationCrudRepository.deleteAll();
    }

    public List<CountClient> getTopClients(){
        List<CountClient> result = new ArrayList<>();

        List<Object[]> report = reservationCrudRepository.countTotalReservationsByClients();

        for(int i= 0; i<report.size(); i++){
            result.add(new CountClient((Long) report.get(i)[1], (Client) report.get(i)[0] ));
        }

        return result;
    }

    public List<Reservation> getReservationPeriod(Date a, Date b){
        return reservationCrudRepository.findAllByStartDateAfterAndDevolutionDateBefore(a, b);
    }
    public List<Reservation> getReservationsByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }
}
