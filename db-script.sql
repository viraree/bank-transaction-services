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

#######################################
[{'currency_amount': 'CHF 75',
 'description': 'Online payment CHF',
 'eur_amount': 77.78,
 'id': 0,
 'month_num': 1,
 'uid': '89d3o179-abcd-465b-o9ee-e2d5f6ofEld46',
 'user': {'full_name': 'Peter Russells',
          'home_address': '123 Sunset Avenue',
          'id': 0,
          'phone': '408-867-5309',
          'uid': 'P-0123456789'},
 'user_uid': 'P-0123456789',
 'value_date': datetime.datetime(2015, 7, 20, 15, 49, 4, tzinfo=tzoffset(None, -25200))}]
