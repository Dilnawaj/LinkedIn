package com.linkedin.connections_service.entity;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Data  // generates getters, setters, equals, hashCode, toString
@Node("Person")
public class Person {

    @Id
    private Long userId;   // external identifier (query key)

    @Property("id")        // maps to "id" property in Neo4j
    private Long id;

    private String name;
}
