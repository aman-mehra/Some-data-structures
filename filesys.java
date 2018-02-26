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

public class filesys {

	Node root = new Node("root");
    Node curnode = root;
    String path = "root";
/*
    class HorNode{
        Node right;
        HorNode(){
            right=null;
        }
    }*/

	class Node{

		String info ="";
		Node[] flink = new Node[20];//HorNode flink;
        Node blink;
        Node right;
        int kids=0;

		Node(String data){
			this.info = data;
            //System.out.println(flink[0]);
            //flink= new HorNode();
            right=null;
            blink=null;
		}
	}

    void makedir(String dir){
        for (int i=0;i<curnode.kids;i++){
            if (curnode.flink[i].info.equals(dir)){
                System.out.println(-1);
                return;
            }
        }
        curnode.flink[curnode.kids]=new Node(dir);
        curnode.flink[curnode.kids].blink=curnode;
        curnode.kids++;
        /*
        Node cur = curnode.flink.right;
        Node prev = curnode.flink.right;
        Node newbie = new Node(dir);
        if (cur == null){
            newbie.blink = curnode;
            curnode.flink.right = newbie;
            return;
        }
        else{
            while(true){
                System.out.println(cur.info);
                if (cur.info == dir){
                    System.out.println(-1);
                    return;
                }
                else if(cur == null){
                    prev.right = newbie;
                    newbie.blink = curnode;
                    return;
                }
                else{
                    prev = cur;
                    cur = cur.right;
                }
            }
        }
        */
    }

    void changedir(String dir){
        if (dir.equals("..")){
            if(path.equals("root")){
                    System.out.println(-1);
                    return;
            }
            else{
                int pathnamelength = this.path.length();
                int dirnamelength = curnode.info.length();
                curnode = curnode.blink;
                this.path = this.path.substring(0,pathnamelength-dirnamelength-1);
                return;
            }
            /*
            if (this.curnode.blink==null){
                    System.out.println(-1);
                    return;
            }
            else{
                int pathnamelength = this.path.length();
                int dirnamelength = dir.length();
                this.curnode = this.curnode.blink;
                this.path = this.path.substring(0,pathnamelength-dirnamelength-1);
                return;
            }*/
        }
        else{
            for (int i=0;i<curnode.kids;i++){
                if (curnode.flink[i].info.equals(dir)){
                    curnode=curnode.flink[i];
                    this.path = this.path+"/"+this.curnode.info;
                    return;
                }
            }
            System.out.println(-1);
            return;
            /*
            //System.out.println(this.curnode.flink.right.info);
            //System.out.println(this.curnode.info);
            Node cur = this.curnode.flink.right;
            while(true){
               //System.out.println(cur.info);
                if (cur==null){
                    System.out.println(-1);
                    return;
                 }
                 else if (cur.info == dir){
                    //System.out.println(cur.info);
                    this.curnode = cur;
                    this.path = this.path+"/"+this.curnode.info;
                    return;
                 }
                 else{
                    cur = cur.right;
                 }
            }*/
        }
                       
    }

    void remove(String dir){
        int ind=-1;
        for (int i=0;i<curnode.kids;i++){
            if (curnode.flink[i].info.equals(dir)){
                ind=i;
            }
        }
        if (ind==-1){
            System.out.println(-1);
            return;
        }
        else{
            Node[] temp = curnode.flink;
            curnode.flink = new Node[20];
            int j=0;
            for (int i=0;i<curnode.kids;i++){
                if (i==ind){
                    j+=1;
                    if (j>19){
                        curnode.kids--;
                        return;
                    }
                }
                curnode.flink[i]=temp[j];
                j++;
            }
        }
        curnode.kids--;

        /*
        Node cur = curnode.flink.right;
        Node prev = curnode.flink.right;
        if (cur.info == rem){
            curnode.flink.right = cur.right;
        }
        while(true){
            if (cur == null){
                System.out.println(-1);
                return;
            }
            else if (cur.info == rem) {
                prev.right = cur.right;
                return;
            }
            else{
                cur = cur.right;
            }
        }*/
    }

    void dirpath(){
        System.out.println(path);
    }

    void dirlisting(){
        if (curnode.kids==0) {
            System.out.println(-1);
            return;
        }
        for (int i=0;i<curnode.kids;i++){
            System.out.print(curnode.flink[i].info+" ");
        }
        System.out.println();
        /*
        Node cur = curnode.flink.right;
        if (cur == null){
                 System.out.println(-1);
                return;
            }
        while(true){
            if (cur == null){
                 System.out.println();
                return;
            }
            System.out.print(cur.info+" ");
            cur = cur.right;
        }*/
    }

    public static void main(String[] args) throws IOException {
            Reader.init(System.in);
            filesys fs = new filesys();
            int n = Reader.nextInt();
            String ip;
            for (int i = 0;i<n;i++){
                String cmd = (Reader.next()).toLowerCase();
                switch(cmd){
                    case "mkdir" :
                        ip = (Reader.next()).toLowerCase();
                        fs.makedir(ip);
                        break;
                    case "cd" :
                        ip = (Reader.next()).toLowerCase();
                        fs.changedir(ip);
                        break;
                    case "rm":
                        String op = (Reader.next()).toLowerCase();
                        ip = (Reader.next()).toLowerCase();
                        fs.remove(ip);
                        break;
                    case "pwd":
                        fs.dirpath();
                        break;
                    case "ls":
                        fs.dirlisting();
                        break;
                    default:
                        break;
                }
                
            }
    }
}
/*
        Node cur = curnode;
        String path = "";
        while(true){
            path = path + cur.info;
            cur = cur.blink;
            if (cur==null){
                System.out.println(fs.rev(path));
                return;
            }
            path = path + "/";
        } */