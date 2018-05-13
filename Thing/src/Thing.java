import java.util.Random;

public class Thing {

    public static void main(String[] args) {
        Random rad = new Random();


        for(int a = 0; a <= 11; a++){
            System.out.print('"');
            for(int i = 0; i< 30; i++){
                int  n = rad.nextInt(3);
                System.out.print(n);
            }
            System.out.print('"');
            System.out.println(",");
        }



    }
}
