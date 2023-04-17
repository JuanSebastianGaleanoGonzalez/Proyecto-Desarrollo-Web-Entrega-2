import { Ruta } from "../ruta/ruta";

export class Transmilenio {
    public id?: number | null;
    public placa?: number | null;
    public modelo?: number | null;
    public dia?: String | null;
    public rutas?: Ruta[];

    constructor(placa?: number | null, modelo?: number | null, dia?: String | null, rutas?: Ruta[]){
        this.placa = placa,
        this.modelo = modelo,
        this.rutas = rutas
        this.dia = dia;
    }
}