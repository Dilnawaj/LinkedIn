package com.linkedin.connections_service.controller;

import com.linkedin.connections_service.entity.Person;
import com.linkedin.connections_service.service.ConnectionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("core")
@RequiredArgsConstructor
public class ConnectionsController {


    private final ConnectionsService connectionsService;

    @GetMapping("/{userId}/first-degree")
    public ResponseEntity<List<Person>>  getFirstConnections(@PathVariable Long userId)
    {
        return  ResponseEntity.status(HttpStatus.OK).body(connectionsService.getFirstDegreeConnection(userId));
    }
    @GetMapping
    public ResponseEntity<Optional<Person>>  getUserByName(@RequestParam String user)
    {
        return  ResponseEntity.status(HttpStatus.OK).body(connectionsService.getUserByName(user));
    }

}
