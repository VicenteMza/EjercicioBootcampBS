INSERT INTO generos(NOMBRE) VALUES('CIENCIA FICCION');
INSERT INTO generos(NOMBRE) VALUES('COMEDIA');
INSERT INTO generos(NOMBRE) VALUES('TERROR');
INSERT INTO generos(NOMBRE) VALUES('DRAMA');

INSERT INTO peliculas(TITULO, FECHA_ESTRENO, CALIFICACION,ID_GENERO) VALUES('BATMAN', '1989-12-14', 5, 1);
INSERT INTO peliculas(TITULO, FECHA_ESTRENO, CALIFICACION,ID_GENERO) VALUES('SHAUN OF THE DEAD', '2004-04-09', 3, 2);
INSERT INTO peliculas(TITULO, FECHA_ESTRENO, CALIFICACION,ID_GENERO) VALUES('SUPERMAN I', '1979-04-25', 4, 1);

INSERT INTO personajes(NOMBRE, EDAD, PESO, HISTORIA) VALUES ('BRUCE WAYNE', 29, 90.0, 'Humano que usa la inteligencia y fortuna para luchar contra el crimen en Ghotam');
INSERT INTO personajes(NOMBRE, EDAD, PESO, HISTORIA) VALUES ('SHAUN', 30, 85.0, 'un vendedor de productos electrónicos que vive en Londres, inmerso en la rutina de la ciudad, debe luchar contra zombies');
INSERT INTO personajes(NOMBRE, EDAD, PESO, HISTORIA) VALUES ('CLARK KENT', 30, 90.2, 'Extraterrestre, ultimo sobreviviente del Planeta Crypton.');
INSERT INTO personajes(NOMBRE, EDAD, PESO, HISTORIA) VALUES ('ELLEN RIPLEY', 28, 65.0, 'La tripulación del remolcador espacial Nostromo atiende una señal de socorro y, sin saberlo, sube a bordo una letal forma de vida extraterrestre.');

INSERT INTO peliculas_personajes(PELICULAS_ID, PERSONAJES_ID) VALUES(1, 1);
INSERT INTO peliculas_personajes(PELICULAS_ID, PERSONAJES_ID) VALUES(3, 3);





