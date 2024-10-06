package com.example.hotel.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotel.model.Reserva;
import com.example.hotel.repository.HotelRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService{
    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public List<Reserva> getAllReserva() {
        return hotelRepository.findAll();
    }

    @Override
    public Optional<Reserva> getReservaById(Long id) {
        return hotelRepository.findById(id);
    }

    @Override
    public Reserva createReserva(Reserva reserva) {
        return hotelRepository.save(reserva);
    }

    @Override
    public Reserva updateReserva(Long id, Reserva reserva) {
        if(hotelRepository.existsById(id))
        {
            reserva.setIdReserva(id);
            return hotelRepository.save(reserva);
        }
        else
        return null;
    }

    @Override
    public void deleteReserva(Long id) {
        hotelRepository.deleteById(id);
    }
}
