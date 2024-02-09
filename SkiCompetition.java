// -------------------------------------------------------
// Assignment {3}
// Written by: {Brian Ly 40028072}
// For COMP 248 Section {H} – Fall 2023

/* Description: A program that ranks the top three winners of their ski competitions. The user may enter
 * 				any amount of skiers up to 20. The program will then identify and print the top 3 skiers.
 */

import java.util.Scanner;

public class A3_Q2 {

	public static void main(String[] args) {
		/* Algorithm 2: Skiing Ranker
		 * Steps of algorithm are described before each section of code to facilitate reading
		 */
		
		//Step 1: Print welcome message
		
		System.out.println("Welcome to Mont-Halloween Skiing Contest Ranker.");
		
		//Step 2: Prompt user for name and skiing time
		
		System.out.println("Whenever a skier makes it to the finish line, enter their name and skiing time.");
		
		/* Step 3: Declaration and initialization of variables
		 * 		   - Declare scanner variable for user input
		 * 		   - Declare string variables to read name inputs and read y/yes
		 * 		   - Declare double variable to read time inputs
		 * 		   - Create arrays for the names and skiing times of 20 skiers
		 * 		   - Declare a counter variable 
		 * 		   - Declare the maximum number of skiers as a constant
		 * 		   - Declare 3 integer variables to hold the index of first, second and third place skiers.
		 * 		  
		 */
		
		Scanner keyIn = new Scanner(System.in);
		String name = "";
		String junk; // to read lines not used in input
		String another = "";
		
		double time;
		String[] names = new String[20];
		double[] times = new double[20];
		final int MAX_NUMBER_SKIERS = 20;
		int countOfskiers = 0;
		int firstPodiumIndex, secondPodiumIndex, thirdPodiumIndex;
		
		/* Step 4: Outer do-while loop
		 * - Prompt skier's name
		 * - Store skier's name in names array
		 * - Prompt skiing time
		 * - Store skiing time in times array
		 */
		
		do {
		
			System.out.print("Please input the skier's name: ");
			name = keyIn.nextLine();
			names[countOfskiers] = name;
			
			System.out.print("Please input the skier's time: ");
			time = keyIn.nextDouble();
			times[countOfskiers] = time;
		
		/* Step 5: For loop to find indices of first, second and third place
		 * - Initialize 1st, 2nd and 3rd podiums index to -1 to indicate no elements have been entered yet.
		 * - Initiate a variable to scan elements in the array
		 * - The loop will execute if scan variable is less than array length and if the accessed time is not 0.
		 * - Each iteration will compare the current time scanned with the times of first, second and third podiums.
		 * - The loop terminates after 20 iterations.
		 * 
		 * Step 6: Inner if-else statement to swap indices of first, second, third 
		 * - The new time entered will be compared to current lowest, second lowest, and third lowest time.
		 * - If any of the conditions are met, the indices will be shifted accordingly.
		 * - Note: all 3 if-else statements will include a condition that ensures a first execution 
		 * 		   if no indices have been set yet. 
		 */
		
			
			firstPodiumIndex = -1;
			secondPodiumIndex = -1;
			thirdPodiumIndex = -1;
			
				
			for (int scan = 0; scan < MAX_NUMBER_SKIERS && times[scan]!=0; scan++)  //if times scanned equal 0
			{	
					
				if (firstPodiumIndex == -1 || times[scan]< times[firstPodiumIndex])
				{
					//If time scanned is now lowest, shifts previous 1st and 2nd indices to 2nd and 3rd place
					thirdPodiumIndex = secondPodiumIndex;
					secondPodiumIndex = firstPodiumIndex;
					firstPodiumIndex = scan;
				}
					
				else if (secondPodiumIndex == -1 || times[scan] < times[secondPodiumIndex]) //
				{
					//If time scanned is now second lowest, shifts previous 2nd index to 3rd place
					thirdPodiumIndex = secondPodiumIndex; 
					secondPodiumIndex = scan;
				}
					
				else if (thirdPodiumIndex == -1 || times[scan] < times[thirdPodiumIndex]) 
				{	
					//If time scanned is now third lowest, scanned index is now 3rd place
					thirdPodiumIndex = scan; 
				}
					
			}
			
		/* Step 7: If-else to print results of winners
		 * - If only one skier, print first element of each array only
		 * - If only two skiers, print first and second elements of each array
		 * - If three or more skiers, print first, second and third elements of each array	
		 */
			
			if (times[1] ==0) //if 2nd element in array is 0
				System.out.println("First podium goes to " + names[firstPodiumIndex] + " who made it in " + times[firstPodiumIndex] + " second(s)");
			else if (times[2] == 0) // if 3rd element in array is 0
			{	System.out.println("First podium goes to " + names[firstPodiumIndex] + " who made it in " + times[firstPodiumIndex] + " second(s)");
				System.out.println("Second podium goes to " + names[secondPodiumIndex] + " who made it in " + times[secondPodiumIndex] + " second(s)");
			}
			else 
			{	
				System.out.println("First podium goes to " + names[firstPodiumIndex] + " who made it in " + times[firstPodiumIndex] + " second(s)");
				System.out.println("Second podium goes to " + names[secondPodiumIndex] + " who made it in " + times[secondPodiumIndex] + " second(s)");
				System.out.println("Third podium goes to " + names[thirdPodiumIndex] + " who made it in " + times[thirdPodiumIndex] + " second(s)");
			}	
			
			
			countOfskiers++; //incrementing count in do-while loop
			
		/*Step 4 (cont.) Repetition of do-while loop
		 * - Prompt user to add another skier. If yes, while condition is true and loop is repeated
		 * - Do-while loop repeats until count reaches 20 (for 20 skiers)
		 */
	
			if (countOfskiers < MAX_NUMBER_SKIERS)
			{	System.out.print("Do you want to add another skier? y/yes: ");
				another = keyIn.next();
				junk = keyIn.nextLine(); // to read prompt for skier's name before prompting
			}
		}
		while ((another.contains("y")|| another.contains("Y")) && countOfskiers< MAX_NUMBER_SKIERS);
		
		//Close scanner object
		keyIn.close();
		
		/*Step 8: Print c message using if-else statement similar to step 7
		* - If 1 skier, congratulate 1 skier
		* - If 2 skiers, congratulate 2 skiers
		* - If 3 skiers, congratulate all 3 skiers
		*/
		
		if (times[1] ==0) // if 2nd element is 0
			System.out.println("Congratulations to " + names[firstPodiumIndex] + "!");
		else if (times[2]==0) // if 3rd element is 0
			System.out.println("Congratulations to " + names[firstPodiumIndex] 
					+ " and " + names[secondPodiumIndex] +  "!");
		else
			System.out.println("Congratulations to " + names[firstPodiumIndex] 
					+ "," + names[secondPodiumIndex] + " and " + names[thirdPodiumIndex] + "!");
		
		//Step 9: Print goodbye message
		
		System.out.print("Goodbye!");
	}

}
