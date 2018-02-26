//Name:Aman Mehra
//Roll No:2017017
//Group:3

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
}

public class Slist {

	Node head = new Node(0);
	int length = 0;

	class Node{

		int info;
		Node link = null;

		Node(int data){
			this.info = data;
		}
	}

	public void ins(Slist x,int nodeinfo){
		Node newbie = new Node(nodeinfo);
		if (x.head.link==null){
			x.head.link = newbie;
		}
		else{
			Node curnode = x.head.link;
			Node prev = x.head;
			while(true){
				if (curnode==null){
					prev.link=newbie;
					return;
				}
				if (curnode.info == nodeinfo){
					return;
				}
				else if(curnode.info < nodeinfo){
					prev=curnode;
					curnode=curnode.link;
				}
				else{
					prev.link=newbie;
					newbie.link=curnode;
					return;
				}
			}
		}
	}
	
	public void sub(Slist a,Slist b){
		Node cur_a = a.head.link;
		Node cur_b = b.head.link;
		int ctr = 0;
		if (a.head.link==null){
			System.out.println(-1);
			return;
		}
		outer:
		while(true){
			cur_b = b.head.link;
			if (cur_a==null){
				if(ctr==0){
					System.out.println(-1);
					return;
				}
				System.out.println();
				return;
			}
			int element = cur_a.info;
			while (cur_b!=null){
				if (cur_b.info==element){
					cur_a = cur_a.link;
					continue outer;
				}
				else if(cur_b.info>element){
					break;
				}
				cur_b = cur_b.link;
			}
			System.out.print(element+" ");
			cur_a=cur_a.link;
			ctr+=1;
		}
	}

	public void add(Slist a,Slist b){
		Node cur_a = a.head.link;
		Node cur_b = b.head.link;
		if (a.head.link==null && b.head.link==null){
			System.out.println(-1);
			return;
		}
		while(true){
			if (cur_a==null || cur_b==null){
				if(cur_b==null && cur_a==null){
					System.out.println();
					return;
				}
				else if(cur_a==null){
					System.out.print(cur_b.info+" ");
					cur_b = cur_b.link;
				}
				else{
					System.out.print(cur_a.info+" ");
					cur_a = cur_a.link;
				}
			}
			else if (cur_b.info==cur_a.info){
				System.out.print(cur_b.info+" ");
				cur_b = cur_b.link;
				cur_a = cur_a.link;
			}
			else if(cur_b.info<cur_a.info){
				System.out.print(cur_b.info+" ");
				cur_b = cur_b.link;
			}
			else{
				System.out.print(cur_a.info+" ");
				cur_a = cur_a.link;
			}
		}		
	}

	public void display(Slist x){
		Node curnode = x.head.link;
		if (x.head.link==null){
			System.out.println(-1);
			return;
		}
		while(true){
			if (curnode==null){
				System.out.println();
				return;
			}
			System.out.print(curnode.info+" ");
			curnode=curnode.link;
		}
	}
	
	public static void main(String[] args) throws IOException {

		Slist A = new Slist();
		Slist B = new Slist();
		Reader.init(System.in);
		int n = Reader.nextInt();
		for (int i=0;i<n;i++){
			int op = Reader.nextInt();
			if (op==1){
				int val = Reader.nextInt();
				A.ins(A,val);
				//A.display(A);
			}
			else if (op==2){
				int val = Reader.nextInt();
				B.ins(B,val);
			}
			else if (op==3){
				A.sub(A,B);
			}
			else if (op==4){
				B.sub(B,A);
			}
			else if (op==5){
				A.add(A,B);
			}
			else if (op==6){
				A.display(A);
			}
			else{
				B.display(B);
			}
		}
	}
}
