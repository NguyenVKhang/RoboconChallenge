
package org.kbc2d.utils.multiplayer;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.EndPoint;
import org.kbc2d.utils.Input;

// This class is a convenient place to keep things common to both the client and server.
public class Network {
	static public final int port = 54777;

	// This registers objects that are going to be sent over the network.
	static public void register(EndPoint endPoint) {
		Kryo kryo = endPoint.getKryo();
		kryo.register(String[].class);
		kryo.register(ChatMessage.class);
	}

	static public class ChatMessage {
		public String text;
		public Input inputt;
	}
}
