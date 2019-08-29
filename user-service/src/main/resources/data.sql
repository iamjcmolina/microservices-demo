insert into `user` (`id`, `email`, `password`, `name`, `last_name`) values
(1, 'isc.juancarlosmolina@gmail.com','12345','Juan Carlos', 'Molina');

insert into `post` (`id`,`title`,`description`,`user_id`) values
(1,'Como usar JPA', 'Este articulo es un ejemplo', 1),
(2,'Como usar Flyway','Este articulo habla de flyway',1);