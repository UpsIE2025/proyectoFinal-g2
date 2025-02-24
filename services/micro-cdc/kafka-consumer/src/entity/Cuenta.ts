import { Entity, PrimaryGeneratedColumn, Column } from "typeorm";

@Entity("cuentas")
export class Cuenta {
    @PrimaryGeneratedColumn("uuid")
    id!: string;

    @Column({ name: "usuario_id" })
    usuarioId!: string;

    @Column()
    saldo!: number;

    @Column()
    estado!: string;

    @Column({ name: "fecha_creacion" })
    fechaCreacion!: Date;
}