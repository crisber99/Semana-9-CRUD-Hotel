package com.example.hotel.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.hotel.model.Reserva;
import com.example.hotel.service.HotelServiceImpl;
import com.example.hotel.repository.HotelRepository;

@ExtendWith(MockitoExtension.class)
public class HotelServiceTest {
    @InjectMocks
    private HotelServiceImpl hotelServImpl;

    @Mock
    private HotelRepository hRepository;

    @Test
    public void guardarOCTest(){
        Reserva reserva = new Reserva();
        reserva.setFechaEntrada("25/03/2024");
        reserva.setFechaSalida("01/04/2024");
        reserva.setNombreCliente("nombre cliente");

        when(hRepository.save(any())).thenReturn(reserva);

        Reserva resultado = hotelServImpl.createReserva(reserva);
        assertEquals("25/03/2024", resultado.getFechaEntrada());
        assertEquals("01/04/2024", resultado.getFechaSalida());
        assertEquals("nombre cliente", resultado.getNombreCliente());
        
    }
}
