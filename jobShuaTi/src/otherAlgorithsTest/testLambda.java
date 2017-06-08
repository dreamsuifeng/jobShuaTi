package otherAlgorithsTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
//lambda expression 有一个缺陷，不能在lambda expression中修改定义在域外的变量
public class testLambda {
	public static void filter1(List<String> names, Predicate<String> condition) {
	    for(String name: names)  {
	        if(condition.test(name)) {
	            System.out.println(name + " ");
	        }
	    }
	}
	
	public static void filter(List<String> names, Predicate<String> condition) {
	    names.stream().filter((name) -> (condition.test(name))).forEach((name) -> {
	        System.out.println(name + " ");
	    });
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
//		features.forEach(n -> System.out.println(n));
//		features.forEach(System.out::println);
		List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
		 
	    Predicate<String> startwithL=(n) -> n.startsWith("L");
	    Predicate<String> strlen=(n) -> n.length()==7;
//	    features.stream().filter(startwithL.and(strlen)).forEach((n)->System.out.println(n));
	    String a=features.stream().map((n)->String.valueOf(n.length())).collect(Collectors.joining(","));
	    System.out.println(a);
	}
	 
	
	}

