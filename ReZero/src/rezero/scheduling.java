package rezero;
//This is the thread for the scheduler
public class scheduling extends Thread{
    OS hitagi ;
    String kimi;
    scheduling (OS gahara , String nonawa ){
        hitagi = gahara;
		kimi = nonawa;
    }
    @Override 
    public void run(){
        for (int i = 0 ; i < hitagi.queue.size() ; i++){
            hitagi.scheduler(kimi);
        }
    }
}
