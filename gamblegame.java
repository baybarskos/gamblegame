package projelerim;

import java.util.Scanner;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.time.LocalTime;
public class gamblegame {
	public static void main(String[] args) throws IOException {
		int playerHealth = 50;
		Scanner input = new Scanner(System.in);
		Random random = new Random();
		int a1 = random.nextInt(5, 26);
		int a2 = random.nextInt(10, 31);
		int a3 = random.nextInt(0, 21);
		int a4 = random.nextInt(15, 36);
		String replay = "yes";
		File myObj = new File("Score.txt");
		int maks = 0;
		int maks1 = 0;
		int maks2 = 0;
		do {
			playerHealth=50;
			System.out.println("1. The Game");
			System.out.println("2. Statistics");
			System.out.println("3. Exit");
			int lobby = alici(input);
			switch (lobby) {
			case 3:
				replay = "no";
				break;
			case 2:
				try {
					Scanner file = new Scanner(new FileInputStream(myObj));
					while (file.hasNextLine()) {
						int num = file.nextInt();
						String trash = file.nextLine();
						if (num > maks) {
							int gec=maks;
							maks = num;
							int gec1=maks1;
							maks1=gec;
							maks2=gec1;
						} else if(num>maks1&&num<maks){
							int gec=maks1;
							num=maks1;
							maks2=gec;
						}else if(num>maks2&&num<maks&&num<maks1) {
							num=maks2;
						}
					}
					System.out.println("maximum score is: " + maks+"\nsecond maximum score is:"+maks1+"\nthird maximum score is: "+maks2);
				} catch (IOException e) {
					myObj.createNewFile();
					System.out.println("File not found. " + e);
				}
				break;
			case 1:
				System.out.println("\n=== LEVEL 1: THE HALL OF CHOICES ===");
				System.out.println("Before you stand three ancient doors:");
				System.out.println("1. The Door of Harmony");
				System.out.println("2. The Door of Balance");
				System.out.println("3. The Door of Elements");
				System.out.print("Choose your door (1, 2, or 3): ");
				int Choise = input.nextInt();
				switch (Choise) {
				case 1:
					System.out.println("You approach the Door of Harmony. It requires a harmonious number.");
					System.out.println("A harmonious number is a number that is divisible by both 2 and 5  ");
					int harmony = input.nextInt();
					if (harmony % 10 == 0) {
						System.out.println("The door glows brightly and opens! You gain health.");
						playerHealth = playerHealth + a1;
						System.out.println(playerHealth + " is your new health! ");
					} else {
						System.out.println("A discordant sound echoes. The door remains shut!");
						playerHealth = playerHealth - a3;
						System.out.println(playerHealth + " is your new health! ");
					}
					break;
				case 2:
					System.out.println("You stand before the Door of Balance. It demands a perfectly balanced number");
					System.out.println("A balanced number is a number that have digits summing to 7");
					int balance = input.nextInt();
					int b = 0;
					for (; balance > 0;) {
						b = b + balance % 10;
						balance = balance / 10;
					}
					switch (b) {
					case 7:
						System.out.println("The perfect balance achieved! The door opens!");
						playerHealth = playerHealth + a2;
						System.out.println(playerHealth + " is your new health! ");
						break;
					default:
						System.out.println("The door tilts dangerously. You are thrown back!");
						playerHealth = playerHealth - a3;
						System.out.println(playerHealth + " is your new health! ");
					}
					break;
				case 3:
					System.out.println("The Door of Elements is covered in runes for Earth, Air, Fire, and Water.");
					System.out.println("Write a number thats modulus to 4 is equal to your wanted rune");
					int element = input.nextInt();
					if (element % 4 == 0) {
						System.out.println("Earth: The ground stabilizes. You may pass safely!");
						playerHealth = playerHealth + a3;
						System.out.println(playerHealth + " is your new health! ");
					} else if (element % 4 == 1) {
						System.out.println("Air: A gust of wind lifts you through the door!");
						playerHealth = playerHealth + 5;
						System.out.println(playerHealth + " is your new health! ");
					} else if (element % 4 == 2) {
						System.out.println("Fire: You pass through flames!");
						playerHealth = playerHealth - a3;
						System.out.println(playerHealth + " is your new health! ");
					} else {
						System.out.println("Water: The waves crashed you over!");
						playerHealth = playerHealth - 5;
						System.out.println(playerHealth + " is your new health! ");
					}
					break;
				default:
					System.out.println("A trap door opens! You fall and lose health.");
					playerHealth = playerHealth - a1;
					System.out.println(playerHealth + " is your new health! ");
					break;
				}
				System.out.println("\n=== LEVEL 2: THE Chamber of Sequences ===");
				System.out.println("You reach a massive chamber covers with leaves.");
				System.out.println("The Spectral Guardian appears: 'Solve my sequence to cross!'");
				System.out.println("The bridge reveals this pattern: 1, 4, 9, 16, 25, 36");
				System.out.print("The Guardian asks: What are the next TWO numbers in this sequence? Enter them seperated by a space: ");
				int predict = input.nextInt();
				int pre = input.nextInt();
				if (predict == 49 && pre == 64) {
					System.out.println("The guardian bows. The artifact is yours! The temple rewards you.");
					playerHealth = playerHealth + a4;
					System.out.println(playerHealth + " is your new health! ");
				} else if (predict == 49 || pre == 64) {
					System.out.println("The sequence flickers. The guardian is only partially impressed.");
					playerHealth = playerHealth + 0;
					System.out.println(playerHealth + " is your new health! ");
				} else {
					System.out.println("The sequence shatters! The temple's curse strikes you.");
					playerHealth = playerHealth - a2;
					System.out.println(playerHealth + " is your new health! ");
				}
				System.out.println(
						"If you want to be the best escapist in the whole wide world you can gamble some of your health for double or nothing!");
				System.out.println("If you don't want it press 0 and see your results!");
				int gamb = input.nextInt();
				do {
					if (gamb > playerHealth) {
						System.out.println(
								"You are a greedy, sneeky escape specialist. This temple does not accept your tactics! You will be punished!");
						playerHealth = 0;
						gamb = 0;
					} else if (gamb <= playerHealth && gamb > 0) {
						System.out.println(
								"The number will be selected between -10 to 10, write zero for zero, write a positive integer if you select positive and vice versa");
						int gambl = random.nextInt(-10, 11);
						int pos = input.nextInt();
						if ((pos > 0 && gambl > 0) || (pos < 0 && gambl < 0)) {
							System.out.println("You won! What you gave will be returned to you doubled.");
							playerHealth = playerHealth + gamb;
							System.out.println(playerHealth);
						} else if (pos == 0 && gambl == 0) {
							playerHealth = playerHealth + gamb * gamb;
							System.out.println(
									"Jackpot! You have won the money of people who can't get out of the temple.");
							System.out.println(playerHealth + "is your new health!");
						} else {
							System.out.println(
									"You lost! What you gave will be appreciated as a donation to the Temple.");
							playerHealth = playerHealth - gamb;
							System.out.println(playerHealth);
						}
					} else {
						System.out.println("You listened your inner voice and convinced yourself this is a bad idea.");
						gamb = 0;
					}
					if (playerHealth == 0 || gamb == 0) {
						gamb = 0;
					} else {
						System.out.println(
								"-----If you don't want to continue press 0 and see your results! Otherwise input the number you want to gamble for-----");
						gamb = input.nextInt();
					}
				} while (gamb != 0);
				if (playerHealth >= 19230) {
					System.out.println(
							"You became the richest person in the whole world! You give people hope and make them die to the temple.");
				} else if (playerHealth >= 1000) {
					System.out.println(
							"The guardian of the temple bowing at you with honor, you are now the master of all temples in the three state area!");
				} else if (playerHealth >= 150) {
					System.out.println("You now own the temple and all the belongings of the temple, Master!");
				} else if (playerHealth >= 75) {
					System.out.println("You are a master explorer! You escape the temple unscathed.");
				} else if (playerHealth >= 40) {
					System.out.println("Bruised but triumphant, you escape with the artifact.");
				} else if (playerHealth > 1) {
					System.out.println("You barely escape with your life, the artifact lost to the temple's depths.");
				} else if (playerHealth == 1) {
					System.out.println("You escaped the temple but you are now paralyzed.");
				} else {
					System.out.println("You have died, Rest In Peace");
					System.out.println("If you want to hug Gambler Teddy Bear just write 1: ");
					if(input.nextInt()==1) {
						run();
					}
					else {
						System.out.println("Well, your choice.");}
				}
				LocalDateTime time=LocalDateTime.now();
				try (FileWriter writer = new FileWriter("Score.txt", true)) {
					writer.write(playerHealth + " is your escape health! You escaped at "+time+"\n");
				} catch (IOException e) {
					e.printStackTrace();
					break;
				}
			}
			System.out.println("-----If you want to play again write 'yes' otherwise press any key-----");
			replay = input.next();
		} while (replay.equals("yes"));
	}
	
	public static int alici(Scanner input) {
		int donut = input.nextInt();
		while(donut!=1&&donut!=2&&donut!=3) {
			System.out.println("You can only write 1, 2 or 3. Try again. ");
			donut = input.nextInt();
		}
		return donut;
	}
	public static void run() {
		    System.out.println(" ()_() ");
		    System.out.println(" _(\")_ ");
		    System.out.println("(_   _)");
		    System.out.println(" / ' \\ ");
		    System.out.println("(_/ \\_)");
	}
}