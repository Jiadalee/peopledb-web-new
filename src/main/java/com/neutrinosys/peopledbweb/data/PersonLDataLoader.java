package com.neutrinosys.peopledbweb.data;

import com.neutrinosys.peopledbweb.biz.model.Person;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
public class PersonLDataLoader implements ApplicationRunner {
    private PersonRepository personRepository;

    public PersonLDataLoader(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (personRepository.count() == 0) {
            //System.out.println("Start running here");
            List<Person> people = List.of(
                    new Person(null, "Pete", "Snake", LocalDate.of(1950, 1, 1), "dummy@sample.com", new BigDecimal("50000")),
                    new Person(null, "Jennifer", "Snake", LocalDate.of(1960, 2, 1), "dummy@sample.com",new BigDecimal("60000")),
                    new Person(null, "Johson", "Snake", LocalDate.of(1970, 3, 1), "dummy@sample.com",new BigDecimal("70000")),
                    new Person(null, "Maj", "Snake", LocalDate.of(1970, 3, 1), "dummy@sample.com",new BigDecimal("70000")),
                    new Person(null, "Steve", "Snake", LocalDate.of(1980, 4, 1), "dummy@sample.com",new BigDecimal("80000"))
            );
            personRepository.saveAll(people);
        }
    }
}
