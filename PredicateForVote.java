package lamdaDemoPrograms;

import java.util.function.Predicate;

public class PredicateForVote {
	
	public static boolean isIlligibleForVote(Person person,Predicate<Person> predicate) {
		return predicate.test(person);
		
	}

	
	public static void main(String[] args) {
		Person person=new Person(16,"jai");
		
		Predicate<Person>per=(p)->p.age >18;
		
		Boolean isEligible=isIlligibleForVote(person, per);
		
		System.out.println("person is eligible to vote "+ isEligible);
	}
}
