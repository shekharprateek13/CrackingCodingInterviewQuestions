package dsalgoproblems.leetcode;


interface Ship {
    void go();
}

class MarineShip implements Ship {
    public void go() {
        System.out.println("Sea surface");
    }
}

class Submarine extends MarineShip{
    public void go() {
        System.out.println("Underwater");
    }
}

public class Main {

    public static void main(String[] args) {
        MarineShip submarine = new Submarine();
        ((Submarine)submarine).go();
    }
}