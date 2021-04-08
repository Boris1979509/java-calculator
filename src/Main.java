import exception.LimitNumbersException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

    /**
     * The type Main.
     */
    public class Main {

        public static void main(String[] args) throws Exception
        {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the data string in the format: <1 + 3> or <I + III>");
            String input = reader.readLine(); // Enter

            try {
                System.out.println(Handle.request(input));
            } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException | LimitNumbersException e){
                System.err.println(e.getMessage());
            }

            reader.close();
        }
    }
