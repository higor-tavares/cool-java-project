package mypackage;

import java.net.Socket;
import java.net.SocketAddress;
import java.net.InetSocketAddress;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.InetSocketAddress;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Get{
	public static void main(String args[]) throws Exception{
		String address = args[0];
		Integer port = new Integer(args[1]);
		Socket socket = new  Socket();
		InetSocketAddress isa = new InetSocketAddress(address, port.intValue());
		System.out.println("connectig...");
		socket.connect(isa);
		System.out.println("successfuly connected");
		OutputStream os = socket.getOutputStream();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
		bw.write("GET /index.html HTTP/1.1");
		bw.flush();
		InputStream is = socket.getInputStream();
		System.out.println("reading data from server...");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line;
		do {
			System.out.println("i am here!");
			line = br.readLine();
			if(line == null) return;
			System.out.println("read: " + line);
		} while(line != null);

		System.out.println("read all data!");
	}
}
