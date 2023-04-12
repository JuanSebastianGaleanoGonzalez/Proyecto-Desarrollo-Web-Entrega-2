import { FormControl } from "@angular/forms";

export interface TransmilenioEditForm {
    placa: FormControl<number | null>;
    modelo: FormControl<number | null>;
}