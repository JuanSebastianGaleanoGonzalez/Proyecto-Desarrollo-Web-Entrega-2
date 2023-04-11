export class Transmilenio {
    public placa?: number | null;
    public modelo?: number | null;

    constructor(placa?: number | null, modelo?: number | null){
        this.placa = placa,
        this.modelo = modelo
    }
}