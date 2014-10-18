import java.io.IOException;
import java.util.Scanner;

/**
 * Created by rishabh on 9/23/14.
 * This is the main class that will execute the cache emulator and do the tasks of reading and writing.
 * It will run a controlled do-while loop for menu and perform the operations as per the user input.
 */

public class architecture {

    public static void main(String args[]) throws IOException
    {
        int response;
        int block_number;
        int offset;
        int value;

        System.out.println("Cache Management Emulator - Rishabh Mehan");

        Scanner reader = new Scanner(System.in);

        // The associativity has to be between 1-8, since there is no check it's user relied input
        System.out.print("Enter Associativity[1-8]: ");
        global.setAssociativity(reader.nextInt());
        global.setSets();

        System.out.println("Cache Sets: " + global.getSets());

        // Initializing the Cache
        cache.init_cache();
        //Initializing the Memory
        memory.init_memory();

        //Do While loop for the choice section
        do {
            /**
             * Printing the Data on the Screen
             */
            global.screenBreak("HIT/MISS Count");
            global.printHitMiss();
            global.screenBreak("Cache");
            cache.print();
            global.screenBreak("Memory");
            memory.print();
            global.screenBreak("Choices");

            /* Show the menu and receive the input */
            System.out.print("[1] - Read from Memory \n"+"[2] - Write to Memory\n"+"[3] - Quit\n\n"+"Enter Your Choice: ");
            reader = new Scanner(System.in);
            response = reader.nextInt();

            switch (response){
                case 1:

                    System.out.print("Enter Block number: ");
                    block_number = reader.nextInt();

                    System.out.print("Enter Offset: ");
                    offset = reader.nextInt();

                    //Calling the Read from Memory method
                    System.out.println("Action= READ | Block= "+ block_number +" | Offset= "+ offset);
                    if(cache.is_cache_hit(block_number, global.READ)){
                        System.out.println("Found. Its a Hit.");
                    }
                    else{
                        System.out.println("Fetching from memory, and loading into cache. It was a Miss.");
                        global.readMiss();
                        cache.load_from_memory(block_number);
                    }
                    break;
                case 2:

                    System.out.print("Enter Block number: ");
                    block_number = reader.nextInt();

                    System.out.print("Enter Offset: ");
                    offset = reader.nextInt();

                    //Call the method to write to memory
                    System.out.print("Enter Value: ");
                    value = reader.nextInt();

                    System.out.println("Action= WRITE | Block= "+ block_number +" | Offset= "+ offset);
                    if(cache.is_cache_hit(block_number, global.WRITE)){
                        System.out.println("Found. Its a Hit.");
                        //Write in Cache and Write to memory
                        cache.write_to_cache(block_number, offset,value);
                        memory.memory[block_number][offset] = value;

                    }
                    else{
                        System.out.println("It was a Miss. Writing to the memory");
                        global.writeMiss();
                        memory.memory[block_number][offset] = value;
                    }
                    break;
                case 3:
                    //The exit option.
                    System.out.println("Exiting System now. Thanks");
                    break;
                default:
                    System.out.println("Unspecified Choice Entered. Please Try again.");
                    break;
            }


        } while(response!=3);


    }

}
