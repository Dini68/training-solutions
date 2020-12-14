package week08d01;

public class Robot {

    private Point position = new Point(0,0);

    public Point getPosition() {
        return position;
    }

    public Point move(String where) {
        for (int i = 0; i < where.length(); i++) {
            if (!(where.charAt(i) == 'F') && !(where.charAt(i) == 'L') && !(where.charAt(i) == 'B') && !(where.charAt(i) == 'J')) {
                throw new IllegalArgumentException("Hibás Karakter!");
            }
            if (where.charAt(i) == 'F') {
                position.setY(position.getY() + 1);
            }
            if (where.charAt(i) == 'L') {
                position.setY(position.getY() - 1);
            }
            if (where.charAt(i) == 'B') {
                position.setX(position.getX() - 1);
            }
            if (where.charAt(i) == 'J') {
                position.setX(position.getX() + 1);
            }
        }
        return position;
    }

    public static void main(String[] args) {
         Robot robot = new Robot();
        robot.move("FFLLLLLBBBBJJJJJJJ");
        System.out.println(robot.position.getX() + ", " + robot.position.getY());
    }
}
