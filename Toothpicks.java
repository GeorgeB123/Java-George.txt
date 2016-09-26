import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Toothpicks extends JComponent{
  
    private static double ratio, width, size, height;
    private static int generation, lineAmount;
    private static int[] currentLine;
  
    public static void main(String[]args){
        ratio = 1;
        size = 1;
        height = 0;
        width = 0;
        Toothpicks t = new Toothpicks();
    
        JFrame window = new JFrame();
        window.setSize(new Dimension(800, 800));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        generation = Integer.parseInt(args[0]);
        if(args.length > 1 ){
            ratio = Double.parseDouble(args[1]);
        }
        size(1);
        if(width > height){
            size = 700 / width;
        } else {
            size = 700 / height;
        }
        window.add(t);
        window.setVisible(true);
    }
  
    public static int[] line(int[] midpoint, int tempInt) {    
        int x1 = 0, x2 =0, y1 = 0, y2 = 0;;
        int[] newLine = new int[4];
        if (tempInt%2 != 0) {
            x1 = midpoint[0];
            x2 = midpoint[0];
            y1 = midpoint[1] - (int)(size/2);
            y2 = midpoint[1] + (int)(size/2);
        } else {
            y1 = midpoint[1];
            y2 = midpoint[1];
            x1 = midpoint[0] - (int)(size/2);
            x2 = midpoint[0] + (int)(size/2);
        }
        newLine[0] = x1;
        newLine[1] = y1;
        newLine[2] = x2;
        newLine[3] = y2;   
        return newLine;
    }
  
    public void paint(Graphics gr){
        Graphics2D g = (Graphics2D) gr;
        ArrayList<int[]> list = new ArrayList<int[]>();
        int[] startPoint = {400, 400};
        int i = 0;
        while(i < generation){
            if(i<1){
                currentLine = line(startPoint, i);
                g.drawLine(currentLine[0],currentLine[1],currentLine[2],currentLine[3]);
                for(int j = 0; j < 2; j++){
                    ArrayList<int[]> a = midPoints(currentLine);
                    list.add(a.get(j));
                }                    
                lineAmount = 2;
            }else{
                int tempLine = lineAmount;
                for(int k = 0; k < tempLine; k++){
                    currentLine = line(list.get(0), i);
                    g.drawLine(currentLine[0],currentLine[1],currentLine[2],currentLine[3]);
                    list.remove(list.get(0));
                    for(int l = 0; l < 2; l++){
                        ArrayList<int[]> temp = midPoints(currentLine);
                        list.add(temp.get(l));
                    }
                }
                lineAmount *= 2;
            }
            i++;
            size *= ratio;
        }
    }
  
    public static ArrayList<int[]> midPoints(int[] coords){
        ArrayList<int[]> mid = new ArrayList<int[]>();
        int[] tempArr1 = new int[2];
        int[] tempArr2 = new int[2];
        tempArr1[0] = coords[0];
        tempArr1[1] = coords[1];
        tempArr2[0] = coords[2];
        tempArr2[1] = coords[3];
        mid.add(tempArr1);
        mid.add(tempArr2);
        return mid;
    }
  
    public static void size(double d){
        int g = generation, i = 1;
        double temp = d;
        width = d;
        i++;
        while( i <= g) {
            temp = temp*ratio;
            if(i % 2 == 0) {
                height += temp;
            }else { 
                width += temp;
            }
            i++;
        }
    }
}
