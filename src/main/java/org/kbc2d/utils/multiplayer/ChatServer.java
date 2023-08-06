
package org.kbc2d.utils.multiplayer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import org.kbc2d.utils.multiplayer.Network.ChatMessage;
//import com.esotericsoftware.minlog.Log;

public class ChatServer {
	Server server;

	public ChatServer() throws IOException {
		server = new Server() {
			protected Connection newConnection() {
				// By providing our own connection implementation, we can store
				// per
				// connection state without a connection ID to state look up.
				return new ChatConnection();
			}
		};

		// For consistency, the classes to be sent over the network are
		// registered by the same method for both the client and server.
		Network.register(server);

		server.addListener(new Listener() {
			public void received(Connection c, Object object) {
				// We know all connections for this server are actually
				// ChatConnections.
				ChatConnection connection = (ChatConnection) c;


				if (object instanceof ChatMessage) {
					// Ignore the object if a client tries to chat before
					// registering a name.
					if (connection.name == null)
						return;
					ChatMessage chatMessage = (ChatMessage) object;
					// Ignore the object if the chat message is invalid.
					String message = chatMessage.text;
					if (message == null)
						return;
					message = message.trim();
					if (message.length() == 0)
						return;
					// Prepend the connection's name and send to everyone.
					chatMessage.text = connection.name;
					for (Connection x : server.getConnections()) {
						if (x != c) {
							x.sendTCP(chatMessage);
						}
					}
					return;
				}

			}
		});
		server.bind(Network.port);
		server.start();
	}


	// This holds per connection state.
	public static class ChatConnection extends Connection {
		public String name;
	}

	public static void main(String[] args) throws IOException {
		//Log.set(Log.LEVEL_DEBUG);
		new ChatServer();
	}
}
