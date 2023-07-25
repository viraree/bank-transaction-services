CREATE DATABASE bank_nosql;

USE bank_nosql;
CREATE TABLE transactions (
 id INT AUTO_INCREMENT PRIMARY KEY,
 doc LONGTEXT NOT NULL
);

use bank_nosql;
INSERT INTO transactions (doc)
VALUES ('[]');
INSERT INTO transactions (doc)
VALUES ('[{}]');

INSERT INTO transactions (doc)
VALUES ("[{'currency_amount': 'CHF 0',
 'description': 'TEST TEST TEST',
 'eur_amount': 0,
 'id': 1111111111,
 'month_num': 1,
 'user_uid': 'P-0123456789' }]");

INSERT INTO transactions (doc)
VALUES ("[{'currency_amount': 'CHF 75',
 'description': 'Online payment CHF',
 'eur_amount': 77.78,
 'id': 0,
 'month_num': 10,
 'user_uid': 'P-0123456789' }]");

INSERT INTO transactions (doc)
VALUES ("[{'currency_amount': 'CHF 75',
 'description': 'Online payment CHF',
 'eur_amount': 77.78,
 'id': 0,
 'month_num': 7,
 'user_uid': 'P-0123456789' }]");

INSERT INTO transactions (doc)
VALUES ("[{'currency_amount': 'CHF 75',
 'description': 'Online payment CHF',
 'eur_amount': 77.78,
 'id': 0,
 'month_num': 11,
 'user_uid': 'P-0123456789' }]");
#######################################
use bank_nosql;
DELETE FROM transactions
WHERE id=3;
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

 #########
