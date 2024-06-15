package stream;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BirthdayPeople {
    public static void main(String[] args) {
        String inputFileName="people.txt";
        String outputFileName="peopleSorted.txt";

        try {
            List<Person> personList=new ArrayList<>();
            List<Person> people = Files.lines(Paths.get(inputFileName))
                    .map(line->line.split(","))
                    .map(parts->new Person(parts[0],parts[1],parts[2]))
                    .collect(Collectors.toList());

            personList=people.stream()
                                 .filter(person -> person.getMonth()==5)
                                    .collect(Collectors.toList());
            personList.sort(Comparator.comparing(Person::getFirstName).thenComparing(Person::getLastName));


            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFileName))) {
                personList.stream()
                        .map(Person::getName)
                        .forEach(line -> {
                            try {
                                writer.write(line);
                                writer.newLine();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
            } catch (IOException e) {
                e.printStackTrace();
            }



        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
    



}
