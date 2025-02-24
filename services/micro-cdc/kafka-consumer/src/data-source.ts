import { DataSource } from "typeorm";
import { Cuenta } from "./entity/Cuenta";
import { Consumo } from "./entity/Consumo";

export const AppDataSource = new DataSource({
    type: "mariadb",
    host: 'mariadb',
    port: 3306,
    username: 'user',
    password: 'password',
    database: 'cdc_db',
    synchronize: true,
    logging: true,
    entities: [Cuenta, Consumo],
    subscribers: [],
    migrations: [],
});