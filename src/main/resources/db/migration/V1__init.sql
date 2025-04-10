CREATE TABLE `t_orders`
(
    `id`       bigint(20) NOT NULL AUTO_INCREMENT,
    `orderNumber`  varchar(255) DEFAULT NULL,
    `skuCode`  varchar(255) DEFAULT NULL,
    `price` int(11)      DEFAULT NULL,
    `quantity` int(11)      DEFAULT NULL,
    PRIMARY KEY (`id`)
);