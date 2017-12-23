import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class JsonMaker {

    private String name;
    private Set<String> AKAnames;
    private String age;
    private Set<String> relatives;

    public JsonMaker(String name, Set<String> AKAnames, String age, Set<String> relatives) {
        this.name = name;
        this.AKAnames = AKAnames;
        this.age = age;
        this.relatives = relatives;
    }

    public String getName() {
        return name;
    }

    public Set<String> getAKAnames() {
        return AKAnames;
    }

    public String getAge() {
        return age;
    }

    public Set<String> getRelatives() {
        return relatives;
    }

    public void PrintResults(){
//        System.out.println(name + AKAnames + age + relatives);
//        List<Set<String>> relatives = Arrays.asList(getRelatives());
        System.out.println(name + ", " + Arrays.toString(AKAnames.toArray()) + ", " + age + ", " + relatives);
    }
}
