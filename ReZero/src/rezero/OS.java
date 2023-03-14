package rezero;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/*
Ted Sama
Celis Senpai
Ernst San

 */
public class OS {
    int counter = 0;
	//Queue is for the Scheduler and temp is for the user input
    ArrayList <Jobs> queue = new ArrayList();
    ArrayList <Jobs> temp = new ArrayList();
    String blank = "";
	//intialize Jobs as empty , this is for the processor
    Jobs processed = new Jobs(true);
    
    JOptionPane j = new JOptionPane();
    JFrame Frame = new JFrame ("OSHIETE");
    
    public String input (String input_element){
        return j.showInputDialog(Frame,input_element);
    }
    //this is where the user will input the tasks
    public void inputjob(int limit){
        for (int i = 0 ; i < limit ; i ++){
            String newId;
            int newA;
            int newB ;
            int newP ;     
            do{
                newId = input("Enter an ID[SINGLE ID]");
            }while (newId.length()!= 1);
            newA = Integer.parseInt(input("Enter the Arrival Time:"));
            do{
                newB = Integer.parseInt(input("Enter the Burst Time[NONZERO]"));
            }while(newB == 0);
            newP = Integer.parseInt(input("Enter the Priority:"));
            temp.add(new Jobs(newId, newA , newB , newP));
        }
        scheduling();
        haruhi();
		suzumiya();
    }
	
    public void scheduling(){
        int hi = 0;
        for (Jobs gin : temp){
            if (gin.a > hi) hi = gin.a;
        }
        for (int i = 0 ; i <= hi ; i++){
            for (Jobs gin: temp){
                if (gin.a == i) queue.add(gin);
            }
        }
    }
	//It creates a table user had input , not arranged
	public void haruhi (){
		String x = "Your Tasks\nId     AT    BT    P     \n";
		for(Jobs kyon : temp){
			String y = kyon.id;
			int kagura = 7 - y.length() ;
			for (int i = 0; i < kagura ; i++){
				y += " ";
			}
			String u = kyon.a + "";
			kagura = 7 - u.length();
			for (int i = 0; i < kagura ; i++){
				u += " ";
			}
			String r = kyon.b + "";
			kagura = 7 - r.length();
			for (int i = 0; i < kagura ; i++){
				r += " ";
			}
			String i = kyon.p + "";
			kagura = 7 - i.length();
			for (int q = 0; q < kagura ; q++){
				i += " ";
			}
			x += y+u+r+i+"\n";
		}
		j.showMessageDialog(Frame , x);
	}
	//it shows the current arranged list of tasks
        public void suzumiya (){
		String x = "Current Arrange Tasks\nId    AT    BT    P     \n";
		for(Jobs kyon : queue){
			String y = kyon.id.substring(0,1);
			int kagura = 7 - y.length() ;
			for (int i = 0; i < kagura ; i++){
				y += " ";
			}
			String u = kyon.a + "";
			kagura = 7 - u.length();
			for (int i = 0; i < kagura ; i++){
				u += " ";
			}
			String r = kyon.b + "";
			kagura = 7 - r.length();
			for (int i = 0; i < kagura ; i++){
				r += " ";
			}
			String i = kyon.p + "";
			kagura = 7 - i.length();
			for (int q = 0; q < kagura ; q++){
				i += " ";
			}
			x += y+u+r+i+"\n";
		}
		j.showMessageDialog(Frame , x);
	}
    //In a thread , it puts a task into a process
    public synchronized void scheduler (String yourname){
        while (!processed.empty){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(OS.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        processed = queue.get(counter);
        j.showMessageDialog (Frame , yourname+", This is Task for " + processed.id.substring(0,1));
        processed.empty = false;
        counter++;
        notify();
    }
	//it puts a task in a graph , simulate process
    public synchronized void out (int quanta,String yourname) {
        while (processed.empty){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(OS.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
		String taki = processed.id;
		int mitsuha = 1;
		if (processed.id.length()>1){
			taki = processed.id.substring(0,1);
			mitsuha += Integer.parseInt(processed.id.charAt(1) + "");
		}
        System.out.print(processed.id+"\t\t");
        System.out.print(blank);
        int x = 0;
        for (int i = 0 ; i < processed.b ; i ++){
            System.out.print("+");
            blank += " ";
            x++;
			//When in its burst time is higher than the quanta
			//it creates a new task, with the same id but less quanta
            if (x > quanta && counter!=queue.size() && quanta!= processed.b){
                queue.add(new Jobs(taki+mitsuha, processed.a , processed.b-quanta , processed.p));
                x = 0;
                break;
            }
            
        }
		//if reaches the end of processes, 
		//it shows again all the task with
		//the remaining burst time, 
        if (counter == queue.size()){
            suzumiya();
			j.showMessageDialog(Frame , "Thanks! "+yourname+" for using the program");
        }
        System.out.println("");
        processed.empty = true;
        
        notify();
    }
}
