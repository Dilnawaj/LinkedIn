package com.linkedin.connections_service.service;

import com.linkedin.connections_service.entity.Person;
import com.linkedin.connections_service.repo.PersonRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j

public class ConnectionsService {

    private final PersonRepo personRepo;


    public List<Person> getFirstDegreeConnection(Long userId)
    {
        return personRepo.findAll();
    }

    public Optional<Person> getUserByName(String user) {
        System.out.println(user);
 return personRepo.getByName(user);
    }
}
