//Name:Aman Mehra
//Roll No:2017017
//Group:3


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.HashSet;
import java.lang.String;
import java.lang.Math;

/** Class for buffered reading int and double values */
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
	
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
    static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }
}

/* O(1) space and O(n) time increment  */

public class stacks{

	Node head = new Node(0);//contains length

	class Node{

		long info;
		Node link;

		Node(long data){
			this.info = data;
			this.link = null;
		}
	}

	void push(long data){
		Node newbie = new Node(data);
		newbie.link = this.head.link;
		this.head.link = newbie;
	}

	long pop(){
		long ret = this.head.link.info;
		this.head.link = this.head.link.link;
		return ret;
	}

	long peak(){
		return this.head.link.info;
	}

	boolean underflow(){
		if (this.head.link==null){
			return true;
		}
		return false;
	}
	void metalen(long d){
		this.head.info+=d;
	}
	void increase(long num,long inc){
		long thresh = this.head.info-num;
		long pos=1;
		Node cur = this.head.link;
		while (cur!=null){
			if (pos>thresh){
				cur.info+=inc;
			}
			cur=cur.link;
			pos+=1;
		}
	}

	public static void main(String[] args) throws IOException{
		Reader.init(System.in);
		int t = Reader.nextInt();
		stacks ob = new stacks();
		outer:
		for (int i=0;i<t;i++){
			String cmd = Reader.next();
			switch(cmd){
				case "push":
					long n = Reader.nextLong();
					ob.push(n);
					ob.metalen(1);
					System.out.println(ob.peak());
					break;
				case "pop":
					if (ob.underflow()){
						System.out.println("EMPTY");
					}
					else{
						ob.pop();
						ob.metalen(-1);
						if (ob.underflow()){
							System.out.println("EMPTY");
						}
						else{
							System.out.println(ob.peak());
						}
					}
					break;
				case "inc":
					long num = Reader.nextLong();
					long inc = Reader.nextLong();
					if (ob.underflow()){
						System.out.println("EMPTY");
					}
					else{
						ob.increase(num,inc);
						System.out.println(ob.peak());
					}
					break;
				default:
					break;
			}
		}
	}
}