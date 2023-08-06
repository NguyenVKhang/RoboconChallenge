
package org.kbc2d.utils.multiplayer;

import java.io.IOException;
import java.net.InetAddress;


import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import org.kbc2d.utils.Input;
import org.kbc2d.utils.multiplayer.Network.ChatMessage;
//import com.esotericsoftware.minlog.Log;

public class ChatClient {
	Input inputt;
	Client client;

	public ChatClient() {
		client = new Client();
		client.start();

		// For consistency, the classes to be sent over the network are
		// registered by the same method for both the client and server.
		Network.register(client);

		client.addListener(new Listener() {

			public void received(Connection connection, Object object) {

				if (object instanceof ChatMessage) {
					ChatMessage chatMessage = (ChatMessage) object;
					inputt = chatMessage.inputt;
					return;
				}
			}
		});

		// Request the host from the user.
		InetAddress address = client.discoverHost(54777, 5000);
		final String host = address.toString();

		// Request the user's name.

		// All the ugly Swing stuff is hidden in ChatFrame so it doesn't clutter
		// the KryoNet example code.

		// This listener is called when the send button is clicked.

		// We'll do the connect on a new thread so the ChatFrame can show a
		// progress bar.
		// Connecting to localhost is usually so fast you won't see the progress
		// bar.
		new Thread("Connect") {
			public void run() {
				try {
					client.connect(5000, host, Network.port);
					// Server communication after connection can go here, or in
					// Listener#connected().
					ChatMessage msg = new ChatMessage();
					msg.inputt = inputt;
					msg.text = "1";
					client.sendUDP(msg);
					client.stop();
				} catch (IOException ex) {
					ex.printStackTrace();
					System.exit(1);
				}
			}
		}.start();
	}



	public static void main(String[] args) {
		//Log.set(Log.LEVEL_DEBUG);
		new ChatClient();
	}
}
