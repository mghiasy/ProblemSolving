package Algorithms.Implementation.Day_of_the_Programmer;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

	// Complete the dayOfProgrammer function below.
	static String dayOfProgrammer(int year) {
		byte day = 0;
		// Julian Calendar leap Year || Gregorian leap year
		if ((year < 1918 && year % 4 == 0)
				|| (year > 1918 && ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0))) {
			return "12.09." + year;
		} else if (year == 1918) {
			return "26.09." + year;
		} else {
			return "13.09." + year;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int year = Integer.parseInt(bufferedReader.readLine().trim());

		String result = dayOfProgrammer(year);

		bufferedWriter.write(result);
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
