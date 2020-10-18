
CREATE TABLE

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    user_name VARCHAR(500) UNIQUE NOT NULL,
    password_digest VARCHAR(500) NOT NULL
);

CREATE TABLE property_Profiles (
  id SERIAL PRIMARY KEY,
  create_at TIMESTAMP,
  time_zone TIMESTAMPTZ,
  user_id INTEGER NOT NULL,
  property_image_link VARCHAR(5000),
  address VARCHAR(5000),
  State VARCHAR(1000),
  suburb VARCHAR(1000),
  price BIGINT,
  property_type VARCHAR(500),
  Num_of_bathroom INT,
  Num_of_Parking_Spaces INT,
  owner_contact BIGINT,
  owner_name VARCHAR(1000),
  transaction_type VARCHAR(1000),
  CONSTRAINT chk_property_type CHECK (property_type IN ('house', 'apartment', 'studio', 'terrace', 'others')),
  CONSTRAINT chk_transaction_type CHECK (transaction_type IN ('sale', 'rent', 'buy')),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE advertisement_profile (
  id SERIAL PRIMARY KEY,
  create_at TIMESTAMP,
  advertisement_start_date TIMESTAMP,
  advertisement_finish_date TIMESTAMP,
  time_zone TIMESTAMPTZ,
  user_id INTEGER NOT NULL,
  property_Profiles_id INTEGER NOT NULL,
  FOREIGN KEY (property_Profiles_id) REFERENCES property_Profiles (id) ON DELETE CASCADE,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

// dummy data
INSERT INTO user_property_infor ()

INSERT INTO property_Profiles (create_at, user_id, property_image_link,
address, State, suburb, price, property_type, Num_of_bathroom, Num_of_Parking_Spaces,
owner_contact, owner_name, transaction_type) VALUES (
CURRENT_TIMESTAMP,
999992,
'https://www.google.com/url?sa=i&url=https%3A%2F%2Funsplash.com%2Fs%2Fphotos%2Fproperty&psig=AOvVaw28yD0rJgFyJqTvEoQ6jcMn&ust=1602824721554000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCNC5ssPptewCFQAAAAAdAAAAABAD',
'999 king st, nsw 2099, australia',
'NSW',
'missipi',
100000323,
'house',
9,
9,
43990129232,
'testCovidVictim',
'sale'
);

?,?,?,?,?,?,?,?,?,?,?,?,?)";

house,
    apartment,
    studio,
    terrace,
    others
//Single quote ***
INSERT INTO address(personid, city, state) Values (4, CURRENT_DATE, 'new');
INSERT INTO users(id, user_name, password_digest) VALUES (999992, 'dummy6', 'dumPassword');
