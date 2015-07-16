import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by arundh on 16/07/15.
 */
public class MarsRover {
static     int initialXCoordinate,initialYCoordinate;
static     char initialDirection;
static     int currentXCoordinate,currentYCoordinate;
static     int currentDirection;
static     int [] maxCoordinates=new int[2];
static int condition=0;
    static  int noOfROvers;
    public static void main(String[] args) {
        ArrayList<Character> direction=new ArrayList<Character>();
        direction.add('N');
        direction.add('E');
        direction.add('S');
        direction.add('W');

        Scanner sc = new Scanner(System.in);
        for(int i=0;i<2;i++) {
            maxCoordinates[i]=sc.nextInt();
            }
        noOfROvers=sc.nextInt();
        initialXCoordinate=sc.nextInt();
        initialYCoordinate=sc.nextInt();
        initialDirection=sc.next().charAt(0);
        currentDirection=direction.indexOf(initialDirection);
        currentXCoordinate=initialXCoordinate;
        currentYCoordinate=initialYCoordinate;

//logic
        for(int j=0;j<noOfROvers;j++) {
            condition=0;
            String input = sc.next();
            for (int i = 0; i < input.length(); i++) {
                switch (input.charAt(i)) {
                    case 'L':
                        changeDirection('L');
                        break;
                    case 'M':
                        condition = moveForward(currentDirection);
                        break;
                    case 'R':
                        changeDirection('R');
                        break;
                }
               }
            if(condition==0)
            System.out.println(currentXCoordinate + " " + currentYCoordinate + " " + direction.get(currentDirection));
            else
                System.out.println("rover out of plateau");

        }
    }

    private static void changeDirection(char l) {
        if(l=='L') {
            currentDirection--;
            if (currentDirection < 0)
                currentDirection = 3;
        }
        else
        {
            currentDirection++;
            if(currentDirection>3)
                currentDirection=0;
        }

    }

    public static int moveForward(int currentDirection) {
        switch (currentDirection){
            case 0:         //North
                currentYCoordinate++;
                break;
            case 1:         //east
                currentXCoordinate++;
                break;
            case 2:         //south
                currentYCoordinate--;
                break;
            case 3:         //west
                currentXCoordinate--;
                break;



        }
        if(currentXCoordinate>maxCoordinates[0] || currentYCoordinate>maxCoordinates[1]){
            return 1;
        }
        else
            return  0;
    }
}
