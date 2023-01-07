import java.util.Objects;


import javax.persistence.*;

@Entity
@Table(name = "BREED")
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id = 0;
    @Column(name = "name")
    private String name = "";
    @Column(name = "mass_male")
    private Double maleMass = 0.0;
    @Column(name = "mass_female")
    private Double femaleMass = 0.0;
    @Column(name = "age")
    private String age = "";

    public Dog() {
    }

    public Dog(String name, Double maleMass, Double femaleMass, String age) {
        this.name = name;
        this.maleMass = maleMass;
        this.femaleMass = femaleMass;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMaleMass() {
        return maleMass;
    }

    public void setMaleMass(Double maleMass) {
        this.maleMass = maleMass;
    }

    public Double getFemaleMass() {
        return femaleMass;
    }

    public void setFemaleMass(Double femaleMass) {
        this.femaleMass = femaleMass;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(id, dog.id) && Objects.equals(name, dog.name) && Objects.equals(maleMass, dog.maleMass) && Objects.equals(femaleMass, dog.femaleMass) && Objects.equals(age, dog.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, maleMass, femaleMass, age);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", breed='" + name + '\'' +
                ", maleMass=" + maleMass +
                ", femaleMass=" + femaleMass +
                ", age=" + age +
                '}';
    }
}
