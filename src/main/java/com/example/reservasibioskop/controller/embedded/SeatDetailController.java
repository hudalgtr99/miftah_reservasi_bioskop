package com.example.reservasibioskop.controller.embedded;

import com.example.reservasibioskop.dto.embedded.SeatDetailDTO;
import com.example.reservasibioskop.entity.FilmEntity;
import com.example.reservasibioskop.entity.embedded.SeatDetailEntity;
import com.example.reservasibioskop.service.embedded.SeatDetailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seatdetail")
public class SeatDetailController {

    @Autowired
    SeatDetailService seatDetailService;

    @Operation(summary = "Create an seat detail")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Created the seat detail",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SeatDetailEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid orderId supplied",
                    content = @Content)})
    @PostMapping("/add/{orderId}")
    public SeatDetailDTO addSeatDetailToOrder(@PathVariable Long orderId, @RequestBody SeatDetailDTO request){
        final SeatDetailEntity seatDetailEntity = seatDetailService.mapToEntity(request);
        SeatDetailEntity result = seatDetailService.addSeatDetail(orderId, seatDetailEntity);
        return seatDetailService.mapToDto(result);
    }

}
