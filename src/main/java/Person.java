import java.util.Objects;

public class Person {
    int varA;
    int varB;

    Person(int varA, int varB){
        this.varA = varA;
        this.varB = varB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return varA == person.varA &&
                varB == person.varB;
    }

    @Override
    public int hashCode() {
        return Objects.hash(varA, varB);
    }
}
