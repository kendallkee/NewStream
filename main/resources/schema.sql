DROP TABLE IF EXISTS user_songs;
DROP TABLE IF EXISTS song_reviews;
DROP TABLE IF EXISTS songs;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
    user_id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(256) NOT NULL,
    password VARCHAR(128) NOT NULL,
    email VARCHAR(128) NOT NULL,
    PRIMARY KEY (user_id),
    UNIQUE (username), -- Added unique constraint for username
    UNIQUE (email) -- Added unique constraint for email
);

CREATE TABLE songs (
    song_id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(64) NOT NULL,
    artist VARCHAR(64) NOT NULL,
    genre VARCHAR(64) NOT NULL,
    release_date DATE NOT NULL, 
    PRIMARY KEY (song_id)
);

CREATE TABLE song_reviews (
    review_id INT NOT NULL AUTO_INCREMENT,
    song_id INT NOT NULL,
    user_id INT NOT NULL,
    rating INT NOT NULL,
    comment VARCHAR(256) NOT NULL,
    PRIMARY KEY (review_id),
    FOREIGN KEY (song_id) REFERENCES songs (song_id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE
);

CREATE TABLE user_songs (
    user_id INT NOT NULL,
    song_id INT NOT NULL,
    like_date DATE NOT NULL, 
    PRIMARY KEY (user_id, song_id), -- Added composite primary key
    FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE,
    FOREIGN KEY (song_id) REFERENCES songs (song_id) ON DELETE CASCADE,
    INDEX (user_id), -- Added index for foreign key
    INDEX (song_id) -- Added index for foreign key
);
