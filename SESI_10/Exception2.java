package CODINGAN.SESI_10;

public class Exception2 {
    public static void main(String[] args) {
        int i = 0;
        String greetings[] = {
            "Hello World!",
            "No, I Mean It!",
            "HELLO WORLD!"
        };
        while(i<4)
        {
            try 
            {
                System.out.println(greetings[i]);
                i++;
            } 
            catch (ArrayIndexOutOfBoundsException e) 
            {
                System.out.println("Resetting index Value.");
                i=0;
                break;
            }
        }
    }
}