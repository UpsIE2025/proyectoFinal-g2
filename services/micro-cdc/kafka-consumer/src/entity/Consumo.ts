// Consumo.ts
import { Entity, PrimaryGeneratedColumn, Column } from "typeorm";

@Entity("consumos")
export class Consumo {
    @PrimaryGeneratedColumn("uuid")
    id!: string;

    @Column({ name: "cuenta_id" })
    cuenta_id!: string;

    @Column()
    descripcion!: string;

    @Column()
    monto!: number;

    @Column({ name: "fecha_consumo" })
    fecha_consumo!: Date;

    @Column()
    estado!: string;
}