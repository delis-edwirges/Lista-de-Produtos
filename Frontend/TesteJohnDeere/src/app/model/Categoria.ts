import { Produto } from "./Produto"

export class Categoria{

    public id: number
    public categoria: string
    public sobre: string
    public produto: Produto[]
}