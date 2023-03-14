package rezero;

// This is the thread for out
public class output extends Thread{
    OS hitagi ;
    int shinobu ;
    String kimi,
    output (OS gahara ,  int oshino ,String nonawa){
        hitagi = gahara;
        shinobu = oshino
		kimi = nonawa;
 
    }
    @Override 
    public void run(){
        for (int i = 0 ; i < hitagi.queue.size() ; i++){
            hitagi.out(shinobu,kimi);
        }
    }
}

