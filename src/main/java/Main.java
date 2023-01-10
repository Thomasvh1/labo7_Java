import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //STAPPENPLAN
        //1. pom.xml => dependencies toevoegen
        //2. hibernate.cfg.xml aanmaken & configureren
        //3. Persistent class aanmaken (Dog) + regels in orde maken
        //4. Annotations in orde brengen
        //5. HibernateUtil aanmaken & configureren
        //6. DAO aanmaken & configureren (queries)
        //7. HibernateUtil toekennen aan sessionFactory

        DogDAO dao = new DogDAO();

        File file = new File("src/main/resources/honden.csv");

        try {
            Files.lines(file.toPath())
                    .skip(1)
                    .map(line -> stringToDogBreed(line))
                    .forEach(breed -> dao.CreateBreed(breed));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // oplossing met DAO


        // oplossing met streams
        List<Dog> breeds = dao.getBreeds();

        System.out.println("bevat dog:");
        System.out.println("");
        breeds.stream()
                .filter(dog -> dog.getName().toLowerCase().contains("dog"))
                .forEach(System.out::println);

        System.out.println("mannelijke honden tussen 50kg & 70kg:");
        System.out.println("");
        breeds.stream()
                .filter(dog -> dog.getMaleMass() >= 50 && dog.getMaleMass() <= 70)
                .forEach(System.out::println);

        System.out.println("aantal honden rassen met shepherd:");
        System.out.println("");
        long shepherds = breeds.stream()
                .filter(dog -> dog.getName().toLowerCase().contains("herder"))
                .count();
        System.out.println(shepherds);

    }
    private static Dog stringToDogBreed(String line) {
        String[] split = line.split(",");
        System.out.println(split[0] + " " + split[1] + " " + split[2] + " " + split[3]);
        return new Dog(split[0], Double.valueOf(split[1]), Double.valueOf(split[2]), split[3]);
    }
}
