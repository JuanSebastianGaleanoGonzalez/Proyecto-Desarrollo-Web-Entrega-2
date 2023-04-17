import { Estacion } from "../estacion/estacion";
import { Horario } from "../horario/horario";

export class Ruta {
    public id?: number | null;
    public codigo?: number | null;
    public nombre?: string | null;
    public estaciones?: Estacion[];
    public horarios?: Horario[];
    
    constructor(codigo?: number | null, estaciones?: Estacion[]){
        this.codigo = codigo,
        this.estaciones = estaciones
    }
}