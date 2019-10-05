import { Ingrediente } from './ingrediente';

export class Plato {
    id: number;
    nombre: string;
    descripcion: string;
    imagen: string;
    ingredientes: Ingrediente[];
}