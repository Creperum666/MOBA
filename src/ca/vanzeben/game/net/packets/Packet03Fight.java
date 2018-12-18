package ca.vanzeben.game.net.packets;

import ca.vanzeben.game.net.GameClient;
import ca.vanzeben.game.net.GameServer;

public class Packet03Fight extends Packet{

	private String username;
	private int x;
	private int y;
	
	public Packet03Fight(byte[]data) {
		super(03);
		String[] dataArray = readData(data).split(",");
        this.username = dataArray[0];
        this.x = Integer.parseInt(dataArray[1]);
        this.y =Integer.parseInt(dataArray[2]);
	}
	public Packet03Fight(String username, int x, int y) {
		super(03);
		this.username = username;
		this.x=x;
		this.y=y;
	}
	 @Override
	    public void writeData(GameClient client) {
	        client.sendData(getData());
	    }

	    @Override
	    public void writeData(GameServer server) {
	        server.sendDataToAllClients(getData());
	    }

	    @Override
	    public byte[] getData() {
	        return ("03" + this.username+","+this.x+","+this.y).getBytes();

	    }

	    public String getUsername() {
	        return username;
	    }
	    public int getX() {
	        return this.x;
	    }

	    public int getY() {
	        return this.y;
	    }

}
