package com.example.hotel.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hotel.model.Reserva;

public interface HotelRepository extends JpaRepository<Reserva, Long> {

    
}
