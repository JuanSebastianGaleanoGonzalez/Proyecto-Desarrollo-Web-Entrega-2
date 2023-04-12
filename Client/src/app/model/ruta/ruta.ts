import { Estacion } from "../estacion/estacion";

export class Ruta {
    public codigo?: number | null;
    public estaciones?: Estacion[];
    constructor(codigo?: number | null, estaciones?: Estacion[]){
        this.codigo = codigo,
        this.estaciones = estaciones
    }
}