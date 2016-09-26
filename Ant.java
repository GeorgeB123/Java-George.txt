import java.util.*;
import java.awt.*;

public class Ant {

    private static ArrayList<String> DNA = new ArrayList<String>();
    private static ArrayList<Character> stateList = new ArrayList<Character>();
    private static ArrayList<String> directionList = new ArrayList<String>();
    private static ArrayList<String> nextState = new ArrayList<String>();

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        } catch(NoSuchElementException e){
            return false;
        }
        // only got here if we didn't return false
        return true;
    }


    private static void readLines(Scanner sc){
        String line = sc.nextLine();
        
        while(line.trim().isEmpty() && sc.hasNextLine()){
            
            line = sc.nextLine();
                 
        }

        if(line.substring(0, 1).equals("#") && sc.hasNextLine()) {
            line = sc.nextLine();
        }
        if(isInteger(line)){
            int steps = Integer.parseInt(line);
            
            playScenarios(steps);

        } else {
            DNA.add(line);

        }
    }

    private static void sortDNA(){
        for(String str: DNA){
            stateList.add(str.charAt(0));
            directionList.add(str.substring(2,6));
            nextState.add(str.substring(7,11));
        }
    }

    private static void playScenarios(int steps){
        sortDNA();
        char state = stateList.get(0);
        int direction = 2;
        char moveTowards = 'N';
        String states;
        char newState = ' ';
        Point ant = new Point();
        int count = 0;

        while(count < steps){
            for(int i = 0; i < stateList.size(); i++){
                if(state == stateList.get(i)){
                    String compass = directionList.get(i);
                    moveTowards = compass.charAt(direction);
                    states = nextState.get(i);
                    newState = states.charAt(direction);
                }
            }
            switch(moveTowards){
                case 'N':
                    ant.translate(0,1);
                    count++;
                    direction = 0;
                    state = newState;
                    break;
                case 'E':
                    ant.translate(1,0);
                    count++;
                    direction = 1;
                    state = newState;
                    break;
                case 'S':
                    ant.translate(0,-1);
                    count++;
                    direction = 2;
                    state = newState;
                    break;
                case 'W':
                    ant.translate(-1,0);
                    count++;
                    direction = 3;
                    state = newState;
                    break;
            }
        }
        //System.out.println(ant.toString());
        for(String s : DNA){
            System.out.println(s);
        }
        System.out.println(count + "\n#" + " " + (int)ant.getX() + " " + (int)ant.getY());
        DNA.clear();
        stateList.clear();
        directionList.clear();
        nextState.clear();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            readLines(sc);
        }
    }
}
