import java.util.ArrayList;

public class Lobby {
	private String name;
	private ArrayList<String> playerNames;
	private String hostName;
	
	public Lobby(String name, String hostName) {
		this.name = name;
		this.hostName = hostName;
	}

	public String getName() { return name; }
	public String getHostName() { return hostName; }
	
	public void addPlayer(String uniqueName) {
		playerNames.add(uniqueName);
	}
}
