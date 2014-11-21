import java.util.Scanner;

public class solvePuzzle {
    String initialState;
    String finalState ;
    State stInit = null, stFinal = null;
    solvePuzzle(String initialState, String finalState) {
        this.initialState = initialState;
        this.finalState = finalState;
    }

    void callAlgo(algoEnum algoSelected) {
        switch (algoSelected) {
        case DFS:
            System.out.println("Depth First Search\n----------------------------");
            System.out.print("Enter the limit: ");
            Scanner limitValue = new Scanner(System.in);
            int limit =limitValue.nextInt();
            DFS_final dfs= new DFS_final(initialState, finalState, limit);
            dfs.play();
            break;

        case BFS:
            System.out.println("Breath First Search\n------------------------------");
            BFS_final bfs = new BFS_final(initialState, finalState);
            bfs.play();
            break;

        case ASTAR:
            System.out.println("A* Search Algorithm\n------------------------------\nStill being constructed");
            break;

        default:
            break;
        }
    }
}