package com.example.hotel.Controller;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.hotel.controller.ReservaController;
import com.example.hotel.model.Reserva;
import com.example.hotel.service.HotelServiceImpl;

@WebMvcTest(ReservaController.class)
public class ReservaControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HotelServiceImpl hotelServiceMock;

    @Test
    public void obtenerTodosTest() throws Exception{
        Reserva hotel1 = new Reserva();
        hotel1.setNombreCliente("nombre 1");
        hotel1.setTelefono("telefono 1");
        hotel1.setMail("mail 1");
        hotel1.setFechaEntrada("25/03/2024");
        hotel1.setIdReserva(1);

        Reserva hotel2 = new Reserva();
        hotel2.setNombreCliente("nombre 2");
        hotel2.setTelefono("telefono 2");
        hotel2.setMail("mail 2");
        hotel2.setFechaEntrada("15/07/2024");
        hotel2.setIdReserva(2);

        Reserva hotel3 = new Reserva();
        hotel3.setNombreCliente("nombre 3");
        hotel3.setTelefono("telefono 3");
        hotel3.setMail("mail 3");
        hotel3.setFechaEntrada("25/03/2024");
        hotel3.setIdReserva(3);

        Reserva hotel4 = new Reserva();
        hotel4.setNombreCliente("nombre 4");
        hotel4.setTelefono("telefono 4");
        hotel4.setMail("mail 4");
        hotel4.setFechaEntrada("15/07/2024");
        hotel4.setIdReserva(4);

        List<Reserva> lReserva = Arrays.asList(hotel1, hotel2, hotel3, hotel4);
        when(hotelServiceMock.getAllReserva()).thenReturn(lReserva);

        mockMvc.perform(MockMvcRequestBuilders.get("/hotel"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.aMapWithSize(4)))
        .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.OcList[0].name", Matchers.is("Direccion 1")))
        .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.OcList[1].name", Matchers.is("Direccion 2")))
        .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.OcList[2].name", Matchers.is("Direccion 3")))
        .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.OcList[3].name", Matchers.is("Direccion 4")));
    }
}