create schema if not exists music_blog;

create table genres(
    id INT (30) NOT NULL AUTO_INCREMENT,
    genre_name VARCHAR (250) NOT NULL,
    PRIMARY KEY (id)
);

create table sub_genres(
  id INT NOT NULL AUTO_INCREMENT,
  sub_gen_name VARCHAR (250) NOT NULL,
  genreid INT NOT NULL,
  PRIMARY KEY (id)
);

alter table sub_genres add constraint CONSTR_SUBGEN_GEN foreign key (genreid) references genres(id);

INSERT INTO music_blog.genres (genre_name) values
  ('ambient/new age'),
  ('electronica/downtempo'),
  ('hip-hop/r'n'b');

INSERT INTO music_blog.sub_genres (sub_gen_name, genreid) values
  ('ambient', 1),
  ('new age', 1),
  ('vaporwave', 1),
  ('beats', 2),
  ('glitch', 2),
  ('trip hop', 2),
  ('classic hip hop', 3),
  ('dirty south', 3),
  ('gangsta rap', 3);