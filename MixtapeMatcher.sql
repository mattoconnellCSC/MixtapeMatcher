DROP DATABASE IF EXISTS MixtapeMatcher;
CREATE DATABASE MixtapeMatcher;
USE MixtapeMatcher;


CREATE TABLE Song(
	id INT,
	title VARCHAR(50) NOT NULL,
	artist VARCHAR(50),
	youtubelink VARCHAR(200),
	PRIMARY KEY(id)
);

CREATE TABLE User(
	id INT,
	username VARCHAR(50) NOT NULL,
	password VARCHAR(50) NOT NULL,
	playlistId INT NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE Playlist(
	id INT,
	songId INT NOT NULL,
	PRIMARY KEY(id),
	CONSTRAINT FKPlaylist_songId FOREIGN KEY (songId)
		REFERENCES Song (id),
	CONSTRAINT FKPlaylist_userId FOREIGN KEY (userId)
		REFERENCES User (id)
);

CREATE TABLE Lobby(
	id INT,
	name VARCHAR(50) NOT NULL,
	password VARCHAR(50),
	userId INT NOT NULL,
	PRIMARY KEY(id),
	CONSTRAINT FKLobby_userId FOREIGN KEY (userId)
		REFERENCES User (id),
	CONSTRAINT FKLobby_playlistId FOREIGN KEY (playlistId)
		REFERENCES Playlist (id),
);
