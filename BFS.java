import java.util.*;
class BFS {
    Queue<String> q = new LinkedList<String>();
    Map<String, Integer> map = new HashMap<String, Integer>();
    State st = null;
    String goal = "123456780";
    
    BFS(String init) {
        st = new State(init);
        add(init, 0);
    };

    public void solve() {
        // System.out.println("Initial State");
        // printState(q.peek());
        // String upString = st.moveUp(q.peek());
        // System.out.println("------------------");

        // st.printState(st.moveUp(q.peek()));
        // st.printState(st.moveDown(q.peek()));
        // st.add(init, 0);                          // Add the Initial State

        while (q.peek() != null) {

            moveUp(q.peek());                   // Move the blank space up and add new state to queue
            moveDown(q.peek());                 // Move the blank space down
            moveLeft(q.peek());                 // Move left
            moveRight(q.remove());              // Move right and remove the current node from Queue

        }
        // System.out.println("Solution doesn't exist");
        // Iterator it = map.entrySet().iterator();
        // while (it.hasNext()) {
        //     Map.Entry pairs = (Map.Entry)it.next();
        //     printState(pairs.getValue().toString());
        //     // System.out.println(pairs.getKey() + " = " + pairs.getValue());
        //     it.remove(); // avoids a ConcurrentModificationException

        // }
        System.out.println(map.size());
        // printMap(map);

    }
    void add(String str, int hashC) {
        if (!map.containsKey(str)) {
            map.put(str, hashC);
            st.setParent();
            queue.add(str);
        }
    }

    public void moveLeft(String str) {
        int a = str.indexOf("0");
        if (a != 0 && a != 3 && a != 6) {
            String s = str.substring(0, a - 1) + "0" + str.charAt(a - 1) + str.substring(a + 1);
            add(s, map.get(str) + 1);
            printState(s);
            if (s.equals(goal)) {
                System.out.println("Solution found at " + (map.get(s)+1)+" node.");
                System.exit(0); // exit 
            }
        }
    }

    public void moveUp(String str) {
        int a = str.indexOf("0");
        if (a > 2) {
            String s = str.substring(0, a - 3) + "0" + str.substring(a - 2, a) + str.charAt(a - 3) + str.substring(a + 1);
            add(s, map.get(str) + 1);
            printState(s);

            if (s.equals(goal)) {
                System.out.println("Solution found at " +( map.get(s)+1)+" node.");
                System.exit(0);
            }
        }
    }
    public void moveRight(String str) {
        int a = str.indexOf("0");
        if (a != 2 && a != 5 && a != 8) {
            String s = str.substring(0, a) + str.charAt(a + 1) + "0" + str.substring(a + 2);
            add(s, map.get(str) + 1);
            printState(s);

            if (s.equals(goal)) {
                System.out.println("Solution found at " + (map.get(s)+1)+" node.");
                System.exit(0);
            }
        }
    }
    public void moveDown(String str) {
        int a = str.indexOf("0");
        if (a < 6) {
            String s = str.substring(0, a) + str.substring(a + 3, a + 4) + str.substring(a + 1, a + 3) + "0" + str.substring(a + 4);
            add(s, map.get(str) + 1);
            printState(s);

            if (s.equals(goal)) {
                System.out.println("Solution found at " + (map.get(s)+1)+" node.");
                System.exit(0);
            }
        }
    }
    public void printState(String statecur) {
        String[][] test = new String[3][3];
        int n = 0 ;
        //1. change string to matrix representation
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                test[i][j] = statecur.substring(n, n + 1);
                n++;
            }
        }
        System.out.println(statecur);
        //2. print the matrix representation
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" | " + test[i][j]);
            }
            System.out.println(" |");
        }
    }

    public  void printMap(Map mp) {
        Iterator it = mp.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry)it.next();
            System.out.println(pairs.getKey() + " = " + pairs.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
    }


}