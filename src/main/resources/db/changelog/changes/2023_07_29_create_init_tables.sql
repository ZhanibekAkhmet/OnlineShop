CREATE TABLE t_permission (
    id SERIAL PRIMARY KEY,
   role VARCHAR(255) NOT NULL
);
CREATE TABLE t_user (
    id SERIAL PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    full_name VARCHAR(255),
    phone VARCHAR(20)
);
CREATE TABLE t_user_permissions (
  user_id BIGINT REFERENCES t_user(id),
  permissions_id BIGINT REFERENCES t_permission(id),
  PRIMARY KEY (user_id, permissions_id)
);
-- Создание таблицы Categories
CREATE TABLE categories (
                            id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                            name VARCHAR(255) NOT NULL
);

-- Создание таблицы Model
CREATE TABLE Model (
                       id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                       name VARCHAR(255)
);

-- Создание таблицы Item
CREATE TABLE Item (
                      id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                      name VARCHAR(255),
                      description VARCHAR(10000),
                      price NUMERIC(10, 2),
                      categories_id BIGINT REFERENCES categories(id),
                      model_id BIGINT REFERENCES Model(id),
                      image VARCHAR(255),
                      weight DOUBLE PRECISION,
                      color VARCHAR(255)
);
CREATE TABLE Processor (
                           id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                           model VARCHAR(255) NOT NULL
);

-- Создание таблицы VideoCard
CREATE TABLE Video_Card (
                           id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                           model VARCHAR(255) NOT NULL
);

-- Создание таблицы Memory
CREATE TABLE Memory (
                        id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                        memory INT NOT NULL
);

-- Создание таблицы Ozu
CREATE TABLE Ozu (
                     id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                     ozu INT NOT NULL
);

-- Создание таблицы Diagonal
CREATE TABLE Diagonal (
                          id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                          diagonal DOUBLE PRECISION NOT NULL
);

-- Создание таблицы PhoneProcessor
CREATE TABLE Phone_Processor (
                                id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                                name VARCHAR(255) NOT NULL
);

-- Создание таблицы Laptop
CREATE TABLE Laptop (
                        id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                        item_id BIGINT REFERENCES Item(id) ON DELETE CASCADE,
                        processor_id BIGINT REFERENCES Processor(id),
                        video_Card_id BIGINT REFERENCES Video_Card(id),
                        memory_id BIGINT REFERENCES Memory(id),
                        ozu_id BIGINT REFERENCES Ozu(id),
                        diagonal_id BIGINT REFERENCES Diagonal(id)
);

-- Создание таблицы Phone
CREATE TABLE Phone (
                       id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                       item_id BIGINT REFERENCES Item(id) ON DELETE CASCADE,
                       memory_id BIGINT REFERENCES Memory(id),
                       ozu_id BIGINT REFERENCES Ozu(id),
                       phone_processor_id BIGINT REFERENCES Phone_Processor(id),
                       diagonal_id BIGINT REFERENCES Diagonal(id),
                       photo INT,
                       front_photo INT,
                       sim INT,
                       OS VARCHAR(255)
);
-- Создание таблицы Comment
CREATE TABLE Comment (
                         id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                         text TEXT,
                         userN VARCHAR(255),
                         item_id BIGINT REFERENCES Item(id) ON DELETE CASCADE,
                         time TIMESTAMP
);

-- Создание таблицы Order
CREATE TABLE orders (
                        id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                        total NUMERIC(10, 2),
                        created_date TIMESTAMP,
                        user_id BIGINT REFERENCES t_user(id) ON DELETE CASCADE,
                        status INT
);

-- Создание таблицы OrderItem
CREATE TABLE Order_Item (
                           id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                           item_id BIGINT REFERENCES Item(id) ON DELETE CASCADE,
                           quantity INT
);

-- Создание таблицы для связи "многие-ко-многим" между Order и OrderItem
CREATE TABLE orders_order_items (
                                    order_id BIGINT REFERENCES orders(id) ON DELETE CASCADE,
                                    order_items_id BIGINT REFERENCES Order_Item(id) ON DELETE CASCADE,
                                    PRIMARY KEY (order_id, order_items_id)
);