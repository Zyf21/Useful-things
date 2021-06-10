public class TestHashCode {

    public static void main(String[] args) {
//        Person person1 = new Person(1,2);
//        Person person2 = new Person(1,2);
//        String q = new String("33");
//        String q2 = new String("33");
//        System.out.println(person1.equals(person2));
//        System.out.println(person1 == person2);
//
//        System.out.println(person1.hashCode() + " "+ person2.hashCode());
//        System.out.println(person1.hashCode() == person2.hashCode());
//        System.out.println(q==q2);
//        System.out.println(q.equals(q2));

        String s1 = "JavaRush - лучший сайт для изучения Java!";
        String s2 = new String("JavaRush - лучший сайт для изучения Java!");
        System.out.println(s1 == s2.intern());
        System.out.println(s1== s2);
        System.out.println(s1.equals(s2));




    }
}
