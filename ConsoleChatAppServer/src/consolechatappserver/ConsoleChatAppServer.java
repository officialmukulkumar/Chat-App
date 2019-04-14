package consolechatappserver;

import java.net.*;
import java.io.*;
import java.util.*;

public class ConsoleChatAppServer {
    
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(2099);
            Socket s = ss.accept();
            System.out.println("Connected");
            
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            
            String m = din.readUTF();
            System.out.println("Client Message: " + m);
            Scanner sc = new Scanner(System.in);
            m = sc.nextLine();
            dout.writeUTF(m);
            dout.flush();
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
}
