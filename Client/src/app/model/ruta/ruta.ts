import { Estacion } from "../estacion/estacion";

export class Ruta {
    public id?: number | null;
    public codigo?: number | null;
    public nombre?: string | null;
    public estaciones?: Estacion[];
    
    constructor(codigo?: number | null, estaciones?: Estacion[]){
        this.codigo = codigo,
        this.estaciones = estaciones
    }
}