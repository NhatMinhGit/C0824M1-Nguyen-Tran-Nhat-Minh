

public class Main {
    public static void main(String[] args) {

        MovablePoint mp = new MovablePoint();
        System.out.println(mp);

        MovablePoint mp1 = new MovablePoint(1.5f,2.5f);
        System.out.println(mp1);

        MovablePoint mp2 = new MovablePoint(1.5f,2.5f,1.5f,2.5f);
        mp2.move();
        System.out.println(mp2);
    }
}