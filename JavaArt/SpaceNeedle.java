public class SpaceNeedle {
    public static final int SIZE = 3;

    public static void main(String[] args){
        needle();
        top();
        middle();
        needle();
        body();
        top();
    }

    public static void needle(){
        for (int i = 1; i <= SIZE; i++){
           for (int space = 1; space <= 3 * SIZE; space++){
               System.out.print(" ");
           }
           System.out.println("||");

         }
    }

    public static void top(){ 
        for (int line = 1; line <= SIZE; line++){ //how to write the spaces
           for (int space1 = 1; space1 <= -3 * line + SIZE * 3; space1++){
               System.out.print(" ");
           }
           System.out.print("__/");

            for (int dots = 2; dots <= line; dots++){
                System.out.print(":::");
            }
            System.out.print("||");

            for (int dots = 2; dots <= line; dots++){
                System.out.print(":::"); 
            }
            System.out.print("\\__");
            System.out.println();

        }

        System.out.print("|");
        for(int spacer = 1; spacer <= 6 * SIZE + 1; spacer++){
            System.out.print("\"");
        }
        System.out.println("|");

    }

    public static void middle(){
        for (int line = 1; line <= SIZE; line++){
           for (int space1 = 1; space1 <= 2 * line - 2; space1++){
               System.out.print(" ");
           }
           System.out.print("\\_/");
           for (int v = 1; v <= -2 * line + SIZE * 3; v++){
               System.out.print("\\/");
           }
           System.out.print("\\_/");
           System.out.println();
        }

    }

    public static void body(){

        for (int i = 1; i <= SIZE * SIZE; i++){ //it works on evens not on odds
            for (int space = 1; space <= 2 * SIZE +1; space++){
               System.out.print(" ");
           }
            System.out.print("|");
           for (int space = 1; space <= SIZE - 2; space++){
               System.out.print("%");
           }
           System.out.print("||");

           for (int space = 1; space <= SIZE - 2; space++){
               System.out.print("%");
           }
           System.out.println("|");
        }
    }


    

}