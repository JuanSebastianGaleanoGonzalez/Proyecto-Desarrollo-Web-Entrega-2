export class Conductor {
    /*constructor(
        public nombre: string, public cedula: number, public telefono: number,  public direccion: string
    ){}*/
    public cedula?: number | null;
    public nombre?: string | null;
    public direccion?: string | null;
    public telefono?: number | null;

    constructor(nombre?: string | null,  cedula?: number | null, telefono?: number | null, direccion?: string | null){
        this.nombre = nombre,
        this.cedula = cedula,
        this.telefono = telefono,
        this.direccion = direccion
    }
}
