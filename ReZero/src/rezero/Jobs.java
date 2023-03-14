package rezero;
//This is Job , consist of id ,arrival time, bursttime , priority
public class Jobs {
    String id ;
    int a ;
    int b ;
    int p ;
	//empty only applies for the process.
    boolean empty;
    Jobs (String id , int a , int b , int p  ){
        this.id = id ;
        this.a = a ;
        this.b = b;
        this.p = p;
    }
    Jobs (boolean empty){
        this.empty = empty;
    }
    Jobs (){;}
    
}
