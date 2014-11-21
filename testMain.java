import java.util.*;
import java.util.Scanner;
class testMain {

    public static void main(String[] args) {
        System.out.println("Enter the initial board State: ");

        // Scanner initialInput = new Scanner(System.in);
        String initState = "123450786"; // initialInput.next();
        // 102345678
        System.out.println("Enter the final board State: ");

        // Scanner finalInput = new Scanner(System.in);
        String finalState = "123456780"; //finalInput.next();
        System.out.println();


        solvePuzzle sp = new solvePuzzle(initState, finalState);
        System.out.println("Select algorithm to search: \n1. BFS\n2. DFS\n3. Astar\n     >> ");
        Scanner opt = new Scanner(System.in);
        int option = opt.nextInt();
        if (option == 1) {
            sp.callAlgo(algoEnum.BFS);
        } else if (option == 2) {
            sp.callAlgo(algoEnum.DFS);
        } else if (option == 3) {
            sp.callAlgo(algoEnum.ASTAR);
        } else
            System.out.println("Invalid option !!!");


    }

}
