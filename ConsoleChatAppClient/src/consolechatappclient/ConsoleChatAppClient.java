package consolechatappclient;

import java.io.*;
import java.net.*;
import java.util.*;

public class ConsoleChatAppClient {

    public static void main(String[] args) {

        try {
            Socket s = new Socket("localhost", 2099);
            System.out.println("Connected");

            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            Scanner sc = new Scanner(System.in);
            String m = sc.nextLine();
            dout.writeUTF(m);
            dout.flush();

            m = din.readUTF();
            System.out.println("Server Message: " + m);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
