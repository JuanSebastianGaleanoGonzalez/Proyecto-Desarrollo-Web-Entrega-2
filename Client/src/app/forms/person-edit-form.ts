import { FormControl } from "@angular/forms";

export interface ConductorEditForm {
    nombre: FormControl<string | null>;
    cedula: FormControl<number | null>;
    telefono: FormControl<number | null>;
    direccion: FormControl<string | null>;
}
