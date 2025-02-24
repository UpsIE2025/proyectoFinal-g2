// Consumo.ts
import { Entity, PrimaryGeneratedColumn, Column } from "typeorm";

@Entity()
export class Consumo {
    @PrimaryGeneratedColumn("uuid")
    id!: string;

    @Column({ name: "cuenta_id" })
    cuentaId!: string;

    @Column()
    descripcion!: string;

    @Column()
    monto!: number;

    @Column({ name: "fecha_consumo" })
    fechaConsumo!: Date;

    @Column()
    estado!: string;
}