package lamdaDemoPrograms;

import java.util.function.Predicate;

public class MultiplePredicate {
	
	public static boolean isEligibleforMarriage(Person person,Predicate<Person> p1,Predicate<Person>p2) {
		
		Predicate<Person> p3=p1.and(p2);
		return p3.test(person);
				
	}
	
	public static void main(String[] args) {
		Person person=new Person(87,"jai");
		
		Predicate<Person>p1=(user)-> person.age>18;
		Predicate<Person>p2=(user)->person.age<60;
		
		Predicate<Person>p3=p1.and(p2);
		
		boolean isEligible=p3.test(person);
		
		System.out.println("he is eligle for marriage"+isEligible);
		
		
	}

}
