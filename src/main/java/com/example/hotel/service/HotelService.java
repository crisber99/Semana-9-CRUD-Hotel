package com.example.hotel.service;
import com.example.hotel.model.Reserva;
import java.util.List;
import java.util.Optional;

public interface HotelService {
    List<Reserva> getAllReserva();
    Optional<Reserva> getReservaById(Long id);
    Reserva createReserva(Reserva reserva);
    Reserva updateReserva(Long id, Reserva reserva);
    void deleteReserva(Long id);
}
