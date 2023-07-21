CREATE DATABASE bank_nosql;

USE bank_nosql;

CREATE TABLE `transactions` (
    `id` varchar(35) GENERATED ALWAYS AS                 
               (json_compact(json_extract(`trans_details`,'$._id'))) VIRTUAL,
                `trans_details` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT 
               NULL CHECK (json_valid(`trans_details`)),
             UNIQUE KEY `id` (`id`),
            CONSTRAINT `id_not_null` CHECK (`id` is not null)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ;