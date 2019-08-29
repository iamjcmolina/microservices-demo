create table `user` (
`id` int primary key auto_increment,
`email` varchar,
`password` varchar,
`name` varchar,
`last_name` varchar,
`enabled` bit
);

create table `post`(
`id` int primary key auto_increment,
`title` varchar,
`description` varchar,
`user_id` int,
constraint fk_post_user foreign key(`user_id`) references `user`(`id`)
);