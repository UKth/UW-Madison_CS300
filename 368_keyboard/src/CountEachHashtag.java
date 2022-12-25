import java.util.Scanner;
import java.util.ArrayList;

public class CountEachHashtag {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // TODO: define and initialize two ArrayLists, one to hold the hashtags and one to count them
    ArrayList<String> tags = new ArrayList<>();
    ArrayList<Integer> count = new ArrayList<>();
    
    System.out.println("Enter a list of hashtags ('end' to end):");        
    boolean done = false;
    do {
      String hashtag = input.next();
      if (hashtag.equals("end")) {
        done = true;
      } else {
        hashtag = hashtag.startsWith("#") ? hashtag : "#" + hashtag;
        if(tags.contains(hashtag)) {
        	int idx = tags.indexOf(hashtag);
        	int cnt = count.get(idx);
        	count.set(idx, cnt+1);
        } else {
        	tags.add(hashtag);
        	count.add(1);
        }
      }
    } while (!done);
        
    // TODO: determine total number of unique hashtags
    int size = tags.size();
    int min_cnt = 100;
    int max_cnt = 0;
    int sum_cnt = 0;
    for(int i = 0; i < size; i++) {
    	int cnt = count.get(i);
    	if(cnt < min_cnt) {
    		min_cnt = cnt;
    	}
    	if(cnt > max_cnt) {
    		max_cnt = cnt;
    	}
    	sum_cnt = sum_cnt + cnt;
    }
    double avg_cnt = (sum_cnt*1.0)/size;
    
    // TODO: determine minimum count
    // TODO: determine maximum count
    // TODO: determine average count
        
    final int NUM_PER_STAR = 1;
    // TODO: draw bar chart
        
    System.out.println(size+" hashtags minimum="+min_cnt+", maximum="+max_cnt+", average="+avg_cnt);
    for(int i = 0; i < size; i++) {
    	int cnt = count.get(i);
    	String tag = tags.get(i);
    	for(int j = 0; j < cnt; j++) {
    		System.out.print("*");
    	}
    	System.out.println(" "+tag+"("+cnt+")");
    }
    System.out.println("(A * represents " + NUM_PER_STAR + 
            " use of tag.)");
  }
}




