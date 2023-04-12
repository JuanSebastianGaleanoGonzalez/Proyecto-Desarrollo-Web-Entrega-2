import { Ruta } from "../ruta/ruta";

export class Transmilenio {
    public id?: number | null;
    public placa?: number | null;
    public modelo?: number | null;
    public rutas?: Ruta[];

    constructor(placa?: number | null, modelo?: number | null, rutas?: Ruta[]){
        this.placa = placa,
        this.modelo = modelo,
        this.rutas = rutas
    }
}