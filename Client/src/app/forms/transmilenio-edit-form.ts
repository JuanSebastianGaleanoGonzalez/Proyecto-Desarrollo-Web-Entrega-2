import { FormControl } from "@angular/forms";

export interface ConductorEditForm {
    placa: FormControl<number | null>;
    modelo: FormControl<number | null>;
}