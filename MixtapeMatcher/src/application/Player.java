package application;

public class Player {
	private String name;
	private Playlist playlist;
	
	// how to represent images?
	// private Image avatar;
	
	// how to encrypt, decrypt
	private String username;
	private String password;

	public Player() {}
	
	public Player(String name) {
		this.name = name;
	}
	
	public String getName() { return name; }
	public Playlist getPlaylist() { return playlist; }
	public String getUsername() { return username; }
	//public Image getAvatar() { return avatar; }
}
