package com.example.pagina.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MapaController {

    @GetMapping("/ruta-optima")
    public List<double[]> getOptimalRoute() {
        List<double[]> coordinates = new ArrayList<>();
        coordinates.add(new double[]{-17.39858, -66.15114});
        coordinates.add(new double[]{-17.398941, -66.153152});
        coordinates.add(new double[]{-17.398628, -66.152208});
        coordinates.add(new double[]{-17.397932, -66.152235});
        coordinates.add(new double[]{-17.396872, -66.152428});
        coordinates.add(new double[]{-17.39784, -66.151173});
        coordinates.add(new double[]{-17.397692, -66.150051});
        return coordinates;
    }
}
