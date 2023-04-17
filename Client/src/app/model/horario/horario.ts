export class Horario {
    public id?: number | null;
    public horaInicio?: number | null;
    public horaFinal?: number | null;
    public diaSemana?: string | null;

    constructor(horaInicio: number | null, horaFinal: number | null, dia: string | null){
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.diaSemana = dia;
    }
}
