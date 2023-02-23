INSERT INTO genre(name) VALUES('CIENCIA FICCION');
INSERT INTO genre(name) VALUES('COMEDIA');
INSERT INTO genre(name) VALUES('TERROR');
INSERT INTO genre(name) VALUES('DRAMA');

INSERT INTO movies(title, release_date, rating,genre_id) VALUES('BATMAN', '1989-12-14', 5, 1);
INSERT INTO movies(title, release_date, rating,genre_id) VALUES('SHAUN OF THE DEAD', '2004-04-09', 3, 2);
INSERT INTO movies(title, release_date, rating,genre_id) VALUES('SUPERMAN I', '1979-04-25', 4, 1);

INSERT INTO characters(name, age, weight, history) VALUES('BRUCE WAYNE', 29, 90.0, 'Humano que usa la inteligencia y fortuna para luchar contra el crimen en Ghotam');
INSERT INTO characters(name, age, weight, history) VALUES('SHAUN', 30, 85.0, 'un vendedor de productos electrónicos que vive en Londres, inmerso en la rutina de la ciudad, debe luchar contra zombies');
INSERT INTO characters(name, age, weight, history) VALUES('CLARK KENT', 30, 90.2, 'Extraterrestre, ultimo sobreviviente del Planeta Crypton.');
INSERT INTO characters(name, age, weight, history) VALUES('ELLEN RIPLEY', 28, 65.0, 'La tripulación del remolcador espacial Nostromo atiende una señal de socorro y, sin saberlo, sube a bordo una letal forma de vida extraterrestre.');

INSERT INTO characters_movies(movie_id, character_id) VALUES(1, 1);
INSERT INTO characters_movies(movie_id, character_id) VALUES(3, 3);





