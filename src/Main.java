import TerminalIO.KeyboardReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		KeyboardReader reader = new KeyboardReader();
		String input = reader.readLine("Enter 10 integers separated by commas: ");
		String[] split = input.split(",");
		List<Integer> numbers = Arrays.asList(split).stream().map(Integer::parseInt).collect(Collectors.toList());
		Integer integer = reader.readInt("Provide one integer: ");
		ArrayList<Integer> sortedNumbers = new Sort<Integer>(new ArrayList<>(numbers)).get();
		String message = new Search<Integer>(sortedNumbers, integer).get() ? "The list contains " + integer : "The list does not contain " + integer;
		System.out.println(message);
	}
}
