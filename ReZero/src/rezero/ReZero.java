package rezero;

import java.util.ArrayList;
import javax.swing.*;

/*
Coders:
Alejandro Celis
Ted Michael Cruz
Ernesto Balisi Jr.
 */
public class ReZero {
    static JOptionPane j = new JOptionPane();
    static JFrame Frame = new JFrame ("OSHIETE");
    public static String input (String input_element){
        return j.showInputDialog(Frame,input_element);
    }
	//It creates a gant chart with labels
    static void printgraph(){
        System.out.print("Hundreds\t");
        for (int q1 = 0 ; q1 < 10 ; q1 ++){
            for (int q2 = 0 ; q2 < 10 ; q2 ++){
                for (int q3 = 0 ; q3 < 10 ; q3 ++){
                    System.out.print(q1);
                }
            }
        }
        System.out.print("\nTens\t\t");
        for (int q1 = 0 ; q1 < 10 ; q1 ++){
            for (int q2 = 0 ; q2 < 10 ; q2 ++){
                for (int q3 = 0 ; q3 < 10 ; q3 ++){
                    System.out.print(q2);
                }
            }
        }
        System.out.print("\nOnes\t\t");
        for (int q1 = 0 ; q1 < 10 ; q1 ++){
            for (int q2 = 0 ; q2 < 10 ; q2 ++){
                for (int q3 = 0 ; q3 < 10 ; q3 ++){
                    System.out.print(q3);
                }
            }
        }
        System.out.println("");
        
    }
    
    public static void main(String[] args) {
        String just = "                  ";
        j.showMessageDialog(Frame ,"WELCOME TO SCHEDULING ALGORITHM\n"+just+"[ROUND ROBIN]"
		      +"Coders:Alejandro Celis\nTed Michael Cruz\nErnesto Balisi Jr.");
	    String yourname = input("How should I call you? ");
        int limit = Integer.parseInt(input(yourname +", How Many task do you want?"));
        int quanta = Integer.parseInt(input(yourname +", What is the Interval?"));
		//proc will be the common class for the two thread
        OS proc = new OS ();
        printgraph();
        proc.inputjob(limit);
		//The Threads start
        scheduling shiro = new scheduling (proc, yourname);
        output sora= new output (proc,quanta,yourname);
        
        shiro.start();
        sora.start();
        
        
    }
    
}
