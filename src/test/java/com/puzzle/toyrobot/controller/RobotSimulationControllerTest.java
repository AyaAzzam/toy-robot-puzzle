package com.puzzle.toyrobot.controller;

import com.puzzle.toyrobot.model.Report;
import com.puzzle.toyrobot.model.SimulationRound;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RobotSimulationControllerTest {

    @Autowired
    private TestRestTemplate template;

    @Test
    public void simulationReportAsExpectedTest() {

        Report report = new Report();
        report.addOutput("0,1,NORTH");

        SimulationRound round = new SimulationRound();
        round.addCommand("PLACE 0,0,NORTH");
        round.addCommand("LEFT");
        round.addCommand("RIGHT");
        round.addCommand("MOVE");
        round.addCommand("REPORT");

        HttpEntity<Object> simulationRound = getHttpEntity(round);

        ResponseEntity<Report> resultAsset = template.postForEntity("/robot/simulation", simulationRound, Report.class);
        Assert.assertEquals(resultAsset.getBody(), report);
    }

    @Test
    public void missingRobotTest() {

        Report report = new Report();
        report.addOutput("ROBOT MISSING");

        SimulationRound round = new SimulationRound();
        round.addCommand("MOVE");
        round.addCommand("REPORT");

        HttpEntity<Object> simulationRound = getHttpEntity(round);
        ResponseEntity<Report> resultAsset = template.postForEntity("/robot/simulation", simulationRound, Report.class);
        Assert.assertEquals(resultAsset.getBody(), report);
    }


    @Test
    public void ignoringWrongCommandTest() {

        Report report = new Report();
        report.addOutput("0,0,WEST");

        SimulationRound round = new SimulationRound();
        round.addCommand("PLACE 0,0,WEST");
        round.addCommand("MOVEEEE");
        round.addCommand("REPORT");

        HttpEntity<Object> simulationRound = getHttpEntity(round);

        ResponseEntity<Report> resultAsset = template.postForEntity("/robot/simulation", simulationRound, Report.class);
        Assert.assertEquals(resultAsset.getBody(), report);
    }


    @Test
    public void ignoringCommandThatCausesFailTest() {

        Report report = new Report();
        report.addOutput("0,0,SOUTH");

        SimulationRound round = new SimulationRound();
        round.addCommand("PLACE 0,0,SOUTH");
        round.addCommand("MOVE");
        round.addCommand("REPORT");

        HttpEntity<Object> simulationRound = getHttpEntity(round);

        ResponseEntity<Report> resultAsset = template.postForEntity("/robot/simulation", simulationRound, Report.class);
        Assert.assertEquals(resultAsset.getBody(), report);
    }


    @Test
    public void simulationRoundWithoutReportTest() {

        Report report = new Report();

        SimulationRound round = new SimulationRound();
        round.addCommand("PLACE 1,2,EAST");
        round.addCommand("MOVE");
        round.addCommand("MOVE");
        round.addCommand("LEFT");

        HttpEntity<Object> simulationRound = getHttpEntity(round);

        ResponseEntity<Report> resultAsset = template.postForEntity("/robot/simulation", simulationRound, Report.class);
        Assert.assertEquals(resultAsset.getBody(), report);
    }



    private HttpEntity<Object> getHttpEntity(Object body) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(body, headers);
    }


}