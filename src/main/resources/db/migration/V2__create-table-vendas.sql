
CREATE TABLE vendas (
  id TEXT PRIMARY KEY UNIQUE NOT NULL,
  id_cliente INT NOT NULL,
  name TEXT NOT NULL,
  data date
);