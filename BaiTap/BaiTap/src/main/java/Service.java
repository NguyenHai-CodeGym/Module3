import java.util.ArrayList;
import java.util.List;

public class Service {
   static List<Person> list = new ArrayList<>();
    static {
        list.add(new Person(1,"Hai",23));
        list.add(new Person(2,"Thang",23));
        list.add(new Person(3,"Thinh",20));
        list.add(new Person(4,"Dat",25));
        list.add(new Person(5,"Tu",20));
    }

    public void addPerson(int id, String name, int age){
        list.add(new Person(id,name,age));
    }
    public List<Person> findAll(){
        return list;
    }

    public Person findId(int id){
        return list.stream().filter(item -> item.getId() == id).findFirst().orElse(null);
    }
}
