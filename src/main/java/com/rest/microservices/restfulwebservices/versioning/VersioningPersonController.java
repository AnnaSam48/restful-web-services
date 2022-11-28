package com.rest.microservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson(){
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    @GetMapping(path="/person", params = "version=1")
    public PersonV1 getFirstVersionOfPersonWithRequestParameter(){
        return new PersonV1("Dean Edward");
    }

    @GetMapping(path="person", params = "version=2")
    public PersonV2 getSecondVersionOfPersonWithRequestParameter(){
        return new PersonV2(new Name("Dean", "Edward"));
    }

    @GetMapping(path="/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersonWithRequestHeader(){
        return new PersonV1("Felix Grove");
    }

    @GetMapping(path="person/header", headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionOfPersonWithRequestHeader(){
        return new PersonV2(new Name("Felix", "Grove"));
    }

    @GetMapping(path="/person/accept", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getFirstVersionOfPersonWithAcceptHeader(){
        return new PersonV1("Henrik Ives");
    }

    @GetMapping(path="person/accept", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getSecondVersionOfPersonWithAcceptHeader(){
        return new PersonV2(new Name("Henrik", "Ives"));
    }
}
