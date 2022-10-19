package com.example.reservasibioskop.controller.embedded;

import com.example.reservasibioskop.dto.embedded.SeatDetailDTO;
import com.example.reservasibioskop.entity.embedded.SeatDetailEntity;
import com.example.reservasibioskop.service.embedded.SeatDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seatdetail")
public class SeatDetailController {

    @Autowired
    SeatDetailService seatDetailService;

    @PostMapping("/add/{orderId}")
    public SeatDetailDTO addSeatDetailToOrder(@PathVariable Long orderId, @RequestBody SeatDetailDTO request){
        final SeatDetailEntity seatDetailEntity = seatDetailService.mapToEntity(request);
        SeatDetailEntity result = seatDetailService.addSeatDetail(orderId, seatDetailEntity);
        return seatDetailService.mapToDto(result);
    }

}
