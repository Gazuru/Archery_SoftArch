package hu.bme.aut.archerybe.business.controller;

import java.util.List;
import java.util.UUID;

import hu.bme.aut.archerybe.business.service.BowService;
import hu.bme.aut.archerybe.datamodel.dto.BowDto;
import hu.bme.aut.archerybe.datamodel.entity.Bow;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.path}")
@RequiredArgsConstructor
public class BowController {

    private final BowService bowService;

    @GetMapping("/bows")
    public List<Bow> getBows() {
        return bowService.getBows();
    }

    @PostMapping("/bows")
    public Bow createBow(BowDto bowDto){
        return bowService.createBow(bowDto);
    }

    @GetMapping("/bow/{id}")
    public Bow getBow(@PathVariable UUID id) {
        return bowService.getBow(id);
    }

    @DeleteMapping("/bow/{id}")
    public void deleteBow(@PathVariable UUID id){
        bowService.deleteBow(id);
    }
}
