package com.puzzle.toyrobot.controller;

import com.puzzle.toyrobot.model.Report;
import com.puzzle.toyrobot.model.SimulationRound;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RobotSimulationController {

    @PostMapping
    @RequestMapping("/robot/simulation")
    public ResponseEntity<Report> newSimulationRound(@RequestBody SimulationRound simulationRound) {
        return ResponseEntity.ok(new Report());
    }
}


