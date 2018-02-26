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
}

public class DoubleLinklist {

	static Node head = new Node(0);
    static Node rear = new Node(0);

	static class Node{

		int info =0;
		Node flink = null;
        Node blink = null;

		Node(int data){
			this.info = data;
		}
	}

    public void display(Node head , Node rear,int len){
        Node start = head.flink;
        Node end = rear.blink;
        while (start != end && start.flink!=end){
            System.out.println(start.info);
            System.out.println(end.info);
            start=start.flink;
            end=end.blink;
        }
        System.out.println(start.info);
        if (len%2==0){System.out.println(end.info);}
    }

    public static void main(String[] args) throws IOException {

            DoubleLinklist linklist = new  DoubleLinklist();
            Reader.init(System.in);
            int n = Reader.nextInt();
            Node pointer = DoubleLinklist.head;
            for (int i = 0;i<n;i++){
                int t = Reader.nextInt();
                Node newbie = new Node(t);
                pointer.flink = newbie;
                newbie.blink = pointer;
                pointer = newbie;
            }
            pointer.flink = DoubleLinklist.rear;
            DoubleLinklist.rear.blink = pointer;
            linklist.display(DoubleLinklist.head,DoubleLinklist.rear,n);
    }
}