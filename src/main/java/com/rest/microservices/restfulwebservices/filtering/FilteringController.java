package com.rest.microservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue filtering() {
        SomeBean someBean = new SomeBean("value1", "value2", "value3");
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);

        setFiltering(mappingJacksonValue, "field1", "field3");
        return mappingJacksonValue;
    }

    @GetMapping("/filtering-list")
    public MappingJacksonValue filteringList() {
        List<SomeBean> someBeans = Arrays.asList(new SomeBean("value1", "value2", "value3"),
                                                 new SomeBean("value4", "value5", "value6"),
                                                 new SomeBean("value7", "value8", "value9"));
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBeans);

        setFiltering(mappingJacksonValue, "field2", "field3");
        return mappingJacksonValue;
    }

    private static void setFiltering(MappingJacksonValue mappingJacksonValue,
                                     String notFilteredProperty, String notFilteredProperty2) {
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(notFilteredProperty, notFilteredProperty2);
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mappingJacksonValue.setFilters(filters);
    }

}
