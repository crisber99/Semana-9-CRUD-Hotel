package com.example.hotel.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotel.model.Reserva;
import com.example.hotel.service.HotelService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/reservas")
public class ReservaController {
    private static final Logger log = LoggerFactory.getLogger(ReservaController.class);

    @Autowired
    private HotelService hotelService;

    @GetMapping
    public CollectionModel<EntityModel<Reserva>> getAllReserva(){
        log.info("getAllReserva");
        List<Reserva> lReserva = hotelService.getAllReserva();
        List<EntityModel<Reserva>> ReservaResources = lReserva.stream()
            .map(reserva -> EntityModel.of(reserva, 
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getReservaById(reserva.getIdReserva())).withSelfRel()
                ))
            .collect(Collectors.toList());
            
            WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllReserva());
            CollectionModel<EntityModel<Reserva>> resources = CollectionModel.of(ReservaResources, linkTo.withRel("hotel"));

        return resources;
    }
        
    @GetMapping("/{id}")
    public EntityModel<Reserva> getReservaById(@PathVariable Long id) {
        log.info("getReservaById");
        Optional<Reserva> reserva = hotelService.getReservaById(id);

        if(reserva.isPresent()){
            return EntityModel.of(reserva.get(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getReservaById(id)).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllReserva()).withRel("all-reserva"));
        }
        else{
            throw new ReservaNotFoundException("Reserva no funciona con el id: " + id); 
        }
    }

    @PostMapping
    public EntityModel<Reserva> createReserva(@RequestBody Reserva res) {
        log.info("createReserva");
        Reserva reserva = hotelService.createReserva(res);
        return EntityModel.of(reserva,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getReservaById(reserva.getIdReserva())).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllReserva()).withRel("all-reserva"));
    }

    @PutMapping("/{id}")
    public EntityModel<Reserva> updateReserva(@PathVariable Long id, @RequestBody Reserva res) {
        log.info("updateReserva");
        Reserva reserva = hotelService.updateReserva(id, res);
        return EntityModel.of(reserva,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getReservaById(id)).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllReserva()).withRel("all-reserva"));
    }

    @DeleteMapping("/{id}")
    public void deleteReserva(@PathVariable Long id)
    {
        log.info("deleteReserva");
        hotelService.deleteReserva(id);
    }

    static class ErrorResponse{
        private final String msg;

        public ErrorResponse(String msg){
            this.msg = msg;
        }

        public String getMsg(){
            return msg;
        }
    }
    
}
