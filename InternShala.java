import java.util.*;
class PQ {
	String name;
	double CGPA;
	int token;
	PQ(String name,double CGPA,int token){
		this.CGPA=CGPA;
		this.name=name;
		this.token=token;
	}

}
class comp implements Comparator<PQ>{
	 public int compare(PQ s1, PQ s2) { 
         if (s1.CGPA > s2.CGPA) 
             return -1; 
         else if (s1.CGPA < s2.CGPA) 
             return 1; 
         else if(s1.name.equals(s2.name)){
        		 if(s1.token<s2.token)
        			 return -1;
        		 else
        			 return 1;
         }
         else {
        	 for(int i=0;i<Math.min(s1.name.length(), s2.name.length());i++) {
        		 if(s1.name.charAt(i)<s2.name.charAt(i)) {
        			 return -1;
        		 }else if(s1.name.charAt(i)>s2.name.charAt(i)) {
        			 return 1;
        		 }
        		 
        	 }
        	 return 0;
         }
            
     } 
}

public class InternShala {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		PriorityQueue<PQ> queue = new PriorityQueue<>(10,new comp());
		for(int i=0 ; i<n ; i++) {
			String choice = sc.next();
			if(choice.equals("ENTER") ){
				String name = sc.next();
				double CGPA = sc.nextDouble();
				int token = sc.nextInt();
				
				PQ x = new PQ(name,CGPA,token);
				
				queue.add(x);
			}
			else if(choice.equals("SERVED")){
				
				queue.poll();
				
			}
			
		}
		if(queue.isEmpty())
			System.out.println("EMPTY");
		else
			while(!queue.isEmpty()) {
				System.out.println(queue.poll().name);
			}
			
	}
	

}
